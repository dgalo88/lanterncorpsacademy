/**
 * Ejemplo de UPDATE y DELETE usando Framework DAO
 * 
 * @author Preparador Hugo Morillo
 * @date   25/03/2010
 * 
 */

package dao.demo;

import java.sql.SQLException;

import dao.api.FactoryDAO;
import dao.api.InterfaceDAO;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.example.DepartmentDAO;
import dao.example.DepartmentDO;

public class Test3 {

  public static void main(String[] args) throws Exception {

    //Obtener Conexion
    ConnectionBean conn = ConnectionFactory.getConnectionBean();

    //Instanciar DAO
    InterfaceDAO dd = FactoryDAO.getDAO(DepartmentDAO.class, conn);

    try {

      DepartmentDO ddo = (DepartmentDO) dd.loadById(10);

      ddo.setName("NewName");
      ddo.setDescription("NewDescription");

      //UPDATE
      dd.update(ddo);

      for (int i = 1; i < 5; i++) {
        DepartmentDO ddoo = (DepartmentDO) dd.loadById(i);
        dd.delete(ddoo);
      }

    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      ConnectionFactory.closeConnection(conn.getConnection());
    }
  }
}