package com.ulasoft.lanterncorpsacademy.logic;

import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUsuarioDAO;
import lcaInterfaceDAO.IUsuarioDO;

import com.ulasoft.lanterncorpsacademy.menus.Menud;

import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class Atributos {

	public Atributos() {

	}

	private IPersonajeDO personaje;
	private IUsuarioDO usuario;
	
	public void updateAtts () throws Exception {
		ConnectionBean connectionBean=ConnectionFactory.getConnectionBean();
		personaje = (IPersonajeDO) GlobalDOFactory.getDO(IPersonajeDO.class);
		usuario = (IUsuarioDO) GlobalDOFactory.getDO(IUsuarioDO.class);
        
		IPersonajeDAO personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
        IUsuarioDAO usDAO = (IUsuarioDAO) GlobalDAOFactory.getDAO(IUsuarioDAO.class, connectionBean);
        usuario = (IUsuarioDO) usDAO.loadById(usuario.getId());
        personaje= (IPersonajeDO) personajeDAO.loadById(personaje.getId());
		
		System.err.println("PERSONAJE ID en atts:"+personaje.getId());
		
		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}
	
	public void updateMenud(Menud menud) throws Exception {
		
		ConnectionBean connectionBean=ConnectionFactory.getConnectionBean();
		IPersonajeDAO personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		personaje = (IPersonajeDO) GlobalDOFactory.getDO(IPersonajeDO.class);
		
		System.err.println("PERSONAJE ID en atts:"+personaje.getId());
		personaje= (IPersonajeDO) personajeDAO.loadById(personaje.getId());
		menud.getSalud().setCurrValue(personaje.getSalud());
		menud.getEnergia().setCurrValue(personaje.getEnergiaDelAnillo());
		menud.getExperiencia().setCurrValue(personaje.getExperiencia());
		menud.getLblTrainsValue().setText(Integer.toString(personaje.getPuntosDeEntrenamiento()));
		menud.getLblNiveLabelValue().setText(Integer.toString(personaje.getNivel()));
		
		ConnectionFactory.closeConnection(connectionBean.getConnection());
		
	}

	public IPersonajeDO getPersonaje() {
		return personaje;
	}

	public void setPersonaje(IPersonajeDO personaje) {
		this.personaje = personaje;
	}

	public IUsuarioDO getUsuario() {
		return usuario;
	}

	public void setUsuario(IUsuarioDO usuario) {
		this.usuario = usuario;
	}

}
