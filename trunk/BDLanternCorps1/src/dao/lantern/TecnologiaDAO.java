package dao.lantern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.FactoryDAO;
import dao.api.Reference;
import lcaInterfaceDAO.ITecnologiaDAO;
import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.IUnidadBasicaDO;

public class TecnologiaDAO extends BaseDAO implements ITecnologiaDAO {

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

		TecnologiaPersonajeDAO tecnologiaPersonajeDAO = new TecnologiaPersonajeDAO();
		// TecnologiaRecursoDAO tecnologiaRecursoDAO = new
		// TecnologiaRecursoDAO();
		tecnologiaPersonajeDAO.init(connectionBean);

		AndroideDAO androideDAO = new AndroideDAO();
		androideDAO.init(connectionBean);

		UnidadBasicaDAO unidadBasicaDAO = new UnidadBasicaDAO();
		unidadBasicaDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(TecnologiaDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(TecnologiaDO.NOMBRE);
		strbuf.append(" VARCHAR(100)    ");
		// strbuf.append(TecnologiaDO.UNIDAD_BASICA_ID);
		// strbuf.append(" INT REFERENCES    ");
		// strbuf.append(unidadBasicaDAO.getTableName());
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
		checkClass(dataObject, TecnologiaDO.class, CHECK_DELETE);

		TecnologiaDO tecnologiaDO = (TecnologiaDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(TecnologiaDO.ID);
		strbuf.append(" = ");
		strbuf.append(tecnologiaDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);
	}

	@Override
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, TecnologiaDO.class, CHECK_INSERT);

		TecnologiaDO tecnologiaDO = (TecnologiaDO) dataObject;

		tecnologiaDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(tecnologiaDO.getId()); // INSTANCIA
		strbuf.append(", ");
		strbuf.append(singleQuotes(tecnologiaDO.getNombre()));
		// strbuf.append(", ");
		// strbuf.append(tecnologiaDO.getAndroideList());
		// strbuf.append(", ");
		// strbuf.append(tecnologiaDO.getTecnologiaPersonajeList());
		// strbuf.append(", ");
		// strbuf.append(tecnologiaDO.getTecnologiaRecursoList());

		strbuf.append(")");

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.add(dataObject);

	}

	// --------------------------------------------------------------------------------------------------------------

	public void loadUnidadBasicaRef(ITecnologiaDO tecnologiaDO)
			throws SQLException {

		checkClass(tecnologiaDO, TecnologiaDO.class, CHECK_UPDATE);

		UnidadBasicaDAO unidadBasicaDAO = new UnidadBasicaDAO();
		unidadBasicaDAO.init(connectionBean);

		Reference<IUnidadBasicaDO> ref = tecnologiaDO.getUnidadBasicaRef();

		if (ref.getRefIdent() == 0) {
			return;
		}

		UnidadBasicaDO unidadBasicaDO = (UnidadBasicaDO) unidadBasicaDAO
				.loadById(ref.getRefIdent());
		ref.setRefValue(unidadBasicaDO);
	}

	// --------------------------------------------------------------------------------------------------------------

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
		// return null;
	}

	@Override
	public List<DataObject> listAll() throws SQLException {

		return null;
	}

	public List<DataObject> listToBuy(int id) throws Exception {

		// SELECT personajedao.id, tecnologiadao.id FROM
		// tecnologiadao,tecnologiapersonajedao,personajedao WHERE
		// tecnologiapersonajedao.personajeid=personajedao.id AND
		// tecnologiapersonajedao.tecnologiaid<>tecnologiadao.id AND
		// tecnologiapersonajedao.personajeid=personajedao.id OR
		// (tecnologiapersonajedao.tecnologiaid IS NULL);
		TecnologiaPersonajeDAO tecnologiaPersonajeDAO = (TecnologiaPersonajeDAO) //
		FactoryDAO.getDAO(TecnologiaPersonajeDAO.class, connectionBean);
		PersonajeDAO personajeDAO = (PersonajeDAO) //
		FactoryDAO.getDAO(PersonajeDAO.class, connectionBean);

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT " + personajeDAO.getTableName() + ".id, " + getTableName() +".id FROM ");
		strbuf.append(getTableName());
		strbuf.append(", ");
		strbuf.append(tecnologiaPersonajeDAO.getTableName());
		strbuf.append(", ");
		strbuf.append(personajeDAO.getTableName());

		strbuf.append(" WHERE ");
		
		strbuf.append(tecnologiaPersonajeDAO.getTableName());
		strbuf.append("." + TecnologiaPersonajeDO.PERSONAJE_ID);
		strbuf.append(" = ");
		strbuf.append(personajeDAO.getTableName());
		strbuf.append("." + PersonajeDO.ID);
		
		strbuf.append(" AND ");
		
		strbuf.append(tecnologiaPersonajeDAO.getTableName());
		strbuf.append("." + TecnologiaDO.ID);
		strbuf.append(" <> ");
		strbuf.append(getTableName());
		strbuf.append("." + TecnologiaDO.ID);

		strbuf.append(" AND ");

		strbuf.append(tecnologiaPersonajeDAO.getTableName());
		strbuf.append("." + PersonajeDO.ID);
		strbuf.append(" = ");
		strbuf.append(personajeDAO.getTableName());
		strbuf.append("." + PersonajeDO.ID);
		
		strbuf.append(" OR ");
		
		strbuf.append(tecnologiaPersonajeDAO.getTableName());
		strbuf.append("." + TecnologiaDO.ID);
		strbuf.append(" IS NULL ");
		
		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());
		System.err.println(strbuf.toString());

		List<DataObject> ret = new ArrayList<DataObject>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}
		return ret;

	}

	public List<DataObject> listTecnologia(int claseid)
			throws ClassNotFoundException, Exception {

		TecnologiaPersonajeDAO tecnologiaPersonajeDAO = (TecnologiaPersonajeDAO) FactoryDAO
				.getDAO( //
						TecnologiaPersonajeDAO.class, connectionBean);

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT " + getTableName() + ".* FROM ");
		strbuf.append(getTableName());
		strbuf.append(" RIGHT JOIN  ");
		strbuf.append(tecnologiaPersonajeDAO.getTableName());
		strbuf.append(" ON ");
		strbuf.append(getTableName());
		strbuf.append("." + PersonajeDO.ID);
		strbuf.append(" = ");
		strbuf.append(tecnologiaPersonajeDAO.getTableName());
		strbuf.append("." + TecnologiaPersonajeDO.TECNOLOGIA_ID);
		strbuf.append(" WHERE ");
		strbuf.append(TecnologiaPersonajeDO.PERSONAJE_ID);
		strbuf.append(" = ");
		strbuf.append(claseid);
		// strbuf.append(" AND ");
		// strbuf.append(getTableName());
		// strbuf.append("." + HabilidadDO.ID);
		// strbuf.append(">25 ");

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());
		System.err.println(strbuf.toString());

		List<DataObject> ret = new ArrayList<DataObject>();

		while (rs.next()) {
			ret.add(resultSetToDO(rs));
		}

		return ret;
		// return null;
	}

	// SELECT habilidad.* FROM habilidad RIGHT JOIN habilidadclaselinterna ON
	// habilidad.id=habilidadclaselinterna.habilidadid
	// WHERE habilidadclaselinterna.claselinternaid= dado AND habilidad.id>25;
	@Override
	public DataObject loadById(int id) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(TecnologiaDO.ID);
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
	public ITecnologiaDO loadByNombre(String nombre) throws SQLException {
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(TecnologiaDO.NOMBRE);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(nombre));

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		if (rs.next()) {
			return resultSetToDO(rs);
		}

		return null;

	}

	// public List<ITecnologiaDO> listByAndroideId(int androideId) throws
	// SQLException{

	// }

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, HabilidadDO.class, CHECK_UPDATE);

		HabilidadDO habilidadDO = (HabilidadDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(HabilidadDO.NOMBRE);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(habilidadDO.getNombre()));

		strbuf.append(", ");

		strbuf.append(HabilidadDO.COSTO_DE_APRENDIZAJE);
		strbuf.append(" = ");
		strbuf.append(habilidadDO.getCosto_de_aprendizaje());

		strbuf.append(", ");

		strbuf.append(HabilidadDO.TIPO);
		strbuf.append(" = ");
		strbuf.append(habilidadDO.getTipo());

		strbuf.append(" WHERE ");
		strbuf.append(HabilidadDO.ID);
		strbuf.append(" = ");
		strbuf.append(habilidadDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

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

	private TecnologiaDO resultSetToDO(ResultSet rs) throws SQLException {
		TecnologiaDO ret = //
		(TecnologiaDO) dtaSession.getDtaByKey( //
				TecnologiaDO.class, rs.getInt(HabilidadDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new TecnologiaDO();

		ret.setId/*     */(rs.getInt(TecnologiaDO.ID));
		ret.setNombre/*   */(rs.getString(TecnologiaDO.NOMBRE));

		return (TecnologiaDO) dtaSession.add(ret);
	}

	public void loadTecnologiaPersonajeList(ITecnologiaDO tecnologiaDO)
			throws Exception {
		checkCache(tecnologiaDO, CHECK_UPDATE);

		TecnologiaPersonajeDAO tecnologiaPersonajeDAO = (TecnologiaPersonajeDAO) FactoryDAO
				.getDAO( //
						TecnologiaPersonajeDAO.class, connectionBean);

		tecnologiaDO.setTecnologiaPersonajeList(tecnologiaPersonajeDAO
				.listByTecnologiaId(tecnologiaDO.getId()));
	}

	public void loadTecnologiaRecursoList(ITecnologiaDO tecnologiaDO)
			throws Exception {
		checkCache(tecnologiaDO, CHECK_UPDATE);

		TecnologiaRecursoDAO tecnologiaRecursoDAO = (TecnologiaRecursoDAO) FactoryDAO
				.getDAO( //
						TecnologiaRecursoDAO.class, connectionBean);

		tecnologiaDO.setTecnologiaRecursoList(tecnologiaRecursoDAO
				.listByRecursoId(tecnologiaDO.getId()));
	}

}
