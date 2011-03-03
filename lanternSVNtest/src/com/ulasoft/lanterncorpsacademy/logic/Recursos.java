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

	public static TestTableModel asignarRecursos(IPersonajeDO personaje, //
			TestTableModel tableDtaModel) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IRecursoDAO recursoDAO = (IRecursoDAO) //
				GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);

		IRecursoPersonajeDO recursoPersonajeDO;

		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);

		personajeDAO.loadRecursoPersonajeList(personaje);
		List<IRecursoPersonajeDO> recursoPersonajeList = //
			personaje.getRecursoPersonajeList();

		List<IRecursoPersonajeDO> listRecursoPersonaje = //
			new ArrayList<IRecursoPersonajeDO>();

		for (int i = 0; i < 8; i++) {

			recursoPersonajeDO = (IRecursoPersonajeDO) //
					GlobalDOFactory.getDO(IRecursoPersonajeDO.class);

			IRecursoDO recursoDO = (IRecursoDO) recursoDAO.loadById(i+1);

			Reference<IRecursoDO> recursoRef = new Reference<IRecursoDO>();
			recursoRef.setRefValue(recursoDO);
			recursoPersonajeDO.setRecursoRef(recursoRef);

			Reference<IPersonajeDO> personajeRef = new Reference<IPersonajeDO>();
			personajeRef.setRefValue(personaje);
			recursoPersonajeDO.setPersonajeRef(personajeRef);

			recursoPersonajeDO.setCantidad(0);

			listRecursoPersonaje.add(recursoPersonajeDO);

		}

		if (personaje.getRecursoPersonajeList().size() == 0) {

			for (int pos = 0; pos < listRecursoPersonaje.size(); pos++) {
				tableDtaModel.add(listRecursoPersonaje.get(pos));
			}
			return tableDtaModel;

		}

		for (int i = 0; i < listRecursoPersonaje.size(); i++) {

			for (int pos = 0; pos < recursoPersonajeList.size(); pos++) {

				if (listRecursoPersonaje.get(i).getRecursoRef().getRefIdent() == //
					recursoPersonajeList.get(pos).getRecursoRef().getRefIdent()) {

					listRecursoPersonaje.get(i).setCantidad( //
							recursoPersonajeList.get(pos).getCantidad());
					listRecursoPersonaje.get(i).setRecursoRef( //
							recursoPersonajeList.get(pos).getRecursoRef());
					listRecursoPersonaje.get(i).setPersonajeRef( //
							recursoPersonajeList.get(pos).getPersonajeRef());

				}

			}
		}

		for (int pos = 0; pos < listRecursoPersonaje.size(); pos++) {
			tableDtaModel.add(listRecursoPersonaje.get(pos));
		}

		connectionBean.getConnection().close();
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
