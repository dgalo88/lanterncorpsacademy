package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
//import dao.api.FactoryDAO;
import dao.api.Reference;

public class GrupoDAO extends BaseDAO {

  public GrupoDAO() {
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
    strbuf.append(GrupoDO.ID);
    strbuf.append(" INT PRIMARY KEY, ");
    strbuf.append(GrupoDO.NOMBRE);
    strbuf.append(" VARCHAR(50),    ");
    strbuf.append(GrupoDO.CLASE_LINTERNA_ID);
    strbuf.append(" STRING REFERENCES   ");
    strbuf.append(GrupoDO.ESTADO);
    strbuf.append(" BOOLEAN");
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
    checkClass(dataObject, GrupoDO.class, CHECK_INSERT);

    GrupoDO grupoDO = (GrupoDO) dataObject;

    grupoDO.setId(getNextId());

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("INSERT INTO ");
    strbuf.append(getTableName());
    strbuf.append(" VALUES (");
    strbuf.append(grupoDO.getId());
    strbuf.append(", ");
    strbuf.append(singleQuotes(grupoDO.getNombre()));
    strbuf.append(", ");
    strbuf.append(grupoDO.isEstado());
    strbuf.append(")");

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());

    dtaSession.add(dataObject);
  }

  // --------------------------------------------------------------------------------

  @Override
  public void update(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_UPDATE);
    checkClass(dataObject, GrupoDO.class, CHECK_UPDATE);

    GrupoDO grupoDO = (GrupoDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("UPDATE ");
    strbuf.append(getTableName());
    strbuf.append(" SET ");

    strbuf.append(GrupoDO.NOMBRE);
    strbuf.append(" = ");
    strbuf.append(singleQuotes(grupoDO.getNombre()));

    strbuf.append(", ");

    strbuf.append(GrupoDO.CLASE_LINTERNA_ID);
    strbuf.append(" = ");
    Reference<ClaseLinternaDO> refcl = grupoDO.getClaseLinternaRef();
    refcl.checkUpdate();
    strbuf.append(refcl.getIdAsString());
    
    strbuf.append(", ");

    strbuf.append(GrupoDO.ESTADO);
    strbuf.append(" = ");
    strbuf.append(grupoDO.isEstado());

    strbuf.append(" WHERE ");
    strbuf.append(GrupoDO.ID);
    strbuf.append(" = ");
    strbuf.append(grupoDO.getId());

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());
  }

  // --------------------------------------------------------------------------------

  @Override
  public void delete(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_DELETE);
    checkClass(dataObject, GrupoDO.class, CHECK_DELETE);

    GrupoDO grupoDO = (GrupoDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("DELETE FROM ");
    strbuf.append(getTableName());

    strbuf.append(" WHERE ");
    strbuf.append(GrupoDO.ID);
    strbuf.append(" = ");
    strbuf.append(grupoDO.getId());

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
    strbuf.append(GrupoDO.ID);
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
  /*
  public List<ClaseLinternaDO> listByIdHabilidadClaseLinternaId(int habilidadClaseLinternaId) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(ClaseLinternaDO.HABILIDAD_CLASE_LINTERNA_ID);
	    strbuf.append(" = ");
	    strbuf.append(habilidadClaseLinternaId);

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    List<ClaseLinternaDO> ret = new ArrayList<ClaseLinternaDO>();

	    while (rs.next()) {
	      ret.add(resultSetToDO(rs));
	    }

	    return ret;
	  }
  */
  //--------------------------------------------------------------------------------
  
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

  private GrupoDO resultSetToDO(ResultSet rs) throws SQLException {
	  GrupoDO ret = //
    (GrupoDO) dtaSession.getDtaByKey( //
    		GrupoDO.class, rs.getInt(GrupoDO.ID));

    if (ret != null) {
      return ret;
    }

    ret = new GrupoDO();

    ret.setId/*     */(rs.getInt(GrupoDO.ID));
    ret.setNombre/*   */(rs.getString(GrupoDO.NOMBRE));
    ret.setEstado(rs.getBoolean(GrupoDO.ESTADO));
/*    
    Reference<HabilidadClaseLinternaDO> refH = new Reference<HabilidadClaseLinternaDO>();
    refH.setRefIdent(rs.getInt(ClaseLinternaDO.HABILIDAD_CLASE_LINTERNA_ID));
    ret.setHabilidadClaseLinternaRef(refH);
    
    Reference<PlanetaDO> refPl = new Reference<PlanetaDO>();
    refPl.setRefIdent(rs.getInt(ClaseLinternaDO.PLANETA_ID));
    ret.setPlanetaRef(refP
*/
    return (GrupoDO) dtaSession.add(ret);
  }

  // --------------------------------------------------------------------------------
/*
  public void loadClaseLinternaRef(GrupoDO grupoDO) throws SQLException {
	    // XXX: Check this method's semantic
	    checkClass(grupoDO, GrupoDO.class, CHECK_UPDATE);

	    ClaseLinternaDAO claseLinternaDAO = new ClaseLinternaDAO();
	    claseLinternaDAO.init(connectionBean);

	    Reference<ClaseLinternaDO> ref = grupoDO.getClaseLinternaRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }
  }
  */
  
}
