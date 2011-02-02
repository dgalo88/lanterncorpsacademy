package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

public interface ITecnologiaDAO extends InterfaceDAO {
	
	public abstract List<ITecnologiaDO> listByAndroideId(int androideId)
	throws SQLException;
	

	public abstract void loadUnidadBasicaRef(ITecnologiaDO tecnologiaDO) throws SQLException;

	public abstract void loadTecnologiaPersonajeList(ITecnologiaDO tecnologiaDO) throws SQLException;

	public abstract void loadTecnologiaRecursoList(ITecnologiaDO tecnologiaDO) throws SQLException;


}
