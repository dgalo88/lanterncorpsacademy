package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class MisionDAO extends BaseDAO {

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

    MisionDAO misionDAO = new MisionDAO(); // Used to make the FK
    misionDAO.init(connectionBean);

    strbuf = new StringBuffer();

    strbuf.append("CREATE TABLE ");
    strbuf.append(getTableName());
    strbuf.append(" (");
    strbuf.append(MisionDO.ID);
    strbuf.append(" INT PRIMARY KEY, ");
    strbuf.append(MisionDO.NOMBRE);
    strbuf.append(" VARCHAR(50),    ");
    strbuf.append(MisionDO.DESCRIPCION);
    strbuf.append(" VARCHAR(250),    ");
    strbuf.append(MisionDO.EXPERIENCIA_GANADA);
    strbuf.append(" INT,    ");
    strbuf.append(MisionDO.PUNTOS_DE_ENTRENAMIENTO_GANADOS);
    strbuf.append(" INT,    ");
    strbuf.append(MisionDO.NIVEL_NECESARIO);
    strbuf.append(" INT,    ");
    strbuf.append(MisionDO.ORDEN_ID);
    strbuf.append(" INT REFERENCES   ");
    strbuf.append(ordenDAO.getTableName());
    strbuf.append(MisionDO.MISION_PERSONAJE_ID);
    strbuf.append(" INT REFERENCES   ");
    strbuf.append(misionPersonajeDAO.getTableName());
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
    checkClass(dataObject, MisionDO.class, CHECK_INSERT);

    MisionDO misionDO = (MisionDO) dataObject;

    misionDO.setId(getNextId());

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("INSERT INTO ");
    strbuf.append(getTableName());
    strbuf.append(" VALUES (");
    strbuf.append(misionDO.getId());
    strbuf.append(", ");
    strbuf.append(singleQuotes(misionDO.getNombre()));
    strbuf.append(", ");
    strbuf.append(singleQuotes(misionDO.getDescripcion()));
    strbuf.append(", ");
    strbuf.append(misionDO.getExperiencia_ganada());
    strbuf.append(", ");
    strbuf.append(misionDO.getNivel_necesario());
    strbuf.append(", ");
    strbuf.append(misionDO.getPuntos_de_entrenamiento_ganados());
    strbuf.append(", ");
   
    Reference<OrdenDO> refO = misionDO.getOrdenRef();
    refO.checkInsert();
    strbuf.append(refO.getIdAsString());
    
    Reference<MisionPersonajeDO> refMP = misionDO.getMisionPersonajeRef();
    refMP.checkInsert();
    strbuf.append(refMP.getIdAsString());

    strbuf.append(")");

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());

    dtaSession.add(dataObject);
  }

  // --------------------------------------------------------------------------------

  @Override
  public void update(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_UPDATE);
    checkClass(dataObject, MisionDO.class, CHECK_UPDATE);

    MisionDO misionDO = (MisionDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("UPDATE ");
    strbuf.append(getTableName());
    strbuf.append(" SET ");

    strbuf.append(MisionDO.DESCRIPCION);
    strbuf.append(" = ");
    strbuf.append(singleQuotes(misionDO.getDescripcion()));

    strbuf.append(", ");

    strbuf.append(ClaseLinternaDO.NOMBRE_DE_CUERPO_LINTERNA);
    strbuf.append(" = ");
    strbuf.append(singleQuotes(claseLinternaDO.getNombre_de_cuerpo_linterna()));

    strbuf.append(", ");

    strbuf.append(ClaseLinternaDO.HABILIDAD_CLASE_LINTERNA_ID);
    strbuf.append(" = ");
    Reference<HabilidadClaseLinternaDO> refH = claseLinternaDO.getHabilidadClaseLinternaRef();
    refH.checkUpdate();
    strbuf.append(refH.getIdAsString());
    
    strbuf.append(", ");
    
    strbuf.append(ClaseLinternaDO.PLANETA_ID);
    strbuf.append(" = ");
    Reference<PlanetaDO> refPl = claseLinternaDO.getPlanetaRef();
    refPl.checkUpdate();
    strbuf.append(refPl.getIdAsString());
    
    strbuf.append(" WHERE ");
    strbuf.append(ClaseLinternaDO.ID);
    strbuf.append(" = ");
    strbuf.append(claseLinternaDO.getId());

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());
  }

  // --------------------------------------------------------------------------------

  @Override
  public void delete(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_DELETE);
    checkClass(dataObject, ClaseLinternaDO.class, CHECK_DELETE);

    ClaseLinternaDO claseLinternaDO = (ClaseLinternaDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("DELETE FROM ");
    strbuf.append(getTableName());

    strbuf.append(" WHERE ");
    strbuf.append(ClaseLinternaDO.ID);
    strbuf.append(" = ");
    strbuf.append(claseLinternaDO.getId());

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
    strbuf.append(ClaseLinternaDO.ID);
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

  // --------------------------------------------------------------------------------

  public List<ClaseLinternaDO> listByIdPlanetaId(int planetaId) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(ClaseLinternaDO.PLANETA_ID);
	    strbuf.append(" = ");
	    strbuf.append(planetaId);

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    List<ClaseLinternaDO> ret = new ArrayList<ClaseLinternaDO>();

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

  private ClaseLinternaDO resultSetToDO(ResultSet rs) throws SQLException {
    ClaseLinternaDO ret = //
    (ClaseLinternaDO) dtaSession.getDtaByKey( //
        ClaseLinternaDO.class, rs.getInt(ClaseLinternaDO.ID));

    if (ret != null) {
      return ret;
    }

    ret = new ClaseLinternaDO();

    ret.setId/*     					*/(rs.getInt(ClaseLinternaDO.ID));
    ret.setColor/*						*/(rs.getString(ClaseLinternaDO.COLOR));
    ret.setNombre_de_cuerpo_linterna/*	*/(rs.getString(ClaseLinternaDO.NOMBRE_DE_CUERPO_LINTERNA));

    Reference<HabilidadClaseLinternaDO> refH = new Reference<HabilidadClaseLinternaDO>();
    refH.setRefIdent(rs.getInt(ClaseLinternaDO.HABILIDAD_CLASE_LINTERNA_ID));
    ret.setHabilidadClaseLinternaRef(refH);

    Reference<PlanetaDO> refPl = new Reference<PlanetaDO>();
    refPl.setRefIdent(rs.getInt(ClaseLinternaDO.PLANETA_ID));
    ret.setPlanetaRef(refPl);
    
    return (ClaseLinternaDO) dtaSession.add(ret);
  }

  // --------------------------------------------------------------------------------

  public void loadHabilidadClaseLinternaRef(ClaseLinternaDO claseLinternaDO) throws SQLException {
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
  
  // --------------------------------------------------------------------------------

  public void loadPlanetaRef(ClaseLinternaDO claseLinternaDO) throws SQLException {
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
  
}
