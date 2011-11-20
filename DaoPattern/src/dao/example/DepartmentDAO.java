package dao.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.FactoryDAO;

/**
 * @author Demián Gutierrez
 */
public class DepartmentDAO extends BaseDAO {

  public DepartmentDAO() {
    // Empty
  }

  // --------------------------------------------------------------------------------

//  @Override
//  public String getTableName() {
//    return "department_dao";
//  }

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

    strbuf = new StringBuffer();

    strbuf.append("CREATE TABLE ");
    strbuf.append(getTableName());
    strbuf.append(" (");
    strbuf.append(DepartmentDO.ID);
    strbuf.append(" INT PRIMARY KEY, ");
    strbuf.append(DepartmentDO.NAME);
    strbuf.append(" VARCHAR(100),    ");
    strbuf.append(DepartmentDO.DESCRIPTION);
    strbuf.append(" VARCHAR(100)     ");
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
    checkClass(dataObject, DepartmentDO.class, CHECK_INSERT);

    DepartmentDO departmentDO = (DepartmentDO) dataObject;

    departmentDO.setId(getNextId());

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("INSERT INTO ");
    strbuf.append(getTableName());
    strbuf.append(" VALUES (");
    strbuf.append(departmentDO.getId());
    strbuf.append(", ");
    strbuf.append(singleQuotes(departmentDO.getName()));
    strbuf.append(", ");
    strbuf.append(singleQuotes(departmentDO.getDescription()));
    strbuf.append(")");

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());

    dtaSession.add(dataObject);
  }

  // --------------------------------------------------------------------------------

  @Override
  public void update(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_UPDATE);
    checkClass(dataObject, DepartmentDO.class, CHECK_UPDATE);

    DepartmentDO departmentDO = (DepartmentDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("UPDATE ");
    strbuf.append(getTableName());
    strbuf.append(" SET ");

    strbuf.append(DepartmentDO.NAME);
    strbuf.append(" = ");
    strbuf.append(singleQuotes(departmentDO.getName()));

    strbuf.append(", ");

    strbuf.append(DepartmentDO.DESCRIPTION);
    strbuf.append(" = ");
    strbuf.append(singleQuotes(departmentDO.getDescription()));

    strbuf.append(" WHERE ");
    strbuf.append(DepartmentDO.ID);
    strbuf.append(" = ");
    strbuf.append(departmentDO.getId());

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());
  }

  // --------------------------------------------------------------------------------

  @Override
  public void delete(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_DELETE);
    checkClass(dataObject, DepartmentDO.class, CHECK_DELETE);

    DepartmentDO departmentDO = (DepartmentDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("DELETE FROM ");
    strbuf.append(getTableName());

    strbuf.append(" WHERE ");
    strbuf.append(DepartmentDO.ID);
    strbuf.append(" = ");
    strbuf.append(departmentDO.getId());

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
    strbuf.append(DepartmentDO.ID);
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

  private DepartmentDO resultSetToDO(ResultSet rs) throws SQLException {
    DepartmentDO ret = //
    (DepartmentDO) dtaSession.getDtaByKey( //
        DepartmentDO.class, rs.getInt(DepartmentDO.ID));

    if (ret != null) {
      return ret;
    }

    ret = new DepartmentDO();

    ret.setId/*     */(rs.getInt(DepartmentDO.ID));
    ret.setName/*   */(rs.getString(DepartmentDO.NAME));
    ret.setDescription(rs.getString(DepartmentDO.DESCRIPTION));

    return (DepartmentDO) dtaSession.add(ret);
  }

  // --------------------------------------------------------------------------------

  public void loadEmployeeList(DepartmentDO departmentDO) throws Exception {
    checkCache(departmentDO, CHECK_UPDATE);
    //checkClass(departmentDO, DepartmentDO.class, CHECK_UPDATE);

    EmployeeDAO employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
        EmployeeDAO.class, connectionBean);

    departmentDO.setEmployeeList(employeeDAO.listByDepartmentId(departmentDO.getId()));
  }

  // --------------------------------------------------------------------------------

  public List<DepartmentDO> listByNameAndLikeDescription(String name, String description) throws SQLException {
    StringBuffer strbuf = new StringBuffer();

    strbuf.append("SELECT * FROM ");
    strbuf.append(getTableName());

    strbuf.append(" WHERE ");
    strbuf.append(DepartmentDO.NAME);
    strbuf.append(" = ");
    strbuf.append(singleQuotes(name));

    strbuf.append(" AND ");
    strbuf.append(DepartmentDO.DESCRIPTION);
    strbuf.append(" LIKE ");
    strbuf.append(singleQuotes("%" + description + "%"));

    System.err.println(strbuf.toString());

    ResultSet rs = //
    connection.createStatement().executeQuery(strbuf.toString());

    List<DepartmentDO> ret = new ArrayList<DepartmentDO>();

    while (rs.next()) {
      ret.add(resultSetToDO(rs));
    }

    return ret;
  }
}
