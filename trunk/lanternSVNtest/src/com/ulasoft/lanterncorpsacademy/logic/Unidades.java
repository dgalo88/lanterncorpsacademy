package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IAndroideDAO;
import lcaInterfaceDAO.IAndroideDO;
import lcaInterfaceDAO.IAndroidePersonajeDAO;
import lcaInterfaceDAO.IAndroidePersonajeDO;
import lcaInterfaceDAO.IAndroideRecursoDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IRecursoDAO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoPersonajeDAO;
import lcaInterfaceDAO.IRecursoPersonajeDO;
import lcaInterfaceDAO.ITecnologiaDAO;
import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.ITecnologiaPersonajeDO;
import lcaInterfaceDAO.IUnidadBasicaDAO;
import lcaInterfaceDAO.IUnidadBasicaDO;
import lcaInterfaceDAO.IUnidadBasicaPersonajeDAO;
import lcaInterfaceDAO.IUnidadBasicaPersonajeDO;
import lcaInterfaceDAO.IUnidadBasicaRecursoDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class Unidades {

	public static List<ITecnologiaDO> getUnidades(IPersonajeDO personaje) //
		throws Exception {

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
			connectionBean.getConnection().close();
			return null;
		}
		List<ITecnologiaPersonajeDO> tecnologiaPersonajeList = //
			personaje.getTecnologiaPersonajeList();

		for (int i = 0; i < tecnologiaPersonajeList.size(); i++) {

			ITecnologiaDO tecnologia = (ITecnologiaDO) //
				tecnologiaDAO.loadById(tecnologiaPersonajeList.get(i) //
						.getTecnologiaRef().getRefIdent());

			tecnologiaList.add(tecnologia);
		}

		connectionBean.getConnection().close();
		return tecnologiaList;

	}

	public static TestTableModel asignarUnidades(TestTableModel tableDtaModel, //
			List<ITecnologiaDO> tecnologiaList) {

		for (int posicion = 0; posicion < tecnologiaList.size(); posicion++) {
			tableDtaModel.add(tecnologiaList.get(posicion));
		}
		return tableDtaModel;

	}

	public static String getNombre(ITecnologiaDO tecnologia) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		String nombre = "";

		IUnidadBasicaDAO unidadBasicaDAO = (IUnidadBasicaDAO) //
				GlobalDAOFactory.getDAO(IUnidadBasicaDAO.class, connectionBean);
		IAndroideDAO androideDAO = (IAndroideDAO) //
				GlobalDAOFactory.getDAO(IAndroideDAO.class, connectionBean);

		try {
			IUnidadBasicaDO unidadBasica = (IUnidadBasicaDO) //
				unidadBasicaDAO.loadById(tecnologia.getId());
			nombre = unidadBasica.getNombre();
		} catch (Exception e) {
			IAndroideDO androide = (IAndroideDO) //
				androideDAO.loadById(tecnologia.getId()-32);
			nombre = androide.getNombre();
		}

		System.err.println("TECNOLOGIA ID en adquirir unidades: " + tecnologia.getId());
		connectionBean.getConnection().close();

		return nombre;
	}

	public static String getCostoUnidadBasicaString(ITecnologiaDO tecnologia) //
		throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		String costo = "";

		IUnidadBasicaDAO unidadBasicaDAO = (IUnidadBasicaDAO) //
				GlobalDAOFactory.getDAO(IUnidadBasicaDAO.class, connectionBean);
		IRecursoDAO recursoDAO = (IRecursoDAO) //
				GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);

		IUnidadBasicaDO unidadBasica = null;
		try {
			unidadBasica = (IUnidadBasicaDO) //
				unidadBasicaDAO.loadById(tecnologia.getId());
		} catch (Exception e) {
			//
		}

		unidadBasicaDAO.loadUnidadBasicaRecursoList(unidadBasica);

		List<IUnidadBasicaRecursoDO> unidadBasicaRecursoList = //
			new ArrayList<IUnidadBasicaRecursoDO>();
		List<IRecursoDO> recursoList = new ArrayList<IRecursoDO>();

		for (int i = 0; i < unidadBasica.getUnidadBasicaRecursoList().size(); i++) {

			IUnidadBasicaRecursoDO unidadBasicaRecurso = (IUnidadBasicaRecursoDO) //
					unidadBasica.getUnidadBasicaRecursoList().get(i);
			unidadBasicaRecursoList.add(unidadBasicaRecurso);

			IRecursoDO recursoDO = (IRecursoDO) //
			recursoDAO.loadById(unidadBasicaRecurso //
					.getRecursoRef().getRefIdent());
			recursoList.add(recursoDO);

		}

		for (int i = 0; i < unidadBasicaRecursoList.size(); i++) {

			costo += recursoList.get(i).getNombre() + ": " + //
					unidadBasicaRecursoList.get(i).getCantidad();

			if (i < unidadBasicaRecursoList.size() - 1) {
				costo += " + ";
			}
		}

		connectionBean.getConnection().close();
		return costo;

	}

	public static String getCostoAndroideString(ITecnologiaDO tecnologia) //
		throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		String costo = "";

		IAndroideDAO androideDAO = (IAndroideDAO) //
				GlobalDAOFactory.getDAO(IAndroideDAO.class, connectionBean);
		IRecursoDAO recursoDAO = (IRecursoDAO) //
				GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);

		IAndroideDO androide = null;
		try {
			androide = (IAndroideDO) //
				androideDAO.loadById(tecnologia.getId()-32);
		} catch (Exception e) {
			//
		}

		androideDAO.loadAndroideRecursoList(androide);

		List<IAndroideRecursoDO> androideRecursoList = //
			new ArrayList<IAndroideRecursoDO>();
		List<IRecursoDO> recursoList = new ArrayList<IRecursoDO>();

		for (int i = 0; i < androide.getAndroideRecursoList().size(); i++) {

			IAndroideRecursoDO androideRecurso = (IAndroideRecursoDO) //
					androide.getAndroideRecursoList().get(i);
			androideRecursoList.add(androideRecurso);

			IRecursoDO recursoDO = (IRecursoDO) //
			recursoDAO.loadById(androideRecurso //
					.getRecursoRef().getRefIdent());
			recursoList.add(recursoDO);

		}

		for (int i = 0; i < androideRecursoList.size(); i++) {

			costo += recursoList.get(i).getNombre() + ": " + //
					androideRecursoList.get(i).getCantidad();

			if (i < androideRecursoList.size() - 1) {
				costo += " + ";
			}
		}

		connectionBean.getConnection().close();
		return costo;

	}

	public static String adquirirUnidades(IPersonajeDO personaje, //
			ITecnologiaDO tecnologia) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		IUnidadBasicaDAO unidadBasicaDAO = (IUnidadBasicaDAO) //
				GlobalDAOFactory.getDAO(IUnidadBasicaDAO.class, connectionBean);
		IUnidadBasicaPersonajeDAO unidadBasicaPersonajeDAO = (IUnidadBasicaPersonajeDAO) //
				GlobalDAOFactory.getDAO(IUnidadBasicaPersonajeDAO.class, connectionBean);
		IRecursoDAO recursoDAO = (IRecursoDAO) //
				GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);
		IRecursoPersonajeDAO recursoPersonajeDAO = (IRecursoPersonajeDAO) //
				GlobalDAOFactory.getDAO(IRecursoPersonajeDAO.class, connectionBean);

		IUnidadBasicaPersonajeDO unidadBasicaPersonajeNueva = (IUnidadBasicaPersonajeDO) //
				GlobalDOFactory.getDO(IUnidadBasicaPersonajeDO.class);

		IUnidadBasicaDO unidadBasica = null;
		try {
			unidadBasica = (IUnidadBasicaDO) //
				unidadBasicaDAO.loadById(tecnologia.getId());
		} catch (Exception e) {
			//
		}

		Reference<IPersonajeDO> personajeRef = new Reference<IPersonajeDO>();
		IPersonajeDO personajeRefValue = (IPersonajeDO) //
				personajeDAO.loadById(personaje.getId());
		Reference<IUnidadBasicaDO> unidadBasicaRef = new Reference<IUnidadBasicaDO>();
		IUnidadBasicaDO unidadBasicaRefValue = (IUnidadBasicaDO) //
				unidadBasicaDAO.loadById(unidadBasica.getId());

		IRecursoDO recursoUnit;
		IRecursoDO recursoPer;

		unidadBasicaDAO.loadUnidadBasicaRecursoList(unidadBasica);
		List<IUnidadBasicaRecursoDO> unidadBasicaRecursoList = //
			unidadBasica.getUnidadBasicaRecursoList();

		personajeDAO.loadUnidadBasicaPersonajeList(personaje);
		List<IUnidadBasicaPersonajeDO> unidadBasicaPersonajeList = //
			personaje.getUnidadBasicaPersonajeList();

		personajeDAO.loadRecursoPersonajeList(personaje);
		List<IRecursoPersonajeDO> recursoPersonajeList = //
			personaje.getRecursoPersonajeList();

		if (recursoPersonajeList.size() == 0) {
			connectionBean.getConnection().close();
			return "No tienes suficientes recursos para adquirir las unidades";
		}

		for (int i = 0; i < unidadBasicaRecursoList.size(); i++) {

			recursoUnit = (IRecursoDO) recursoDAO.loadById( //
					unidadBasicaRecursoList.get(i).getRecursoRef().getRefIdent());

			for (int j = 0; j < recursoPersonajeList.size(); j++) {

				recursoPer = (IRecursoDO) recursoDAO.loadById( //
						recursoPersonajeList.get(j).getRecursoRef().getRefIdent());

				if (recursoUnit.getArticulo() != recursoPer.getArticulo()) {
					
					if (j == recursoPersonajeList.size() - 1) {
						connectionBean.getConnection().close();
						return "No tienes suficiente " + recursoUnit.getNombre() + //
								" para adquirir " + unidadBasica.getNombre();
					}
					continue;
				}

				if (unidadBasicaRecursoList.get(i).getCantidad() > //
					recursoPersonajeList.get(j).getCantidad()) {

					return "No tienes suficiente " + recursoUnit.getNombre() + //
							" para adquirir " + unidadBasica.getNombre();
				}

				recursoPersonajeList.get(j).setCantidad( //
						recursoPersonajeList.get(j).getCantidad() - //
						unidadBasicaRecursoList.get(i).getCantidad());

				break;
			}

		}

		personajeRef.setRefValue(personajeRefValue);
		unidadBasicaPersonajeNueva.setPersonajeRef(personajeRef);

		unidadBasicaRef.setRefValue(unidadBasicaRefValue);
		unidadBasicaPersonajeNueva.setUnidadBasicaRef(unidadBasicaRef);

		for (int i = 0; i < recursoPersonajeList.size(); i++) {
			recursoPersonajeDAO.update(recursoPersonajeList.get(i));
		}

		for (int i = 0; i < unidadBasicaPersonajeList.size(); i++) {

			if (unidadBasicaPersonajeList.get(i).getUnidadBasicaRef().getRefIdent() != //
				unidadBasicaPersonajeNueva.getUnidadBasicaRef().getRefIdent()) {

				if (i == unidadBasicaPersonajeList.size() - 1) {
					unidadBasicaPersonajeList.add(unidadBasicaPersonajeNueva);
					unidadBasicaPersonajeDAO.insert(unidadBasicaPersonajeNueva);					
				}

			} else {
				unidadBasicaPersonajeList.get(i).setCantidad( //
						unidadBasicaPersonajeList.get(i).getCantidad()+1);

				unidadBasicaPersonajeDAO.update(unidadBasicaPersonajeList.get(i));
				break;
			}
		}

		if (unidadBasicaPersonajeList.size() == 0) {
			unidadBasicaPersonajeNueva.setCantidad(1);
			unidadBasicaPersonajeList.add(unidadBasicaPersonajeNueva);
			unidadBasicaPersonajeDAO.insert(unidadBasicaPersonajeNueva);
		}

		personaje.setUnidadBasicaPersonajeList(unidadBasicaPersonajeList);

		personajeDAO.update(personaje);

		connectionBean.getConnection().close();

		return "Has Adquirido " + unidadBasica.getNombre() + " con éxito";

	}

	public static String adquirirAndroides(IPersonajeDO personaje, //
			ITecnologiaDO tecnologia) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		IAndroideDAO androideDAO = (IAndroideDAO) //
				GlobalDAOFactory.getDAO(IAndroideDAO.class, connectionBean);
		IAndroidePersonajeDAO androidePersonajeDAO = (IAndroidePersonajeDAO) //
				GlobalDAOFactory.getDAO(IAndroidePersonajeDAO.class, connectionBean);
		IRecursoDAO recursoDAO = (IRecursoDAO) //
				GlobalDAOFactory.getDAO(IRecursoDAO.class, connectionBean);
		IRecursoPersonajeDAO recursoPersonajeDAO = (IRecursoPersonajeDAO) //
				GlobalDAOFactory.getDAO(IRecursoPersonajeDAO.class, connectionBean);

		IAndroidePersonajeDO androidePersonajeNuevo = (IAndroidePersonajeDO) //
				GlobalDOFactory.getDO(IAndroidePersonajeDO.class);

		IAndroideDO androide = null;
		try {
			androide = (IAndroideDO) //
				androideDAO.loadById(tecnologia.getId()-32);
		} catch (Exception e) {
			//
		}

		Reference<IPersonajeDO> personajeRef = new Reference<IPersonajeDO>();
		IPersonajeDO personajeRefValue = (IPersonajeDO) //
				personajeDAO.loadById(personaje.getId());
		Reference<IAndroideDO> androideRef = new Reference<IAndroideDO>();
		IAndroideDO androideRefValue = (IAndroideDO) //
				androideDAO.loadById(androide.getId());

		IRecursoDO recursoAnd;
		IRecursoDO recursoPer;

		androideDAO.loadAndroideRecursoList(androide);
		List<IAndroideRecursoDO> androideRecursoList = //
			androide.getAndroideRecursoList();

		personajeDAO.loadAndroidePersonajeList(personaje);
		List<IAndroidePersonajeDO> androidePersonajeList = //
			personaje.getAndroidePersonajeList();

		personajeDAO.loadRecursoPersonajeList(personaje);
		List<IRecursoPersonajeDO> recursoPersonajeList = //
			personaje.getRecursoPersonajeList();

		if (recursoPersonajeList.size() == 0) {
			connectionBean.getConnection().close();
			return "No tienes suficientes recursos para adquirir las unidades";
		}

		for (int i = 0; i < androideRecursoList.size(); i++) {

			recursoAnd = (IRecursoDO) recursoDAO.loadById( //
					androideRecursoList.get(i).getRecursoRef().getRefIdent());

			for (int j = 0; j < recursoPersonajeList.size(); j++) {

				recursoPer = (IRecursoDO) recursoDAO.loadById( //
						recursoPersonajeList.get(j).getRecursoRef().getRefIdent());

				if (recursoAnd.getArticulo() != recursoPer.getArticulo()) {
					
					if (j == recursoPersonajeList.size() - 1) {
						connectionBean.getConnection().close();
						return "No tienes suficiente " + recursoAnd.getNombre() + //
								" para adquirir " + androide.getNombre();
					}
					continue;
				}

				if (androideRecursoList.get(i).getCantidad() > //
					recursoPersonajeList.get(j).getCantidad()) {

					return "No tienes suficiente " + recursoAnd.getNombre() + //
							" para adquirir " + androide.getNombre();
				}

				recursoPersonajeList.get(j).setCantidad( //
						recursoPersonajeList.get(j).getCantidad() - //
						androideRecursoList.get(i).getCantidad());

				break;
			}

		}

		personajeRef.setRefValue(personajeRefValue);
		androidePersonajeNuevo.setPersonajeRef(personajeRef);

		androideRef.setRefValue(androideRefValue);
		androidePersonajeNuevo.setAndroideRef(androideRef);

		androidePersonajeNuevo.setVidaMaxima(10);

		androidePersonajeNuevo.setVidaActual( //
				androidePersonajeNuevo.getVidaMaxima());

//		for (int i = 0; i < androidePersonajeList.size(); i++) {
//			if (androidePersonajeNuevo.getId() == androidePersonajeList.get(i).getId()) {
//
//				androidePersonajeList.get(i).setAndroideRef( //
//						androidePersonajeNuevo.getAndroideRef());
//				androidePersonajeList.get(i).setPersonajeRef( //
//						androidePersonajeNuevo.getPersonajeRef());
//				androidePersonajeList.get(i).setVidaMaxima( //
//						androidePersonajeNuevo.getVidaMaxima());
//				androidePersonajeList.get(i).setVidaActual( //
//						androidePersonajeNuevo.getVidaActual());
//			}
//		}

		androidePersonajeList.add(androidePersonajeNuevo);
		personaje.setAndroidePersonajeList(androidePersonajeList);

		for (int i = 0; i < recursoPersonajeList.size(); i++) {
			recursoPersonajeDAO.update(recursoPersonajeList.get(i));
		}

		androidePersonajeDAO.insert(androidePersonajeNuevo);
		personajeDAO.update(personaje);

		connectionBean.getConnection().close();

		return "Has Adquirido " + androide.getNombre() + " con éxito";

	}

}
