package com.ulasoft.lanterncorpsacademy.logic;

import java.util.List;

import lcaInterfaceDAO.IHabilidadActivaDO;
import lcaInterfaceDAO.IHabilidadDAO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.INivelHabilidadDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;

public class VerHabilidadesAnillo {


	public static TestTableModel obtenerHabilidades(IPersonajeDO person, TestTableModel tableDtaModel) throws Exception{
		List<IHabilidadActivaDO> hab;
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IHabilidadDO h;
		IHabilidadDAO habilidad= (IHabilidadDAO) GlobalDAOFactory.getDAO( //
				IHabilidadDAO.class, connectionBean);
		IPersonajeDAO personaje = (IPersonajeDAO) GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);;
		personaje.loadHabilidadActivaList(person);
		hab = person.getHabilidadActivaList();
		for(int pos=0;pos<hab.size();pos++){
			h=(IHabilidadDO) habilidad.loadById((hab.get(pos).getHabilidadRef()).getRefIdent());
			tableDtaModel.add(h);
		}
		connectionBean.getConnection().close();
		return tableDtaModel;
	}
	
	public static String determinarTipo(int clase){
		switch (clase){
		case 1:
			return "Ataque";
		case 2:
			return "Defensa";
		case 3:
			return "Defensa y Ataque";
		case 4:
			return "Neutras";
		default:
			break;
		}
		return "";
	}
	public static int obtenerNivel(IHabilidadDO habilidad) throws Exception{
		int c=0;
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		List<INivelHabilidadDO> nhab;
		IHabilidadDAO h = (IHabilidadDAO) GlobalDAOFactory.getDAO( //
				IHabilidadDAO.class, connectionBean);
		h.loadNivelHabilidadList(habilidad);
		nhab = habilidad.getNivelHabilidadList();
		for(int pos=0;pos<(nhab.size());pos++){
  	  		if(habilidad.getId()== nhab.get(pos).getHabilidadRef().getRefIdent()){
  	  			c=nhab.get(pos).getNivel_de_habilidad();
  	  		}
  	  	}
  	  connectionBean.getConnection().close();
      return c;
	}
}
