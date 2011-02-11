package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

public interface IRecursoPlanetaDAO extends InterfaceDAO {

	public abstract List<IRecursoPlanetaDO> listByRecursoId(int RecursoId)
			throws SQLException;

	public abstract List<IRecursoPlanetaDO> listByPlanetaId(int PlanetaId)
			throws SQLException;

}