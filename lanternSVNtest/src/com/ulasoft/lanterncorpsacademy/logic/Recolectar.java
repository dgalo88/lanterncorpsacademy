package com.ulasoft.lanterncorpsacademy.logic;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDAO;
import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IRecursoDAO;
import lcaInterfaceDAO.IRecursoDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;

public class Recolectar {

	public static TestTableModel getRecursosPlaneta(IPersonajeDO personaje, //
			TestTableModel tableDtaModel) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPlanetaDAO planetaDAO = (IPlanetaDAO) //
				GlobalDAOFactory.getDAO(IPlanetaDAO.class, connectionBean);
		IPlanetaDO planeta = (IPlanetaDO) //
				planetaDAO.loadById(personaje.getPlanetaRef().getRefIdent());
		IRecursoDAO recursoDAO = (IRecursoDAO) //
				GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);

		for (int i = 0; i < 2; i++) {

			IRecursoDO recursoDO = (IRecursoDO) //
				recursoDAO.loadById(planeta.getRecursoPlanetaList().get(i) //
						.getRecursoRef().getRefIdent());
			tableDtaModel.add(recursoDO);

		}

		connectionBean.getConnection().close();
		return tableDtaModel;

	}


}
