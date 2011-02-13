package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IHabilidadDAO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.INivelHabilidadDAO;
import lcaInterfaceDAO.INivelHabilidadDO;
import lcaInterfaceDAO.INpcDAO;
import lcaInterfaceDAO.INpcDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.api.DataObject;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;

public class Atacar {

	private static int result;

	private static final int EMPATE = 0;
	private static final int VICTORIA = 1;
	private static final int DERROTA = 2;

	public static List<IPersonajeDO> obtenerContrincantes(IPersonajeDO person)
			throws Exception {
		List<IPersonajeDO> personajes;
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IPersonajeDAO personaje = (IPersonajeDAO) GlobalDAOFactory.getDAO(
				IPersonajeDAO.class, connectionBean);
		;
		personajes = personaje.listContrincantes(person.getId(), (person
				.getClaseLinternaRef()).getRefIdent(), (person.getPlanetaRef())
				.getRefIdent());
		connectionBean.getConnection().close();
		return personajes;
	}
	public static List<INpcDO> obtenerContrincantesNPC(IPersonajeDO person)
	throws Exception {
		List<INpcDO> personajes;
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		INpcDAO personaje = (INpcDAO) GlobalDAOFactory.getDAO(
		INpcDAO.class, connectionBean);
		personajes = personaje.listNpc(person.getClaseLinternaRef().getRefIdent());
		connectionBean.getConnection().close();
		return personajes;
	}

	public static int combate(IPersonajeDO contrincante) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
				.getActive();
		Desktop desktop;

		IHabilidadDAO habilidadDAO = (IHabilidadDAO) GlobalDAOFactory.getDAO(
				IHabilidadDAO.class, connectionBean);
		IPersonajeDAO personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(
				IPersonajeDAO.class, connectionBean);
		INivelHabilidadDAO nivHabilidadDAO = (INivelHabilidadDAO) GlobalDAOFactory
				.getDAO(INivelHabilidadDAO.class, connectionBean);

		Atributos atts = app.getAtributos();
		IPersonajeDO atacante = atts.getPersonaje();

		personajeDAO.loadHabilidadActivaList(atacante);
		personajeDAO.loadHabilidadActivaList(contrincante);

		System.err.println(atacante.getHabilidadActivaList().size());
		System.err.println(contrincante.getHabilidadActivaList().size());

		List<DataObject> habilidadesAtacante = new ArrayList<DataObject>();
		List<DataObject> habilidadesContrincantes = new ArrayList<DataObject>();

		for (int i = 0; i < (atacante.getHabilidadActivaList().size()); i++) {
			habilidadesAtacante.add(habilidadDAO.loadById(atacante
					.getHabilidadActivaList().get(i).getHabilidadRef()
					.getRefIdent()));
		}

		for (int i = 0; i < (contrincante.getHabilidadActivaList().size()); i++) {
			habilidadesContrincantes.add(habilidadDAO.loadById(contrincante
					.getHabilidadActivaList().get(i).getHabilidadRef()
					.getRefIdent()));
		}

		List<DataObject> NivelHabilidadAtacantes = new ArrayList<DataObject>();
		List<DataObject> NivelHabilidadContrincantes = new ArrayList<DataObject>();

		for (int i = 0; i < (atacante.getHabilidadActivaList().size()); i++) {
			NivelHabilidadAtacantes.add(nivHabilidadDAO.loadNivelHabStats(
					atacante.getHabilidadActivaList().get(i).getHabilidadRef()
							.getRefIdent(), atacante.getHabilidadActivaList()
							.get(i).getNivel_habilidad()));
		}

		for (int i = 0; i < (contrincante.getHabilidadActivaList().size()); i++) {
			NivelHabilidadContrincantes.add(nivHabilidadDAO.loadNivelHabStats(
					contrincante.getHabilidadActivaList().get(i)
							.getHabilidadRef().getRefIdent(), contrincante
							.getHabilidadActivaList().get(i)
							.getNivel_habilidad()));
		}

		IHabilidadDO habilidadAtacante;
		INivelHabilidadDO NivelHabilidadAtacante;
		IHabilidadDO habilidadContricante;
		INivelHabilidadDO NivelHabilidadContricante;
		int x, tipoA, y, tipoB;
		float efectividadAtacante, efectividadContrincante;

		do {
			x = (int) (Math.random() * habilidadesAtacante.size());
			habilidadAtacante = (IHabilidadDO) habilidadesAtacante.get(x);
		} while (habilidadAtacante.getTipo() != 1);

		tipoA = habilidadAtacante.getTipo();
		NivelHabilidadAtacante = nivHabilidadDAO.loadNivelHabStats(
				habilidadAtacante.getId(), atacante.getHabilidadActivaList()
						.get(x).getNivel_habilidad());
		efectividadAtacante = NivelHabilidadAtacante.getEfectividad();

		if (atacante.getEnergiaDelAnillo() >= NivelHabilidadAtacante
				.getCosto_de_energia()) {
			contrincante
					.setSalud((int) (contrincante.getSalud() - efectividadAtacante));

			atacante
					.setEnergiaDelAnillo((int) (atacante.getEnergiaDelAnillo() - NivelHabilidadAtacante
							.getCosto_de_energia()));

			System.err.println("Atacante " + habilidadAtacante.getNombre());
		} else {
			tipoA = 2;
		}

		while (atacante.getSalud() > 0 && contrincante.getSalud() > 0) {

			if (tipoA == 2) {
				do {
					y = (int) (Math.random() * habilidadesContrincantes.size());
					habilidadContricante = (IHabilidadDO) habilidadesContrincantes
							.get(y);
				} while (habilidadContricante.getTipo() == 2
						|| habilidadContricante.getTipo() == 4);
			} else {
				do {
					y = (int) (Math.random() * habilidadesContrincantes.size());
					habilidadContricante = (IHabilidadDO) habilidadesContrincantes
							.get(y);
				} while (habilidadContricante.getTipo() == 4);
			}

			tipoB = habilidadContricante.getTipo();
			NivelHabilidadContricante = nivHabilidadDAO.loadNivelHabStats(
					habilidadContricante.getId(), contrincante
							.getHabilidadActivaList().get(y)
							.getNivel_habilidad());
			efectividadContrincante = NivelHabilidadContricante
					.getEfectividad();

			if (contrincante.getEnergiaDelAnillo() >= NivelHabilidadContricante
					.getCosto_de_energia()) {
				System.err.println("Contrincante "
						+ habilidadContricante.getNombre());
				if (tipoB == 2) {
					contrincante
							.setSalud((int) (contrincante.getSalud() + (efectividadAtacante
									* efectividadContrincante / 100)));
				} else {
					atacante
							.setSalud((int) (atacante.getSalud() - efectividadContrincante));
				}

				contrincante.setEnergiaDelAnillo((int) (contrincante
						.getEnergiaDelAnillo() - NivelHabilidadContricante
						.getCosto_de_energia()));

			} else {
				tipoB = 2;
			}

			if (atacante.getSalud() > 0) {
				if (tipoB == 2) {
					do {
						x = (int) (Math.random() * habilidadesAtacante.size());
						habilidadAtacante = (IHabilidadDO) habilidadesAtacante
								.get(x);
					} while (habilidadAtacante.getTipo() == 2
							|| habilidadAtacante.getTipo() == 4);
				} else {
					do {
						x = (int) (Math.random() * habilidadesAtacante.size());
						habilidadAtacante = (IHabilidadDO) habilidadesAtacante
								.get(x);
					} while (habilidadAtacante.getTipo() == 4);
				}

				tipoA = habilidadAtacante.getTipo();
				NivelHabilidadAtacante = nivHabilidadDAO.loadNivelHabStats(
						habilidadAtacante.getId(), atacante
								.getHabilidadActivaList().get(x)
								.getNivel_habilidad());
				efectividadAtacante = NivelHabilidadAtacante.getEfectividad();
				if (atacante.getEnergiaDelAnillo() >= NivelHabilidadAtacante
						.getCosto_de_energia()) {
					System.err.println("Atacante "
							+ habilidadAtacante.getNombre());
					if (tipoA == 2) {
						atacante
								.setSalud((int) (atacante.getSalud() + (efectividadAtacante
										* efectividadContrincante / 100)));
					} else {
						contrincante
								.setSalud((int) (contrincante.getSalud() - efectividadAtacante));
					}
					if (NivelHabilidadAtacante.getCosto_de_energia() <= atacante
							.getEnergiaDelAnillo()) {
						atacante.setEnergiaDelAnillo((int) (atacante
								.getEnergiaDelAnillo() - NivelHabilidadAtacante
								.getCosto_de_energia()));
					} else {
						atacante.setEnergiaDelAnillo(0);
					}
				} else {
					tipoA = 2;
				}
			}

			if (atacante.getEnergiaDelAnillo() <= (5 - ((atacante.getNivel() - 1) * 0.2))
					&& contrincante.getEnergiaDelAnillo() <= (5 - ((contrincante
							.getNivel() - 1) * 0.2))) {
				atacante.setSalud(0);
				contrincante.setSalud(0);
			}

		}
		double expA = 10, expB = 10;
		double puntosB;
		double puntosA;
		desktop = app.getDesktop();
		if (atacante.getEnergiaDelAnillo() <= (5 - ((atacante.getNivel() - 1) * 0.2))
				&& contrincante.getEnergiaDelAnillo() <= (5 - ((contrincante
						.getNivel() - 1) * 0.2))) {
			atacante.setSalud((200 + (50 * (atacante.getNivel() - 1))));
			contrincante.setSalud((200 + (50 * (contrincante.getNivel() - 1))));
			atacante.getPlanetaRef().setRefIdent(
					atacante.getClaseLinternaRef().getRefIdent());
			contrincante.getPlanetaRef().setRefIdent(
					contrincante.getClaseLinternaRef().getRefIdent());

			result = EMPATE;

		} else {
			if (atacante.getSalud() > 0) {
				contrincante
						.setSalud((200 + (50 * (contrincante.getNivel() - 1))));
				contrincante.getPlanetaRef().setRefIdent(
						contrincante.getClaseLinternaRef().getRefIdent());
				puntosA = (100 + (50 * (contrincante.getNivel() - 1)));
				atacante.setPuntosDeEntrenamiento((int) (atacante
						.getPuntosDeEntrenamiento() + puntosA));

				for (int i = 1; i < atacante.getNivel(); i++) {
					expA = expA + (expA * 0.5);
				}
				atacante
						.setExperiencia((int) (atacante.getExperiencia() + expA));
				if (contrincante.getPuntosDeEntrenamiento() != 0) {
					puntosB = puntosA / 2;
					if (contrincante.getPuntosDeEntrenamiento() < puntosB) {
						contrincante.setPuntosDeEntrenamiento(0);
					} else {
						contrincante
								.setPuntosDeEntrenamiento((int) (contrincante
										.getPuntosDeEntrenamiento() - puntosB));
					}

				}

				result = VICTORIA;

			} else {
				atacante.setSalud((200 + (50 * (atacante.getNivel() - 1))));
				atacante.getPlanetaRef().setRefIdent(
						atacante.getClaseLinternaRef().getRefIdent());

				puntosB = (100 + (50 * (contrincante.getNivel() - 1)));
				contrincante.setPuntosDeEntrenamiento((int) (contrincante
						.getPuntosDeEntrenamiento() + puntosB));

				for (int i = 1; i < contrincante.getNivel(); i++) {
					expB = expB + (expB * 0.5);
				}
				contrincante.setExperiencia((int) (contrincante
						.getExperiencia() + expB));
				if (atacante.getPuntosDeEntrenamiento() != 0) {
					puntosA = puntosB / 2;
					if (atacante.getPuntosDeEntrenamiento() < puntosA) {
						atacante.setPuntosDeEntrenamiento(0);
					} else {
						atacante.setPuntosDeEntrenamiento((int) (atacante
								.getPuntosDeEntrenamiento() - puntosA));
					}

				}

				result = DERROTA;

			}
		}
		
		if(atacante.getExperiencia() >= (150*2^(atacante.getNivel()-1))){
			atacante.setNivel((atacante.getNivel()+1));
			atacante.setExperiencia(0);
		}
		if(contrincante.getExperiencia() >= (150*2^(contrincante.getNivel()-1))){
			contrincante.setNivel((contrincante.getNivel()+1));
			contrincante.setExperiencia(0);
		}
		atts.setPersonaje(atacante);
		atts.guardarAtts();
		atts.updateMenuStatus(desktop.getMenuHead().getMenuStatus());
		personajeDAO.update(contrincante);

		return result;
	}

	public static int atacarNPC(INpcDO npc) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
				.getActive();
		Desktop desktop;

		IHabilidadDAO habilidadDAO = (IHabilidadDAO) GlobalDAOFactory.getDAO(
				IHabilidadDAO.class, connectionBean);
		IPersonajeDAO personajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(
				IPersonajeDAO.class, connectionBean);
		INivelHabilidadDAO nivHabilidadDAO = (INivelHabilidadDAO) GlobalDAOFactory
				.getDAO(INivelHabilidadDAO.class, connectionBean);

		Atributos atts = app.getAtributos();
		IPersonajeDO atacante = atts.getPersonaje();

		personajeDAO.loadHabilidadActivaList(atacante);

		System.err.println(atacante.getHabilidadActivaList().size());

		List<DataObject> habilidadesAtacante = new ArrayList<DataObject>();

		for (int i = 0; i < (atacante.getHabilidadActivaList().size()); i++) {
			habilidadesAtacante.add(habilidadDAO.loadById(atacante
					.getHabilidadActivaList().get(i).getHabilidadRef()
					.getRefIdent()));
		}

		List<DataObject> NivelHabilidadAtacantes = new ArrayList<DataObject>();

		for (int i = 0; i < (atacante.getHabilidadActivaList().size()); i++) {
			NivelHabilidadAtacantes.add(nivHabilidadDAO.loadNivelHabStats(
					atacante.getHabilidadActivaList().get(i).getHabilidadRef()
							.getRefIdent(), atacante.getHabilidadActivaList()
							.get(i).getNivel_habilidad()));
		}

		IHabilidadDO habilidadAtacante;
		INivelHabilidadDO NivelHabilidadAtacante;
		int x, tipoA;
		float efectividadAtacante;

		do {
			x = (int) (Math.random() * habilidadesAtacante.size());
			habilidadAtacante = (IHabilidadDO) habilidadesAtacante.get(x);
		} while (habilidadAtacante.getTipo() != 1);

		tipoA = habilidadAtacante.getTipo();
		NivelHabilidadAtacante = nivHabilidadDAO.loadNivelHabStats(
				habilidadAtacante.getId(), atacante.getHabilidadActivaList()
						.get(x).getNivel_habilidad());
		efectividadAtacante = NivelHabilidadAtacante.getEfectividad();

		if (atacante.getEnergiaDelAnillo() >= NivelHabilidadAtacante
				.getCosto_de_energia()) {
			npc.setSalud((int) (npc.getSalud() - efectividadAtacante));

			atacante
					.setEnergiaDelAnillo((int) (atacante.getEnergiaDelAnillo() - NivelHabilidadAtacante
							.getCosto_de_energia()));

			System.err.println("Atacante " + habilidadAtacante.getNombre());
		}
		double alea;
		while (atacante.getSalud() > 0 && npc.getSalud() > 0) {

			alea = Math.random();
			if (alea > 0.5) {
				atacante.setSalud((int) (atacante.getSalud() - npc.getDano()));
			}

			if (atacante.getSalud() > 0) {

				do {
					x = (int) (Math.random() * habilidadesAtacante.size());
					habilidadAtacante = (IHabilidadDO) habilidadesAtacante
							.get(x);
				} while (habilidadAtacante.getTipo() == 4);

				tipoA = habilidadAtacante.getTipo();
				NivelHabilidadAtacante = nivHabilidadDAO.loadNivelHabStats(
						habilidadAtacante.getId(), atacante
								.getHabilidadActivaList().get(x)
								.getNivel_habilidad());
				efectividadAtacante = NivelHabilidadAtacante.getEfectividad();

				if (atacante.getEnergiaDelAnillo() >= NivelHabilidadAtacante
						.getCosto_de_energia()) {

					if (tipoA == 2) {
						atacante
								.setSalud((int) (atacante.getSalud() + (efectividadAtacante
										* npc.getDano() / 100)));
					} else {
						npc
								.setSalud((int) (npc.getSalud() - efectividadAtacante));
					}

					atacante.setEnergiaDelAnillo((int) (atacante
							.getEnergiaDelAnillo() - NivelHabilidadAtacante
							.getCosto_de_energia()));

				} 
			}

		}
		double expA = 10;

		double puntosA;
		desktop = app.getDesktop();

		if (atacante.getSalud() > 0) {

			puntosA = (100 + (50 * (npc.getNivel() - 1)));
			atacante.setPuntosDeEntrenamiento((int) (atacante
					.getPuntosDeEntrenamiento() + puntosA));

			for (int i = 1; i < atacante.getNivel(); i++) {
				expA = expA + (expA * 0.5);
			}
			atacante.setExperiencia((int) (atacante.getExperiencia() + expA));

			result = VICTORIA;

		} else {
			atacante.setSalud((200 + (50 * (atacante.getNivel() - 1))));
			atacante.getPlanetaRef().setRefIdent(
					atacante.getClaseLinternaRef().getRefIdent());

			if (atacante.getPuntosDeEntrenamiento() != 0) {
				puntosA = (100 + (50 * (npc.getNivel() - 1))) / 2;
				if (atacante.getPuntosDeEntrenamiento() > puntosA) {
					atacante.setPuntosDeEntrenamiento(0);
				} else {
					atacante.setPuntosDeEntrenamiento((int) (atacante
							.getPuntosDeEntrenamiento() - puntosA));
				}

			}

			result = DERROTA;

		}
		
		if(atacante.getExperiencia() >= (150*2^(atacante.getNivel()-1))){
			atacante.setNivel((atacante.getNivel()+1));
			atacante.setExperiencia(0);
		}

		atts.setPersonaje(atacante);
		atts.guardarAtts();
		atts.updateMenuStatus(desktop.getMenuHead().getMenuStatus());

		return result;
	}

	public static TestTableModel asignarRanking(TestTableModel tableDtaModel,
			List<IPersonajeDO> personajes) {

		for (int posicion = 0; posicion < personajes.size(); posicion++) {
			tableDtaModel.add(personajes.get(posicion));

		}
		return tableDtaModel;
	}
	
	public static TestTableModel asignarRankingNPC(TestTableModel tableDtaModel,
			List<INpcDO> personajes) {

		for (int posicion = 0; posicion < personajes.size(); posicion++) {
			tableDtaModel.add(personajes.get(posicion));

		}
		return tableDtaModel;
	}

}
