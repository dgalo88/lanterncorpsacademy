package dao.test;

import java.util.Iterator;

import junit.framework.TestCase;
import dao.api.FactoryDAO;
import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.example.DepartmentDAO;
import dao.example.DepartmentDO;
import dao.example.EmployeeDAO;
import dao.example.EmployeeDO;

/**
 * @author Demián Gutierrez
 */
public class TestDepartmentEmployee extends TestCase {

  private boolean compareDODeep(DepartmentDO departmentDO1, DepartmentDO departmentDO2) {
    boolean ret = true;

    ret = ret && departmentDO1.getId() == departmentDO2.getId();
    ret = ret && departmentDO1.getName().equals(departmentDO2.getName());
    ret = ret && departmentDO1.getDescription().equals(departmentDO2.getDescription());

    if (departmentDO1.getEmployeeList().size() != //
    departmentDO2.getEmployeeList().size()) {
      return false;
    }

    Iterator<EmployeeDO> itt1 = departmentDO1.getEmployeeList().iterator();
    Iterator<EmployeeDO> itt2 = departmentDO2.getEmployeeList().iterator();

    while (itt1.hasNext() && itt2.hasNext()) {
      EmployeeDO employeeDO1 = (EmployeeDO) itt1.next();
      EmployeeDO employeeDO2 = (EmployeeDO) itt2.next();

      compareDOShallow(employeeDO1, employeeDO2);
    }

    return ret;
  }

  // --------------------------------------------------------------------------------

  private boolean compareDODeep(EmployeeDO employeeDO1, EmployeeDO employeeDO2) {
    boolean ret = true;

    ret = ret && employeeDO1.getId() == employeeDO2.getId();
    ret = ret && employeeDO1.getFrstName().equals(employeeDO2.getFrstName());
    ret = ret && employeeDO1.getLastName().equals(employeeDO2.getLastName());

    Reference<DepartmentDO> ref1 = employeeDO1.getDepartmentRef();
    Reference<DepartmentDO> ref2 = employeeDO2.getDepartmentRef();

    ret = ret && ref1.getRefIdent() == ref2.getRefIdent();

    compareDOShallow(ref1.getRefValue(), ref2.getRefValue());

    return ret;
  }

  // --------------------------------------------------------------------------------

  private boolean compareDOShallow(DepartmentDO departmentDO1, DepartmentDO departmentDO2) {
    boolean ret = true;

    ret = ret && departmentDO1.getId() == departmentDO2.getId();
    ret = ret && departmentDO1.getName().equals(departmentDO2.getName());
    ret = ret && departmentDO1.getDescription().equals(departmentDO2.getDescription());

    return ret;
  }

  // --------------------------------------------------------------------------------

  private boolean compareDOShallow(EmployeeDO employeeDO1, EmployeeDO employeeDO2) {
    boolean ret = true;

    ret = ret && employeeDO1.getId() == employeeDO2.getId();
    ret = ret && employeeDO1.getFrstName().equals(employeeDO2.getFrstName());
    ret = ret && employeeDO1.getLastName().equals(employeeDO2.getLastName());

    return ret;
  }

  // --------------------------------------------------------------------------------

  public void testRefOnInsert() throws Exception {
    ConnectionBean connectionBean;

    DepartmentDAO departmentDAO;
    EmployeeDAO employeeDAO;

    // ----------------------------------------

    connectionBean = ConnectionFactory.getConnectionBean();

    // ----------------------------------------
    // INSERT Departments
    // ----------------------------------------

    departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
        DepartmentDAO.class, connectionBean);
    departmentDAO.createTable();

    DepartmentDO departmentDO1 = new DepartmentDO();
    departmentDO1.setName("FooName111");
    departmentDO1.setDescription("FooDescription111");
    departmentDAO.insert(departmentDO1);
    assertEquals(departmentDO1.getId(), 1);

    DepartmentDO departmentDO2 = new DepartmentDO();
    departmentDO2.setName("FooName222");
    departmentDO2.setDescription("FooDescription222");
    departmentDAO.insert(departmentDO2);
    assertEquals(departmentDO2.getId(), 2);

    // ----------------------------------------
    // INSERT Employees
    // ----------------------------------------

    employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
        EmployeeDAO.class, connectionBean);
    employeeDAO.createTable();

    EmployeeDO employeeDO1 = new EmployeeDO();
    employeeDO1.setFrstName("FrstName111");
    employeeDO1.setLastName("LastName111");
    //employeeDO1.setDepartmentRef(departmentDO1); // ----------> LINK
    employeeDO1.getDepartmentRef().setRefValue(departmentDO1); // ----------> LINK
    departmentDO1.getEmployeeList().add(employeeDO1); // -----> LINK
    employeeDAO.insert(employeeDO1);
    assertEquals(employeeDO1.getId(), 1);

    EmployeeDO employeeDO2 = new EmployeeDO();
    employeeDO2.setFrstName("FrstName222");
    employeeDO2.setLastName("LastName222");
    //employeeDO2.setDepartmentRef(departmentDO1); // ----------> LINK
    employeeDO2.getDepartmentRef().setRefValue(departmentDO1); // ----------> LINK
    departmentDO1.getEmployeeList().add(employeeDO2); // -----> LINK
    employeeDAO.insert(employeeDO2);
    assertEquals(employeeDO2.getId(), 2);

    EmployeeDO employeeDO3 = new EmployeeDO();
    employeeDO3.setFrstName("FrstName333");
    employeeDO3.setLastName("LastName333");
    //employeeDO3.setDepartmentRef(departmentDO2); // ----------> LINK
    employeeDO3.getDepartmentRef().setRefValue(departmentDO2); // ----------> LINK
    departmentDO2.getEmployeeList().add(employeeDO3); // -----> LINK
    employeeDAO.insert(employeeDO3);
    assertEquals(employeeDO3.getId(), 3);

    EmployeeDO employeeDO4 = new EmployeeDO();
    employeeDO4.setFrstName("FrstName444");
    employeeDO4.setLastName("LastName444");
    //employeeDO4.setDepartmentRef(departmentDO2); // ----------> LINK
    employeeDO4.getDepartmentRef().setRefValue(departmentDO2); // ----------> LINK
    departmentDO2.getEmployeeList().add(employeeDO4); // -----> LINK
    employeeDAO.insert(employeeDO4);
    assertEquals(employeeDO4.getId(), 4);

    ConnectionFactory.closeConnection(connectionBean.getConnection());

    // ----------------------------------------
    // LOAD / CHECK Departments
    // ----------------------------------------

    connectionBean = ConnectionFactory.getConnectionBean();

    departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
        DepartmentDAO.class, connectionBean);

    DepartmentDO departmentDOX = (DepartmentDO) departmentDAO.loadById(1);
    departmentDAO.loadEmployeeList(departmentDOX);
    assertTrue(compareDODeep(departmentDO1, departmentDOX));

    DepartmentDO departmentDOY = (DepartmentDO) departmentDAO.loadById(2);
    departmentDAO.loadEmployeeList(departmentDOY);
    assertTrue(compareDODeep(departmentDO2, departmentDOY));

    ConnectionFactory.closeConnection(connectionBean.getConnection());

    // ----------------------------------------
    // LOAD / CHECK Employees
    // ----------------------------------------

    connectionBean = ConnectionFactory.getConnectionBean();

    employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
        EmployeeDAO.class, connectionBean);

    EmployeeDO employeeDOX = (EmployeeDO) employeeDAO.loadById(1);
    employeeDAO.loadDepartmentRef(employeeDOX);
    assertTrue(compareDODeep(employeeDO1, employeeDOX));

    EmployeeDO employeeDOY = (EmployeeDO) employeeDAO.loadById(2);
    employeeDAO.loadDepartmentRef(employeeDOY);
    assertTrue(compareDODeep(employeeDO2, employeeDOY));

    ConnectionFactory.closeConnection(connectionBean.getConnection());
  }

  // --------------------------------------------------------------------------------

  public void testRefOnUpdate() throws Exception {
    ConnectionBean connectionBean;

    DepartmentDAO departmentDAO;
    EmployeeDAO employeeDAO;

    // ----------------------------------------

    connectionBean = ConnectionFactory.getConnectionBean();

    // ----------------------------------------
    // INSERT Departments
    // ----------------------------------------

    departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
        DepartmentDAO.class, connectionBean);
    departmentDAO.createTable();

    DepartmentDO departmentDO1 = new DepartmentDO();
    departmentDO1.setName("FooName111");
    departmentDO1.setDescription("FooDescription111");
    departmentDAO.insert(departmentDO1);
    assertEquals(departmentDO1.getId(), 1);

    DepartmentDO departmentDO2 = new DepartmentDO();
    departmentDO2.setName("FooName222");
    departmentDO2.setDescription("FooDescription222");
    departmentDAO.insert(departmentDO2);
    assertEquals(departmentDO2.getId(), 2);

    // ----------------------------------------
    // INSERT Employees
    // ----------------------------------------

    employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
        EmployeeDAO.class, connectionBean);
    employeeDAO.createTable();

    // d1 -> e1
    EmployeeDO employeeDO1 = new EmployeeDO();
    employeeDO1.setFrstName("FrstName111");
    employeeDO1.setLastName("LastName111");
    //employeeDO1.setDepartmentRef(departmentDO1); // ----------> LINK
    employeeDO1.getDepartmentRef().setRefValue(departmentDO1); // ----------> LINK
    departmentDO1.getEmployeeList().add(employeeDO1); // -----> LINK
    employeeDAO.insert(employeeDO1);
    assertEquals(employeeDO1.getId(), 1);

    // d2 -> e2
    EmployeeDO employeeDO2 = new EmployeeDO();
    employeeDO2.setFrstName("FrstName222");
    employeeDO2.setLastName("LastName222");
    //employeeDO2.setDepartmentRef(departmentDO2); // ----------> LINK
    employeeDO2.getDepartmentRef().setRefValue(departmentDO2); // ----------> LINK
    departmentDO2.getEmployeeList().add(employeeDO2); // -----> LINK
    employeeDAO.insert(employeeDO2);
    assertEquals(employeeDO2.getId(), 2);

    // e3 -> (No dep)
    EmployeeDO employeeDO3 = new EmployeeDO();
    employeeDO3.setFrstName("FrstName333");
    employeeDO3.setLastName("LastName333");
    //employeeDO3.setDepartmentRef(departmentDO1); // ----------> LINK
    //departmentDO2.getEmployeeList().add(employeeDO3); // -----> LINK
    employeeDAO.insert(employeeDO3);
    assertEquals(employeeDO3.getId(), 3);

    // e4 -> (No dep)
    EmployeeDO employeeDO4 = new EmployeeDO();
    employeeDO4.setFrstName("FrstName444");
    employeeDO4.setLastName("LastName444");
    //employeeDO4.setDepartmentRef(departmentDO2); // ----------> LINK
    //departmentDO2.getEmployeeList().add(employeeDO4); // -----> LINK
    employeeDAO.insert(employeeDO4);
    assertEquals(employeeDO4.getId(), 4);

    ConnectionFactory.closeConnection(connectionBean.getConnection());

    // ----------------------------------------
    // LOAD / UPDATE Departments
    // ----------------------------------------

    connectionBean = ConnectionFactory.getConnectionBean();

    departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
        DepartmentDAO.class, connectionBean);
    employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
        EmployeeDAO.class, connectionBean);

    // d1->(e1)
    DepartmentDO departmentDOa = (DepartmentDO) departmentDAO.loadById(1);
    departmentDAO.loadEmployeeList(departmentDOa);
    assertTrue(compareDODeep(departmentDO1, departmentDOa));

    // d2->(e2)
    DepartmentDO departmentDOb = (DepartmentDO) departmentDAO.loadById(2);
    departmentDAO.loadEmployeeList(departmentDOb);
    assertTrue(compareDODeep(departmentDO2, departmentDOb));

    // Load 1 & 2 just to compare in the next part
    EmployeeDO employeeDOa = (EmployeeDO) employeeDAO.loadById(1);
    employeeDAO.loadDepartmentRef(employeeDOa);
    EmployeeDO employeeDOb = (EmployeeDO) employeeDAO.loadById(2);
    employeeDAO.loadDepartmentRef(employeeDOb);

    // d1->(e1, e3)
    EmployeeDO employeeDOc = (EmployeeDO) employeeDAO.loadById(3);
    //employeeDOc.setDepartmentRef(departmentDOa); // ----------> LINK
    employeeDOc.getDepartmentRef().setRefValue(departmentDOa); // ----------> LINK
    // If I don't add I can't compare below
    departmentDOa.getEmployeeList().add(employeeDOc); // -----> LINK
    employeeDAO.update(employeeDOc);

    // d2->(e2, e4)
    EmployeeDO employeeDOd = (EmployeeDO) employeeDAO.loadById(4);
    //employeeDOd.setDepartmentRef(departmentDOb); // ----------> LINK
    employeeDOd.getDepartmentRef().setRefValue(departmentDOb); // ----------> LINK
    // If I don't add I can't compare below
    departmentDOb.getEmployeeList().add(employeeDOd); // -----> LINK
    employeeDAO.update(employeeDOd);

    // d3->Empty
    // d4->Empty

    ConnectionFactory.closeConnection(connectionBean.getConnection());

    // ----------------------------------------
    // LOAD / CHECK Departments
    // ----------------------------------------

    connectionBean = ConnectionFactory.getConnectionBean();

    departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
        DepartmentDAO.class, connectionBean);

    DepartmentDO departmentDOX = (DepartmentDO) departmentDAO.loadById(1);
    departmentDAO.loadEmployeeList(departmentDOX);
    assertTrue(compareDODeep(departmentDOa, departmentDOX));

    DepartmentDO departmentDOY = (DepartmentDO) departmentDAO.loadById(2);
    departmentDAO.loadEmployeeList(departmentDOY);
    assertTrue(compareDODeep(departmentDOb, departmentDOY));

    ConnectionFactory.closeConnection(connectionBean.getConnection());

    // ----------------------------------------
    // LOAD / CHECK Employees
    // ----------------------------------------

    connectionBean = ConnectionFactory.getConnectionBean();

    employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
        EmployeeDAO.class, connectionBean);

    EmployeeDO employeeDOX = (EmployeeDO) employeeDAO.loadById(1);
    employeeDAO.loadDepartmentRef(employeeDOX);
    assertTrue(compareDODeep(employeeDOa, employeeDOX));

    EmployeeDO employeeDOY = (EmployeeDO) employeeDAO.loadById(2);
    employeeDAO.loadDepartmentRef(employeeDOY);
    assertTrue(compareDODeep(employeeDOb, employeeDOY));

    EmployeeDO employeeDOZ = (EmployeeDO) employeeDAO.loadById(3);
    employeeDAO.loadDepartmentRef(employeeDOZ);
    assertTrue(compareDODeep(employeeDOc, employeeDOZ));

    EmployeeDO employeeDOW = (EmployeeDO) employeeDAO.loadById(4);
    employeeDAO.loadDepartmentRef(employeeDOW);
    assertTrue(compareDODeep(employeeDOd, employeeDOW));

    ConnectionFactory.closeConnection(connectionBean.getConnection());
  }

  // --------------------------------------------------------------------------------

  public void testRefCrash() throws Exception {
    ConnectionBean connectionBean;

    DepartmentDAO departmentDAO;
    EmployeeDAO employeeDAO;

    // ----------------------------------------

    connectionBean = ConnectionFactory.getConnectionBean();

    // ----------------------------------------
    // INSERT Departments
    // ----------------------------------------

    departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
        DepartmentDAO.class, connectionBean);
    departmentDAO.createTable();

    DepartmentDO departmentDO = new DepartmentDO();
    departmentDO.setName("FooName111");
    departmentDO.setDescription("FooDescription111");
    departmentDAO.insert(departmentDO);
    assertEquals(departmentDO.getId(), 1);

    // ----------------------------------------
    // INSERT Employees
    // ----------------------------------------

    employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
        EmployeeDAO.class, connectionBean);
    employeeDAO.createTable();

    // d1 -> e1
    EmployeeDO employeeDO = new EmployeeDO();
    employeeDO.setFrstName("FrstName111");
    employeeDO.setLastName("LastName111");
    employeeDO.getDepartmentRef().setRefValue(departmentDO); // ----------> LINK
    departmentDO.getEmployeeList().add(employeeDO); // -----> LINK
    employeeDAO.insert(employeeDO);
    assertEquals(employeeDO.getId(), 1);

    ConnectionFactory.closeConnection(connectionBean.getConnection());
  }
}
