package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
//import dao.api.FactoryDAO;
import dao.api.Reference;

public class GrupoPersonajeDAO extends BaseDAO {

  public GrupoPersonajeDAO() {
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
    strbuf.append(GrupoPersonajeDO.ID);
    strbuf.append(" INT PRIMARY KEY, ");
    strbuf.append(GrupoPersonajeDO.PERSONAJE_ID);
    strbuf.append(" STRING REFERENCES   ");
    strbuf.append(GrupoPersonajeDO.GRUPO_ID);
    strbuf.append(" STRING REFERENCES   ");
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

    GrupoPersonajeDO grupoPersonajeDO = (GrupoPersonajeDO) dataObject;

    grupoPersonajeDO.setId(getNextId());

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("INSERT INTO ");
    strbuf.append(getTableName());
    strbuf.append(" VALUES (");
    strbuf.append(grupoPersonajeDO.getId());
    strbuf.append(")");

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());

    dtaSession.add(dataObject);
  }

  // --------------------------------------------------------------------------------

  @Override
  public void update(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_UPDATE);
    checkClass(dataObject, GrupoPersonajeDO.class, CHECK_UPDATE);

    GrupoPersonajeDO grupoPersonajeDO = (GrupoPersonajeDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("UPDATE ");
    strbuf.append(getTableName());
    strbuf.append(" SET ");
    
    strbuf.append(GrupoPersonajeDO.PERSONAJE_ID);
    strbuf.append(" = ");
    Reference<PersonajeDO> refp = grupoPersonajeDO.getPersonajeRef();
    refp.checkUpdate();
    strbuf.append(refp.getIdAsString());
    
    strbuf.append(", ");
    
    strbuf.append(GrupoPersonajeDO.GRUPO_ID);
    strbuf.append(" = ");
    Reference<GrupoDO> refg = grupoPersonajeDO.getGrupoRef();
    refg.checkUpdate();
    strbuf.append(refg.getIdAsString());

    strbuf.append(" WHERE ");
    strbuf.append(GrupoPersonajeDO.ID);
    strbuf.append(" = ");
    strbuf.append(grupoPersonajeDO.getId());

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());
  }

  // --------------------------------------------------------------------------------

  @Override
  public void delete(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_DELETE);
    checkClass(dataObject, GrupoPersonajeDO.class, CHECK_DELETE);

    GrupoPersonajeDO grupoPersonajeDO = (GrupoPersonajeDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("DELETE FROM ");
    strbuf.append(getTableName());

    strbuf.append(" WHERE ");
    strbuf.append(GrupoPersonajeDO.ID);
    strbuf.append(" = ");
    strbuf.append(grupoPersonajeDO.getId());

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
    strbuf.append(GrupoPersonajeDO.ID);
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
  
  public List<GrupoPersonajeDO> listByPersonajeId(int personajeId) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(GrupoPersonajeDO.PERSONAJE_ID);
	    strbuf.append(" = ");
	    strbuf.append(personajeId);

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    List<GrupoPersonajeDO> ret = new ArrayList<GrupoPersonajeDO>();

	    while (rs.next()) {
	      ret.add(resultSetToDO(rs));
	    }

	    return ret;
	  }
  
// --------------------------------------------------------------------------------
  
  public List<GrupoPersonajeDO> listByGrupoId(int grupoId) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(GrupoPersonajeDO.GRUPO_ID);
	    strbuf.append(" = ");
	    strbuf.append(grupoId);

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    List<GrupoPersonajeDO> ret = new ArrayList<GrupoPersonajeDO>();

	    while (rs.next()) {
	      ret.add(resultSetToDO(rs));
	    }

	    return ret;
	  }
  
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

  private GrupoPersonajeDO resultSetToDO(ResultSet rs) throws SQLException {
	  GrupoPersonajeDO ret = //
    (GrupoPersonajeDO) dtaSession.getDtaByKey( //
    		GrupoPersonajeDO.class, rs.getInt(GrupoPersonajeDO.ID));

    if (ret != null) {
      return ret;
    }

    ret = new GrupoPersonajeDO();

    ret.setId/*     */(rs.getInt(GrupoPersonajeDO.ID));
     
    Reference<PersonajeDO> refP = new Reference<PersonajeDO>();
    refP.setRefIdent(rs.getInt(GrupoPersonajeDO.PERSONAJE_ID));
    ret.setPersonajeRef(refP);
    
    Reference<GrupoDO> refG = new Reference<GrupoDO>();
    refG.setRefIdent(rs.getInt(GrupoPersonajeDO.GRUPO_ID));
    ret.setGrupoRef(refG);
    
    return (GrupoPersonajeDO) dtaSession.add(ret);
  }

  // --------------------------------------------------------------------------------

  public void loadPersonajeRef(GrupoPersonajeDO grupoPersonajeDO) throws SQLException {
	    // XXX: Check this method's semantic
	    checkClass(grupoPersonajeDO, GrupoPersonajeDO.class, CHECK_UPDATE);

	    PersonajeDAO personajeDAO = new PersonajeDAO();
	    personajeDAO.init(connectionBean);

	    Reference<PersonajeDO> ref = grupoPersonajeDO.getPersonajeRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	    PersonajeDO personajeDO = //
	    	(PersonajeDO) personajeDAO.loadById(ref.getRefIdent());

	        ref.setRefValue(personajeDO);
  }
  
//--------------------------------------------------------------------------------

  public void loadGrupoRef(GrupoPersonajeDO grupoPersonajeDO) throws SQLException {
	    // XXX: Check this method's semantic
	    checkClass(grupoPersonajeDO, GrupoPersonajeDO.class, CHECK_UPDATE);

	    GrupoDAO grupoDAO = new GrupoDAO();
	    grupoDAO.init(connectionBean);

	    Reference<GrupoDO> ref = grupoPersonajeDO.getGrupoRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	    GrupoDO grupoDO = //
	    	(GrupoDO) grupoDAO.loadById(ref.getRefIdent());

	        ref.setRefValue(grupoDO);
  }
  
}
