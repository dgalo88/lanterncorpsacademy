package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IGrupoDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDO;
import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.FactoryDAO;
import dao.api.Reference;

public class PersonajeDAO extends BaseDAO implements IPersonajeDAO {

	public PersonajeDAO() {
		// Empty
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

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.init(connectionBean);
		PlanetaDAO planetaDAO = new PlanetaDAO();
		planetaDAO.init(connectionBean);
		GrupoDAO grupoDAO = new GrupoDAO();
		grupoDAO.init(connectionBean);
		ClaseLinternaDAO claseLinternaDAO = new ClaseLinternaDAO();
		claseLinternaDAO.init(connectionBean);

		// ----------------------------------------

		strbuf = new StringBuffer();
		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(PersonajeDO.ID);
		strbuf.append(" INT PRIMARY KEY,	");
		strbuf.append(PersonajeDO.ALIAS);
		strbuf.append(" VARCHAR(20) UNIQUE NOT NULL,	");
		strbuf.append(PersonajeDO.EXPERIENCIA);
		strbuf.append(" INT DEFAULT 0,	");
		strbuf.append(PersonajeDO.PUNTOS_DE_ENTRENAMIENTO);
		strbuf.append(" INT DEFAULT 0,	");
		strbuf.append(PersonajeDO.SALUD);
		strbuf.append(" INT CHECK (" + PersonajeDO.SALUD
				+ " >= 0 ) DEFAULT 200,	");
		strbuf.append(PersonajeDO.ENERGIA_DEL_ANILLO);
		strbuf.append(" INT DEFAULT 100,	");
		strbuf.append(PersonajeDO.NIVEL);
		strbuf.append(" INT DEFAULT 1,	");
		strbuf.append(PersonajeDO.ULTIMA_FECHA_INGRESO);
		strbuf.append(" DATE DEFAULT current_date ,	");
		strbuf.append(PersonajeDO.PLANETA_ID);
		strbuf.append(" INT REFERENCES	");
		strbuf.append(planetaDAO.getTableName());
		strbuf.append(",");
		strbuf.append(PersonajeDO.GRUPO_ID);
		strbuf.append(" INT REFERENCES	");
		strbuf.append(grupoDAO.getTableName());
		strbuf.append(",");
		strbuf.append(PersonajeDO.CLASE_LINTERNA_ID);
		strbuf.append(" INT REFERENCES	");
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
	public void insert(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_INSERT);
		checkClass(dataObject, PersonajeDO.class, CHECK_INSERT);

		PersonajeDO personajeDO = (PersonajeDO) dataObject;
		personajeDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(PersonajeDO.ID);
		strbuf.append(", ");
		strbuf.append(PersonajeDO.ALIAS);
		strbuf.append(", ");
		strbuf.append(PersonajeDO.PLANETA_ID);
		strbuf.append(", ");
		strbuf.append(PersonajeDO.CLASE_LINTERNA_ID);
		strbuf.append(") ");
		strbuf.append(" VALUES (");
		strbuf.append(personajeDO.getId());
		strbuf.append(", ");
		strbuf.append(singleQuotes(personajeDO.getAlias()));
		strbuf.append(", ");
		Reference<IPlanetaDO> ref = personajeDO.getPlanetaRef();
		ref.checkInsert();
		strbuf.append(ref.getIdAsString());
		strbuf.append(", ");
		Reference<IClaseLinternaDO> ref1 = personajeDO.getClaseLinternaRef();
		ref1.checkInsert();
		strbuf.append(ref1.getIdAsString());

		strbuf.append(")");
		System.err.println(strbuf.toString());
		connection.createStatement().execute(strbuf.toString());
		dtaSession.add(dataObject);
	}

	// --------------------------------------------------------------------------------

	@Override
	public void update(DataObject dataObject) throws SQLException {

		//checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, PersonajeDO.class, CHECK_UPDATE);
		
		PersonajeDO personajeDO = (PersonajeDO) dataObject;
		
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");
		strbuf.append(PersonajeDO.EXPERIENCIA);
		strbuf.append(" = ");
		strbuf.append(personajeDO.getExperiencia());
		strbuf.append(", ");

		strbuf.append(PersonajeDO.PUNTOS_DE_ENTRENAMIENTO);
		strbuf.append(" = ");
		strbuf.append(personajeDO.getPuntosDeEntrenamiento());
		strbuf.append(", ");

		strbuf.append(PersonajeDO.SALUD);
		strbuf.append(" = ");
		strbuf.append(personajeDO.getSalud());
		strbuf.append(", ");

		strbuf.append(PersonajeDO.ENERGIA_DEL_ANILLO);
		strbuf.append(" = ");
		strbuf.append(personajeDO.getEnergiaDelAnillo());
		strbuf.append(", ");

		strbuf.append(PersonajeDO.NIVEL);
		strbuf.append(" = ");
		strbuf.append(personajeDO.getNivel());
		strbuf.append(", ");

		strbuf.append(PersonajeDO.ULTIMA_FECHA_INGRESO);
		strbuf.append(" = current_date,	");

		strbuf.append(PersonajeDO.PLANETA_ID);
		strbuf.append(" = ");
		Reference<IPlanetaDO> ref1 = personajeDO.getPlanetaRef();
		ref1.checkUpdate();
		strbuf.append(ref1.getIdAsString());
		strbuf.append(", ");

		strbuf.append(PersonajeDO.GRUPO_ID);
		strbuf.append(" = ");
		Reference<IGrupoDO> ref2 = personajeDO.getGrupoRef();
		ref2.checkUpdate();
		strbuf.append(ref2.getIdAsString());

		strbuf.append(" WHERE ");
		strbuf.append(PersonajeDO.ID);
		strbuf.append(" = ");
		strbuf.append(personajeDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());
	}

	// --------------------------------------------------------------------------------

	@Override
	public void delete(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_DELETE);
		checkClass(dataObject, PersonajeDO.class, CHECK_DELETE);

		PersonajeDO personajeDO = (PersonajeDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(PersonajeDO.ID);
		strbuf.append(" = ");
		strbuf.append(personajeDO.getId());

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
		strbuf.append(PersonajeDO.ID);
		strbuf.append(" = ");
		strbuf.append(id);

		System.err.println(strbuf.toString());
		ResultSet rs = connection.createStatement().executeQuery(
				strbuf.toString());

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
		ResultSet rs = connection.createStatement().executeQuery(
				strbuf.toString());

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

	private PersonajeDO resultSetToDO(ResultSet rs) throws SQLException {

		PersonajeDO ret = (PersonajeDO) dtaSession.getDtaByKey( //
				PersonajeDO.class, rs.getInt(PersonajeDO.ID));

		if (ret != null) {
			return ret;
		}

		ret = new PersonajeDO();
		ret.setId(rs.getInt(PersonajeDO.ID));
		ret.setAlias(rs.getString(PersonajeDO.ALIAS));
		ret.setExperiencia(rs.getInt(PersonajeDO.EXPERIENCIA));
		ret.setPuntosDeEntrenamiento(rs
				.getInt(PersonajeDO.PUNTOS_DE_ENTRENAMIENTO));
		ret.setSalud(rs.getInt(PersonajeDO.SALUD));
		ret.setEnergiaDelAnillo(rs.getInt(PersonajeDO.ENERGIA_DEL_ANILLO));
		ret.setNivel(rs.getInt(PersonajeDO.NIVEL));
		ret.setUltimaFechaIngreso(rs.getDate(PersonajeDO.ULTIMA_FECHA_INGRESO));
		Reference<IPlanetaDO> ref1 = new Reference<IPlanetaDO>();
		ref1.setRefIdent(rs.getInt(PersonajeDO.PLANETA_ID));
		ret.setPlanetaRef(ref1);
		Reference<IGrupoDO> ref2 = new Reference<IGrupoDO>();
		ref2.setRefIdent(rs.getInt(PersonajeDO.GRUPO_ID));
		ret.setGrupoRef(ref2);
		Reference<IClaseLinternaDO> ref3 = new Reference<IClaseLinternaDO>();
		ref3.setRefIdent(rs.getInt(PersonajeDO.CLASE_LINTERNA_ID));
		ret.setClaseLinternaRef(ref3);

		return (PersonajeDO) dtaSession.add(ret);
	}

	// --------------------------------------------------------------------------------

	public void loadClaseLinternaRef(IPersonajeDO personajeDO)
			throws SQLException {

		checkClass(personajeDO, PersonajeDO.class, CHECK_UPDATE);
		ClaseLinternaDAO claseLinternaDAO = new ClaseLinternaDAO();
		claseLinternaDAO.init(connectionBean);
		Reference<IClaseLinternaDO> ref = personajeDO.getClaseLinternaRef();
		if (ref.getRefIdent() == 0) {
			return;
		}
		ClaseLinternaDO claseLinternaDO = (ClaseLinternaDO) claseLinternaDAO
				.loadById(ref.getRefIdent());
		ref.setRefValue(claseLinternaDO);
	}

	// --------------------------------------------------------------------------------

	public void loadPlanetaRef(IPersonajeDO personajeDO) throws SQLException {

		checkClass(personajeDO, PersonajeDO.class, CHECK_UPDATE);
		PlanetaDAO planetaDAO = new PlanetaDAO();
		planetaDAO.init(connectionBean);
		Reference<IPlanetaDO> ref = personajeDO.getPlanetaRef();
		if (ref.getRefIdent() == 0) {
			return;
		}
		PlanetaDO planetaDO = (PlanetaDO) planetaDAO
				.loadById(ref.getRefIdent());
		ref.setRefValue(planetaDO);
	}

	// --------------------------------------------------------------------------------

	public void loadGrupoRef(IPersonajeDO personajeDO) throws SQLException {

		checkClass(personajeDO, PersonajeDO.class, CHECK_UPDATE);
		GrupoDAO grupoDAO = new GrupoDAO();
		grupoDAO.init(connectionBean);
		Reference<IGrupoDO> ref = personajeDO.getGrupoRef();
		if (ref.getRefIdent() == 0) {
			return;
		}
		GrupoDO grupoDO = (GrupoDO) grupoDAO.loadById(ref.getRefIdent());
		ref.setRefValue(grupoDO);
	}

	// --------------------------------------------------------------------------------

	public void loadMisionPersonajeList(IPersonajeDO personajeDO)
			throws Exception {
		checkCache(personajeDO, CHECK_UPDATE);
		MisionPersonajeDAO misionPersonaDAO = (MisionPersonajeDAO) FactoryDAO
				.getDAO(MisionPersonajeDAO.class, connectionBean);

		personajeDO.setMisionPersonajelist(misionPersonaDAO
				.listByPersonajeId(personajeDO.getId()));

	}

	// --------------------------------------------------------------------------------

	public void loadHabilidadActivaList(IPersonajeDO personajeDO)
			throws Exception {
		//checkCache(personajeDO, CHECK_UPDATE);
		HabilidadActivaDAO habilidadActivaDAO = (HabilidadActivaDAO) FactoryDAO
				.getDAO(HabilidadActivaDAO.class, connectionBean);

		personajeDO.setHabilidadActivaList(habilidadActivaDAO
				.listByPersonajeId(personajeDO.getId()));

	}

	// --------------------------------------------------------------------------------

	public List<IPersonajeDO> listByClaseLinternaId(int claseLinternaId)
			throws SQLException {

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(PersonajeDO.CLASE_LINTERNA_ID);
		strbuf.append(" = ");
		strbuf.append(claseLinternaId);

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IPersonajeDO> ret = new ArrayList<IPersonajeDO>();
		PersonajeDO per;

		while (rs.next()) {
			per = (PersonajeDO) dtaSession.getDtaByKey( //
					PersonajeDO.class, rs.getInt(PersonajeDO.ID));

			if (per == null) {
				per = (PersonajeDO) dtaSession.add(resultSetToDO(rs));
			}

			ret.add(per);
		}

		return ret;
	}

	// --------------------------------------------------------------------------------

	
	//funcion usada para el caso de uso ver clasificacion (Listar mejores jugadores)
	//esta funcion devuelve una lista de personajes ordenada de manera dependiendo de la posicion 
	//La tabla que se quiere mostrar debe tener Posicion alias nivel y clase 
	//la posicion la colocas segun El orden en que se encuentren en la lista y para la clase 
	//solo tienes el id pero se decidio trabajarlo arriba ya que son 7 clases nada mas ...
	//Ej si el Id es 1 es linterna verde ... (Buscar el orden en q se encuentran en la BD)
	
	public List<IPersonajeDO> listRankin() throws SQLException {
		
		StringBuffer strbuf = new StringBuffer();
		
		strbuf.append("SELECT	");
		strbuf.append("* FROM ");
		strbuf.append(getTableName());
		strbuf.append(" ORDER BY nivel, experiencia");
		System.err.println(strbuf.toString());
		
		ResultSet rs = connection.createStatement().executeQuery(strbuf.toString());
		
		List<IPersonajeDO> ret = new ArrayList<IPersonajeDO>();
		PersonajeDO per;

		while (rs.next()) {
			per = resultSetToDO(rs);
			loadClaseLinternaRef(per);
			ret.add(per);
		}

		return ret;
	}
	
	// --------------------------------------------------------------------------------
	
	public boolean checkIfAliasExists(String alias) throws SQLException {
        
		StringBuffer strbuf = new StringBuffer();
        strbuf.append("SELECT * FROM ");
        strbuf.append(getTableName());
        strbuf.append(" WHERE ");
        strbuf.append(PersonajeDO.ALIAS);
        strbuf.append(" = ");
        strbuf.append(singleQuotes(alias));
        System.err.println(strbuf.toString());

        ResultSet rs = connection.createStatement().executeQuery(strbuf.toString());

        if(rs.next()) {
                return true;
        }
		return false;
	}

	// --------------------------------------------------------------------------------
	
	public IPersonajeDO loadByAlias(String alias) throws SQLException {
	    
		StringBuffer strbuf = new StringBuffer();
	    strbuf.append("SELECT * FROM ");
	    strbuf.append(getTableName());
	    strbuf.append(" WHERE ");
	    strbuf.append(PersonajeDO.ALIAS);
	    strbuf.append(" = ");
	    strbuf.append(singleQuotes(alias));
	    System.err.println(strbuf.toString());

	    ResultSet rs = //
	    connection.createStatement().executeQuery(strbuf.toString());
	    if (rs.next()) {
	      return resultSetToDO(rs);
	    }
	    return null;
	}
	
	
	//Metodo recibe el id del personaje del planeta actual y de la clase a la que pertenece y
	//retorna la lista de personajes a atacar ordenados por el nivel de manera ascendente
	@Override
	public List<IPersonajeDO> listContrincantes(int personajeId, int claseId, int planetaId) throws SQLException {
	
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());
		strbuf.append(" WHERE ");
		strbuf.append(PersonajeDO.CLASE_LINTERNA_ID);
		strbuf.append(" <> ");
		strbuf.append(claseId);
		strbuf.append(" AND ");
		strbuf.append(PersonajeDO.PLANETA_ID);
		strbuf.append(" = ");
		strbuf.append(planetaId);
		strbuf.append(" AND ");
		strbuf.append(PersonajeDO.ID);
		strbuf.append(" <> ");
		strbuf.append(personajeId);
		strbuf.append(" ORDER BY ");
		strbuf.append(PersonajeDO.NIVEL);
		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());

		List<IPersonajeDO> ret = new ArrayList<IPersonajeDO>();
		PersonajeDO per;

		while (rs.next()) {
			per = (PersonajeDO) dtaSession.getDtaByKey( //
					PersonajeDO.class, rs.getInt(PersonajeDO.ID));

			if (per == null) {
				per = (PersonajeDO) dtaSession.add(resultSetToDO(rs));
			}

			ret.add(per);
		}

		return ret;
	}

}
