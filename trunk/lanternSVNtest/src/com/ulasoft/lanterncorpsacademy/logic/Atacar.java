package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IHabilidadDAO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.INivelHabilidadDAO;
import lcaInterfaceDAO.INivelHabilidadDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;

import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.api.DataObject;
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
	
	public static void combate(IPersonajeDO contrincante) throws Exception {
		
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
		
		IHabilidadDAO habilidadDAO = (IHabilidadDAO) GlobalDAOFactory.getDAO(IHabilidadDAO.class, connectionBean);		
		IPersonajeDAO personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);		
		INivelHabilidadDAO nivHabilidadDAO = (INivelHabilidadDAO) GlobalDAOFactory.getDAO(INivelHabilidadDAO.class, connectionBean);
		
		Atributos atts = app.getAtributos();
		IPersonajeDO atacante = atts.getPersonaje();
			
		personajeDAO.loadHabilidadActivaList(atacante);
		personajeDAO.loadHabilidadActivaList(contrincante);
		
		System.err.println(atacante.getHabilidadActivaList().size());
		System.err.println(contrincante.getHabilidadActivaList().size());
				
		List<DataObject> habilidadesAtacante = new ArrayList<DataObject>();
		List<DataObject> habilidadesContrincantes = new ArrayList<DataObject>();
		
		for (int i = 0; i < (atacante.getHabilidadActivaList().size()); i++){			
			habilidadesAtacante.add(habilidadDAO.loadById(atacante.getHabilidadActivaList().get(i).getHabilidadRef().getRefIdent()));
		}
		
		for (int i = 0; i < (contrincante.getHabilidadActivaList().size()); i++){
			habilidadesContrincantes.add(habilidadDAO.loadById(contrincante.getHabilidadActivaList().get(i).getHabilidadRef().getRefIdent()));
		}
		
		List<DataObject> NivelHabilidadAtacantes = new ArrayList<DataObject>();
		List<DataObject> NivelHabilidadContrincantes = new ArrayList<DataObject>();
		
		for (int i = 0; i < (atacante.getHabilidadActivaList().size()); i++){
			NivelHabilidadAtacantes.add(nivHabilidadDAO.loadNivelHabStats(atacante.getHabilidadActivaList().get(i).getHabilidadRef().getRefIdent(),atacante.getHabilidadActivaList().get(i).getNivel_habilidad()));
		}
		
		for (int i = 0; i < (contrincante.getHabilidadActivaList().size()); i++){
			NivelHabilidadContrincantes.add(nivHabilidadDAO.loadNivelHabStats(contrincante.getHabilidadActivaList().get(i).getHabilidadRef().getRefIdent(), contrincante.getHabilidadActivaList().get(i).getNivel_habilidad()));
		}
		
		IHabilidadDO habilidadAtacante;
		INivelHabilidadDO NivelHabilidadAtacante;
		IHabilidadDO habilidadContricante;
		INivelHabilidadDO NivelHabilidadContricante;
		int x,tipoA,y,tipoB;
		float efectividadAtacante, efectividadContrincante;
		
				
		do{
			x = (int) (Math.random()*habilidadesAtacante.size());
			habilidadAtacante = (IHabilidadDO) habilidadesAtacante.get(x);
		}while(habilidadAtacante.getTipo() != 1);
		
		tipoA = habilidadAtacante.getTipo();
		NivelHabilidadAtacante = nivHabilidadDAO.loadNivelHabStats(habilidadAtacante.getId(), atacante.getHabilidadActivaList().get(x).getNivel_habilidad());
		efectividadAtacante = NivelHabilidadAtacante.getEfectividad();
		
		if(atacante.getEnergiaDelAnillo() >= NivelHabilidadAtacante.getCosto_de_energia() ){
			contrincante.setSalud((int) (contrincante.getSalud() - efectividadAtacante));
			atacante.setEnergiaDelAnillo((int) (atacante.getEnergiaDelAnillo() - NivelHabilidadAtacante.getCosto_de_energia()));
		}else{
			tipoA = 2;
		}
		
		while(atacante.getSalud() > 0 && contrincante.getSalud() > 0){
			
			if(tipoA == 2){
				do{
					y = (int) (Math.random()*habilidadesContrincantes.size());
					habilidadContricante = (IHabilidadDO) habilidadesContrincantes.get(y);
				}while(habilidadContricante.getTipo() == 2 || habilidadContricante.getTipo() == 4);				
			}else{
				do{
					y = (int) (Math.random()*habilidadesContrincantes.size());
					habilidadContricante = (IHabilidadDO) habilidadesContrincantes.get(y);
				}while(habilidadContricante.getTipo() == 4);
			}
			
			tipoB = habilidadContricante.getTipo();
			NivelHabilidadContricante = nivHabilidadDAO.loadNivelHabStats(habilidadContricante.getId(), contrincante.getHabilidadActivaList().get(y).getNivel_habilidad());
			efectividadContrincante = NivelHabilidadContricante.getEfectividad();
			
			if(contrincante.getEnergiaDelAnillo() >= NivelHabilidadAtacante.getCosto_de_energia()){
				if(tipoB == 2){
					contrincante.setSalud((int) (contrincante.getSalud() + (efectividadAtacante*efectividadContrincante/100)));
				}else{
					atacante.setSalud((int) (atacante.getSalud() - efectividadContrincante));
				}
				contrincante.setEnergiaDelAnillo((int) (contrincante.getEnergiaDelAnillo() - NivelHabilidadContricante.getCosto_de_energia()));
			}else{
				tipoB = 2;
			}
			
			if(atacante.getSalud() > 0){
				if(tipoB == 2){
					do{
						x = (int) (Math.random()*habilidadesAtacante.size());
						habilidadAtacante = (IHabilidadDO) habilidadesAtacante.get(x);
					}while(habilidadAtacante.getTipo() == 2 || habilidadAtacante.getTipo() == 4);				
				}else{
					do{
						x = (int) (Math.random()*habilidadesAtacante.size());
						habilidadAtacante= (IHabilidadDO) habilidadesAtacante.get(x);
					}while(habilidadAtacante.getTipo() == 4);
				}
				
				tipoA = habilidadAtacante.getTipo();
				NivelHabilidadAtacante = nivHabilidadDAO.loadNivelHabStats(habilidadAtacante.getId(), atacante.getHabilidadActivaList().get(x).getNivel_habilidad());
				efectividadAtacante = NivelHabilidadAtacante.getEfectividad();
				if(atacante.getSalud() > 0 || contrincante.getSalud() > 0){
					if(tipoA == 2){
						atacante.setSalud((int) (atacante.getSalud() + (efectividadAtacante*efectividadContrincante/100)));
					}else{
						contrincante.setSalud((int) (contrincante.getSalud() - efectividadAtacante));
					}
				}else{
					tipoA = 2;
				}
			}
			
			if(atacante.getEnergiaDelAnillo() <= (5 - ((atacante.getNivel()-1)*0.2)) && contrincante.getEnergiaDelAnillo() <= (5 - ((contrincante.getNivel()-1)*0.2))){
				atacante.setSalud(0);
				contrincante.setSalud(0);
			}
			
		}
		
		if(atacante.getEnergiaDelAnillo() <= (5 - ((atacante.getNivel()-1)*0.2)) && contrincante.getEnergiaDelAnillo() <= (5 - ((contrincante.getNivel()-1)*0.2))){
			System.err.println("jejejej noganaron ninguno");
		}else{
			if(atacante.getSalud() <= 0){
				System.err.println("Gane sapos");
			}else{
				System.err.println("Mardito me ganaste pero voy por la revancha");
			}
		}		
		
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
