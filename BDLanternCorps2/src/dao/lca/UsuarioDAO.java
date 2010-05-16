package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
import dao.api.FactoryDAO;
import dao.api.Reference;
import dao.lca.UsuarioDO;

public class UsuarioDAO extends BaseDAO {

	public UsuarioDAO() {

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

		PersonajeDAO personajeDAO = new PersonajeDAO();
		personajeDAO.init(connectionBean);

		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(UsuarioDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(UsuarioDO.NOMBRE);
		strbuf.append(" VARCHAR(50) NOT NULL,    ");
		strbuf.append(UsuarioDO.CORREO);
		strbuf.append(" VARCHAR(50) UNIQUE NOT NULL,     ");
		strbuf.append(UsuarioDO.CLAVE);
		strbuf.append(" VARCHAR(20) NOT NULL,     ");
		strbuf.append(UsuarioDO.PERSONAJE_ID);
		strbuf.append(" INT NOT NULL REFERENCES   ");
		strbuf.append(personajeDAO.getTableName());
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
		checkClass(dataObject, UsuarioDO.class, CHECK_INSERT);

		UsuarioDO usuarioDO = (UsuarioDO) dataObject;

		usuarioDO.setId(getNextId());

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("INSERT INTO ");
		strbuf.append(getTableName());
		strbuf.append(" VALUES (");
		strbuf.append(usuarioDO.getId());
		strbuf.append(", ");
		strbuf.append(singleQuotes(usuarioDO.getNombre()));
		strbuf.append(", ");
		strbuf.append(singleQuotes(usuarioDO.getCorreo()));
		strbuf.append(", ");
		strbuf.append(singleQuotes(usuarioDO.getClave()));
		strbuf.append(", ");
		strbuf.append(usuarioDO.getPersonajeRef().getRefIdent());
		strbuf.append(")");

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.add(dataObject);
	}

	// --------------------------------------------------------------------------------

	@Override
	public void update(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_UPDATE);
		checkClass(dataObject, UsuarioDO.class, CHECK_UPDATE);

		UsuarioDO usuarioDO = (UsuarioDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("UPDATE ");
		strbuf.append(getTableName());
		strbuf.append(" SET ");

		strbuf.append(UsuarioDO.NOMBRE);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(usuarioDO.getNombre()));

		strbuf.append(", ");

		strbuf.append(UsuarioDO.CLAVE);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(usuarioDO.getClave()));

		strbuf.append(" WHERE ");
		strbuf.append(UsuarioDO.ID);
		strbuf.append(" = ");
		strbuf.append(usuarioDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());
	}

	// --------------------------------------------------------------------------------

	@Override
	public void delete(DataObject dataObject) throws SQLException {
		checkCache(dataObject, CHECK_DELETE);
		checkClass(dataObject, UsuarioDO.class, CHECK_DELETE);

		UsuarioDO usuarioDO = (UsuarioDO) dataObject;

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("DELETE FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(UsuarioDO.ID);
		strbuf.append(" = ");
		strbuf.append(usuarioDO.getId());

		System.err.println(strbuf.toString());

		connection.createStatement().execute(strbuf.toString());

		dtaSession.del(dataObject);
	}

	// --------------------------------------------------------------------------------

	@Override
	public DataObject loadById(int id) throws SQLException {

		UsuarioDO usuarioDO;

		usuarioDO = (UsuarioDO) dtaSession.getDtaByKey(UsuarioDO.class, id);// VERIFICA
																			// SI
																			// ESTE
																			// ID
																			// ESTA
																			// EN
																			// CACHE

		if (usuarioDO != null) {
			return usuarioDO;
		} else {

			StringBuffer strbuf = new StringBuffer();

			strbuf.append("SELECT * FROM ");
			strbuf.append(getTableName());

			strbuf.append(" WHERE ");
			strbuf.append(UsuarioDO.ID);
			strbuf.append(" = ");
			strbuf.append(id);

			System.err.println(strbuf.toString());

			ResultSet rs = //
			connection.createStatement().executeQuery(strbuf.toString());

			if (rs.next()) {
				usuarioDO = resultSetToDO(rs);
				return (UsuarioDO) dtaSession.add(usuarioDO);
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
		UsuarioDO usuarioDO;

		while (rs.next()) {

			usuarioDO = (UsuarioDO) dtaSession.getDtaByKey( //
					UsuarioDO.class, rs.getInt(UsuarioDO.ID));

			if (usuarioDO == null) {
				usuarioDO = (UsuarioDO) dtaSession.add(resultSetToDO(rs));
			}

			ret.add(usuarioDO);
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

	private UsuarioDO resultSetToDO(ResultSet rs) throws SQLException {
		UsuarioDO ret = new UsuarioDO();

		// if (idInCache(rs.getInt(UsuarioDO.ID), ret)) {
		//
		// return ret;
		//
		// } else {

		ret.setId(rs.getInt(UsuarioDO.ID));
		ret.setNombre(rs.getString(UsuarioDO.NOMBRE));
		ret.setCorreo(rs.getString(UsuarioDO.CORREO));
		ret.setClave(rs.getString(UsuarioDO.CLAVE));
		Reference<PersonajeDO> refp = new Reference<PersonajeDO>();
		refp.setRefIdent(rs.getInt(UsuarioDO.PERSONAJE_ID));
		ret.setPersonajeRef(refp);

		return ret;

		// return (UsuarioDO) dtaSession.add(ret);
		// }

	}

	// --------------------------------------------------------------------------------

	public void loadPersonajeRef(UsuarioDO usuarioDO) throws SQLException {
		if(usuarioDO==null){
			return;
		}

		checkClass(usuarioDO, UsuarioDO.class, CHECK_UPDATE);

		PersonajeDAO personajeDAO = new PersonajeDAO();
		personajeDAO.init(connectionBean);

		Reference<PersonajeDO> ref = usuarioDO.getPersonajeRef();
		if (ref.getRefIdent() == 0) {
			return;
		}

		PersonajeDO personajeDO = //
		(PersonajeDO) personajeDAO.loadById(ref.getRefIdent());

		ref.setRefValue(personajeDO);
	}

	// --------------------------------------------------------------------------------

	public PersonajeDO Login(UsuarioDO usuarioDO) throws SQLException{
		checkCache(usuarioDO, CHECK_INSERT);
		checkClass(usuarioDO, UsuarioDO.class, CHECK_INSERT);
	
		StringBuffer strbuf = new StringBuffer();

		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());

		strbuf.append(" WHERE ");
		strbuf.append(UsuarioDO.CORREO);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(usuarioDO.getCorreo()));
		
		strbuf.append(" AND ");
		
		strbuf.append(UsuarioDO.CLAVE);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(usuarioDO.getClave()));
		

		System.err.println(strbuf.toString());

		ResultSet rs = //
		connection.createStatement().executeQuery(strbuf.toString());
		PersonajeDO personajeDO=new PersonajeDO();
		if(rs.next()){

			
			PersonajeDAO personajeDAO;
			try {
				personajeDAO = (PersonajeDAO) FactoryDAO.getDAO( //
						PersonajeDAO.class, connectionBean);
				usuarioDO = (UsuarioDO) dtaSession.add(resultSetToDO(rs));
				System.out.print(usuarioDO.getId());
				personajeDO= (PersonajeDO) personajeDAO.loadById(usuarioDO.getId());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return personajeDO;
	}
	
	// --------------------------------------------------------------------------------
	
	public boolean checkIfUsuarioExists(String correo) throws SQLException {
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("SELECT * FROM ");
		strbuf.append(getTableName());
		strbuf.append(" WHERE ");
		strbuf.append(UsuarioDO.CORREO);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(correo));
		System.err.println(strbuf.toString());
		ResultSet rs = connection.createStatement().executeQuery(strbuf.toString());
		if (rs.next()) {
			return true;
		}
		return false;
	}
	
	public UsuarioDO loadByCorreo(String mail) throws SQLException {
		    StringBuffer strbuf = new StringBuffer();	
		    strbuf.append("SELECT * FROM ");
		    strbuf.append(getTableName());	
		    strbuf.append(" WHERE ");
		    strbuf.append(UsuarioDO.CORREO);
		    strbuf.append(" = ");
		    strbuf.append(singleQuotes(mail));	
		    System.err.println(strbuf.toString());
		    ResultSet rs = //
		    connection.createStatement().executeQuery(strbuf.toString());	
		    if (rs.next()) {
		      return resultSetToDO(rs);
		    }	
		    return null;
	}
	
}
