package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IOfertaDO;
import lcaInterfaceDAO.IOfertaPersonajeDO;
import lcaInterfaceDAO.IRecursoOfertaCompraDO;
import lcaInterfaceDAO.IRecursoOfertaVentaDO;
import lcaInterfaceDAO.IUnidadEjercitoOfertaDO;

public class OfertaDO implements IOfertaDO {

	// --------------------------------------------------
	public static final String OFERTA_ID = "oferta";
	public static final String ARTICULO = "articulo";

	public static final String RECURSO_OFERTA_COMPRA_ID = "recursoOfertaCompra";
	public static final String RECURSO_OFERTA_VENTA_ID = "recursoOfertaVenta";
	public static final String PERSONAJE_ID = "personje";

	// ----------------------------------------------------------------

	private int id;
	private String articulo;

	// -----------------------------------------------------------------------

	private List<IUnidadEjercitoOfertaDO> unidadEjercitoOfertaList = //
	new ArrayList<IUnidadEjercitoOfertaDO>();

	private List<IOfertaPersonajeDO> ofertaPersonajeList = //
	new ArrayList<IOfertaPersonajeDO>();

	private List<IRecursoOfertaCompraDO> recursoOfertaCompraList = //
	new ArrayList<IRecursoOfertaCompraDO>();

	private List<IRecursoOfertaVentaDO> recursoOfertaVentaList = //
	new ArrayList<IRecursoOfertaVentaDO>();

	// -----------------------------------------------------------------------

	public OfertaDO() {
		// empty
	}

	// ---------------------------------------------------------------------------

	public String getArticulo() {

		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;

	}

	// -------------------------------------------------------------------------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// --------------------------------------------------------------------------------

	public void setOfertaPersonajeList(
			List<IOfertaPersonajeDO> ofertaPersonajeList) {
		this.ofertaPersonajeList = ofertaPersonajeList;

	}

	public List<IOfertaPersonajeDO> getOfertaPersonajeList() {
		return ofertaPersonajeList;
	}

	public void setRecursoOfertaCompraList(
			List<IRecursoOfertaCompraDO> recursoOfertaCompraList) {
		this.recursoOfertaCompraList = recursoOfertaCompraList;

	}

	public List<IRecursoOfertaCompraDO> getRecursoOfertaCompraList() {
		return recursoOfertaCompraList;
	}

	public void setRecursoOfertaVentaList(
			List<IRecursoOfertaVentaDO> recursoOfertaVentaList) {
		this.recursoOfertaVentaList = recursoOfertaVentaList;

	}

	public List<IRecursoOfertaVentaDO> getRecursoOfertaVentaList() {
		return recursoOfertaVentaList;
	}

	@Override
	public void setUnidadEjercitoOfertaList(
			List<IUnidadEjercitoOfertaDO> unidadEjercitoOfertaList) {
		this.unidadEjercitoOfertaList = unidadEjercitoOfertaList;
	}

	@Override
	public List<IUnidadEjercitoOfertaDO> getUnidadEjercitoOfertaList() {
		return unidadEjercitoOfertaList;

	}

}
