package dao.example;

import dao.api.DataObject;
import dao.api.Reference;

/**
 * @author Demián Gutierrez
 */
public class EmployeeDO implements DataObject {

  public static final String FRST_NAME/* */= "frstName";
  public static final String LAST_NAME/* */= "lastName";
  public static final String DEPARTMENT_ID = "departmentId";

  // --------------------------------------------------------------------------------

  private int id;

  private String frstName;
  private String lastName;

  private Reference<DepartmentDO> departmentRef = new Reference<DepartmentDO>();

  // --------------------------------------------------------------------------------

  public EmployeeDO() {
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

  public String getFrstName() {
    return frstName;
  }

  public void setFrstName(String frstName) {
    this.frstName = frstName;
  }

  // --------------------------------------------------------------------------------

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  // --------------------------------------------------------------------------------

  public Reference<DepartmentDO> getDepartmentRef() {
    return departmentRef;
  }

  public void setDepartmentRef(Reference<DepartmentDO> departmentRef) {
    this.departmentRef = departmentRef;
  }
}
