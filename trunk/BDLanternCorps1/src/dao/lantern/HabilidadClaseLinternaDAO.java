package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class HabilidadClaseLinternaDAO extends BaseDAO {

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

	    ClaseLinternaDAO claseLinternaDAO = new ClaseLinternaDAO(); // Used to make the FK
	    claseLinternaDAO.init(connectionBean);
	    
	    HabilidadDAO habilidadDAO = new HabilidadDAO(); // Used to make the FK
	    habilidadDAO.init(connectionBean);

	    strbuf = new StringBuffer();

	    strbuf.append("CREATE TABLE ");
	    strbuf.append(getTableName());
	    strbuf.append(" (");
	    strbuf.append(HabilidadClaseLinternaDO.ID);
	    strbuf.append(" INT PRIMARY KEY, ");
	    
	    strbuf.append(HabilidadClaseLinternaDO.CLASE_LINTERNA_ID);
	    strbuf.append(" INT REFERENCES   ");
	    strbuf.append(claseLinternaDAO.getTableName()+", ");
	    strbuf.append(HabilidadClaseLinternaDO.HABILIDAD_ID);
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

	// ----------------------------------------

	@Override
	public void delete(DataObject dataObject) throws SQLException {
	    checkCache(dataObject, CHECK_DELETE);
	    checkClass(dataObject, HabilidadDO.class, CHECK_DELETE);

	    HabilidadClaseLinternaDO habilidadClaseLinternaDO = (HabilidadClaseLinternaDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("DELETE FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(HabilidadClaseLinternaDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(habilidadClaseLinternaDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.del(dataObject);

	}

    // ----------------------------------------

	@Override
	public void insert(DataObject dataObject) throws SQLException {
	    checkCache(dataObject, CHECK_INSERT);
	    checkClass(dataObject, HabilidadClaseLinternaDO.class, CHECK_INSERT);

	    HabilidadClaseLinternaDO habilidadClaseLinternaDO = (HabilidadClaseLinternaDO) dataObject;

	    habilidadClaseLinternaDO.setId(getNextId());

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("INSERT INTO ");
	    strbuf.append(getTableName());
	    strbuf.append(" VALUES (");
	    strbuf.append(habilidadClaseLinternaDO.getId());
	    strbuf.append(", ");

	    Reference<ClaseLinternaDO> refcl = habilidadClaseLinternaDO.getClaseLinternaRef();
	    refcl.checkInsert();
	    strbuf.append(refcl.getIdAsString());
	    
	    
	    strbuf.append(", ");

	    Reference<HabilidadDO> refh = habilidadClaseLinternaDO.getHabilidadRef();
	    refh.checkInsert();
	    strbuf.append(refh.getIdAsString());
	    strbuf.append(")");

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.add(dataObject);

	}

    // ----------------------------------------

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

    // ----------------------------------------

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

    // ----------------------------------------

	private HabilidadClaseLinternaDO resultSetToDO(ResultSet rs) throws SQLException {
		HabilidadClaseLinternaDO ret = //
		(HabilidadClaseLinternaDO) dtaSession.getDtaByKey( //
				HabilidadClaseLinternaDO.class, rs
						.getInt(HabilidadClaseLinternaDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new HabilidadClaseLinternaDO();

		ret.setId/*     */(rs.getInt(HabilidadClaseLinternaDO.ID));

		Reference<ClaseLinternaDO> refCl = new Reference<ClaseLinternaDO>();
		refCl.setRefIdent(rs.getInt(HabilidadClaseLinternaDO.CLASE_LINTERNA_ID));
		ret.setClaseLinternaRef(refCl);

		Reference<HabilidadDO> refH = new Reference<HabilidadDO>();
		refH.setRefIdent(rs.getInt(HabilidadClaseLinternaDO.HABILIDAD_ID));
		ret.setHabilidadRef(refH);

		return (HabilidadClaseLinternaDO) dtaSession.add(ret);
	}

    // ----------------------------------------

	@Override
	public List<DataObject> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
    // ----------------------------------------

	public List<HabilidadClaseLinternaDO> listByHabilidadId(int habilidadId)
	throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(HabilidadClaseLinternaDO.HABILIDAD_ID);
		strbuf.append(" = ");
		strbuf.append(habilidadId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
			connection.createStatement().executeQuery(strbuf.toString());

		List<HabilidadClaseLinternaDO> ret = new ArrayList<HabilidadClaseLinternaDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}
	
    // ----------------------------------------

	public List<HabilidadClaseLinternaDO> listByClaseLinternaId(int claseLinternaId)
	throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(HabilidadClaseLinternaDO.CLASE_LINTERNA_ID);
		strbuf.append(" = ");
		strbuf.append(claseLinternaId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
			connection.createStatement().executeQuery(strbuf.toString());

		List<HabilidadClaseLinternaDO> ret = new ArrayList<HabilidadClaseLinternaDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}
    // ----------------------------------------

	@Override
	public DataObject loadById(int id) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(HabilidadClaseLinternaDO.ID);
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

	  public void loadHabilidadRef(HabilidadClaseLinternaDO habilidadClaseLinternaDO) throws SQLException {
	    // XXX: Check this method's semantic
	    checkClass(habilidadClaseLinternaDO, HabilidadClaseLinternaDO.class, CHECK_UPDATE);

	    HabilidadDAO habilidadDAO = new HabilidadDAO();
	    habilidadDAO.init(connectionBean);

	    Reference<HabilidadDO> ref = habilidadClaseLinternaDO.getHabilidadRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	    HabilidadDO habilidadDO = //
	    (HabilidadDO) habilidadDAO.loadById(ref.getRefIdent());

	    ref.setRefValue(habilidadDO);
	  }

		// --------------------------------------------------------------------------------

	  public void loadClaseLinternaRef(HabilidadClaseLinternaDO habilidadClaseLinternaDO) throws SQLException {
	    // XXX: Check this method's semantic
	    checkClass(habilidadClaseLinternaDO, HabilidadClaseLinternaDO.class, CHECK_UPDATE);

	    ClaseLinternaDAO claseLinternaDAO = new ClaseLinternaDAO();
	    claseLinternaDAO.init(connectionBean);

	    Reference<ClaseLinternaDO> ref = habilidadClaseLinternaDO.getClaseLinternaRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	    ClaseLinternaDO claseLinternaDO = //
	    (ClaseLinternaDO) claseLinternaDAO.loadById(ref.getRefIdent());

	    ref.setRefValue(claseLinternaDO);
	  }

	@Override
	public void update(DataObject dataObject) throws SQLException {
	    checkCache(dataObject, CHECK_UPDATE);
	    checkClass(dataObject, HabilidadClaseLinternaDO.class, CHECK_UPDATE);

	    HabilidadClaseLinternaDO habilidadClaseLinternaDO = (HabilidadClaseLinternaDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("UPDATE ");
	    strbuf.append(getTableName());
	    strbuf.append(" SET ");

	    strbuf.append(HabilidadClaseLinternaDO.CLASE_LINTERNA_ID);
	    strbuf.append(" = ");
	    Reference<ClaseLinternaDO> refCl = habilidadClaseLinternaDO.getClaseLinternaRef();
	    refCl.checkUpdate();
	    strbuf.append(refCl.getIdAsString());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(HabilidadClaseLinternaDO.HABILIDAD_ID);
	    strbuf.append(" = ");
	    Reference<HabilidadDO> refH = habilidadClaseLinternaDO.getHabilidadRef();
	    refH.checkUpdate();
	    strbuf.append(refH.getIdAsString());

	    strbuf.append(" WHERE ");
	    strbuf.append(HabilidadClaseLinternaDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(habilidadClaseLinternaDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	}

}
