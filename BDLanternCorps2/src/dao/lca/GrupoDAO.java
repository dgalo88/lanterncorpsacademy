package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.api.BaseDAO;
import dao.api.DataObject;
//import dao.api.FactoryDAO;
import dao.api.Reference;

public class GrupoDAO extends BaseDAO{

	public GrupoDAO(){
		// Empty		
	}
	
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
	    ClaseLinternaDAO claseLinternaDAO = new ClaseLinternaDAO();
	    claseLinternaDAO.init(connectionBean);
		
		
		strbuf = new StringBuffer();
		
		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(GrupoDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(GrupoDO.NOMBRE);
		strbuf.append(" VARCHAR(100),    ");
		strbuf.append(GrupoDO.ESTADO);
		strbuf.append(" BOOLEAN,     ");
		strbuf.append(GrupoDO.CLASE_LINTERNA_ID);
		strbuf.append(" INT REFERENCES ClaseLinternaDO.ID ");
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
	    strbuf.append(grupoDO.getNombre());
	    strbuf.append(", ");
	    strbuf.append(grupoDO.isEstado());
	    strbuf.append(", ");
	    Reference<ClaseLinternaDO> ref = grupoDO.getClaseLinternaRef();
	    ref.checkInsert();
	    strbuf.append(ref.getIdAsString());
	    strbuf.append(", ");
	    strbuf.append(")");
	    System.err.println(strbuf.toString());
	    connection.createStatement().execute(strbuf.toString());
	    dtaSession.add(dataObject);
		
	}


	private int getNextId() throws SQLException{
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

	@Override
	public List<DataObject> listAll() throws SQLException {
	    return listAll(-1, -1);
	}

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

	
	private GrupoDO resultSetToDO(ResultSet rs) throws SQLException {
		GrupoDO ret = //
		(GrupoDO) dtaSession.getDtaByKey( //
				GrupoDO.class, rs.getInt(GrupoDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new GrupoDO();

		ret.setId/*      */(rs.getInt(GrupoDO.ID));
		ret.setNombre/*  */(rs.getString(GrupoDO.NOMBRE));
		ret.setEstado/*  */(rs.getBoolean(GrupoDO.ESTADO));

		Reference<ClaseLinternaDO> ref = new Reference<ClaseLinternaDO>();
		ref.setRefIdent(rs.getInt(GrupoDO.CLASE_LINTERNA_ID));

		ret.setClaseLinternaRef(ref);

		return (GrupoDO) dtaSession.add(ret);
	}
}
