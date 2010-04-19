package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class ClaseLinternaDAO extends BaseDAO{
	
	public ClaseLinternaDAO(){
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
		
	    PlanetaDAO planetaDAO = new PlanetaDAO();
	    planetaDAO.init(connectionBean);
		
		strbuf = new StringBuffer();
		
		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(ClaseLinternaDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(ClaseLinternaDO.COLOR);
		strbuf.append(" VARCHAR(100),    ");
		strbuf.append(ClaseLinternaDO.NOMBRE_DE_CUERPO_LINTERNA);
		strbuf.append(" VARCHAR(100),     ");
		strbuf.append(ClaseLinternaDO.PLANETA_ID);
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

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
	    checkClass(dataObject, PersonajeDO.class, CHECK_INSERT);
	    
	    ClaseLinternaDO claseLinternaDO = (ClaseLinternaDO) dataObject;
	    claseLinternaDO.setId(getNextId());

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("INSERT INTO ");
	    strbuf.append(getTableName());
	    strbuf.append(" VALUES (");
	    strbuf.append(claseLinternaDO.getId());
	    strbuf.append(", ");
	    strbuf.append(singleQuotes(claseLinternaDO.getColor()));
	    strbuf.append(", ");
	    strbuf.append(singleQuotes(claseLinternaDO.getNombre_de_cuerpo_linterna()));
	    strbuf.append(", ");
	    Reference<PlanetaDO> ref = claseLinternaDO.getPlanetaRef();
	    ref.checkInsert();
	    strbuf.append(ref.getIdAsString());
	    strbuf.append(", ");
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
