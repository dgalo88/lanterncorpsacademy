package com.ulasoft.lanterncorpsacademy.logic;

import java.util.List;

import lcaInterfaceDAO.IGrupoDAO;
import lcaInterfaceDAO.IGrupoDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.lantern.PersonajeDAO;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class MiGrupo {

	public static List<IPersonajeDO> obtenerPersonClase(IPersonajeDO personaje)
			throws Exception {
		List<IPersonajeDO> h;
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IPersonajeDAO person = (IPersonajeDAO) GlobalDAOFactory.getDAO( //
				IPersonajeDAO.class, connectionBean);
		h = ((PersonajeDAO) person).listByGrupoId((personaje
				.getGrupoRef().getRefIdent()));
		connectionBean.getConnection().close();
		return h;
	}

	public static TestTableModel asignarPersonaje(TestTableModel tableDtaModel,
			List<IPersonajeDO> personajes) {
		for (int posicion = 0; posicion < personajes.size(); posicion++) {
			(personajes.get(posicion)).setId(posicion + 1);
			tableDtaModel.add(personajes.get(posicion));

		}
		return tableDtaModel;
	}

	public static int abandonarGrupo(IPersonajeDO personaje) throws Exception {
		List<IPersonajeDO> h;
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IPersonajeDAO person = (IPersonajeDAO) GlobalDAOFactory.getDAO( //
				IPersonajeDAO.class, connectionBean);
		IGrupoDO grupodo;
		IGrupoDAO grupoDAO = (IGrupoDAO) GlobalDAOFactory.getDAO( //
				IGrupoDAO.class, connectionBean);
		grupodo = (IGrupoDO)grupoDAO.loadById(personaje
				.getGrupoRef().getRefIdent());
		h = obtenerPersonClase(personaje);
		Reference<IGrupoDO> grupoRef = new Reference<IGrupoDO>();
		grupoRef.setRefIdent(0);
		personaje.setGrupoRef(grupoRef);
		person.update(personaje);
		connectionBean.getConnection().close();
		if(h.size()==1){
			grupoDAO.delete(grupodo);
			return 0;
		}
		if(h.size()==2){
			grupodo.setEstado(false);
			grupoDAO.update(grupodo);
			return 1;
		}
		return 2;
	}

}
