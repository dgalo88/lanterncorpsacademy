package inicializacion;

import dao.api.FactoryDAO;
import dao.api.InterfaceDAO;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.lca.ClaseLinternaDAO;
import dao.lca.GrupoDAO;
import dao.lca.HabilidadActivaDAO;
import dao.lca.HabilidadClaseLinternaDAO;
import dao.lca.HabilidadDAO;
import dao.lca.MisionClaseLinternaDAO;
import dao.lca.MisionDAO;
import dao.lca.MisionPersonajeDAO;
import dao.lca.NivelHabilidadDAO;
import dao.lca.NpcDAO;
import dao.lca.ObjetivoDAO;
import dao.lca.OrdenDAO;
import dao.lca.PersonajeDAO;
import dao.lca.PlanetaDAO;
import dao.lca.PlanetaDO;
import dao.lca.UsuarioDAO;

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
		
		// Obtenemos la Conexion
		ConnectionBean connCreateDB = ConnectionFactory.getConnectionBean("connection_create_db.properties");

		connCreateDB.getConnection().createStatement().execute("DROP DATABASE IF EXISTS lca");
		connCreateDB.getConnection().createStatement().execute("CREATE DATABASE lca");

		ConnectionFactory.closeConnection(connCreateDB.getConnection());

		ConnectionBean conn = ConnectionFactory.getConnectionBean();

		// Instanciamos los DAO
		InterfaceDAO UsuarioDAO = FactoryDAO.getDAO(UsuarioDAO.class, conn);
		InterfaceDAO PersonajeDAO = FactoryDAO.getDAO(PersonajeDAO.class, conn);
		InterfaceDAO MisionPersonajeDAO = FactoryDAO.getDAO(MisionPersonajeDAO.class, conn);
		InterfaceDAO ClaseLinternaDAO = FactoryDAO.getDAO(ClaseLinternaDAO.class, conn);
		InterfaceDAO PlanetaDAO = FactoryDAO.getDAO(PlanetaDAO.class, conn);
		InterfaceDAO GrupoDAO = FactoryDAO.getDAO(GrupoDAO.class, conn);
		InterfaceDAO MisionDAO = FactoryDAO.getDAO(MisionDAO.class, conn);
		InterfaceDAO OrdenDAO = FactoryDAO.getDAO(OrdenDAO.class, conn);
		InterfaceDAO ObjetivoDAO = FactoryDAO.getDAO(ObjetivoDAO.class, conn);
		InterfaceDAO NpcDAO = FactoryDAO.getDAO(NpcDAO.class, conn);
		InterfaceDAO MisionClaseLinternaDAO = FactoryDAO.getDAO(MisionClaseLinternaDAO.class, conn);
		InterfaceDAO HabilidadDAO = FactoryDAO.getDAO(HabilidadDAO.class, conn);
		InterfaceDAO HabilidadClaseLinternaDAO = FactoryDAO.getDAO(	HabilidadClaseLinternaDAO.class, conn);
		InterfaceDAO HabilidadActivaDAO = FactoryDAO.getDAO(HabilidadActivaDAO.class, conn);
		InterfaceDAO NivelHabilidadDAO = FactoryDAO.getDAO(NivelHabilidadDAO.class, conn);

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

			PlanetaDO PlanetaDO[] = new PlanetaDO[7];
			for (int i = 0; i < 7; i++) {
				PlanetaDO[i] = new PlanetaDO();
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
