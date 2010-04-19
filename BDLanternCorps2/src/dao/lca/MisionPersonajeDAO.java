package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class MisionPersonajeDAO extends BaseDAO {

	public MisionPersonajeDAO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

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

		MisionDAO misionDAO = new MisionDAO();
		misionDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(MisionPersonajeDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(MisionPersonajeDO.PERSONAJE_ID);
		strbuf.append(" INT  REFERENCES    ");
		strbuf.append(personajeDAO.getTableName());
		strbuf.append(",    ");
		strbuf.append(MisionPersonajeDO.MISION_ID);
		strbuf.append(" INT  REFERENCES    ");
		strbuf.append(misionDAO.getTableName());
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
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, MisionPersonajeDO.class, CHECK_INSERT);

		MisionPersonajeDO misionPersonajeDO = (MisionPersonajeDO) dataObject;

		misionPersonajeDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(misionPersonajeDO.getId());
		strbuf.append(", ");
		strbuf.append(misionPersonajeDO.getPersonajeRef().getRefIdent());
		strbuf.append(", ");
		strbuf.append(misionPersonajeDO.getMisionRef().getRefIdent());
		strbuf.append(")");

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.add(dataObject);
	}

	// --------------------------------------------------------------------------------

	@Override
	public void update(DataObject dataObject) throws SQLException {
		//empty
	}

	// --------------------------------------------------------------------------------

	@Override
	public void delete(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_DELETE);
		checkClass(dataObject, MisionPersonajeDO.class, CHECK_DELETE);

		MisionPersonajeDO misionPersonajeDO = (MisionPersonajeDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(MisionPersonajeDO.ID);
		strbuf.append(" = ");
		strbuf.append(misionPersonajeDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);
	}

	// --------------------------------------------------------------------------------

	@Override
	public DataObject loadById(int id) throws SQLException {
		MisionPersonajeDO mp;

		mp = (MisionPersonajeDO) dtaSession.getDtaByKey( //
				MisionPersonajeDO.class, id);

		if (mp != null) {
			return mp;
		} else {
			StringBuffer strbuf = new StringBuffer();

			strbuf.append("SELECT * FROM ");
			strbuf.append(getTableName());

			strbuf.append(" WHERE ");
			strbuf.append(MisionPersonajeDO.ID);
			strbuf.append(" = ");
			strbuf.append(id);

			System.err.println(strbuf.toString());

			ResultSet rs = //
			connection.createStatement().executeQuery(strbuf.toString());

			if (rs.next()) {
				mp = resultSetToDO(rs);
				return (MisionPersonajeDO) dtaSession.add(mp);
			}

			return null;
		}
	}

	// --------------------------------------------------------------------------------

	@Override
	public List<DataObject> listAll(int lim, int off) throws SQLException {// NECESARIA??

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
		MisionPersonajeDO mp;

		while (rs.next()) {

			mp = (MisionPersonajeDO) dtaSession.getDtaByKey( //
					MisionPersonajeDO.class, rs.getInt(MisionPersonajeDO.ID));

			if (mp == null) {
				mp = (MisionPersonajeDO) dtaSession.add(resultSetToDO(rs));
			}

			ret.add(mp);
		}

		return ret;
	}

	// --------------------------------------------------------------------------------

	@Override
	public List<DataObject> listAll() throws SQLException {// NECESARIA??
		return listAll(-1, -1);
	}

	// --------------------------------------------------------------------------------

	@Override
	public int countAll() throws SQLException {// NECESARIA??
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT COUNT(*) FROM ");
		strbuf.append(getTableName());

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		rs.next();

		return rs.getInt("count");
	}

	// --------------------------------------------------------------------------------

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

	// --------------------------------------------------------------------------------

	private MisionPersonajeDO resultSetToDO(ResultSet rs) throws SQLException {
		MisionPersonajeDO ret = new MisionPersonajeDO();

		ret.setId(rs.getInt(MisionPersonajeDO.ID));

		Reference<PersonajeDO> p = new Reference<PersonajeDO>();
		p.setRefIdent(rs.getInt(MisionPersonajeDO.PERSONAJE_ID));
		ret.setPersonajeRef(p);

		Reference<MisionDO> m = new Reference<MisionDO>();
		m.setRefIdent(rs.getInt(MisionPersonajeDO.MISION_ID));
		ret.setMisionRef(m);

		return ret;
	}

	// --------------------------------------------------------------------------------

	public List<MisionPersonajeDO> listByIdMisionId(int misionId)
			throws SQLException {

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(MisionPersonajeDO.MISION_ID);
		strbuf.append(" = ");
		strbuf.append(misionId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<MisionPersonajeDO> ret = new ArrayList<MisionPersonajeDO>();
		MisionPersonajeDO mp;

		while (rs.next()) {
			mp = (MisionPersonajeDO) dtaSession.getDtaByKey( //
					MisionPersonajeDO.class, rs.getInt(MisionPersonajeDO.ID));

			if (mp == null) {
				mp = (MisionPersonajeDO) dtaSession.add(resultSetToDO(rs));
			}

			ret.add(mp);
		}

		return ret;
	}

	// --------------------------------------------------------------------------------

	public List<MisionPersonajeDO> listByIdPersonajeId(int personajeId)
			throws SQLException {

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(MisionPersonajeDO.PERSONAJE_ID);
		strbuf.append(" = ");
		strbuf.append(personajeId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<MisionPersonajeDO> ret = new ArrayList<MisionPersonajeDO>();
		MisionPersonajeDO mp;

		while (rs.next()) {
			mp = (MisionPersonajeDO) dtaSession.getDtaByKey( //
					MisionPersonajeDO.class, rs.getInt(MisionPersonajeDO.ID));

			if (mp == null) {
				mp = (MisionPersonajeDO) dtaSession.add(resultSetToDO(rs));
			}

			ret.add(mp);
		}

		return ret;
	}
	
	// --------------------------------------------------------------------------------

	public void loadPersonajeRef(MisionPersonajeDO misionpersonajeDO) throws SQLException {

		checkClass(misionpersonajeDO, MisionPersonajeDO.class, CHECK_UPDATE);

		PersonajeDAO personajeDAO = new PersonajeDAO();
		personajeDAO.init(connectionBean);

		Reference<PersonajeDO> ref = misionpersonajeDO.getPersonajeRef();
		if (ref.getRefIdent() == 0) {
			return;
		}

		PersonajeDO personajeDO = //
		(PersonajeDO) personajeDAO.loadById(ref.getRefIdent());

		ref.setRefValue(personajeDO);
	}
	
	// --------------------------------------------------------------------------------

	public void loadMisionRef(MisionPersonajeDO misionpersonajeDO) throws SQLException {

		checkClass(misionpersonajeDO, MisionPersonajeDO.class, CHECK_UPDATE);

		MisionDAO misionDAO = new MisionDAO();
		misionDAO.init(connectionBean);

		Reference<MisionDO> ref = misionpersonajeDO.getMisionRef();
		if (ref.getRefIdent() == 0) {
			return;
		}

		MisionDO misionDO = //
		(MisionDO) misionDAO.loadById(ref.getRefIdent());

		ref.setRefValue(misionDO);
	}
}
