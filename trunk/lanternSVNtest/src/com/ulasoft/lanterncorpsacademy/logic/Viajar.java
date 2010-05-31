package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;

import dao.api.DataObject;
import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import echopoint.model.CircleSection;
import echopoint.model.MapSection;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

import lcaInterfaceDAO.IClaseLinternaDAO;
import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IHabilidadActivaDAO;
import lcaInterfaceDAO.IHabilidadDAO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDAO;
import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IUsuarioDAO;




public class Viajar {
	
	protected static final int VERDE = 1;
	protected static final int AMARILLO = 2;
	protected static final int ROJO = 3;
	protected static final int NEGRO = 4;
	protected static final int AZUL = 5;
	protected static final int INDIGO = 6;
	protected static final int VIOLETA = 7;

	public static List<MapSection> cargarPlanetas() throws Exception {
		
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IPlanetaDAO planetDAO = (IPlanetaDAO) GlobalDAOFactory.getDAO(IPlanetaDAO.class, connectionBean);

		LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
		Atributos atts = app.getAtributos();
				
		List<DataObject> planetasDOList = planetDAO.listAll();
		
		ConnectionFactory.closeConnection(connectionBean.getConnection());
		
		List<MapSection> planetas = new ArrayList<MapSection>();
		
		IPlanetaDO planeta = (IPlanetaDO) GlobalDOFactory
		.getDO(IPlanetaDO.class);


	for (int i = 0; i < (planetasDOList.size()); i++) {

		planeta = (IPlanetaDO) planetasDOList.get(i);

		CircleSection pl = new CircleSection((int) planeta
			.getCoordenadaEnX(), (int) planeta.getCoordenadaEnY(),
			15, planeta.getNombre());

			if (i < 7) {
				
				switch (planeta.getId()) {
				case VERDE: 
					pl.setAltText(planeta.getNombre() + " - Sector: "
							+ planeta.getSector() + " - "
							+ "Base de los Green Lantern Corps");
					break;
				
				case AMARILLO:
					pl.setAltText(planeta.getNombre() + " - Sector: "
							+ planeta.getSector() + " - "
							+ "Base de los Sinestro Corps");
					break;
				case ROJO: 
					pl.setAltText(planeta.getNombre() + " - Sector: "
							+ planeta.getSector() + " - "
							+ "Base de los Red Lantern Corps");
					break;
				
				case NEGRO: 
					pl.setAltText(planeta.getNombre() + " - Sector: "
							+ planeta.getSector() + " - "
							+ "Base de los Black Lantern Corps");
					break;
				
				case AZUL: 
					pl.setAltText(planeta.getNombre() + " - Sector: "
							+ planeta.getSector() + " - "
							+ "Base de los Blue Lantern Corps");
					break;
				
				case INDIGO: 
					pl.setAltText(planeta.getNombre() + " - Sector: "
							+ planeta.getSector() + " - "
							+ "Base de la Tribu Indigo");
					break;
				
				case VIOLETA: 
					pl.setAltText(planeta.getNombre() + " - Sector: "
							+ planeta.getSector() + " - "
							+ "Base de las Star Sapphires");
					break;
				
			  }
			}

		else {
				pl.setAltText(planeta.getNombre() + " - Sector: "
			+ planeta.getSector() + "."); 
			}
		if (atts.getPersonaje().getPlanetaRef().getRefIdent() != planeta.getId()) {
			System.err.println("PLANETA ID:"+planeta.getId());
			planetas.add(pl);
			}
 }
 
 return planetas;

}

	public static void viajarA(String planeta) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IPlanetaDAO planetDAO = (IPlanetaDAO) GlobalDAOFactory.getDAO(IPlanetaDAO.class, connectionBean);

		LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
		Atributos atts = app.getAtributos();
				
		
		
		
		ConnectionFactory.closeConnection(connectionBean.getConnection());	
		
	}

	
	
	
	
	
}
