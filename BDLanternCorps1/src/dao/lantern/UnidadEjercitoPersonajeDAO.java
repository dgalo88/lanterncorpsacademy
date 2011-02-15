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
		// TODO Auto-generated method stub

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
