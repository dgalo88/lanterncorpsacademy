package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IOfertaDO;
import lcaInterfaceDAO.IOfertaPersonajeDAO;
import lcaInterfaceDAO.IOfertaPersonajeDO;
import lcaInterfaceDAO.IPersonajeDO;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class OfertaPersonajeDAO extends BaseDAO implements IOfertaPersonajeDAO {

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

		OfertaDAO ofertaDAO = new OfertaDAO(); // Used to make the FK
		ofertaDAO.init(connectionBean);

		PersonajeDAO personajeDAO = new PersonajeDAO(); // Used to make the FK
		personajeDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(OfertaPersonajeDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");

		strbuf.append(OfertaPersonajeDO.OFERTA_ID);
		strbuf.append(" INT NOT NULL REFERENCES   ");
		strbuf.append(ofertaDAO.getTableName() + ", ");
		strbuf.append(OfertaPersonajeDO.PERSONAJE_ID);
		strbuf.append(" INT NOT NULL REFERENCES   ");
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

	// ----------------------------------------

	@Override
	public void delete(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_DELETE);
		checkClass(dataObject, OfertaDO.class, CHECK_DELETE);

		OfertaPersonajeDO ofertaPersonajeDO = (OfertaPersonajeDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(OfertaPersonajeDO.ID);
		strbuf.append(" = ");
		strbuf.append(ofertaPersonajeDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);

	}

	// ----------------------------------------

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, OfertaPersonajeDO.class, CHECK_INSERT);

		OfertaPersonajeDO ofertaPersonajeDO = (OfertaPersonajeDO) dataObject;

		ofertaPersonajeDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(ofertaPersonajeDO.getId());
		strbuf.append(", ");

		Reference<IOfertaDO> refof = ofertaPersonajeDO.getOfertaRef();
		refof.checkInsert();
		strbuf.append(refof.getIdAsString());

		strbuf.append(", ");

		Reference<IPersonajeDO> refp = ofertaPersonajeDO.getPersonajeRef();
		refp.checkInsert();
		strbuf.append(refp.getIdAsString());
		strbuf.append(")");

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.add(dataObject);

	}

	// ----------------------------------------

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

	// ----------------------------------------

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

	// ----------------------------------------

	private OfertaPersonajeDO resultSetToDO(ResultSet rs) throws SQLException {
		OfertaPersonajeDO ret = //
		(OfertaPersonajeDO) dtaSession.getDtaByKey( //
				OfertaPersonajeDO.class, rs.getInt(OfertaPersonajeDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new OfertaPersonajeDO();

		ret.setId/*     */(rs.getInt(OfertaPersonajeDO.ID));

		Reference<IOfertaDO> refOf = new Reference<IOfertaDO>();
		refOf.setRefIdent(rs.getInt(OfertaPersonajeDO.OFERTA_ID));
		ret.setOfertaRef(refOf);

		Reference<IPersonajeDO> refP = new Reference<IPersonajeDO>();
		refP.setRefIdent(rs.getInt(OfertaPersonajeDO.PERSONAJE_ID));
		ret.setPersonajeRef(refP);

		return (OfertaPersonajeDO) dtaSession.add(ret);
	}

	// ----------------------------------------

	@Override
	public List<DataObject> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IOfertaPersonajeDO> listByPersonajeId(int personajeId)
			throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(OfertaPersonajeDO.PERSONAJE_ID);
		strbuf.append(" = ");
		strbuf.append(personajeId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IOfertaPersonajeDO> ret = new ArrayList<IOfertaPersonajeDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	// ----------------------------------------

	public List<IOfertaPersonajeDO> listByOfertaId(int ofertaId)
			throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(OfertaPersonajeDO.OFERTA_ID);
		strbuf.append(" = ");
		strbuf.append(ofertaId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IOfertaPersonajeDO> ret = new ArrayList<IOfertaPersonajeDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	// ----------------------------------------

	@Override
	public DataObject loadById(int id) throws SQLException {

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(OfertaPersonajeDO.ID);
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
	public void loadPersonajeRef(IOfertaPersonajeDO ofertaPersonajeDO)
			throws SQLException {
		checkClass(ofertaPersonajeDO, OfertaPersonajeDO.class, CHECK_UPDATE);

		PersonajeDAO personajeDAO = new PersonajeDAO();
		personajeDAO.init(connectionBean);

		Reference<IPersonajeDO> ref = ofertaPersonajeDO.getPersonajeRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		PersonajeDO personajeDO = //
		(PersonajeDO) personajeDAO.loadById(ref.getRefIdent());

		ref.setRefValue(personajeDO);
	}

	// --------------------------------------------------------------------------------

	public void loadOfertaRef(IOfertaPersonajeDO ofertaPersonajeDO)
			throws SQLException {

		checkClass(ofertaPersonajeDO, OfertaPersonajeDO.class, CHECK_UPDATE);

		OfertaDAO ofertaDAO = new OfertaDAO();
		ofertaDAO.init(connectionBean);

		Reference<IOfertaDO> ref = ofertaPersonajeDO.getOfertaRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		OfertaDO ofertaDO = //
		(OfertaDO) ofertaDAO.loadById(ref.getRefIdent());

		ref.setRefValue(ofertaDO);
	}

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, OfertaPersonajeDO.class, CHECK_UPDATE);

		OfertaPersonajeDO ofertaPersonajeDO = (OfertaPersonajeDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(OfertaPersonajeDO.OFERTA_ID);
		strbuf.append(" = ");
		Reference<IOfertaDO> refOf = ofertaPersonajeDO.getOfertaRef();
		refOf.checkUpdate();
		strbuf.append(refOf.getIdAsString());

		strbuf.append(", ");

		strbuf.append(OfertaPersonajeDO.PERSONAJE_ID);
		strbuf.append(" = ");
		Reference<IPersonajeDO> refP = ofertaPersonajeDO.getPersonajeRef();
		refP.checkUpdate();
		strbuf.append(refP.getIdAsString());

		strbuf.append(" WHERE ");
		strbuf.append(OfertaPersonajeDO.ID);
		strbuf.append(" = ");
		strbuf.append(ofertaPersonajeDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

	}

}
