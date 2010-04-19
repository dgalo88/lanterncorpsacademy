package dao.lca;

import java.sql.SQLException;
import java.util.List;
import dao.api.BaseDAO;
import dao.api.DataObject;



public class HabilidadDAO extends BaseDAO{

	public HabilidadDAO(){
		//Empty
	}
	
    // --------------------------------------------------------------------------------
	
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

	    strbuf = new StringBuffer();
	    strbuf.append("CREATE TABLE ");
	    strbuf.append(getTableName());
	    strbuf.append(" (");
	    strbuf.append(HabilidadDO.ID);
	    strbuf.append(" INT PRIMARY KEY,	");
	    strbuf.append(HabilidadDO.NOMBRE);
	    strbuf.append(" VARCHAR(20), UNIQUE,	");
	    strbuf.append(HabilidadDO.COSTO_DE_APRENDIZAJE);
	    strbuf.append(" INT,	");
	    strbuf.append(HabilidadDO.TIPO);
	    strbuf.append(" INT");
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
	public void delete(DataObject dataObject) throws SQLException {
		
	}

    // --------------------------------------------------------------------------------
	
	private int getNextId() {
		// TODO Auto-generated method stub
		return 0;
	}

    // --------------------------------------------------------------------------------

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
	    checkClass(dataObject, HabilidadDO.class, CHECK_INSERT);
	    
	    HabilidadDO habilidadDO = (HabilidadDO) dataObject;
	    habilidadDO.setId(getNextId());

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("INSERT INTO ");
	    strbuf.append(getTableName());
	    strbuf.append(" VALUES (");
	    strbuf.append(habilidadDO.getId());
	    strbuf.append(", ");
	    strbuf.append(singleQuotes(habilidadDO.getNombre()));
	    strbuf.append(", ");
	    strbuf.append(habilidadDO.getCosto_de_aprendizaje());
	    strbuf.append(", ");
	    strbuf.append(habilidadDO.getTipo());

	    strbuf.append(")");
	    System.err.println(strbuf.toString());
	    connection.createStatement().execute(strbuf.toString());
	    dtaSession.add(dataObject);
	}

    // --------------------------------------------------------------------------------

	@Override
	public List<DataObject> listAll(int lim, int off) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

    // --------------------------------------------------------------------------------

	@Override
	public List<DataObject> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

    // --------------------------------------------------------------------------------

	@Override
	public int countAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

    // --------------------------------------------------------------------------------

	@Override
	public DataObject loadById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

    // --------------------------------------------------------------------------------

	@Override
	public void update(DataObject bean) throws SQLException {
		// TODO Auto-generated method stub
		
	}


}
