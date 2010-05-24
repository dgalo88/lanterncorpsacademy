package com.ulasoft.lanterncorpsacademy.logic;

import lcaInterfaceDAO.IClaseLinternaDAO;
import lcaInterfaceDAO.IGrupoDAO;
import lcaInterfaceDAO.IHabilidadActivaDAO;
import lcaInterfaceDAO.IHabilidadClaseLinternaDAO;
import lcaInterfaceDAO.IHabilidadDAO;
import lcaInterfaceDAO.IMisionClaseLinternaDAO;
import lcaInterfaceDAO.IMisionDAO;
import lcaInterfaceDAO.IMisionPersonajeDAO;
import lcaInterfaceDAO.INivelHabilidadDAO;
import lcaInterfaceDAO.INpcDAO;
import lcaInterfaceDAO.IObjetivoDAO;
import lcaInterfaceDAO.IOrdenDAO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPlanetaDAO;
import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IUsuarioDAO;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.BD;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class inicializarBD {

	// Clases de linterna
	protected static final int VERDE = 0;
	protected static final int AMARILLO = 1;
	protected static final int ROJO = 2;
	protected static final int NEGRO = 3;
	protected static final int AZUL = 4;
	protected static final int INDIGO = 5;
	protected static final int VIOLETA = 6;


		
	public static void main(String[] nada) throws Exception {
		
		StringBuffer strbuf;
		strbuf = new StringBuffer();
		strbuf.append("CREATE DATABASE ");
		strbuf.append(BD.nombreBD());
		
		// Obtenemos la Conexion
		
		ConnectionBean connCreateDB = ConnectionFactory.getConnectionBean("connection_create_db.properties");
		strbuf = new StringBuffer();
		strbuf.append("DROP DATABASE IF EXISTS ");
		strbuf.append(BD.nombreBD());
		connCreateDB.getConnection().createStatement().execute(strbuf.toString());
		strbuf = new StringBuffer();
		strbuf.append("CREATE DATABASE ");
		strbuf.append(BD.nombreBD());
		connCreateDB.getConnection().createStatement().execute(strbuf.toString());
		ConnectionFactory.closeConnection(connCreateDB.getConnection());
		ConnectionBean conn = ConnectionFactory.getConnectionBean();

		// Instanciamos los DAO
		IUsuarioDAO UsuarioDAO = (IUsuarioDAO) GlobalDAOFactory.getDAO(IUsuarioDAO.class, conn);
		IPersonajeDAO PersonajeDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(IPersonajeDAO.class, conn);
		IMisionPersonajeDAO MisionPersonajeDAO = (IMisionPersonajeDAO) GlobalDAOFactory.getDAO(IMisionPersonajeDAO.class, conn);
		IClaseLinternaDAO ClaseLinternaDAO = (IClaseLinternaDAO) GlobalDAOFactory.getDAO(IClaseLinternaDAO.class, conn);
		IPlanetaDAO PlanetaDAO = (IPlanetaDAO) GlobalDAOFactory.getDAO(IPlanetaDAO.class, conn);
		IGrupoDAO GrupoDAO = (IGrupoDAO) GlobalDAOFactory.getDAO(IGrupoDAO.class, conn);
		IMisionDAO MisionDAO = (IMisionDAO) GlobalDAOFactory.getDAO(IMisionDAO.class, conn);
		IOrdenDAO OrdenDAO = (IOrdenDAO) GlobalDAOFactory.getDAO(IOrdenDAO.class, conn);
		IObjetivoDAO ObjetivoDAO = (IObjetivoDAO) GlobalDAOFactory.getDAO(IObjetivoDAO.class, conn);
		INpcDAO NpcDAO = (INpcDAO) GlobalDAOFactory.getDAO(INpcDAO.class, conn);
		IMisionClaseLinternaDAO MisionClaseLinternaDAO = (IMisionClaseLinternaDAO) GlobalDAOFactory.getDAO(IMisionClaseLinternaDAO.class, conn);
		IHabilidadDAO HabilidadDAO = (IHabilidadDAO) GlobalDAOFactory.getDAO(IHabilidadDAO.class, conn);
		IHabilidadClaseLinternaDAO HabilidadClaseLinternaDAO = (IHabilidadClaseLinternaDAO) GlobalDAOFactory.getDAO(IHabilidadClaseLinternaDAO.class, conn);
		IHabilidadActivaDAO HabilidadActivaDAO = (IHabilidadActivaDAO) GlobalDAOFactory.getDAO(IHabilidadActivaDAO.class, conn);
		INivelHabilidadDAO NivelHabilidadDAO = (INivelHabilidadDAO) GlobalDAOFactory.getDAO(INivelHabilidadDAO.class, conn);
		
		// creamos las tablas
		
		PlanetaDAO.createTable();
		MisionDAO.createTable();
		ClaseLinternaDAO.createTable();
		ObjetivoDAO.createTable();
		OrdenDAO.createTable();
		GrupoDAO.createTable();
		PersonajeDAO.createTable();
		UsuarioDAO.createTable();
		MisionPersonajeDAO.createTable();
		NpcDAO.createTable();
		MisionClaseLinternaDAO.createTable();
		HabilidadDAO.createTable();
		NivelHabilidadDAO.createTable();
		HabilidadActivaDAO.createTable();
		HabilidadClaseLinternaDAO.createTable();
		
		try {
			
			//PLANETAS

			
			IPlanetaDO PlanetaDO[] = new IPlanetaDO[7];
			
			
			for (int i = 0; i < 7; i++) {
				PlanetaDO[i] = (IPlanetaDO) GlobalDOFactory.getDO(IPlanetaDO.class);
			}

			// ********************************************

			PlanetaDO[VERDE].setNombre("Oa");
			PlanetaDO[AMARILLO].setNombre("Qward");
			PlanetaDO[ROJO].setNombre("Ysmault");
			PlanetaDO[NEGRO].setNombre("Ryut");
			PlanetaDO[AZUL].setNombre("Odym");
			PlanetaDO[INDIGO].setNombre("Aku");
			PlanetaDO[VIOLETA].setNombre("Zamaron");

			// ********************************************

			PlanetaDO[VERDE].setSector("0");
			PlanetaDO[AMARILLO].setSector("-1");
			PlanetaDO[ROJO].setSector("666");
			PlanetaDO[NEGRO].setSector("665");
			PlanetaDO[AZUL].setSector("2682");
			PlanetaDO[INDIGO].setSector("200");
			PlanetaDO[VIOLETA].setSector("1416");

			// ********************************************
			
			PlanetaDO[VERDE].setCoordenadaEnX(1);
			PlanetaDO[AMARILLO].setCoordenadaEnX(2);
			PlanetaDO[ROJO].setCoordenadaEnX(3);
			PlanetaDO[NEGRO].setCoordenadaEnX(4);
			PlanetaDO[AZUL].setCoordenadaEnX(5);
			PlanetaDO[INDIGO].setCoordenadaEnX(6);
			PlanetaDO[VIOLETA].setCoordenadaEnX(7);
			
			// ********************************************
			
			PlanetaDO[VERDE].setCoordenadaEnY(1);
			PlanetaDO[AMARILLO].setCoordenadaEnY(2);
			PlanetaDO[ROJO].setCoordenadaEnY(3);
			PlanetaDO[NEGRO].setCoordenadaEnY(4);
			PlanetaDO[AZUL].setCoordenadaEnY(5);
			PlanetaDO[INDIGO].setCoordenadaEnY(6);
			PlanetaDO[VIOLETA].setCoordenadaEnY(7);

			
			// INSERT PLANETA
			for (int i = 0; i < 7; i++) {
				PlanetaDAO.insert(PlanetaDO[i]);
			}

		} finally {
			// Cerramos la Conexion
			ConnectionFactory.closeConnection(conn.getConnection());
		}

	}

}
