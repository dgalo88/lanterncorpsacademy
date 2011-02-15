package dao.lantern;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IOfertaDO;
import lcaInterfaceDAO.IUnidadEjercitoDO;
import lcaInterfaceDAO.IUnidadEjercitoOfertaDAO;
import lcaInterfaceDAO.IUnidadEjercitoOfertaDO;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class UnidadEjercitoOfertaDAO extends BaseDAO implements
		IUnidadEjercitoOfertaDAO {

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

		UnidadEjercitoDAO unidadEjercitoDAO = new UnidadEjercitoDAO(); // Used
		// to
		// make
		// the
		// FK
		unidadEjercitoDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(UnidadEjercitoOfertaDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");

		strbuf.append(UnidadEjercitoOfertaDO.OFERTA_ID);
		strbuf.append(" INT NOT NULL REFERENCES   ");
		strbuf.append(ofertaDAO.getTableName() + ", ");
		strbuf.append(UnidadEjercitoOfertaDO.UNIDAD_EJERCITO_ID);
		strbuf.append(" INT NOT NULL REFERENCES   ");
		strbuf.append(unidadEjercitoDAO.getTableName());
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
		checkClass(dataObject, UnidadEjercitoDO.class, CHECK_DELETE);

		UnidadEjercitoOfertaDO unidadEjercitoOfertaDO = (UnidadEjercitoOfertaDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(UnidadEjercitoOfertaDO.ID);
		strbuf.append(" = ");
		strbuf.append(unidadEjercitoOfertaDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);

	}

	// ----------------------------------------

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, UnidadEjercitoOfertaDO.class, CHECK_INSERT);

		UnidadEjercitoOfertaDO unidadEjercitoOfertaDO = (UnidadEjercitoOfertaDO) dataObject;

		unidadEjercitoOfertaDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(unidadEjercitoOfertaDO.getId());
		strbuf.append(", ");

		Reference<IOfertaDO> refof = unidadEjercitoOfertaDO.getOfertaRef();
		refof.checkInsert();
		strbuf.append(refof.getIdAsString());

		strbuf.append(", ");

		Reference<IUnidadEjercitoDO> refe = unidadEjercitoOfertaDO
				.getUnidadEjercitoRef();
		refe.checkInsert();
		strbuf.append(refe.getIdAsString());
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

	private UnidadEjercitoOfertaDO resultSetToDO(ResultSet rs)
			throws SQLException {
		UnidadEjercitoOfertaDO ret = //
		(UnidadEjercitoOfertaDO) dtaSession.getDtaByKey( //
				UnidadEjercitoOfertaDO.class, rs
						.getInt(UnidadEjercitoOfertaDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new UnidadEjercitoOfertaDO();

		ret.setId/*     */(rs.getInt(UnidadEjercitoOfertaDO.ID));

		Reference<IOfertaDO> refOf = new Reference<IOfertaDO>();
		refOf.setRefIdent(rs.getInt(UnidadEjercitoOfertaDO.OFERTA_ID));
		ret.setOfertaRef(refOf);

		Reference<IUnidadEjercitoDO> refe = new Reference<IUnidadEjercitoDO>();
		refe.setRefIdent(rs.getInt(UnidadEjercitoOfertaDO.UNIDAD_EJERCITO_ID));
		ret.setUnidadEjercitoRef(refe);

		return (UnidadEjercitoOfertaDO) dtaSession.add(ret);
	}

	// ----------------------------------------

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
		strbuf.append(UnidadEjercitoOfertaDO.ID);
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

	// -----------------------------------------------------------------------

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, UnidadEjercitoOfertaDO.class, CHECK_UPDATE);

		UnidadEjercitoOfertaDO unidadEjercitoOfertaDO = (UnidadEjercitoOfertaDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(UnidadEjercitoOfertaDO.OFERTA_ID);
		strbuf.append(" = ");
		Reference<IOfertaDO> refOf = unidadEjercitoOfertaDO.getOfertaRef();
		refOf.checkUpdate();
		strbuf.append(refOf.getIdAsString());

		strbuf.append(", ");

		strbuf.append(UnidadEjercitoOfertaDO.UNIDAD_EJERCITO_ID);
		strbuf.append(" = ");
		Reference<IUnidadEjercitoDO> refe = unidadEjercitoOfertaDO
				.getUnidadEjercitoRef();
		refe.checkUpdate();
		strbuf.append(refe.getIdAsString());

		strbuf.append(" WHERE ");
		strbuf.append(UnidadEjercitoOfertaDO.ID);
		strbuf.append(" = ");
		strbuf.append(unidadEjercitoOfertaDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

	}

	@Override
	public List<IUnidadEjercitoOfertaDO> listByOfertaId(int ofertaId)
			throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(UnidadEjercitoOfertaDO.OFERTA_ID);
		strbuf.append(" = ");
		strbuf.append(ofertaId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IUnidadEjercitoOfertaDO> ret = new ArrayList<IUnidadEjercitoOfertaDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	// ----------------------------------------

	@Override
	public List<IUnidadEjercitoOfertaDO> listByUnidadEjercitoId(
			int unidadEjercitoId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(UnidadEjercitoOfertaDO.UNIDAD_EJERCITO_ID);
		strbuf.append(" = ");
		strbuf.append(unidadEjercitoId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IUnidadEjercitoOfertaDO> ret = new ArrayList<IUnidadEjercitoOfertaDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

}
