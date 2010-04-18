package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.FactoryDAO;
import dao.example.DepartmentDAO;

public class PersonajeDAO extends BaseDAO {

  public PersonajeDAO() {
    // Empty
  }


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

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    usuarioDAO.init(connectionBean);
    PlanetaDAO planetaDAO = new PlanetaDAO();
    planetaDAO.init(connectionBean);
    ClaseLinternaDAO claseLinternaDAO = new ClaseLinternaDAO();
    claseLinternaDAO.init(connectionBean);
    DepartmentDAO departmentDAO = new DepartmentDAO();
    departmentDAO.init(connectionBean);

    // ----------------------------------------
    
    strbuf = new StringBuffer();
    strbuf.append("CREATE TABLE ");
    strbuf.append(getTableName());
    strbuf.append(" (");
    strbuf.append(PersonajeDO.ID);
    strbuf.append(" INT PRIMARY KEY,	");
    strbuf.append(PersonajeDO.ALIAS);
    strbuf.append(" VARCHAR(20), UNIQUE,	");
    strbuf.append(PersonajeDO.EXPERIENCIA);
    strbuf.append(" INT, DEFAULT 0");
    strbuf.append(PersonajeDO.PUNTOS_DE_ENTRENAMIENTO);
    strbuf.append(" INT, DEFAULT 0");
    strbuf.append(PersonajeDO.SALUD);
    strbuf.append(" INT, CHECK (PersonajeDO.SALUD >= 0), DEFAULT 200");
    strbuf.append(PersonajeDO.ENERGIA_DEL_ANILLO);
    strbuf.append(" INT, DEFAULT 100	");
    strbuf.append(PersonajeDO.NIVEL);
    strbuf.append(" INT,	DEFAULT 1");
    strbuf.append(PersonajeDO.ULTIMA_FECHA_INGRESO);
    strbuf.append(" DATE,	");
    strbuf.append(PersonajeDO.USUARIO_ID);
    strbuf.append(" INT,	");
    strbuf.append(departmentDAO.getTableName());
    strbuf.append(PersonajeDO.PLANETA_ID);
    strbuf.append(" INT,	");
    strbuf.append(departmentDAO.getTableName());
    strbuf.append(PersonajeDO.GRUPO_ID);
    strbuf.append(" INT,	");
    strbuf.append(departmentDAO.getTableName());
    strbuf.append(PersonajeDO.CLASE_LINTERNA_ID);
    strbuf.append(" INT,	");
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
    checkClass(dataObject, PersonajeDO.class, CHECK_INSERT);

    PersonajeDO departmentDO = (PersonajeDO) dataObject;

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
    checkClass(dataObject, PersonajeDO.class, CHECK_UPDATE);

    PersonajeDO departmentDO = (PersonajeDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("UPDATE ");
    strbuf.append(getTableName());
    strbuf.append(" SET ");

    strbuf.append(PersonajeDO.NAME);
    strbuf.append(" = ");
    strbuf.append(singleQuotes(departmentDO.getName()));

    strbuf.append(", ");

    strbuf.append(PersonajeDO.DESCRIPTION);
    strbuf.append(" = ");
    strbuf.append(singleQuotes(departmentDO.getDescription()));

    strbuf.append(" WHERE ");
    strbuf.append(PersonajeDO.ID);
    strbuf.append(" = ");
    strbuf.append(departmentDO.getId());

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());
  }

  // --------------------------------------------------------------------------------

  @Override
  public void delete(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_DELETE);
    checkClass(dataObject, PersonajeDO.class, CHECK_DELETE);

    PersonajeDO departmentDO = (PersonajeDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("DELETE FROM ");
    strbuf.append(getTableName());

    strbuf.append(" WHERE ");
    strbuf.append(PersonajeDO.ID);
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
    strbuf.append(PersonajeDO.ID);
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

  private PersonajeDO resultSetToDO(ResultSet rs) throws SQLException {
    PersonajeDO ret = //
    (PersonajeDO) dtaSession.getDtaByKey( //
        PersonajeDO.class, rs.getInt(PersonajeDO.ID));

    if (ret != null) {
      return ret;
    }

    ret = new PersonajeDO();

    ret.setId/*     */(rs.getInt(PersonajeDO.ID));
    ret.setName/*   */(rs.getString(PersonajeDO.NAME));
    ret.setDescription(rs.getString(PersonajeDO.DESCRIPTION));

    return (PersonajeDO) dtaSession.add(ret);
  }

  // --------------------------------------------------------------------------------

  public void loadEmployeeList(PersonajeDO departmentDO) throws Exception {
    checkCache(departmentDO, CHECK_UPDATE);
    //checkClass(departmentDO, DepartmentDO.class, CHECK_UPDATE);

    EmployeeDAO employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
        EmployeeDAO.class, connectionBean);

    departmentDO.setEmployeeList(employeeDAO.listByDepartmentId(departmentDO.getId()));
  }

  // --------------------------------------------------------------------------------

  public List<PersonajeDO> listByNameAndLikeDescription(String name, String description) throws SQLException {
    StringBuffer strbuf = new StringBuffer();

    strbuf.append("SELECT * FROM ");
    strbuf.append(getTableName());

    strbuf.append(" WHERE ");
    strbuf.append(PersonajeDO.NAME);
    strbuf.append(" = ");
    strbuf.append(singleQuotes(name));

    strbuf.append(" AND ");
    strbuf.append(PersonajeDO.DESCRIPTION);
    strbuf.append(" LIKE ");
    strbuf.append(singleQuotes("%" + description + "%"));

    System.err.println(strbuf.toString());

    ResultSet rs = //
    connection.createStatement().executeQuery(strbuf.toString());

    List<PersonajeDO> ret = new ArrayList<PersonajeDO>();

    while (rs.next()) {
      ret.add(resultSetToDO(rs));
    }

    return ret;
  }
}
