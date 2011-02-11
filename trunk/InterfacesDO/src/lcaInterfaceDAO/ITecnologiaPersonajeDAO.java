package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.DataObject;
import dao.api.InterfaceDAO;

public interface ITecnologiaPersonajeDAO extends InterfaceDAO
{

	public abstract List<ITecnologiaPersonajeDO> listByPersonajeId(int PersonajeId)
	throws SQLException;

	public abstract List<ITecnologiaPersonajeDO> listByTecnologiaId(int TecnologiaId)
	throws SQLException;

	public abstract void loadPersonajeRef(ITecnologiaPersonajeDO personajeDO)
	throws SQLException;

	public abstract void loadTecnologiaRef(ITecnologiaPersonajeDO tecnologiaPersonajeDO)
	throws SQLException;

	DataObject loadByTecnologiaId(int tecid, int personajeId)
	throws SQLException;

}
