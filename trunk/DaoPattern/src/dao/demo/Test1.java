/**
 * Ejemplo de CREATE TABLE y INSERT usando Framework DAO
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

public class Test1 {

  public static void main(String[] args) throws Exception {

    //Obtener Conexion
    ConnectionBean conn = ConnectionFactory.getConnectionBean();

    //Instanciar DAO
    InterfaceDAO dd = FactoryDAO.getDAO(DepartmentDAO.class, conn);

    //CREATE TABLE
    dd.createTable();

    try {

      for (int i = 0; i < 11; i++) {
        DepartmentDO ddo = new DepartmentDO();

        ddo.setName("Foo" + i);
        ddo.setDescription("Faa" + i);

        //INSERT
        dd.insert(ddo);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      //Cerrar Conexion
      ConnectionFactory.closeConnection(conn.getConnection());
    }
  }
}
