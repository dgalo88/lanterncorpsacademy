package com.ulasoft.lanterncorpsacademy.logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.lantern.PersonajeDAO;
import factory.GlobalDAOFactory;

import lcaInterfaceDAO.IGrupoDAO;
import lcaInterfaceDAO.IGrupoDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;

public class InvitarUsuariosGrupo {

	public static void agregarUsuarios(IPersonajeDO personaje,
			List<IPersonajeDO> personajes, List<Integer> seleccion) throws Exception {
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		List<IPersonajeDO> listPersonaje = new ArrayList<IPersonajeDO>();
		for(int pos=0;pos<seleccion.size();pos++){
			listPersonaje.add(personajes.get(seleccion.get(pos).intValue()));
		}
		IPersonajeDAO personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO( //
				IPersonajeDAO.class, connectionBean);
		IGrupoDO grupodo;
		IGrupoDAO grupoDAO = (IGrupoDAO) GlobalDAOFactory.getDAO( //
				IGrupoDAO.class, connectionBean);
		grupodo = (IGrupoDO)grupoDAO.loadById(personaje
				.getGrupoRef().getRefIdent());
		Reference<IGrupoDO> grupoRef = new Reference<IGrupoDO>();
		grupoRef.setRefIdent(grupodo.getId());
		for(int pos=0;pos<listPersonaje.size();pos++){
			personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO( //
					IPersonajeDAO.class, connectionBean);
			listPersonaje.get(pos).setGrupoRef(grupoRef);
			personajeDAO.update(listPersonaje.get(pos));
			
		}
		connectionBean.getConnection().close();
	}

	public static List<IPersonajeDO> obtenerPersonasClase(IPersonajeDO personaje) throws Exception {
		List<IPersonajeDO> h;
		List<IPersonajeDO> h1;
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IPersonajeDAO person = (IPersonajeDAO) GlobalDAOFactory.getDAO( //
				IPersonajeDAO.class, connectionBean);
		h = person.listByClaseLinternaId(personaje.getClaseLinternaRef()
				.getRefIdent());
		h1 = ((PersonajeDAO) person).listByGrupoId((personaje
				.getGrupoRef().getRefIdent()));
		for(int pos=0;pos<h.size();pos++){
			for(int pos1=0;pos1<h1.size();pos1++){
				if(h.get(pos).getId()==h1.get(pos1).getId()){
					h.remove(pos);
				}
			}
		}
		connectionBean.getConnection().close();
		return h;
	}

}
