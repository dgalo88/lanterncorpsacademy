package dao.lantern;

import java.sql.SQLException;
import java.util.List;

import lcaInterfaceDAO.IUnidadEjercitoPersonajeDAO;
import lcaInterfaceDAO.IUnidadEjercitoPersonajeDO;
import dao.api.BaseDAO;
import dao.api.DataObject;

public class UnidadEjercitoPersonajeDAO extends BaseDAO implements
		IUnidadEjercitoPersonajeDAO {

	@Override
	public int countAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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

		UnidadEjercitoDAO unidadEjercitoDAO = new UnidadEjercitoDAO();
		unidadEjercitoDAO.init(connectionBean);
		
		PersonajeDAO personajeDAO = new PersonajeDAO();
		personajeDAO.init(connectionBean);


		strbuf = new StringBuffer();

		strbuf.append("CREATE TABLE ");
		strbuf.append(getTableName());
		strbuf.append(" (");
		strbuf.append(UnidadEjercitoPersonajeDO.ID);
		strbuf.append(" INT PRIMARY KEY, ");
		strbuf.append(UnidadEjercitoPersonajeDO.VIDA_MAXIMA);
		strbuf.append(" INT,    ");
		strbuf.append(UnidadEjercitoPersonajeDO.VIDA_MINIMA);
		strbuf.append(" INT,    ");
		strbuf.append(UnidadEjercitoPersonajeDO.UNIDAD_EJERCITO_ID);
		strbuf.append(" INT REFERENCES   ");
		strbuf.append(unidadEjercitoDAO.getTableName());
		strbuf.append(", ");
		strbuf.append(UnidadEjercitoPersonajeDO.PERSONAJE_ID);
		strbuf.append(" INT REFERENCES   ");
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

	@Override
	public void delete(DataObject bean) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(DataObject bean) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DataObject> listAll(int lim, int off) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataObject> listAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataObject loadById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(DataObject bean) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<IUnidadEjercitoPersonajeDO> listByPersonajeId(int PersonajeId)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IUnidadEjercitoPersonajeDO> listByUnidadEjercitoId(
			int UnidadEjercitoId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataObject loadByUnidadEjercitoId(int unidadEjercito, int personajeId)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadPersonajeRef(IUnidadEjercitoPersonajeDO unidadEjercitoDO)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadUnidadEjercitoRef(
			IUnidadEjercitoPersonajeDO unidadEjercitoPersonajeDO)
			throws SQLException {
		// TODO Auto-generated method stub

	}

}
