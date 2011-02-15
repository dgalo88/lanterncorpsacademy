package lcaInterfaceDAO;

import java.sql.SQLException;

import dao.api.InterfaceDAO;

public interface IRecursoDAO extends InterfaceDAO {

	public abstract void loadRecursoPersonajeList(IRecursoDO recursoDO)
			throws Exception;

	public abstract void loadRecursoPlanetaList(IRecursoDO recursoDO)
			throws Exception;

	public abstract void loadAndroideRecursoList(IRecursoDO recursoDO)
			throws Exception;

	public abstract void loadTecnologiaRecursoList(IRecursoDO recursoDO)
			throws Exception;

	public abstract void loadUnidadBasicaRecursoList(IRecursoDO recursoDO)
			throws Exception;

	public abstract void loadRecursoOfertaCompraList(IRecursoDO recursoDO)
			throws Exception;

	public abstract void loadRecursoOfertaVentaList(IRecursoDO recursoDO)
			throws Exception;

	IRecursoDO loadByNombre(String nombre) throws SQLException;

}
