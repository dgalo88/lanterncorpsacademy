package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoPlanetaDAO;
import lcaInterfaceDAO.IRecursoPlanetaDO;
import lcaInterfaceDAO.IPlanetaDO;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class RecursoPlanetaDAO extends BaseDAO implements IRecursoPlanetaDAO {

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

		RecursoDAO recursoDAO = new RecursoDAO(); // Used to make the FK
		recursoDAO.init(connectionBean);

		PlanetaDAO planetaDAO = new PlanetaDAO(); // Used to make the FK
		planetaDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(RecursoPlanetaDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");

		strbuf.append(RecursoPlanetaDO.RECURSO_ID);
		strbuf.append(" INT NOT NULL REFERENCES   ");
		strbuf.append(recursoDAO.getTableName() + ", ");
		strbuf.append(RecursoPlanetaDO.PLANETA_ID);
		strbuf.append(" INT NOT NULL REFERENCES   ");
		strbuf.append(planetaDAO.getTableName());
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
		checkClass(dataObject, RecursoDO.class, CHECK_DELETE);

		RecursoPlanetaDO recursoPlanetaDO = (RecursoPlanetaDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(OfertaPersonajeDO.ID);
		strbuf.append(" = ");
		strbuf.append(recursoPlanetaDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);

	}

	// ----------------------------------------

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, RecursoPlanetaDO.class, CHECK_INSERT);

		RecursoPlanetaDO recursoPlanetaDO = (RecursoPlanetaDO) dataObject;

		recursoPlanetaDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(recursoPlanetaDO.getId());
		strbuf.append(", ");

		Reference<IRecursoDO> refr = recursoPlanetaDO.getRecursoRef();
		refr.checkInsert();
		strbuf.append(refr.getIdAsString());

		strbuf.append(", ");

		Reference<IPlanetaDO> refpl = recursoPlanetaDO.getPlanetaRef();
		refpl.checkInsert();
		strbuf.append(refpl.getIdAsString());
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

	private RecursoPlanetaDO resultSetToDO(ResultSet rs) throws SQLException {
		RecursoPlanetaDO ret = //
		(RecursoPlanetaDO) dtaSession.getDtaByKey( //
				RecursoPlanetaDO.class, rs.getInt(RecursoPlanetaDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new RecursoPlanetaDO();

		ret.setId/*     */(rs.getInt(RecursoPlanetaDO.ID));

		Reference<IRecursoDO> refR = new Reference<IRecursoDO>();
		refR.setRefIdent(rs.getInt(RecursoPlanetaDO.RECURSO_ID));
		ret.setRecursoRef(refR);

		Reference<IPlanetaDO> refPl = new Reference<IPlanetaDO>();
		refPl.setRefIdent(rs.getInt(RecursoPlanetaDO.PLANETA_ID));
		ret.setPlanetaRef(refPl);

		return (RecursoPlanetaDO) dtaSession.add(ret);
	}

	// ----------------------------------------

	@Override
	public List<DataObject> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IRecursoPlanetaDO> listByPlanetaId(int planetaId)
			throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(RecursoPlanetaDO.PLANETA_ID);
		strbuf.append(" = ");
		strbuf.append(planetaId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IRecursoPlanetaDO> ret = new ArrayList<IRecursoPlanetaDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	// ----------------------------------------

	public List<IRecursoPlanetaDO> listByRecursoId(int recursoId)
			throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(RecursoPlanetaDO.RECURSO_ID);
		strbuf.append(" = ");
		strbuf.append(recursoId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IRecursoPlanetaDO> ret = new ArrayList<IRecursoPlanetaDO>();

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
		strbuf.append(RecursoPlanetaDO.ID);
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
	public void loadPlanetaRef(IRecursoPlanetaDO recursoPlanetaDO)
			throws SQLException {
		checkClass(recursoPlanetaDO, RecursoPlanetaDO.class, CHECK_UPDATE);

		PlanetaDAO planetaDAO = new PlanetaDAO();
		planetaDAO.init(connectionBean);

		Reference<IPlanetaDO> ref = recursoPlanetaDO.getPlanetaRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		PlanetaDO planetaDO = //
		(PlanetaDO) planetaDAO.loadById(ref.getRefIdent());

		ref.setRefValue(planetaDO);
	}

	// --------------------------------------------------------------------------------

	public void loadRecursoRef(IRecursoPlanetaDO recursoPlanetaDO)
			throws SQLException {

		checkClass(recursoPlanetaDO, RecursoPlanetaDO.class, CHECK_UPDATE);

		RecursoDAO recursoDAO = new RecursoDAO();
		recursoDAO.init(connectionBean);

		Reference<IRecursoDO> ref = recursoPlanetaDO.getRecursoRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		RecursoDO recursoDO = //
		(RecursoDO) recursoDAO.loadById(ref.getRefIdent());

		ref.setRefValue(recursoDO);
	}

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, RecursoPlanetaDO.class, CHECK_UPDATE);

		RecursoPlanetaDO recursoPlanetaDO = (RecursoPlanetaDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(RecursoPlanetaDO.RECURSO_ID);
		strbuf.append(" = ");
		Reference<IRecursoDO> refR = recursoPlanetaDO.getRecursoRef();
		refR.checkUpdate();
		strbuf.append(refR.getIdAsString());

		strbuf.append(", ");

		strbuf.append(RecursoPlanetaDO.PLANETA_ID);
		strbuf.append(" = ");
		Reference<IPlanetaDO> refPl = recursoPlanetaDO.getPlanetaRef();
		refPl.checkUpdate();
		strbuf.append(refPl.getIdAsString());

		strbuf.append(" WHERE ");
		strbuf.append(RecursoPlanetaDO.ID);
		strbuf.append(" = ");
		strbuf.append(recursoPlanetaDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

	}

}
