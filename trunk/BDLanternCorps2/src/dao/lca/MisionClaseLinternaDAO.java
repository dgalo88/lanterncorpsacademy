package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class MisionClaseLinternaDAO extends BaseDAO {

	public MisionClaseLinternaDAO() {
		// Empty
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

		ClaseLinternaDAO claseLinternaDAO = new ClaseLinternaDAO();
		claseLinternaDAO.init(connectionBean);
		MisionDAO misionDAO = new MisionDAO();
		misionDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(MisionClaseLinternaDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(MisionClaseLinternaDO.MISION_ID);
		strbuf.append(" INT REFERENCES,    ");
		strbuf.append(MisionClaseLinternaDO.CLASE_LINTERNA_ID);
		strbuf.append("INT REFERENCES    ");
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
		checkClass(dataObject, MisionClaseLinternaDO.class, CHECK_DELETE);

		MisionClaseLinternaDO misionClaseLinternaDO = (MisionClaseLinternaDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(MisionClaseLinternaDO.ID);
		strbuf.append(" = ");
		strbuf.append(misionClaseLinternaDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);

	}

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, MisionClaseLinternaDO.class, CHECK_INSERT);

		MisionClaseLinternaDO misionClaseLinternaDO = (MisionClaseLinternaDO) dataObject;

		misionClaseLinternaDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(misionClaseLinternaDO.getId());
		strbuf.append(", ");
		Reference<MisionDO> ref = misionClaseLinternaDO.getMisionRef();
		ref.checkInsert();
		strbuf.append(ref.getIdAsString());
		strbuf.append(", ");
		Reference<ClaseLinternaDO> ref1 = misionClaseLinternaDO
				.getClaseLinternaRef();
		ref1.checkInsert();
		strbuf.append(ref1.getIdAsString());
		strbuf.append(", ");
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
		return listAll(-1, -1);
	}

	@Override
	public DataObject loadById(int id) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(MisionClaseLinternaDO.ID);
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
	public void update(DataObject bean) throws SQLException {
		// Empty

	}

	private MisionClaseLinternaDO resultSetToDO(ResultSet rs)
			throws SQLException {
		MisionClaseLinternaDO ret = //
		(MisionClaseLinternaDO) dtaSession.getDtaByKey( //
				MisionClaseLinternaDO.class, rs
						.getInt(MisionClaseLinternaDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new MisionClaseLinternaDO();

		ret.setId/*      */(rs.getInt(MisionClaseLinternaDO.ID));

		Reference<MisionDO> ref = new Reference<MisionDO>();
		ref.setRefIdent(rs.getInt(MisionClaseLinternaDO.MISION_ID));

		ret.setMisionRef(ref);

		return (MisionClaseLinternaDO) dtaSession.add(ret);
	}

}
