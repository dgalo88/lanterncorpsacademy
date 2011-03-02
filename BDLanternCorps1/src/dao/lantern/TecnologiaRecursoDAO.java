package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.ITecnologiaRecursoDAO;
import lcaInterfaceDAO.ITecnologiaRecursoDO;

public class TecnologiaRecursoDAO extends BaseDAO implements ITecnologiaRecursoDAO {


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

		RecursoDAO recursoDAO = new RecursoDAO();
		recursoDAO.init(connectionBean);

		TecnologiaDAO tecnologiaDAO = new TecnologiaDAO();
		tecnologiaDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(TecnologiaRecursoDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(TecnologiaRecursoDO.TECNOLOGIA_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(tecnologiaDAO.getTableName());
		strbuf.append(", ");
		strbuf.append(TecnologiaRecursoDO.CANTIDAD);
		strbuf.append(" INT DEFAULT 1,    ");
		strbuf.append(TecnologiaRecursoDO.RECURSO_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(recursoDAO.getTableName());
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
		checkClass(dataObject, TecnologiaRecursoDO.class, CHECK_DELETE);

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
		checkClass(dataObject, TecnologiaRecursoDO.class, CHECK_INSERT);

		TecnologiaRecursoDO tecnologiaRecursoDO = (TecnologiaRecursoDO) dataObject;

		tecnologiaRecursoDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(tecnologiaRecursoDO.getId());
		strbuf.append(", ");

		Reference<ITecnologiaDO> refTec = tecnologiaRecursoDO.getTecnologiaRef();
		refTec.checkInsert();
		strbuf.append(refTec.getIdAsString());
		strbuf.append(", ");

		strbuf.append(tecnologiaRecursoDO.getCantidad());
		strbuf.append(", ");

		Reference<IRecursoDO> refRec = tecnologiaRecursoDO.getRecursoRef();
		refRec.checkInsert();
		strbuf.append(refRec.getIdAsString());

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

		return null;
	}

	@Override
	public DataObject loadById(int id) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(TecnologiaRecursoDO.ID);
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
	public DataObject loadByTecnologiaId(int tecid, int recursoId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(TecnologiaRecursoDO.TECNOLOGIA_ID);
		strbuf.append(" = ");
		strbuf.append(tecid);
		strbuf.append(" AND ");
		strbuf.append(TecnologiaRecursoDO.RECURSO_ID);
		strbuf.append(" = ");
		strbuf.append(recursoId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
			connection.createStatement().executeQuery(strbuf.toString());

		if (rs.next()) {
			return resultSetToDO(rs);
		}

		return null;
	}

	// --------------------------------------------------------------------------------

	public void loadTecnologiaRef(ITecnologiaRecursoDO tecnologiaRecursoDO) throws SQLException {

		checkClass(tecnologiaRecursoDO, TecnologiaRecursoDO.class, CHECK_UPDATE);

		TecnologiaDAO tecnologiaDAO = new TecnologiaDAO();
		tecnologiaDAO.init(connectionBean);

		Reference<ITecnologiaDO> ref = tecnologiaRecursoDO.getTecnologiaRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		TecnologiaDO tecnologiaDO = (TecnologiaDO) //
			tecnologiaDAO.loadById(ref.getRefIdent());

		ref.setRefValue(tecnologiaDO);
	}

	// --------------------------------------------------------------------------------

	public void loadRecursoRef(ITecnologiaRecursoDO tecnologiaRecursoDO) throws SQLException {

		checkClass(tecnologiaRecursoDO, TecnologiaRecursoDO.class, CHECK_UPDATE);

		RecursoDAO recursoDAO = new RecursoDAO();
		recursoDAO.init(connectionBean);

		Reference<IRecursoDO> ref = tecnologiaRecursoDO.getRecursoRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		RecursoDO recursoDO = (RecursoDO) //
			recursoDAO. loadById(ref.getRefIdent());

		ref.setRefValue(recursoDO);
	}

	// --------------------------------------------------------------------------------

	private ITecnologiaRecursoDO resultSetToDO(ResultSet rs) throws SQLException {
		TecnologiaRecursoDO ret = //
			(TecnologiaRecursoDO) dtaSession.getDtaByKey( //
					TecnologiaRecursoDO.class, rs.getInt(TecnologiaRecursoDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new TecnologiaRecursoDO();

		ret.setId/*				*/(rs.getInt(TecnologiaRecursoDO.ID));
		ret.setCantidad/*		*/(rs.getInt(TecnologiaRecursoDO.CANTIDAD));

		Reference<ITecnologiaDO> refTec = new Reference<ITecnologiaDO>();
		refTec.setRefIdent(rs.getInt(TecnologiaRecursoDO.TECNOLOGIA_ID));
		ret.setTecnologiaRef(refTec);

		Reference<IRecursoDO> refRec = new Reference<IRecursoDO>();
		refRec.setRefIdent(rs.getInt(TecnologiaRecursoDO.RECURSO_ID));
		ret.setRecursoRef(refRec);

		return (TecnologiaRecursoDO) dtaSession.add(ret);
	}

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, TecnologiaRecursoDO.class, CHECK_UPDATE);

		TecnologiaRecursoDO tecnologiaRecursoDO = (TecnologiaRecursoDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(TecnologiaRecursoDO.TECNOLOGIA_ID);
		strbuf.append(" = ");
		Reference<ITecnologiaDO> refTec = tecnologiaRecursoDO.getTecnologiaRef();
		refTec.checkUpdate();
		strbuf.append(refTec.getIdAsString());

		strbuf.append(TecnologiaRecursoDO.CANTIDAD);
		strbuf.append(" = ");
		strbuf.append(tecnologiaRecursoDO.getCantidad());
		strbuf.append(", ");

		strbuf.append(TecnologiaRecursoDO.RECURSO_ID);
		strbuf.append(" = ");
		Reference<IRecursoDO> refRec = tecnologiaRecursoDO.getRecursoRef();
		refRec.checkUpdate();
		strbuf.append(refRec.getIdAsString());

		strbuf.append(" WHERE ");
		strbuf.append(TecnologiaDO.ID);
		strbuf.append(" = ");
		strbuf.append(tecnologiaRecursoDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

	}

	public List<ITecnologiaRecursoDO> listByTecnologiaId(int tecnologiaId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(TecnologiaRecursoDO.TECNOLOGIA_ID);
		strbuf.append(" = ");
		strbuf.append(tecnologiaId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
			connection.createStatement().executeQuery(strbuf.toString());

		List<ITecnologiaRecursoDO> ret = new ArrayList<ITecnologiaRecursoDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	public List<ITecnologiaRecursoDO> listByRecursoId(int RecursoId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(TecnologiaRecursoDO.RECURSO_ID);
		strbuf.append(" = ");
		strbuf.append(RecursoId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
			connection.createStatement().executeQuery(strbuf.toString());

		List<ITecnologiaRecursoDO> ret = new ArrayList<ITecnologiaRecursoDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

}
