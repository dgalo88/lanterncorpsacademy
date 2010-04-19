package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.api.BaseDAO;
import dao.api.DataObject;
//import dao.api.FactoryDAO;
import dao.api.Reference;



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
    GrupoDAO grupoDAO = new GrupoDAO();
    grupoDAO.init(connectionBean);
    ClaseLinternaDAO claseLinternaDAO = new ClaseLinternaDAO();
    claseLinternaDAO.init(connectionBean);

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
    strbuf.append(" REFERENCES,	");
    strbuf.append(usuarioDAO.getTableName());
    strbuf.append(PersonajeDO.PLANETA_ID);
    strbuf.append(" REFERENCES,	");
    strbuf.append(planetaDAO.getTableName());
    strbuf.append(PersonajeDO.GRUPO_ID);
    strbuf.append(" REFERENCES,	");
    strbuf.append(grupoDAO.getTableName());
    strbuf.append(PersonajeDO.CLASE_LINTERNA_ID);
    strbuf.append(" REFERENCES,	");
    strbuf.append(claseLinternaDAO.getTableName());
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
    
    PersonajeDO personajeDO = (PersonajeDO) dataObject;
    personajeDO.setId(getNextId());

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("INSERT INTO ");
    strbuf.append(getTableName());
    strbuf.append(" VALUES (");
    strbuf.append(personajeDO.getId());
    strbuf.append(", ");
    strbuf.append(singleQuotes(personajeDO.getAlias()));
    strbuf.append(", ");
    strbuf.append(personajeDO.getExperiencia());
    strbuf.append(", ");
    strbuf.append(personajeDO.getPuntosDeEntrenamiento());
    strbuf.append(", ");
    strbuf.append(personajeDO.getSalud());
    strbuf.append(", ");
    strbuf.append(personajeDO.getEnergiaDelAnillo());
    strbuf.append(", ");
    strbuf.append(personajeDO.getNivel());
    strbuf.append(", ");
    strbuf.append(personajeDO.getUltimaFechaIngreso());
    strbuf.append(", ");
    Reference<UsuarioDO> ref = personajeDO.getUsuarioRef();
    ref.checkInsert();
    strbuf.append(ref.getIdAsString());
    strbuf.append(", ");
    Reference<PlanetaDO> ref1 = personajeDO.getPlanetaRef();
    ref1.checkInsert();
    strbuf.append(ref1.getIdAsString());
    strbuf.append(", ");
    Reference<GrupoDO> ref2 = personajeDO.getGrupoRef();
    ref2.checkInsert();
    strbuf.append(ref2.getIdAsString());
    strbuf.append(", ");
    Reference<ClaseLinternaDO> ref3 = personajeDO.getClaseLinternaRef();
    ref3.checkInsert();
    strbuf.append(ref3.getIdAsString());
    strbuf.append(", ");
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

    PersonajeDO personajeDO = (PersonajeDO) dataObject;

    StringBuffer strbuf = new StringBuffer();
    strbuf.append("UPDATE ");
    strbuf.append(getTableName());
    strbuf.append(" SET ");
    
    strbuf.append(PersonajeDO.ALIAS);
    strbuf.append(" = ");
    strbuf.append(singleQuotes(personajeDO.getAlias()));

    strbuf.append(", ");

    strbuf.append(PersonajeDO.EXPERIENCIA);
    strbuf.append(" = ");
    strbuf.append(personajeDO.getExperiencia());

    strbuf.append(PersonajeDO.PUNTOS_DE_ENTRENAMIENTO);
    strbuf.append(" = ");
    strbuf.append(personajeDO.getPuntosDeEntrenamiento());
    
    strbuf.append(PersonajeDO.SALUD);
    strbuf.append(" = ");
    strbuf.append(personajeDO.getSalud());
    
    strbuf.append(PersonajeDO.ENERGIA_DEL_ANILLO);
    strbuf.append(" = ");
    strbuf.append(personajeDO.getEnergiaDelAnillo());
    
    strbuf.append(PersonajeDO.NIVEL);
    strbuf.append(" = ");
    strbuf.append(personajeDO.getNivel());
    
    strbuf.append(PersonajeDO.ULTIMA_FECHA_INGRESO);
    strbuf.append(" = ");
    strbuf.append(personajeDO.getUltimaFechaIngreso());
    
    strbuf.append(PersonajeDO.USUARIO_ID);
    strbuf.append(" = ");
    Reference<UsuarioDO> ref = personajeDO.getUsuarioRef();
    ref.checkUpdate();
    strbuf.append(ref.getIdAsString());
    
    strbuf.append(PersonajeDO.PLANETA_ID);
    strbuf.append(" = ");
    Reference<PlanetaDO> ref1 = personajeDO.getPlanetaRef();
    ref1.checkUpdate();
    strbuf.append(ref1.getIdAsString());
    
    strbuf.append(PersonajeDO.GRUPO_ID);
    strbuf.append(" = ");
    Reference<GrupoDO> ref2 = personajeDO.getGrupoRef();
    ref2.checkUpdate();
    strbuf.append(ref2.getIdAsString());
    
    strbuf.append(PersonajeDO.CLASE_LINTERNA_ID);
    strbuf.append(" = ");
    Reference<ClaseLinternaDO> ref3 = personajeDO.getClaseLinternaRef();
    ref3.checkUpdate();
    strbuf.append(ref3.getIdAsString());
    
    strbuf.append(" WHERE ");
    strbuf.append(PersonajeDO.ID);
    strbuf.append(" = ");
    strbuf.append(personajeDO.getId());

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());
  }

  // --------------------------------------------------------------------------------

  @Override
  public void delete(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_DELETE);
    checkClass(dataObject, PersonajeDO.class, CHECK_DELETE);

    PersonajeDO personajeDO = (PersonajeDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("DELETE FROM ");
    strbuf.append(getTableName());

    strbuf.append(" WHERE ");
    strbuf.append(PersonajeDO.ID);
    strbuf.append(" = ");
    strbuf.append(personajeDO.getId());

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
    
	  PersonajeDO ret = (PersonajeDO) dtaSession.getDtaByKey( //
      PersonajeDO.class, rs.getInt(PersonajeDO.ID));
	  
    if (ret != null) {
      return ret;
    }
    
    ret = new PersonajeDO();
    ret.setId(rs.getInt(PersonajeDO.ID));
    ret.setExperiencia(rs.getInt(PersonajeDO.EXPERIENCIA));
    ret.setPuntosDeEntrenamiento(rs.getInt(PersonajeDO.PUNTOS_DE_ENTRENAMIENTO));
    ret.setSalud(rs.getInt(PersonajeDO.SALUD));
    ret.setEnergiaDelAnillo(rs.getInt(PersonajeDO.ENERGIA_DEL_ANILLO));
    ret.setNivel(rs.getInt(PersonajeDO.NIVEL));
    ret.setUltimaFechaIngreso(rs.getDate(PersonajeDO.ULTIMA_FECHA_INGRESO));
    Reference<PlanetaDO> ref = new Reference<PlanetaDO>();
    ref.setRefIdent(rs.getInt(PersonajeDO.USUARIO_ID));
    Reference<PlanetaDO> ref1 = new Reference<PlanetaDO>();
    ref1.setRefIdent(rs.getInt(PersonajeDO.PLANETA_ID));
    Reference<GrupoDO> ref2 = new Reference<GrupoDO>();
    ref2.setRefIdent(rs.getInt(PersonajeDO.GRUPO_ID));
    Reference<ClaseLinternaDO> ref3 = new Reference<ClaseLinternaDO>();
    ref3.setRefIdent(rs.getInt(PersonajeDO.CLASE_LINTERNA_ID));
        
    return (PersonajeDO) dtaSession.add(ret);
  }

  // --------------------------------------------------------------------------------

  public void loadUsuarioRef(PersonajeDO personajeDO) throws SQLException {

	  checkClass(personajeDO, PersonajeDO.class, CHECK_UPDATE);
	  UsuarioDAO usuarioDAO = new UsuarioDAO();
	  usuarioDAO.init(connectionBean);
	  Reference<UsuarioDO> ref = personajeDO.getUsuarioRef();
	  if (ref.getRefIdent() == 0) {
		  return;
	  }
	  UsuarioDO usuarioDO = (UsuarioDO) usuarioDAO.loadById(ref.getRefIdent());
      ref.setRefValue(usuarioDO);
  }

  // --------------------------------------------------------------------------------

  public void loadClaseLinternaRef(PersonajeDO personajeDO) throws SQLException {

	  checkClass(personajeDO, PersonajeDO.class, CHECK_UPDATE);
	  ClaseLinternaDAO claseLinternaDAO = new ClaseLinternaDAO();
	  claseLinternaDAO.init(connectionBean);
	  Reference<ClaseLinternaDO> ref = personajeDO.getClaseLinternaRef();
	  if (ref.getRefIdent() == 0) {
		  return;
	  }
	  ClaseLinternaDO claseLinternaDO = (ClaseLinternaDO) claseLinternaDAO.loadById(ref.getRefIdent());
      ref.setRefValue(claseLinternaDO);
  }
  
  // --------------------------------------------------------------------------------

  public void loadPlanetaRef(PersonajeDO personajeDO) throws SQLException {
	
	  checkClass(personajeDO, PersonajeDO.class, CHECK_UPDATE);
	  PlanetaDAO planetaDAO = new PlanetaDAO();
	  planetaDAO.init(connectionBean);
	  Reference<PlanetaDO> ref = personajeDO.getPlanetaRef();
	  if (ref.getRefIdent() == 0) {
		  return;
	  }
	  PlanetaDO planetaDO = (PlanetaDO) planetaDAO.loadById(ref.getRefIdent());
      ref.setRefValue(planetaDO);
  }
  
  //--------------------------------------------------------------------------------
  
  public void loadGrupoRef(PersonajeDO personajeDO) throws SQLException {
		
	  checkClass(personajeDO, PersonajeDO.class, CHECK_UPDATE);
	  GrupoDAO grupoDAO = new GrupoDAO();
	  grupoDAO.init(connectionBean);
	  Reference<GrupoDO> ref = personajeDO.getGrupoRef();
	  if (ref.getRefIdent() == 0) {
		  return;
	  }
	  GrupoDO grupoDO = (GrupoDO) grupoDAO.loadById(ref.getRefIdent());
      ref.setRefValue(grupoDO);
  }
  
  // --------------------------------------------------------------------------------

  public List<PersonajeDO> listRankin() throws SQLException {
    
	StringBuffer strbuf = new StringBuffer();
	
    strbuf.append("SELECT" + PersonajeDO.ALIAS + "," + PersonajeDO.NIVEL);
    strbuf.append(","+ PersonajeDO.CLASE_LINTERNA_ID + "FROM ");
    strbuf.append(getTableName());
    strbuf.append("ODERBY BY");
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
