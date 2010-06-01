package com.ulasoft.lanterncorpsacademy.logic;

import java.sql.SQLException;
import java.util.List;

import lcaInterfaceDAO.IGrupoDAO;
import lcaInterfaceDAO.IGrupoDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUsuarioDAO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;

public class CrearGrupo {

	public static String obtenerNombreGrupo(IPersonajeDO personaje) throws Exception {
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IGrupoDAO grupoDAO = (IGrupoDAO) GlobalDAOFactory.getDAO( //
				IGrupoDAO.class, connectionBean);
		IGrupoDO grupodo;
		grupodo = (IGrupoDO) grupoDAO.loadById(personaje.getGrupoRef().getRefIdent());
		if(grupodo==null){
			return "";
		}
		connectionBean.getConnection().close();
		return grupodo.getNombre();
	}

	public static List<IPersonajeDO> obtenerPersonasClase(IPersonajeDO personaje) throws Exception {
		List<IPersonajeDO> h;
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IPersonajeDAO person = (IPersonajeDAO) GlobalDAOFactory.getDAO( //
				IPersonajeDAO.class, connectionBean);
		h = person.listByClaseLinternaId(personaje.getClaseLinternaRef().getRefIdent());
		return h;
	}

	public static TestTableModel asignarPersonaje(TestTableModel tableDtaModel,
			List<IPersonajeDO> personajes) {
		for(int posicion=0;posicion<personajes.size();posicion++){
			(personajes.get(posicion)).setId(posicion+1);
			tableDtaModel.add(personajes.get(posicion)); 
			
		}
		return tableDtaModel;
	}

}
