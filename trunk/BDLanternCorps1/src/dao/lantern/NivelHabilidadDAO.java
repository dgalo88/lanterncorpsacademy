package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IHabilidadActivaDO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.INivelHabilidadDAO;
import lcaInterfaceDAO.INivelHabilidadDO;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class NivelHabilidadDAO extends BaseDAO implements INivelHabilidadDAO {

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

	@Override
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

	    HabilidadDAO habilidadDAO = new HabilidadDAO(); 
	    habilidadDAO.init(connectionBean);
	    
	    strbuf = new StringBuffer();

	    strbuf.append("CREATE TABLE ");
	    strbuf.append(getTableName());
	    strbuf.append(" (");
	    strbuf.append(NivelHabilidadDO.ID);
	    strbuf.append(" INT PRIMARY KEY, ");
	    strbuf.append(NivelHabilidadDO.NIVEL_DE_HABILIDAD); 
	    strbuf.append(" INT,    ");
	    strbuf.append(NivelHabilidadDO.EFECTIVIDAD); 
	    strbuf.append(" FLOAT,   ");
	    strbuf.append(NivelHabilidadDO.COSTO_DE_ENERGIA); 
	    strbuf.append(" FLOAT,   ");
	    strbuf.append(NivelHabilidadDO.PROBABILIDAD); 
	    strbuf.append(" INT,   ");

	    strbuf.append(NivelHabilidadDO.HABILIDAD_ID);
	    strbuf.append(" INT REFERENCES   ");
	    strbuf.append(habilidadDAO.getTableName());
	    
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

	@Override
	public void delete(DataObject dataObject) throws SQLException {
	    checkCache(dataObject, CHECK_DELETE);
	    checkClass(dataObject, NivelHabilidadDO.class, CHECK_DELETE);

	    NivelHabilidadDO nivelHabilidadDO = (NivelHabilidadDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("DELETE FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(NivelHabilidadDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(nivelHabilidadDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.del(dataObject);

	}

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
	    checkClass(dataObject, NivelHabilidadDO.class, CHECK_INSERT);

	    NivelHabilidadDO nivelHabilidadDO = (NivelHabilidadDO) dataObject;

	    nivelHabilidadDO.setId(getNextId());

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("INSERT INTO ");
	    strbuf.append(getTableName());
	    strbuf.append(" VALUES (");
	    strbuf.append(nivelHabilidadDO.getId()); // INSTANCIA
	    strbuf.append(", ");
	    strbuf.append(nivelHabilidadDO.getNivel_de_habilidad());
	    strbuf.append(", ");
	    strbuf.append(nivelHabilidadDO.getEfectividad());
	    strbuf.append(", ");
	    strbuf.append(nivelHabilidadDO.getCosto_de_energia());
	    strbuf.append(", ");
	    strbuf.append(nivelHabilidadDO.getProbabilidad());
	    strbuf.append(", ");
	    
	    Reference<IHabilidadDO> refU = nivelHabilidadDO.getHabilidadRef();
	    refU.checkInsert();
	    strbuf.append(refU.getIdAsString());
	    
	    strbuf.append(")");

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.add(dataObject);

	}

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

	private NivelHabilidadDO resultSetToDO(ResultSet rs) throws SQLException {
		NivelHabilidadDO ret = //
	        (NivelHabilidadDO) dtaSession.getDtaByKey( //
	        		NivelHabilidadDO.class, rs.getInt(NivelHabilidadDO.ID));

	        if (ret != null) {
	          return ret;
	        }
	        
	        ret = new NivelHabilidadDO();

	        ret.setId/*     			*/(rs.getInt(PersonajeDO.ID));
	        ret.setNivel_de_habilidad/*	*/(rs.getInt(NivelHabilidadDO.NIVEL_DE_HABILIDAD));
	        ret.setEfectividad/*	    */(rs.getInt(NivelHabilidadDO.EFECTIVIDAD));
	        ret.setCosto_de_energia/*	    */(rs.getInt(NivelHabilidadDO.COSTO_DE_ENERGIA));
	        ret.setProbabilidad/*		*/(rs.getInt(NivelHabilidadDO.PROBABILIDAD));

	        Reference<IHabilidadDO> refH = new Reference<IHabilidadDO>();
	        refH.setRefIdent(rs.getInt(NivelHabilidadDO.HABILIDAD_ID));
	        ret.setHabilidadRef(refH);
	        
	        return (NivelHabilidadDO) dtaSession.add(ret);
	}

	  // --------------------------------------------------------------------------------

	@Override
	public List<DataObject> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	  // --------------------------------------------------------------------------------

	@Override
	public DataObject loadById(int id) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(NivelHabilidadDO.ID);
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
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
	    checkClass(dataObject, NivelHabilidadDO.class, CHECK_UPDATE);

	    NivelHabilidadDO nivelHabilidadDO = (NivelHabilidadDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("UPDATE ");
	    strbuf.append(getTableName());
	    strbuf.append(" SET ");

	    strbuf.append(NivelHabilidadDO.NIVEL_DE_HABILIDAD);
	    strbuf.append(" = ");
	    strbuf.append(nivelHabilidadDO.getEfectividad());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(NivelHabilidadDO.COSTO_DE_ENERGIA);
	    strbuf.append(" = ");
	    strbuf.append(nivelHabilidadDO.getCosto_de_energia());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(NivelHabilidadDO.PROBABILIDAD);
	    strbuf.append(" = ");
	    strbuf.append(nivelHabilidadDO.getProbabilidad());
	    
	    strbuf.append(", ");	    
	    	    
	    strbuf.append(NivelHabilidadDO.HABILIDAD_ID);
	    strbuf.append(" = ");
	    Reference<IHabilidadDO> refH = nivelHabilidadDO.getHabilidadRef();
	    refH.checkUpdate();
	    strbuf.append(refH.getIdAsString());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(" WHERE ");
	    strbuf.append(NivelHabilidadDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(nivelHabilidadDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	}
	
	// --------------------------------------------------------------------------------
	  
	  public List<INivelHabilidadDO> listByHabilidadId(int habilidadId) throws SQLException {
		    StringBuffer strbuf = new StringBuffer();

		    strbuf.append("SELECT * FROM ");
		    strbuf.append(getTableName());

		    strbuf.append(" WHERE ");
		    strbuf.append(NivelHabilidadDO.HABILIDAD_ID);
		    strbuf.append(" = ");
		    strbuf.append(habilidadId);

		    System.err.println(strbuf.toString());

		    ResultSet rs = //
		    connection.createStatement().executeQuery(strbuf.toString());

		    List<INivelHabilidadDO> ret = new ArrayList<INivelHabilidadDO>();

		    while (rs.next()) {
		      ret.add(resultSetToDO(rs));
		    }

		    return ret;
		  }

	  // --------------------------------------------------------------------------------

	  public void loadHabilidadRef(INivelHabilidadDO nivelHabilidadDO) throws SQLException {

	    checkClass(nivelHabilidadDO, NivelHabilidadDO.class, CHECK_UPDATE);

	    HabilidadDAO habilidadDAO = new HabilidadDAO();
	    habilidadDAO.init(connectionBean);

	    Reference<IHabilidadDO> ref = nivelHabilidadDO.getHabilidadRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	    HabilidadDO habilidadDO = //
	    (HabilidadDO) habilidadDAO.loadById(ref.getRefIdent());

	    ref.setRefValue(habilidadDO);
	  }



}
