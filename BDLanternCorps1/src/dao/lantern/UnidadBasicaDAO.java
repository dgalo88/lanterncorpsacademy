package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.IUnidadBasicaDAO;
import lcaInterfaceDAO.IUnidadBasicaDO;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.FactoryDAO;
import dao.api.Reference;

public class UnidadBasicaDAO extends BaseDAO implements IUnidadBasicaDAO {

	public UnidadBasicaDAO() {

	}

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

		TecnologiaDAO tecnologiaDAO = new TecnologiaDAO();
		tecnologiaDAO.init(connectionBean);

		UnidadEjercitoDAO unidadEjercitoDAO = new UnidadEjercitoDAO();
		unidadEjercitoDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(UnidadBasicaDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(UnidadBasicaDO.NOMBRE);
		strbuf.append(" VARCHAR(50) UNIQUE,    ");
		strbuf.append(UnidadBasicaDO.DEFENSA);
		strbuf.append(" INT,   ");
		strbuf.append(UnidadBasicaDO.ATAQUE);
		strbuf.append(" INT,   ");
		strbuf.append(UnidadBasicaDO.TIPO);
		strbuf.append(" INT,   ");
		strbuf.append(UnidadBasicaDO.IMAGEN_UNIDAD_BASICA);
		strbuf.append(" VARCHAR(400),   ");
		strbuf.append(UnidadBasicaDO.TECNOLOGIA_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(tecnologiaDAO.getTableName());
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

	public void delete(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_DELETE);
		checkClass(dataObject, UnidadBasicaDO.class, CHECK_DELETE);

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

	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, UnidadBasicaDO.class, CHECK_INSERT);

		UnidadBasicaDO unidadBasicaDO = (UnidadBasicaDO) dataObject;

		unidadBasicaDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(unidadBasicaDO.getId());
		strbuf.append(", ");
		strbuf.append(singleQuotes(unidadBasicaDO.getNombre()));
		strbuf.append(", ");
		strbuf.append(unidadBasicaDO.getDefensa());
		strbuf.append(", ");
		strbuf.append(unidadBasicaDO.getAtaque());
		strbuf.append(", ");
		strbuf.append(unidadBasicaDO.getTipo());
		strbuf.append(", ");
		strbuf.append(unidadBasicaDO.getImagenUnidadBasica());
		strbuf.append(", ");

		Reference<ITecnologiaDO> ref = unidadBasicaDO.getTecnologiaRef();
		ref.checkInsert();
		strbuf.append(ref.getIdAsString());

		strbuf.append(")");

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.add(dataObject);

	}

	public List<DataObject> listToBuy(int id) throws Exception {

		UnidadBasicaPersonajeDAO unidadBasicaPersonajeDAO = (UnidadBasicaPersonajeDAO) //
		FactoryDAO.getDAO(UnidadBasicaPersonajeDAO.class, connectionBean);
		PersonajeDAO personajeDAO = (PersonajeDAO) //
		FactoryDAO.getDAO(PersonajeDAO.class, connectionBean);

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT distinct " + getTableName() + ".* FROM ");
		strbuf.append(personajeDAO.getTableName());
		strbuf.append(", ");
		strbuf.append(getTableName());
		strbuf.append(", ");
		strbuf.append(unidadBasicaPersonajeDAO.getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(getTableName());
		strbuf.append("." + UnidadBasicaDO.ID);
		strbuf.append(" = ");
		strbuf.append(unidadBasicaPersonajeDAO.getTableName());
		strbuf.append("." + UnidadBasicaPersonajeDO.UNIDAD_BASICA_ID);

		strbuf.append(" AND ");
		strbuf.append(personajeDAO.getTableName());
		strbuf.append("." + PersonajeDO.ID);
		strbuf.append(" = ");
		strbuf.append(id);

		strbuf.append(" AND ");
		strbuf.append(personajeDAO.getTableName());
		strbuf.append("." + PersonajeDO.ID);
		strbuf.append(" = ");
		strbuf.append(unidadBasicaPersonajeDAO.getTableName());
		strbuf.append("." + UnidadBasicaPersonajeDO.PERSONAJE_ID);

		strbuf.append(" AND ");
		strbuf.append(getTableName());
		strbuf.append("." + UnidadBasicaDO.ID);
		strbuf.append(" <> ");
		strbuf.append(unidadBasicaPersonajeDAO.getTableName());
		strbuf.append("." + UnidadBasicaPersonajeDO.UNIDAD_BASICA_ID);

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());
		System.err.println(strbuf.toString());

		List<DataObject> ret = new ArrayList<DataObject>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}
		return ret;

	}

	public void loadUnidadBasicaRecursoList(IUnidadBasicaDO unidadBasicaDO)
			throws Exception {
		checkCache(unidadBasicaDO, CHECK_UPDATE);

		UnidadBasicaRecursoDAO unidadBasicaRecursoDAO = (UnidadBasicaRecursoDAO) FactoryDAO
				.getDAO( //
						UnidadBasicaRecursoDAO.class, connectionBean);

		unidadBasicaDO.setUnidadBasicaRecursoList(unidadBasicaRecursoDAO
				.listByUnidadBasicaId(unidadBasicaDO.getId()));
	}

	public void loadUnidadBasicaPersonajeList(IUnidadBasicaDO unidadBasicaDO)
			throws Exception {
		checkCache(unidadBasicaDO, CHECK_UPDATE);

		UnidadBasicaPersonajeDAO unidadBasicaPersonajeDAO = (UnidadBasicaPersonajeDAO) FactoryDAO
				.getDAO( //
						UnidadBasicaPersonajeDAO.class, connectionBean);

		unidadBasicaDO.setUnidadBasicaPersonajeList(unidadBasicaPersonajeDAO
				.listByPersonajeId(unidadBasicaDO.getId()));

	}

	public void loadTecnologiaRef(IUnidadBasicaDO unidadBasicaDO)
			throws Exception {

		checkClass(unidadBasicaDO, UnidadBasicaDO.class, CHECK_UPDATE);

		TecnologiaDAO tecnologiaDAO = new TecnologiaDAO();
		tecnologiaDAO.init(connectionBean);

		Reference<ITecnologiaDO> ref = unidadBasicaDO.getTecnologiaRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		TecnologiaDO tecnologiaDO = //
		(TecnologiaDO) tecnologiaDAO.loadById(ref.getRefIdent());

		ref.setRefValue(tecnologiaDO);
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

	private DataObject resultSetToDO(ResultSet rs) throws SQLException {
		UnidadBasicaDO ret = //
		(UnidadBasicaDO) dtaSession.getDtaByKey( //
				UnidadBasicaDO.class, rs.getInt(UnidadBasicaDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new UnidadBasicaDO();

		ret.setId/*      */(rs.getInt(UnidadBasicaDO.ID));
		ret.setNombre/*  */(rs.getString(UnidadBasicaDO.NOMBRE));
		ret.setDefensa/* */(rs.getInt(UnidadBasicaDO.DEFENSA));
		ret.setAtaque/*  */(rs.getInt(UnidadBasicaDO.ATAQUE));
		ret.setTipo/*    */(rs.getInt(UnidadBasicaDO.TIPO));
		ret.setImagenUnidadBasica/*    */(rs.getString(UnidadBasicaDO.IMAGEN_UNIDAD_BASICA));

		Reference<ITecnologiaDO> refTec = new Reference<ITecnologiaDO>();

		refTec.setRefIdent(rs.getInt(UnidadBasicaDO.TECNOLOGIA_ID));

		return (UnidadBasicaDO) dtaSession.add(ret);
	}

	public List<DataObject> listAll() throws SQLException {
		return listAll(-1, -1);
	}

	public DataObject loadById(int id) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(UnidadBasicaDO.ID);
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

	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, UnidadBasicaDO.class, CHECK_UPDATE);

		UnidadBasicaDO unidadBasicaDO = (UnidadBasicaDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(UnidadBasicaDO.NOMBRE);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(unidadBasicaDO.getNombre()));
		strbuf.append(", ");

		strbuf.append(UnidadBasicaDO.DEFENSA);
		strbuf.append(" = ");
		strbuf.append(unidadBasicaDO.getDefensa());
		strbuf.append(", ");

		strbuf.append(UnidadBasicaDO.ATAQUE);
		strbuf.append(" = ");
		strbuf.append(unidadBasicaDO.getAtaque());
		strbuf.append(", ");

		strbuf.append(UnidadBasicaDO.TIPO);
		strbuf.append(" = ");
		strbuf.append(unidadBasicaDO.getTipo());
		strbuf.append(", ");
		
		strbuf.append(UnidadBasicaDO.IMAGEN_UNIDAD_BASICA);
		strbuf.append(" = ");
		strbuf.append(unidadBasicaDO.getImagenUnidadBasica());
		strbuf.append(", ");

		strbuf.append(UnidadBasicaDO.TECNOLOGIA_ID);
		strbuf.append(" = ");

		Reference<ITecnologiaDO> refTec = unidadBasicaDO.getTecnologiaRef();
		refTec.checkUpdate();
		strbuf.append(refTec.getIdAsString());

		strbuf.append(" WHERE ");
		strbuf.append(UnidadBasicaDO.ID);
		strbuf.append(" = ");
		strbuf.append(unidadBasicaDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

	}

}
