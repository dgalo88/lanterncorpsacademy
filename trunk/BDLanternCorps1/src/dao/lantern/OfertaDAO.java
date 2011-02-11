package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IOfertaDAO;
import lcaInterfaceDAO.IOfertaDO;
import lcaInterfaceDAO.IRecursoDO;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.FactoryDAO;

public class OfertaDAO extends BaseDAO implements IOfertaDAO {

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

		RecursoOfertaCompraDAO recursoOfertaCompraDAO = new RecursoOfertaCompraDAO();
		recursoOfertaCompraDAO.init(connectionBean);

		RecursoOfertaVentaDAO recursoOfertaVentaDAO = new RecursoOfertaVentaDAO();
		recursoOfertaVentaDAO.init(connectionBean);

		OfertaPersonajeDAO ofertaPersonajeDAO = new OfertaPersonajeDAO();
		ofertaPersonajeDAO.init(connectionBean);

		UnidadEjercitoOfertaDAO unidadEjercitoOfertaDAO = new UnidadEjercitoOfertaDAO();
		unidadEjercitoOfertaDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(OfertaDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(OfertaDO.ARTICULO);
		strbuf.append(" INT    ");
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
		checkClass(dataObject, OfertaDO.class, CHECK_DELETE);

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
		checkClass(dataObject, OfertaDO.class, CHECK_INSERT);

		OfertaDO ofertaDO = (OfertaDO) dataObject;

		ofertaDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(ofertaDO.getId()); // INSTANCIA
		strbuf.append(", ");
		strbuf.append(ofertaDO.getArticulo());

		strbuf.append(")");

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.add(dataObject);

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
		strbuf.append(OfertaDO.ID);
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

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, OfertaDO.class, CHECK_UPDATE);

		OfertaDO ofertaDO = (OfertaDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(OfertaDO.ARTICULO);
		strbuf.append(" = ");
		strbuf.append(ofertaDO.getArticulo());

		strbuf.append(" WHERE ");
		strbuf.append(OfertaDO.ID);
		strbuf.append(" = ");
		strbuf.append(ofertaDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

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

	private OfertaDO resultSetToDO(ResultSet rs) throws SQLException {
		OfertaDO ret = //
		(OfertaDO) dtaSession.getDtaByKey( //
				OfertaDO.class, rs.getInt(OfertaDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new OfertaDO();

		ret.setId/*     */(rs.getInt(OfertaDO.ID));
		ret.setArticulo(rs.getString(OfertaDO.ARTICULO));

		return (OfertaDO) dtaSession.add(ret);
	}

	public void loadRecursoOfertaCompraList(IOfertaDO ofertaDO)
			throws Exception {
		checkCache(ofertaDO, CHECK_UPDATE);

		RecursoOfertaCompraDAO recursoOfertaCompraDAO = (RecursoOfertaCompraDAO) FactoryDAO
				.getDAO( //
						RecursoOfertaCompraDAO.class, connectionBean);

		ofertaDO.setRecursoOfertaCompraList(recursoOfertaCompraDAO
				.listByOfertaId(ofertaDO.getId()));
	}

	public void loadRecursoOfertaVentaList(IOfertaDO ofertaDO) throws Exception {
		checkCache(ofertaDO, CHECK_UPDATE);

		RecursoOfertaVentaDAO recursoOfertaVentaDAO = (RecursoOfertaVentaDAO) FactoryDAO
				.getDAO( //
						RecursoOfertaVentaDAO.class, connectionBean);

		ofertaDO.setRecursoOfertaVentaList(recursoOfertaVentaDAO
				.listByOfertaId(ofertaDO.getId()));

	}

	public void loadOfertaPersonajeList(IOfertaDO ofertaDO) throws Exception {
		checkCache(ofertaDO, CHECK_UPDATE);

		OfertaPersonajeDAO ofertaPersonajeDAO = (OfertaPersonajeDAO) FactoryDAO
				.getDAO( //
						OfertaPersonajeDAO.class, connectionBean);

		ofertaDO.setOfertaPersonajeList(OfertaPersonajeDAO
				.listByOfertaId(ofertaDO.getId()));

	}

	public void loadUnidadEjercitoOfertaList(IOfertaDO ofertaDO)
			throws Exception {

		checkCache(ofertaDO, CHECK_UPDATE);

		UnidadEjercitoOfertaDAO unidadEjercitoOfertaDAO = (UnidadEjercitoOfertaDAO) FactoryDAO
				.getDAO( //
						UnidadEjercitoOfertaDAO.class, connectionBean);

		ofertaDO.setUnidadEjercitoOfertaList(UnidadEjercitoOfertaDAO
				.listByOfertaId(ofertaDO.getId()));

	}

	@Override
	public List<IOfertaDO> listPlayable(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRecursoDO loadByNombre(String nombre) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
