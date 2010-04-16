package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class GrupoPersonajeDAO extends BaseDAO {

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

    GrupoPersonajeDAO grupoPersonajeDAO = new GrupoPersonajeDAO(); // Used to make the FK
    grupoPersonajeDAO.init(connectionBean);

    strbuf = new StringBuffer();

    strbuf.append("CREATE TABLE ");
    strbuf.append(getTableName());
    strbuf.append(" (");
    strbuf.append(GrupoPersonajeDO.ID);
    strbuf.append(" INT PRIMARY KEY, ");
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
    checkClass(dataObject, GrupoPersonajeDO.class, CHECK_INSERT);

    GrupoPersonajeDO grupoPersonajeDO = (GrupoPersonajeDO) dataObject;

    grupoPersonajeDO.setId(getNextId());

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("INSERT INTO ");
    strbuf.append(getTableName());
    strbuf.append(" VALUES (");
    strbuf.append(grupoPersonajeDO.getId());
    
    /*Reference <GrupoDO> refG = grupoDO.getGrupoRef();
    ref.checkInsert();
    
    Reference <PersonajeDO> refP = personajeDO.getPersonajeRef();*/s

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

  }

  // --------------------------------------------------------------------------------

  @Override
  public void delete(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_DELETE);
    checkClass(dataObject, ClaseLinternaDO.class, CHECK_DELETE);

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

  /*public List<ClaseLinternaDO> listByIdHabilidadClaseLinternaId(int habilidadClaseLinternaId) throws SQLException {
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

  private GrupoPersonajeDO resultSetToDO(ResultSet rs) throws SQLException {
    GrupoPersonajeDO retGP = //
    (GrupoPersonajeDO) dtaSession.getDtaByKey( //
        GrupoPersonajeDO.class, rs.getInt(GrupoPersonajeDO.ID));

    if (retGP != null) {
      return retGP;
    }

    retGP = new GrupoPersonajeDO();

    retGP.setId/*     */(rs.getInt(GrupoPersonajeDO.ID));
        
    return (GrupoPersonajeDO) dtaSession.add(retGP);
  }

  // --------------------------------------------------------------------------------

  /*public void loadHabilidadClaseLinternaRef(ClaseLinternaDO claseLinternaDO) throws SQLException {
    // XXX: Check this method's semantic
    checkClass(claseLinternaDO, ClaseLinternaDO.class, CHECK_UPDATE);

    HabilidadClaseLinternaDAO habilidadClaseLinternaDAO = new HabilidadClaseLinternaDAO();
    habilidadClaseLinternaDAO.init(connectionBean);

    Reference<HabilidadClaseLinternaDO> ref = claseLinternaDO.getHabilidadClaseLinternaRef();

    if (ref.getRefIdent() == 0) {
      return;
    }

    HabilidadClaseLinternaDO habilidadClaseLinternaDO = //
    (HabilidadClaseLinternaDO) habilidadClaseLinternaDAO.loadById(ref.getRefIdent());

    ref.setRefValue(habilidadClaseLinternaDO);
  }
  */
  // --------------------------------------------------------------------------------

/*  public void loadPlanetaRef(ClaseLinternaDO claseLinternaDO) throws SQLException {
    // XXX: Check this method's semantic
    checkClass(claseLinternaDO, ClaseLinternaDO.class, CHECK_UPDATE);

    PlanetaDAO planetaDAO = new PlanetaDAO();
    planetaDAO.init(connectionBean);

    Reference<PlanetaDO> ref = claseLinternaDO.getPlanetaRef();

    if (ref.getRefIdent() == 0) {
      return;
    }

    PlanetaDO planetaDO = //
    (PlanetaDO) planetaDAO.loadById(ref.getRefIdent());

    ref.setRefValue(planetaDO);
  }
  */

  // --------------------------------------------------------------------------------

  public void loadGrupoList(GrupoPersonajeDO grupoPersonajeDO) throws Exception {
	    checkCache(grupoPersonajeDO, CHECK_UPDATE);
	    checkClass(grupoPersonajeDO, GrupoPersonajeDO.class, CHECK_UPDATE);

	    GrupoDAO grupoDAO = (GrupoDAO) FactoryDAO.getDAO( //
	        GrupoDAO.class, connectionBean);

	    GrupoPersonajeDO.setGrupoList(grupoDAO.listByIdGrupoPersonajeId(grupoPersonajeDO.getId()));
	  }
  
//--------------------------------------------------------------------------------

  public void loadPersonajeList(GrupoPersonajeDO grupoPersonajeDO) throws Exception {
	    checkCache(grupoPersonajeDO, CHECK_UPDATE);
	    checkClass(grupoPersonajeDO, GrupoPersonajeDO.class, CHECK_UPDATE);

	    PersonajeDAO personajeDAO = (PersonajeDAO) FactoryDAO.getDAO( //
	        PersonajeDAO.class, connectionBean);

	    GrupoPersonajeDO.setPersonajeList(personajeDAO.listByIdGrupoPersonajeId(grupoPersonajeDO.getId()));
	  }

}
