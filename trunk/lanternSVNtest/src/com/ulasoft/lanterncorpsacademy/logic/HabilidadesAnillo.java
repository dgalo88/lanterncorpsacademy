package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IHabilidadActivaDAO;
import lcaInterfaceDAO.IHabilidadActivaDO;
import lcaInterfaceDAO.IHabilidadDAO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.api.DataObject;
import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class HabilidadesAnillo {

	public static TestTableModel obtenerHabilidades(IPersonajeDO personaje, //
			TestTableModel tableDtaModel) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IHabilidadDO habilidad;

		IHabilidadDAO habilidadDAO = (IHabilidadDAO) //
				GlobalDAOFactory.getDAO(IHabilidadDAO.class, connectionBean);
		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);

		personajeDAO.loadHabilidadActivaList(personaje);
		List<IHabilidadActivaDO> listaHabilidades = personaje.getHabilidadActivaList();

		for(int pos = 0; pos < listaHabilidades.size(); pos++) {
			habilidad = (IHabilidadDO) habilidadDAO.loadById( //
					(listaHabilidades.get(pos).getHabilidadRef()).getRefIdent());
			tableDtaModel.add(habilidad);
		}

		connectionBean.getConnection().close();
		return tableDtaModel;
	}

	public static int obtenerNivel(int personajeId, IHabilidadDO habilidad) //
	throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IHabilidadActivaDO habilidadActiva;

		IHabilidadActivaDAO habilidadActivaDAO = (IHabilidadActivaDAO) //
				GlobalDAOFactory.getDAO(IHabilidadActivaDAO.class, connectionBean);
		habilidadActiva = (IHabilidadActivaDO) //
				habilidadActivaDAO.loadByHabilidadId(habilidad.getId(), personajeId);

		connectionBean.getConnection().close();

		return habilidadActiva.getNivel_habilidad();
	}

	public static TestTableModel obtenerHabilidadesCompra( //
			IPersonajeDO personaje, TestTableModel tableDtaModel) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);

		personajeDAO.loadHabilidadActivaList(personaje);
		List<IHabilidadActivaDO> listaHabilidades = personaje.getHabilidadActivaList();

		List<DataObject> listhabilidadToBuy;
		IHabilidadDAO habilidadDAO = (IHabilidadDAO) //
				GlobalDAOFactory.getDAO(IHabilidadDAO.class, connectionBean);
		listhabilidadToBuy = habilidadDAO.listToBuy(personaje.getId());

		for(int pos = 0; pos < listhabilidadToBuy.size(); pos++) {
			if (listaHabilidades.get(pos) != listhabilidadToBuy.get(pos)) {
				tableDtaModel.add((IHabilidadDO) listhabilidadToBuy.get(pos));
			}
		}

		return tableDtaModel;
	}

	public static boolean entrenarHabilidades(List<Integer> seleccion, //
			IPersonajeDO personaje) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		int costo = 0;
		List<IHabilidadActivaDO> listHabilidad;

		IHabilidadDAO habilidadDAO = (IHabilidadDAO) //
				GlobalDAOFactory.getDAO(IHabilidadDAO.class, connectionBean);
		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);

		personajeDAO.loadHabilidadActivaList(personaje);
		listHabilidad = personaje.getHabilidadActivaList();

		for(int pos = 0; pos < seleccion.size(); pos++) {
			costo += (Math.pow(2, listHabilidad.get(seleccion.get(pos)).getNivel_habilidad())*100);
		}

		if(costo > personaje.getPuntosDeEntrenamiento()) {
			return true;
		}

		personaje.setPuntosDeEntrenamiento(personaje.getPuntosDeEntrenamiento()-costo);
		personajeDAO.update(personaje);

		for(int pos = 0; pos < seleccion.size(); pos++) {
			listHabilidad.get(seleccion.get(pos)).setNivel_habilidad( //
					listHabilidad.get(seleccion.get(pos)).getNivel_habilidad()+1);
			habilidadDAO.update(listHabilidad.get(seleccion.get(pos)));
		}

		connectionBean.getConnection().close();
		return false;
	}

	public static boolean adquirirHabilidades(List<Integer> seleccion, //
			IPersonajeDO personaje) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		int costo = 0;
		List<DataObject> habilidad;
		List<IHabilidadDO> listHabilidad = new ArrayList<IHabilidadDO>();

		IHabilidadActivaDO habilidadActiva = (IHabilidadActivaDO) //
				GlobalDOFactory.getDO(IHabilidadActivaDO.class);
		IHabilidadDAO habilidadDAO = (IHabilidadDAO) //
				GlobalDAOFactory.getDAO(IHabilidadDAO.class, connectionBean);
		IHabilidadActivaDAO habilidadActivaDAO = (IHabilidadActivaDAO) //
				GlobalDAOFactory.getDAO(IHabilidadActivaDAO.class, connectionBean);

		habilidad = habilidadDAO.listToBuy(personaje.getId());

		for(int pos = 0; pos < habilidad.size(); pos++) {
			listHabilidad.add((IHabilidadDO) habilidad.get(pos));
		}
		for(int pos = 0; pos < seleccion.size(); pos++) {
			costo += listHabilidad.get(seleccion.get(pos)).getCosto_de_aprendizaje();
		}
		if(costo > personaje.getPuntosDeEntrenamiento()) {
			return true;
		}

		Reference<IPersonajeDO> personRef = new Reference<IPersonajeDO>();
		personRef.setRefIdent(personaje.getId());
		Reference<IHabilidadDO> habilidadRef = new Reference<IHabilidadDO>();

		for(int pos = 0; pos < seleccion.size(); pos++) {

			habilidadRef.setRefIdent(listHabilidad.get(seleccion.get(pos)).getId());
			habilidadActiva.setNivel_habilidad(1);
			habilidadActiva.setPersonajeRef(personRef);
			habilidadActiva.setHabilidadRef(habilidadRef);
			habilidadActivaDAO.insert(habilidadActiva);

		}
		return false;

	}

	public static String determinarTipo(int clase) {
		switch (clase) {
		case 1:
			return "Ataque";
		case 2:
			return "Defensa";
		case 3:
			return "Defensa y Ataque";
		case 4:
			return "Neutras";
		default:
			break;
		}
		return "";
	}

}
