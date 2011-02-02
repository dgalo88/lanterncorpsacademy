package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

public interface IAndroideRecursoDAO extends InterfaceDAO {

	
	public abstract void loadAndroideRef(
			IAndroideRecursoDO androideRecursoDO) throws Exception;

	public abstract void loadRecursoRef(
			IAndroideRecursoDO androideRecursojeDO) throws Exception;

	//----------------------------------------------------------------------------
	
	public abstract List<IAndroideRecursoDO> listByRecursoId(int recursoId)
	throws SQLException;
	
	//-----------------------------------------------------------------------------
	
	public abstract List<IAndroideRecursoDO> listByAndroideId(int androideId)
	throws SQLException;
	
	
	//public IAndroideDO loadByTipo () throws SQLException;
	

}
