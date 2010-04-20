package dao.test;

import dao.api.FactoryDAO;
import dao.api.InterfaceDAO;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.lca.ClaseLinternaDAO;
import dao.lca.GrupoDAO;
import dao.lca.HabilidadDAO;
import dao.lca.MisionClaseLinternaDAO;
import dao.lca.MisionDAO;
import dao.lca.MisionPersonajeDAO;
import dao.lca.MisionPersonajeDO;
import dao.lca.NpcDAO;
import dao.lca.ObjetivoDAO;
import dao.lca.OrdenDAO;
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
		InterfaceDAO cDAO = FactoryDAO.getDAO(ClaseLinternaDAO.class, conn);
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

		//PersonajeDO personajeDO = uDAO.Login(usuarioDO);
		usuarioDO = (UsuarioDO) uDAO.loadById(2);
		uDAO.loadPersonajeRef(usuarioDO);
		
		System.out.print(usuarioDO.getPersonajeRef().getRefValue().getAlias()+" "+usuarioDO.getPersonajeRef().getRefValue().getEnergiaDelAnillo());
		
		PersonajeDO personajeDO = usuarioDO.getPersonajeRef().getRefValue();
		pDAO.loadMisionPersonajeList(personajeDO);
		//for(MisionPersonajeDO mision:personajeDO.getMisionPersonajeList().iterator())
		
		
		
	}

}