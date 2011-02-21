package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IGrupoDAO;
import lcaInterfaceDAO.IGrupoDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;

public class MiGrupo {

	public static List<IPersonajeDO> obtenerPersonClase(IPersonajeDO personaje) //
			throws Exception {

		List<IPersonajeDO> listPersonajes = new ArrayList<IPersonajeDO>();

		if(personaje.getGrupoRef() == null){
			return listPersonajes;
		}

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

//		IPersonajeDAO personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO( //
//				IPersonajeDAO.class, connectionBean);

		IGrupoDAO grupoDAO = (IGrupoDAO) //
				GlobalDAOFactory.getDAO(IGrupoDAO.class, connectionBean);
		IGrupoDO grupoDO = (IGrupoDO) //
				grupoDAO.loadById(personaje.getGrupoRef().getRefIdent());

		listPersonajes = grupoDO.getPersonajeList();

//		listPersonajes = ((PersonajeDAO) personajeDAO).listByGrupoId( //
//				(personaje.getGrupoRef().getRefIdent()));

		connectionBean.getConnection().close();
		return listPersonajes;
	}

	public static TestTableModel asignarPersonaje( //
			TestTableModel tableDtaModel, List<IPersonajeDO> personajes) {

		if (personajes.isEmpty()){
			return tableDtaModel;
		}
		for (int posicion = 0; posicion < personajes.size(); posicion++) {

			(personajes.get(posicion)).setId(posicion + 1);
			tableDtaModel.add(personajes.get(posicion));

		}
		return tableDtaModel;
	}

	public static int abandonarGrupo(IPersonajeDO personaje) throws Exception {

		List<IPersonajeDO> listPersonajes;

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPersonajeDAO personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO( //
				IPersonajeDAO.class, connectionBean);
		IGrupoDAO grupoDAO = (IGrupoDAO) GlobalDAOFactory.getDAO( //
				IGrupoDAO.class, connectionBean);
//		IGrupoDO grupoDO = (IGrupoDO)grupoDAO.loadById( //
//				personaje.getGrupoRef().getRefIdent());

		IGrupoDO grupoDO = (IGrupoDO) //
				grupoDAO.loadById(personaje.getGrupoRef().getRefIdent());

		listPersonajes = obtenerPersonClase(personaje);

		listPersonajes.remove(personaje);
		grupoDO.setPersonajeList(listPersonajes);

		personaje.setGrupoRef(null);

//		Reference<IGrupoDO> grupoRef = new Reference<IGrupoDO>();
//		grupoRef.setRefIdent(0);
//		personaje.setGrupoRef(grupoRef);
		personajeDAO.update(personaje);

		connectionBean.getConnection().close();

		if(listPersonajes.size() == 0) {

			grupoDAO.delete(grupoDO);
			return 0;

		}
		if(listPersonajes.size() == 1) {

			grupoDO.setEstado(false);
			grupoDAO.update(grupoDO);
			return 1;

		}
		return 2;
	}

}
