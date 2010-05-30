package com.ulasoft.lanterncorpsacademy.logic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;

import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;

public class Ranking {

public static List<IPersonajeDO> obtenerRanking() throws Exception{
	IPersonajeDAO personaje;
	List<IPersonajeDO> personajes;
	ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
	personaje = (IPersonajeDAO) GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
	personajes = personaje.listRankin();
	connectionBean.getConnection().close();
	return personajes;
	}
public static void asignarRanking(TestTableModel tableDtaModel, List<IPersonajeDO> personajes){
	int posicion=0;
	while(personajes.get(posicion)==null){
		tableDtaModel.add(personajes.get(posicion));
	}
}
}
