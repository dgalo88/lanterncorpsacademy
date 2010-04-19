package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject; //import dao.api.FactoryDAO;
import dao.api.Reference;


/**
 * @author Demián Gutierrez
 */
public class OrdenDAO extends BaseDAO {

	public OrdenDAO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

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

		MisionDAO m = new MisionDAO();

		ObjetivoDAO o = new ObjetivoDAO();

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(OrdenDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(OrdenDO.PRIORIDAD);
		strbuf.append("INT,    ");
		strbuf.append(OrdenDO.MISION_ID);
		strbuf.append("INT  REFERENCES    ");
		strbuf.append(m.getTableName());
		strbuf.append(" ");
		strbuf.append(MisionDO.ID);
		strbuf.append(", ");
		strbuf.append(OrdenDO.OBJETIVO_ID);
		strbuf.append("INT  REFERENCES    ");
		strbuf.append(o.getTableName());
		strbuf.append(" ");
		strbuf.append(ObjetivoDO.ID);
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

	// --------------------------------------------------------------------------------

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, OrdenDO.class, CHECK_INSERT);

		OrdenDO ordenDO = (OrdenDO) dataObject;

		ordenDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(ordenDO.getId());
		strbuf.append(", ");
		strbuf.append(ordenDO.getPrioridad());
		strbuf.append(", ");
		strbuf.append(ordenDO.getMisionRef().getRefIdent());
		strbuf.append(", ");
		strbuf.append(ordenDO.getObjetivoRef().getRefIdent());
		strbuf.append(")");

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.add(dataObject);
	}

	// --------------------------------------------------------------------------------

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, OrdenDO.class, CHECK_UPDATE);

		OrdenDO ordenDO = (OrdenDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(OrdenDO.PRIORIDAD);
		strbuf.append(" = ");
		strbuf.append(ordenDO.getPrioridad());

		strbuf.append(", ");

		strbuf.append(OrdenDO.MISION_ID);
		strbuf.append(" = ");
		strbuf.append(ordenDO.getMisionRef().getRefIdent());

		strbuf.append(", ");

		strbuf.append(OrdenDO.OBJETIVO_ID);
		strbuf.append(" = ");
		strbuf.append(ordenDO.getObjetivoRef().getRefIdent());

		strbuf.append(" WHERE ");
		strbuf.append(OrdenDO.ID);
		strbuf.append(" = ");
		strbuf.append(ordenDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());
	}

	// --------------------------------------------------------------------------------

	@Override
	public void delete(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_DELETE);
		checkClass(dataObject, OrdenDO.class, CHECK_DELETE);

		OrdenDO ordenDO = (OrdenDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(OrdenDO.ID);
		strbuf.append(" = ");
		strbuf.append(ordenDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);
	}

	// --------------------------------------------------------------------------------

	@Override
	public DataObject loadById(int id) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(OrdenDO.ID);
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

	// --------------------------------------------------------------------------------

	@Override
	public List<DataObject> listAll() throws SQLException {
		return listAll(-1, -1);
	}

	// --------------------------------------------------------------------------------

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

	// --------------------------------------------------------------------------------

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

	// --------------------------------------------------------------------------------

	private OrdenDO resultSetToDO(ResultSet rs) throws SQLException {
		OrdenDO ret = //
		(OrdenDO) dtaSession.getDtaByKey( //
				OrdenDO.class, rs.getInt(OrdenDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new OrdenDO();

		ret.setId/*     */(rs.getInt(OrdenDO.ID));
		ret.setPrioridad/*   */(rs.getInt(OrdenDO.PRIORIDAD));

		Reference<MisionDO> refm = new Reference<MisionDO>();
		refm.setRefIdent(rs.getInt(OrdenDO.MISION_ID));
		ret.setMisionRef(refm);

		Reference<ObjetivoDO> refo = new Reference<ObjetivoDO>();
		refo.setRefIdent(rs.getInt(OrdenDO.OBJETIVO_ID));
		ret.setObjetivoRef(refo);

		return (OrdenDO) dtaSession.add(ret);
	}

	// --------------------------------------------------------------------------------

	public List<OrdenDO> listByIdMisionId(int misionId) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(OrdenDO.MISION_ID);
	    strbuf.append(" = ");
	    strbuf.append(misionId);

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    List<OrdenDO> ret = new ArrayList<OrdenDO>();

	    while (rs.next()) {
	      ret.add(resultSetToDO(rs));
	    }

	    return ret;
	  }
	
	// --------------------------------------------------------------------------------

	public List<OrdenDO> listByIdObjetivoId(int objetivoId) throws SQLException {
	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(OrdenDO.OBJETIVO_ID);
	    strbuf.append(" = ");
	    strbuf.append(objetivoId);

	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());

	    List<OrdenDO> ret = new ArrayList<OrdenDO>();

	    while (rs.next()) {
	      ret.add(resultSetToDO(rs));
	    }

	    return ret;
	  }
}
