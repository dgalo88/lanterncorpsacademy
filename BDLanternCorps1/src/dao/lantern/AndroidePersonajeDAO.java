package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

import lcaInterfaceDAO.IAndroideDO;
import lcaInterfaceDAO.IAndroidePersonajeDAO;
import lcaInterfaceDAO.IAndroidePersonajeDO;
import lcaInterfaceDAO.IPersonajeDO;


public class AndroidePersonajeDAO extends BaseDAO implements IAndroidePersonajeDAO {
	
	public AndroidePersonajeDAO() {
		// TODO Auto-generated constructor stub
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

		AndroideDAO androideDAO = new AndroideDAO();
		androideDAO.init(connectionBean);

		PersonajeDAO personajeDAO = new PersonajeDAO();
		personajeDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(AndroidePersonajeDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(AndroidePersonajeDO.VIDA_ACTUAL);
		strbuf.append(" INT,    ");
		strbuf.append(AndroidePersonajeDO.VIDA_MAXIMA);
		strbuf.append(" INT,    ");
		strbuf.append(AndroidePersonajeDO.PERSONAJE_ID);
		strbuf.append(" INT REFERENCES    ");
		strbuf.append(personajeDAO.getTableName());
		strbuf.append(",");
		strbuf.append(AndroidePersonajeDO.ANDROIDE_ID);
		strbuf.append(" INT REFERENCES    ");
		strbuf.append(androideDAO.getTableName());
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
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, AndroidePersonajeDO.class, CHECK_INSERT);

		AndroidePersonajeDO androidePersonaje = (AndroidePersonajeDO) dataObject;

		androidePersonaje.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(androidePersonaje.getId());
		strbuf.append(", ");
		strbuf.append(androidePersonaje.getVidaActual());
		strbuf.append(", ");
		strbuf.append(androidePersonaje.getVidaMaxima());
		strbuf.append(", ");
		Reference<IPersonajeDO> refPer = androidePersonaje.getPersonajeRef();
		refPer.checkInsert();
		strbuf.append(refPer.getIdAsString());
		strbuf.append(", ");
		Reference<IAndroideDO> refAnd = androidePersonaje.getAndroideRef();
		refAnd.checkInsert();
		strbuf.append(refAnd.getIdAsString());
		strbuf.append(")");

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.add(dataObject);

	}

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, AndroidePersonajeDO.class, CHECK_UPDATE);

		AndroidePersonajeDO androidePersonaje = (AndroidePersonajeDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");
		strbuf.append(AndroidePersonajeDO.VIDA_ACTUAL);
		strbuf.append(" = ");
		strbuf.append(androidePersonaje.getVidaActual());
		strbuf.append(", ");

		strbuf.append(AndroidePersonajeDO.VIDA_MAXIMA);
		strbuf.append(" = ");
		strbuf.append(androidePersonaje.getVidaMaxima());
		strbuf.append(", ");
		
		strbuf.append(AndroidePersonajeDO.PERSONAJE_ID);
		strbuf.append(" = ");
		Reference<IPersonajeDO> refPer = androidePersonaje.getPersonajeRef();
		refPer.checkUpdate();
		strbuf.append(refPer.getIdAsString());

		strbuf.append(", ");

		strbuf.append(AndroidePersonajeDO.ANDROIDE_ID);
		strbuf.append(" = ");
		Reference<IAndroideDO> refAnd = androidePersonaje.getAndroideRef();
		refAnd.checkUpdate();
		strbuf.append(refAnd.getIdAsString());

		strbuf.append(" WHERE ");
		strbuf.append(AndroidePersonajeDO.ID);
		strbuf.append(" = ");
		strbuf.append(androidePersonaje.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

	}

	@Override
	public void delete(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_DELETE);
		checkClass(dataObject, PersonajeDO.class, CHECK_DELETE);

		AndroidePersonajeDO androidePersonajeDO = (AndroidePersonajeDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(AndroidePersonajeDO.ID);
		strbuf.append(" = ");
		strbuf.append(androidePersonajeDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);

	}

	@Override
	public DataObject loadById(int id) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(AndroidePersonajeDO.ID);
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

	private AndroidePersonajeDO resultSetToDO(ResultSet rs) throws SQLException {
		AndroidePersonajeDO ret = //
		(AndroidePersonajeDO) dtaSession.getDtaByKey( //
				AndroidePersonajeDO.class, rs.getInt(AndroidePersonajeDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new AndroidePersonajeDO();

		ret.setId/*     				*/(rs.getInt(AndroidePersonajeDO.ID));
		ret.setVidaActual/*	            */(rs.getInt(AndroidePersonajeDO.VIDA_ACTUAL));
		ret.setVidaActual/*	            */(rs.getInt(AndroidePersonajeDO.VIDA_MAXIMA));

		Reference<IPersonajeDO> refPer = new Reference<IPersonajeDO>();
		refPer.setRefIdent(rs.getInt(AndroidePersonajeDO.PERSONAJE_ID));
		ret.setPersonajeRef(refPer);

		Reference<IAndroideDO> refAnd = new Reference<IAndroideDO>();
		refAnd.setRefIdent(rs.getInt(AndroidePersonajeDO.ANDROIDE_ID));
		ret.setAndroideRef(refAnd);

		return (AndroidePersonajeDO) dtaSession.add(ret);
	}

	@Override
	public List<DataObject> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IAndroidePersonajeDO> listByPersonajeId(int perId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(AndroidePersonajeDO.PERSONAJE_ID);
		strbuf.append(" = ");
		strbuf.append(perId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IAndroidePersonajeDO> ret = new ArrayList<IAndroidePersonajeDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	public List<IAndroidePersonajeDO> listByAndroideId(int AndroideId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(AndroidePersonajeDO.ANDROIDE_ID);
		strbuf.append(" = ");
		strbuf.append(AndroideId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IAndroidePersonajeDO> ret = new ArrayList<IAndroidePersonajeDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}
	//----------------------------------------------------------------------------------------------

	@Override
	public void loadAndroideRef(IAndroidePersonajeDO androidePersonajeDO) throws SQLException {
		checkClass(androidePersonajeDO, AndroidePersonajeDO.class, CHECK_UPDATE);
		AndroideDAO androideDAO = new AndroideDAO();
		androideDAO.init(connectionBean);
		Reference<IAndroideDO> ref = androidePersonajeDO.getAndroideRef();
		if (ref.getRefIdent() == 0) {
			return;
		}
		AndroideDO androideDO = //
		(AndroideDO) androideDAO.loadById(ref.getRefIdent());
		ref.setRefValue(androideDO);
		
	}

	@Override
	public void loadPersonajeRef(IAndroidePersonajeDO androidePersonajeDO) throws SQLException {
		checkClass(androidePersonajeDO, AndroidePersonajeDO.class, CHECK_UPDATE);
		PersonajeDAO personajeDAO = new PersonajeDAO();
		personajeDAO.init(connectionBean);
		Reference<IPersonajeDO> ref = androidePersonajeDO.getPersonajeRef();
		if (ref.getRefIdent() == 0) {
			return;
		}
		PersonajeDO personajeDO = //
		(PersonajeDO) personajeDAO.loadById(ref.getRefIdent());
		ref.setRefValue(personajeDO);
	}

}
