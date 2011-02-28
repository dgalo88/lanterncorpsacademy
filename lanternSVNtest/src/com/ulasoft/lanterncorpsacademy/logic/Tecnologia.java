package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.ITecnologiaDAO;
import lcaInterfaceDAO.ITecnologiaPersonajeDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;

public class Tecnologia {

	public static List<ITecnologiaPersonajeDO> getTecnologiaPersonaje( //
			IPersonajeDO personaje) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		List<ITecnologiaPersonajeDO> tecnologiaPersonajeList = new ArrayList<ITecnologiaPersonajeDO>();

		ITecnologiaDAO tecnologiaDAO = (ITecnologiaDAO) //
				GlobalDAOFactory.getDAO(ITecnologiaDAO.class, connectionBean);

		for (int i = 0; i < tecnologiaDAO.listToBuy(personaje.getId()).size(); i++) {
			tecnologiaPersonajeList.add((ITecnologiaPersonajeDO) //
					tecnologiaDAO.listToBuy(personaje.getId()));
		}

		connectionBean.getConnection().close();

		return tecnologiaPersonajeList;
	}

	public static TestTableModel asignarTecnologia(TestTableModel tableDtaModel,
			List<ITecnologiaPersonajeDO> tecnologiaPersonajeList) {

		for (int posicion = 0; posicion < tecnologiaPersonajeList.size(); posicion++) {
			tableDtaModel.add(tecnologiaPersonajeList.get(posicion));
		}
		return tableDtaModel;

	}

}
