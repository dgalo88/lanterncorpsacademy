package com.ulasoft.lanterncorpsacademy.logic;

import java.sql.SQLException;
import java.util.List;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.lantern.PersonajeDAO;
import factory.GlobalDAOFactory;

import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;

public class MiGrupo {

	public static List<IPersonajeDO> obtenerPersonClase(IPersonajeDO personaje) throws Exception {
		List<IPersonajeDO> h;
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IPersonajeDAO person = (IPersonajeDAO) GlobalDAOFactory.getDAO( //
				IPersonajeDAO.class, connectionBean);
		h = ((PersonajeDAO) person).listByGrupoId((personaje.getClaseLinternaRef().getRefIdent()));
		return h;
	}

	public static TestTableModel asignarPersonaje(TestTableModel tableDtaModel,
			List<IPersonajeDO> personajes) {
		for(int posicion=0;posicion<personajes.size();posicion++){
			tableDtaModel.add(personajes.get(posicion)); 
			
		}
		return tableDtaModel;
	}

}
