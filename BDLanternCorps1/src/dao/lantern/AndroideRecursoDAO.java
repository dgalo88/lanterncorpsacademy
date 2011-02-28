package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;
import lcaInterfaceDAO.IAndroideDO;
import lcaInterfaceDAO.IAndroideRecursoDAO;
import lcaInterfaceDAO.IAndroideRecursoDO;
import lcaInterfaceDAO.IRecursoDO;

public class AndroideRecursoDAO extends BaseDAO implements IAndroideRecursoDAO {

	public AndroideRecursoDAO() {
		// TODO Auto-generated constructor stub
	}

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

		AndroideDAO androideDAO = new AndroideDAO();
		androideDAO.init(connectionBean);

		RecursoDAO recursoDAO = new RecursoDAO();
		recursoDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(AndroideRecursoDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(AndroideRecursoDO.CANTIDAD);
		strbuf.append(" INT,    ");
		strbuf.append(AndroideRecursoDO.RECURSO_ID);
		strbuf.append(" INT REFERENCES    ");
		strbuf.append(recursoDAO.getTableName());
		strbuf.append(",");
		strbuf.append(AndroideRecursoDO.ANDROIDE_ID);
		strbuf.append(" INT REFERENCES    ");
		strbuf.append(androideDAO.getTableName());
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
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, AndroideRecursoDO.class, CHECK_INSERT);

		AndroideRecursoDO androideRecurso = (AndroideRecursoDO) dataObject;

		androideRecurso.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(androideRecurso.getId());
		strbuf.append(", ");
		strbuf.append(androideRecurso.getCantidad());
		strbuf.append(", ");
		Reference<IRecursoDO> refRec = androideRecurso.getRecursoRef();
		refRec.checkInsert();
		strbuf.append(refRec.getIdAsString());
		strbuf.append(", ");
		Reference<IAndroideDO> refAnd = androideRecurso.getAndroideRef();
		refAnd.checkInsert();
		strbuf.append(refAnd.getIdAsString());
		strbuf.append(")");

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.add(dataObject);

	}

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, AndroideRecursoDO.class, CHECK_UPDATE);

		AndroideRecursoDO androideRecurso = (AndroideRecursoDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");
		strbuf.append(AndroideRecursoDO.CANTIDAD);
		strbuf.append(" = ");
		strbuf.append(androideRecurso.getCantidad());
		strbuf.append(", ");

		strbuf.append(AndroideRecursoDO.RECURSO_ID);
		strbuf.append(" = ");
		Reference<IRecursoDO> refRec = androideRecurso.getRecursoRef();
		refRec.checkUpdate();
		strbuf.append(refRec.getIdAsString());

		strbuf.append(", ");

		strbuf.append(AndroideRecursoDO.ANDROIDE_ID);
		strbuf.append(" = ");
		Reference<IAndroideDO> refAnd = androideRecurso.getAndroideRef();
		refAnd.checkUpdate();
		strbuf.append(refAnd.getIdAsString());

		strbuf.append(" WHERE ");
		strbuf.append(AndroideRecursoDO.ID);
		strbuf.append(" = ");
		strbuf.append(androideRecurso.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

	}

	@Override
	public void delete(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_DELETE);
		checkClass(dataObject, RecursoDO.class, CHECK_DELETE);

		AndroideRecursoDO androideRecursoDO = (AndroideRecursoDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(AndroideRecursoDO.ID);
		strbuf.append(" = ");
		strbuf.append(androideRecursoDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);

	}

	@Override
	public DataObject loadById(int id) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(AndroideRecursoDO.ID);
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

	private AndroideRecursoDO resultSetToDO(ResultSet rs) throws SQLException {
		AndroideRecursoDO ret = //
		(AndroideRecursoDO) dtaSession.getDtaByKey( //
				AndroideRecursoDO.class, rs.getInt(AndroideRecursoDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new AndroideRecursoDO();

		ret.setId/*     				*/(rs.getInt(AndroideRecursoDO.ID));
		ret.setCantidad/*	            */(rs.getInt(AndroideRecursoDO.CANTIDAD));

		Reference<IRecursoDO> refRec = new Reference<IRecursoDO>();
		refRec.setRefIdent(rs.getInt(AndroideRecursoDO.RECURSO_ID));
		ret.setRecursoRef(refRec);

		Reference<IAndroideDO> refAnd = new Reference<IAndroideDO>();
		refAnd.setRefIdent(rs.getInt(AndroidePersonajeDO.ANDROIDE_ID));
		ret.setAndroideRef(refAnd);

		return (AndroideRecursoDO) dtaSession.add(ret);
	}

	@Override
	public List<DataObject> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IAndroideRecursoDO> listByRecursoId(int recId)
			throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(AndroideRecursoDO.RECURSO_ID);
		strbuf.append(" = ");
		strbuf.append(recId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IAndroideRecursoDO> ret = new ArrayList<IAndroideRecursoDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	public List<IAndroideRecursoDO> listByAndroideId(int AndroideId)
			throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(AndroidePersonajeDO.ANDROIDE_ID);
		strbuf.append(" = ");
		strbuf.append(AndroideId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IAndroideRecursoDO> ret = new ArrayList<IAndroideRecursoDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	// ----------------------------------------------------------------------------------------------

	@Override
	public void loadAndroideRef(IAndroideRecursoDO androideRecursoDO)
			throws SQLException {
		checkClass(androideRecursoDO, AndroideRecursoDO.class, CHECK_UPDATE);
		AndroideDAO androideDAO = new AndroideDAO();
		androideDAO.init(connectionBean);
		Reference<IAndroideDO> ref = androideRecursoDO.getAndroideRef();
		if (ref.getRefIdent() == 0) {
			return;
		}
		AndroideDO androideDO = //
		(AndroideDO) androideDAO.loadById(ref.getRefIdent());
		ref.setRefValue(androideDO);

	}

	@Override
	public void loadRecursoRef(IAndroideRecursoDO androideRecursoDO)
			throws SQLException {
		checkClass(androideRecursoDO, AndroideRecursoDO.class, CHECK_UPDATE);
		RecursoDAO recursoDAO = new RecursoDAO();
		recursoDAO.init(connectionBean);
		Reference<IRecursoDO> ref = androideRecursoDO.getRecursoRef();
		if (ref.getRefIdent() == 0) {
			return;
		}
		RecursoDO recursoDO = //
		(RecursoDO) recursoDAO.loadById(ref.getRefIdent());
		ref.setRefValue(recursoDO);
	}

}
