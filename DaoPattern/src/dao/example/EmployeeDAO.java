package dao.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

/**
 * @author Demián Gutierrez
 */
public class EmployeeDAO extends BaseDAO {

  public void createTable() throws SQLException {
    StringBuffer strbuf;

    // ----------------------------------------

    strbuf = new StringBuffer();

    strbuf.append("DROP TABLE IF EXISTS ");
    strbuf.append(getTableName());
    strbuf.append(" CASCADE");

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());

    // ----------------------------------------

    strbuf = new StringBuffer();

    strbuf.append("DROP SEQUENCE IF EXISTS ");
    strbuf.append("seq_");
    strbuf.append(getTableName());

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());

    // ----------------------------------------

    DepartmentDAO departmentDAO = new DepartmentDAO(); // Used to make the FK
    departmentDAO.init(connectionBean);

    strbuf = new StringBuffer();

    strbuf.append("CREATE TABLE ");
    strbuf.append(getTableName());
    strbuf.append(" (");
    strbuf.append(EmployeeDO.ID);
    strbuf.append(" INT PRIMARY KEY, ");
    strbuf.append(EmployeeDO.FRST_NAME);
    strbuf.append(" VARCHAR(100),    ");
    strbuf.append(EmployeeDO.LAST_NAME);
    strbuf.append(" VARCHAR(100),    ");
    strbuf.append(EmployeeDO.DEPARTMENT_ID);
    strbuf.append(" INT REFERENCES   ");
    strbuf.append(departmentDAO.getTableName());
    strbuf.append(")");

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());

    // ----------------------------------------

    strbuf = new StringBuffer();

    strbuf.append("CREATE SEQUENCE ");
    strbuf.append("seq_");
    strbuf.append(getTableName());

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());
  }

  // --------------------------------------------------------------------------------

  @Override
  public void insert(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_INSERT);
    checkClass(dataObject, EmployeeDO.class, CHECK_INSERT);

    EmployeeDO employeeDO = (EmployeeDO) dataObject;

    employeeDO.setId(getNextId());

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("INSERT INTO ");
    strbuf.append(getTableName());
    strbuf.append(" VALUES (");
    strbuf.append(employeeDO.getId());
    strbuf.append(", ");
    strbuf.append(singleQuotes(employeeDO.getFrstName()));
    strbuf.append(", ");
    strbuf.append(singleQuotes(employeeDO.getLastName()));
    strbuf.append(", ");

    Reference<DepartmentDO> ref = employeeDO.getDepartmentRef();
    ref.checkInsert();
    strbuf.append(ref.getIdAsString());

    strbuf.append(")");

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());

    dtaSession.add(dataObject);
  }

  // --------------------------------------------------------------------------------

  @Override
  public void update(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_UPDATE);
    checkClass(dataObject, EmployeeDO.class, CHECK_UPDATE);

    EmployeeDO employeeDO = (EmployeeDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("UPDATE ");
    strbuf.append(getTableName());
    strbuf.append(" SET ");

    strbuf.append(EmployeeDO.FRST_NAME);
    strbuf.append(" = ");
    strbuf.append(singleQuotes(employeeDO.getFrstName()));

    strbuf.append(", ");

    strbuf.append(EmployeeDO.LAST_NAME);
    strbuf.append(" = ");
    strbuf.append(singleQuotes(employeeDO.getLastName()));

    strbuf.append(", ");

    strbuf.append(EmployeeDO.DEPARTMENT_ID);
    strbuf.append(" = ");

    Reference<DepartmentDO> ref = employeeDO.getDepartmentRef();
    ref.checkUpdate();
    strbuf.append(ref.getIdAsString());

    strbuf.append(" WHERE ");
    strbuf.append(EmployeeDO.ID);
    strbuf.append(" = ");
    strbuf.append(employeeDO.getId());

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());
  }

  // --------------------------------------------------------------------------------

  @Override
  public void delete(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_DELETE);
    checkClass(dataObject, EmployeeDO.class, CHECK_DELETE);

    EmployeeDO employeeDO = (EmployeeDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("DELETE FROM ");
    strbuf.append(getTableName());

    strbuf.append(" WHERE ");
    strbuf.append(EmployeeDO.ID);
    strbuf.append(" = ");
    strbuf.append(employeeDO.getId());

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());

    dtaSession.del(dataObject);
  }

  // --------------------------------------------------------------------------------

  @Override
  public DataObject loadById(int id) throws SQLException {
    StringBuffer strbuf = new StringBuffer();

    strbuf.append("SELECT * FROM ");
    strbuf.append(getTableName());

    strbuf.append(" WHERE ");
    strbuf.append(EmployeeDO.ID);
    strbuf.append(" = ");
    strbuf.append(id);

    System.err.println(strbuf.toString());

    ResultSet rs = //
    connection.createStatement().executeQuery(strbuf.toString());

    if (rs.next()) {
      return resultSetToDO(rs);
    }

    return null;
  }

  // --------------------------------------------------------------------------------

  @Override
  public List<DataObject> listAll(int lim, int off) throws SQLException {
    StringBuffer strbuf = new StringBuffer();

    strbuf.append("SELECT * FROM ");
    strbuf.append(getTableName());

    if (lim >= 0 && off >= 0) {
      strbuf.append(" LIMIT  ");
      strbuf.append(lim);
      strbuf.append(" OFFSET ");
      strbuf.append(off);
    }

    System.err.println(strbuf.toString());

    ResultSet rs = //
    connection.createStatement().executeQuery(strbuf.toString());

    List<DataObject> ret = new ArrayList<DataObject>();

    while (rs.next()) {
      ret.add(resultSetToDO(rs));
    }

    return ret;
  }

  // --------------------------------------------------------------------------------

  @Override
  public List<DataObject> listAll() throws SQLException {
    return listAll(-1, -1);
  }

  // --------------------------------------------------------------------------------

  @Override
  public int countAll() throws SQLException {
    StringBuffer strbuf = new StringBuffer();

    strbuf.append("SELECT COUNT(*) FROM ");
    strbuf.append(getTableName());

    System.err.println(strbuf.toString());

    ResultSet rs = //
    connection.createStatement().executeQuery(strbuf.toString());

    rs.next();

    return rs.getInt("count");
  }

  // --------------------------------------------------------------------------------

  public List<EmployeeDO> listByDepartmentId(int departmentId) throws SQLException {
    StringBuffer strbuf = new StringBuffer();

    strbuf.append("SELECT * FROM ");
    strbuf.append(getTableName());

    strbuf.append(" WHERE ");
    strbuf.append(EmployeeDO.DEPARTMENT_ID);
    strbuf.append(" = ");
    strbuf.append(departmentId);

    System.err.println(strbuf.toString());

    ResultSet rs = //
    connection.createStatement().executeQuery(strbuf.toString());

    List<EmployeeDO> ret = new ArrayList<EmployeeDO>();

    while (rs.next()) {
      ret.add(resultSetToDO(rs));
    }

    return ret;
  }

  // --------------------------------------------------------------------------------

  private int getNextId() throws SQLException {
    StringBuffer strbuf = new StringBuffer();

    strbuf.append("SELECT nextval(");
    strbuf.append(singleQuotes("seq_" + getTableName()));
    strbuf.append(")");

    System.err.println(strbuf.toString());

    ResultSet rs = //
    connection.createStatement().executeQuery(strbuf.toString());

    if (!rs.next()) {
      throw new IllegalStateException("!rs.next()");
    }

    return rs.getInt("nextval");
  }

  // --------------------------------------------------------------------------------

  private EmployeeDO resultSetToDO(ResultSet rs) throws SQLException {
    EmployeeDO ret = //
    (EmployeeDO) dtaSession.getDtaByKey( //
        EmployeeDO.class, rs.getInt(EmployeeDO.ID));

    if (ret != null) {
      return ret;
    }

    ret = new EmployeeDO();

    ret.setId/*      */(rs.getInt(EmployeeDO.ID));
    ret.setFrstName/**/(rs.getString(EmployeeDO.FRST_NAME));
    ret.setLastName/**/(rs.getString(EmployeeDO.LAST_NAME));

    Reference<DepartmentDO> ref = new Reference<DepartmentDO>();
    ref.setRefIdent(rs.getInt(EmployeeDO.DEPARTMENT_ID));

    ret.setDepartmentRef(ref);

    return (EmployeeDO) dtaSession.add(ret);
  }

  // --------------------------------------------------------------------------------

  public void loadDepartmentRef(EmployeeDO employeeDO) throws SQLException {
    // XXX: Check this method's semantic
    checkClass(employeeDO, EmployeeDO.class, CHECK_UPDATE);

    DepartmentDAO departmentDAO = new DepartmentDAO();
    departmentDAO.init(connectionBean);

    Reference<DepartmentDO> ref = employeeDO.getDepartmentRef();

    // ----------------------------------------
    // If ident == 0 there is nothing to do
    // ----------------------------------------

    if (ref.getRefIdent() == 0) {
      return;
    }

    DepartmentDO departmentDO = //
    (DepartmentDO) departmentDAO.loadById(ref.getRefIdent());

    ref.setRefValue(departmentDO);
  }
}
