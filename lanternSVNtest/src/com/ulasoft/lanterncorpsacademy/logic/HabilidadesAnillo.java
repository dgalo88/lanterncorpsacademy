package com.ulasoft.lanterncorpsacademy.logic;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IGrupoDO;
import lcaInterfaceDAO.IHabilidadActivaDAO;
import lcaInterfaceDAO.IHabilidadActivaDO;
import lcaInterfaceDAO.IHabilidadDAO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.INivelHabilidadDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;

import com.ulasoft.lanterncorpsacademy.TestTableModel;

import dao.api.DataObject;
import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class HabilidadesAnillo {


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
	public static int obtenerNivel(int personajeId, IHabilidadDO habilidad) throws Exception{
		int c;
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IHabilidadActivaDO habAct;
		IHabilidadActivaDAO hActDAO = (IHabilidadActivaDAO) GlobalDAOFactory.getDAO( //
				IHabilidadActivaDAO.class, connectionBean);
		habAct=(IHabilidadActivaDO) hActDAO.loadByHabilidadId(habilidad.getId(), personajeId);
//		nhab = habilidad.getNivelHabilidadList();
//		for(int pos=0;pos<(habAct.size());pos++){
//  	  		if(habilidad.getId()== habAct.get(pos).getHabilidadRef().getRefIdent()){
//  	  			c=nhab.get(pos).getNivel_de_habilidad();
//  	  		}
//  	  	}
  	  connectionBean.getConnection().close();
  	  if(habAct.getNivel_habilidad()==0){
  		 return 0;
  	  }
      return c=habAct.getNivel_habilidad();
	}

	public static TestTableModel obtenerHabilidadesCompra(
			IPersonajeDO personaje, TestTableModel tableDtaModel) throws Exception {
		List<DataObject> hab;
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IHabilidadDAO habilidad= (IHabilidadDAO) GlobalDAOFactory.getDAO( //
				IHabilidadDAO.class, connectionBean);
		hab = habilidad.listToBuy(personaje.getId());
		for(int pos=0;pos<hab.size();pos++){
			tableDtaModel.add((IHabilidadDO) hab.get(pos));
		}
		return tableDtaModel;
	}

	public static boolean entrenarHabilidades(List<Integer> seleccion,
			IPersonajeDO personaje) throws Exception {
		int costo=0;
		List<IHabilidadActivaDO> hab;
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IHabilidadDAO habilidad= (IHabilidadDAO) GlobalDAOFactory.getDAO( //
				IHabilidadDAO.class, connectionBean);
		IPersonajeDAO personaje1 = (IPersonajeDAO) GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);;
		personaje1.loadHabilidadActivaList(personaje);
		hab = personaje.getHabilidadActivaList();
		for(int pos=0;pos < seleccion.size();pos++){
			costo+=(Math.pow(2, hab.get(seleccion.get(pos)).getNivel_habilidad())*100);
		}
		if(costo>personaje.getPuntosDeEntrenamiento()){
			return true;
		}
		personaje.setPuntosDeEntrenamiento(personaje.getPuntosDeEntrenamiento()-costo);
		personaje1.update(personaje);
		for(int pos=0;pos < seleccion.size();pos++){
			hab.get(seleccion.get(pos)).setNivel_habilidad(hab.get(seleccion.get(pos)).getNivel_habilidad()+1);
			habilidad.update(hab.get(seleccion.get(pos)));
		}
		connectionBean.getConnection().close();
		return false;
	}
	public static boolean adquirirHabilidades(List<Integer> seleccion, IPersonajeDO personaje) throws Exception {
		int costo=0;
		List<DataObject> hab;
		List<IHabilidadDO> hab1 = new ArrayList<IHabilidadDO>();
		IHabilidadActivaDO habact = (IHabilidadActivaDO) GlobalDOFactory.getDO( //
				IHabilidadActivaDO.class);
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IHabilidadDAO habilidad= (IHabilidadDAO) GlobalDAOFactory.getDAO( //
				IHabilidadDAO.class, connectionBean);
		IHabilidadActivaDAO habilidadActiva= (IHabilidadActivaDAO) GlobalDAOFactory.getDAO( //
				IHabilidadActivaDAO.class, connectionBean);
		hab = habilidad.listToBuy(personaje.getId());
		for(int pos=0;pos<hab.size();pos++){
			hab1.add((IHabilidadDO) hab.get(pos));
		}
		for(int pos=0;pos<seleccion.size();pos++){
			costo+=hab1.get(seleccion.get(pos)).getCosto_de_aprendizaje();
			
		}
		if(costo>personaje.getPuntosDeEntrenamiento()){
			return true;
		}
		Reference<IPersonajeDO> personRef = new Reference<IPersonajeDO>();
		personRef.setRefIdent(personaje.getId());
		Reference<IHabilidadDO> habilidadRef = new Reference<IHabilidadDO>();
		for(int pos=0;pos<seleccion.size();pos++){
			habilidadRef.setRefIdent(hab1.get(seleccion.get(pos)).getId());
			habact.setNivel_habilidad(1);
			habact.setPersonajeRef(personRef);
			habact.setHabilidadRef(habilidadRef);
			habilidadActiva.insert(habact);
		}
		return false;
	}
}
