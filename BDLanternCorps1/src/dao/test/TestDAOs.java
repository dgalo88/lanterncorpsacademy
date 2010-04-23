package dao.test;

import dao.api.FactoryDAO;
import dao.api.InterfaceDAO;
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
import dao.lantern.MisionPersonajeDO;
import dao.lantern.NpcDAO;
import dao.lantern.ObjetivoDAO;
import dao.lantern.ObjetivoDO;
import dao.lantern.OrdenDAO;
import dao.lantern.OrdenDO;
import dao.lantern.PersonajeDAO;
import dao.lantern.PersonajeDO;
import dao.lantern.PlanetaDAO;
import dao.lantern.PlanetaDO;
import dao.lantern.UsuarioDAO;
import dao.lantern.UsuarioDO;

public class TestDAOs {


	        protected static final int ROJO = 0;
	        protected static final int VERDE = 1;
	        protected static final int AZUL = 2;
	        protected static final int AMARILLO = 3;

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

	               
	                // CREATE TABLE
	                plDAO.createTable();
	                mDAO.createTable();
	                cDAO.createTable();
	                obDAO.createTable();
	                oDAO.createTable();
	                gDAO.createTable();
	                uDAO.createTable();  //TODO make them work!
	                pDAO.createTable();
	                pmDAO.createTable();

	                npcDAO.createTable();
	                mcDAO.createTable();
	                hDAO.createTable(); //TODO este en consecuencia tampoco sirve
	                haDAO.createTable();
	                hcDAO.createTable();

	                try {

	                        // CREATE PLANETADO
	                        PlanetaDO pldo[] = new PlanetaDO[4];
	                        for (int i = 0; i < 4; i++) {
	                                pldo[i] = new PlanetaDO();
	                        }

	                        pldo[ROJO].setNombre("ROJO");
	                        pldo[AZUL].setNombre("AZUL");
	                        pldo[AMARILLO].setNombre("AMARILLO");
	                        pldo[VERDE].setNombre("VERDE");

	                        pldo[ROJO].setSector("1");
	                        pldo[AZUL].setSector("2");
	                        pldo[AMARILLO].setSector("3");
	                        pldo[VERDE].setSector("4");

	                        pldo[ROJO].setCoordenadaEnX(1);
	                        pldo[AZUL].setCoordenadaEnX(2);
	                        pldo[AMARILLO].setCoordenadaEnX(3);
	                        pldo[VERDE].setCoordenadaEnX(4);

	                        pldo[ROJO].setCoordenadaEnY(1);
	                        pldo[AZUL].setCoordenadaEnY(2);
	                        pldo[AMARILLO].setCoordenadaEnY(3);
	                        pldo[VERDE].setCoordenadaEnY(4);

	                        // INSERT PLANETA
	                        for (int i = 0; i < 4; i++) {
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
	                        ClaseLinternaDO cdo[] = new ClaseLinternaDO[4];
	                        for (int i = 0; i < 4; i++) {
	                                cdo[i] = new ClaseLinternaDO();
	                        }
	                        cdo[ROJO].setColor("ROJO");
	                        cdo[VERDE].setColor("VERDE");
	                        cdo[AZUL].setColor("AZUL");
	                        cdo[AMARILLO].setColor("AMARILLO");

	                        cdo[ROJO].setNombreDeCuerpoLinterna("ROJO");
	                        cdo[VERDE].setNombreDeCuerpoLinterna("VERDE");
	                        cdo[AZUL].setNombreDeCuerpoLinterna("AZUL");
	                        cdo[AMARILLO].setNombreDeCuerpoLinterna("AMARILLO");

	                        // CREATE REFERENCE TO PLANETA AND INSERT CLASELINTERNA
	                        Reference<PlanetaDO> refpl;
	                        for (int i = 0; i < 4; i++) {
	                                refpl = new Reference<PlanetaDO>();
	                                refpl.setRefIdent(pldo[i].getId());
	                                cdo[i].setPlanetaRef(refpl);
	                                cDAO.insert(cdo[i]);
	                        }

	                        // CREATE PERSONAJE
	                        PersonajeDO pdo[] = new PersonajeDO[4];
	                        for (int i = 0; i < 4; i++) {
	                                pdo[i] = new PersonajeDO();
	                        }
	                        pdo[ROJO].setAlias("ROJO");
	                        pdo[AZUL].setAlias("AZUL");
	                        pdo[VERDE].setAlias("VERDE");
	                        pdo[AMARILLO].setAlias("AMARILLO");

	                        // CREATE REFERENCE TO CLASELINTERNA AND INSERT PERSONAJE
	                        Reference<ClaseLinternaDO> refc;
	                        for (int i = 0; i < 4; i++) {
	                                refc = new Reference<ClaseLinternaDO>();
	                                //refc.setRefValue(cdo[i]);
	                                refc.setRefIdent(cdo[i].getId());
	                                pdo[i].setClaseLinternaRef(refc);
	                                /* pdo[i].setUltimaFechaIngreso(new Date(i)); */
	                                pdo[i].setPlanetaRef(cdo[i].getPlanetaRef());
	                                pDAO.insert(pdo[i]);
	                        }

	                        // CREATE USUARIO
	                        UsuarioDO udo[] = new UsuarioDO[4];
	                        for (int i = 0; i < 4; i++) {
	                                udo[i] = new UsuarioDO();
	                        }
	                        udo[ROJO].setCorreo("ROJO@ROJO");
	                        udo[AZUL].setCorreo("AZUL@AZUL");
	                        udo[VERDE].setCorreo("VERDE@VERDE");
	                        udo[AMARILLO].setCorreo("AMARILLO@AMARILLO");

	                        udo[ROJO].setClave("ROJOROJO");
	                        udo[AZUL].setClave("AZULAZUL");
	                        udo[VERDE].setClave("VERDEVERDE");
	                        udo[AMARILLO].setClave("AMARILLOAMARILLO");

	                        udo[ROJO].setNombre("ROJO");
	                        udo[AZUL].setNombre("AZUL");
	                        udo[VERDE].setNombre("VERDE");
	                        udo[AMARILLO].setNombre("AMARILLO");

	                        // CREATE REFERENCE TO PERSONAJE AND INSERT USUARIO
	                        Reference<PersonajeDO> refp;
	                        for (int i = 0; i < 4; i++) {
	                                refp = new Reference<PersonajeDO>();
	                                refp.setRefIdent(pdo[i].getId());
	                                udo[i].setPersonajeRef(refp);
	                                uDAO.insert(udo[i]);
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


	                        // CREATE AND INSERT MISIONPERSONAJE
	                        int nmp = 0;
	                        Reference<MisionDO> refm;
	                        MisionPersonajeDO mpdo[] = new MisionPersonajeDO[4 * 4];
	                        for (int i = 0; i < 4; i++) {
	                                for (int j = 0; j < 4; j++, nmp++) {
	                                        mpdo[nmp] = new MisionPersonajeDO();
	                                        refm = new Reference<MisionDO>();
	                                        refm.setRefIdent(mdo[i + j].getId());
	                                        mpdo[nmp].setMisionRef(refm);
	                                        refp = new Reference<PersonajeDO>();
	                                        refp.setRefIdent(pdo[i].getId());
	                                        mpdo[nmp].setPersonajeRef(refp);
	                                        pmDAO.insert(mpdo[nmp]);
	                                }
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
