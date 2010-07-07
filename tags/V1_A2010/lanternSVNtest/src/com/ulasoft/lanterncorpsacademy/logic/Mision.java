package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import lcaInterfaceDAO.IGrupoDAO;
import lcaInterfaceDAO.IMisionClaseLinternaDAO;
import lcaInterfaceDAO.IMisionClaseLinternaDO;
import lcaInterfaceDAO.IMisionDAO;
import lcaInterfaceDAO.IMisionDO;
import lcaInterfaceDAO.IPersonajeDO;

public class Mision {
	
	public static List<IMisionDO> obtenerMisiones(IPersonajeDO personaje)
	throws Exception {
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		List<IMisionDO> lMisionDO = new ArrayList<IMisionDO>();
		IMisionDAO misionDAO = (IMisionDAO) GlobalDAOFactory.getDAO( //
				IMisionDAO.class, connectionBean);
		lMisionDO = misionDAO.listPlayable(personaje.getId());
		return lMisionDO;
		
	}
	public static TestTableModel asignarMision(TestTableModel tableDtaModel,
			List<IMisionDO> lMisionDO) {
		for (int posicion = 0; posicion < lMisionDO.size(); posicion++) {
			tableDtaModel.add(lMisionDO.get(posicion));

		}
		return tableDtaModel;
	}

}
