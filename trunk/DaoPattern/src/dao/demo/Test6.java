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
import dao.example.DepartmentDO;
import dao.example.EmployeeDAO;
import dao.example.EmployeeDO;

public class Test6 {

  public static void main(String[] args) throws Exception {

    //Obtener Conexion
    ConnectionBean conn = ConnectionFactory.getConnectionBean();

    //Instanciar DAO
    EmployeeDAO daoEmp = (EmployeeDAO) FactoryDAO.getDAO(EmployeeDAO.class, conn);

    try {

      EmployeeDO employeeDO = (EmployeeDO) daoEmp.loadById(5); // Cargar un empleado cualquiera (por id)

      if (employeeDO == null) {
        return;
      }

      System.err.println("******************************>");
      System.err.println("El nombre: " + employeeDO.getFrstName());
      System.err.println("El apellido: " + employeeDO.getLastName());

      // Ahora necesitamos el departamento asociado al empleado...
      // Pero la lista referencia está vacía... hay que cargarla
      System.err.println("******************************>");
      System.err.println("El id (sólo por curiosidad): " + employeeDO.getDepartmentRef().getRefIdent());
      System.err.println("La referencia: " + employeeDO.getDepartmentRef().getRefValue());

      // Tiene sentido apuntar el empleado a otro departamento antes de cargar la referencia?

      daoEmp.loadDepartmentRef(employeeDO); // Se carga la referencia al departamento

      System.err.println("******************************>");
      System.err.println("El id (sólo por curiosidad): " + employeeDO.getDepartmentRef().getRefIdent());
      System.err.println("La referencia: " + employeeDO.getDepartmentRef().getRefValue());

      DepartmentDO departmentDO = employeeDO.getDepartmentRef().getRefValue();

      System.err.println("******************************>");
      System.err.println("El nombre del departamento es: " + departmentDO.getName());
      System.err.println("La descripción del departamento es: " + departmentDO.getDescription());
    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      ConnectionFactory.closeConnection(conn.getConnection());
    }
  }
}