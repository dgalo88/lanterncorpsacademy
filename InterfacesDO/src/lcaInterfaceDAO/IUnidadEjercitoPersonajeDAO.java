package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.DataObject;
import dao.api.InterfaceDAO;

public interface IUnidadEjercitoPersonajeDAO extends InterfaceDAO {

	public abstract List<IUnidadEjercitoPersonajeDO> listByUnidadEjercitoId(
			int UnidadEjercitoId) throws SQLException;

	public abstract List<IUnidadEjercitoPersonajeDO> listByPersonajeId(
			int PersonajeId) throws SQLException;

	public abstract void loadPersonajeRef(
			IUnidadEjercitoPersonajeDO unidadEjercitoDO) throws SQLException;

	public abstract void loadUnidadEjercitoRef(
			IUnidadEjercitoPersonajeDO unidadEjercitoPersonajeDO)
			throws SQLException;

	DataObject loadByUnidadEjercitoId(int unidadEjercito, int personajeId)
			throws SQLException;

}
