package dao.lca;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.api.BaseDAO;
import dao.api.DataObject;
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

		MisionDAO m = new MisionDAO();////////////PersonajeDAO m = new PersonajeDAO();
		
		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(UsuarioDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(UsuarioDO.NOMBRE);
		strbuf.append(" VARCHAR(50),    ");
		strbuf.append(UsuarioDO.CORREO);
		strbuf.append(" VARCHAR(50),     ");
		strbuf.append(UsuarioDO.CLAVE);
		strbuf.append(" VARCHAR(20),     ");
		strbuf.append(UsuarioDO.PERSONAJE_ID);
		strbuf.append(" INT  REFERENCES   ");
		strbuf.append(m.getTableName());
		strbuf.append(" ");
		strbuf.append(PersonajeDO.ID);
		
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
		
		//FALTA REFERENCIAS
		
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

		strbuf.append(UsuarioDO.CORREO);
		strbuf.append(" = ");
		strbuf.append(singleQuotes(usuarioDO.getCorreo()));

		strbuf.append(", ");

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
		
		//FALTA BORRAR EL RESTO DE INFORMACION DEL USUARIO ( PERSONAJE)

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
		strbuf.append(UsuarioDO.ID);
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

	private UsuarioDO resultSetToDO(ResultSet rs) throws SQLException {
		UsuarioDO ret = //
		(UsuarioDO) dtaSession.getDtaByKey( //
				UsuarioDO.class, rs.getInt(UsuarioDO.ID));

		if (ret != null) {
			return ret;
		}
		ret = new UsuarioDO();

		ret.setId/*     */(rs.getInt(UsuarioDO.ID));
		ret.setNombre/*   */(rs.getString(UsuarioDO.NOMBRE));
		ret.setCorreo(rs.getString(UsuarioDO.CORREO));
		ret.setClave(rs.getString(UsuarioDO.CLAVE));
		
		// FALTA LA CONEXION CON PERSONAJE
		
		return (UsuarioDO) dtaSession.add(ret);
		
	}

}
