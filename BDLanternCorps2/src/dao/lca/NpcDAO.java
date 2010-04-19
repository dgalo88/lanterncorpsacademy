package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;

public class NpcDAO extends BaseDAO{

	public NpcDAO(){
		//Empty
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

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(NpcDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(NpcDO.NOMBRE);
		strbuf.append(" VARCHAR(100),    ");
		strbuf.append(NpcDO.NIVEL);
		strbuf.append(" INT,     ");
		strbuf.append(NpcDO.SALUD);
		strbuf.append(" INT, CHECK (NpcDO.SALUD >= 0)    ");
		strbuf.append(NpcDO.DANO);
		strbuf.append(" INT,     ");
		strbuf.append(NpcDO.COLOR);
		strbuf.append(" VARCHAR(100)     ");
		strbuf.append(")");

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

	}

	// --------------------------------------------------------------------------------

		

	@Override
	public void delete(DataObject dataObject) throws SQLException {
	    checkCache(dataObject, CHECK_DELETE);
	    checkClass(dataObject, PlanetaDO.class, CHECK_DELETE);

	    NpcDO npcDO = (NpcDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("DELETE FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(NpcDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(npcDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.del(dataObject);
		
		
	}

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
	    checkClass(dataObject, NpcDO.class, CHECK_INSERT);
	    
	    NpcDO npcDO = (NpcDO) dataObject;
	    npcDO.setId(getNextId());

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("INSERT INTO ");
	    strbuf.append(getTableName());
	    strbuf.append(" VALUES (");
	    strbuf.append(npcDO.getId());
	    strbuf.append(", ");
	    strbuf.append(singleQuotes(npcDO.getNombre()));
	    strbuf.append(", ");
	    strbuf.append(npcDO.getNivel());
	    strbuf.append(", ");
	    strbuf.append(npcDO.getSalud());
	    strbuf.append(", ");
	    strbuf.append(npcDO.getDano());
	    strbuf.append(", ");
	    strbuf.append(singleQuotes(npcDO.getColor()));
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
