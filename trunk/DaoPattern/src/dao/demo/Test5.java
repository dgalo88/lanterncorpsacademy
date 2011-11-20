/**
 * Ejemplo de manejo de relaciones usando Framework DAO
 * 
 * @author Demián Gutierrez
 * @date   13/04/2010
 * 
 */

package dao.demo;

import java.sql.SQLException;
import java.util.List;

import dao.api.FactoryDAO;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.example.DepartmentDAO;
import dao.example.DepartmentDO;
import dao.example.EmployeeDAO;
import dao.example.EmployeeDO;

public class Test5 {

  public static void main(String[] args) throws Exception {

    //Obtener Conexion
    ConnectionBean conn = ConnectionFactory.getConnectionBean();

    //Instanciar DAO
    DepartmentDAO daoDep = (DepartmentDAO) FactoryDAO.getDAO(DepartmentDAO.class, conn);

    try {

      List<DepartmentDO> compList = daoDep.listByNameAndLikeDescription("Computacion", "bla");

      if (compList.isEmpty()) {
        return;
      }

      DepartmentDO departmentDO = compList.get(0);
      System.err.println("El nombre del departamento es: " + departmentDO.getName());
      System.err.println("La descripción del departamento es: " + departmentDO.getDescription());

      // Ahora necesitamos la lista de los empleados asociados al departamento...
      // Pero la lista est{a vacia, hay que cargarla...
      System.err.println(departmentDO.getEmployeeList().size());

      // Tiene sentido tratar de crear un nuevo departamento y tratar de añadirlo
      // a la lista aquí antes de cargar la lista???
      
      daoDep.loadEmployeeList(departmentDO); // Se carga la lista de empleados...
      System.err.println(departmentDO.getEmployeeList().size());
      
      EmployeeDO doEmp = new EmployeeDO();
      doEmp.setFrstName("NombreCCC ");
      doEmp.setLastName("ApellidoCCC ");
      departmentDO.getEmployeeList().add(doEmp);
      doEmp.getDepartmentRef().setRefValue(departmentDO);
      // INSERT

      for (EmployeeDO employeeDO : departmentDO.getEmployeeList()) {
        System.err.println("******************************>");
        System.err.println("Nombre: " + employeeDO.getFrstName());
        System.err.println("Apellido: " + employeeDO.getLastName());
      }

    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      ConnectionFactory.closeConnection(conn.getConnection());
    }
  }
}