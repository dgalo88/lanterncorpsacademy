package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lcaInterfaceDAO.IAndroideDAO;
import lcaInterfaceDAO.IAndroideDO;
import lcaInterfaceDAO.IAndroidePersonajeDAO;
import lcaInterfaceDAO.IAndroideRecursoDAO;
import lcaInterfaceDAO.IAndroideRecursoDO;
import lcaInterfaceDAO.IClaseLinternaDAO;
import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IGrupoDAO;
import lcaInterfaceDAO.IHabilidadActivaDAO;
import lcaInterfaceDAO.IHabilidadClaseLinternaDAO;
import lcaInterfaceDAO.IHabilidadClaseLinternaDO;
import lcaInterfaceDAO.IHabilidadDAO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.INivelHabilidadDAO;
import lcaInterfaceDAO.INivelHabilidadDO;
import lcaInterfaceDAO.INpcDAO;
import lcaInterfaceDAO.INpcDO;
import lcaInterfaceDAO.IOfertaDAO;
import lcaInterfaceDAO.IOfertaPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPlanetaDAO;
import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IRecursoDAO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoOfertaCompraDAO;
import lcaInterfaceDAO.IRecursoOfertaVentaDAO;
import lcaInterfaceDAO.IRecursoPersonajeDAO;
import lcaInterfaceDAO.IRecursoPlanetaDAO;
import lcaInterfaceDAO.IRecursoPlanetaDO;
import lcaInterfaceDAO.ITecnologiaDAO;
import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.ITecnologiaPersonajeDAO;
import lcaInterfaceDAO.ITecnologiaRecursoDAO;
import lcaInterfaceDAO.ITecnologiaRecursoDO;
import lcaInterfaceDAO.IUnidadBasicaDAO;
import lcaInterfaceDAO.IUnidadBasicaDO;
import lcaInterfaceDAO.IUnidadBasicaPersonajeDAO;
import lcaInterfaceDAO.IUnidadBasicaRecursoDAO;
import lcaInterfaceDAO.IUnidadBasicaRecursoDO;
import lcaInterfaceDAO.IUnidadEjercitoDAO;
import lcaInterfaceDAO.IUnidadEjercitoOfertaDAO;
import lcaInterfaceDAO.IUnidadEjercitoPersonajeDAO;
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

		// Obtenemos la Conexión
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
		IUsuarioDAO UsuarioDAO = (IUsuarioDAO) //
			GlobalDAOFactory.getDAO(IUsuarioDAO.class, conn);
		IPersonajeDAO PersonajeDAO = (IPersonajeDAO) //
			GlobalDAOFactory.getDAO(IPersonajeDAO.class, conn);
		IClaseLinternaDAO ClaseLinternaDAO = (IClaseLinternaDAO) //
			GlobalDAOFactory.getDAO(IClaseLinternaDAO.class, conn);
		IPlanetaDAO PlanetaDAO = (IPlanetaDAO) //
			GlobalDAOFactory.getDAO(IPlanetaDAO.class, conn);
		IGrupoDAO GrupoDAO = (IGrupoDAO) //
			GlobalDAOFactory.getDAO(IGrupoDAO.class, conn);
		INpcDAO NpcDAO = (INpcDAO) //
			GlobalDAOFactory.getDAO(INpcDAO.class, conn);
		IHabilidadDAO HabilidadDAO = (IHabilidadDAO) //
			GlobalDAOFactory.getDAO(IHabilidadDAO.class, conn);
		IHabilidadClaseLinternaDAO HabilidadClaseLinternaDAO = (IHabilidadClaseLinternaDAO) //
			GlobalDAOFactory.getDAO(IHabilidadClaseLinternaDAO.class, conn);
		IHabilidadActivaDAO HabilidadActivaDAO = (IHabilidadActivaDAO) //
			GlobalDAOFactory.getDAO(IHabilidadActivaDAO.class, conn);
		INivelHabilidadDAO NivelHabilidadDAO = (INivelHabilidadDAO) //
			GlobalDAOFactory.getDAO(INivelHabilidadDAO.class, conn);

		// DAOs Nuevos
		IAndroideDAO AndroideDAO = (IAndroideDAO) //
			GlobalDAOFactory.getDAO(IAndroideDAO.class, conn);
		IAndroidePersonajeDAO AndroidePersonajeDAO = (IAndroidePersonajeDAO) //
			GlobalDAOFactory.getDAO(IAndroidePersonajeDAO.class, conn);
		IAndroideRecursoDAO AndroideRecursoDAO = (IAndroideRecursoDAO) //
			GlobalDAOFactory.getDAO(IAndroideRecursoDAO.class, conn);
		IOfertaDAO OfertaDAO = (IOfertaDAO) //
			GlobalDAOFactory.getDAO(IOfertaDAO.class, conn);
		IOfertaPersonajeDAO OfertaPersonajeDAO = (IOfertaPersonajeDAO) //
			GlobalDAOFactory.getDAO(IOfertaPersonajeDAO.class, conn);
		IRecursoDAO RecursoDAO = (IRecursoDAO) //
			GlobalDAOFactory.getDAO(IRecursoDAO.class, conn);
		IRecursoOfertaCompraDAO RecursoOfertaCompraDAO = (IRecursoOfertaCompraDAO) //
			GlobalDAOFactory.getDAO(IRecursoOfertaCompraDAO.class, conn);
		IRecursoOfertaVentaDAO RecursoOfertaVentaDAO = (IRecursoOfertaVentaDAO) //
			GlobalDAOFactory.getDAO(IRecursoOfertaVentaDAO.class, conn);
		IRecursoPersonajeDAO RecursoPersonajeDAO = (IRecursoPersonajeDAO) //
			GlobalDAOFactory.getDAO(IRecursoPersonajeDAO.class, conn);
		IRecursoPlanetaDAO RecursoPlanetaDAO = (IRecursoPlanetaDAO) //
			GlobalDAOFactory.getDAO(IRecursoPlanetaDAO.class, conn);
		ITecnologiaDAO TecnologiaDAO = (ITecnologiaDAO) //
			GlobalDAOFactory.getDAO(ITecnologiaDAO.class, conn);
		ITecnologiaPersonajeDAO TecnologiaPersonajeDAO = (ITecnologiaPersonajeDAO) //
			GlobalDAOFactory.getDAO(ITecnologiaPersonajeDAO.class, conn);
		ITecnologiaRecursoDAO TecnologiaRecursoDAO = (ITecnologiaRecursoDAO) //
			GlobalDAOFactory.getDAO(ITecnologiaRecursoDAO.class, conn);
		IUnidadBasicaDAO UnidadBasicaDAO = (IUnidadBasicaDAO) //
			GlobalDAOFactory.getDAO(IUnidadBasicaDAO.class, conn);
		IUnidadBasicaPersonajeDAO UnidadBasicaPersonajeDAO = (IUnidadBasicaPersonajeDAO) //
			GlobalDAOFactory.getDAO(IUnidadBasicaPersonajeDAO.class, conn);
		IUnidadBasicaRecursoDAO UnidadBasicaRecursoDAO = (IUnidadBasicaRecursoDAO) //
			GlobalDAOFactory.getDAO(IUnidadBasicaRecursoDAO.class, conn);
		IUnidadEjercitoDAO UnidadEjercito = (IUnidadEjercitoDAO) //
			GlobalDAOFactory.getDAO(IUnidadEjercitoDAO.class, conn); 
		IUnidadEjercitoOfertaDAO UnidadEjercitoOfertaDAO = (IUnidadEjercitoOfertaDAO) //
			GlobalDAOFactory.getDAO(IUnidadEjercitoOfertaDAO.class, conn);
		IUnidadEjercitoPersonajeDAO UnidadEjercitoPersonajeDAO = (IUnidadEjercitoPersonajeDAO) //
			GlobalDAOFactory.getDAO(IUnidadEjercitoPersonajeDAO.class, conn);


		// creamos las tablas
		PlanetaDAO.createTable();
		ClaseLinternaDAO.createTable();
		GrupoDAO.createTable();
		PersonajeDAO.createTable();
		UsuarioDAO.createTable();
		NpcDAO.createTable();
		HabilidadDAO.createTable();
		NivelHabilidadDAO.createTable();
		HabilidadActivaDAO.createTable();
		HabilidadClaseLinternaDAO.createTable();

		// Tablas Nuevas
		RecursoDAO.createTable();
		RecursoPersonajeDAO.createTable();
		RecursoPlanetaDAO.createTable();
		TecnologiaDAO.createTable();
		UnidadBasicaDAO.createTable();
		TecnologiaPersonajeDAO.createTable();
		TecnologiaRecursoDAO.createTable();
		AndroideDAO.createTable();
		AndroidePersonajeDAO.createTable();
		AndroideRecursoDAO.createTable();
		OfertaDAO.createTable();
		OfertaPersonajeDAO.createTable();
		RecursoOfertaCompraDAO.createTable();
		RecursoOfertaVentaDAO.createTable();
		UnidadBasicaPersonajeDAO.createTable();
		UnidadBasicaRecursoDAO.createTable();
		UnidadEjercito.createTable(); 
		UnidadEjercitoOfertaDAO.createTable();
		UnidadEjercitoPersonajeDAO.createTable();

		try {

			// PLANETAS
			IPlanetaDO PlanetaDO[] = new IPlanetaDO[48];

			for (int i = 0; i < PlanetaDO.length; i++) {
				PlanetaDO[i] = (IPlanetaDO) GlobalDOFactory.getDO(IPlanetaDO.class);
			}

			// NOMBRES DE LOS PLANETAS
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

			// SECTORES
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

			// COORDENADA X
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

			// COORDENADA Y
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

			// CONQUISTADO
			for (int i = 0; i < PlanetaDO.length; i++) {
				PlanetaDO[i].setConquistado(false);
			}
			PlanetaDO[VERDE].setConquistado(true);
			PlanetaDO[AMARILLO].setConquistado(true);
			PlanetaDO[ROJO].setConquistado(true);
			PlanetaDO[NEGRO].setConquistado(true);
			PlanetaDO[AZUL].setConquistado(true);
			PlanetaDO[INDIGO].setConquistado(true);
			PlanetaDO[VIOLETA].setConquistado(true);

			// INSERT PLANETA
			for (int i = 0; i < PlanetaDO.length; i++) {
				PlanetaDAO.insert(PlanetaDO[i]);
			}

			// XXX: RECURSOS
			IRecursoDO RecursoDO[] = new IRecursoDO[8];

			for (int i = 0; i < RecursoDO.length; i++) {
				RecursoDO[i] = (IRecursoDO) GlobalDOFactory.getDO(IRecursoDO.class);
			}

			RecursoDO[0].setNombre("Plomo");
			RecursoDO[1].setNombre("Hierro");
			RecursoDO[2].setNombre("Acero");
			RecursoDO[3].setNombre("Uranio");
			RecursoDO[4].setNombre("Titanio");
			RecursoDO[5].setNombre("Cristalo");
			RecursoDO[6].setNombre("Adamantium");
			RecursoDO[7].setNombre("Vibratium");

			for (int i = 0; i < RecursoDO.length; i++) {
				RecursoDO[i].setArticulo(i+1);
				RecursoDAO.insert(RecursoDO[i]);
			}

			// REFERENCIAS PLANETA-RECURSO
			IRecursoPlanetaDO RecursoPlanetaDO1[] = new IRecursoPlanetaDO[PlanetaDO.length];
			IRecursoPlanetaDO RecursoPlanetaDO2[] = new IRecursoPlanetaDO[PlanetaDO.length];

			for (int i = 0; i < PlanetaDO.length; i++) {

				RecursoPlanetaDO1[i] = (IRecursoPlanetaDO) //
					GlobalDOFactory.getDO(IRecursoPlanetaDO.class);
				RecursoPlanetaDO2[i] = (IRecursoPlanetaDO) //
					GlobalDOFactory.getDO(IRecursoPlanetaDO.class);

			}

			Reference<IRecursoDO> refRecurso1;
			Reference<IRecursoDO> refRecurso2;
			Reference<IPlanetaDO> refPlaneta;

			List<IRecursoPlanetaDO> recursoPlanetaList;
			Random random = new Random();

			// ASIGNA RECURSOS A LOS PLANETAS BASE
			// ASEGURANDO QUE EN TODOS EL RECURSO 1 SEA PLOMO
			// Y EL RECURSO 2 HIERRO, ACERO O URANIO ALEATORIAMENTE
			refRecurso1 = new Reference<IRecursoDO>();
			IRecursoDO refValue = (IRecursoDO) RecursoDAO.loadById(1);
			refRecurso1.setRefValue(refValue);

			for (int i = 0; i < 7; i++) {

				RecursoPlanetaDO1[i].setCantidad_maxima_recurso(random.nextInt(200) + 100);
				RecursoPlanetaDO2[i].setCantidad_maxima_recurso(random.nextInt(200) + 100);

				recursoPlanetaList = new ArrayList<IRecursoPlanetaDO>();

				refPlaneta = new Reference<IPlanetaDO>();
				refPlaneta.setRefIdent(PlanetaDO[i].getId());
				RecursoPlanetaDO1[i].setPlanetaRef(refPlaneta);
				RecursoPlanetaDO2[i].setPlanetaRef(refPlaneta);

				refRecurso2 = new Reference<IRecursoDO>();
				refValue = (IRecursoDO) RecursoDAO.loadById((random.nextInt(3) + 1) + 1);
				refRecurso2.setRefValue(refValue);

				RecursoPlanetaDO1[i].setRecursoRef(refRecurso1);
				RecursoPlanetaDO2[i].setRecursoRef(refRecurso2);

				RecursoPlanetaDAO.insert(RecursoPlanetaDO1[i]);
				RecursoPlanetaDAO.insert(RecursoPlanetaDO2[i]);

				recursoPlanetaList.add(RecursoPlanetaDO1[i]);
				recursoPlanetaList.add(RecursoPlanetaDO2[i]);
				PlanetaDO[i].setRecursoPlanetaList(recursoPlanetaList);
				PlanetaDAO.update(PlanetaDO[i]);

				recursoPlanetaList.removeAll(recursoPlanetaList);

			}

			// ASIGNA RECURSOS ALEATORIAMENTE AL RESTO DE PLANETAS
			for (int i = 7; i < PlanetaDO.length; ) {

				int ref1 = random.nextInt(RecursoDO.length) + 1;
				int ref2 = random.nextInt(RecursoDO.length) + 1;

				if (ref1 == ref2) {
					continue;
				}

				RecursoPlanetaDO1[i].setCantidad_maxima_recurso(random.nextInt(200) + 100);
				RecursoPlanetaDO2[i].setCantidad_maxima_recurso(random.nextInt(200) + 100);

				recursoPlanetaList = new ArrayList<IRecursoPlanetaDO>();

				refRecurso1 = new Reference<IRecursoDO>();
				refRecurso2 = new Reference<IRecursoDO>();

				IRecursoDO refValue1;
				IRecursoDO refValue2;

				refPlaneta = new Reference<IPlanetaDO>();
				refPlaneta.setRefIdent(PlanetaDO[i].getId());

				RecursoPlanetaDO1[i].setPlanetaRef(refPlaneta);
				RecursoPlanetaDO2[i].setPlanetaRef(refPlaneta);

				refValue1 = (IRecursoDO) RecursoDAO.loadById(ref1);
				refRecurso1.setRefValue(refValue1);
				RecursoPlanetaDO1[i].setRecursoRef(refRecurso1);
				recursoPlanetaList.add(RecursoPlanetaDO1[i]);

				refValue2 = (IRecursoDO) RecursoDAO.loadById(ref2);
				refRecurso2.setRefValue(refValue2);
				RecursoPlanetaDO2[i].setRecursoRef(refRecurso2);
				recursoPlanetaList.add(RecursoPlanetaDO2[i]);

				RecursoPlanetaDAO.insert(RecursoPlanetaDO1[i]);
				RecursoPlanetaDAO.insert(RecursoPlanetaDO2[i]);

				PlanetaDO[i].setRecursoPlanetaList(recursoPlanetaList);
				PlanetaDAO.update(PlanetaDO[i]);

				recursoPlanetaList.removeAll(recursoPlanetaList);

				i++;

			}

			// TECNOLOGIAS
			ITecnologiaDO TecnologiaDO[] = new ITecnologiaDO[48];

			for (int i = 0; i < TecnologiaDO.length; i++) {
				TecnologiaDO[i] = (ITecnologiaDO) //
					GlobalDOFactory.getDO(ITecnologiaDO.class);
			}
			TecnologiaDO[0].setNombre("Tecnologia para Robot Plomo");
			TecnologiaDO[1].setNombre("Tecnologia para Robot Hierro");
			TecnologiaDO[2].setNombre("Tecnologia para Robot Acero");
			TecnologiaDO[3].setNombre("Tecnologia para Robot Uranio");
			TecnologiaDO[4].setNombre("Tecnologia para Robot Titanio");
			TecnologiaDO[5].setNombre("Tecnologia para Robot Cristalo");
			TecnologiaDO[6].setNombre("Tecnologia para Robot Adamantium");
			TecnologiaDO[7].setNombre("Tecnologia para Robot Vibratium");
			TecnologiaDO[8].setNombre("Tecnologia para Arma Plomo");
			TecnologiaDO[9].setNombre("Tecnologia para Arma Hierro");
			TecnologiaDO[10].setNombre("Tecnologia para Arma Acero");
			TecnologiaDO[11].setNombre("Tecnologia para Arma Uranio");
			TecnologiaDO[12].setNombre("Tecnologia para Arma Titanio");
			TecnologiaDO[13].setNombre("Tecnologia para Arma Cristalo");
			TecnologiaDO[14].setNombre("Tecnologia para Arma Adamantium");
			TecnologiaDO[15].setNombre("Tecnologia para Arma Vibratium");
			TecnologiaDO[16].setNombre("Tecnologia para Vehiculo Plomo");
			TecnologiaDO[17].setNombre("Tecnologia para Vehiculo Hierro");
			TecnologiaDO[18].setNombre("Tecnologia para Vehiculo Acero");
			TecnologiaDO[19].setNombre("Tecnologia para Vehiculo Uranio");
			TecnologiaDO[20].setNombre("Tecnologia para Vehiculo Titanio");
			TecnologiaDO[21].setNombre("Tecnologia para Vehiculo Cristalo");
			TecnologiaDO[22].setNombre("Tecnologia para Vehiculo Adamantium");
			TecnologiaDO[23].setNombre("Tecnologia para Vehiculo Vibratium");
			TecnologiaDO[24].setNombre("Tecnologia para Bala Plomo");
			TecnologiaDO[25].setNombre("Tecnologia para Bala Hierro");
			TecnologiaDO[26].setNombre("Tecnologia para Bala Acero");
			TecnologiaDO[27].setNombre("Tecnologia para Bala Uranio");
			TecnologiaDO[28].setNombre("Tecnologia para Bala Titanio");
			TecnologiaDO[29].setNombre("Tecnologia para Bala Cristalo");
			TecnologiaDO[30].setNombre("Tecnologia para Bala Adamantium");
			TecnologiaDO[31].setNombre("Tecnologia para Bala Vibratium");

			TecnologiaDO[32].setNombre("Tecnologia para Recolector de Plomo");
			TecnologiaDO[33].setNombre("Tecnologia para Recolector de Hierro");
			TecnologiaDO[34].setNombre("Tecnologia para Recolector de Acero");
			TecnologiaDO[35].setNombre("Tecnologia para Recolector de Uranio");
			TecnologiaDO[36].setNombre("Tecnologia para Recolector de Titanio");
			TecnologiaDO[37].setNombre("Tecnologia para Recolector de Cristalo");
			TecnologiaDO[38].setNombre("Tecnologia para Recolector de Adamantium");
			TecnologiaDO[39].setNombre("Tecnologia para Recolector de Vibratium");
			TecnologiaDO[40].setNombre("Tecnologia para Saboteador de Plomo");
			TecnologiaDO[41].setNombre("Tecnologia para Saboteador de Hierro");
			TecnologiaDO[42].setNombre("Tecnologia para Saboteador de Acero");
			TecnologiaDO[43].setNombre("Tecnologia para Saboteador de Uranio");
			TecnologiaDO[44].setNombre("Tecnologia para Saboteador de Titanio");
			TecnologiaDO[45].setNombre("Tecnologia para Saboteador de Cristalo");
			TecnologiaDO[46].setNombre("Tecnologia para Saboteador de Adamantium");
			TecnologiaDO[47].setNombre("Tecnologia para Saboteador de Vibratium");

			// INSERT TECNOLOGIAS
			for (int i = 0; i < TecnologiaDO.length; i++) {
				TecnologiaDAO.insert(TecnologiaDO[i]);
			}

			// VALORES DE ATAQUE Y DEFENSA PARA UNIDADES BASICAS
			int valor[] = new int[8];
			valor[0] = 1;
			valor[1] = 2;
			valor[2] = 3;
			valor[3] = 4;
			valor[4] = 5;
			valor[5] = 6;
			valor[6] = 8;
			valor[7] = 10;

			// UNIDADES BASICAS
			IUnidadBasicaDO UnidadBasicaDO[] = new IUnidadBasicaDO[32];

			for (int i = 0; i < UnidadBasicaDO.length; i++) {
				UnidadBasicaDO[i] = (IUnidadBasicaDO) //
					GlobalDOFactory.getDO(IUnidadBasicaDO.class);
			}
			// Unidades Basicas - Robots
			UnidadBasicaDO[0].setNombre("Robot Plomo");
			UnidadBasicaDO[1].setNombre("Robot Hierro");
			UnidadBasicaDO[2].setNombre("Robot Acero");
			UnidadBasicaDO[3].setNombre("Robot Uranio");
			UnidadBasicaDO[4].setNombre("Robot Titanio");
			UnidadBasicaDO[5].setNombre("Robot Cristalo");
			UnidadBasicaDO[6].setNombre("Robot Adamantium");
			UnidadBasicaDO[7].setNombre("Robot Vibratium");

			// Unidades Basicas - Armas
			UnidadBasicaDO[8].setNombre("Arma Plomo");
			UnidadBasicaDO[9].setNombre("Arma Hierro");
			UnidadBasicaDO[10].setNombre("Arma Acero");
			UnidadBasicaDO[11].setNombre("Arma Uranio");
			UnidadBasicaDO[12].setNombre("Arma Titanio");
			UnidadBasicaDO[13].setNombre("Arma Cristalo");
			UnidadBasicaDO[14].setNombre("Arma Adamantium");
			UnidadBasicaDO[15].setNombre("Arma Vibratium");

			// Unidades Basicas - Vehiculos
			UnidadBasicaDO[16].setNombre("Vehiculo Plomo");
			UnidadBasicaDO[17].setNombre("Vehiculo Hierro");
			UnidadBasicaDO[18].setNombre("Vehiculo Acero");
			UnidadBasicaDO[19].setNombre("Vehiculo Uranio");
			UnidadBasicaDO[20].setNombre("Vehiculo Titanio");
			UnidadBasicaDO[21].setNombre("Vehiculo Cristalo");
			UnidadBasicaDO[22].setNombre("Vehiculo Adamantium");
			UnidadBasicaDO[23].setNombre("Vehiculo Vibratium");

			// Unidades Basicas - Balas
			UnidadBasicaDO[24].setNombre("Bala Plomo");
			UnidadBasicaDO[25].setNombre("Bala Hierro");
			UnidadBasicaDO[26].setNombre("Bala Acero");
			UnidadBasicaDO[27].setNombre("Bala Uranio");
			UnidadBasicaDO[28].setNombre("Bala Titanio");
			UnidadBasicaDO[29].setNombre("Bala Cristalo");
			UnidadBasicaDO[30].setNombre("Bala Adamantium");
			UnidadBasicaDO[31].setNombre("Bala Vibratium");

			for (int i = 0, j = 0; i < 32; i++, j++) {

				Reference<ITecnologiaDO> tecnologiaRef = new Reference<ITecnologiaDO>();
				ITecnologiaDO tecnologiaRefValue = (ITecnologiaDO) TecnologiaDAO.loadById(i+1);
				tecnologiaRef.setRefValue(tecnologiaRefValue);

				UnidadBasicaDO[i].setTecnologiaRef(tecnologiaRef);

				if (i >= 0 && i < 8) {
					UnidadBasicaDO[i].setAtaque(0);
					UnidadBasicaDO[i].setDefensa(valor[j]);
					UnidadBasicaDO[i].setTipo(i+1);
				}
				if (i >= 8 && i < 16) {
					UnidadBasicaDO[i].setAtaque(valor[j-8]);
					UnidadBasicaDO[i].setDefensa(0);
					UnidadBasicaDO[i].setTipo(i+1);
				}
				if (i >= 16 && i < 24) {
					UnidadBasicaDO[i].setAtaque(0);
					UnidadBasicaDO[i].setDefensa(valor[j-16]);
					UnidadBasicaDO[i].setTipo(i+1);
				}
				if (i >= 24 && i < 32) {
					UnidadBasicaDO[i].setAtaque(valor[j-24]);
					UnidadBasicaDO[i].setDefensa(0);
					UnidadBasicaDO[i].setTipo(i+1);
				}

			}

			// INSERT UNIDADES BASICAS
			for (int i = 0; i < UnidadBasicaDO.length; i++) {
				UnidadBasicaDAO.insert(UnidadBasicaDO[i]);
			}

			// TODO: ASIGNAR PRECIOS A LAS UNIDADES BASICAS
			IUnidadBasicaRecursoDO UnidadBasicaRecursoDO[] = new IUnidadBasicaRecursoDO[81];

			for (int i = 0; i < UnidadBasicaRecursoDO.length; i++) {
				UnidadBasicaRecursoDO[i] = (IUnidadBasicaRecursoDO) //
						GlobalDOFactory.getDO(IUnidadBasicaRecursoDO.class);
			}

			Reference<IUnidadBasicaDO> refUnidadBasica;
			IUnidadBasicaDO refUnidadBasicaValue[] = new IUnidadBasicaDO[32];
			for (int i = 0; i < refUnidadBasicaValue.length; i++) {
				refUnidadBasicaValue[i] = (IUnidadBasicaDO) UnidadBasicaDAO.loadById(i+1);
			}

			List<IUnidadBasicaRecursoDO> unidadBasicaRecursoList;

			// ASIGNAR PRECIOS A LAS UNIDAD ROBOT 1

			// Plomo 10
			UnidadBasicaRecursoDO[0].setCantidad(10);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(1);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[0].setRecursoRef(refRecurso1);

			// Hierro 15
			UnidadBasicaRecursoDO[1].setCantidad(15);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(2);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[1].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[0]);
			UnidadBasicaRecursoDO[0].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[1].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[0]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[1]);
			UnidadBasicaDO[0].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD ROBOT 2

			// Plomo 10
			UnidadBasicaRecursoDO[2].setCantidad(10);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(1);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[2].setRecursoRef(refRecurso1);

			// Hierro 15
			UnidadBasicaRecursoDO[3].setCantidad(20);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(2);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[3].setRecursoRef(refRecurso1);

			// Acero 10
			UnidadBasicaRecursoDO[4].setCantidad(10);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(3);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[4].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[1]);
			UnidadBasicaRecursoDO[2].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[3].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[4].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[2]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[3]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[4]);
			UnidadBasicaDO[1].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD ROBOT 3

			// Hierro 40
			UnidadBasicaRecursoDO[5].setCantidad(40);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(2);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[5].setRecursoRef(refRecurso1);

			// Acero 30
			UnidadBasicaRecursoDO[6].setCantidad(30);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(3);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[6].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[2]);
			UnidadBasicaRecursoDO[5].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[6].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[5]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[6]);
			UnidadBasicaDO[2].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD ROBOT 4

			// acero 40
			UnidadBasicaRecursoDO[7].setCantidad(40);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(3);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[7].setRecursoRef(refRecurso1);

			// Uranio 50
			UnidadBasicaRecursoDO[8].setCantidad(50);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(4);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[8].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[3]);
			UnidadBasicaRecursoDO[7].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[8].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[7]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[8]);
			UnidadBasicaDO[3].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD ROBOT 5

			// Hierro 100
			UnidadBasicaRecursoDO[9].setCantidad(100);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(2);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[9].setRecursoRef(refRecurso1);

			// Acero 10
			UnidadBasicaRecursoDO[10].setCantidad(10);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(3);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[10].setRecursoRef(refRecurso1);

			// Uranio 40
			UnidadBasicaRecursoDO[11].setCantidad(40);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(4);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[11].setRecursoRef(refRecurso1);

			// Titanio 60
			UnidadBasicaRecursoDO[12].setCantidad(60);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(5);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[12].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[4]);
			UnidadBasicaRecursoDO[9].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[10].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[11].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[12].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[9]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[10]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[11]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[12]);
			UnidadBasicaDO[4].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD ROBOT 6

			// Plomo 10
			UnidadBasicaRecursoDO[13].setCantidad(10);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(1);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[13].setRecursoRef(refRecurso1);

			// Hierro 30
			UnidadBasicaRecursoDO[14].setCantidad(30);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(2);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[14].setRecursoRef(refRecurso1);

			// Acero 40
			UnidadBasicaRecursoDO[15].setCantidad(40);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(3);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[15].setRecursoRef(refRecurso1);

			// Uranio 40
			UnidadBasicaRecursoDO[16].setCantidad(40);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(4);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[16].setRecursoRef(refRecurso1);

			// Titanio 80
			UnidadBasicaRecursoDO[17].setCantidad(80);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(5);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[17].setRecursoRef(refRecurso1);

			// Cristalo
			UnidadBasicaRecursoDO[18].setCantidad(100);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(6);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[18].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[5]);
			UnidadBasicaRecursoDO[13].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[14].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[15].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[16].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[17].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[18].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[13]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[14]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[15]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[16]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[17]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[18]);
			UnidadBasicaDO[5].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD ROBOT 7

			// Plomo 200
			UnidadBasicaRecursoDO[19].setCantidad(200);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(1);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[19].setRecursoRef(refRecurso1);

			// Hierro 200
			UnidadBasicaRecursoDO[20].setCantidad(200);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(2);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[20].setRecursoRef(refRecurso1);

			// Uranio 60
			UnidadBasicaRecursoDO[21].setCantidad(60);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(4);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[21].setRecursoRef(refRecurso1);

			// Titanio 80
			UnidadBasicaRecursoDO[22].setCantidad(80);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(5);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[22].setRecursoRef(refRecurso1);

			// Cristalo 90
			UnidadBasicaRecursoDO[23].setCantidad(90);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(6);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[23].setRecursoRef(refRecurso1);

			// Adamantium 200
			UnidadBasicaRecursoDO[24].setCantidad(200);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(7);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[24].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[6]);
			UnidadBasicaRecursoDO[19].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[20].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[21].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[22].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[23].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[24].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[19]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[20]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[21]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[22]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[23]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[24]);
			UnidadBasicaDO[6].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD ROBOT 8

			// Plomo 100
			UnidadBasicaRecursoDO[25].setCantidad(100);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(1);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[25].setRecursoRef(refRecurso1);

			// Hierro 100
			UnidadBasicaRecursoDO[26].setCantidad(100);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(2);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[26].setRecursoRef(refRecurso1);

			// Acero 100
			UnidadBasicaRecursoDO[27].setCantidad(100);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(3);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[27].setRecursoRef(refRecurso1);

			// Uranio 100
			UnidadBasicaRecursoDO[28].setCantidad(100);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(4);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[28].setRecursoRef(refRecurso1);

			// Titanio 100
			UnidadBasicaRecursoDO[29].setCantidad(100);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(5);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[29].setRecursoRef(refRecurso1);

			// Cristalo 100
			UnidadBasicaRecursoDO[30].setCantidad(100);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(6);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[30].setRecursoRef(refRecurso1);

			// Adamantium 100
			UnidadBasicaRecursoDO[31].setCantidad(100);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(7);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[31].setRecursoRef(refRecurso1);

			// Vibratrium 200
			UnidadBasicaRecursoDO[32].setCantidad(200);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(8);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[32].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[7]);
			UnidadBasicaRecursoDO[25].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[26].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[27].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[28].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[29].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[30].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[31].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[32].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[25]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[26]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[27]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[28]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[29]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[30]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[31]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[32]);
			UnidadBasicaDO[7].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD ARMA 1

			// Plomo 30
			UnidadBasicaRecursoDO[33].setCantidad(30);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(1);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[33].setRecursoRef(refRecurso1);

			// Hierro 5
			UnidadBasicaRecursoDO[34].setCantidad(5);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(2);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[34].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[8]);
			UnidadBasicaRecursoDO[33].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[34].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[33]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[34]);
			UnidadBasicaDO[8].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD ARMA 2

			// Plomo 10
			UnidadBasicaRecursoDO[35].setCantidad(10);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(1);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[35].setRecursoRef(refRecurso1);

			// Hierro 30
			UnidadBasicaRecursoDO[36].setCantidad(30);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(2);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[36].setRecursoRef(refRecurso1);

			// Acero 20
			UnidadBasicaRecursoDO[37].setCantidad(20);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(3);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[37].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[9]);
			UnidadBasicaRecursoDO[35].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[36].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[37].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[35]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[36]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[37]);
			UnidadBasicaDO[9].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD ARMA 3

			// Hierro 20
			UnidadBasicaRecursoDO[38].setCantidad(20);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(2);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[38].setRecursoRef(refRecurso1);

			// Acero 50
			UnidadBasicaRecursoDO[39].setCantidad(50);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(3);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[39].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[10]);
			UnidadBasicaRecursoDO[38].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[39].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[38]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[39]);
			UnidadBasicaDO[10].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD ARMA 4

			// acero 50
			UnidadBasicaRecursoDO[40].setCantidad(50);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(3);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[40].setRecursoRef(refRecurso1);

			// Uranio 60
			UnidadBasicaRecursoDO[41].setCantidad(60);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(4);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[41].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[11]);
			UnidadBasicaRecursoDO[40].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[41].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[40]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[41]);
			UnidadBasicaDO[11].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD ARMA 5

			// Hierro 100
			UnidadBasicaRecursoDO[42].setCantidad(100);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(2);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[42].setRecursoRef(refRecurso1);

			// Acero 20
			UnidadBasicaRecursoDO[43].setCantidad(20);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(3);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[43].setRecursoRef(refRecurso1);

			// Uranio 80
			UnidadBasicaRecursoDO[44].setCantidad(80);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(4);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[44].setRecursoRef(refRecurso1);

			// Titanio 80
			UnidadBasicaRecursoDO[45].setCantidad(80);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(5);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[45].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[12]);
			UnidadBasicaRecursoDO[42].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[43].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[44].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[45].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[42]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[43]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[44]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[45]);
			UnidadBasicaDO[12].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD ARMA 6

			// Titanio 100
			UnidadBasicaRecursoDO[46].setCantidad(100);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(5);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[46].setRecursoRef(refRecurso1);

			// Cristalo 100
			UnidadBasicaRecursoDO[47].setCantidad(100);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(6);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[47].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[13]);
			UnidadBasicaRecursoDO[46].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[47].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[46]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[47]);
			UnidadBasicaDO[13].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD ARMA 7

			// Cristalo 200
			UnidadBasicaRecursoDO[48].setCantidad(200);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(6);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[48].setRecursoRef(refRecurso1);

			// Adamantium 400
			UnidadBasicaRecursoDO[49].setCantidad(400);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(7);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[49].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[14]);
			UnidadBasicaRecursoDO[48].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[49].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[48]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[49]);
			UnidadBasicaDO[14].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD ARMA 8

			// Cristalo 300
			UnidadBasicaRecursoDO[50].setCantidad(300);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(6);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[50].setRecursoRef(refRecurso1);

			// Adamantium 300
			UnidadBasicaRecursoDO[51].setCantidad(300);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(7);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[51].setRecursoRef(refRecurso1);

			// Vibratrium 500
			UnidadBasicaRecursoDO[52].setCantidad(500);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(8);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[52].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[15]);
			UnidadBasicaRecursoDO[50].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[51].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[52].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[50]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[51]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[52]);
			UnidadBasicaDO[15].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD VEHICULO 1

			// Plomo 30
			UnidadBasicaRecursoDO[53].setCantidad(30);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(1);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[53].setRecursoRef(refRecurso1);

			// Hierro 5
			UnidadBasicaRecursoDO[54].setCantidad(5);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(2);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[54].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[16]);
			UnidadBasicaRecursoDO[53].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[54].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[53]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[54]);
			UnidadBasicaDO[16].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD VEHICULO 2

			// Plomo 10
			UnidadBasicaRecursoDO[55].setCantidad(10);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(1);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[55].setRecursoRef(refRecurso1);

			// Hierro 30
			UnidadBasicaRecursoDO[56].setCantidad(30);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(2);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[56].setRecursoRef(refRecurso1);

			// Acero 20
			UnidadBasicaRecursoDO[57].setCantidad(20);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(3);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[57].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[17]);
			UnidadBasicaRecursoDO[55].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[56].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[57].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[55]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[56]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[57]);
			UnidadBasicaDO[17].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD VEHICULO 3

			// Hierro 20
			UnidadBasicaRecursoDO[58].setCantidad(20);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(2);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[58].setRecursoRef(refRecurso1);

			// Acero 50
			UnidadBasicaRecursoDO[59].setCantidad(50);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(3);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[59].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[18]);
			UnidadBasicaRecursoDO[58].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[59].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[58]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[59]);
			UnidadBasicaDO[18].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD VEHICULO 4

			// acero 50
			UnidadBasicaRecursoDO[60].setCantidad(50);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(3);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[60].setRecursoRef(refRecurso1);

			// Uranio 60
			UnidadBasicaRecursoDO[61].setCantidad(60);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(4);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[61].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[19]);
			UnidadBasicaRecursoDO[60].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[61].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[60]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[61]);
			UnidadBasicaDO[19].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD VEHICULO 5

			// Hierro 100
			UnidadBasicaRecursoDO[62].setCantidad(100);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(2);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[62].setRecursoRef(refRecurso1);

			// Acero 20
			UnidadBasicaRecursoDO[63].setCantidad(20);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(3);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[63].setRecursoRef(refRecurso1);

			// Uranio 80
			UnidadBasicaRecursoDO[64].setCantidad(80);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(4);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[64].setRecursoRef(refRecurso1);

			// Titanio 80
			UnidadBasicaRecursoDO[65].setCantidad(80);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(5);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[65].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[20]);
			UnidadBasicaRecursoDO[62].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[63].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[64].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[65].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[62]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[63]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[64]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[65]);
			UnidadBasicaDO[20].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD VEHICULO 6

			// Titanio 100
			UnidadBasicaRecursoDO[66].setCantidad(100);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(5);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[66].setRecursoRef(refRecurso1);

			// Cristalo 100
			UnidadBasicaRecursoDO[67].setCantidad(100);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(6);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[67].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[21]);
			UnidadBasicaRecursoDO[66].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[67].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[66]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[67]);
			UnidadBasicaDO[21].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD VEHICULO 7

			// Cristalo 200
			UnidadBasicaRecursoDO[68].setCantidad(200);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(6);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[68].setRecursoRef(refRecurso1);

			// Adamantium 400
			UnidadBasicaRecursoDO[69].setCantidad(400);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(7);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[69].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[22]);
			UnidadBasicaRecursoDO[68].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[69].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[68]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[69]);
			UnidadBasicaDO[22].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// ASIGNAR PRECIOS A LAS UNIDAD VEHICULO 8

			// Cristalo 300
			UnidadBasicaRecursoDO[70].setCantidad(300);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(6);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[70].setRecursoRef(refRecurso1);

			// Adamantium 300
			UnidadBasicaRecursoDO[71].setCantidad(300);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(7);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[71].setRecursoRef(refRecurso1);

			// Vibratrium 500
			UnidadBasicaRecursoDO[72].setCantidad(500);
			refRecurso1 = new Reference<IRecursoDO>();
			refValue = (IRecursoDO) RecursoDAO.loadById(8);
			refRecurso1.setRefValue(refValue);
			UnidadBasicaRecursoDO[72].setRecursoRef(refRecurso1);

			refUnidadBasica = new Reference<IUnidadBasicaDO>();
			refUnidadBasica.setRefValue(refUnidadBasicaValue[23]);
			UnidadBasicaRecursoDO[70].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[71].setUnidadBasicaRef(refUnidadBasica);
			UnidadBasicaRecursoDO[72].setUnidadBasicaRef(refUnidadBasica);

			unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[70]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[71]);
			unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[72]);
			UnidadBasicaDO[23].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			// TODO: ASIGNAR PRECIOS A LAS UNIDAD BALA 1-8
			for (int i = 0; i < 8; i++) {

				UnidadBasicaRecursoDO[i+73].setCantidad(valor[i] * 10);

				refRecurso1 = new Reference<IRecursoDO>();
				refValue = (IRecursoDO) RecursoDAO.loadById(i+1);
				refRecurso1.setRefValue(refValue);
				UnidadBasicaRecursoDO[i+73].setRecursoRef(refRecurso1);

				refUnidadBasica = new Reference<IUnidadBasicaDO>();
				refUnidadBasica.setRefValue(refUnidadBasicaValue[i+24]);
				UnidadBasicaRecursoDO[i+73].setUnidadBasicaRef(refUnidadBasica);

				unidadBasicaRecursoList = new ArrayList<IUnidadBasicaRecursoDO>();
				unidadBasicaRecursoList.add(UnidadBasicaRecursoDO[i+73]);

				UnidadBasicaDO[i+24].setUnidadBasicaRecursoList(unidadBasicaRecursoList);

			}

			// ASIGNO LOS COSTOS DE LAS TECNOLOGIAS
			ITecnologiaRecursoDO TecnologiaRecursoDO[] = new ITecnologiaRecursoDO[97];
			for (int i = 0; i < TecnologiaRecursoDO.length; i++) {
				TecnologiaRecursoDO[i] = (ITecnologiaRecursoDO) //
					GlobalDOFactory.getDO(ITecnologiaRecursoDO.class);
			}

			// INSERT UNIDADES BASICAS-RECURSO & TECNOLOGIA-RECURSO(1-81)
			for (int i = 0; i < UnidadBasicaRecursoDO.length; i++) {

				TecnologiaRecursoDO[i].setCantidad(UnidadBasicaRecursoDO[i].getCantidad() * 5);
				TecnologiaRecursoDO[i].setRecursoRef(UnidadBasicaRecursoDO[i].getRecursoRef());
				TecnologiaRecursoDO[i].setTecnologiaRef( //
						UnidadBasicaRecursoDO[i].getUnidadBasicaRef() //
						.getRefValue().getTecnologiaRef());

				TecnologiaRecursoDAO.insert(TecnologiaRecursoDO[i]);
				UnidadBasicaRecursoDAO.insert(UnidadBasicaRecursoDO[i]);
			}

			// UPDATE UNIDADES BASICAS
			for (int i = 0; i < UnidadBasicaDO.length; i++) {
				UnidadBasicaDAO.update(UnidadBasicaDO[i]);
			}

			// ANDROIDES
			IAndroideDO AndroideDO[] = new IAndroideDO[16];

			for (int i = 0; i < AndroideDO.length; i++) {
				AndroideDO[i] = (IAndroideDO) //
					GlobalDOFactory.getDO(IAndroideDO.class);
			}
			// Unidades Recolectoras
			AndroideDO[0].setNombre("Recolector de Plomo");
			AndroideDO[1].setNombre("Recolector de Hierro");
			AndroideDO[2].setNombre("Recolector de Acero");
			AndroideDO[3].setNombre("Recolector de Uranio");
			AndroideDO[4].setNombre("Recolector de Titanio");
			AndroideDO[5].setNombre("Recolector de Cristalo");
			AndroideDO[6].setNombre("Recolector de Adamantium");
			AndroideDO[7].setNombre("Recolector de Vibratium");

			// Unidades Saboteadoras
			AndroideDO[8].setNombre("Saboteador de Plomo");
			AndroideDO[9].setNombre("Saboteador de Hierro");
			AndroideDO[10].setNombre("Saboteador de Acero");
			AndroideDO[11].setNombre("Saboteador de Uranio");
			AndroideDO[12].setNombre("Saboteador de Titanio");
			AndroideDO[13].setNombre("Saboteador de Cristalo");
			AndroideDO[14].setNombre("Saboteador de Adamantium");
			AndroideDO[15].setNombre("Saboteador de Vibratium");

			IAndroideRecursoDO AndroideRecursoDO[] = new IAndroideRecursoDO[16];

			for (int i = 0, j = 0; i < AndroideDO.length; i++, j++) {

				AndroideDO[i].setTipo(i+1);

				Reference<ITecnologiaDO> tecnologiaRef = new Reference<ITecnologiaDO>();
				ITecnologiaDO tecnologiaRefValue = (ITecnologiaDO) TecnologiaDAO.loadById(i+33);
				tecnologiaRef.setRefValue(tecnologiaRefValue);
				AndroideDO[i].setTecnologiaRef(tecnologiaRef);

				AndroideDAO.insert(AndroideDO[i]);

				AndroideRecursoDO[i] = (IAndroideRecursoDO) //
					GlobalDOFactory.getDO(IAndroideRecursoDO.class);

				if (7 < j) {
					j = 0;
				}
				refRecurso1 = new Reference<IRecursoDO>();
				refValue = (IRecursoDO) RecursoDAO.loadById(j+1);
				refRecurso1.setRefValue(refValue);
				AndroideRecursoDO[i].setRecursoRef(refRecurso1);

				Reference<IAndroideDO> androideRef = new Reference<IAndroideDO>();
				IAndroideDO refValueAndroide = (IAndroideDO) AndroideDAO.loadById(i+1);
				androideRef.setRefValue(refValueAndroide);
				AndroideRecursoDO[i].setAndroideRef(androideRef);

				AndroideRecursoDO[i].setCantidad(100);

				TecnologiaRecursoDO[i+81].setCantidad(AndroideRecursoDO[i].getCantidad() * 5);
				TecnologiaRecursoDO[i+81].setRecursoRef(AndroideRecursoDO[i].getRecursoRef());
				TecnologiaRecursoDO[i+81].setTecnologiaRef(tecnologiaRef);

				TecnologiaRecursoDAO.insert(TecnologiaRecursoDO[i+81]);

				List<IAndroideRecursoDO> androideRecursoList = //
					new ArrayList<IAndroideRecursoDO>();
				androideRecursoList.add(AndroideRecursoDO[i]);

				AndroideRecursoDAO.insert(AndroideRecursoDO[i]);

				AndroideDO[i].setAndroideRecursojeList(androideRecursoList);
				AndroideDAO.update(AndroideDO[i]);

			}

			// REFERENCIAS EN TENOLOGIA A UNIDAD BASICA
			for (int i = 0; i < UnidadBasicaDO.length; i++) {

				Reference<IUnidadBasicaDO> unidadBasicaRef = //
					new Reference<IUnidadBasicaDO>();
				IUnidadBasicaDO unidadBasicaRefValue = (IUnidadBasicaDO) //
					UnidadBasicaDAO.loadById(i+1);
				unidadBasicaRef.setRefValue(unidadBasicaRefValue);
				TecnologiaDO[i].setUnidadBasicaRef(unidadBasicaRef);

				TecnologiaDAO.update(TecnologiaDO[i]);
			}

			// REFERENCIAS EN TENOLOGIA A ANDROIDE
			for (int i = 0; i < AndroideDO.length; i++) {

				Reference<IAndroideDO> androideRef = //
					new Reference<IAndroideDO>();
				IAndroideDO androideRefValue = (IAndroideDO) //
					AndroideDAO.loadById(i+1);
				androideRef.setRefValue(androideRefValue);
				TecnologiaDO[i+32].setAndroideRef(androideRef);

				TecnologiaDAO.update(TecnologiaDO[i+32]);
			}

			// XXX: CREATE CLASELINTERNA
			IClaseLinternaDO ClaseLinternaDO[] = new IClaseLinternaDO[7];

			for (int i = 0; i < ClaseLinternaDO.length; i++) {
				ClaseLinternaDO[i] = (IClaseLinternaDO) //
					GlobalDOFactory.getDO(IClaseLinternaDO.class);
			}

			ClaseLinternaDO[VERDE].setColor("Verde");
			ClaseLinternaDO[AMARILLO].setColor("Amarillo");
			ClaseLinternaDO[ROJO].setColor("Rojo");
			ClaseLinternaDO[AZUL].setColor("Azul");
			ClaseLinternaDO[NEGRO].setColor("Negro");
			ClaseLinternaDO[INDIGO].setColor("Indigo");
			ClaseLinternaDO[VIOLETA].setColor("Violeta");

			ClaseLinternaDO[VERDE].setNombre_de_cuerpo_linterna( //
					"Green Lantern Corps");
			ClaseLinternaDO[AMARILLO].setNombre_de_cuerpo_linterna( //
					"Sinestro Corps");
			ClaseLinternaDO[ROJO].setNombre_de_cuerpo_linterna( //
					"Red Lantern Corps");
			ClaseLinternaDO[AZUL].setNombre_de_cuerpo_linterna( //
					"Blue Lantern Corps");
			ClaseLinternaDO[NEGRO].setNombre_de_cuerpo_linterna( //
					"Black Lantern Corps");
			ClaseLinternaDO[INDIGO].setNombre_de_cuerpo_linterna( //
					"Tribu Indigo");
			ClaseLinternaDO[VIOLETA].setNombre_de_cuerpo_linterna( //
					"Star Sapphires");

			// CREATE REFERENCE TO PLANETA AND INSERT CLASELINTERNA
			Reference<IPlanetaDO> refpl;
			Reference<IClaseLinternaDO> refcl[] = new Reference[ClaseLinternaDO.length];

			for (int i = 0; i < ClaseLinternaDO.length; i++) {

				refpl = new Reference<IPlanetaDO>();
				refpl.setRefIdent(PlanetaDO[i].getId());
				refcl[i] = new Reference<IClaseLinternaDO>();
				refcl[i].setRefIdent(ClaseLinternaDO[i].getId());
				ClaseLinternaDO[i].setPlanetaRef(refpl);
				ClaseLinternaDAO.insert(ClaseLinternaDO[i]);

			}

			// CREATE AND INSERT HABILIDADES
			for (int i = 0; i < ClaseLinternaDO.length; i++) {

				refcl[i] = new Reference<IClaseLinternaDO>();
				refcl[i].setRefIdent(ClaseLinternaDO[i].getId());

			}

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
				NivelHabilidadDO[i] = (INivelHabilidadDO) GlobalDOFactory
				.getDO(INivelHabilidadDO.class);
				NivelHabilidadDO[i].setNivel_de_habilidad(i + 1);
				NivelHabilidadDO[i].setEfectividad(50 + i * 5);
				NivelHabilidadDO[i].setCosto_de_energia(20 - i);
				NivelHabilidadDO[i].setHabilidadRef(refhab);
				NivelHabilidadDAO.insert(NivelHabilidadDO[i]);
			}			
			IHabilidadClaseLinternaDO habilidadClaseLinternaDO = 
				(IHabilidadClaseLinternaDO) GlobalDOFactory
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


			// XXX: NPC

			INpcDO npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Abin Sur");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Verde");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Barreer WoT");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Verde");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Fentara Rrab");
			npcDO.setNivel(2);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Verde");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Bizarro Green Lantern");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Amarillo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Maash");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Amarillo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Tekik");
			npcDO.setNivel(2);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Amarillo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Bleez");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Rojo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Mera");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Rojo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Dex-Starr");
			npcDO.setNivel(2);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Rojo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Diamalon");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Negro");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Katma Tui");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Negro");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Terrence Long");
			npcDO.setNivel(2);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Negro");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Hymn");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Azul");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Sercy");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Azul");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Barry Allen");
			npcDO.setNivel(2);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Azul");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Indigo-1");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Indigo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Munk");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Indigo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Ray Palmer");
			npcDO.setNivel(2);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Indigo");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Cowgirl");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Violeta");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Dela Pharon");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Violeta");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Jillian Pearlman");
			npcDO.setNivel(2);
			npcDO.setSalud(150);
			npcDO.setDano(15);
			npcDO.setColor("Violeta");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Paul Kirk");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Neutral");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("clon de Paul Kirk");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Neutral");
			NpcDAO.insert(npcDO);

			npcDO=(INpcDO) GlobalDOFactory.getDO(INpcDO.class);
			npcDO.setNombre("Kate Spencer");
			npcDO.setNivel(1);
			npcDO.setSalud(100);
			npcDO.setDano(10);
			npcDO.setColor("Neutral");
			NpcDAO.insert(npcDO);

			System.out.println("\nBase de Datos Inicializada\n");

		} finally {
			// Cerramos la Conexion
			ConnectionFactory.closeConnection(conn.getConnection());
		}

	}

}
