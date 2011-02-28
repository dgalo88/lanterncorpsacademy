package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.ITecnologiaDAO;
import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.ITecnologiaRecursoDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;

public class Tecnologia {

	public static List<ITecnologiaDO> getTecnologiaPersonaje( //
			IPersonajeDO personaje) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		ITecnologiaDAO tecnologiaDAO = (ITecnologiaDAO) //
				GlobalDAOFactory.getDAO(ITecnologiaDAO.class, connectionBean);

		List<ITecnologiaDO> tecnologiaList = new ArrayList<ITecnologiaDO>();
		for (int i = 0; i < 48; i++) {
			tecnologiaList.add((ITecnologiaDO) tecnologiaDAO.loadById(i+1));
		}

		personajeDAO.loadTecnologiaPersonajeList(personaje);

		if (personaje.getTecnologiaPersonajeList() == null) {
			return tecnologiaList;
		}

		List<ITecnologiaDO> tecnologiaListPer = new ArrayList<ITecnologiaDO>();
		for (int i = 0; i < personaje.getTecnologiaPersonajeList().size(); i++) {
			tecnologiaListPer.add(personaje.getTecnologiaPersonajeList().get(i) //
					.getTecnologiaRef().getRefValue());
		}

		for (int i = 0; i < tecnologiaList.size(); i++) {

			for (int j = 0; j < tecnologiaListPer.size(); j++) {
				if (tecnologiaList.get(i).equals(tecnologiaListPer.get(j))) {
					tecnologiaList.remove(i);
				}	
			}
		}

		System.err.println("PERSONAJE ID en tecnologia:" + personaje.getId());
		connectionBean.getConnection().close();

		return tecnologiaList;
	}

	public static TestTableModel asignarTecnologia(TestTableModel tableDtaModel,
			List<ITecnologiaDO> tecnologiaList) {

		for (int posicion = 0; posicion < tecnologiaList.size(); posicion++) {
			tableDtaModel.add(tecnologiaList.get(posicion));
		}
		return tableDtaModel;

	}

	public static String getPrecio(ITecnologiaDO tecnologia) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		String precio = "";

		ITecnologiaDAO tecnologiaDAO = (ITecnologiaDAO) //
				GlobalDAOFactory.getDAO(ITecnologiaDAO.class, connectionBean);

		tecnologiaDAO.loadTecnologiaRecursoList(tecnologia);
		System.err.println("listaTR:" + tecnologia.getTecnologiaRecursoList());

		List<ITecnologiaRecursoDO> tecnologiaRecursoList = new ArrayList<ITecnologiaRecursoDO>();
		List<IRecursoDO> recursoList = new ArrayList<IRecursoDO>();
		for (int i = 0; i < tecnologia.getTecnologiaRecursoList().size(); i++) {

			tecnologiaRecursoList.add(tecnologia.getTecnologiaRecursoList().get(i));

			recursoList.add(tecnologia.getTecnologiaRecursoList().get(i) //
					.getRecursoRef().getRefValue());
		}

		System.err.println("listaTR:" + tecnologiaRecursoList);
		System.err.println("listaR:" + recursoList);

		for (int i = 0; i < tecnologiaRecursoList.size(); i++) {

			System.err.println("NOMBRE RECURSO en tecnologia:" + recursoList.get(i).getNombre());
			System.err.println("CANTIDAD RECURSO en tecnologia:" + tecnologiaRecursoList.get(i).getCantidad());

			precio += recursoList.get(i).getNombre() + ": " + //
					tecnologiaRecursoList.get(i).getCantidad();

			if (i != tecnologiaRecursoList.size()) {
				precio += " + ";
			}
		}

		connectionBean.getConnection().close();

		return precio;

	}

}
