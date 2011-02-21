package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

	public interface IUnidadBasicaPersonajeDAO extends InterfaceDAO{

	public abstract void loadPersonajeRef(IUnidadBasicaPersonajeDO unidadBasicaDO)
	throws SQLException;

	public abstract void loadUnidadBasicaRef(IUnidadBasicaPersonajeDO unidadBasicaPersonajeDO)
	throws SQLException;
	
	public abstract List<IUnidadBasicaPersonajeDO> listByPersonajeId(int personajeId) throws SQLException;
	
	public abstract List<IUnidadBasicaPersonajeDO> listByUnidadBasicaId(int unidadBasicaId) throws SQLException;
}
