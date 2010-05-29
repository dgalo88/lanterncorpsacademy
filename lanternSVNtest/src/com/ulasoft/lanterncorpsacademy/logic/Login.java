package com.ulasoft.lanterncorpsacademy.logic;

import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUsuarioDAO;
import lcaInterfaceDAO.IUsuarioDO;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

public class Login {

	public static IUsuarioDO verificarLogin(String txtCorreo, String fldPass) throws Exception {

        IUsuarioDO usDO = (IUsuarioDO) GlobalDOFactory.getDO(IUsuarioDO.class);
        
        ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
        IUsuarioDAO usDAO = (IUsuarioDAO) GlobalDAOFactory.getDAO(IUsuarioDAO.class, connectionBean);
        usDO = usDAO.loadByCorreo(txtCorreo);
        ConnectionFactory.closeConnection(connectionBean.getConnection());
        
    if (usDO == null) {
    return null;
}

if (fldPass.equals(usDO.getClave())) {
    return usDO;
}

return null;

}

public static IPersonajeDO cargarPersonaje(int personajeid) throws Exception {
        
        IPersonajeDO personDO = (IPersonajeDO) GlobalDOFactory.getDO(IPersonajeDO.class);
        
        ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
        IPersonajeDAO personDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
        personDO = (IPersonajeDO) personDAO.loadById(personajeid);
        
    if (personDO == null) {
    return null;
}
        
        return personDO;
}
}
