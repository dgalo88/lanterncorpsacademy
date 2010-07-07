package com.ulasoft.lanterncorpsacademy.logic;

import lcaInterfaceDAO.IClaseLinternaDAO;
import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IGrupoDAO;
import lcaInterfaceDAO.IHabilidadActivaDAO;
import lcaInterfaceDAO.IHabilidadClaseLinternaDAO;
import lcaInterfaceDAO.IHabilidadClaseLinternaDO;
import lcaInterfaceDAO.IHabilidadDAO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.IMisionClaseLinternaDAO;
import lcaInterfaceDAO.IMisionClaseLinternaDO;
import lcaInterfaceDAO.IMisionDAO;
import lcaInterfaceDAO.IMisionDO;
import lcaInterfaceDAO.IMisionPersonajeDAO;
import lcaInterfaceDAO.INivelHabilidadDAO;
import lcaInterfaceDAO.INivelHabilidadDO;
import lcaInterfaceDAO.INpcDAO;
import lcaInterfaceDAO.INpcDO;
import lcaInterfaceDAO.IObjetivoDAO;
import lcaInterfaceDAO.IObjetivoDO;
import lcaInterfaceDAO.IOrdenDAO;
import lcaInterfaceDAO.IOrdenDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPlanetaDAO;
import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IUsuarioDAO;
import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.BD;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class InicializarBD {

	// Clases de linterna
	protected static final int VERDE = 0;
	protected static final int AMARILLO = 1;
	protected static final int ROJO = 2;
	protected static final int NEGRO = 3;
	protected static final int AZUL = 4;
	protected static final int INDIGO = 5;
	protected static final int VIOLETA = 6;


		
	@SuppressWarnings("unchecked")
	public static void main(String[] nada) throws Exception {
		
		StringBuffer strbuf;
	
		// Obtenemos la Conexion
		
//		ConnectionBean connCreateDB = ConnectionFactory.getConnectionBean("connection_create_db.properties");
//		strbuf = new StringBuffer();
//		strbuf.append("DROP DATABASE IF EXISTS ");
//		strbuf.append(BD.nombreBD());
//		connCreateDB.getConnection().createStatement().execute(strbuf.toString());
//		strbuf = new StringBuffer();
//		strbuf.append("CREATE DATABASE ");
//		strbuf.append(BD.nombreBD());
//		connCreateDB.getConnection().createStatement().execute(strbuf.toString());
//		ConnectionFactory.closeConnection(connCreateDB.getConnection());
		
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

			
			IPlanetaDO PlanetaDO[] = new IPlanetaDO[48];
			
			
			for (int i = 0; i < 48; i++) {
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
			PlanetaDO[7].setNombre("Euphorix");
			PlanetaDO[8].setNombre("Xaos");
			PlanetaDO[9].setNombre("Sodas");
			PlanetaDO[10].setNombre("Wolsoon");
			PlanetaDO[11].setNombre("Genesis");
			PlanetaDO[12].setNombre("Cairo");
			PlanetaDO[13].setNombre("Surpalam");
			PlanetaDO[14].setNombre("Ovacron VI");
			PlanetaDO[15].setNombre("Krypton");
			PlanetaDO[16].setNombre("Tierra");
			PlanetaDO[17].setNombre("Zerbon");
			PlanetaDO[18].setNombre("Okaara");
			PlanetaDO[19].setNombre("Ungara");
			PlanetaDO[20].setNombre("Karax");
			PlanetaDO[21].setNombre("Rhan");
			PlanetaDO[22].setNombre("Korugar");
			PlanetaDO[23].setNombre("Mogo");
			PlanetaDO[24].setNombre("Hardee");
			PlanetaDO[25].setNombre("Arden");
			PlanetaDO[26].setNombre("Black Mercy");
			PlanetaDO[27].setNombre("Khunda");
			PlanetaDO[28].setNombre("Slamgeni");
			PlanetaDO[29].setNombre("Voorl");
			PlanetaDO[30].setNombre("Bolovax Vik");
			PlanetaDO[31].setNombre("Pacredo");
			PlanetaDO[32].setNombre("Apokolips");
			PlanetaDO[33].setNombre("Krolotea");
			PlanetaDO[34].setNombre("Coristeel");
			PlanetaDO[35].setNombre("Cygnus 4");
			PlanetaDO[36].setNombre("Talcylon Omega");
			PlanetaDO[37].setNombre("Trigus VIII");
			PlanetaDO[38].setNombre("Timron");
			PlanetaDO[39].setNombre("Thanagar");
			PlanetaDO[40].setNombre("Perreseen");
			PlanetaDO[41].setNombre("Cythonis");
			PlanetaDO[42].setNombre("Betrassus");
			PlanetaDO[43].setNombre("Apiaton");
			PlanetaDO[44].setNombre("Berrith");
			PlanetaDO[45].setNombre("Hiven"); // H'iven tal vez por el encoding aqui da error
			PlanetaDO[46].setNombre("Znang"); //Z'nang
			PlanetaDO[47].setNombre("Vorn");

			// ********************************************

			PlanetaDO[VERDE].setSector("0");
			PlanetaDO[AMARILLO].setSector("-1");
			PlanetaDO[ROJO].setSector("666");
			PlanetaDO[NEGRO].setSector("665");
			PlanetaDO[AZUL].setSector("2682");
			PlanetaDO[INDIGO].setSector("200");
			PlanetaDO[VIOLETA].setSector("1416");
			PlanetaDO[7].setSector("2828");
			PlanetaDO[8].setSector("3550");
			PlanetaDO[9].setSector("3550");
			PlanetaDO[10].setSector("30");
			PlanetaDO[11].setSector("35");
			PlanetaDO[12].setSector("2");
			PlanetaDO[13].setSector("312");
			PlanetaDO[14].setSector("2");
			PlanetaDO[15].setSector("2813");
			PlanetaDO[16].setSector("2814");
			PlanetaDO[17].setSector("2814");
			PlanetaDO[18].setSector("2828");
			PlanetaDO[19].setSector("2814");
			PlanetaDO[20].setSector("424");
			PlanetaDO[21].setSector("2682");
			PlanetaDO[22].setSector("1417");
			PlanetaDO[23].setSector("2261");
			PlanetaDO[24].setSector("1014");
			PlanetaDO[25].setSector("1132");
			PlanetaDO[26].setSector("2261");
			PlanetaDO[27].setSector("424");
			PlanetaDO[28].setSector("3550");
			PlanetaDO[29].setSector("2828");
			PlanetaDO[30].setSector("674");
			PlanetaDO[31].setSector("2");
			PlanetaDO[32].setSector("38");
			PlanetaDO[33].setSector("312");
			PlanetaDO[34].setSector("674");
			PlanetaDO[35].setSector("1132");
			PlanetaDO[36].setSector("424");
			PlanetaDO[37].setSector("2813");
			PlanetaDO[38].setSector("2813");
			PlanetaDO[39].setSector("2682");
			PlanetaDO[40].setSector("312");
			PlanetaDO[41].setSector("1417");
			PlanetaDO[42].setSector("1417");
			PlanetaDO[43].setSector("2261");
			PlanetaDO[44].setSector("1014");
			PlanetaDO[45].setSector("1014");
			PlanetaDO[46].setSector("1132");
			PlanetaDO[47].setSector("674");
			
			// ********************************************
			
			PlanetaDO[VERDE].setCoordenadaEnX(374);
			PlanetaDO[AMARILLO].setCoordenadaEnX(12);
			PlanetaDO[ROJO].setCoordenadaEnX(722);
			PlanetaDO[NEGRO].setCoordenadaEnX(740);
			PlanetaDO[AZUL].setCoordenadaEnX(102);
			PlanetaDO[INDIGO].setCoordenadaEnX(502);
			PlanetaDO[VIOLETA].setCoordenadaEnX(494);
			PlanetaDO[7].setCoordenadaEnX(96);
			PlanetaDO[8].setCoordenadaEnX(172);
			PlanetaDO[9].setCoordenadaEnX(249);
			PlanetaDO[10].setCoordenadaEnX(438);
			PlanetaDO[11].setCoordenadaEnX(409);
			PlanetaDO[12].setCoordenadaEnX(354);
			PlanetaDO[13].setCoordenadaEnX(581);
			PlanetaDO[14].setCoordenadaEnX(322);
			PlanetaDO[15].setCoordenadaEnX(151);
			PlanetaDO[16].setCoordenadaEnX(151);
			PlanetaDO[17].setCoordenadaEnX(242);
			PlanetaDO[18].setCoordenadaEnX(156);
			PlanetaDO[19].setCoordenadaEnX(79);
			PlanetaDO[20].setCoordenadaEnX(702);
			PlanetaDO[21].setCoordenadaEnX(147);
			PlanetaDO[22].setCoordenadaEnX(373);
			PlanetaDO[23].setCoordenadaEnX(290);
			PlanetaDO[24].setCoordenadaEnX(508);
			PlanetaDO[25].setCoordenadaEnX(500);
			PlanetaDO[26].setCoordenadaEnX(286);
			PlanetaDO[27].setCoordenadaEnX(584);
			PlanetaDO[28].setCoordenadaEnX(300);
			PlanetaDO[29].setCoordenadaEnX(255);
			PlanetaDO[30].setCoordenadaEnX(624);
			PlanetaDO[31].setCoordenadaEnX(299);
			PlanetaDO[32].setCoordenadaEnX(397);
			PlanetaDO[33].setCoordenadaEnX(491);
			PlanetaDO[34].setCoordenadaEnX(487);
			PlanetaDO[35].setCoordenadaEnX(639);
			PlanetaDO[36].setCoordenadaEnX(659);
			PlanetaDO[37].setCoordenadaEnX(45);
			PlanetaDO[38].setCoordenadaEnX(251);
			PlanetaDO[39].setCoordenadaEnX(268);
			PlanetaDO[40].setCoordenadaEnX(585);
			PlanetaDO[41].setCoordenadaEnX(374);
			PlanetaDO[42].setCoordenadaEnX(414);
			PlanetaDO[43].setCoordenadaEnX(202);
			PlanetaDO[44].setCoordenadaEnX(442);
			PlanetaDO[45].setCoordenadaEnX(587);
			PlanetaDO[46].setCoordenadaEnX(585);
			PlanetaDO[47].setCoordenadaEnX(702);
			
			// ********************************************
			
			PlanetaDO[VERDE].setCoordenadaEnY(252);
			PlanetaDO[AMARILLO].setCoordenadaEnY(124);
			PlanetaDO[ROJO].setCoordenadaEnY(290);
			PlanetaDO[NEGRO].setCoordenadaEnY(158);
			PlanetaDO[AZUL].setCoordenadaEnY(396);
			PlanetaDO[INDIGO].setCoordenadaEnY(10);
			PlanetaDO[VIOLETA].setCoordenadaEnY(486);
			PlanetaDO[7].setCoordenadaEnY(100);
			PlanetaDO[8].setCoordenadaEnY(60);
			PlanetaDO[9].setCoordenadaEnY(41);
			PlanetaDO[10].setCoordenadaEnY(22);
			PlanetaDO[11].setCoordenadaEnY(89);
			PlanetaDO[12].setCoordenadaEnY(119);
			PlanetaDO[13].setCoordenadaEnY(62);
			PlanetaDO[14].setCoordenadaEnY(33);
			PlanetaDO[15].setCoordenadaEnY(281);
			PlanetaDO[16].setCoordenadaEnY(207);
			PlanetaDO[17].setCoordenadaEnY(203);
			PlanetaDO[18].setCoordenadaEnY(144);
			PlanetaDO[19].setCoordenadaEnY(208);
			PlanetaDO[20].setCoordenadaEnY(62);
			PlanetaDO[21].setCoordenadaEnY(333);
			PlanetaDO[22].setCoordenadaEnY(469);
			PlanetaDO[23].setCoordenadaEnY(370);
			PlanetaDO[24].setCoordenadaEnY(324);
			PlanetaDO[25].setCoordenadaEnY(398);
			PlanetaDO[26].setCoordenadaEnY(445);
			PlanetaDO[27].setCoordenadaEnY(215);
			PlanetaDO[28].setCoordenadaEnY(111);
			PlanetaDO[29].setCoordenadaEnY(154);
			PlanetaDO[30].setCoordenadaEnY(322);
			PlanetaDO[31].setCoordenadaEnY(192);
			PlanetaDO[32].setCoordenadaEnY(179);
			PlanetaDO[33].setCoordenadaEnY(174);
			PlanetaDO[34].setCoordenadaEnY(258);
			PlanetaDO[35].setCoordenadaEnY(443);
			PlanetaDO[36].setCoordenadaEnY(136);
			PlanetaDO[37].setCoordenadaEnY(289);
			PlanetaDO[38].setCoordenadaEnY(249);
			PlanetaDO[39].setCoordenadaEnY(311);
			PlanetaDO[40].setCoordenadaEnY(134);
			PlanetaDO[41].setCoordenadaEnY(348);
			PlanetaDO[42].setCoordenadaEnY(414);
			PlanetaDO[43].setCoordenadaEnY(446);
			PlanetaDO[44].setCoordenadaEnY(308);
			PlanetaDO[45].setCoordenadaEnY(362);
			PlanetaDO[46].setCoordenadaEnY(448);
			PlanetaDO[47].setCoordenadaEnY(380);

			// INSERT PLANETA
			for (int i = 0; i < 48; i++) {
				PlanetaDAO.insert(PlanetaDO[i]);
			}
			

			// CREATE CLASELINTERNA
			IClaseLinternaDO ClaseLinternaDO[] = new IClaseLinternaDO[7];
			for (int i = 0; i < 7; i++) {
				ClaseLinternaDO[i] = (IClaseLinternaDO) GlobalDOFactory
						.getDO(IClaseLinternaDO.class);
			}
			ClaseLinternaDO[VERDE].setColor("Verde");
			ClaseLinternaDO[AMARILLO].setColor("Amarillo");
			ClaseLinternaDO[ROJO].setColor("Rojo");
			ClaseLinternaDO[AZUL].setColor("Azul");
			ClaseLinternaDO[NEGRO].setColor("Negro");
			ClaseLinternaDO[INDIGO].setColor("Indigo");
			ClaseLinternaDO[VIOLETA].setColor("Violeta");

			ClaseLinternaDO[VERDE]
					.setNombre_de_cuerpo_linterna("Green Lantern Corps");
			ClaseLinternaDO[AMARILLO]
					.setNombre_de_cuerpo_linterna("Sinestro Corps");
			ClaseLinternaDO[ROJO]
					.setNombre_de_cuerpo_linterna("Red Lantern Corps");
			ClaseLinternaDO[AZUL]
					.setNombre_de_cuerpo_linterna("Blue Lantern Corps");
			ClaseLinternaDO[NEGRO]
					.setNombre_de_cuerpo_linterna("Black Lantern Corps");
			ClaseLinternaDO[INDIGO]
					.setNombre_de_cuerpo_linterna("Tribu Indigo");
			ClaseLinternaDO[VIOLETA]
					.setNombre_de_cuerpo_linterna("Star Sapphires");

			// CREATE REFERENCE TO PLANETA AND INSERT CLASELINTERNA
			Reference<IPlanetaDO> refpl;
			Reference<IClaseLinternaDO> refcl[] = new Reference[7];

			for (int i = 0; i < 7; i++) {
				refpl = new Reference<IPlanetaDO>();
				refcl[i] = new Reference<IClaseLinternaDO>();
				refpl.setRefIdent(PlanetaDO[i].getId());
				refcl[i].setRefIdent(ClaseLinternaDO[i].getId());
				ClaseLinternaDO[i].setPlanetaRef(refpl);
				ClaseLinternaDAO.insert(ClaseLinternaDO[i]);
			}

			// CREATE AND INSERT HABILIDADES
			IHabilidadDO HabilidadDO;
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Taclear");
			HabilidadDO.setCosto_de_aprendizaje(1500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			Reference<IHabilidadDO> refhab;
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			INivelHabilidadDO NivelHabilidadDO[] = new INivelHabilidadDO[10];
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(50 + i * 5);
				NivelHabilidadDO[i].setCosto_de_energia(20 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			//Reference<IClaseLinternaDO> refcl[] = new Reference[7];

			for (int i = 0; i < 7; i++) {
				//refpl = new Reference<IPlanetaDO>();
				refcl[i] = new Reference<IClaseLinternaDO>();
				//refpl.setRefIdent(PlanetaDO[i].getId());
				refcl[i].setRefIdent(ClaseLinternaDO[i].getId());
				//ClaseLinternaDO[i].setPlanetaRef(refpl);
				//ClaseLinternaDAO.insert(ClaseLinternaDO[i]);
			}
			
			IHabilidadClaseLinternaDO habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[ROJO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);

			
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Daga de Cristal");
			HabilidadDO.setCosto_de_aprendizaje(1500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(50 + i * 5);
				NivelHabilidadDO[i].setCosto_de_energia(20 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[VIOLETA]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Electrocución");
			HabilidadDO.setCosto_de_aprendizaje(4500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(50 + i * 5);
				NivelHabilidadDO[i].setCosto_de_energia(20 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[AZUL]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
			
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Hacha de Energía Amarilla");
			HabilidadDO.setCosto_de_aprendizaje(1500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(50 + i * 5);
				NivelHabilidadDO[i].setCosto_de_energia(20 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[AMARILLO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
			
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Rayo antimateria");
			HabilidadDO.setCosto_de_aprendizaje(1500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(50 + i * 5);
				NivelHabilidadDO[i].setCosto_de_energia(20 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[NEGRO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
			
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Espada de Energía Verde");
			HabilidadDO.setCosto_de_aprendizaje(1500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(50 + i * 5);
				NivelHabilidadDO[i].setCosto_de_energia(20 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[VERDE]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
			
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Llama Roja");
			HabilidadDO.setCosto_de_aprendizaje(13500);
			HabilidadDO.setTipo(2);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(40 + i * 5);
				NivelHabilidadDO[i].setCosto_de_energia(0.5 - i*0.05);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[ROJO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Campo de Cristal");
			HabilidadDO.setCosto_de_aprendizaje(4500);
			HabilidadDO.setTipo(2);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(40 + i * 5);
				NivelHabilidadDO[i].setCosto_de_energia(0.5 - i*0.05);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[VIOLETA]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Aura de Esperanza");
			HabilidadDO.setCosto_de_aprendizaje(13500);
			HabilidadDO.setTipo(2);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(40 + i * 5);
				NivelHabilidadDO[i].setCosto_de_energia(0.5 - i*0.05);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[AZUL]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Avatar de Protección");
			HabilidadDO.setCosto_de_aprendizaje(13500);
			HabilidadDO.setTipo(2);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(40 + i * 5);
				NivelHabilidadDO[i].setCosto_de_energia(0.5 - i*0.05);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[AMARILLO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Piel de Hueso");
			HabilidadDO.setCosto_de_aprendizaje(4500);
			HabilidadDO.setTipo(2);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(40 + i * 5);
				NivelHabilidadDO[i].setCosto_de_energia(0.5 - i*0.05);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[NEGRO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Esfera Indigo");
			HabilidadDO.setCosto_de_aprendizaje(4500);
			HabilidadDO.setTipo(2);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(40 + i * 5);
				NivelHabilidadDO[i].setCosto_de_energia(0.5 - i*0.05);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[INDIGO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Avatar del Predator");
			HabilidadDO.setCosto_de_aprendizaje(13500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(85 + i * 10);
				NivelHabilidadDO[i].setCosto_de_energia(25 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[VIOLETA]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Avatar del Antimonitor");
			HabilidadDO.setCosto_de_aprendizaje(13500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(85 + i * 10);
				NivelHabilidadDO[i].setCosto_de_energia(25 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[NEGRO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Avatar de Abin Sur");
			HabilidadDO.setCosto_de_aprendizaje(13500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(85 + i * 10);
				NivelHabilidadDO[i].setCosto_de_energia(25 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[INDIGO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Avatar de Parallax");
			HabilidadDO.setCosto_de_aprendizaje(37500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(100 + i * 20);
				NivelHabilidadDO[i].setCosto_de_energia(30 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[AMARILLO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Avatar de ION");
			HabilidadDO.setCosto_de_aprendizaje(37500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(100 + i * 20);
				NivelHabilidadDO[i].setCosto_de_energia(30 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[VERDE]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Corrupción de Energía");
			HabilidadDO.setCosto_de_aprendizaje(4500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(20 + i);
				NivelHabilidadDO[i].setCosto_de_energia(15 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[ROJO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Plasma");
			HabilidadDO.setCosto_de_aprendizaje(37500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(100 + i * 20);
				NivelHabilidadDO[i].setCosto_de_energia(30 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[ROJO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Petrificar");
			HabilidadDO.setCosto_de_aprendizaje(37500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(10 + i );
				NivelHabilidadDO[i].setCosto_de_energia(40 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[VIOLETA]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Consumir Corazón");
			HabilidadDO.setCosto_de_aprendizaje(37500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(10 + i );
				NivelHabilidadDO[i].setCosto_de_energia(40 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[NEGRO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Predicción de Ataque");
			HabilidadDO.setCosto_de_aprendizaje(1500);
			HabilidadDO.setTipo(2);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(25 + i * 5 );
				NivelHabilidadDO[i].setCosto_de_energia(1 - i*0.05);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[AZUL]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Infligir Terror");
			HabilidadDO.setCosto_de_aprendizaje(4500);
			HabilidadDO.setTipo(2);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(25 + i * 5 );
				NivelHabilidadDO[i].setCosto_de_energia(1 - i*0.05);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[AMARILLO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Rayo de esperanza");
			HabilidadDO.setCosto_de_aprendizaje(37500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(110 + i * 20 );
				NivelHabilidadDO[i].setCosto_de_energia(30 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[AZUL]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Cetro Cargado");
			HabilidadDO.setCosto_de_aprendizaje(37500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(110 + i * 20 );
				NivelHabilidadDO[i].setCosto_de_energia(30 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[INDIGO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Golpe de Mazo");
			HabilidadDO.setCosto_de_aprendizaje(125);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(30 + i * 10 );
				NivelHabilidadDO[i].setCosto_de_energia(10 - i * 0.5);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[VERDE]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Constricción");
			HabilidadDO.setCosto_de_aprendizaje(125);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(35 + i * 5 );
				NivelHabilidadDO[i].setCosto_de_energia(10 - i * 0.5);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[AMARILLO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Robo de Salud");
			HabilidadDO.setCosto_de_aprendizaje(125);
			HabilidadDO.setTipo(3);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(45 + i * 5 );
				NivelHabilidadDO[i].setCosto_de_energia((45 + i * 5 )*(0.3 - i * 0.02));
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[NEGRO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Puño Luminoso");
			HabilidadDO.setCosto_de_aprendizaje(125);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(35 + i * 5 );
				NivelHabilidadDO[i].setCosto_de_energia(10 - i * 0.5);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[ROJO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Curación");
			HabilidadDO.setCosto_de_aprendizaje(125);
			HabilidadDO.setTipo(3);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(45 + i * 5 );
				NivelHabilidadDO[i].setCosto_de_energia((45 + i * 5 )*(0.3 - i * 0.02));
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[AZUL]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Evasión de Combate");
			HabilidadDO.setCosto_de_aprendizaje(125);
			HabilidadDO.setTipo(2);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(10 + i * 3 );
				NivelHabilidadDO[i].setCosto_de_energia(20 - i );
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[INDIGO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);

		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Confusión");
			HabilidadDO.setCosto_de_aprendizaje(125);
			HabilidadDO.setTipo(2);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(15 + i * 2 );
				NivelHabilidadDO[i].setCosto_de_energia((15 + i * 2 )*(0.5 - i * 0.02) );
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[VIOLETA]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);

		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Vuelo");
			HabilidadDO.setCosto_de_aprendizaje(50);
			HabilidadDO.setTipo(4);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(0);
				NivelHabilidadDO[i].setCosto_de_energia(1 - i * 0.1 );
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			for (int i = 0; i < 7; i++) {
				habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
						.getDO(IHabilidadClaseLinternaDO.class);
				habilidadClaseLinternaDO.setHabilidadRef(refhab);
				habilidadClaseLinternaDO.setClaseLinternaRef(refcl[i]);
				HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
			}

		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Rayo Directo");
			HabilidadDO.setCosto_de_aprendizaje(75);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(20 + i * 5);
				NivelHabilidadDO[i].setCosto_de_energia(5 - i * 0.2 );
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			for (int i = 0; i < 7; i++) {
				habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
						.getDO(IHabilidadClaseLinternaDO.class);
				habilidadClaseLinternaDO.setHabilidadRef(refhab);
				habilidadClaseLinternaDO.setClaseLinternaRef(refcl[i]);
				HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
			}

		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Aura Protectora");
			HabilidadDO.setCosto_de_aprendizaje(100);
			HabilidadDO.setTipo(2);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(30 + i * 2);
				NivelHabilidadDO[i].setCosto_de_energia(0.3 - i * 0.02 );
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			for (int i = 0; i < 7; i++) {
				habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
						.getDO(IHabilidadClaseLinternaDO.class);
				habilidadClaseLinternaDO.setHabilidadRef(refhab);
				habilidadClaseLinternaDO.setClaseLinternaRef(refcl[i]);
				HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
			}

		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Escudo");
			HabilidadDO.setCosto_de_aprendizaje(100);////////NO DEFINIDO
			HabilidadDO.setTipo(2);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(20 + i * 3);
				NivelHabilidadDO[i].setCosto_de_energia(0.4 - i * 0.03);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			for (int i = 0; i < 7; i++) {
				habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
						.getDO(IHabilidadClaseLinternaDO.class);
				habilidadClaseLinternaDO.setHabilidadRef(refhab);
				habilidadClaseLinternaDO.setClaseLinternaRef(refcl[i]);
				HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
			}

			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Empatia");
			HabilidadDO.setCosto_de_aprendizaje(1500);
			HabilidadDO.setTipo(2);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(15 + i * 2 );
				NivelHabilidadDO[i].setCosto_de_energia((15 + i * 2 )*(0.5 - i * 0.02) );
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[INDIGO]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
			

		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Cañon de Energia");
			HabilidadDO.setCosto_de_aprendizaje(4500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(50 + i * 5);
				NivelHabilidadDO[i].setCosto_de_energia(20 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[VERDE]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
			

		
			
			HabilidadDO = (IHabilidadDO) GlobalDOFactory
					.getDO(IHabilidadDO.class);
			HabilidadDO.setNombre("Explosion de Energia");
			HabilidadDO.setCosto_de_aprendizaje(13500);
			HabilidadDO.setTipo(1);
			HabilidadDAO.insert(HabilidadDO);
			refhab = new Reference<IHabilidadDO>();
			refhab.setRefIdent(HabilidadDO.getId());
			for (int i = 0; i < 10; i++) {
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
						.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(85 + i * 10 );
				NivelHabilidadDO[i].setCosto_de_energia(25 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}
			habilidadClaseLinternaDO = (IHabilidadClaseLinternaDO) GlobalDOFactory
					.getDO(IHabilidadClaseLinternaDO.class);
			habilidadClaseLinternaDO.setHabilidadRef(refhab);
			habilidadClaseLinternaDO.setClaseLinternaRef(refcl[VERDE]);
			HabilidadClaseLinternaDAO.insert(habilidadClaseLinternaDO);
			
			//NPC
			
			INpcDO npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Abin Sur");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Verde");
			NpcDAO.insert(npcDO);
			
			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Barreer WoT");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Verde");
			NpcDAO.insert(npcDO);
			
			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Fentara Rrab");
			npcDO.setNivel(2);
			npcDO.setSalud(200);
			npcDO.setDano(20);
			npcDO.setColor("Verde");
			NpcDAO.insert(npcDO);
			
			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Bizarro Green Lantern");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Amarillo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Maash");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Amarillo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Tekik");
			npcDO.setNivel(2);
			npcDO.setSalud(200);
			npcDO.setDano(20);
			npcDO.setColor("Amarillo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Bleez");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Rojo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Mera");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Rojo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Dex-Starr");
			npcDO.setNivel(2);
			npcDO.setSalud(200);
			npcDO.setDano(20);
			npcDO.setColor("Rojo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Diamalon");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Negro");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Katma Tui");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Negro");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Terrence Long");
			npcDO.setNivel(2);
			npcDO.setSalud(200);
			npcDO.setDano(20);
			npcDO.setColor("Negro");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Hymn");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Azul");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Sercy");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Azul");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Barry Allen");
			npcDO.setNivel(2);
			npcDO.setSalud(200);
			npcDO.setDano(20);
			npcDO.setColor("Azul");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Indigo-1");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Indigo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Munk");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Indigo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Ray Palmer");
			npcDO.setNivel(2);
			npcDO.setSalud(200);
			npcDO.setDano(20);
			npcDO.setColor("Indigo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Cowgirl");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Violeta");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Dela Pharon");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Violeta");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Jillian Pearlman");
			npcDO.setNivel(2);
			npcDO.setSalud(200);
			npcDO.setDano(20);
			npcDO.setColor("Violeta");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Paul Kirk");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Neutral");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("clon de Paul Kirk");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Neutral");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Kate Spencer");
			npcDO.setNivel(1);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Neutral");
			NpcDAO.insert(npcDO);

			//MISIONES
			
			IMisionDO misionDO[]=new IMisionDO[5]; 
			misionDO[0] = (IMisionDO) GlobalDOFactory.getDO(IMisionDO.class);
			misionDO[0].setNombre("Combatir con los ManHunter.");
			misionDO[0].setNivel_necesario(1);
			misionDO[0].setExperiencia_ganada(10);
			misionDO[0].setPuntos_de_entrenamiento_ganados(100);
			misionDO[0].setDescripcion("Los Manhunters son unos androides guerreros creados antiguamente por los guardianes del universo.\nUna falla en su progrmación provocó que se rebelaran y se propusieran aniquilar toda la vida del\nuniverso. Su código, \"Ningún hombre escapa a los Manhunters\".\nEl objetivo es luchar contra estos androides para proteger la vida inteligente del universo.");
			MisionDAO.insert(misionDO[0]);
			IMisionClaseLinternaDO misionClaseLinternaDO;
			Reference<IMisionDO> refmis;
			refmis = new Reference<IMisionDO>();
			refmis.setRefIdent(misionDO[0].getId());
			for(int i=0;i<7;i++){
				misionClaseLinternaDO = (IMisionClaseLinternaDO) GlobalDOFactory.getDO(IMisionClaseLinternaDO.class);
				misionClaseLinternaDO.setClaseLinternaRef(refcl[i]); //RefCL
				misionClaseLinternaDO.setMisionRef(refmis);
				MisionClaseLinternaDAO.insert(misionClaseLinternaDO);
			}
			

			misionDO[1] = (IMisionDO) GlobalDOFactory.getDO(IMisionDO.class);
			misionDO[1].setNombre("Asegurar la bateria central.");
			misionDO[1].setNivel_necesario(1);
			misionDO[1].setExperiencia_ganada(10);
			misionDO[1].setPuntos_de_entrenamiento_ganados(100);
			misionDO[1].setDescripcion("El rasgo más destacado es la Batería de Poder Central, una versión gigantesca de las baterías de poder\nde los Linternas, que canaliza la energía de los Guardianes y amplifica, alimentando las baterías individuales.\nLa entidad del miedo conocida como Parallax fue encerrada en el centro de la Batería Central.\nEs vital conservar a salvo este artefacto ya que cualquier daño mayor podría impedir recargar los anillos\nde poder y así eliminar el arma principal de los linternas.");
			MisionDAO.insert(misionDO[1]);
			refmis = new Reference<IMisionDO>();
			refmis.setRefIdent(misionDO[1].getId());
			for(int i=0;i<7;i++){
				misionClaseLinternaDO = (IMisionClaseLinternaDO) GlobalDOFactory.getDO(IMisionClaseLinternaDO.class);
				misionClaseLinternaDO.setClaseLinternaRef(refcl[i]);
				misionClaseLinternaDO.setMisionRef(refmis);
				MisionClaseLinternaDAO.insert(misionClaseLinternaDO);
			}
			

			misionDO[2] = (IMisionDO) GlobalDOFactory.getDO(IMisionDO.class);
			misionDO[2].setNombre("Rescatar un compañero en black mercy.");
			misionDO[2].setNivel_necesario(1);
			misionDO[2].setExperiencia_ganada(10);
			misionDO[2].setPuntos_de_entrenamiento_ganados(100);
			misionDO[2].setDescripcion("Un compañero linterna no ha respondido en dias luego de ser enviado al sector 2261,\n revisa el sector, especificamente el planeta black mercy, sospechamos que se encuentra atrapado alli.");
			MisionDAO.insert(misionDO[2]);
			
			refmis = new Reference<IMisionDO>();
			refmis.setRefIdent(misionDO[2].getId());
			
			for(int i=0;i<7;i++){
				misionClaseLinternaDO = (IMisionClaseLinternaDO) GlobalDOFactory.getDO(IMisionClaseLinternaDO.class);
				misionClaseLinternaDO.setClaseLinternaRef(refcl[i]);
				misionClaseLinternaDO.setMisionRef(refmis);
				MisionClaseLinternaDAO.insert(misionClaseLinternaDO);
			}
			

			misionDO[4] = (IMisionDO) GlobalDOFactory.getDO(IMisionDO.class);
			misionDO[4].setNombre("Defender la tierra de Mongul.");
			misionDO[4].setNivel_necesario(2);
			misionDO[4].setExperiencia_ganada(20);
			misionDO[4].setPuntos_de_entrenamiento_ganados(200);
			misionDO[4].setDescripcion("Mogul como gobernante del planeta belicoso llamado Warworld, Mongul conquistó y esclavizo la población\nde incontables mundos. Ya sea forzados a alimentar las gigantescas unidades de propulsión del planeta\no participando de luchas de gladiadores,  Por esto la tierra debe de ser protegida de este gobernante.");
			MisionDAO.insert(misionDO[4]);
			refmis = new Reference<IMisionDO>();
			refmis.setRefIdent(misionDO[4].getId());
			for(int i=0;i<7;i++){
				misionClaseLinternaDO = (IMisionClaseLinternaDO) GlobalDOFactory.getDO(IMisionClaseLinternaDO.class);
				misionClaseLinternaDO.setClaseLinternaRef(refcl[i]);
				misionClaseLinternaDO.setMisionRef(refmis);
				MisionClaseLinternaDAO.insert(misionClaseLinternaDO);
			}
			

			misionDO[3] = (IMisionDO) GlobalDOFactory.getDO(IMisionDO.class);
			misionDO[3].setNombre("Proteger Planetas de los Manhunter.");
			misionDO[3].setNivel_necesario(2);
			misionDO[3].setExperiencia_ganada(10);
			misionDO[3].setPuntos_de_entrenamiento_ganados(200);
			misionDO[3].setDescripcion("Para ejecutar su voluntad y evitar amenazas alienígenas de todo tipo, los Guardianes crearon una legión de robots\ncentinelas llamados Manhunters. Sin embargo, con el tiempo el resentimiento creció entre los Manhunters y fueron\nvistos como fracasos debido a su incapacidad para reconocer y/o sentir miedo. Finalmente se rebelaron contra los\nGuardianes, alejándose de ellos y formando su propia sociedad automatizada donde podían perseguir sus propias metas\ny una de ellas es atacar planetas.");
			MisionDAO.insert(misionDO[3]);
			refmis = new Reference<IMisionDO>();
			refmis.setRefIdent(misionDO[3].getId());
			for(int i=0;i<7;i++){
				misionClaseLinternaDO = (IMisionClaseLinternaDO) GlobalDOFactory.getDO(IMisionClaseLinternaDO.class);
				misionClaseLinternaDO.setClaseLinternaRef(refcl[i]);
				misionClaseLinternaDO.setMisionRef(refmis);
				MisionClaseLinternaDAO.insert(misionClaseLinternaDO);
			}
			
			
			//OBJETIVOS
			
			IObjetivoDO objetivoDO[] = new IObjetivoDO[6];
			objetivoDO[0] = (IObjetivoDO) GlobalDOFactory.getDO(IObjetivoDO.class);
			objetivoDO[0].setDescripcion("Atravezar Bolovax Vik.");
			objetivoDO[0].setNumeroDeNpc(2);
			refpl = new Reference<IPlanetaDO>();
			refpl.setRefIdent(PlanetaDO[30].getId());
			objetivoDO[0].setPlanetaRef(refpl);
			ObjetivoDAO.insert(objetivoDO[0]);
			
			IOrdenDO ordenDO = (IOrdenDO) GlobalDOFactory.getDO(IOrdenDO.class);
			refmis =new Reference<IMisionDO>();
			refmis.setRefIdent(misionDO[2].getId());
			Reference<IObjetivoDO> refobj= new Reference<IObjetivoDO>();
			refobj.setRefIdent(objetivoDO[0].getId());
			ordenDO.setMisionRef(refmis);
			ordenDO.setObjetivoRef(refobj);
			ordenDO.setPrioridad(1);
			OrdenDAO.insert(ordenDO);
			
			objetivoDO[1] = (IObjetivoDO) GlobalDOFactory.getDO(IObjetivoDO.class);
			objetivoDO[1].setDescripcion("Rescatar a compañero linterna.");
			objetivoDO[1].setNumeroDeNpc(1);
			refpl = new Reference<IPlanetaDO>();
			refpl.setRefIdent(PlanetaDO[26].getId());
			objetivoDO[1].setPlanetaRef(refpl);
			ObjetivoDAO.insert(objetivoDO[1]);
			
			ordenDO = (IOrdenDO) GlobalDOFactory.getDO(IOrdenDO.class);
			refobj= new Reference<IObjetivoDO>();
			refobj.setRefIdent(objetivoDO[1].getId());
			ordenDO.setMisionRef(refmis);
			ordenDO.setObjetivoRef(refobj);
			ordenDO.setPrioridad(2);
			OrdenDAO.insert(ordenDO);
			
			//
			
			objetivoDO[3] = (IObjetivoDO) GlobalDOFactory.getDO(IObjetivoDO.class);
			objetivoDO[3].setDescripcion("Luchar contra los Pacredo.");
			objetivoDO[3].setNumeroDeNpc(2);
			refpl = new Reference<IPlanetaDO>();
			refpl.setRefIdent(PlanetaDO[31].getId());
			objetivoDO[3].setPlanetaRef(refpl);
			ObjetivoDAO.insert(objetivoDO[3]);
			
			ordenDO = (IOrdenDO) GlobalDOFactory.getDO(IOrdenDO.class);
			refmis =new Reference<IMisionDO>();
			refmis.setRefIdent(misionDO[0].getId());
			refobj= new Reference<IObjetivoDO>();
			refobj.setRefIdent(objetivoDO[0].getId());
			ordenDO.setMisionRef(refmis);
			ordenDO.setObjetivoRef(refobj);
			ordenDO.setPrioridad(1);
			OrdenDAO.insert(ordenDO);
			
			ordenDO = (IOrdenDO) GlobalDOFactory.getDO(IOrdenDO.class);
			refmis =new Reference<IMisionDO>();
			refmis.setRefIdent(misionDO[0].getId());
			refobj= new Reference<IObjetivoDO>();
			refobj.setRefIdent(objetivoDO[3].getId());
			ordenDO.setMisionRef(refmis);
			ordenDO.setObjetivoRef(refobj);
			ordenDO.setPrioridad(2);
			OrdenDAO.insert(ordenDO);
			
			//
			
			objetivoDO[4] = (IObjetivoDO) GlobalDOFactory.getDO(IObjetivoDO.class);
			objetivoDO[4].setDescripcion("Defender Hunamos en la Tierra.");
			objetivoDO[4].setNumeroDeNpc(2);
			refpl = new Reference<IPlanetaDO>();
			refpl.setRefIdent(PlanetaDO[16].getId());
			objetivoDO[4].setPlanetaRef(refpl);
			ObjetivoDAO.insert(objetivoDO[4]);

			ordenDO = (IOrdenDO) GlobalDOFactory.getDO(IOrdenDO.class);
			refmis =new Reference<IMisionDO>();
			refmis.setRefIdent(misionDO[4].getId());
			refobj= new Reference<IObjetivoDO>();
			refobj.setRefIdent(objetivoDO[3].getId());
			ordenDO.setMisionRef(refmis);
			ordenDO.setObjetivoRef(refobj);
			ordenDO.setPrioridad(1);
			OrdenDAO.insert(ordenDO);
			
			ordenDO = (IOrdenDO) GlobalDOFactory.getDO(IOrdenDO.class);
			refmis =new Reference<IMisionDO>();
			refmis.setRefIdent(misionDO[4].getId());
			refobj= new Reference<IObjetivoDO>();
			refobj.setRefIdent(objetivoDO[4].getId());
			ordenDO.setMisionRef(refmis);
			ordenDO.setObjetivoRef(refobj);
			ordenDO.setPrioridad(2);
			OrdenDAO.insert(ordenDO);
			
			objetivoDO[5] = (IObjetivoDO) GlobalDOFactory.getDO(IObjetivoDO.class);
			objetivoDO[5].setDescripcion("Evitar destrucion de Korugar.");
			objetivoDO[5].setNumeroDeNpc(2);
			refpl = new Reference<IPlanetaDO>();
			refpl.setRefIdent(PlanetaDO[22].getId());
			objetivoDO[5].setPlanetaRef(refpl);
			ObjetivoDAO.insert(objetivoDO[5]);
			
			ordenDO = (IOrdenDO) GlobalDOFactory.getDO(IOrdenDO.class);
			refmis =new Reference<IMisionDO>();
			refmis.setRefIdent(misionDO[4].getId());
			refobj= new Reference<IObjetivoDO>();
			refobj.setRefIdent(objetivoDO[5].getId());
			ordenDO.setMisionRef(refmis);
			ordenDO.setObjetivoRef(refobj);
			ordenDO.setPrioridad(3);
			OrdenDAO.insert(ordenDO);
			
			//
			
			ordenDO = (IOrdenDO) GlobalDOFactory.getDO(IOrdenDO.class);
			refmis =new Reference<IMisionDO>();
			refmis.setRefIdent(misionDO[3].getId());
			refobj= new Reference<IObjetivoDO>();
			refobj.setRefIdent(objetivoDO[3].getId());
			ordenDO.setMisionRef(refmis);
			ordenDO.setObjetivoRef(refobj);
			ordenDO.setPrioridad(1);
			OrdenDAO.insert(ordenDO);
			
			ordenDO = (IOrdenDO) GlobalDOFactory.getDO(IOrdenDO.class);
			refmis =new Reference<IMisionDO>();
			refmis.setRefIdent(misionDO[3].getId());
			refobj= new Reference<IObjetivoDO>();
			refobj.setRefIdent(objetivoDO[4].getId());
			ordenDO.setMisionRef(refmis);
			ordenDO.setObjetivoRef(refobj);
			ordenDO.setPrioridad(2);
			OrdenDAO.insert(ordenDO);
			
			//
			
			ordenDO = (IOrdenDO) GlobalDOFactory.getDO(IOrdenDO.class);
			refmis =new Reference<IMisionDO>();
			refmis.setRefIdent(misionDO[1].getId());
			refobj= new Reference<IObjetivoDO>();
			refobj.setRefIdent(objetivoDO[0].getId());
			ordenDO.setMisionRef(refmis);
			ordenDO.setObjetivoRef(refobj);
			ordenDO.setPrioridad(1);
			OrdenDAO.insert(ordenDO);
			
			ordenDO = (IOrdenDO) GlobalDOFactory.getDO(IOrdenDO.class);
			refmis =new Reference<IMisionDO>();
			refmis.setRefIdent(misionDO[1].getId());
			refobj= new Reference<IObjetivoDO>();
			refobj.setRefIdent(objetivoDO[5].getId());
			ordenDO.setMisionRef(refmis);
			ordenDO.setObjetivoRef(refobj);
			ordenDO.setPrioridad(2);
			OrdenDAO.insert(ordenDO);
			
		} finally {
			// Cerramos la Conexion
			ConnectionFactory.closeConnection(conn.getConnection());
		}

	}

}
