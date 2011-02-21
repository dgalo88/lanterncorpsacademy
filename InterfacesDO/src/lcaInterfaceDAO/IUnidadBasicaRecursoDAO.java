package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

public interface IUnidadBasicaRecursoDAO extends InterfaceDAO {
	
	
	public abstract void loadRecursoRef(IUnidadBasicaRecursoDO unidadBasicaDO)
	throws SQLException;

	public abstract void loadUnidadBasicaRef(IUnidadBasicaRecursoDO unidadBasicaRecursoDO)
	throws SQLException;
	
	public abstract List<IUnidadBasicaRecursoDO> listByRecursoId(int recursoId) throws SQLException;
	
	public abstract List<IUnidadBasicaRecursoDO> listByUnidadBasicaId(int unidadBasicaId) throws SQLException;

	

}
