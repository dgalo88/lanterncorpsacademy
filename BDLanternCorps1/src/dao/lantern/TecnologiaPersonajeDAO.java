package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.ITecnologiaPersonajeDAO;
import lcaInterfaceDAO.ITecnologiaPersonajeDO;

public class TecnologiaPersonajeDAO extends BaseDAO implements ITecnologiaPersonajeDAO{
	
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

	    TecnologiaDAO tecnologiaDAO = new TecnologiaDAO();
	    tecnologiaDAO.init(connectionBean);
	    
	    PersonajeDAO personajeDAO = new PersonajeDAO();
	    personajeDAO.init(connectionBean);

	    strbuf = new StringBuffer();

	    strbuf.append("CREATE TABLE ");
	    strbuf.append(getTableName());
	    strbuf.append(" (");
	    strbuf.append(TecnologiaPersonajeDO.ID);
	    strbuf.append(" INT PRIMARY KEY, ");
	    strbuf.append(TecnologiaPersonajeDO.PERSONAJE_ID);
	    strbuf.append(" INT REFERENCES   ");
	    strbuf.append(personajeDAO.getTableName()+", ");
	    strbuf.append(TecnologiaPersonajeDO.TECNOLOGIA_ID);
	    strbuf.append(" INT REFERENCES   ");
	    strbuf.append(tecnologiaDAO.getTableName());
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
	    checkClass(dataObject, TecnologiaPersonajeDO.class, CHECK_DELETE);

	    PersonajeDO personajeDO = (PersonajeDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("DELETE FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(PersonajeDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(personajeDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.del(dataObject);

	}

	@Override
	public void insert(DataObject dataObject) throws SQLException {
	    checkCache(dataObject, CHECK_INSERT);
	    checkClass(dataObject, TecnologiaPersonajeDO.class, CHECK_INSERT);

	    TecnologiaPersonajeDO tecnologiaPersonajeDO = (TecnologiaPersonajeDO) dataObject;

	    tecnologiaPersonajeDO.setId(getNextId());

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("INSERT INTO ");
	    strbuf.append(getTableName());
	    strbuf.append(" VALUES (");
	    strbuf.append(tecnologiaPersonajeDO.getId());
	    strbuf.append(", ");
	    Reference<IPersonajeDO> refP=tecnologiaPersonajeDO.getPersonajeRef(); 
	    refP.checkInsert();
	    strbuf.append(refP.getIdAsString());
	    
	    strbuf.append(", ");
	    Reference<ITecnologiaDO> refTec = tecnologiaPersonajeDO.getTecnologiaRef();
	    refTec.checkInsert();
	    strbuf.append(refTec.getIdAsString());
	    
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

	@Override
	public List<DataObject> listAll() throws SQLException {

		return null;
	}

	@Override
	public DataObject loadById(int id) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(TecnologiaPersonajeDO.ID);
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
	public DataObject loadByTecnologiaId(int tecid, int personajeId) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(TecnologiaPersonajeDO.TECNOLOGIA_ID);
	    strbuf.append(" = ");
	    strbuf.append(tecid);
	    strbuf.append(" AND ");
	    strbuf.append(TecnologiaPersonajeDO.PERSONAJE_ID);
	    strbuf.append(" = ");
	    strbuf.append(personajeId);

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    if (rs.next()) {
	      return resultSetToDO(rs);
	    }

	    return null;
	}

	 // --------------------------------------------------------------------------------
	
	  public void loadTecnologiaRef(ITecnologiaPersonajeDO tecnologiaPersonajeDO) throws SQLException {

	    checkClass(tecnologiaPersonajeDO, TecnologiaPersonajeDO.class, CHECK_UPDATE);

	    TecnologiaDAO tecnologiaDAO = new TecnologiaDAO();
	    tecnologiaDAO.init(connectionBean);

	    Reference<ITecnologiaDO> ref = tecnologiaPersonajeDO.getTecnologiaRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	    TecnologiaDO tecnologiaDO = //
	    (TecnologiaDO) tecnologiaDAO.loadById(ref.getRefIdent());

	    ref.setRefValue(tecnologiaDO);
	  }

		 // --------------------------------------------------------------------------------

	  public void loadPersonajeRef(ITecnologiaPersonajeDO tecnologiaPersonajeDO) throws SQLException {

	    checkClass(tecnologiaPersonajeDO, TecnologiaPersonajeDO.class, CHECK_UPDATE);

	    PersonajeDAO personajeDAO = new PersonajeDAO();
	    personajeDAO.init(connectionBean);

	    Reference<IPersonajeDO> ref = tecnologiaPersonajeDO.getPersonajeRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	    PersonajeDO recursoDO = //
	    (PersonajeDO) personajeDAO. loadById(ref.getRefIdent());

	    ref.setRefValue(recursoDO);
	  }
	  
	  // --------------------------------------------------------------------------------
	  
	private ITecnologiaPersonajeDO resultSetToDO(ResultSet rs) throws SQLException {
		TecnologiaPersonajeDO ret = //
		(TecnologiaPersonajeDO) dtaSession.getDtaByKey( //
				TecnologiaPersonajeDO.class, rs.getInt(TecnologiaPersonajeDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new TecnologiaPersonajeDO();

		ret.setId/*     					*/(rs.getInt(TecnologiaPersonajeDO.ID));		

		Reference<ITecnologiaDO> refTec = new Reference<ITecnologiaDO>();
		refTec.setRefIdent(rs.getInt(TecnologiaPersonajeDO.TECNOLOGIA_ID));
		ret.setTecnologiaRef(refTec);

		Reference<IPersonajeDO> refPer = new Reference<IPersonajeDO>();
		refPer.setRefIdent(rs.getInt(TecnologiaPersonajeDO.PERSONAJE_ID));
		ret.setPersonajeRef(refPer);

		return (TecnologiaPersonajeDO) dtaSession.add(ret);
	}

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
	    checkClass(dataObject, TecnologiaPersonajeDO.class, CHECK_UPDATE);

	    TecnologiaPersonajeDO tecnologiaPersonajeDO = (TecnologiaPersonajeDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("UPDATE ");
	    strbuf.append(getTableName());
	    strbuf.append(" SET ");

	    	    
	    strbuf.append(TecnologiaPersonajeDO.PERSONAJE_ID);
	    strbuf.append(" = ");
	    Reference<IPersonajeDO> refPer = tecnologiaPersonajeDO.getPersonajeRef();
	    refPer.checkUpdate();
	    strbuf.append(refPer.getIdAsString());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(TecnologiaRecursoDO.TECNOLOGIA_ID);
	    strbuf.append(" = ");
	    Reference<ITecnologiaDO> refTec = tecnologiaPersonajeDO.getTecnologiaRef();
	    refTec.checkUpdate();
	    strbuf.append(refTec.getIdAsString());
	    
	    strbuf.append(" WHERE ");
	    strbuf.append(TecnologiaDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(tecnologiaPersonajeDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	}

	public List<ITecnologiaPersonajeDO> listByTecnologiaId(int tecnologiaId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(TecnologiaPersonajeDO.TECNOLOGIA_ID);
		strbuf.append(" = ");
		strbuf.append(tecnologiaId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<ITecnologiaPersonajeDO> ret = new ArrayList<ITecnologiaPersonajeDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}
	
	public List<ITecnologiaPersonajeDO> listByPersonajeId(int PersonajeId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(TecnologiaPersonajeDO.PERSONAJE_ID);
		strbuf.append(" = ");
		strbuf.append(PersonajeId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<ITecnologiaPersonajeDO> ret = new ArrayList<ITecnologiaPersonajeDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}
}
