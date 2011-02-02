package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

public interface IAndroidePersonajeDAO extends InterfaceDAO{

	public abstract void loadAndroideRef(
			IAndroidePersonajeDO androidePersonajeDO) throws Exception;

	public abstract void loadPersonajeRef(
			IAndroidePersonajeDO androidePersonajeDO) throws Exception;

	//----------------------------------------------------------------------------
	
	public abstract List<IAndroidePersonajeDO> listByPersonajeId(int personajeId)
	throws SQLException;
	
	//-----------------------------------------------------------------------------
	
	public abstract List<IAndroidePersonajeDO> listByAndroideId(int androideId)
	throws SQLException;
	
	
	//public IAndroideDO loadByTipo () throws SQLException;
	

}

