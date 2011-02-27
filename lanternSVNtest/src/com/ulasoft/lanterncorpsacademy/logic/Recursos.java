package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IRecursoDAO;
import lcaInterfaceDAO.IRecursoDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;

public class Recursos {

	public static List<IRecursoDO> getRecursos() throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		List<IRecursoDO> recursosList = new ArrayList<IRecursoDO>();

		IRecursoDAO recursoDAO = (IRecursoDAO) //
				GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);

		for (int i = 1; i < 9; i++) {
			IRecursoDO recurso = (IRecursoDO) //
					recursoDAO.loadById(i);
			recursosList.add(recurso);
		}

		connectionBean.getConnection().close();
		return recursosList;
	}

	public static TestTableModel asignarRecursos(TestTableModel tableDtaModel, //
			List<IRecursoDO> recursos) {

		for (int posicion = 0; posicion < recursos.size(); posicion++) {
			tableDtaModel.add(recursos.get(posicion));
		}
		return tableDtaModel;
	}

}
