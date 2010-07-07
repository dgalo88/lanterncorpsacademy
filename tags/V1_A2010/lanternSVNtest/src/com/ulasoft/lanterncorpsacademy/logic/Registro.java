package com.ulasoft.lanterncorpsacademy.logic;

import java.sql.SQLException;
import java.util.List;

import lcaInterfaceDAO.IClaseLinternaDAO;
import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IHabilidadActivaDAO;
import lcaInterfaceDAO.IHabilidadActivaDO;
import lcaInterfaceDAO.IHabilidadDAO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUsuarioDAO;
import lcaInterfaceDAO.IUsuarioDO;
import dao.api.DataObject;
import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class Registro {
	
	public static void guardarUsuario(IUsuarioDO usuario, IPersonajeDO personaje, String optClase) throws ClassNotFoundException, Exception {
		
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IUsuarioDAO usDAO = (IUsuarioDAO) GlobalDAOFactory.getDAO(IUsuarioDAO.class, connectionBean);
		IPersonajeDAO perDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		IClaseLinternaDAO clDAO = (IClaseLinternaDAO) GlobalDAOFactory.getDAO(IClaseLinternaDAO.class, connectionBean);
		IHabilidadDAO habDAO = (IHabilidadDAO) GlobalDAOFactory.getDAO(IHabilidadDAO.class, connectionBean);
		IHabilidadActivaDAO habActDAO = (IHabilidadActivaDAO) GlobalDAOFactory.getDAO(IHabilidadActivaDAO.class, connectionBean);

		Reference<IClaseLinternaDO> refc = new Reference<IClaseLinternaDO>();

		IClaseLinternaDO clase = clDAO.loadByColor(optClase);

		refc.setRefIdent(clase.getId());

		
		personaje.setClaseLinternaRef(refc);
		personaje.setPlanetaRef(clase.getPlanetaRef());

		perDAO.insert(personaje);

		IPersonajeDO pers = perDAO.loadByAlias(personaje.getAlias());
		Reference<IPersonajeDO> refper = new Reference<IPersonajeDO>();
		refper.setRefIdent(pers.getId());
		
		// Relacionando al personaje con sus habilidades iniciales.
		List<DataObject> habInic = habDAO.listHabIniciales(clase.getId());
		
		for (int i = 0; i < (habInic.size()); i++) {
			
			IHabilidadActivaDO habActiva = (IHabilidadActivaDO) GlobalDOFactory
			.getDO(IHabilidadActivaDO.class);
			
			habActiva.setNivel_habilidad(1);
			Reference<IHabilidadDO> href = new Reference<IHabilidadDO>();
			href.setRefIdent(habInic.get(i).getId());
			habActiva.setHabilidadRef(href);
//			Reference<IPersonajeDO> persoRef = new Reference<IPersonajeDO>();
//			persoRef.setRefIdent(personaje.getId());
			habActiva.setPersonajeRef(refper);
			
			habActDAO.insert(habActiva);
			
			personaje.getHabilidadActivaList().add(habActiva);
			
		}
		usuario.setPersonajeRef(refper);
		usDAO.insert(usuario);
		
		connectionBean.getConnection().close();


	}
	
	public static boolean verificarAlias(String alias) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPersonajeDAO usuarioDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(
				IPersonajeDAO.class, connectionBean);
		try {

			if (usuarioDAO.checkIfAliasExists(alias)) {
				return true;
			} else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		connectionBean.getConnection().close();
		return false;

	}
	
	public static boolean verificarCorreo (String correo) throws Exception {
		
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IUsuarioDAO usuarioDAO = (IUsuarioDAO) GlobalDAOFactory.getDAO(IUsuarioDAO.class, connectionBean);

		try {

			if (usuarioDAO.checkIfUsuarioExists(correo)) {
				return true;
			}
			else 
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connectionBean.getConnection().close();
		return false;
	}

}
