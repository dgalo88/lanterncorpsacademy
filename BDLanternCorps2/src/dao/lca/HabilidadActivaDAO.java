package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class HabilidadActivaDAO extends BaseDAO {

	public HabilidadActivaDAO() {
		// Emty
	}

	// --------------------------------------------------------------------------------

	@Override
	public int countAll() throws SQLException {

		StringBuffer strbuf = new StringBuffer();
		strbuf.append("SELECT COUNT(*) FROM ");
		strbuf.append(getTableName());

		System.err.println(strbuf.toString());
		ResultSet rs = connection.createStatement().executeQuery(
				strbuf.toString());
		rs.next();

		return rs.getInt("count");
	}

	// --------------------------------------------------------------------------------

	@Override
	public void createTable() throws SQLException {

		StringBuffer strbuf;

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
		HabilidadDAO habilidadDAO = new HabilidadDAO();
		habilidadDAO.init(connectionBean);

		// ----------------------------------------

		strbuf = new StringBuffer();
		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(HabilidadActivaDO.ID);
		strbuf.append(" INT PRIMARY KEY,	");
		strbuf.append(HabilidadActivaDO.NIVEL_HABILIDAD);
		strbuf.append(" INT CHECK (" + HabilidadActivaDO.NIVEL_HABILIDAD
				+ " >= 1 ) DEFAULT 1,	");
		strbuf.append(HabilidadActivaDO.PERSONAJE_ID);
		strbuf.append(" INT REFERENCES NOT NULL");
		strbuf.append(personajeDAO.getTableName());
		strbuf.append(",");
		strbuf.append(HabilidadActivaDO.HABILIDAD_ID);
		strbuf.append(" INT REFERENCES NOT NULL");
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

	// --------------------------------------------------------------------------------

	@Override
	public void delete(DataObject dataObject) throws SQLException {

		checkCache(dataObject, CHECK_DELETE);
		checkClass(dataObject, HabilidadActivaDO.class, CHECK_DELETE);

		HabilidadActivaDO habilidadActivaDO = (HabilidadActivaDO) dataObject;

		StringBuffer strbuf = new StringBuffer();
		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());
		strbuf.append(" WHERE ");
		strbuf.append(HabilidadActivaDO.ID);
		strbuf.append(" = ");
		strbuf.append(habilidadActivaDO.getId());

		System.err.println(strbuf.toString());
		connection.createStatement().execute(strbuf.toString());
		dtaSession.del(dataObject);
	}

	// --------------------------------------------------------------------------------

	@Override
	public void insert(DataObject dataObject) throws SQLException {

		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, HabilidadActivaDO.class, CHECK_INSERT);

		HabilidadActivaDO habilidadActivaDO = (HabilidadActivaDO) dataObject;
		habilidadActivaDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();
		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(habilidadActivaDO.getId());
		strbuf.append(", ");
		strbuf.append(habilidadActivaDO.getNivel_habilidad());
		strbuf.append(", ");
		Reference<PersonajeDO> ref = habilidadActivaDO.getPersonajeRef();
		ref.checkInsert();
		strbuf.append(ref.getIdAsString());
		strbuf.append(", ");
		Reference<HabilidadDO> ref1 = habilidadActivaDO.getHabilidadRef();
		ref1.checkInsert();
		strbuf.append(ref1.getIdAsString());
		strbuf.append(")");

		System.err.println(strbuf.toString());
		connection.createStatement().execute(strbuf.toString());
		dtaSession.add(dataObject);
	}

	// --------------------------------------------------------------------------------

	private int getNextId() throws SQLException {

		StringBuffer strbuf = new StringBuffer();
		strbuf.append("SELECT nextval(");
		strbuf.append(singleQuotes("seq_" + getTableName()));
		strbuf.append(")");

		System.err.println(strbuf.toString());
		ResultSet rs = connection.createStatement().executeQuery(
				strbuf.toString());

		if (!rs.next()) {
			throw new IllegalStateException("!rs.next()");
		}
		return rs.getInt("nextval");
	}

	// --------------------------------------------------------------------------------

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
		ResultSet rs = connection.createStatement().executeQuery(
				strbuf.toString());
		List<DataObject> ret = new ArrayList<DataObject>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}
		return ret;
	}

	// --------------------------------------------------------------------------------

	@Override
	public List<DataObject> listAll() throws SQLException {
		return listAll(-1, -1);
	}

	// --------------------------------------------------------------------------------

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
		ResultSet rs = connection.createStatement().executeQuery(
				strbuf.toString());

		if (rs.next()) {
			return resultSetToDO(rs);
		}
		return null;
	}

	// --------------------------------------------------------------------------------

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
		strbuf.append(" WHERE ");
		strbuf.append(HabilidadActivaDO.ID);
		strbuf.append(" = ");
		strbuf.append(habilidadActivaDO.getId());

		System.err.println(strbuf.toString());
		connection.createStatement().execute(strbuf.toString());
	}

	// --------------------------------------------------------------------------------

	public List<HabilidadActivaDO> listByHabilidadId(int HabilidadId)
			throws SQLException {

		StringBuffer strbuf = new StringBuffer();
		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());
		strbuf.append(" WHERE ");
		strbuf.append(HabilidadActivaDO.HABILIDAD_ID);
		strbuf.append(" = ");
		strbuf.append(HabilidadId);

		System.err.println(strbuf.toString());
		ResultSet rs = connection.createStatement().executeQuery(
				strbuf.toString());
		List<HabilidadActivaDO> ret = new ArrayList<HabilidadActivaDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}
		return ret;
	}

	// --------------------------------------------------------------------------------

	public List<HabilidadActivaDO> listByPersonajeId(int PersonajeId)
			throws SQLException {

		StringBuffer strbuf = new StringBuffer();
		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());
		strbuf.append(" WHERE ");
		strbuf.append(HabilidadActivaDO.PERSONAJE_ID);
		strbuf.append(" = ");
		strbuf.append(PersonajeId);

		System.err.println(strbuf.toString());
		ResultSet rs = connection.createStatement().executeQuery(
				strbuf.toString());
		List<HabilidadActivaDO> ret = new ArrayList<HabilidadActivaDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}
		return ret;
	}

	// --------------------------------------------------------------------------------

	private HabilidadActivaDO resultSetToDO(ResultSet rs) throws SQLException {
		HabilidadActivaDO ret = (HabilidadActivaDO) dtaSession.getDtaByKey( //
				HabilidadActivaDO.class, rs.getInt(HabilidadActivaDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new HabilidadActivaDO();
		ret.setId(rs.getInt(HabilidadActivaDO.ID));
		ret.setNivel_habilidad(rs.getInt(HabilidadActivaDO.NIVEL_HABILIDAD));
		Reference<PersonajeDO> ref = new Reference<PersonajeDO>();
		ref.setRefIdent(rs.getInt(HabilidadActivaDO.PERSONAJE_ID));
		ret.setPersonajeRef(ref);
		Reference<HabilidadDO> ref1 = new Reference<HabilidadDO>();
		ref1.setRefIdent(rs.getInt(HabilidadActivaDO.HABILIDAD_ID));
		ret.setHabilidadRef(ref1);

		return (HabilidadActivaDO) dtaSession.add(ret);

	}

	// --------------------------------------------------------------------------------

	public void loadPersonajeRef(HabilidadActivaDO habilidadDO)
			throws SQLException {
		if (habilidadDO == null) {
			return;
		}

		checkClass(habilidadDO, HabilidadActivaDO.class, CHECK_UPDATE);

		PersonajeDAO personajeDAO = new PersonajeDAO();
		personajeDAO.init(connectionBean);

		Reference<PersonajeDO> ref = habilidadDO.getPersonajeRef();
		if (ref.getRefIdent() == 0) {
			return;
		}

		PersonajeDO personajeDO = //
		(PersonajeDO) personajeDAO.loadById(ref.getRefIdent());

		ref.setRefValue(personajeDO);
	}

	public void loadHabilidadRef(HabilidadActivaDO habilidadActivaDO)
			throws SQLException {
		if (habilidadActivaDO == null) {
			return;
		}

		checkClass(habilidadActivaDO, HabilidadActivaDO.class, CHECK_UPDATE);

		HabilidadActivaDAO habilidaDAO = new HabilidadActivaDAO();
		habilidaDAO.init(connectionBean);

		Reference<HabilidadDO> ref = habilidadActivaDO.getHabilidadRef();
		if (ref.getRefIdent() == 0) {
			return;
		}

		HabilidadDO habilidadDO = //
		(HabilidadDO) habilidaDAO.loadById(ref.getRefIdent());

		ref.setRefValue(habilidadDO);
	}
}
