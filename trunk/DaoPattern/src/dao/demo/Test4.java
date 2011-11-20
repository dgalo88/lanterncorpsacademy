/**
 * Ejemplo de manejo de relaciones usando Framework DAO
 * 
 * @author Demián Gutierrez
 * @date   13/04/2010
 * 
 */

package dao.demo;

import java.sql.SQLException;

import dao.api.FactoryDAO;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.example.DepartmentDAO;
import dao.example.DepartmentDO;
import dao.example.EmployeeDAO;
import dao.example.EmployeeDO;

public class Test4 {

  public static void main(String[] args) throws Exception {

    //Obtener Conexion
    ConnectionBean conn = ConnectionFactory.getConnectionBean();

    //Instanciar DAO
    DepartmentDAO daoDep = (DepartmentDAO) FactoryDAO.getDAO(DepartmentDAO.class, conn);
    EmployeeDAO daoEmp = (EmployeeDAO) FactoryDAO.getDAO(EmployeeDAO.class, conn);

    daoDep.createTable();
    daoEmp.createTable();

    try {

      DepartmentDO doComp = new DepartmentDO();
      doComp.setName("Computacion");
      doComp.setDescription("... bla, bla bla ...");

      //INSERT
      daoDep.insert(doComp);

      //Crea 10 empleados
      for (int i = 0; i < 10; i++) {
        EmployeeDO doEmp = new EmployeeDO();
        doEmp.setFrstName("Nombre " + i);
        doEmp.setLastName("Apellido " + i);
        doComp.getEmployeeList().add(doEmp);
        doEmp.getDepartmentRef().setRefValue(doComp);
        daoEmp.insert(doEmp);
      }
    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      ConnectionFactory.closeConnection(conn.getConnection());
    }
  }
}