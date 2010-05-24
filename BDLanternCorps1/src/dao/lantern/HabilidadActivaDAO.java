package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IHabilidadActivaDAO;
import lcaInterfaceDAO.IHabilidadActivaDO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.IPersonajeDO;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;


public class HabilidadActivaDAO extends BaseDAO implements IHabilidadActivaDAO {

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
	    
	    PersonajeDAO personajeDAO = new PersonajeDAO();
	    personajeDAO.init(connectionBean);

	    strbuf = new StringBuffer();

	    strbuf.append("CREATE TABLE ");
	    strbuf.append(getTableName());
	    strbuf.append(" (");
	    strbuf.append(HabilidadActivaDO.ID);
	    strbuf.append(" INT PRIMARY KEY, ");
	    strbuf.append(HabilidadActivaDO.NIVEL_HABILIDAD);
	    strbuf.append(" INT,    ");
	    strbuf.append(HabilidadActivaDO.PERSONAJE_ID);
	    strbuf.append(" INT REFERENCES   ");
	    strbuf.append(personajeDAO.getTableName()+", ");
	    strbuf.append(HabilidadActivaDO.HABILIDAD_ID);
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
	    checkClass(dataObject, HabilidadDO.class, CHECK_DELETE);

	    HabilidadDO habilidadDO = (HabilidadDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("DELETE FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(HabilidadDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(habilidadDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.del(dataObject);

	}

	@Override
	public void insert(DataObject dataObject) throws SQLException {
	    checkCache(dataObject, CHECK_INSERT);
	    checkClass(dataObject, HabilidadDO.class, CHECK_INSERT);

	    HabilidadActivaDO habilidadActivaDO = (HabilidadActivaDO) dataObject;

	    habilidadActivaDO.setId(getNextId());

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("INSERT INTO ");
	    strbuf.append(getTableName());
	    strbuf.append(" VALUES (");
	    strbuf.append(habilidadActivaDO.getId());
	    strbuf.append(", ");
	    Reference<IPersonajeDO> refP = habilidadActivaDO.getPersonajeRef();
	    refP.checkInsert();
	    strbuf.append(refP.getIdAsString());
	    
	    strbuf.append(", ");	    
	    Reference<IHabilidadDO> refH = habilidadActivaDO.getHabilidadRef();
	    refH.checkInsert();
	    strbuf.append(refH.getIdAsString());
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
	    strbuf.append(HabilidadActivaDO.ID);
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

	  public void loadPersonajeRef(IHabilidadActivaDO habilidadActivaDO) throws SQLException {

	    checkClass(habilidadActivaDO, HabilidadActivaDO.class, CHECK_UPDATE);

	    PersonajeDAO personajeDAO = new PersonajeDAO();
	    personajeDAO.init(connectionBean);

	    Reference<IPersonajeDO> ref = habilidadActivaDO.getPersonajeRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	    PersonajeDO personajeDO = //
	    (PersonajeDO) personajeDAO.loadById(ref.getRefIdent());

	    ref.setRefValue(personajeDO);
	  }

		 // --------------------------------------------------------------------------------

	  public void loadHabilidadRef(IHabilidadActivaDO habilidadActivaDO) throws SQLException {

	    checkClass(habilidadActivaDO, HabilidadActivaDO.class, CHECK_UPDATE);

	    HabilidadDAO habilidadDAO = new HabilidadDAO();
	    habilidadDAO.init(connectionBean);

	    Reference<IHabilidadDO> ref = habilidadActivaDO.getHabilidadRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	    HabilidadDO habilidadDO = //
	    (HabilidadDO) habilidadDAO.loadById(ref.getRefIdent());

	    ref.setRefValue(habilidadDO);
	  }
	  
	  // --------------------------------------------------------------------------------
	  
	private IHabilidadActivaDO resultSetToDO(ResultSet rs) throws SQLException {
		HabilidadActivaDO ret = //
		(HabilidadActivaDO) dtaSession.getDtaByKey( //
				HabilidadActivaDO.class, rs.getInt(HabilidadActivaDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new HabilidadActivaDO();

		ret.setId/*     					*/(rs.getInt(HabilidadActivaDO.ID));
		ret.setNivel_habilidad/*	            */(rs.getInt(HabilidadActivaDO.NIVEL_HABILIDAD));

		Reference<IPersonajeDO> refP = new Reference<IPersonajeDO>();
		refP.setRefIdent(rs.getInt(HabilidadActivaDO.PERSONAJE_ID));
		ret.setPersonajeRef(refP);

		Reference<IHabilidadDO> refH = new Reference<IHabilidadDO>();
		refH.setRefIdent(rs.getInt(HabilidadActivaDO.HABILIDAD_ID));
		ret.setHabilidadRef(refH);

		return (HabilidadActivaDO) dtaSession.add(ret);
	}

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
	    checkClass(dataObject, HabilidadActivaDO.class, CHECK_UPDATE);

	    HabilidadActivaDO habilidadActivaDO = (HabilidadActivaDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("UPDATE ");
	    strbuf.append(getTableName());
	    strbuf.append(" SET ");

	    strbuf.append(HabilidadActivaDO.NIVEL_HABILIDAD);
	    strbuf.append(" = ");
	    strbuf.append(habilidadActivaDO.getNivel_habilidad());
	    
	    strbuf.append(", ");
	    	    
	    strbuf.append(HabilidadActivaDO.PERSONAJE_ID);
	    strbuf.append(" = ");
	    Reference<IPersonajeDO> refP = habilidadActivaDO.getPersonajeRef();
	    refP.checkUpdate();
	    strbuf.append(refP.getIdAsString());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(HabilidadActivaDO.HABILIDAD_ID);
	    strbuf.append(" = ");
	    Reference<IHabilidadDO> refH = habilidadActivaDO.getHabilidadRef();
	    refH.checkUpdate();
	    strbuf.append(refH.getIdAsString());
	    
	    strbuf.append(" WHERE ");
	    strbuf.append(HabilidadDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(habilidadActivaDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	}

	public List<IHabilidadActivaDO> listByHabilidadId(int habilidadId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(HabilidadActivaDO.HABILIDAD_ID);
		strbuf.append(" = ");
		strbuf.append(habilidadId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IHabilidadActivaDO> ret = new ArrayList<IHabilidadActivaDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}
	
	public List<IHabilidadActivaDO> listByPersonajeId(int personajeId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(HabilidadActivaDO.PERSONAJE_ID);
		strbuf.append(" = ");
		strbuf.append(personajeId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IHabilidadActivaDO> ret = new ArrayList<IHabilidadActivaDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

}
