package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IUnidadBasicaDO;
import lcaInterfaceDAO.IUnidadBasicaRecursoDAO;
import lcaInterfaceDAO.IUnidadBasicaRecursoDO;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.Reference;

public class UnidadBasicaRecursoDAO extends BaseDAO implements IUnidadBasicaRecursoDAO {

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
	    
	    RecursoDAO recursoDAO = new RecursoDAO();
	    recursoDAO.init(connectionBean);

	    strbuf = new StringBuffer();

	    strbuf.append("CREATE TABLE ");
	    strbuf.append(getTableName());
	    strbuf.append(" (");
	    strbuf.append(UnidadBasicaRecursoDO.ID);
	    strbuf.append(" INT PRIMARY KEY, ");
	    strbuf.append(UnidadBasicaRecursoDO.CANTIDAD);
	    strbuf.append(" INT DEFAULT 1,    ");
	    strbuf.append(UnidadBasicaRecursoDO.UNIDAD_BASICA_ID);
	    strbuf.append(" INT REFERENCES   ");
	    strbuf.append(unidadBasicaDAO.getTableName()+", ");
	    strbuf.append(UnidadBasicaRecursoDO.RECURSO_ID);
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
	    checkClass(dataObject, UnidadBasicaRecursoDO.class, CHECK_DELETE);

	    UnidadBasicaDO unidadBasicaDO = (UnidadBasicaDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("DELETE FROM ");
	    strbuf.append(getTableName());

	    strbuf.append(" WHERE ");
	    strbuf.append(UnidadBasicaDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(unidadBasicaDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	    dtaSession.del(dataObject);


	}

	@Override
	public void insert(DataObject dataObject) throws SQLException {
	
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, UnidadBasicaRecursoDO.class, CHECK_INSERT);

	    UnidadBasicaRecursoDO unidadBasicaRecursoDO = (UnidadBasicaRecursoDO) dataObject;

	    unidadBasicaRecursoDO.setId(getNextId());

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("INSERT INTO ");
	    strbuf.append(getTableName());
	    strbuf.append(" VALUES (");
	    strbuf.append(unidadBasicaRecursoDO.getId());
	    strbuf.append(", ");
	    strbuf.append(unidadBasicaRecursoDO.getCantidad());
	    strbuf.append(", ");
	    Reference<IRecursoDO> refRec = unidadBasicaRecursoDO.getRecursoRef();
	    refRec.checkInsert();
	    strbuf.append(refRec.getIdAsString());
	    
	    strbuf.append(", ");	    
	    Reference<IUnidadBasicaDO> refUniBas = unidadBasicaRecursoDO.getUnidadBasicaRef();
	    refUniBas.checkInsert();
	    strbuf.append(refUniBas.getIdAsString());

	    
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
	    strbuf.append(UnidadBasicaRecursoDO.ID);
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

	
	//------------------------------------------------------------------------------------------------------------------------
	private IUnidadBasicaRecursoDO resultSetToDO(ResultSet rs) throws SQLException {
		UnidadBasicaRecursoDO ret = //
		(UnidadBasicaRecursoDO) dtaSession.getDtaByKey( //
				UnidadBasicaRecursoDO.class, rs.getInt(UnidadBasicaRecursoDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new UnidadBasicaRecursoDO();

		ret.setId/*     					*/(rs.getInt(UnidadBasicaRecursoDO.ID));
		ret.setCantidad/*	            */(rs.getInt(UnidadBasicaRecursoDO.CANTIDAD));

		Reference<IRecursoDO> refRec = new Reference<IRecursoDO>();
		refRec.setRefIdent(rs.getInt(UnidadBasicaRecursoDO.RECURSO_ID));
		ret.setRecursoRef(refRec);

		Reference<IUnidadBasicaDO> refUniBas = new Reference<IUnidadBasicaDO>();
		refUniBas.setRefIdent(rs.getInt(UnidadBasicaRecursoDO.UNIDAD_BASICA_ID));
		ret.setUnidadBasicaRef(refUniBas);

		return (UnidadBasicaRecursoDO) dtaSession.add(ret);
	}
	//-------------------------------------------------------------------------------------------------------------------------
	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
	    checkClass(dataObject, UnidadBasicaRecursoDO.class, CHECK_UPDATE);

	    UnidadBasicaRecursoDO unidadBasicaRecursoDO = (UnidadBasicaRecursoDO) dataObject;

	    StringBuffer strbuf = new StringBuffer();

	    strbuf.append("UPDATE ");
	    strbuf.append(getTableName());
	    strbuf.append(" SET ");

	    strbuf.append(UnidadBasicaRecursoDO.CANTIDAD);
	    strbuf.append(" = ");
	    strbuf.append(unidadBasicaRecursoDO.getCantidad());
	    
	    strbuf.append(", ");
	    	    
	    strbuf.append(UnidadBasicaRecursoDO.RECURSO_ID);
	    strbuf.append(" = ");
	    Reference<IRecursoDO> refRec = unidadBasicaRecursoDO.getRecursoRef();
	    refRec.checkUpdate();
	    strbuf.append(refRec.getIdAsString());
	    
	    strbuf.append(", ");
	    
	    strbuf.append(UnidadBasicaRecursoDO.UNIDAD_BASICA_ID);
	    strbuf.append(" = ");
	    Reference<IUnidadBasicaDO> refUnidBas = unidadBasicaRecursoDO.getUnidadBasicaRef();
	    refUnidBas.checkUpdate();
	    strbuf.append(refUnidBas.getIdAsString());
	    
	    strbuf.append(" WHERE ");
	    strbuf.append(UnidadBasicaDO.ID);
	    strbuf.append(" = ");
	    strbuf.append(unidadBasicaRecursoDO.getId());

	    System.err.println(strbuf.toString());

	    connection.createStatement().execute(strbuf.toString());

	}
	//--------------------------------------------------------------------------------------------------------------------------
	public List<IUnidadBasicaRecursoDO> listByRecursoId(int recursoId) throws SQLException {
		
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(UnidadBasicaRecursoDO.RECURSO_ID);
		strbuf.append(" = ");
		strbuf.append(recursoId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IUnidadBasicaRecursoDO> ret = new ArrayList<IUnidadBasicaRecursoDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}
	

	public List<IUnidadBasicaRecursoDO> listByUnidadBasicaId(int unidadBasicaId) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(UnidadBasicaRecursoDO.UNIDAD_BASICA_ID);
		strbuf.append(" = ");
		strbuf.append(unidadBasicaId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IUnidadBasicaRecursoDO> ret = new ArrayList<IUnidadBasicaRecursoDO>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
	}

	@Override
	public void loadRecursoRef(IUnidadBasicaRecursoDO unidadBasicaRecursoDO)
			throws SQLException {
		checkClass(unidadBasicaRecursoDO, UnidadBasicaRecursoDO.class, CHECK_UPDATE);

	    RecursoDAO recursoDAO = new RecursoDAO();
	    recursoDAO.init(connectionBean);

	    Reference<IRecursoDO> ref = unidadBasicaRecursoDO.getRecursoRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	    RecursoDO recursoDO = //
	    (RecursoDO) recursoDAO.loadById(ref.getRefIdent());

	    ref.setRefValue(recursoDO);
	}

	@Override
	public void loadUnidadBasicaRef(IUnidadBasicaRecursoDO unidadBasicaRecursoDO)
			throws SQLException {
		
		checkClass(unidadBasicaRecursoDO, UnidadBasicaRecursoDO.class, CHECK_UPDATE);

	    UnidadBasicaDAO unidadBasicaDAO = new UnidadBasicaDAO();
	    unidadBasicaDAO.init(connectionBean);

	    Reference<IUnidadBasicaDO> ref = unidadBasicaRecursoDO.getUnidadBasicaRef();

	    if (ref.getRefIdent() == 0) {
	      return;
	    }

	    UnidadBasicaDO unidadBasicaDO = //
	    (UnidadBasicaDO) unidadBasicaDAO.loadById(ref.getRefIdent());

	    ref.setRefValue(unidadBasicaDO);
		
		
	}

}
