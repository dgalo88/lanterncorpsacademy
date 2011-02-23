package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.DataObject;
import dao.api.InterfaceDAO;

public interface ITecnologiaRecursoDAO extends InterfaceDAO{
	

	public abstract List<ITecnologiaRecursoDO> listByRecursoId(int RecursoId)
	throws SQLException;

	public abstract List<ITecnologiaRecursoDO> listByTecnologiaId(int TecnologiaId)
	throws SQLException;

	public abstract void loadRecursoRef(ITecnologiaRecursoDO recursoDO)
	throws SQLException;

	public abstract void loadTecnologiaRef(ITecnologiaRecursoDO tecnologiaRecursoDO)
	throws SQLException;

	DataObject loadByTecnologiaId(int tecid, int recursoId)
	throws SQLException;

}
