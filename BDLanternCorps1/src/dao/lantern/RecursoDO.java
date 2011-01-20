package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IAndroideDO;
import lcaInterfaceDAO.IOfertaDO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDAO;
import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IRecursoDO;
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
	
	private List<IPersonajeDO> personajeList = //
		new ArrayList<IPersonajeDO>();
	
	private List<IUnidadBasicaDO> unidadBasicaList =//
		new ArrayList<IUnidadBasicaDO>();
	
	private List<IAndroideDO> androideList =//
		new ArrayList<IAndroideDO>();
	
	private List<ITecnologiaDO> tecnologiaList =//
		new ArrayList<ITecnologiaDO>();
	
	private List<IOfertaDO> ofertaList =//
		new ArrayList<IOfertaDO>();
	
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
	
	public List<IPersonajeDO> getPersonajeList() {
		return personajeList;
	}
	
	
	public void setPersonajeList(List<IPersonajeDO> personajeList) {
		this.personajeList = personajeList;
	}
	//--------------------------------------------------------------------------------------
	
	public List<IUnidadBasicaDO> getUnidadBasicaList() {
		return unidadBasicaList;
	}
	
	
	public void setUnidadBasicaList(List<IUnidadBasicaDO> unidadBasicaList) {
		this.unidadBasicaList = unidadBasicaList;
	}
	//--------------------------------------------------------------------------------------
	
	public List<IAndroideDO> getAndroideList() {
		return androideList;
	}
	
	
	public void setAndroideList(List<IAndroideDO> androideList) {
		this.androideList = androideList;
	}
	//--------------------------------------------------------------------------------------
	
	public List<ITecnologiaDO> getTecnologiaList() {
		return tecnologiaList;
	}
	
	
	public void setTecnologiaList(List<ITecnologiaDO> tecnologiaList) {
		this.tecnologiaList = tecnologiaList;
	}
	//--------------------------------------------------------------------------------------

	public List<IOfertaDO> getOfertaList() {
		return ofertaList;
	}
	
	
	public void setOfertaList(List<IOfertaDO> ofertaList) {
		this.ofertaList = ofertaList;
	}
	//--------------------------------------------------------------------------------------
	
	public List<IPlanetaDO> getPlanetaList() {
		return planetaList;
	}
	
	
	public void setPlanetaList(List<IPlanetaDO> planetaList) {
		this.planetaList = planetaList;
	}
	//--------------------------------------------------------------------------------------
	
}
