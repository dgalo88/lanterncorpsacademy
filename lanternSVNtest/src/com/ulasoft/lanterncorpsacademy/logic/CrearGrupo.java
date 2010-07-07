package com.ulasoft.lanterncorpsacademy.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nextapp.echo.app.TextField;

import lcaInterfaceDAO.IGrupoDAO;
import lcaInterfaceDAO.IGrupoDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class CrearGrupo {

	public static String obtenerNombreGrupo(IPersonajeDO personaje)
			throws Exception {
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IGrupoDAO grupoDAO = (IGrupoDAO) GlobalDAOFactory.getDAO( //
				IGrupoDAO.class, connectionBean);
		IGrupoDO grupodo;
		if(personaje.getGrupoRef().getRefIdent()!=0){
			grupodo = (IGrupoDO) grupoDAO.loadById(personaje.getGrupoRef()
					.getRefIdent());
			if (grupodo == null) {
				return "";
			}
		}
		else{
			return "";
		}
		connectionBean.getConnection().close();
		return grupodo.getNombre();
	}

	public static List<IPersonajeDO> obtenerPersonasClase(IPersonajeDO personaje)
			throws Exception {
		List<IPersonajeDO> h;
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IPersonajeDAO person = (IPersonajeDAO) GlobalDAOFactory.getDAO( //
				IPersonajeDAO.class, connectionBean);
		h = person.listByClaseLinternaId(personaje.getClaseLinternaRef()
				.getRefIdent());
		connectionBean.getConnection().close();
		return h;
	}

	public static TestTableModel asignarPersonaje(TestTableModel tableDtaModel,
			List<IPersonajeDO> personajes, IPersonajeDO personaje) {
		for (int posicion = 0; posicion < personajes.size(); posicion++) {
			if((personajes.get(posicion).getId() == personaje.getId())){
				continue;
			}
//			(personajes.get(posicion)).setId(posicion + 1);
			tableDtaModel.add(personajes.get(posicion));
		}
		return tableDtaModel;
	}
	
	public static void crearGrupo(IPersonajeDO personaje, List<IPersonajeDO> personajes, List<Integer> seleccion, TextField txtGrupo) throws Exception{
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IGrupoDAO grupoDAO = (IGrupoDAO) GlobalDAOFactory.getDAO( //
				IGrupoDAO.class, connectionBean);
		IPersonajeDAO personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO( //
				IPersonajeDAO.class, connectionBean);
		IGrupoDO grupodo = (IGrupoDO) GlobalDOFactory.getDO( //
				IGrupoDO.class);
		List<IPersonajeDO> listPersonaje = new ArrayList<IPersonajeDO>();
		grupodo.setNombre(txtGrupo.getText());
		grupodo.setEstado(true);
		listPersonaje.add(personaje);
		for(int pos=0;pos<seleccion.size();pos++){
			listPersonaje.add(personajes.get(seleccion.get(pos).intValue()));
		}
		grupodo.setPersonajeList(listPersonaje);
		grupodo.setClaseLinternaRef(personaje.getClaseLinternaRef());
		grupoDAO.insert(grupodo);
		Reference<IGrupoDO> grupoRef = new Reference<IGrupoDO>();
		grupoRef.setRefIdent(grupodo.getId());
		for(int pos=0;pos<listPersonaje.size();pos++){
			listPersonaje.get(pos).setGrupoRef(grupoRef);
			personajeDAO.update(listPersonaje.get(pos));
			personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO( //
					IPersonajeDAO.class, connectionBean);
		}
		connectionBean.getConnection().close();
	}
	
	public static boolean checkNombreGrupo(TextField txtGrupo){
		if (txtGrupo.getText().equals("")){
			return true;
		}
		return false;
	}

}
