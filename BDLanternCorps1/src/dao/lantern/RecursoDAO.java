package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IRecursoDAO;
import lcaInterfaceDAO.IRecursoDO;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.FactoryDAO;

public class RecursoDAO extends BaseDAO implements IRecursoDAO {

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

		RecursoPersonajeDAO recursoPersonajeDAO = new RecursoPersonajeDAO();
		recursoPersonajeDAO.init(connectionBean);

		RecursoPlanetaDAO recursoPlanetaDAO = new RecursoPlanetaDAO();
		recursoPlanetaDAO.init(connectionBean);

		RecursoOfertaCompraDAO recursoOfertaCompraDAO = new RecursoOfertaCompraDAO();
		recursoOfertaCompraDAO.init(connectionBean);

		RecursoOfertaVentaDAO recursoOfertaVentaDAO = new RecursoOfertaVentaDAO();
		recursoOfertaVentaDAO.init(connectionBean);

		AndroideRecursoDAO androideRecursoDAO = new AndroideRecursoDAO();
		androideRecursoDAO.init(connectionBean);

		TecnologiaRecursoDAO tecnologiaRecursoDAO = new TecnologiaRecursoDAO();
		tecnologiaRecursoDAO.init(connectionBean);

		UnidadBasicaRecursoDAO unidadBasicaRecursoDAO = new UnidadBasicaRecursoDAO();
		unidadBasicaRecursoDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(RecursoDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(RecursoDO.ARTICULO);
		strbuf.append(" INT    ");
		strbuf.append(RecursoDO.NOMBRE);
		strbuf.append(" VARCHAR(100),    ");
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
		checkClass(dataObject, RecursoDO.class, CHECK_DELETE);

		RecursoDO recursoDO = (RecursoDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(RecursoDO.ID);
		strbuf.append(" = ");
		strbuf.append(recursoDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);
	}

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, RecursoDO.class, CHECK_INSERT);

		RecursoDO recursoDO = (RecursoDO) dataObject;

		recursoDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(recursoDO.getId()); // INSTANCIA
		strbuf.append(", ");
		strbuf.append(recursoDO.getArticulo());
		strbuf.append(", ");
		strbuf.append(singleQuotes(recursoDO.getNombre()));

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

		return null;
	}

	@Override
	public DataObject loadById(int id) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(RecursoDO.ID);
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
		checkClass(dataObject, RecursoDO.class, CHECK_UPDATE);

		RecursoDO recursoDO = (RecursoDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(RecursoDO.ARTICULO);
		strbuf.append(" = ");
		strbuf.append(recursoDO.getArticulo());

		strbuf.append(", ");

		strbuf.append(RecursoDO.NOMBRE);
		strbuf.append(" = ");
		strbuf.append(recursoDO.getNombre());

		strbuf.append(" WHERE ");
		strbuf.append(RecursoDO.ID);
		strbuf.append(" = ");
		strbuf.append(recursoDO.getId());

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

	private RecursoDO resultSetToDO(ResultSet rs) throws SQLException {
		RecursoDO ret = //
		(RecursoDO) dtaSession.getDtaByKey( //
				RecursoDO.class, rs.getInt(RecursoDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new RecursoDO();

		ret.setId/*     */(rs.getInt(RecursoDO.ID));
		ret.setArticulo/*   */(rs.getInt(RecursoDO.ARTICULO));
		ret.setNombre(rs.getString(RecursoDO.NOMBRE));

		return (RecursoDO) dtaSession.add(ret);
	}

	public void loadRecursoPersonajeList(IRecursoDO recursoDO) throws Exception {

		RecursoPersonajeDAO recursoPersonajeDAO = (RecursoPersonajeDAO) FactoryDAO
				.getDAO( //
						RecursoPersonajeDAO.class, connectionBean);

		recursoDO.setRecursoPersonajeList(recursoPersonajeDAO
				.listByRecursoId(recursoDO.getId()));
	}

	public void loadRecursoPlanetaList(IRecursoDO recursoDO) throws Exception {

		RecursoPlanetaDAO recursoPlanetaDAO = (RecursoPlanetaDAO) FactoryDAO
				.getDAO( //
						RecursoPlanetaDAO.class, connectionBean);

		recursoDO.setRecursoPlanetaList(recursoPlanetaDAO
				.listByRecursoId(recursoDO.getId()));
	}

	public void loadAndroideRecursoList(IRecursoDO recursoDO) throws Exception {

		AndroideRecursoDAO androideRecursoDAO = (AndroideRecursoDAO) FactoryDAO
				.getDAO( //
						AndroideRecursoDAO.class, connectionBean);

		recursoDO.setAndroideRecursoList(androideRecursoDAO
				.listByRecursoId(recursoDO.getId()));
	}

	public void loadTecnologiaRecursoList(IRecursoDO recursoDO)
			throws Exception {

		TecnologiaRecursoDAO tecnologiaRecursoDAO = (TecnologiaRecursoDAO) FactoryDAO
				.getDAO( //
						TecnologiaRecursoDAO.class, connectionBean);

		recursoDO.setTecnologiaRecursoList(tecnologiaRecursoDAO
				.listByRecursoId(recursoDO.getId()));
	}

	public void loadUnidadBasicaRecursoList(IRecursoDO recursoDO)
			throws Exception {

		
		 UnidadBasicaRecursoDAO unidadBasicaRecursoDAO = (UnidadBasicaRecursoDAO) FactoryDAO.getDAO( //
			        UnidadBasicaRecursoDAO.class, connectionBean);

			        recursoDO.setUnidadBasicaRecursoList(unidadBasicaRecursoDAO.listByRecursoId((recursoDO.getId())));
//		UnidadBasicaRecursoDAO unidadBasicaRecursoDAO = (UnidadBasicaRecursoDAO) FactoryDAO
//				.getDAO( //
//						UnidadBasicaRecursoDAO.class, connectionBean);
//
//		recursoDO.setUnidadBasicaRecursoList(unidadBasicaRecursoDAO
//				.listByRecursoId(recursoDO.getId()));
	}

	public void loadRecursoOfertaCompraList(IRecursoDO recursoDO)
			throws Exception {

		RecursoOfertaCompraDAO recursoOfertaCompraDAO = (RecursoOfertaCompraDAO) FactoryDAO
				.getDAO( //
						RecursoOfertaCompraDAO.class, connectionBean);

		recursoDO.setRecursoOfertaCompraList(recursoOfertaCompraDAO
				.listByRecursoId(recursoDO.getId()));
	}

	public void loadRecursoOfertaVentaList(IRecursoDO recursoDO)
			throws Exception {

		RecursoOfertaVentaDAO recursoOfertaVentaDAO = (RecursoOfertaVentaDAO) FactoryDAO
				.getDAO( //
						RecursoOfertaVentaDAO.class, connectionBean);

		recursoDO.setRecursoOfertaVentaList(recursoOfertaVentaDAO
				.listByRecursoId(recursoDO.getId()));
	}

	@Override
	public IRecursoDO loadByNombre(String nombre) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(RecursoDO.NOMBRE);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(nombre));

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		if (rs.next()) {
			return resultSetToDO(rs);
		}

		return null;

	}

}
