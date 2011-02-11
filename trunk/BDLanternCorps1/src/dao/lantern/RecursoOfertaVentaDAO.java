package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IOfertaDO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoOfertaVentaDAO;
import lcaInterfaceDAO.IRecursoOfertaVentaDO;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class RecursoOfertaVentaDAO extends BaseDAO implements
		IRecursoOfertaVentaDAO {

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

		OfertaDAO ofertaDAO = new OfertaDAO();
		ofertaDAO.init(connectionBean);

		RecursoDAO recursoDAO = new RecursoDAO();
		recursoDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(RecursoOfertaVentaDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(RecursoOfertaVentaDO.CANTIDAD);
		strbuf.append(" INT ,    ");
		strbuf.append(RecursoOfertaVentaDO.RECURSO_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(recursoDAO.getTableName() + ", ");
		strbuf.append(RecursoOfertaVentaDO.OFERTA_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(ofertaDAO.getTableName());
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
		checkClass(dataObject, RecursoOfertaVentaDO.class, CHECK_DELETE);

		OfertaDO ofertaDO = (OfertaDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(OfertaDO.ID);
		strbuf.append(" = ");
		strbuf.append(ofertaDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);

	}

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, RecursoOfertaVentaDO.class, CHECK_INSERT);

		RecursoOfertaVentaDO recursoOfertaVentaDO = (RecursoOfertaVentaDO) dataObject;

		recursoOfertaVentaDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(recursoOfertaVentaDO.getId());
		strbuf.append(", ");
		strbuf.append(recursoOfertaVentaDO.getCantidad());
		strbuf.append(", ");
		Reference<IRecursoDO> refR = recursoOfertaVentaDO.getRecursoRef();
		refR.checkInsert();
		strbuf.append(refR.getIdAsString());

		strbuf.append(", ");
		Reference<IOfertaDO> refO = recursoOfertaVentaDO.getOfertaRef();
		refO.checkInsert();
		strbuf.append(refO.getIdAsString());

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
		strbuf.append(RecursoOfertaVentaDO.ID);
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
		checkClass(dataObject, RecursoOfertaVentaDO.class, CHECK_UPDATE);

		RecursoOfertaVentaDO recursoOfertaVentaDO = (RecursoOfertaVentaDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(RecursoOfertaVentaDO.CANTIDAD);
		strbuf.append(" = ");
		strbuf.append(recursoOfertaVentaDO.getCantidad());

		strbuf.append(", ");

		strbuf.append(RecursoOfertaVentaDO.OFERTA_ID);
		strbuf.append(" = ");
		Reference<IOfertaDO> refOf = recursoOfertaVentaDO.getOfertaRef();
		refOf.checkUpdate();
		strbuf.append(refOf.getIdAsString());

		strbuf.append(", ");

		strbuf.append(RecursoOfertaVentaDO.RECURSO_ID);
		strbuf.append(" = ");
		Reference<IRecursoDO> refR = recursoOfertaVentaDO.getRecursoRef();
		refR.checkUpdate();
		strbuf.append(refR.getIdAsString());

		strbuf.append(" WHERE ");
		strbuf.append(OfertaDO.ID);
		strbuf.append(" = ");
		strbuf.append(recursoOfertaVentaDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

	}

	@Override
	public List<IRecursoOfertaVentaDO> listByOfertaId(int ofertaId)
			throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(RecursoOfertaVentaDO.OFERTA_ID);
		strbuf.append(" = ");
		strbuf.append(ofertaId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IRecursoOfertaVentaDO> ret = new ArrayList<IRecursoOfertaVentaDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	@Override
	public List<IRecursoOfertaVentaDO> listByRecursoId(int recursoId)
			throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(RecursoOfertaVentaDO.RECURSO_ID);
		strbuf.append(" = ");
		strbuf.append(recursoId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IRecursoOfertaVentaDO> ret = new ArrayList<IRecursoOfertaVentaDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	private IRecursoOfertaVentaDO resultSetToDO(ResultSet rs)
			throws SQLException {
		RecursoOfertaVentaDO ret = //
		(RecursoOfertaVentaDO) dtaSession.getDtaByKey( //
				RecursoOfertaVentaDO.class, rs.getInt(RecursoOfertaVentaDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new RecursoOfertaVentaDO();

		ret.setId/*     					*/(rs.getInt(RecursoOfertaVentaDO.ID));
		ret.setCantidad/*	            */(rs.getInt(RecursoOfertaVentaDO.CANTIDAD));

		Reference<IOfertaDO> refOf = new Reference<IOfertaDO>();
		refOf.setRefIdent(rs.getInt(RecursoOfertaVentaDO.OFERTA_ID));
		ret.setOfertaRef(refOf);

		Reference<IRecursoDO> refR = new Reference<IRecursoDO>();
		refR.setRefIdent(rs.getInt(RecursoOfertaVentaDO.RECURSO_ID));
		ret.setRecursoRef(refR);

		return (RecursoOfertaVentaDO) dtaSession.add(ret);
	}

	@Override
	public DataObject loadByRecursoId(int recurso, int ofertaId)
			throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(RecursoOfertaVentaDO.RECURSO_ID);
		strbuf.append(" = ");
		strbuf.append(recurso);
		strbuf.append(" AND ");
		strbuf.append(RecursoOfertaVentaDO.OFERTA_ID);
		strbuf.append(" = ");
		strbuf.append(ofertaId);

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
	public void loadOfertaRef(IRecursoOfertaVentaDO recursoOfertaVentaDO)
			throws SQLException {

		checkClass(recursoOfertaVentaDO, RecursoOfertaVentaDO.class,
				CHECK_UPDATE);

		OfertaDAO ofertaDAO = new OfertaDAO();
		ofertaDAO.init(connectionBean);

		Reference<IOfertaDO> ref = recursoOfertaVentaDO.getOfertaRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		OfertaDO ofertaDO = //
		(OfertaDO) ofertaDAO.loadById(ref.getRefIdent());

		ref.setRefValue(ofertaDO);
	}

	// --------------------------------------------------------------------------------

	@Override
	public void loadRecursoRef(IRecursoOfertaVentaDO recursoOfertaVentaDO)
			throws SQLException {
		checkClass(recursoOfertaVentaDO, RecursoOfertaVentaDO.class,
				CHECK_UPDATE);

		RecursoDAO recursoDAO = new RecursoDAO();
		recursoDAO.init(connectionBean);

		Reference<IRecursoDO> ref = recursoOfertaVentaDO.getRecursoRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		RecursoDO recursoDO = //
		(RecursoDO) recursoDAO.loadById(ref.getRefIdent());

		ref.setRefValue(recursoDO);
	}

}
