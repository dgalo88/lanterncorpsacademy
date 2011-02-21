package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IAndroideRecursoDO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoOfertaCompraDO;
import lcaInterfaceDAO.IRecursoOfertaVentaDO;
import lcaInterfaceDAO.IRecursoPersonajeDO;
import lcaInterfaceDAO.IRecursoPlanetaDO;
import lcaInterfaceDAO.ITecnologiaRecursoDO;
import lcaInterfaceDAO.IUnidadBasicaRecursoDO;

public class RecursoDO implements IRecursoDO {

	public static final String ARTICULO = "articulo";
	public static final String NOMBRE = "nombre";

	public static final String RECURSO_ID = "recursoId";

	// ---------------------------------------------------------------
	private int id;

	private int articulo;
	private String nombre;
	// --------------------------------------------------------------

	private List<IRecursoPersonajeDO> recursoPersonajeList = //
	new ArrayList<IRecursoPersonajeDO>();

	private List<IUnidadBasicaRecursoDO> unidadBasicaRecursoList = //
	new ArrayList<IUnidadBasicaRecursoDO>();

	private List<IAndroideRecursoDO> androideRecursoList = //
	new ArrayList<IAndroideRecursoDO>();

	private List<ITecnologiaRecursoDO> tecnologiaRecursoList = //
	new ArrayList<ITecnologiaRecursoDO>();

	private List<IRecursoOfertaCompraDO> recursoOfertaCompraList = //
	new ArrayList<IRecursoOfertaCompraDO>();

	private List<IRecursoOfertaVentaDO> recursoOfertaVentaList = //
	new ArrayList<IRecursoOfertaVentaDO>();

	private List<IRecursoPlanetaDO> recursoPlanetaList = //
	new ArrayList<IRecursoPlanetaDO>();

	// ------------------------------------------------------------------

	public RecursoDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// --------------------------------------------------------------------------------

	public int getArticulo() {
		return articulo;
	}

	public void setArticulo(int articulo) {
		this.articulo = articulo;
	}

	// --------------------------------------------------------------------------------

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// --------------------------------------------------------------------------------

	public List<IRecursoPersonajeDO> getRecursoPersonajeList() {
		return recursoPersonajeList;
	}

	public void setRecursoPersonajeList(
			List<IRecursoPersonajeDO> recursoPersonajeList) {
		this.recursoPersonajeList = recursoPersonajeList;
	}

	// --------------------------------------------------------------------------------------

	public List<IUnidadBasicaRecursoDO> getUnidadBasicaRecursoList() {
		return unidadBasicaRecursoList;
	}

	public void setUnidadBasicaRecursoList(
			List<IUnidadBasicaRecursoDO> unidadBasicaRecursoList) {
		this.unidadBasicaRecursoList = unidadBasicaRecursoList;
	}

	// --------------------------------------------------------------------------------------

	public List<IAndroideRecursoDO> getAndroideRecursoList() {
		return androideRecursoList;
	}

	public void setAndroideRecursoList(
			List<IAndroideRecursoDO> androideRecursoList) {
		this.androideRecursoList = androideRecursoList;
	}

	// --------------------------------------------------------------------------------------

	public List<ITecnologiaRecursoDO> getTecnologiaRecursoList() {
		return tecnologiaRecursoList;
	}

	public void setTecnologiaRecursoList(
			List<ITecnologiaRecursoDO> tecnologiaRecursoList) {
		this.tecnologiaRecursoList = tecnologiaRecursoList;
	}

	// --------------------------------------------------------------------------------------

	public List<IRecursoOfertaCompraDO> getRecursoOfertaCompraList() {
		return recursoOfertaCompraList;
	}

	public void setRecursoOfertaCompraList(
			List<IRecursoOfertaCompraDO> recursoOfertaCompraList) {
		this.recursoOfertaCompraList = recursoOfertaCompraList;
	}

	// --------------------------------------------------------------------------------------
	public List<IRecursoOfertaVentaDO> getRecursoOfertaVentaList() {
		return recursoOfertaVentaList;
	}

	public void setRecursoOfertaVentaList(
			List<IRecursoOfertaVentaDO> recursoOfertaVentaList) {
		this.recursoOfertaVentaList = recursoOfertaVentaList;
	}

	// --------------------------------------------------------------------------------------

	@Override
	public List<IRecursoPlanetaDO> getRecursoPlanetaList() {
		return recursoPlanetaList;
	}

	@Override
	public void setRecursoPlanetaList(List<IRecursoPlanetaDO> recursoPlanetaList) {
		this.recursoPlanetaList = recursoPlanetaList;

	}


}
