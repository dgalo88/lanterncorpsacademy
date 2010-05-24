package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IMisionDO;
import lcaInterfaceDAO.IObjetivoDO;
import lcaInterfaceDAO.IOrdenDAO;
import lcaInterfaceDAO.IOrdenDO;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class OrdenDAO extends BaseDAO implements IOrdenDAO {

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

		ObjetivoDAO objetivoDAO = new ObjetivoDAO();
		objetivoDAO.init(connectionBean);

		MisionDAO misionDAO = new MisionDAO();
		misionDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(OrdenDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(OrdenDO.PRIORIDAD);
		strbuf.append(" INT,    ");
		strbuf.append(OrdenDO.OBJETIVO_ID);
		strbuf.append(" INT REFERENCES    ");
		strbuf.append(objetivoDAO.getTableName());
		strbuf.append(",");
		strbuf.append(OrdenDO.MISION_ID);
		strbuf.append(" INT REFERENCES    ");
		strbuf.append(misionDAO.getTableName());
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
		checkClass(dataObject, OrdenDO.class, CHECK_INSERT);

		OrdenDO orden = (OrdenDO) dataObject;

		orden.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(orden.getId());
		strbuf.append(", ");
		strbuf.append(orden.getPrioridad());
		strbuf.append(", ");
		Reference<IObjetivoDO> refOb = orden.getObjetivoRef();
		refOb.checkInsert();
		strbuf.append(refOb.getIdAsString());
		strbuf.append(", ");
		Reference<IMisionDO> refM = orden.getMisionRef();
		refM.checkInsert();
		strbuf.append(refM.getIdAsString());
		strbuf.append(")");

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.add(dataObject);

	}

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, OrdenDO.class, CHECK_UPDATE);

		OrdenDO orden = (OrdenDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(OrdenDO.PRIORIDAD);
		strbuf.append(" = ");
		strbuf.append(orden.getPrioridad());

		strbuf.append(", ");

		strbuf.append(OrdenDO.OBJETIVO_ID);
		strbuf.append(" = ");
		Reference<IObjetivoDO> refOb = orden.getObjetivoRef();
		refOb.checkUpdate();
		strbuf.append(refOb.getIdAsString());

		strbuf.append(", ");

		strbuf.append(OrdenDO.MISION_ID);
		strbuf.append(" = ");
		Reference<IMisionDO> refM = orden.getMisionRef();
		refM.checkUpdate();
		strbuf.append(refM.getIdAsString());

		strbuf.append(" WHERE ");
		strbuf.append(OrdenDO.ID);
		strbuf.append(" = ");
		strbuf.append(orden.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

	}

	@Override
	public void delete(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_DELETE);
		checkClass(dataObject, ObjetivoDO.class, CHECK_DELETE);

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

	private OrdenDO resultSetToDO(ResultSet rs) throws SQLException {
		OrdenDO ret = //
		(OrdenDO) dtaSession.getDtaByKey( //
				OrdenDO.class, rs.getInt(OrdenDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new OrdenDO();

		ret.setId/*     				*/(rs.getInt(OrdenDO.ID));
		ret.setPrioridad/*	            */(rs.getInt(OrdenDO.PRIORIDAD));

		Reference<IObjetivoDO> refOb = new Reference<IObjetivoDO>();
		refOb.setRefIdent(rs.getInt(OrdenDO.OBJETIVO_ID));
		ret.setObjetivoRef(refOb);

		Reference<IMisionDO> refM = new Reference<IMisionDO>();
		refM.setRefIdent(rs.getInt(OrdenDO.MISION_ID));
		ret.setMisionRef(refM);

		return (OrdenDO) dtaSession.add(ret);
	}

	@Override
	public List<DataObject> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IOrdenDO> listByObjetivoId(int objId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(OrdenDO.OBJETIVO_ID);
		strbuf.append(" = ");
		strbuf.append(objId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IOrdenDO> ret = new ArrayList<IOrdenDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	public List<IOrdenDO> listByMisionId(int MisionId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(OrdenDO.MISION_ID);
		strbuf.append(" = ");
		strbuf.append(MisionId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IOrdenDO> ret = new ArrayList<IOrdenDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}
	//----------------------------------------------------------------------------------------------

	@Override
	public void loadMisionRef(IOrdenDO ordenDO) throws SQLException {
		checkClass(ordenDO, OrdenDO.class, CHECK_UPDATE);
		MisionDAO misionDAO = new MisionDAO();
		misionDAO.init(connectionBean);
		Reference<IMisionDO> ref = ordenDO.getMisionRef();
		if (ref.getRefIdent() == 0) {
			return;
		}
		MisionDO misionDO = //
		(MisionDO) misionDAO.loadById(ref.getRefIdent());
		ref.setRefValue(misionDO);
		
	}

	@Override
	public void loadObjetivoRef(IOrdenDO ordenDO) throws SQLException {
		checkClass(ordenDO, OrdenDO.class, CHECK_UPDATE);
		ObjetivoDAO objetivoDAO = new ObjetivoDAO();
		objetivoDAO.init(connectionBean);
		Reference<IObjetivoDO> ref = ordenDO.getObjetivoRef();
		if (ref.getRefIdent() == 0) {
			return;
		}
		ObjetivoDO objetivoDO = //
		(ObjetivoDO) objetivoDAO.loadById(ref.getRefIdent());
		ref.setRefValue(objetivoDO);
	}

}
