package lcaInterfaceDAO;

import java.sql.SQLException;

import dao.api.InterfaceDAO;

public interface ITecnologiaDAO extends InterfaceDAO {
	
	
	
//	public abstract List<ITecnologiaDO> listByAndroideId(int androideId) verificar si es necesario el metodo
//	throws SQLException;
	

	public abstract void loadUnidadBasicaRef(ITecnologiaDO tecnologiaDO) throws SQLException;

	public abstract void loadTecnologiaPersonajeList(ITecnologiaDO tecnologiaDO) throws Exception;

	public abstract void loadTecnologiaRecursoList(ITecnologiaDO tecnologiaDO) throws Exception;

	public abstract ITecnologiaDO loadByNombre(String nombre) throws SQLException;


}
