package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;
import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.IAndroideDAO;
import lcaInterfaceDAO.IAndroideDO;
import lcaInterfaceDAO.IClaseLinternaDO;

public class AndroideDAO extends BaseDAO implements IAndroideDAO {



		public AndroideDAO() {
			// TODO Auto-generated constructor stub
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
	    checkClass(dataObject, AndroideDO.class, CHECK_INSERT);

	    AndroideDO androideDO = (AndroideDO) dataObject;

	    androideDO.setId(getNextId());

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("INSERT INTO ");
	    strbuf.append(getTableName());
	    strbuf.append(" VALUES (");
	    strbuf.append(androideDO.getId());
	    strbuf.append(", ");
	    strbuf.append(singleQuotes(androideDO.getTipo());
	    strbuf.append(", ");
	    strbuf.append(singleQuotes(androideDO.getCantidad()));
	    strbuf.append(", ");

	    Reference<ITecnologiaDO> refTec = androideDO.getTecnologiaRef();
	    refTec.checkInsert();
	    strbuf.append(refTec.getIdAsString());

	    strbuf.append(")");

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.add(dataObject);
	  }

	  // --------------------------------------------------------------------------------

	  @Override
	  public void update(DataObject dataObject) throws SQLException {
	    checkCache(dataObject, CHECK_UPDATE);
	    checkClass(dataObject, ClaseLinternaDO.class, CHECK_UPDATE);

	    AndroideDO androideDO = (AndroideDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("UPDATE ");
	    strbuf.append(getTableName());
	    strbuf.append(" SET ");

	    strbuf.append(AndroideDO.TIPO);
	    strbuf.append(" = ");
	    strbuf.append(singleQuotes(androideDO.getTipo()));

	    strbuf.append(", ");

	    strbuf.append(AndroideDO.CANTIDAD);
	    strbuf.append(" = ");
	    strbuf.append(singleQuotes(androideDO.getCantidad()));
	    
	    strbuf.append(", ");
	    
	    strbuf.append(AndroideDO.TECNOLOGIA_ID);
	    strbuf.append(" = ");
	    Reference<ITecnologiaDO> refTec = androideDO.getTecnologiaRef();
	    refTec.checkUpdate();
	    strbuf.append(refTec.getIdAsString());
	    
	    strbuf.append(" WHERE ");
	    strbuf.append(AndroideDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(androideDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());
	  }

	  // --------------------------------------------------------------------------------

	  @Override
	  public void delete(DataObject dataObject) throws SQLException {
	    checkCache(dataObject, CHECK_DELETE);
	    checkClass(dataObject, AndroideDO.class, CHECK_DELETE);

	    AndroideDO androideDO = (AndroideDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("DELETE FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(AndroideDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(androideDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.del(dataObject);
	  }

	  // --------------------------------------------------------------------------------

	  @Override
	  public AndroideDO loadById(int id) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(AndroideDO.ID);
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

	  
	  public IAndroideDO loadByTipo(String tipo) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(AndroideDO.TIPO);
	    strbuf.append(" = ");
	    strbuf.append(singleQuotes(tipo));

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    if (rs.next()) {
	      return resultSetToDO(rs);
	    }

	    return null;
	  }

	  // --------------------------------------------------------------------------------
	  
	  public IAndroideDO loadByCantidad(String cantidad) throws SQLException {
		    StringBuffer strbuf = new StringBuffer();

		    strbuf.append("SELECT * FROM ");
		    strbuf.append(getTableName());

		    strbuf.append(" WHERE ");
		    strbuf.append(AndroideDO.CANTIDAD);
		    strbuf.append(" = ");
		    strbuf.append(singleQuotes(cantidad));

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

	  public List<AndroideDO> listByAndroidePersonajeId(int androidePersonajeId) throws SQLException {
		    StringBuffer strbuf = new StringBuffer();

		    strbuf.append("SELECT * FROM ");
		    strbuf.append(getTableName());

		    strbuf.append(" WHERE ");
		    strbuf.append(AndroideDO.ANDROIDE_PERSONAJE_ID);
		    strbuf.append(" = ");
		    strbuf.append(androidePersonajeId);

		    System.err.println(strbuf.toString());

		    ResultSet rs = //
		    connection.createStatement().executeQuery(strbuf.toString());

		    List<AndroideDO> ret = new ArrayList<AndroideDO>();

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

	  private AndroideDO resultSetToDO(ResultSet rs) throws SQLException {
	    AndroideDO ret = //
	    (AndroideDO) dtaSession.getDtaByKey( //
	        AndroideDO.class, rs.getInt(AndroideDO.ID));

	    if (ret != null) {
	      return ret;
	    }

	    ret = new AndroideDO();

	    ret.setId/*     					*/(rs.getInt(AndroideDO.ID));
	    ret.setTipo/*						*/(rs.getString(AndroideDO.TIPO));
	    ret.getCantidad/*	*/(rs.getString(AndroideDO.CANTIDAD));

	    Reference<ITecnologiaDO> refTec = new Reference<ITecnologiaDO>();
	    refTec.setRefIdent(rs.getInt(AndroideDO.TECNOLOGIA_ID));
	    ret.setTecnologiaRef(refTec);
	    
	    return (AndroideDO) dtaSession.add(ret);
	  }

	  // --------------------------------------------------------------------------------

	  public void loadTecnologiaRef(IAndroideDO androideDO) throws SQLException {
	    // XXX: Check this method's semantic
	    checkClass(androideDO, AndroideDO.class, CHECK_UPDATE);

	    TecnologiaDAO tecnologiaDAO = new TecnologiaDAO();
	    tecnologiaDAO.init(connectionBean);

	    Reference<ITecnologiaDO> ref = androideDO.getTecnologiaRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	   TecnologiaDO tecnologiaDO = //
	    (TecnologiaDO) tecnologiaDAO.loadById(ref.getRefIdent());

	    ref.setRefValue(tecnologiaDO);
	  }
	  
	// --------------------------------------------------------------------------------

	public void loadAndroidePersonajeList(IAndroideDO androideDO) throws Exception {
	  checkCache(androideDO, CHECK_UPDATE);

	  	AndroidePersonajeDAO androidePersonajeDAO = (androidePersonajeDAO) FactoryDAO.getDAO( //
	      AndroidePersonajeDAO.class, connectionBean);

	  	androideDO.getAndroidePersonajeList(androidePersonajeDAO.listByAndroidePersonajeId(androideDO.getId()));
		}

	//--------------------------------------------------------------------------------

	public void loadAndroideRecursoList(IAndroideDO androideDO) throws Exception {
	  checkCache(androideDO, CHECK_UPDATE);

	  	AndroideRecursoDAO androideRecursoDAO = (AndroideRecursoDAO) FactoryDAO.getDAO( //
	  			AndroideRecursoDAO.class, connectionBean);

	  	androideDO.setAndroideRecursojeList(androidePersonajeDAO.listByAndroideId(androideDO.getId()));
		}

	//--------------------------------------------------------------------------------

		public boolean checkIfTipoExists(String tipo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<IAndroideDO> listAndroides() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAndroideDO loadByTipo() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
