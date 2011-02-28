package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IUnidadBasicaDO;
import lcaInterfaceDAO.IUnidadEjercitoDAO;
import lcaInterfaceDAO.IUnidadEjercitoDO;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.FactoryDAO;
import dao.api.Reference;

public class UnidadEjercitoDAO extends BaseDAO implements IUnidadEjercitoDAO {

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

		UnidadBasicaDAO unidadBasicaDAO = new UnidadBasicaDAO();
		unidadBasicaDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(UnidadEjercitoDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(UnidadEjercitoDO.NOMBRE);
		strbuf.append(" VARCHAR (100)    ");

		strbuf.append(", ");
		strbuf.append(UnidadEjercitoDO.UNIDAD_BASICA_ARMA_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(unidadBasicaDAO.getTableName());
		strbuf.append(", ");
		strbuf.append(UnidadEjercitoDO.UNIDAD_BASICA_BALA_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(unidadBasicaDAO.getTableName());
		strbuf.append(", ");
		strbuf.append(UnidadEjercitoDO.UNIDAD_BASICA_ROBOT_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(unidadBasicaDAO.getTableName());
		strbuf.append(", ");
		strbuf.append(UnidadEjercitoDO.UNIDAD_BASICA_VEHICULO_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(unidadBasicaDAO.getTableName());

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
		checkClass(dataObject, UnidadEjercitoDO.class, CHECK_DELETE);

		UnidadEjercitoDO unidadEjercitoDO = (UnidadEjercitoDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(UnidadEjercitoDO.ID);
		strbuf.append(" = ");
		strbuf.append(unidadEjercitoDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);
	}

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, UnidadEjercitoDO.class, CHECK_INSERT);

		UnidadEjercitoDO unidadEjercitoDO = (UnidadEjercitoDO) dataObject;

		unidadEjercitoDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(unidadEjercitoDO.getId()); // INSTANCIA
		strbuf.append(", ");
		strbuf.append(unidadEjercitoDO.getNombre());
		strbuf.append(", ");

		Reference<IUnidadBasicaDO> ref1 = unidadEjercitoDO
				.getUnidadBasicaArmaRef();
		ref1.checkInsert();
		strbuf.append(ref1.getIdAsString());
		strbuf.append(", ");

		Reference<IUnidadBasicaDO> ref2 = unidadEjercitoDO
				.getUnidadBasicaBalaRef();
		ref2.checkInsert();
		strbuf.append(ref2.getIdAsString());
		strbuf.append(", ");

		Reference<IUnidadBasicaDO> ref3 = unidadEjercitoDO
				.getUnidadBasicaRobotRef();
		ref3.checkInsert();
		strbuf.append(ref3.getIdAsString());
		strbuf.append(", ");

		Reference<IUnidadBasicaDO> ref4 = unidadEjercitoDO
				.getUnidadBasicaVehiculoRef();
		ref4.checkInsert();
		strbuf.append(ref4.getIdAsString());

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
		return listAll(-1, -1);
	}

	@Override
	public DataObject loadById(int id) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(UnidadEjercitoDO.ID);
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
		checkClass(dataObject, UnidadEjercitoDO.class, CHECK_UPDATE);

		UnidadEjercitoDO unidadEjercitoDO = (UnidadEjercitoDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(UnidadEjercitoDO.NOMBRE);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(unidadEjercitoDO.getNombre()));

		strbuf.append(", ");

		strbuf.append(UnidadEjercitoDO.UNIDAD_BASICA_ARMA_ID);
		strbuf.append(" = ");
		Reference<IUnidadBasicaDO> refUba = unidadEjercitoDO
				.getUnidadBasicaArmaRef();
		refUba.checkUpdate();
		strbuf.append(refUba.getIdAsString());

		strbuf.append(", ");

		strbuf.append(UnidadEjercitoDO.UNIDAD_BASICA_ROBOT_ID);
		strbuf.append(" = ");
		Reference<IUnidadBasicaDO> refUbr = unidadEjercitoDO
				.getUnidadBasicaRobotRef();
		refUbr.checkUpdate();
		strbuf.append(refUbr.getIdAsString());

		strbuf.append(", ");

		strbuf.append(UnidadEjercitoDO.UNIDAD_BASICA_VEHICULO_ID);
		strbuf.append(" = ");
		Reference<IUnidadBasicaDO> refUbv = unidadEjercitoDO
				.getUnidadBasicaVehiculoRef();
		refUbv.checkUpdate();
		strbuf.append(refUbv.getIdAsString());

		strbuf.append(", ");

		strbuf.append(UnidadEjercitoDO.UNIDAD_BASICA_BALA_ID);
		strbuf.append(" = ");
		Reference<IUnidadBasicaDO> refUbb = unidadEjercitoDO
				.getUnidadBasicaArmaRef();
		refUbb.checkUpdate();
		strbuf.append(refUbb.getIdAsString());

		strbuf.append(" WHERE ");
		strbuf.append(UnidadEjercitoDO.ID);
		strbuf.append(" = ");
		strbuf.append(unidadEjercitoDO.getId());

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

	private UnidadEjercitoDO resultSetToDO(ResultSet rs) throws SQLException {
		UnidadEjercitoDO ret = //
		(UnidadEjercitoDO) dtaSession.getDtaByKey( //
				UnidadEjercitoDO.class, rs.getInt(UnidadEjercitoDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new UnidadEjercitoDO();

		ret.setId/*     */(rs.getInt(UnidadEjercitoDO.ID));
		ret.setNombre(rs.getString(UnidadEjercitoDO.NOMBRE));

		return (UnidadEjercitoDO) dtaSession.add(ret);
	}

	@Override
	public void loadUnidadBasicaArmaRef(IUnidadEjercitoDO unidadEjercitoDO)
			throws SQLException {
		checkClass(unidadEjercitoDO, UnidadEjercitoDO.class, CHECK_UPDATE);

		UnidadBasicaDAO unidadBasicaDAO = new UnidadBasicaDAO();
		unidadBasicaDAO.init(connectionBean);

		Reference<IUnidadBasicaDO> ref = unidadEjercitoDO
				.getUnidadBasicaArmaRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		UnidadBasicaDO unidadBasicaDO = //
		(UnidadBasicaDO) unidadBasicaDAO.loadById(ref.getRefIdent());

		ref.setRefValue(unidadBasicaDO);
	}

	@Override
	public void loadUnidadBasicaBalaRef(IUnidadEjercitoDO unidadEjercitoDO)
			throws SQLException {
		checkClass(unidadEjercitoDO, UnidadEjercitoDO.class, CHECK_UPDATE);

		UnidadBasicaDAO unidadBasicaDAO = new UnidadBasicaDAO();
		unidadBasicaDAO.init(connectionBean);

		Reference<IUnidadBasicaDO> ref = unidadEjercitoDO
				.getUnidadBasicaBalaRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		UnidadBasicaDO unidadBasicaDO = //
		(UnidadBasicaDO) unidadBasicaDAO.loadById(ref.getRefIdent());

		ref.setRefValue(unidadBasicaDO);

	}

	@Override
	public void loadUnidadBasicaRobotRef(IUnidadEjercitoDO unidadEjercitoDO)
			throws SQLException {
		checkClass(unidadEjercitoDO, UnidadEjercitoDO.class, CHECK_UPDATE);

		UnidadBasicaDAO unidadBasicaDAO = new UnidadBasicaDAO();
		unidadBasicaDAO.init(connectionBean);

		Reference<IUnidadBasicaDO> ref = unidadEjercitoDO
				.getUnidadBasicaRobotRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		UnidadBasicaDO unidadBasicaDO = //
		(UnidadBasicaDO) unidadBasicaDAO.loadById(ref.getRefIdent());

		ref.setRefValue(unidadBasicaDO);
	}

	@Override
	public void loadUnidadBasicaVehiculoRef(IUnidadEjercitoDO unidadEjercitoDO)
			throws SQLException {
		checkClass(unidadEjercitoDO, UnidadEjercitoDO.class, CHECK_UPDATE);

		UnidadBasicaDAO unidadBasicaDAO = new UnidadBasicaDAO();
		unidadBasicaDAO.init(connectionBean);

		Reference<IUnidadBasicaDO> ref = unidadEjercitoDO
				.getUnidadBasicaVehiculoRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		UnidadBasicaDO unidadBasicaDO = //
		(UnidadBasicaDO) unidadBasicaDAO.loadById(ref.getRefIdent());

		ref.setRefValue(unidadBasicaDO);

	}

	@Override
	public void loadUnidadEjercitoOfertaList(IUnidadEjercitoDO unidadEjercitoDO)
			throws Exception {
		checkCache(unidadEjercitoDO, CHECK_UPDATE);

		UnidadEjercitoOfertaDAO unidadEjercitoOfertaDAO = (UnidadEjercitoOfertaDAO) FactoryDAO
				.getDAO( //
						UnidadEjercitoOfertaDAO.class, connectionBean);

		unidadEjercitoDO.setUnidadEjercitoOfertaList(unidadEjercitoOfertaDAO
				.listByOfertaId(unidadEjercitoDO.getId()));

	}

	@Override
	public void loadUnidadEjercitoPersonajeList(
			IUnidadEjercitoDO unidadEjercitoDO) throws Exception {
		checkCache(unidadEjercitoDO, CHECK_UPDATE);

		UnidadEjercitoPersonajeDAO unidadEjercitoPersonajeDAO = (UnidadEjercitoPersonajeDAO) FactoryDAO
				.getDAO( //
						UnidadEjercitoPersonajeDAO.class, connectionBean);

		unidadEjercitoDO
				.setUnidadEjercitoPersonajeList(unidadEjercitoPersonajeDAO
						.listByPersonajeId(unidadEjercitoDO.getId()));

	}

	@Override
	public void loadPlanetaRef(IUnidadEjercitoDO unidadEjercitoDO)
			throws SQLException {
		checkClass(unidadEjercitoDO, UnidadEjercitoDO.class, CHECK_UPDATE);

		PlanetaDAO planetaDAO = new PlanetaDAO();
		planetaDAO.init(connectionBean);

		Reference<IPlanetaDO> ref = unidadEjercitoDO.getPlanetaRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		PlanetaDO planetaDO = //
		(PlanetaDO) planetaDAO.loadById(ref.getRefIdent());

		ref.setRefValue(planetaDO);

	}

	public List<IUnidadEjercitoDO> listByPlanetaId(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
