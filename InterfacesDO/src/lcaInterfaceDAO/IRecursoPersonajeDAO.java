package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.DataObject;
import dao.api.InterfaceDAO;

public interface IRecursoPersonajeDAO extends InterfaceDAO {

	public abstract List<IRecursoPersonajeDO> listByRecursoId(int RecursoId)
			throws SQLException;

	public abstract List<IRecursoPersonajeDO> listByPersonajeId(int PersonajeId)
			throws SQLException;

	public abstract void loadPersonajeRef(IRecursoPersonajeDO recursoDO)
			throws SQLException;

	public abstract void loadRecursoRef(IRecursoPersonajeDO recursoPersonajeDO)
			throws SQLException;

	DataObject loadByRecursoId(int recurso, int personajeId)
			throws SQLException;

}
