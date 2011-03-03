package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IRecursoDAO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoPersonajeDAO;
import lcaInterfaceDAO.IRecursoPersonajeDO;
import lcaInterfaceDAO.ITecnologiaDAO;
import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.ITecnologiaPersonajeDAO;
import lcaInterfaceDAO.ITecnologiaPersonajeDO;
import lcaInterfaceDAO.ITecnologiaRecursoDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class Tecnologia {

	public static List<ITecnologiaDO> getTecnologiaPersonaje( //
			IPersonajeDO personaje) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		ITecnologiaDAO tecnologiaDAO = (ITecnologiaDAO) //
				GlobalDAOFactory.getDAO(ITecnologiaDAO.class, connectionBean);

		List<ITecnologiaDO> tecnologiaList = new ArrayList<ITecnologiaDO>();

		System.err.println("tecnologiaDAO countAll: " //
				+ tecnologiaDAO.countAll());

		for (int i = 0; i < tecnologiaDAO.countAll(); i++) {
			tecnologiaList.add((ITecnologiaDO) //
					tecnologiaDAO.loadById(i + 1));
		}

		personajeDAO.loadTecnologiaPersonajeList(personaje);

		System.err.println("List en tecnologia size: " //
				+ personaje.getTecnologiaPersonajeList().size());

		if (personaje.getTecnologiaPersonajeList().size() == 0) {
			return tecnologiaList;
		}
		List<ITecnologiaPersonajeDO> tecnologiaPersonajeList = //
			personaje.getTecnologiaPersonajeList();

		for (int i = 0; i < tecnologiaList.size(); i++) {

			for (int j = 0; j < tecnologiaPersonajeList.size(); j++) {

				if (tecnologiaList.get(i).getId() == //
					tecnologiaPersonajeList.get(j).getTecnologiaRef().getRefIdent()) {

					tecnologiaList.remove(i);
				}
			}
		}

		System.err.println("PERSONAJE ID en tecnologia:" + personaje.getId());
		connectionBean.getConnection().close();

		return tecnologiaList;
	}

	public static TestTableModel asignarTecnologia( //
			TestTableModel tableDtaModel, List<ITecnologiaDO> tecnologiaList) {

		for (int posicion = 0; posicion < tecnologiaList.size(); posicion++) {
			tableDtaModel.add(tecnologiaList.get(posicion));
		}
		return tableDtaModel;

	}

	public static String getCostoString(ITecnologiaDO tecnologia) //
			throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		String costo = "";

		ITecnologiaDAO tecnologiaDAO = (ITecnologiaDAO) //
				GlobalDAOFactory.getDAO(ITecnologiaDAO.class, connectionBean);
		IRecursoDAO recursoDAO = (IRecursoDAO) //
				GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);

		tecnologiaDAO.loadTecnologiaRecursoList(tecnologia);

		List<ITecnologiaRecursoDO> tecnologiaRecursoList = //
			new ArrayList<ITecnologiaRecursoDO>();
		List<IRecursoDO> recursoList = new ArrayList<IRecursoDO>();

		for (int i = 0; i < tecnologia.getTecnologiaRecursoList().size(); i++) {

			ITecnologiaRecursoDO tecnologiaRecurso = (ITecnologiaRecursoDO) //
					tecnologia.getTecnologiaRecursoList().get(i);
			tecnologiaRecursoList.add(tecnologiaRecurso);

			IRecursoDO recursoDO = (IRecursoDO) //
					recursoDAO.loadById(tecnologiaRecurso //
							.getRecursoRef().getRefIdent());
			recursoList.add(recursoDO);

		}

		for (int i = 0; i < tecnologiaRecursoList.size(); i++) {

			costo += recursoList.get(i).getNombre() + ": " + //
					tecnologiaRecursoList.get(i).getCantidad();

			if (i < tecnologiaRecursoList.size() - 1) {
				costo += " + ";
			}
		}

		connectionBean.getConnection().close();
		return costo;

	}

	public static String adquirirTecnologia(IPersonajeDO personaje, //
			ITecnologiaDO tecnologia) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		ITecnologiaDAO tecnologiaDAO = (ITecnologiaDAO) //
				GlobalDAOFactory.getDAO(ITecnologiaDAO.class, connectionBean);
		ITecnologiaPersonajeDAO tecnologiaPersonajeDAO = (ITecnologiaPersonajeDAO) //
				GlobalDAOFactory.getDAO(ITecnologiaPersonajeDAO.class, connectionBean);
		IRecursoDAO recursoDAO = (IRecursoDAO) //
				GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);
		IRecursoPersonajeDAO recursoPersonajeDAO = (IRecursoPersonajeDAO) //
				GlobalDAOFactory.getDAO(IRecursoPersonajeDAO.class, connectionBean);

		ITecnologiaPersonajeDO tecnologiaPersonajeNueva = (ITecnologiaPersonajeDO) //
				GlobalDOFactory.getDO(ITecnologiaPersonajeDO.class);

		Reference<IPersonajeDO> personajeRef = new Reference<IPersonajeDO>();
		IPersonajeDO personajeRefValue = (IPersonajeDO) //
				personajeDAO.loadById(personaje.getId());
		Reference<ITecnologiaDO> tecnologiaRef = new Reference<ITecnologiaDO>();
		ITecnologiaDO tecnologiaRefValue = (ITecnologiaDO) //
				tecnologiaDAO.loadById(tecnologia.getId());

		IRecursoDO recursoTec;
		IRecursoDO recursoPer;

		tecnologiaDAO.loadTecnologiaRecursoList(tecnologia);
		List<ITecnologiaRecursoDO> tecnologiaRecursoList = //
			tecnologia.getTecnologiaRecursoList();

		personajeDAO.loadRecursoPersonajeList(personaje);
		List<IRecursoPersonajeDO> recursoPersonajeList = //
			personaje.getRecursoPersonajeList();

		personajeDAO.loadTecnologiaPersonajeList(personaje);
		List<ITecnologiaPersonajeDO> tecnologiaPersonajeList = //
			personaje.getTecnologiaPersonajeList();

		if (recursoPersonajeList.size() == 0) {
			connectionBean.getConnection().close();
			return "No tienes suficientes recursos para adquirir la tecnología";
		}

		for (int i = 0; i < tecnologiaRecursoList.size(); i++) {

			recursoTec = (IRecursoDO) recursoDAO.loadById( //
					tecnologiaRecursoList.get(i).getRecursoRef().getRefIdent());

			for (int j = 0; j < recursoPersonajeList.size(); j++) {

				recursoPer = (IRecursoDO) recursoDAO.loadById( //
						recursoPersonajeList.get(j).getRecursoRef().getRefIdent());

				if (recursoTec.getArticulo() != recursoPer.getArticulo()) {
					
					if (j == recursoPersonajeList.size() - 1) {
						connectionBean.getConnection().close();
						return "No tienes suficiente " + recursoTec.getNombre() + //
								" para adquirir " + tecnologia.getNombre();
					}
					continue;
				}

				if (tecnologiaRecursoList.get(i).getCantidad() > //
					recursoPersonajeList.get(j).getCantidad()) {

					return "No tienes suficiente " + recursoTec.getNombre() + //
							" para adquirir " + tecnologia.getNombre();
				}

				recursoPersonajeList.get(j).setCantidad( //
						recursoPersonajeList.get(j).getCantidad() - //
						tecnologiaRecursoList.get(i).getCantidad());

				break;
			}

		}

		personajeRef.setRefValue(personajeRefValue);
		tecnologiaPersonajeNueva.setPersonajeRef(personajeRef);

		tecnologiaRef.setRefValue(tecnologiaRefValue);
		tecnologiaPersonajeNueva.setTecnologiaRef(tecnologiaRef);

		tecnologiaPersonajeList.add(tecnologiaPersonajeNueva);
		personaje.setTecnologiaPersonajeList(tecnologiaPersonajeList);

		for (int i = 0; i < recursoPersonajeList.size(); i++) {
			recursoPersonajeDAO.update(recursoPersonajeList.get(i));
		}

		tecnologiaPersonajeDAO.insert(tecnologiaPersonajeNueva);
		personajeDAO.update(personaje);

		connectionBean.getConnection().close();

		return "Has Adquirido " + tecnologia.getNombre() + " con éxito";

	}

	public static String adquirirListaTecnologia(IPersonajeDO personaje, //
			List<ITecnologiaDO> tecnologiaList, List<Integer> seleccion) throws Exception {

		String result = "";

		for (int i = 0; i < seleccion.size(); i++) {
			result = adquirirTecnologia(personaje, //
					tecnologiaList.get(seleccion.get(i)));
		}

		return result;

	}

}
