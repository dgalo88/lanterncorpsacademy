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

	public static List<IRecursoPlanetaDO> getRecursosPlaneta( //
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

	public static void recolectar(IPersonajeDO personaje, //
			IRecursoPlanetaDO recursoPlanetaDO) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		IRecursoPersonajeDAO recursoPersonajeDAO = (IRecursoPersonajeDAO) //
				GlobalDAOFactory.getDAO(IRecursoPersonajeDAO.class, connectionBean);
		IRecursoPersonajeDO recursoPersonaje = (IRecursoPersonajeDO) //
				GlobalDOFactory.getDO(IRecursoPersonajeDO.class);

		personajeDAO.loadRecursoPersonajeList(personaje);
		List<IRecursoPersonajeDO> recursoPersonajeList = personaje.getRecursoPersonajeList();

		int cantidadRecurso = recursoPlanetaDO.getCantidad_maxima_recurso() / 24;

		for (int i = 0; i < recursoPersonajeList.size(); i++) {

			if(recursoPlanetaDO.getRecursoRef().getRefIdent() == //
				recursoPersonajeList.get(i).getRecursoRef().getRefIdent()) {

				recursoPersonaje = recursoPersonajeList.get(i);
				cantidadRecurso += recursoPersonajeList.get(i).getCantidad();
			}
		}

		Reference<IPersonajeDO> refPersonaje = new Reference<IPersonajeDO>();
		refPersonaje.setRefIdent(personaje.getId());
		recursoPersonaje.setPersonajeRef(refPersonaje);

		Reference<IRecursoDO> refRecurso = new Reference<IRecursoDO>();
		refRecurso.setRefIdent(recursoPlanetaDO.getRecursoRef().getRefIdent());
		recursoPersonaje.setRecursoRef(refRecurso);

		recursoPersonaje.setCantidad(cantidadRecurso);

		if (recursoPersonajeDAO.loadById(recursoPersonaje.getId()) != null) {
			recursoPersonajeDAO.update(recursoPersonaje);
		} else {
			recursoPersonajeDAO.insert(recursoPersonaje);
		}

		recursoPersonajeList.add(recursoPersonaje);
		personaje.setRecursoPersonajeList(recursoPersonajeList);

		personajeDAO.update(personaje);

		connectionBean.getConnection().close();

	}

	public static void recolectarRecursoList(IPersonajeDO personaje, //
			List<IRecursoPlanetaDO> recursoPlanetaList) throws Exception {

		for (int i = 0; i < recursoPlanetaList.size(); i++) {
			recolectar(personaje, recursoPlanetaList.get(i));
		}

	}

}
