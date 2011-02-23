package com.ulasoft.lanterncorpsacademy.logic;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDAO;
import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IRecursoPlanetaDAO;
import lcaInterfaceDAO.IRecursoPlanetaDO;

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

//		System.err.println("list: " + planeta.getRecursoPlanetaList());
//		System.err.println("list 1: " + planeta.getRecursoPlanetaList().get(0).getId());
//		System.err.println("list 2: " + planeta.getRecursoPlanetaList().get(1).getId());

		IRecursoPlanetaDAO recursoPlanetaDAO = (IRecursoPlanetaDAO) //
				GlobalDAOFactory.getDAO(IRecursoPlanetaDAO.class, connectionBean);
		IRecursoPlanetaDO recursoPlanetaDO1 = (IRecursoPlanetaDO) //
				recursoPlanetaDAO.loadById((planeta.getId() * 2) - 1);
		IRecursoPlanetaDO recursoPlanetaDO2 = (IRecursoPlanetaDO) //
				recursoPlanetaDAO.loadById(planeta.getId() * 2);

		tableDtaModel.add(recursoPlanetaDO1);
		tableDtaModel.add(recursoPlanetaDO2);

		connectionBean.getConnection().close();

		return tableDtaModel;

	}

	public static TestTableModel getCantidadMaximaDisponible( //
			IPersonajeDO personaje, TestTableModel tableDtaModel) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPlanetaDAO planetaDAO = (IPlanetaDAO) //
				GlobalDAOFactory.getDAO(IPlanetaDAO.class, connectionBean);
		IPlanetaDO planeta = (IPlanetaDO) //
				planetaDAO.loadById(personaje.getPlanetaRef().getRefIdent());

		IRecursoPlanetaDAO recursoPlanetaDAO = (IRecursoPlanetaDAO) //
				GlobalDAOFactory.getDAO(IRecursoPlanetaDAO.class, connectionBean);
		IRecursoPlanetaDO recursoPlanetaDO1 = (IRecursoPlanetaDO) //
				recursoPlanetaDAO.loadById((planeta.getId() * 2) - 1);
		IRecursoPlanetaDO recursoPlanetaDO2 = (IRecursoPlanetaDO) //
				recursoPlanetaDAO.loadById(planeta.getId() * 2);

		tableDtaModel.add(recursoPlanetaDO1);
		tableDtaModel.add(recursoPlanetaDO2);

		connectionBean.getConnection().close();

		return tableDtaModel;

	}

}
