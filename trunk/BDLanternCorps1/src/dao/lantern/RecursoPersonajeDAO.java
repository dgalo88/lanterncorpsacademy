package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoPersonajeDAO;
import lcaInterfaceDAO.IRecursoPersonajeDO;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class RecursoPersonajeDAO extends BaseDAO implements
		IRecursoPersonajeDAO {

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

		PersonajeDAO personajeDAO = new PersonajeDAO();
		personajeDAO.init(connectionBean);

		RecursoDAO recursoDAO = new RecursoDAO();
		recursoDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(RecursoPersonajeDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(RecursoPersonajeDO.CANTIDAD);
		strbuf.append(" INT ,    ");
		strbuf.append(RecursoPersonajeDO.RECURSO_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(recursoDAO.getTableName() + ", ");
		strbuf.append(RecursoPersonajeDO.PERSONAJE_ID);
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
		checkClass(dataObject, RecursoPersonajeDO.class, CHECK_DELETE);

		RecursoPersonajeDO recursoPersonajeDO = (RecursoPersonajeDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(RecursoPersonajeDO.ID);
		strbuf.append(" = ");
		strbuf.append(recursoPersonajeDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);

	}

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, RecursoPersonajeDO.class, CHECK_INSERT);

		RecursoPersonajeDO recursoPersonajeDO = (RecursoPersonajeDO) dataObject;

		recursoPersonajeDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(recursoPersonajeDO.getId());
		strbuf.append(", ");
		strbuf.append(recursoPersonajeDO.getCantidad());
		strbuf.append(", ");
		Reference<IRecursoDO> refR = recursoPersonajeDO.getRecursoRef();
		refR.checkInsert();
		strbuf.append(refR.getIdAsString());

		strbuf.append(", ");
		Reference<IPersonajeDO> refP = recursoPersonajeDO.getPersonajeRef();
		refP.checkInsert();
		strbuf.append(refP.getIdAsString());

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataObject loadById(int id) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(RecursoPersonajeDO.ID);
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
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, RecursoPersonajeDO.class, CHECK_UPDATE);

		RecursoPersonajeDO recursoPersonajeDO = (RecursoPersonajeDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(RecursoPersonajeDO.CANTIDAD);
		strbuf.append(" = ");
		strbuf.append(recursoPersonajeDO.getCantidad());

		strbuf.append(", ");

		strbuf.append(RecursoPersonajeDO.PERSONAJE_ID);
		strbuf.append(" = ");
		Reference<IPersonajeDO> refP = recursoPersonajeDO.getPersonajeRef();
		refP.checkUpdate();
		strbuf.append(refP.getIdAsString());

		strbuf.append(", ");

		strbuf.append(RecursoPersonajeDO.RECURSO_ID);
		strbuf.append(" = ");
		Reference<IRecursoDO> refR = recursoPersonajeDO.getRecursoRef();
		refR.checkUpdate();
		strbuf.append(refR.getIdAsString());

		strbuf.append(" WHERE ");
		strbuf.append(OfertaDO.ID);
		strbuf.append(" = ");
		strbuf.append(recursoPersonajeDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

	}

	@Override
	public List<IRecursoPersonajeDO> listByPersonajeId(int personajeId)
			throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(RecursoPersonajeDO.PERSONAJE_ID);
		strbuf.append(" = ");
		strbuf.append(personajeId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IRecursoPersonajeDO> ret = new ArrayList<IRecursoPersonajeDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	@Override
	public List<IRecursoPersonajeDO> listByRecursoId(int recursoId)
			throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(RecursoPersonajeDO.RECURSO_ID);
		strbuf.append(" = ");
		strbuf.append(recursoId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IRecursoPersonajeDO> ret = new ArrayList<IRecursoPersonajeDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	private IRecursoPersonajeDO resultSetToDO(ResultSet rs) throws SQLException {
		RecursoPersonajeDO ret = //
		(RecursoPersonajeDO) dtaSession.getDtaByKey( //
				RecursoPersonajeDO.class, rs.getInt(RecursoPersonajeDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new RecursoPersonajeDO();

		ret.setId/*     					*/(rs.getInt(RecursoPersonajeDO.ID));
		ret.setCantidad/*	            */(rs.getInt(RecursoPersonajeDO.CANTIDAD));

		Reference<IPersonajeDO> refP = new Reference<IPersonajeDO>();
		refP.setRefIdent(rs.getInt(RecursoPersonajeDO.PERSONAJE_ID));
		ret.setPersonajeRef(refP);

		Reference<IRecursoDO> refR = new Reference<IRecursoDO>();
		refR.setRefIdent(rs.getInt(RecursoPersonajeDO.RECURSO_ID));
		ret.setRecursoRef(refR);

		return (RecursoPersonajeDO) dtaSession.add(ret);
	}

	@Override
	public DataObject loadByRecursoId(int recurso, int personajeId)
			throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(RecursoPersonajeDO.RECURSO_ID);
		strbuf.append(" = ");
		strbuf.append(recurso);
		strbuf.append(" AND ");
		strbuf.append(RecursoPersonajeDO.PERSONAJE_ID);
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

	@Override
	public void loadPersonajeRef(IRecursoPersonajeDO recursoPersonajeDO)
			throws SQLException {

		checkClass(recursoPersonajeDO, RecursoPersonajeDO.class, CHECK_UPDATE);

		PersonajeDAO personajeDAO = new PersonajeDAO();
		personajeDAO.init(connectionBean);

		Reference<IPersonajeDO> ref = recursoPersonajeDO.getPersonajeRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		PersonajeDO personajeDO = //
		(PersonajeDO) personajeDAO.loadById(ref.getRefIdent());

		ref.setRefValue(personajeDO);
	}

	// --------------------------------------------------------------------------------

	@Override
	public void loadRecursoRef(IRecursoPersonajeDO recursoPersonajeDO)
			throws SQLException {
		checkClass(recursoPersonajeDO, RecursoPersonajeDO.class, CHECK_UPDATE);

		RecursoDAO recursoDAO = new RecursoDAO();
		recursoDAO.init(connectionBean);

		Reference<IRecursoDO> ref = recursoPersonajeDO.getRecursoRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		RecursoDO recursoDO = //
		(RecursoDO) recursoDAO.loadById(ref.getRefIdent());

		ref.setRefValue(recursoDO);
	}

}
