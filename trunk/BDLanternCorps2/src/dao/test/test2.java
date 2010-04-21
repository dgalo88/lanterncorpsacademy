package dao.test;

import java.util.Iterator;
import java.util.List;

import dao.api.DataObject;
import dao.api.FactoryDAO;
import dao.api.InterfaceDAO;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.lca.ClaseLinternaDAO;
import dao.lca.GrupoDAO;
import dao.lca.HabilidadDAO;
import dao.lca.MisionClaseLinternaDAO;
import dao.lca.MisionDAO;
import dao.lca.MisionDO;
import dao.lca.MisionPersonajeDAO;
import dao.lca.MisionPersonajeDO;
import dao.lca.NpcDAO;
import dao.lca.ObjetivoDAO;
import dao.lca.ObjetivoDO;
import dao.lca.OrdenDAO;
import dao.lca.OrdenDO;
import dao.lca.PersonajeDAO;
import dao.lca.PersonajeDO;
import dao.lca.PlanetaDAO;
import dao.lca.UsuarioDAO;
import dao.lca.UsuarioDO;

public class test2 {

	public static void main(String[] args) throws Exception {

		// Obtener Conexion
		ConnectionBean conn = ConnectionFactory.getConnectionBean();

		// Instanciar DAO
		UsuarioDAO uDAO = (UsuarioDAO) FactoryDAO.getDAO(UsuarioDAO.class, conn);
		PersonajeDAO pDAO = (PersonajeDAO) FactoryDAO.getDAO(PersonajeDAO.class, conn);
		InterfaceDAO pmDAO = FactoryDAO.getDAO(MisionPersonajeDAO.class, conn);
		ClaseLinternaDAO cDAO = (ClaseLinternaDAO) FactoryDAO.getDAO(ClaseLinternaDAO.class, conn);
		InterfaceDAO plDAO = FactoryDAO.getDAO(PlanetaDAO.class, conn);
		InterfaceDAO gDAO = FactoryDAO.getDAO(GrupoDAO.class, conn);
		InterfaceDAO mDAO = FactoryDAO.getDAO(MisionDAO.class, conn);
		InterfaceDAO oDAO = FactoryDAO.getDAO(OrdenDAO.class, conn);
		InterfaceDAO obDAO = FactoryDAO.getDAO(ObjetivoDAO.class, conn);
		InterfaceDAO npcDAO = FactoryDAO.getDAO(NpcDAO.class, conn);
		InterfaceDAO mcDAO = FactoryDAO.getDAO(MisionClaseLinternaDAO.class,
				conn);
		InterfaceDAO hDAO = FactoryDAO.getDAO(HabilidadDAO.class, conn);
		
		UsuarioDO usuarioDO=new UsuarioDO();
		usuarioDO.setClave("ROJOROJO");
		usuarioDO.setCorreo("ROJO@ROJO");

		usuarioDO = (UsuarioDO) uDAO.loadById(2);
		uDAO.loadPersonajeRef(usuarioDO);
		
		System.out.println(usuarioDO.getPersonajeRef().getRefValue().getAlias()+" "+usuarioDO.getPersonajeRef().getRefValue().getEnergiaDelAnillo());
		
		PersonajeDO personajeDO = usuarioDO.getPersonajeRef().getRefValue();
		pDAO.loadMisionPersonajeList(personajeDO);
		List<MisionPersonajeDO> misionPersonajeList = personajeDO.getMisionPersonajeList();
		Iterator<MisionPersonajeDO> mIterator=misionPersonajeList.iterator();
		MisionDO misionDO;
		while(mIterator.hasNext()){
			misionDO= (MisionDO) mDAO.loadById(mIterator.next().getMisionRef().getRefIdent());
			System.out.println(misionDO.getNombre());
		}
		misionDO=(MisionDO) mDAO.loadById(2);
		((MisionDAO) mDAO).loadMisionPersonajeList(misionDO);
		mIterator=misionDO.getMisionPersonajeList().iterator();
		while(mIterator.hasNext()){
			System.out.println(mIterator.next().getPersonajeRef().getRefIdent());
		}
		personajeDO=(PersonajeDO) pDAO.loadById(3);
		pDAO.loadClaseLinternaRef(personajeDO);
		//cDAO.l(personajeDO.getClaseLinternaRef().getRefValue())
		pDAO.loadMisionPersonajeList(personajeDO);
		mIterator=personajeDO.getMisionPersonajeList().iterator();
		while(mIterator.hasNext()){
			misionDO= (MisionDO) mDAO.loadById(mIterator.next().getMisionRef().getRefIdent());
			System.out.println(misionDO.getNombre());
		}
			
		((MisionDAO) mDAO).loadOrdenList(misionDO);
		Iterator<OrdenDO> oIterator=misionDO.getOrdenList().iterator();
		ObjetivoDO objetivoDO=new ObjetivoDO();
		while(oIterator.hasNext()){
			objetivoDO=(ObjetivoDO) obDAO.loadById(oIterator.next().getObjetivoRef().getRefIdent());
			System.out.println(objetivoDO.getNumeroDeNpc());
		}
		
		((ObjetivoDAO) obDAO).loadPlanetaRef(objetivoDO);
		
		usuarioDO.setCorreo("hola");
		usuarioDO.setClave("chao");
		usuarioDO.setNombre("pepe");
		uDAO.update(usuarioDO);
		Iterator<DataObject> uIterator=uDAO.listAll().iterator();
		while(uIterator.hasNext()){
			System.out.println(((UsuarioDO) uIterator.next()).getNombre());
		}
		
		//uDAO.delete(usuarioDO.);
		usuarioDO= (UsuarioDO) uDAO.loadById(2);
		//for(MisionPersonajeDO mision:personajeDO.getMisionPersonajeList().iterator())
		
		
		
	}

}