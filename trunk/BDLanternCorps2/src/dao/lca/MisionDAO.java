package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IMisionDAO;
import lcaInterfaceDAO.IMisionDO;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.FactoryDAO;

public class MisionDAO extends BaseDAO implements IMisionDAO{

	public MisionDAO() {
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

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(MisionDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(MisionDO.NOMBRE);
		strbuf.append(" VARCHAR(100) UNIQUE NOT NULL,    ");
		strbuf.append(MisionDO.DESCRIPCION);
		strbuf.append(" VARCHAR(100) NOT NULL,     ");
		strbuf.append(MisionDO.EXPERIENCIA_GANADA);
		strbuf.append(" INT CHECK(" + MisionDO.EXPERIENCIA_GANADA +" > 0 ),     ");
		strbuf.append(MisionDO.PUNTOS_DE_ENTRENAMIENTO_GANADOS);
		strbuf.append(" INT CHECK(" + MisionDO.PUNTOS_DE_ENTRENAMIENTO_GANADOS +" > 0 ),     ");
		strbuf.append(MisionDO.NIVEL_NECESARIO);
		strbuf.append(" INT CHECK(" + MisionDO.NIVEL_NECESARIO +" > 0 )   ");
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
		checkClass(dataObject, MisionDO.class, CHECK_INSERT);

		MisionDO misionDO = (MisionDO) dataObject;

		misionDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(misionDO.getId());
		strbuf.append(", ");
		strbuf.append(singleQuotes(misionDO.getNombre()));
		strbuf.append(", ");
		strbuf.append(singleQuotes(misionDO.getDescripcion()));
		strbuf.append(", ");
		strbuf.append(misionDO.getExperiencia_ganada());
		strbuf.append(", ");
		strbuf.append(misionDO.getPuntos_de_entrenamiento_ganados());
		strbuf.append(", ");
		strbuf.append(misionDO.getNivel_necesario());
		strbuf.append(")");

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.add(dataObject);
	}

	// --------------------------------------------------------------------------------

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, MisionDO.class, CHECK_UPDATE);

		MisionDO misionDO = (MisionDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(MisionDO.NOMBRE);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(misionDO.getNombre()));

		strbuf.append(", ");

		strbuf.append(MisionDO.DESCRIPCION);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(misionDO.getDescripcion()));

		strbuf.append(", ");

		strbuf.append(MisionDO.EXPERIENCIA_GANADA);
		strbuf.append(" = ");
		strbuf.append(misionDO.getExperiencia_ganada());

		strbuf.append(", ");

		strbuf.append(MisionDO.PUNTOS_DE_ENTRENAMIENTO_GANADOS);
		strbuf.append(" = ");
		strbuf.append(misionDO.getPuntos_de_entrenamiento_ganados());

		strbuf.append(", ");

		strbuf.append(MisionDO.NIVEL_NECESARIO);
		strbuf.append(" = ");
		strbuf.append(misionDO.getNivel_necesario());

		strbuf.append(" WHERE ");
		strbuf.append(MisionDO.ID);
		strbuf.append(" = ");
		strbuf.append(misionDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());
	}

	// --------------------------------------------------------------------------------

	@Override
	public void delete(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_DELETE);
		checkClass(dataObject, MisionDO.class, CHECK_DELETE);

		MisionDO misionDO = (MisionDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(MisionDO.ID);
		strbuf.append(" = ");
		strbuf.append(misionDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);
	}

	// --------------------------------------------------------------------------------

	@Override
	public DataObject loadById(int id) throws SQLException {
		MisionDO misionDO;

		misionDO = (MisionDO) dtaSession.getDtaByKey(MisionDO.class, id);

		if (misionDO != null) {
			return misionDO;
		} else {
			
			StringBuffer strbuf = new StringBuffer();

			strbuf.append("SELECT * FROM ");
			strbuf.append(getTableName());

			strbuf.append(" WHERE ");
			strbuf.append(MisionDO.ID);
			strbuf.append(" = ");
			strbuf.append(id);

			System.err.println(strbuf.toString());

			ResultSet rs = //
			connection.createStatement().executeQuery(strbuf.toString());

			if (rs.next()) {
				misionDO = resultSetToDO(rs);
				return (MisionDO) dtaSession.add(misionDO);
			}

			return null;
		}
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
		MisionDO mision;

		while (rs.next()) {
			
			mision = (MisionDO) dtaSession.getDtaByKey( //
					MisionDO.class, rs.getInt(MisionDO.ID));

			if (mision == null) {
				mision = (MisionDO) dtaSession.add(resultSetToDO(rs));
			}

			ret.add(mision);
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

	private MisionDO resultSetToDO(ResultSet rs) throws SQLException {
		MisionDO ret = new MisionDO();

		ret.setId(rs.getInt(MisionDO.ID));
		ret.setNombre(rs.getString(MisionDO.NOMBRE));
		ret.setDescripcion(rs.getString(MisionDO.DESCRIPCION));
		ret.setExperiencia_ganada(rs.getInt(MisionDO.EXPERIENCIA_GANADA));
		ret.setPuntos_de_entrenamiento_ganados(rs.getInt(MisionDO.PUNTOS_DE_ENTRENAMIENTO_GANADOS));
		ret.setNivel_necesario(rs.getInt(MisionDO.NIVEL_NECESARIO));

		return ret;
	}

	// --------------------------------------------------------------------------------

	public void loadOrdenList(IMisionDO misionDO) throws Exception {
		checkCache(misionDO, CHECK_UPDATE);
		checkClass(misionDO, MisionDO.class, CHECK_UPDATE);

		OrdenDAO ordenDAO = (OrdenDAO) FactoryDAO.getDAO( //
				OrdenDAO.class, connectionBean);

		misionDO.setOrdenList(ordenDAO.listByMisionId(misionDO.getId()));
	}

	// --------------------------------------------------------------------------------
	
	public void loadMisionPersonajeList(IMisionDO misionDO) throws Exception {
		checkCache(misionDO, CHECK_UPDATE);
		checkClass(misionDO, MisionDO.class, CHECK_UPDATE);

		MisionPersonajeDAO misionPersonajeDAO = (MisionPersonajeDAO) FactoryDAO.getDAO( //
				MisionPersonajeDAO.class, connectionBean);

		misionDO.setMisionPersonajeList(misionPersonajeDAO.listByMisionId(misionDO.getId()));
	}
	
	public List<IMisionDO> listPlayable(int id) throws Exception {
		
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());
		strbuf.append(", personajedao, misionclaselinternadao, misionpersonajedao");
		strbuf.append(" WHERE ");
		
		strbuf.append("personajedao.id");
		strbuf.append(" = ");
		strbuf.append(id);
		
		strbuf.append(" misionpersonajedao.personajeid");
		strbuf.append(" = ");
		strbuf.append("personajedao.id");
	
		strbuf.append(" personajedao.claselinternaid");
		strbuf.append(" = ");
		strbuf.append("misionclaselinternadao.claselinternaid ");
		
		strbuf.append(MisionDO.ID);
		strbuf.append(" = ");
		strbuf.append("misionclaselinternadao.misionid ");

		strbuf.append(MisionDO.ID);
		strbuf.append(" <> ");
		strbuf.append("isionpersonajedao..misionid");
		
		
		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IMisionDO> ret = new ArrayList<IMisionDO>();
		MisionDO mision;

		while (rs.next()) {
			
			mision = (MisionDO) dtaSession.getDtaByKey(MisionDO.class, rs.getInt(MisionDO.ID));

			if (mision == null) {
				mision = (MisionDO) dtaSession.add(resultSetToDO(rs));
			}

			ret.add(mision);
		}

		return ret;
	}

}
