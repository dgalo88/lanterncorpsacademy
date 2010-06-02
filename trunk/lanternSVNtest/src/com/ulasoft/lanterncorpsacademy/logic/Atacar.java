package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IHabilidadDAO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.INivelHabilidadDAO;
import lcaInterfaceDAO.INivelHabilidadDO;
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

	public static void combate(IPersonajeDO contrincante) throws Exception {

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
			if (NivelHabilidadAtacante.getCosto_de_energia() <= atacante
					.getEnergiaDelAnillo()) {
				atacante.setEnergiaDelAnillo((int) (atacante
						.getEnergiaDelAnillo() - NivelHabilidadAtacante
						.getCosto_de_energia()));
			} else {
				atacante.setEnergiaDelAnillo(0);
			}
			System.err.println("atacante " + habilidadAtacante.getNombre());
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

			if (contrincante.getEnergiaDelAnillo() >= NivelHabilidadContricante.getCosto_de_energia()) {
				System.err.println("contrincante "
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
					System.err.println("atacante "
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
			desktop.setWindowPaneEmergente("El Combate a resultado un empate:");
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
				desktop.setWindowPaneEmergente("Ganaste el combate:");
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
				desktop.setWindowPaneEmergente("Perdiste el combate:");
			}
		}

		atts.setPersonaje(atacante);
		atts.guardarAtts();
		atts.updateMenud(desktop.getMenud());
		personajeDAO.update(contrincante);

	}

	public static TestTableModel asignarRanking(TestTableModel tableDtaModel,
			List<IPersonajeDO> personajes) {

		for (int posicion = 0; posicion < personajes.size(); posicion++) {
			tableDtaModel.add(personajes.get(posicion));

		}
		return tableDtaModel;
	}

	public static String determinarClase(int clase) {
		switch (clase) {
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
