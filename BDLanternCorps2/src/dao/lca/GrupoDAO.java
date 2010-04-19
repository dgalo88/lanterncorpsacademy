package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
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
		strbuf.append("INT REFERENCES    ");
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataObject> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataObject loadById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(DataObject bean) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
