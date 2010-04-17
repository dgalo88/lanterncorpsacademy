package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public class ClaseLinternaDO implements DataObject {

	public static final String COLOR = "color";
	public static final String NOMBRE_DE_CUERPO_LINTERNA   = "nombre_de_cuerpo_linterna";
	
	public static final String PLANETA_ID = "planetaId";

	// --------------------------------------------------------------------------------

	private int id;
	
	private String color;
	private String nombre_de_cuerpo_linterna;
	
	// --------------------------------------------------------------------------------

	private List<GrupoDO> grupoList = //
	new ArrayList<GrupoDO>();

	private List<PersonajeDO> personajeList = //
		new ArrayList<PersonajeDO>();
	
	private List<HabilidadClaseLinternaDO> habilidadClaseLinternaList = //
		new ArrayList<HabilidadClaseLinternaDO>();
	
	private List<MisionClaseLinternaDO> misionClaseLinternaList = //
		new ArrayList<MisionClaseLinternaDO>();	
	
	private Reference<PlanetaDO> planetaRef = new Reference<PlanetaDO>();
	
	// --------------------------------------------------------------------------------

	public ClaseLinternaDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// --------------------------------------------------------------------------------

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// --------------------------------------------------------------------------------
	
	public String getNombreDeCuerpoLinterna() {
		return nombre_de_cuerpo_linterna;
	}

	public void setNombreDeCuerpoLinterna(String nombreDeCuerpoLinterna) {
		nombre_de_cuerpo_linterna = nombreDeCuerpoLinterna;
	}
	
	// --------------------------------------------------------------------------------

	public List<PersonajeDO> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<PersonajeDO> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------

	public List<GrupoDO> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(List<GrupoDO> grupoList) {
		this.grupoList = grupoList;
	}

	// --------------------------------------------------------------------------------

	public Reference<PlanetaDO> getPlanetaRef() {
		return planetaRef;
	}

	public void setPlanetaRef(Reference<PlanetaDO> planetaRef) {
		this.planetaRef = planetaRef;
	}

	// --------------------------------------------------------------------------------
	
	public void setHabilidadClaseLinternaList(
			List<HabilidadClaseLinternaDO> habilidadClaseLinternaList) {
		this.habilidadClaseLinternaList = habilidadClaseLinternaList;
	}

	public List<HabilidadClaseLinternaDO> getHabilidadClaseLinternaList() {
		return habilidadClaseLinternaList;
	}

	// --------------------------------------------------------------------------------
	
	public void setMisionClaseLinternaList(List<MisionClaseLinternaDO> misionClaseLinternaList) {
		this.misionClaseLinternaList = misionClaseLinternaList;
	}

	public List<MisionClaseLinternaDO> getMisionClaseLinternaList() {
		return misionClaseLinternaList;
	}

	// --------------------------------------------------------------------------------

}
