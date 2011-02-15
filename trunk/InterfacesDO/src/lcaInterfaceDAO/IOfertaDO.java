package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;

public interface IOfertaDO extends DataObject {

	public abstract String getArticulo();

	public abstract void setArticulo(String articulo);

	public abstract List<IRecursoOfertaCompraDO> getRecursoOfertaCompraList();

	public abstract void setRecursoOfertaCompraList(
			List<IRecursoOfertaCompraDO> RecursoOfertaCompraList);

	public abstract List<IRecursoOfertaVentaDO> getRecursoOfertaVentaList();

	public abstract void setRecursoOfertaVentaList(
			List<IRecursoOfertaVentaDO> RecursoOfertaVentaList);

	public abstract List<IOfertaPersonajeDO> getOfertaPersonajeList();

	public abstract void setOfertaPersonajeList(
			List<IOfertaPersonajeDO> OfertaPersonajeList);

	public abstract List<IUnidadEjercitoOfertaDO> getUnidadEjercitoOfertaList();

	public abstract void setUnidadEjercitoOfertaList(
			List<IUnidadEjercitoOfertaDO> unidadEjercitoOfertaList);

}
