package com.ulasoft.lanterncorpsacademy.logic;

import java.util.List;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;

public class Atacar {
	
	public static List<IPersonajeDO> obtenerContrincantes(IPersonajeDO person) throws Exception{
		List<IPersonajeDO> personajes;
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IPersonajeDAO personaje = (IPersonajeDAO) GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);;
		personajes = personaje.listContrincantes(person.getId(), (person.getClaseLinternaRef()).getRefIdent(), (person.getPlanetaRef()).getRefIdent());
		connectionBean.getConnection().close();
		return personajes;
	}
	
	public static TestTableModel asignarRanking(TestTableModel tableDtaModel, List<IPersonajeDO> personajes){
		
		for(int posicion=0;posicion<personajes.size();posicion++){
			tableDtaModel.add(personajes.get(posicion)); 
			
		}
		return tableDtaModel;
	}
	
	public static String determinarClase(int clase){
		switch (clase){
		case 1:
			return "Green Lantern Corps";
		case 2:
			return "Siniestro Corps";
		case 3:
			return "Red Lantern Corps";
		case 4:
			return "Black Lantern Corps";
		case 5:
			return "Blue Lantern Corps";
		case 6:
			return "Tribu Indigo";
		case 7:
			return "Star Saphirre";
		default:
			break;
		}
		return "";
	}
}
