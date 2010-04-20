package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class PlanetaDAO extends BaseDAO {

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

    ClaseLinternaDAO claseLinternaDAO = new ClaseLinternaDAO(); 
    claseLinternaDAO.init(connectionBean);
    
    strbuf = new StringBuffer();

    strbuf.append("DROP SEQUENCE IF EXISTS ");
    strbuf.append("seq_");
    strbuf.append(getTableName());

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());

    // ----------------------------------------
/*
    PlanetaDAO planetaDAO = new PlanetaDAO(); // Used to make the FK
    planetaDAO.init(connectionBean);
    
    HabilidadClaseLinternaDAO habilidadClaseLinternaDAO = new HabilidadClaseLinternaDAO(); // Used to make the FK
    habilidadClaseLinternaDAO.init(connectionBean);
*/
    strbuf = new StringBuffer();

    strbuf.append("CREATE TABLE ");
    strbuf.append(getTableName());
    strbuf.append(" (");
    strbuf.append(PlanetaDO.ID);
    strbuf.append(" INT PRIMARY KEY, ");
    strbuf.append(PlanetaDO.NOMBRE);
    strbuf.append(" VARCHAR(50),    ");
    strbuf.append(PlanetaDO.SECTOR);
    strbuf.append(" VARCHAR(50),    ");
    strbuf.append(PlanetaDO.COORDENADA_EN_X);
    strbuf.append(" FLOAT,    ");
    strbuf.append(PlanetaDO.COORDENADA_EN_Y);
    strbuf.append(" FLOAT,    ");
    strbuf.append(PlanetaDO.CLASE_LINTERNA_ID);
    strbuf.append(" INT REFERENCES   ");
    strbuf.append(claseLinternaDAO.getTableName());

    
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
    checkClass(dataObject, PlanetaDO.class, CHECK_INSERT);

    PlanetaDO planetaDO = (PlanetaDO) dataObject;

    planetaDO.setId(getNextId());

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("INSERT INTO ");
    strbuf.append(getTableName());
    strbuf.append(" VALUES (");
    strbuf.append(planetaDO.getId());
    strbuf.append(", ");
    strbuf.append(singleQuotes(planetaDO.getNombre()));
    strbuf.append(", ");
    strbuf.append(singleQuotes(planetaDO.getSector()));
    strbuf.append(", ");
    strbuf.append(planetaDO.getCoordenadaEnX());
    strbuf.append(", ");
    strbuf.append(planetaDO.getCoordenadaEnY());
    strbuf.append(", ");
    Reference<ClaseLinternaDO> refU = planetaDO.getClaseLinternaRef();
    refU.checkInsert();
    strbuf.append(refU.getIdAsString());
    
    strbuf.append(")");

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());

    dtaSession.add(dataObject);
  }

  // --------------------------------------------------------------------------------

  @Override
  public void update(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_UPDATE);
    checkClass(dataObject, PlanetaDO.class, CHECK_UPDATE);

    PlanetaDO planetaDO = (PlanetaDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("UPDATE ");
    strbuf.append(getTableName());
    strbuf.append(" SET ");

    strbuf.append(PlanetaDO.SECTOR);
    strbuf.append(" = ");
    strbuf.append(singleQuotes(planetaDO.getSector()));

    strbuf.append(", ");

    strbuf.append(PlanetaDO.COORDENADA_EN_X);
    strbuf.append(" = ");
    strbuf.append(planetaDO.getCoordenadaEnX());

    strbuf.append(", ");

    strbuf.append(PlanetaDO.COORDENADA_EN_Y);
    strbuf.append(" = ");
    strbuf.append(planetaDO.getCoordenadaEnY());
    strbuf.append(", ");
    
    Reference<ClaseLinternaDO> refH = planetaDO.getClaseLinternaRef();
    refH.checkUpdate();
    strbuf.append(refH.getIdAsString());
    
    strbuf.append(" WHERE ");
    strbuf.append(PlanetaDO.ID);
    strbuf.append(" = ");
    strbuf.append(planetaDO.getId());

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());
  }

  // --------------------------------------------------------------------------------

  @Override
  public void delete(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_DELETE);
    checkClass(dataObject, PlanetaDO.class, CHECK_DELETE);

    PlanetaDO planetaDO = (PlanetaDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("DELETE FROM ");
    strbuf.append(getTableName());

    strbuf.append(" WHERE ");
    strbuf.append(PlanetaDO.ID);
    strbuf.append(" = ");
    strbuf.append(planetaDO.getId());

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
    strbuf.append(PlanetaDO.ID);
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

  private PlanetaDO resultSetToDO(ResultSet rs) throws SQLException {
	  PlanetaDO ret = //
    (PlanetaDO) dtaSession.getDtaByKey( //
    		PlanetaDO.class, rs.getInt(PlanetaDO.ID));

    if (ret != null) {
      return ret;
    }

    ret = new PlanetaDO();

    ret.setId/*     			*/(rs.getInt(PlanetaDO.ID));
    ret.setSector/*				*/(rs.getString(PlanetaDO.SECTOR));
    ret.setCoordenadaEnX/*  	*/(rs.getFloat(PlanetaDO.COORDENADA_EN_X));
    ret.setCoordenadaEnY/*  	*/(rs.getFloat(PlanetaDO.COORDENADA_EN_Y));
    
    Reference<ClaseLinternaDO> refU = new Reference<ClaseLinternaDO>();
    refU.setRefIdent(rs.getInt(PlanetaDO.CLASE_LINTERNA_ID));
    ret.setClaseLinternaRef(refU);

    
    return (PlanetaDO) dtaSession.add(ret);
  }

  // --------------------------------------------------------------------------------

  public void loadObjetivoList(PlanetaDO planetaDO) throws SQLException {
    // XXX: Check this method's semantic
	checkCache(planetaDO, CHECK_UPDATE);
    checkClass(planetaDO, PlanetaDO.class, CHECK_UPDATE);

    ObjetivoDAO objetivoDAO = new ObjetivoDAO();
    objetivoDAO.init(connectionBean);

   // planetaDO.setObjetivoList(objetivoDAO.ListByIdPlanetaID(planetaDO.getId()));

  }
  
  
  // --------------------------------------------------------------------------------

  public void loadPersonajeList(PlanetaDO planetaDO) throws SQLException {
    // XXX: Check this method's semantic
	checkCache(planetaDO, CHECK_UPDATE);
    checkClass(planetaDO, PlanetaDO.class, CHECK_UPDATE);

    PersonajeDAO personajeDAO = new PersonajeDAO();
    personajeDAO.init(connectionBean);

   // planetaDO.setPersonajeList(personajeDAO.ListByIdPlanetaId(planetaDO.getId()));

  }
  // --------------------------------------------------------------------------------

  public void loadClaseLinternaRef(PlanetaDO planetaDO) throws SQLException {
    // XXX: Check this method's semantic
    checkClass(planetaDO, PlanetaDO.class, CHECK_UPDATE);

    ClaseLinternaDAO claseLinternaDAO = new ClaseLinternaDAO();
    claseLinternaDAO.init(connectionBean);

    Reference<ClaseLinternaDO> ref = planetaDO.getClaseLinternaRef();

    if (ref.getRefIdent() == 0) {
      return;
    }

    ClaseLinternaDO claseLinternaDO = //
    (ClaseLinternaDO) claseLinternaDAO.loadById(ref.getRefIdent());

    ref.setRefValue(claseLinternaDO);
  }
  
}
