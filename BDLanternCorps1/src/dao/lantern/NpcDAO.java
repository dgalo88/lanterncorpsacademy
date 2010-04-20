package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;

public class NpcDAO extends BaseDAO {

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

	    strbuf = new StringBuffer();

	    strbuf.append("CREATE TABLE ");
	    strbuf.append(getTableName());
	    strbuf.append(" (");
	    strbuf.append(NpcDO.ID);
	    strbuf.append(" INT PRIMARY KEY, ");
	    strbuf.append(NpcDO.NOMBRE); 
	    strbuf.append(" VARCHAR(100),    ");
	    strbuf.append(NpcDO.NIVEL);
	    strbuf.append(" INT,    ");
	    strbuf.append(NpcDO.SALUD);
	    strbuf.append(" INT,    ");
	    strbuf.append(NpcDO.DANO);
	    strbuf.append(" INT,    ");
	    strbuf.append(NpcDO.COLOR);
	    strbuf.append(" INT    ");
	    
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
	    checkClass(dataObject, HabilidadDO.class, CHECK_DELETE);

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
	    strbuf.append(npcDO.getId()); // INSTANCIA
	    strbuf.append(", ");
	    strbuf.append(singleQuotes(npcDO.getNombre()));
	    strbuf.append(", ");
	    strbuf.append(npcDO.getNivel());
	    strbuf.append(", ");
	    strbuf.append(npcDO.getSalud());
	    strbuf.append(", ");
	    strbuf.append(npcDO.getDano());
	    strbuf.append(", ");
	    strbuf.append(npcDO.getColor());
	    
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

	private NpcDO resultSetToDO(ResultSet rs) throws SQLException {
	  	  NpcDO ret = //
	  	      (NpcDO) dtaSession.getDtaByKey( //
	  	      		NpcDO.class, rs.getInt(NpcDO.ID));

	  	      if (ret != null) {
	  	        return ret;
	  	      }

	  	      ret = new NpcDO();

	  	      ret.setId/*     */(rs.getInt(HabilidadDO.ID));
	  	      ret.setNombre/*   */(rs.getString(HabilidadDO.NOMBRE));
	  	      ret.setNivel((rs.getInt(NpcDO.NIVEL)));
	  	      ret.setSalud((rs.getInt(NpcDO.SALUD)));
	  	      ret.setDano((rs.getInt(NpcDO.DANO)));
	  	      ret.setColor((rs.getString(NpcDO.COLOR)));
	  	      
	  	      return (NpcDO) dtaSession.add(ret);	
	}

	@Override
	public List<DataObject> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataObject loadById(int id) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(NpcDO.ID);
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
	    checkClass(dataObject, HabilidadDO.class, CHECK_UPDATE);

	    NpcDO npcDO = (NpcDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("UPDATE ");
	    strbuf.append(getTableName());
	    strbuf.append(" SET ");

	    strbuf.append(NpcDO.NOMBRE);
	    strbuf.append(" = ");
	    strbuf.append(singleQuotes(npcDO.getNombre()));

	    strbuf.append(", ");

	    strbuf.append(NpcDO.NIVEL);
	    strbuf.append(" = ");
	    strbuf.append(npcDO.getNivel());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(NpcDO.SALUD);
	    strbuf.append(" = ");
	    strbuf.append(npcDO.getSalud());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(NpcDO.DANO);
	    strbuf.append(" = ");
	    strbuf.append(npcDO.getDano());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(NpcDO.COLOR);
	    strbuf.append(" = ");
	    strbuf.append(singleQuotes(npcDO.getColor()));
	    
	    strbuf.append(", ");
	    
	    strbuf.append(" WHERE ");
	    strbuf.append(NpcDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(npcDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	}

}
