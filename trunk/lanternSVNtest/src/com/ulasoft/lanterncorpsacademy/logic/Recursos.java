package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IRecursoDAO;
import lcaInterfaceDAO.IRecursoDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.lantern.RecursoDAO;
import factory.GlobalDAOFactory;

public class Recursos {

	private IRecursoDO recurso;

	public Recursos() {

	}

	public static List<IRecursoDO> obtenerRecursos() throws Exception {

		IRecursoDO recurso;
		RecursoDAO recursoDAO = new RecursoDAO();
		List<IRecursoDO> recursos = new ArrayList<IRecursoDO>();
		
		for (int i = 1; i < 9; i++) {
			recurso = (IRecursoDO) recursoDAO.loadById(i);
			recursos.add(recurso);
		}

		return recursos;
	}

	public void guardarAtts() throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IRecursoDAO recursoDAO = (IRecursoDAO) GlobalDAOFactory.getDAO( //
				IRecursoDAO.class, connectionBean);

		recursoDAO.update(recurso);

		System.err.println("PERSONAJE ID en atts save:" + recurso.getId());

		ConnectionFactory.closeConnection(connectionBean.getConnection());

	}

	public static TestTableModel asignarRecursos(TestTableModel tableDtaModel, //
			List<IRecursoDO> recursos) {

		for (int posicion = 0; posicion < recursos.size(); posicion++) {
			(recursos.get(posicion)).setId(posicion + 1);
			tableDtaModel.add(recursos.get(posicion));
		}
		return tableDtaModel;
	}

//	public static TestTableModel asignarRecursos(TestTableModel tableDtaModel, //
//			List<String> recursos) {
//
//		for (int posicion = 1; posicion < recursos.size(); posicion++) {
//			recursos.get(posicion);
//			tableDtaModel.add(recursos.get(posicion));
//		}
//		return tableDtaModel;
//	}

}
