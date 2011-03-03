package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IRecursoDAO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoPersonajeDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class Recursos {

	public static List<IRecursoPersonajeDO> getRecursos(IPersonajeDO personaje) //
		throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		IRecursoDAO recursoDAO = (IRecursoDAO) //
				GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);

		IRecursoPersonajeDO recursoPersonajeDO = (IRecursoPersonajeDO) //
				GlobalDOFactory.getDO(IRecursoPersonajeDO.class);

		int cantidad = 0;

		personajeDAO.loadRecursoPersonajeList(personaje);
		List<IRecursoPersonajeDO> recursoPersonajeList = //
			new ArrayList<IRecursoPersonajeDO>();

		for (int i = 1; i < 9; i++) {

			IRecursoDO recurso = (IRecursoDO) recursoDAO.loadById(i);

			for (int j = 0; j < personaje.getRecursoPersonajeList().size(); j++) {

				if (recurso.getArticulo() == //
					recursoPersonajeList.get(j).getRecursoRef().getRefIdent()) {

					cantidad = personaje.getRecursoPersonajeList().get(j).getCantidad();
				}
			}

			Reference<IRecursoDO> refRecurso = new Reference<IRecursoDO>();
			refRecurso.setRefValue(recurso);

			Reference<IPersonajeDO> refPersonaje = new Reference<IPersonajeDO>();
			refPersonaje.setRefValue(personaje);

			recursoPersonajeDO.setRecursoRef(refRecurso);
			recursoPersonajeDO.setPersonajeRef(refPersonaje);
			recursoPersonajeDO.setCantidad(cantidad);

			recursoPersonajeList.add(recursoPersonajeDO);

		}

		connectionBean.getConnection().close();
		return recursoPersonajeList;

	}

	public static TestTableModel asignarRecursos(TestTableModel tableDtaModel, //
			List<IRecursoPersonajeDO> recursoPersonajeList) {

		for (int pos = 0; pos < recursoPersonajeList.size(); pos++) {
			tableDtaModel.add(recursoPersonajeList.get(pos));
		}
		return tableDtaModel;
	}

	public static String getNombreRecurso(IRecursoPersonajeDO recursoPersonaje) //
		throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IRecursoDAO recursoDAO = (IRecursoDAO) //
				GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);

		IRecursoDO recurso = (IRecursoDO) recursoDAO.loadById( //
				recursoPersonaje.getRecursoRef().getRefIdent());

		connectionBean.getConnection().close();
		return recurso.getNombre();
	}

}
