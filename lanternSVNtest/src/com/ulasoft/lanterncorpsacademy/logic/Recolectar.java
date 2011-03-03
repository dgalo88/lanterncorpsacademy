package com.ulasoft.lanterncorpsacademy.logic;

import java.util.List;

import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDAO;
import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IRecursoDAO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoPersonajeDAO;
import lcaInterfaceDAO.IRecursoPersonajeDO;
import lcaInterfaceDAO.IRecursoPlanetaDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class Recolectar {

	public static List<IRecursoPlanetaDO> getRecursoPlanetaList( //
			IPersonajeDO personaje) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPlanetaDAO planetaDAO = (IPlanetaDAO) //
				GlobalDAOFactory.getDAO(IPlanetaDAO.class, connectionBean);
		IPlanetaDO planeta = (IPlanetaDO) //
				planetaDAO.loadById(personaje.getPlanetaRef().getRefIdent());

		planetaDAO.loadRecursoPlanetaList(planeta);

		connectionBean.getConnection().close();

		return planeta.getRecursoPlanetaList();

	}

	public static TestTableModel asignarRecursos(TestTableModel tableDtaModel,
			List<IRecursoPlanetaDO> recursoPlanetaList) {

		for (int posicion = 0; posicion < recursoPlanetaList.size(); posicion++) {
			tableDtaModel.add(recursoPlanetaList.get(posicion));
		}
		return tableDtaModel;

	}

	public static IRecursoDO getRecurso(IRecursoPlanetaDO recursoPlanetaDO) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IRecursoDAO recursoDAO = (IRecursoDAO) //
			GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);
		IRecursoDO recurso = (IRecursoDO) //
			recursoDAO.loadById(recursoPlanetaDO.getRecursoRef().getRefIdent());

		connectionBean.getConnection().close();
		return recurso;

	}

	public static String recolectar(IPersonajeDO personaje, //
			IRecursoPlanetaDO recursoPlanetaDO) throws Exception {

		int cantidadRecurso = recursoPlanetaDO.getCantidad_maxima_recurso() / 24;
		int energia = personaje.getEnergiaDelAnillo();

		if (energia < cantidadRecurso) {
			return "No tienes suficiente energía para recolectar";
		}

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		IRecursoPersonajeDAO recursoPersonajeDAO = (IRecursoPersonajeDAO) //
				GlobalDAOFactory.getDAO(IRecursoPersonajeDAO.class, connectionBean);
		IRecursoPersonajeDO recursoPersonaje = (IRecursoPersonajeDO) //
				GlobalDOFactory.getDO(IRecursoPersonajeDO.class);
		IRecursoDAO recursoDAO = (IRecursoDAO) //
				GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);
		IRecursoDO recursoNuevo = (IRecursoDO) //
				recursoDAO.loadById(recursoPlanetaDO.getRecursoRef().getRefIdent());

		personajeDAO.loadRecursoPersonajeList(personaje);
		List<IRecursoPersonajeDO> recursoPersonajeList = //
			personaje.getRecursoPersonajeList();

		Reference<IPersonajeDO> refPersonaje = new Reference<IPersonajeDO>();
		refPersonaje.setRefValue(personaje);

		Reference<IRecursoDO> refRecurso = new Reference<IRecursoDO>();
		refRecurso.setRefValue(recursoNuevo);

		for (int i = 0; i < recursoPersonajeList.size(); i++) {

			if (recursoPlanetaDO.getRecursoRef().getRefIdent() == //
				recursoPersonajeList.get(i).getRecursoRef().getRefIdent()) {

				recursoPersonajeList.get(i).setCantidad(cantidadRecurso + //
						recursoPersonajeList.get(i).getCantidad());
				recursoPersonajeDAO.update(recursoPersonajeList.get(i));

				energia -= cantidadRecurso;
				break;

			} else {

				if (i == recursoPersonajeList.size() - 1) {

					recursoPersonaje.setPersonajeRef(refPersonaje);
					recursoPersonaje.setRecursoRef(refRecurso);
					recursoPersonaje.setCantidad(cantidadRecurso);

					recursoPersonajeList.add(recursoPersonaje);
					recursoPersonajeDAO.insert(recursoPersonaje);

					energia -= cantidadRecurso;
					break;
				}

			}

		}

		if (recursoPersonajeList.size() == 0) {

			recursoPersonaje.setPersonajeRef(refPersonaje);
			recursoPersonaje.setRecursoRef(refRecurso);
			recursoPersonaje.setCantidad(cantidadRecurso);

			recursoPersonajeList.add(recursoPersonaje);
			recursoPersonajeDAO.insert(recursoPersonaje);

			energia -= cantidadRecurso;
		}

		personaje.setEnergiaDelAnillo(energia);
		personaje.setRecursoPersonajeList(recursoPersonajeList);
		personajeDAO.update(personaje);

		System.err.println("\nPERSONAJE ID en recolectar: " + personaje.getId());
		connectionBean.getConnection().close();

		return "Has recolectado " + cantidadRecurso + //
				" unidades de " + recursoNuevo.getNombre();

	}

	public static String recolectarRecursoList(IPersonajeDO personaje, //
			List<IRecursoPlanetaDO> recursoPlanetaList) throws Exception {

		String result[] = new String[2];
		for (int i = 0; i < recursoPlanetaList.size(); i++) {

			result[i] = recolectar(personaje, recursoPlanetaList.get(i));

			if (result[i].equals("No tienes suficiente energía para recolectar")) {
				return result[i];
			}

		}

		return result[0] + " & " + result[1];
	}

}
