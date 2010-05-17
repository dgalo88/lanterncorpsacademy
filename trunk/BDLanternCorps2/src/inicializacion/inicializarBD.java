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
import dao.lca.UsuarioDAO;

public class inicializarBD {
	
	//Clases de linterna
	protected static final int VERDE = 0;
	protected static final int AMARILLO = 1;
	protected static final int ROJO = 2;
	protected static final int NEGRO = 3;
	protected static final int AZUL = 4;
	protected static final int INDIGO = 5;
	protected static final int VIOLETA = 6;
	
	public static void main(String[] nada) throws Exception {
		
		// Obtenemos la Conexion
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
        InterfaceDAO MisionClaseLinternaDAO = FactoryDAO.getDAO(MisionClaseLinternaDAO.class,conn);
        InterfaceDAO HabilidadDAO = FactoryDAO.getDAO(HabilidadDAO.class, conn);
        InterfaceDAO HabilidadClaseLinternaDAO = FactoryDAO.getDAO(HabilidadClaseLinternaDAO.class, conn);
        InterfaceDAO HabilidadActivaDAO = FactoryDAO.getDAO(HabilidadActivaDAO.class, conn);
        InterfaceDAO NivelHabilidadDAO = FactoryDAO.getDAO(NivelHabilidadDAO.class, conn);
		
        //creamos las tablas
        UsuarioDAO.createTable();
        PersonajeDAO.createTable();
        MisionPersonajeDAO.createTable();
        ClaseLinternaDAO.createTable();
        PlanetaDAO.createTable();
        GrupoDAO.createTable();
        MisionDAO.createTable();
        OrdenDAO.createTable();
        ObjetivoDAO.createTable();
        NpcDAO.createTable();
        MisionClaseLinternaDAO.createTable();
        HabilidadDAO.createTable();
        HabilidadClaseLinternaDAO.createTable();
        HabilidadActivaDAO.createTable();
        NivelHabilidadDAO.createTable();
        
        try { 
        	
        } finally {
            // Cerrar Conexion
            ConnectionFactory.closeConnection(conn.getConnection());
    }
        
	}

}
