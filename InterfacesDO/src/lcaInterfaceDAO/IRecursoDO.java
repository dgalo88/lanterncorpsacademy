package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;

public interface IRecursoDO extends DataObject {

	public abstract int getArticulo();

	public abstract void setArticulo(int articulo);

	public abstract String getNombre();

	public abstract void setNombre(String nombre);

	// ------------------------------------------------------------------------------------------
	public abstract List<IRecursoPersonajeDO> getRecursoPersonajeList();

	public abstract void setRecursoPersonajeList(
			List<IRecursoPersonajeDO> recursoPersonajeList);


	// ------------------------------------------------------------------------------------------
	public abstract List<IAndroideRecursoDO> getAndroideRecursoList();

	public abstract void setAndroideRecursoList(
			List<IAndroideRecursoDO> androideRecursoList);

	// -----------------------------------------------------------------------------------------
	public abstract List<ITecnologiaRecursoDO> getTecnologiaRecursoList();

	public abstract void setTecnologiaRecursoList(
			List<ITecnologiaRecursoDO> tecnologiaList);

	// -------------------------------------------------------------------------------------
	public abstract List<IRecursoOfertaCompraDO> getRecursoOfertaCompraList();

	public abstract void setRecursoOfertaCompraList(
			List<IRecursoOfertaCompraDO> recursoOfertaCompraList);

	// ---------------------------------------------------------------------------------------
	public abstract List<IRecursoOfertaVentaDO> getRecursoOfertaVentaList();

	public abstract void setRecursoOfertaVentaList(
			List<IRecursoOfertaVentaDO> recursoOfertaVentaList);

	// ---------------------------------------------------------------------------------------

	public abstract List<IRecursoPlanetaDO> getRecursoPlanetaList();

	public abstract void setRecursoPlanetaList(
			List<IRecursoPlanetaDO> recursoPlanetaList);

	public abstract List<IUnidadBasicaRecursoDO> getUnidadBasicaRecursoList();
	public abstract void setUnidadBasicaRecursoList(List<IUnidadBasicaRecursoDO> unidadBasicaRecursoList);

	// ------------------------------------------------------------------------------------------------

}
