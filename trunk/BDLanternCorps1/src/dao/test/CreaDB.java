package dao.test;

import dao.api.FactoryDAO;
import dao.api.InterfaceDAO;
import dao.api.BaseDAO;
import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.lantern.ClaseLinternaDAO;
import dao.lantern.ClaseLinternaDO;
import dao.lantern.GrupoDAO;
import dao.lantern.HabilidadActivaDAO;
import dao.lantern.HabilidadClaseLinternaDAO;
import dao.lantern.HabilidadDAO;
import dao.lantern.MisionClaseLinternaDAO;
import dao.lantern.MisionDAO;
import dao.lantern.MisionDO;
import dao.lantern.MisionPersonajeDAO;
import dao.lantern.NivelHabilidadDAO;
import dao.lantern.NpcDAO;
import dao.lantern.ObjetivoDAO;
import dao.lantern.ObjetivoDO;
import dao.lantern.OrdenDAO;
import dao.lantern.OrdenDO;
import dao.lantern.PersonajeDAO;
import dao.lantern.PlanetaDAO;
import dao.lantern.PlanetaDO;
import dao.lantern.UsuarioDAO;



public class CreaDB {

	protected static final int VERDE = 0;
	protected static final int AMARILLO = 1;
	protected static final int ROJO = 2;
	protected static final int NEGRO = 3;
	protected static final int AZUL = 4;
	protected static final int INDIGO = 5;
	protected static final int VIOLETA = 6;

    public static void main(String[] args) throws Exception {

            // Obtener Conexion
            ConnectionBean conn = ConnectionFactory.getConnectionBean();

            // Instanciar DAO
            InterfaceDAO uDAO = FactoryDAO.getDAO(UsuarioDAO.class, conn);
            InterfaceDAO pDAO = FactoryDAO.getDAO(PersonajeDAO.class, conn);
            InterfaceDAO pmDAO = FactoryDAO.getDAO(MisionPersonajeDAO.class, conn);
            InterfaceDAO cDAO = FactoryDAO.getDAO(ClaseLinternaDAO.class, conn);
            InterfaceDAO plDAO = FactoryDAO.getDAO(PlanetaDAO.class, conn);
            InterfaceDAO gDAO = FactoryDAO.getDAO(GrupoDAO.class, conn);
            InterfaceDAO mDAO = FactoryDAO.getDAO(MisionDAO.class, conn);
            InterfaceDAO oDAO = FactoryDAO.getDAO(OrdenDAO.class, conn);
            InterfaceDAO obDAO = FactoryDAO.getDAO(ObjetivoDAO.class, conn);
            InterfaceDAO npcDAO = FactoryDAO.getDAO(NpcDAO.class, conn);
            InterfaceDAO mcDAO = FactoryDAO.getDAO(MisionClaseLinternaDAO.class,
                            conn);
            InterfaceDAO hDAO = FactoryDAO.getDAO(HabilidadDAO.class, conn);
            InterfaceDAO hcDAO = FactoryDAO.getDAO(HabilidadClaseLinternaDAO.class, conn);
            InterfaceDAO haDAO = FactoryDAO.getDAO(HabilidadActivaDAO.class, conn);
            InterfaceDAO nhDAO = FactoryDAO.getDAO(NivelHabilidadDAO.class, conn);

           
            // CREATE TABLE
            plDAO.createTable();
            mDAO.createTable();
            cDAO.createTable();
            obDAO.createTable();
            oDAO.createTable();
            gDAO.createTable();
            pDAO.createTable();
            uDAO.createTable(); 
            pmDAO.createTable();

            npcDAO.createTable();
            mcDAO.createTable();
            hDAO.createTable(); 
            nhDAO.createTable();
            haDAO.createTable();
            hcDAO.createTable();

            try {

                    // CREATE PLANETADO
                    PlanetaDO pldo[] = new PlanetaDO[7];
                    for (int i = 0; i < 7; i++) {
                            pldo[i] = new PlanetaDO();
                    }

                    pldo[VERDE].setNombre("Oa");
                    pldo[AMARILLO].setNombre("Qward");
                    pldo[ROJO].setNombre("Ysmault");
                    pldo[NEGRO].setNombre("Ryut");
                    pldo[AZUL].setNombre("Odym");
                    pldo[INDIGO].setNombre("desconocido");
                    pldo[VIOLETA].setNombre("Zamaron");

                    pldo[VERDE].setSector("0");
                    pldo[AMARILLO].setSector("-1");
                    pldo[ROJO].setSector("666");
                    pldo[NEGRO].setSector("665");
                    pldo[AZUL].setSector("1");
                    pldo[INDIGO].setSector("200");
                    pldo[VIOLETA].setSector("1416");

//                    pldo[ROJO].setCoordenadaEnX(1);
//                    pldo[AZUL].setCoordenadaEnX(2);
//                    pldo[AMARILLO].setCoordenadaEnX(3);
//                    pldo[VERDE].setCoordenadaEnX(4);
//
//                    pldo[ROJO].setCoordenadaEnY(1);
//                    pldo[AZUL].setCoordenadaEnY(2);
//                    pldo[AMARILLO].setCoordenadaEnY(3);
//                    pldo[VERDE].setCoordenadaEnY(4);

                    // INSERT PLANETA
                    for (int i = 0; i < 7; i++) {
                    	pldo[i].setCoordenadaEnX(2*i);
                    	pldo[i].setCoordenadaEnY(3*i);
                    	plDAO.insert(pldo[i]);
                    }
                    StringBuffer str = new StringBuffer();
                    PlanetaDO pldo2[] = new PlanetaDO[14];
                    for (int i = 0; i < 14; i++) {
                            str.append(i + 4);
                            pldo2[i] = new PlanetaDO();
                            pldo2[i].setNombre(str.toString());
                            pldo2[i].setSector("2");
                            pldo2[i].setCoordenadaEnX(i + 4);
                            pldo2[i].setCoordenadaEnY(i + 4);
                            plDAO.insert(pldo2[i]);
                    }

                    // CREATE CLASELINTERNA
                    ClaseLinternaDO cdo[] = new ClaseLinternaDO[7];
                    for (int i = 0; i < 7; i++) {
                            cdo[i] = new ClaseLinternaDO();
                    }
                    cdo[VERDE].setColor("Verde");
                    cdo[AMARILLO].setColor("Amarillo");
                    cdo[ROJO].setColor("Rojo");
                    cdo[AZUL].setColor("Azul");
                    cdo[NEGRO].setColor("Negro");
                    cdo[INDIGO].setColor("Indigo");
                    cdo[VIOLETA].setColor("Violeta");

                    cdo[VERDE].setNombreDeCuerpoLinterna("Green Lantern Corps");
                    cdo[AMARILLO].setNombreDeCuerpoLinterna("Sinestro Corps");
                    cdo[ROJO].setNombreDeCuerpoLinterna("Red Lantern Corps");
                    cdo[AZUL].setNombreDeCuerpoLinterna("Blue Lantern Corps");
                    cdo[NEGRO].setNombreDeCuerpoLinterna("Black Lantern Corps");
                    cdo[INDIGO].setNombreDeCuerpoLinterna("Tribu Indigo");
                    cdo[VIOLETA].setNombreDeCuerpoLinterna("Star Sapphires");

                    // CREATE REFERENCE TO PLANETA AND INSERT CLASELINTERNA
                    Reference<PlanetaDO> refpl;
                    for (int i = 0; i < 6; i++) {
                            refpl = new Reference<PlanetaDO>();
                            refpl.setRefIdent(pldo[i].getId());
                            cdo[i].setPlanetaRef(refpl);
                            cDAO.insert(cdo[i]);
                    }
                    
                    
                    // CREATE AND INSERT MISION
                    StringBuffer str2 = new StringBuffer();
                    str2.append('a');
                    int nm = 10;
                    MisionDO mdo[] = new MisionDO[7];
                    for (int i = 0; i < 7; i++) {
                            mdo[i] = new MisionDO();
                            mdo[i].setDescripcion(str2.toString());
                            mdo[i].setPuntosDeEntrenamientoGanados(nm + nm);
                            mdo[i].setNivelNecesario(i + 1);
                            mdo[i].setExperienciaGanada(i * nm + 1);
                            mdo[i].setNombre(str2.toString());
                            mDAO.insert(mdo[i]);
                            str2.append(i);
                            nm += nm;
                    }
                    
                    // CREATE AND INSERT OBJETIVO
                    ObjetivoDO obdo[] = new ObjetivoDO[14];
                    str.delete(0, str.length());
                    str.append("a");
                    for (int i = 0; i < 14; i++) {
                            obdo[i] = new ObjetivoDO();
                            obdo[i].setDescripcion(str.toString());
                            obdo[i].setNumeroDeNpc(i + 1);
                            refpl = new Reference<PlanetaDO>();
                            refpl.setRefIdent(pldo2[i].getId());
                            obdo[i].setPlanetaRef(refpl);
                            obDAO.insert(obdo[i]);
                    }

                    // CREATE AND INSERT ORDEN
                    OrdenDO odo[] = new OrdenDO[14];
                    Reference<ObjetivoDO> refob;
                    Reference<MisionDO> refm;
                    for (int j = 0; j < 7; j++) {

                            for (int i = 0; i < 2; i++) {
                                    odo[i] = new OrdenDO();
                                    odo[i].setPrioridad(i + 1);

                                    refm = new Reference<MisionDO>();
                                    refm.setRefIdent(mdo[j].getId());
                                    odo[i].setMisionRef(refm);

                                    refob = new Reference<ObjetivoDO>();
                                    refob.setRefIdent(obdo[j * 2 + i].getId());
                                    odo[i].setObjetivoRef(refob);

                                    oDAO.insert(odo[i]);
                            }
                    }
	
            } finally {
                // Cerrar Conexion
                ConnectionFactory.closeConnection(conn.getConnection());
        }
            
    }
	
	
}
