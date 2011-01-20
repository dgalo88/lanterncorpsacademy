package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IAndroideRecursoDO;
import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoOfertaCompraDO;
import lcaInterfaceDAO.IRecursoOfertaVentaDO;
import lcaInterfaceDAO.IRecursoPersonajeDO;
import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.IUnidadBasicaDO;

public class RecursoDO implements IRecursoDO{ //Porque me pide que la clase sea abstracta?
	
	public static final String ARTICULO ="articulo";
	public static final String NOMBRE = "nombre";
	
	public static final String RECURSO_ID = "recursoId";
	
    //---------------------------------------------------------------
	private int id;
	
	private int articulo;
	private String nombre;
	//--------------------------------------------------------------
	
	private List<IRecursoPersonajeDO> recursoPersonajeList = //
		new ArrayList<IRecursoPersonajeDO>();
	
	private List<IUnidadBasicaDO> unidadBasicaList =//
		new ArrayList<IUnidadBasicaDO>();
	
	private List<IAndroideRecursoDO> androideRecursoList =//
		new ArrayList<IAndroideRecursoDO>();
	
	private List<ITecnologiaDO> tecnologiaList =//
		new ArrayList<ITecnologiaDO>();
	
	private List<IRecursoOfertaCompraDO> recursoOfertaCompraList =//
		new ArrayList<IRecursoOfertaCompraDO>();
	
	private List<IRecursoOfertaVentaDO> recursoOfertaVentaList =//
		new ArrayList<IRecursoOfertaVentaDO>();
	
	private List<IPlanetaDO> planetaList =//
		new ArrayList<IPlanetaDO>();

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
	
	
	public void setRecursoPersonajeList(List<IRecursoPersonajeDO> recursoPersonajeList) {
		this.recursoPersonajeList = recursoPersonajeList;
	}
	//--------------------------------------------------------------------------------------
	
	public List<IUnidadBasicaDO> getUnidadBasicaList() {
		return unidadBasicaList;
	}
	
	
	public void setUnidadBasicaList(List<IUnidadBasicaDO> unidadBasicaList) {
		this.unidadBasicaList = unidadBasicaList;
	}
	//--------------------------------------------------------------------------------------
	
	public List<IAndroideRecursoDO> getAndroideRecursoList() {
		return androideRecursoList;
	}
	
	
	public void setAndroideList(List<IAndroideRecursoDO> androideRecursoList) {
		this.androideRecursoList = androideRecursoList;
	}
	//--------------------------------------------------------------------------------------
	
	public List<ITecnologiaDO> getTecnologiaList() {
		return tecnologiaList;
	}
	
	
	public void setTecnologiaList(List<ITecnologiaDO> tecnologiaList) {
		this.tecnologiaList = tecnologiaList;
	}
	//--------------------------------------------------------------------------------------

	public List<IRecursoOfertaCompraDO> getRecursoOfertaCompraList() {
		return recursoOfertaCompraList;
	}
	
	
	public void setRecursoOfertaCompraList(List<IRecursoOfertaCompraDO> recursoOfertaCompraList) {
		this.recursoOfertaCompraList = recursoOfertaCompraList;
	}
	//--------------------------------------------------------------------------------------
	public List<IRecursoOfertaVentaDO> getRecursoOfertaVentaList() {
		return recursoOfertaVentaList;
	}
	
	
	public void setRecursoOfertaVentaList(List<IRecursoOfertaVentaDO> recursoOfertaVentaList) {
		this.recursoOfertaVentaList = recursoOfertaVentaList;
	}
	//---------------------------------------------------------------------------------------
	public List<IPlanetaDO> getPlanetaList() {
		return planetaList;
	}
	
	
	public void setPlanetaList(List<IPlanetaDO> planetaList) {
		this.planetaList = planetaList;
	}
	//--------------------------------------------------------------------------------------
	
}
