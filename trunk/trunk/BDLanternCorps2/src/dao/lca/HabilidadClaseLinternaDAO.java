package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class HabilidadClaseLinternaDAO extends BaseDAO{
	
	public HabilidadClaseLinternaDAO() {
		//Empty
	}

	// --------------------------------------------------------------------------------

	@Override
	public int countAll() throws SQLException {
		
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("SELECT COUNT(*) FROM ");
		strbuf.append(getTableName());

		System.err.println(strbuf.toString());
		ResultSet rs = connection.createStatement().executeQuery(strbuf.toString());
		rs.next();

		return rs.getInt("count");
	}

	// --------------------------------------------------------------------------------

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

		HabilidadDAO habilidadDAO = new HabilidadDAO();
		habilidadDAO.init(connectionBean);
		ClaseLinternaDAO claseLinternaDAO= new ClaseLinternaDAO();
		claseLinternaDAO.init(connectionBean);

		strbuf = new StringBuffer();
		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(HabilidadClaseLinternaDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(HabilidadClaseLinternaDO.HABILIDAD_ID);
		strbuf.append(" INT NOT NULL REFERENCES   ");
		strbuf.append(habilidadDAO.getTableName());
		strbuf.append(", ");
		strbuf.append(HabilidadClaseLinternaDO.CLASE_LINTERNA_ID);
		strbuf.append(" INT NOT NULL REFERENCES   ");
		strbuf.append(claseLinternaDAO.getTableName());
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
	public void delete(DataObject dataObject) throws SQLException {
		
		checkCache(dataObject, CHECK_DELETE);
		checkClass(dataObject, HabilidadClaseLinternaDO.class, CHECK_DELETE);

		HabilidadClaseLinternaDO habilidadDO = (HabilidadClaseLinternaDO) dataObject;

		StringBuffer strbuf = new StringBuffer();
		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());
		strbuf.append(" WHERE ");
		strbuf.append(HabilidadDO.ID);
		strbuf.append(" = ");
		strbuf.append(habilidadDO.getId());

		System.err.println(strbuf.toString());
		connection.createStatement().execute(strbuf.toString());
		dtaSession.del(dataObject);
		
	}

	// --------------------------------------------------------------------------------

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, HabilidadClaseLinternaDO.class, CHECK_INSERT);

		HabilidadClaseLinternaDO habilidadClaseLinternaDO = (HabilidadClaseLinternaDO) dataObject;
		habilidadClaseLinternaDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();
		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(habilidadClaseLinternaDO.getId());
		strbuf.append(", ");
		strbuf.append(habilidadClaseLinternaDO.getHabilidadRef().getIdAsString());
		strbuf.append(", ");
		strbuf.append(habilidadClaseLinternaDO.getClaseLinternaRef().getIdAsString());
		strbuf.append(")");
		System.err.println(strbuf.toString());
		connection.createStatement().execute(strbuf.toString());
		dtaSession.add(dataObject);
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
		ResultSet rs = connection.createStatement().executeQuery(strbuf.toString());
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
	public DataObject loadById(int id) throws SQLException {

		StringBuffer strbuf = new StringBuffer();
		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());
		strbuf.append(" WHERE ");
		strbuf.append(HabilidadDO.ID);
		strbuf.append(" = ");
		strbuf.append(id);

		System.err.println(strbuf.toString());
		ResultSet rs = connection.createStatement().executeQuery(strbuf.toString());

		if (rs.next()) {
			return resultSetToDO(rs);
		}
		return null;
	}

	// --------------------------------------------------------------------------------

	@Override
	public void update(DataObject dataObject) throws SQLException {
			
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, HabilidadClaseLinternaDO.class, CHECK_UPDATE);

		HabilidadClaseLinternaDO habilidadClaselinternaDO = (HabilidadClaseLinternaDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");
		strbuf.append(HabilidadClaseLinternaDO.HABILIDAD_ID);
		strbuf.append(" = ");
		strbuf.append(habilidadClaselinternaDO.getHabilidadRef().getIdAsString());
		strbuf.append(", ");
		strbuf.append(HabilidadClaseLinternaDO.CLASE_LINTERNA_ID);
		strbuf.append(" = ");
		strbuf.append(habilidadClaselinternaDO.getClaseLinternaRef().getIdAsString());
		strbuf.append(" WHERE ");
		strbuf.append(HabilidadClaseLinternaDO.ID);
		strbuf.append(" = ");
		strbuf.append(habilidadClaselinternaDO.getId());
		
		System.err.println(strbuf.toString());
		connection.createStatement().execute(strbuf.toString());
	}

	// --------------------------------------------------------------------------------

	private int getNextId() throws SQLException {
		
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("SELECT nextval(");
		strbuf.append(singleQuotes("seq_" + getTableName()));
		strbuf.append(")");

		System.err.println(strbuf.toString());
		ResultSet rs = connection.createStatement().executeQuery(strbuf.toString());

		if (!rs.next()) {
			throw new IllegalStateException("!rs.next()");
		}

		return rs.getInt("nextval");
	}

	// --------------------------------------------------------------------------------

	
	public List<HabilidadClaseLinternaDO> listByHabilidadId(int HabilidadId) throws SQLException {
		
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());
		strbuf.append(" WHERE ");
		strbuf.append(HabilidadClaseLinternaDO.HABILIDAD_ID);
		strbuf.append(" = ");
		strbuf.append(HabilidadId);

		System.err.println(strbuf.toString());
		ResultSet rs = connection.createStatement().executeQuery(strbuf.toString());

		List<HabilidadClaseLinternaDO> ret = new ArrayList<HabilidadClaseLinternaDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	// --------------------------------------------------------------------------------

	
	public List<HabilidadClaseLinternaDO> listByClaseId(int claseId) throws SQLException {
		
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());
		strbuf.append(" WHERE ");
		strbuf.append(HabilidadClaseLinternaDO.CLASE_LINTERNA_ID);
		strbuf.append(" = ");
		strbuf.append(claseId);

		System.err.println(strbuf.toString());
		ResultSet rs = connection.createStatement().executeQuery(strbuf.toString());

		List<HabilidadClaseLinternaDO> ret = new ArrayList<HabilidadClaseLinternaDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	// --------------------------------------------------------------------------------


	private HabilidadClaseLinternaDO resultSetToDO(ResultSet rs) throws SQLException {
		HabilidadClaseLinternaDO ret = (HabilidadClaseLinternaDO) dtaSession.getDtaByKey( //
				HabilidadClaseLinternaDO.class, rs.getInt(HabilidadClaseLinternaDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new HabilidadClaseLinternaDO();
		ret.setId(rs.getInt(HabilidadClaseLinternaDO.ID));
		
		Reference<HabilidadDO> ref = new Reference<HabilidadDO>();
	    ref.setRefIdent(rs.getInt(HabilidadClaseLinternaDO.HABILIDAD_ID));
	    ret.setHabilidadRef(ref);
	    
		Reference<ClaseLinternaDO> ref1 = new Reference<ClaseLinternaDO>();
	    ref1.setRefIdent(rs.getInt(HabilidadClaseLinternaDO.CLASE_LINTERNA_ID));
	    ret.setClaseLinternaRef(ref1);
	    
		return (HabilidadClaseLinternaDO) dtaSession.add(ret);
		
	}


}
