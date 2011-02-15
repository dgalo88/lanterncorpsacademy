package lcaInterfaceDAO;

import java.sql.SQLException;
import dao.api.InterfaceDAO;

public interface IUnidadEjercitoDAO extends InterfaceDAO {

	public void loadUnidadBasicaArmaRef(IUnidadEjercitoDO unidadEjercitoDO)
			throws SQLException;

	public void loadUnidadBasicaRobotRef(IUnidadEjercitoDO unidadEjercitoDO)
			throws SQLException;

	public void loadUnidadBasicaVehiculoRef(IUnidadEjercitoDO unidadEjercitoDO)
			throws SQLException;

	public void loadUnidadBasicaBalaRef(IUnidadEjercitoDO unidadEjercitoDO)
			throws SQLException;

	public void loadUnidadEjercitoPersonajeList(
			IUnidadEjercitoDO unidadEjercitoDO) throws Exception;

	public void loadUnidadEjercitoOfertaList(IUnidadEjercitoDO unidadEjercitoDO)
			throws Exception;

}
