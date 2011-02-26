package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDAO;
import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IRecursoDAO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoPersonajeDAO;
import lcaInterfaceDAO.IRecursoPersonajeDO;
import lcaInterfaceDAO.IRecursoPlanetaDAO;
import lcaInterfaceDAO.IRecursoPlanetaDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;

public class Recolectar {

	public static List<IRecursoPlanetaDO> getRecursosPlaneta( //
			IPersonajeDO personaje) throws Exception {

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

		List<IRecursoPlanetaDO> recursoPlanetaList = new ArrayList<IRecursoPlanetaDO>();
		recursoPlanetaList.add(recursoPlanetaDO1);
		recursoPlanetaList.add(recursoPlanetaDO2);

		connectionBean.getConnection().close();
		return recursoPlanetaList;

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

	@SuppressWarnings("deprecation")
	public static void recolectar(IPersonajeDO personaje, //
			IRecursoPlanetaDO recursoPlanetaDO, Calendar dateInit) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		Calendar dateActual = Calendar.getInstance();
		dateActual.getTime().getMinutes();

		IPlanetaDAO planetaDAO = (IPlanetaDAO) //
				GlobalDAOFactory.getDAO(IPlanetaDAO.class, connectionBean);
		IPlanetaDO planeta = (IPlanetaDO) //
				planetaDAO.loadById(personaje.getPlanetaRef().getRefIdent());

		IRecursoDAO recursoDAO = (IRecursoDAO) //
				GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);
		IRecursoDO recurso = (IRecursoDO) //
				recursoDAO.loadById(recursoPlanetaDO.getRecursoRef().getRefIdent());

		IRecursoPersonajeDAO recursoPersonajeDAO = (IRecursoPersonajeDAO) //
				GlobalDAOFactory.getDAO(IRecursoPersonajeDAO.class, connectionBean);

		if (dateActual.getTime().getHours() - dateInit.getTime().getHours() < 1) {

			

		}


		connectionBean.getConnection().close();

	}

}
