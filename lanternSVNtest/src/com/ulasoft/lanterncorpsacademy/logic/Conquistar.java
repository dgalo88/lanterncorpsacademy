package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import lcaInterfaceDAO.INpcDAO;
import lcaInterfaceDAO.INpcDO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDAO;
import lcaInterfaceDAO.IPlanetaDO;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;

public class Conquistar {

	public static boolean isConquistado(IPersonajeDO personaje) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IPlanetaDAO planetaDAO = (IPlanetaDAO) //
				GlobalDAOFactory.getDAO(IPlanetaDAO.class, connectionBean);
		IPlanetaDO planeta = (IPlanetaDO) //
				planetaDAO.loadById(personaje.getPlanetaRef().getRefIdent());

		connectionBean.getConnection().close();
		return planeta.isConquistado();
	}

	public static List<INpcDO> obtenerNPCGuardianes(IPersonajeDO person) //
	throws Exception {

		Random random = new Random();

		List<INpcDO> personajes;
		List<INpcDO> npcGuardianes = new ArrayList<INpcDO>();

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		INpcDAO personaje = (INpcDAO) //
		GlobalDAOFactory.getDAO(INpcDAO.class, connectionBean);

		personajes = personaje.listNpc( //
				person.getClaseLinternaRef().getRefIdent());

		for (int i = 0; i < 5; i++) {
			npcGuardianes.add(personajes.get(random.nextInt(personajes.size())));
		}

		connectionBean.getConnection().close();

		return personajes;

	}

	public static TestTableModel asignarRankingNPC(TestTableModel tableDtaModel, //
			List<INpcDO> personajes) {

		for (int posicion = 0; posicion < personajes.size(); posicion++) {
			tableDtaModel.add(personajes.get(posicion));
		}
		return tableDtaModel;
	}

	public static int atacarNPCGuardianes(TestTableModel tableDtaModel, //
			List<INpcDO> personajes) {

		int result = 0;

		for (int posicion = 0; posicion < personajes.size(); posicion++) {
			try {
				result = Atacar.atacarNPC(personajes.get(posicion));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;

	}

}
