/**
 * Ejemplo de SELECT usando Framework DAO
 * 
 * @author Preparador Hugo Morillo
 * @date   25/03/2010
 * 
 */

package dao.demo;

import java.sql.SQLException;
import java.util.List;

import dao.api.DataObject;
import dao.api.FactoryDAO;
import dao.api.InterfaceDAO;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.example.DepartmentDAO;
import dao.example.DepartmentDO;

public class Test2 {

  public static void main(String[] args) throws Exception {

    //Obtener Conexion
    ConnectionBean conn = ConnectionFactory.getConnectionBean();

    //Instanciar DAO
    InterfaceDAO dd = FactoryDAO.getDAO(DepartmentDAO.class, conn);

    try {

      //SELECT ALL
      List<DataObject> dataList = dd.listAll();
      //List<DataObject> dataList = dd.listAll(3, 3);

      for (DataObject dataObject : dataList) {
        DepartmentDO ddo = (DepartmentDO) dataObject;
        System.err.println(ddo.getId() + ";" + ddo.getName() + ";" + ddo.getDescription());
      }

      System.err.println("**********************************");

      //SELECT BY ID
      DepartmentDO ddo = (DepartmentDO) dd.loadById(5);

      System.err.println(ddo.getId() + ";" + ddo.getName() + ";" + ddo.getDescription());

    } catch (SQLException e) {
      System.err.println("Error: " + e.getMessage());

    } finally {
      //Cerrar Conexion
      ConnectionFactory.closeConnection(conn.getConnection());
    }
  }
}
