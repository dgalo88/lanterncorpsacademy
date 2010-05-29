package com.ulasoft.lanterncorpsacademy.logic;

import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;

import com.ulasoft.lanterncorpsacademy.menus.Menud;

import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class Atributos {

	public static void updateMenud(Menud menud, IPersonajeDO personaje) throws Exception {
		
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
		
	}

}
