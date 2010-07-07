package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IMisionClaseLinternaDAO;
import lcaInterfaceDAO.IMisionClaseLinternaDO;
import lcaInterfaceDAO.IMisionDO;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class MisionClaseLinternaDAO extends BaseDAO implements IMisionClaseLinternaDAO {

  public MisionClaseLinternaDAO() {
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

    ClaseLinternaDAO claseLinternaDAO = new ClaseLinternaDAO();
    claseLinternaDAO.init(connectionBean);
    
    MisionDAO misionDAO = new MisionDAO();
    misionDAO.init(connectionBean);
    
    
    strbuf = new StringBuffer();

    strbuf.append("CREATE TABLE ");
    strbuf.append(getTableName());
    strbuf.append(" (");
    strbuf.append(MisionClaseLinternaDO.ID);
    strbuf.append(" INT PRIMARY KEY, ");
    strbuf.append(MisionClaseLinternaDO.CLASE_LINTERNA_ID);
    strbuf.append(" INT REFERENCES   ");
    strbuf.append(claseLinternaDAO.getTableName());
    strbuf.append(", ");
    strbuf.append(MisionClaseLinternaDO.MISION_ID);
    strbuf.append(" INT REFERENCES   ");
    strbuf.append(misionDAO.getTableName());
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
    checkClass(dataObject, MisionClaseLinternaDO.class, CHECK_INSERT);

    MisionClaseLinternaDO misionClaseLinternaDO = (MisionClaseLinternaDO) dataObject;

    misionClaseLinternaDO.setId(getNextId());

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("INSERT INTO ");
    strbuf.append(getTableName());
    strbuf.append(" VALUES (");
    strbuf.append(misionClaseLinternaDO.getId());
    strbuf.append(", ");

    Reference<IClaseLinternaDO> refCl = misionClaseLinternaDO.getClaseLinternaRef();
    refCl.checkInsert();
    strbuf.append(refCl.getIdAsString());

    Reference<IMisionDO> refM = misionClaseLinternaDO.getMisionRef();
    refM.checkInsert();
    strbuf.append(refM.getIdAsString());
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
    checkClass(dataObject, MisionClaseLinternaDO.class, CHECK_UPDATE);

    MisionClaseLinternaDO misionClaseLinternaDO = (MisionClaseLinternaDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("UPDATE ");
    strbuf.append(getTableName());
    strbuf.append(" SET ");

    strbuf.append(MisionClaseLinternaDO.CLASE_LINTERNA_ID);
    strbuf.append(" = ");
    Reference<IClaseLinternaDO> refCl = misionClaseLinternaDO.getClaseLinternaRef();
    refCl.checkUpdate();
    strbuf.append(refCl.getIdAsString());

    strbuf.append(", ");

    strbuf.append(MisionClaseLinternaDO.MISION_ID);
    strbuf.append(" = ");
    Reference<IMisionDO> refM = misionClaseLinternaDO.getMisionRef();
    refM.checkUpdate();
    strbuf.append(refM.getIdAsString());

    strbuf.append(" WHERE ");
    strbuf.append(MisionClaseLinternaDO.ID);
    strbuf.append(" = ");
    strbuf.append(misionClaseLinternaDO.getId());

    System.err.println(strbuf.toString());

    connection.createStatement().execute(strbuf.toString());
  }

  // --------------------------------------------------------------------------------

  @Override
  public void delete(DataObject dataObject) throws SQLException {
    checkCache(dataObject, CHECK_DELETE);
    checkClass(dataObject, MisionClaseLinternaDO.class, CHECK_DELETE);

    MisionClaseLinternaDO misionClaseLinternaDO = (MisionClaseLinternaDO) dataObject;

    StringBuffer strbuf = new StringBuffer();

    strbuf.append("DELETE FROM ");
    strbuf.append(getTableName());

    strbuf.append(" WHERE ");
    strbuf.append(MisionClaseLinternaDO.ID);
    strbuf.append(" = ");
    strbuf.append(misionClaseLinternaDO.getId());

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
    strbuf.append(MisionClaseLinternaDO.ID);
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
  
  public List<IMisionClaseLinternaDO> listByClaseLinternaId(int claseLinternaId) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(MisionClaseLinternaDO.CLASE_LINTERNA_ID);
	    strbuf.append(" = ");
	    strbuf.append(claseLinternaId);

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    List<IMisionClaseLinternaDO> ret = new ArrayList<IMisionClaseLinternaDO>();

	    while (rs.next()) {
	      ret.add(resultSetToDO(rs));
	    }

	    return ret;
	  }
  
  // --------------------------------------------------------------------------------
  
  public List<IMisionClaseLinternaDO> listByMisionId(int misionId) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(MisionClaseLinternaDO.CLASE_LINTERNA_ID);
	    strbuf.append(" = ");
	    strbuf.append(misionId);

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    List<IMisionClaseLinternaDO> ret = new ArrayList<IMisionClaseLinternaDO>();

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

  private MisionClaseLinternaDO resultSetToDO(ResultSet rs) throws SQLException {
	  MisionClaseLinternaDO ret = //
    (MisionClaseLinternaDO) dtaSession.getDtaByKey( //
    		MisionClaseLinternaDO.class, rs.getInt(MisionClaseLinternaDO.ID));

    if (ret != null) {
      return ret;
    }

    ret = new MisionClaseLinternaDO();

    ret.setId(rs.getInt(MisionClaseLinternaDO.ID));
 
    Reference<IClaseLinternaDO> refCl = new Reference<IClaseLinternaDO>();
    refCl.setRefIdent(rs.getInt(MisionClaseLinternaDO.CLASE_LINTERNA_ID));
    ret.setClaseLinternaRef(refCl);

    Reference<IMisionDO> refM = new Reference<IMisionDO>();
    refM.setRefIdent(rs.getInt(MisionClaseLinternaDO.MISION_ID));
    ret.setMisionRef(refM);
    
    return (MisionClaseLinternaDO) dtaSession.add(ret);
  }

  // --------------------------------------------------------------------------------

  public void loadClaseLinternaRef(IMisionClaseLinternaDO misionClaseLinternaDO) throws SQLException {
	    checkClass(misionClaseLinternaDO, MisionClaseLinternaDO.class, CHECK_UPDATE);

	    ClaseLinternaDAO claseLinternaDAO = new ClaseLinternaDAO();
	    claseLinternaDAO.init(connectionBean);

	    Reference<IClaseLinternaDO> ref = misionClaseLinternaDO.getClaseLinternaRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	    ClaseLinternaDO claseLinternaDO = //
	    	(ClaseLinternaDO) claseLinternaDAO.loadById(ref.getRefIdent());

	        ref.setRefValue(claseLinternaDO);
  }
  
  // --------------------------------------------------------------------------------

  public void loadMisionRef(IMisionClaseLinternaDO misionClaseLinternaDO) throws SQLException {
	    checkClass(misionClaseLinternaDO, MisionClaseLinternaDO.class, CHECK_UPDATE);

	    MisionDAO misionDAO = new MisionDAO();
	    misionDAO.init(connectionBean);

	    Reference<IMisionDO> ref = misionClaseLinternaDO.getMisionRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	    MisionDO misionDO = //
	    	(MisionDO) misionDAO.loadById(ref.getRefIdent());

	        ref.setRefValue(misionDO);
  }

}
