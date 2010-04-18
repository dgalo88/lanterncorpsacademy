package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
//import dao.api.FactoryDAO;

/**
 * @author Demián Gutierrez
 */
public class MisionPersonajeDAO extends BaseDAO {

  public MisionPersonajeDAO() {
    // Empty
  }

  // --------------------------------------------------------------------------------


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
    strbuf.append(MisionPersonajeDO.ID);
    strbuf.append(" INT PRIMARY KEY, ");
    strbuf.append(MisionPersonajeDO.PERSONAJE);
    strbuf.append(" VARCHAR(100),    ");
    strbuf.append(MisionPersonajeDO.MISION);
    strbuf.append(" VARCHAR(100)     ");
    strbuf.append(")");

    ///FALTAAAAA
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
    checkClass(dataObject, MisionPersonajeDO.class, CHECK_INSERT);

    MisionPersonajeDO misionPersonajeDO = (MisionPersonajeDO) dataObject;

    misionPersonajeDO.setId(getNextId());

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("INSERT INTO ");
    strbuf.append(getTableName());
    strbuf.append(" VALUES (");
    strbuf.append(misionPersonajeDO.getId());
    /*strbuf.append(", ");
    strbuf.append(singleQuotes(MisionPersonajeDO.getName()));
    strbuf.append(", ");
    strbuf.append(singleQuotes(MisionPersonajeDO.getDescription()));*/
    strbuf.append(")");

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());

    dtaSession.add(dataObject);
  }

  // --------------------------------------------------------------------------------

  @Override
  public void update(DataObject dataObject) throws SQLException {
    /*checkCache(dataObject, CHECK_UPDATE);
    checkClass(dataObject, MisionPersonajeDO.class, CHECK_UPDATE);

    MisionPersonajeDO MisionPersonajeDO = (MisionPersonajeDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("UPDATE ");
    strbuf.append(getTableName());
    strbuf.append(" SET ");

    strbuf.append(MisionPersonajeDO.NAME);
    strbuf.append(" = ");
    strbuf.append(singleQuotes(MisionPersonajeDO.getName()));

    strbuf.append(", ");

    strbuf.append(MisionPersonajeDO.DESCRIPTION);
    strbuf.append(" = ");
    strbuf.append(singleQuotes(MisionPersonajeDO.getDescription()));

    strbuf.append(" WHERE ");
    strbuf.append(MisionPersonajeDO.ID);
    strbuf.append(" = ");
    strbuf.append(MisionPersonajeDO.getId());

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());*/
  }

  // --------------------------------------------------------------------------------

  @Override
  public void delete(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_DELETE);
    checkClass(dataObject, MisionPersonajeDO.class, CHECK_DELETE);

    MisionPersonajeDO misionPersonajeDO = (MisionPersonajeDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("DELETE FROM ");
    strbuf.append(getTableName());

    strbuf.append(" WHERE ");
    strbuf.append(MisionPersonajeDO.ID);
    strbuf.append(" = ");
    strbuf.append(misionPersonajeDO.getId());

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
    strbuf.append(MisionPersonajeDO.ID);
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
  public List<DataObject> listAll(int lim, int off) throws SQLException {/////??????????????
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

  private MisionPersonajeDO resultSetToDO(ResultSet rs) throws SQLException {
    MisionPersonajeDO ret = //
    (MisionPersonajeDO) dtaSession.getDtaByKey( //
        MisionPersonajeDO.class, rs.getInt(MisionPersonajeDO.ID));

    if (ret != null) {
      return ret;
    }

    ret = new MisionPersonajeDO();

    ret.setId/*     */(rs.getInt(MisionPersonajeDO.ID));
    /*ret.setName/*   /(rs.getString(MisionPersonajeDO.NAME));
    ret.setDescription(rs.getString(MisionPersonajeDO.DESCRIPTION));*/

    return (MisionPersonajeDO) dtaSession.add(ret);
  }

  // --------------------------------------------------------------------------------

 /* public void loadEmployeeList(MisionPersonajeDO MisionPersonajeDO) throws Exception {
    checkCache(MisionPersonajeDO, CHECK_UPDATE);
    checkClass(MisionPersonajeDO, MisionPersonajeDO.class, CHECK_UPDATE);

    EmployeeDAO employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
        EmployeeDAO.class, connectionBean);

    MisionPersonajeDO.setEmployeeList(employeeDAO.listByIdMisionPersonajeId(MisionPersonajeDO.getId()));
  }
  */
}
