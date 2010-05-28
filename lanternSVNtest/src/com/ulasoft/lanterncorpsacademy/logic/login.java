package com.ulasoft.lanterncorpsacademy.logic;

import java.sql.SQLException;

import lcaInterfaceDAO.IUsuarioDAO;
import lcaInterfaceDAO.IUsuarioDO;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class login {

	
	public static IUsuarioDO verificarlogin(IUsuarioDO usuario, String txtCorreo, String fldPass) throws Exception {
		
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IUsuarioDAO usDAO = (IUsuarioDAO) GlobalDAOFactory.getDAO(IUsuarioDAO.class, connectionBean);
		
		try {
			usuario = (IUsuarioDO) GlobalDOFactory.getDO(IUsuarioDO.class);
			usuario = usDAO.loadByCorreo(txtCorreo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionFactory.closeConnection(connectionBean.getConnection());
		
		if(usuario.getClave() != fldPass){
			return null;
		}else{
			return usuario;
		}
	}
}
