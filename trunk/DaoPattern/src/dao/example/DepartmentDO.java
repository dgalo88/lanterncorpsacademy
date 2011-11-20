package dao.example;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;

/**
 * @author Demián Gutierrez
 */
public class DepartmentDO implements DataObject {

  public static final String NAME/*    */= "name";
  public static final String DESCRIPTION = "description";

  // --------------------------------------------------------------------------------

  private int id;

  private String name;
  private String description;

  // --------------------------------------------------------------------------------

  private List<EmployeeDO> employeeList = //
  new ArrayList<EmployeeDO>();

  // --------------------------------------------------------------------------------

  public DepartmentDO() {
    // Empty
  }

  // --------------------------------------------------------------------------------

  @Override
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  // --------------------------------------------------------------------------------

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // --------------------------------------------------------------------------------

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  // --------------------------------------------------------------------------------

  public List<EmployeeDO> getEmployeeList() {
    return employeeList;
  }

  public void setEmployeeList(List<EmployeeDO> employeeList) {
    this.employeeList = employeeList;
  }

  // --------------------------------------------------------------------------------

  //  public static boolean compareDO(DepartmentDO departmentDO1, DepartmentDO departmentDO2) {
  //    boolean ret = true;
  //
  //    ret = ret && departmentDO1.getId() == departmentDO2.getId();
  //    ret = ret && departmentDO1.getName().equals(departmentDO2.getName());
  //    ret = ret && departmentDO1.getDescription().equals(departmentDO2.getDescription());
  //
  //    return ret;
  //  }
}
