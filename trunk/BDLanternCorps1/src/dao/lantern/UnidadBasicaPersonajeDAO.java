package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUnidadBasicaDO;
import lcaInterfaceDAO.IUnidadBasicaPersonajeDAO;
import lcaInterfaceDAO.IUnidadBasicaPersonajeDO;

public class UnidadBasicaPersonajeDAO extends BaseDAO implements IUnidadBasicaPersonajeDAO {

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

	    UnidadBasicaDAO unidadBasicaDAO = new UnidadBasicaDAO();
	    unidadBasicaDAO.init(connectionBean);
	    
	    PersonajeDAO personajeDAO = new PersonajeDAO();
	    personajeDAO.init(connectionBean);

	    strbuf = new StringBuffer();

	    strbuf.append("CREATE TABLE ");
	    strbuf.append(getTableName());
	    strbuf.append(" (");
	    strbuf.append(UnidadBasicaPersonajeDO.ID);
	    strbuf.append(" INT PRIMARY KEY, ");
	    strbuf.append(UnidadBasicaPersonajeDO.CANTIDAD);
	    strbuf.append(" INT DEFAULT 1,    ");
	    strbuf.append(UnidadBasicaPersonajeDO.UNIDAD_BASICA_ID);
	    strbuf.append(" INT REFERENCES   ");
	    strbuf.append(unidadBasicaDAO.getTableName()+", ");
	    strbuf.append(UnidadBasicaPersonajeDO.PERSONAJE_ID);
	    strbuf.append(" INT REFERENCES   ");
	    strbuf.append(personajeDAO.getTableName());
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
	    checkClass(dataObject, UnidadBasicaPersonajeDO.class, CHECK_DELETE);

	    UnidadBasicaDO unidadBasicaDO = (UnidadBasicaDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("DELETE FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(UnidadBasicaDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(unidadBasicaDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.del(dataObject);


	}

	@Override
	public void insert(DataObject dataObject) throws SQLException {
	
		checkCache(dataObject, CHECK_INSERT);
	    checkClass(dataObject, UnidadBasicaPersonajeDO.class, CHECK_INSERT);

	    UnidadBasicaPersonajeDO unidadBasicaPersonajeDO = (UnidadBasicaPersonajeDO) dataObject;

	    unidadBasicaPersonajeDO.setId(getNextId());

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("INSERT INTO ");
	    strbuf.append(getTableName());
	    strbuf.append(" VALUES (");
	    strbuf.append(unidadBasicaPersonajeDO.getId());
	    strbuf.append(", ");
	    strbuf.append(unidadBasicaPersonajeDO.getCantidad());
	    strbuf.append(", ");
	    Reference<IPersonajeDO> refP = unidadBasicaPersonajeDO.getPersonajeRef();
	    refP.checkInsert();
	    strbuf.append(refP.getIdAsString());
	    
	    strbuf.append(", ");	    
	    Reference<IUnidadBasicaDO> refUniBas = unidadBasicaPersonajeDO.getUnidadBasicaRef();
	    refUniBas.checkInsert();
	    strbuf.append(refUniBas.getIdAsString());

	    
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
	    strbuf.append(UnidadBasicaPersonajeDO.ID);
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

	
	//------------------------------------------------------------------------------------------------------------------------
	private IUnidadBasicaPersonajeDO resultSetToDO(ResultSet rs) throws SQLException {
		UnidadBasicaPersonajeDO ret = //
		(UnidadBasicaPersonajeDO) dtaSession.getDtaByKey( //
				UnidadBasicaPersonajeDO.class, rs.getInt(UnidadBasicaPersonajeDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new UnidadBasicaPersonajeDO();

		ret.setId/*     					*/(rs.getInt(UnidadBasicaPersonajeDO.ID));
		ret.setCantidad/*	            */(rs.getInt(UnidadBasicaPersonajeDO.CANTIDAD));

		Reference<IPersonajeDO> refP = new Reference<IPersonajeDO>();
		refP.setRefIdent(rs.getInt(UnidadBasicaPersonajeDO.PERSONAJE_ID));
		ret.setPersonajeRef(refP);

		Reference<IUnidadBasicaDO> refUniBas = new Reference<IUnidadBasicaDO>();
		refUniBas.setRefIdent(rs.getInt(UnidadBasicaPersonajeDO.UNIDAD_BASICA_ID));
		ret.setUnidadBasicaRef(refUniBas);

		return (UnidadBasicaPersonajeDO) dtaSession.add(ret);
	}
	//-------------------------------------------------------------------------------------------------------------------------
	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
	    checkClass(dataObject, UnidadBasicaPersonajeDO.class, CHECK_UPDATE);

	    UnidadBasicaPersonajeDO unidadBasicaPersonajeDO = (UnidadBasicaPersonajeDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("UPDATE ");
	    strbuf.append(getTableName());
	    strbuf.append(" SET ");

	    strbuf.append(UnidadBasicaPersonajeDO.CANTIDAD);
	    strbuf.append(" = ");
	    strbuf.append(unidadBasicaPersonajeDO.getCantidad());
	    
	    strbuf.append(", ");
	    	    
	    strbuf.append(UnidadBasicaPersonajeDO.PERSONAJE_ID);
	    strbuf.append(" = ");
	    Reference<IPersonajeDO> refP = unidadBasicaPersonajeDO.getPersonajeRef();
	    refP.checkUpdate();
	    strbuf.append(refP.getIdAsString());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(UnidadBasicaPersonajeDO.UNIDAD_BASICA_ID);
	    strbuf.append(" = ");
	    Reference<IUnidadBasicaDO> refUnidBas = unidadBasicaPersonajeDO.getUnidadBasicaRef();
	    refUnidBas.checkUpdate();
	    strbuf.append(refUnidBas.getIdAsString());
	    
	    strbuf.append(" WHERE ");
	    strbuf.append(UnidadBasicaDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(unidadBasicaPersonajeDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	}
	//--------------------------------------------------------------------------------------------------------------------------
	public List<IUnidadBasicaPersonajeDO> listByPersonajeId(int personajeId) throws SQLException {
		
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(UnidadBasicaPersonajeDO.PERSONAJE_ID);
		strbuf.append(" = ");
		strbuf.append(personajeId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IUnidadBasicaPersonajeDO> ret = new ArrayList<IUnidadBasicaPersonajeDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}
	

	public List<IUnidadBasicaPersonajeDO> listByUnidadBasicaId(int unidadBasicaId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(UnidadBasicaPersonajeDO.UNIDAD_BASICA_ID);
		strbuf.append(" = ");
		strbuf.append(unidadBasicaId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IUnidadBasicaPersonajeDO> ret = new ArrayList<IUnidadBasicaPersonajeDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	@Override
	public void loadPersonajeRef(IUnidadBasicaPersonajeDO unidadBasicaPersonajeDO)
			throws SQLException {
		checkClass(unidadBasicaPersonajeDO, UnidadBasicaPersonajeDO.class, CHECK_UPDATE);

	    PersonajeDAO personajeDAO = new PersonajeDAO();
	    personajeDAO.init(connectionBean);

	    Reference<IPersonajeDO> ref = unidadBasicaPersonajeDO.getPersonajeRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	    PersonajeDO personajeDO = //
	    (PersonajeDO) personajeDAO.loadById(ref.getRefIdent());

	    ref.setRefValue(personajeDO);
	}

	@Override
	public void loadUnidadBasicaRef(IUnidadBasicaPersonajeDO unidadBasicaPersonajeDO)
			throws SQLException {
		
		checkClass(unidadBasicaPersonajeDO, UnidadBasicaPersonajeDO.class, CHECK_UPDATE);

	    UnidadBasicaDAO unidadBasicaDAO = new UnidadBasicaDAO();
	    unidadBasicaDAO.init(connectionBean);

	    Reference<IUnidadBasicaDO> ref = unidadBasicaPersonajeDO.getUnidadBasicaRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	    UnidadBasicaDO unidadBasicaDO = //
	    (UnidadBasicaDO) unidadBasicaDAO.loadById(ref.getRefIdent());

	    ref.setRefValue(unidadBasicaDO);
		
		
	}
}
