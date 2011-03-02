package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IRecursoDAO;
import lcaInterfaceDAO.IRecursoDO;
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

		personajeDAO.loadTecnologiaPersonajeList(personaje);

		System.err.println("List en tecnologia size: " //
				+ personaje.getTecnologiaPersonajeList().size());

		if (personaje.getTecnologiaPersonajeList().size() == 0) {

			for (int i = 0; i < 48; i++) {
				tecnologiaList.add((ITecnologiaDO) //
						tecnologiaDAO.loadById(i + 1));
			}
			return tecnologiaList;
		}

		System.err.println("listToBuy en tecnologia size: " //
				+ tecnologiaDAO.listToBuy(personaje.getId()).size());

		for (int i = 0; i < tecnologiaDAO.listToBuy(personaje.getId()).size(); i++) {

			ITecnologiaPersonajeDO tecnologiaPersonaje = (ITecnologiaPersonajeDO) //
					tecnologiaDAO.listToBuy(personaje.getId()).get(i);

			ITecnologiaDO tecnologiaDO = (ITecnologiaDO) //
					tecnologiaPersonaje.getTecnologiaRef().getRefValue();

			tecnologiaList.add(tecnologiaDO);

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

		String result = "Has Adquirido ";

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		ITecnologiaDAO tecnologiaDAO = (ITecnologiaDAO) //
				GlobalDAOFactory.getDAO(ITecnologiaDAO.class, connectionBean);
		ITecnologiaPersonajeDAO tecnologiaPersonajeDAO = (ITecnologiaPersonajeDAO) //
				GlobalDAOFactory.getDAO(ITecnologiaPersonajeDAO.class, connectionBean);
		IRecursoDAO recursoDAO = (IRecursoDAO) //
				GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);

		ITecnologiaPersonajeDO tecnologiaPersonajeNueva = (ITecnologiaPersonajeDO) //
				GlobalDOFactory.getDO(ITecnologiaPersonajeDO.class);

		ITecnologiaDO tecnologiaNueva;
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

		for (int i = 0; i < tecnologiaRecursoList.size(); i++) {

			recursoTec = (IRecursoDO) recursoDAO.loadById( //
					tecnologiaRecursoList.get(i).getRecursoRef().getRefIdent());

			tecnologiaNueva = (ITecnologiaDO) tecnologiaDAO.loadById( //
					tecnologiaRecursoList.get(i) //
					.getTecnologiaRef().getRefIdent());

			for (int j = 0; j < recursoPersonajeList.size(); j++) {

				recursoPer = (IRecursoDO) recursoDAO.loadById( //
						recursoPersonajeList.get(j).getRecursoRef().getRefIdent());

				if (recursoTec.getArticulo() != recursoPer.getArticulo()) {
					
					if (j == recursoPersonajeList.size() - 1) {
						return "No tienes suficiente " + recursoTec.getNombre() + //
								"para adquirir " + tecnologiaNueva.getNombre();
					}
					continue;
				}
				break;
			}

			if (tecnologiaRecursoList.get(i).getCantidad() > //
				recursoPersonajeList.get(i).getCantidad()) {

				return "No tienes suficiente " + recursoTec.getNombre() + //
						"para adquirir " + tecnologiaNueva.getNombre();
			}

			Reference<IPersonajeDO> personajeRef = new Reference<IPersonajeDO>();
			IPersonajeDO refPersonajeValue = (IPersonajeDO) //
					personajeDAO.loadById(personaje.getId());
			personajeRef.setRefValue(refPersonajeValue);
			tecnologiaPersonajeNueva.setPersonajeRef(personajeRef);

			Reference<ITecnologiaDO> tecnologiaRef = new Reference<ITecnologiaDO>();
			ITecnologiaDO refTecnologiaValue = (ITecnologiaDO) //
					tecnologiaDAO.loadById(tecnologiaNueva.getId());
			tecnologiaRef.setRefValue(refTecnologiaValue);
			tecnologiaPersonajeNueva.setTecnologiaRef(tecnologiaRef);

			tecnologiaPersonajeDAO.insert(tecnologiaPersonajeNueva);

			tecnologiaPersonajeList.add(tecnologiaPersonajeNueva);

			recursoPersonajeList.get(i).setCantidad( //
					recursoPersonajeList.get(i).getCantidad() - //
					tecnologiaRecursoList.get(i).getCantidad());

			result += tecnologiaNueva.getNombre() + " con éxito";
		}

		personaje.setTecnologiaPersonajeList(tecnologiaPersonajeList);
		personajeDAO.update(personaje);

		connectionBean.getConnection().close();

		return result;

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
