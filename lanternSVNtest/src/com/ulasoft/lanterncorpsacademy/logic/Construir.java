package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUnidadBasicaDAO;
import lcaInterfaceDAO.IUnidadBasicaDO;
import lcaInterfaceDAO.IUnidadBasicaPersonajeDAO;
import lcaInterfaceDAO.IUnidadEjercitoDAO;
import lcaInterfaceDAO.IUnidadEjercitoDO;
import lcaInterfaceDAO.IUnidadEjercitoPersonajeDAO;
import lcaInterfaceDAO.IUnidadEjercitoPersonajeDO;

import com.ulasoft.lanterncorpsacademy.paneles.PanelConstruir;

import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class Construir {

	

	public static void construir(PanelConstruir construir, IPersonajeDO personaje) //
		throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPersonajeDAO personajeDAO = (IPersonajeDAO) //
				GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		IUnidadBasicaDAO unidadBasicaDAO = (IUnidadBasicaDAO) //
				GlobalDAOFactory.getDAO(IUnidadBasicaDAO.class, connectionBean);
		IUnidadBasicaPersonajeDAO unidadBasicaPersonajeDAO = (IUnidadBasicaPersonajeDAO) //
				GlobalDAOFactory.getDAO(IUnidadBasicaPersonajeDAO.class, connectionBean);
		IUnidadEjercitoDAO unidadEjercitoDAO = (IUnidadEjercitoDAO) //
				GlobalDAOFactory.getDAO(IUnidadEjercitoDAO.class, connectionBean);
		IUnidadEjercitoPersonajeDAO unidadEjercitoPersonajeDAO = (IUnidadEjercitoPersonajeDAO) //
				GlobalDAOFactory.getDAO(IUnidadEjercitoPersonajeDAO.class, connectionBean);

		IUnidadEjercitoDO unidadEjercito = (IUnidadEjercitoDO) //
				GlobalDOFactory.getDO(IUnidadEjercitoDO.class);
		IUnidadEjercitoPersonajeDO unidadEjercitoPersonaje = (IUnidadEjercitoPersonajeDO) //
				GlobalDOFactory.getDO(IUnidadEjercitoPersonajeDO.class);

		List<IUnidadEjercitoPersonajeDO> unidadEjercitoPersonajeList = //
			new ArrayList<IUnidadEjercitoPersonajeDO>();

		Reference<IUnidadBasicaDO> robotRef = new Reference<IUnidadBasicaDO>();
		IUnidadBasicaDO robotRefValue = (IUnidadBasicaDO) //
				unidadBasicaDAO.loadById(construir.getRobot().getId());
		robotRef.setRefValue(robotRefValue);
		unidadEjercito.setUnidadBasicaRobotRef(robotRef);

		Reference<IUnidadBasicaDO> armaRef = new Reference<IUnidadBasicaDO>();
		IUnidadBasicaDO armaRefValue = (IUnidadBasicaDO) //
				unidadBasicaDAO.loadById(construir.getArma().getId());
		armaRef.setRefValue(armaRefValue);
		unidadEjercito.setUnidadBasicaRobotRef(armaRef);

		Reference<IUnidadBasicaDO> vehiculoRef = new Reference<IUnidadBasicaDO>();
		IUnidadBasicaDO vehiculoRefValue = (IUnidadBasicaDO) //
				unidadBasicaDAO.loadById(construir.getVehiculo().getId());
		vehiculoRef.setRefValue(vehiculoRefValue);
		unidadEjercito.setUnidadBasicaVehiculoRef(vehiculoRef);

		Reference<IUnidadBasicaDO> balaRef = new Reference<IUnidadBasicaDO>();
		IUnidadBasicaDO balaRefValue = (IUnidadBasicaDO) //
				unidadBasicaDAO.loadById(construir.getBala().getId());
		balaRef.setRefValue(balaRefValue);
		unidadEjercito.setUnidadBasicaBalaRef(balaRef);

		Reference<IPersonajeDO> personajeRef = new Reference<IPersonajeDO>();
		IPersonajeDO personajeRefValue = (IPersonajeDO) //
				personajeDAO.loadById(personaje.getId());
		personajeRef.setRefValue(personajeRefValue);
		unidadEjercitoPersonaje.setPersonajeRef(personajeRef);

		Reference<IUnidadEjercitoDO> unidadEjercitoRef = //
			new Reference<IUnidadEjercitoDO>();
		unidadEjercitoRef.setRefValue(unidadEjercito);
		unidadEjercitoPersonaje.setUnidadEjercitoRef(unidadEjercitoRef);

		int vidaMaxima = construir.getRobot().getDefensa() //
					+ construir.getVehiculo().getDefensa();

		unidadEjercitoPersonaje.setVidaMaxima(vidaMaxima);

		unidadEjercitoPersonajeDAO.insert(unidadEjercitoPersonaje);

		unidadEjercito.getUnidadEjercitoPersonajeList() //
				.add(unidadEjercitoPersonaje);

		construir.setUnidadEjercito(unidadEjercito);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

	}

}
