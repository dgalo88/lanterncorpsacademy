package dao.lca;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;

public class PlanetaDO implements DataObject {

	public static final String NOMBRE = "nombre";
	public static final String SECTOR = "sector";

	// --------------------------------------------------------------------------------

	private int id;
	private String nombre;
	private String sector;
	private float coordenada_en_x;
	private float coordenada_en_y;

	// --------------------------------------------------------------------------------

	private List<PersonajeDO> personajeList = new ArrayList<PersonajeDO>();

	private List<ClaseLinternaDO> claseLinternaList = new ArrayList<ClaseLinternaDO>();
	
	private List<ObjetivoDO> objetivoList = new ArrayList<ObjetivoDO>();
	
	// --------------------------------------------------------------------------------

	public PlanetaDO() {
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// --------------------------------------------------------------------------------

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}
	
	// --------------------------------------------------------------------------------

	public float getCoordenadaEnX() {
		return coordenada_en_x;
	}

	public void setCoordenadaEnX(float coordenada_en_x) {
		this.coordenada_en_x = coordenada_en_x;
	}

	// --------------------------------------------------------------------------------

	public float getCoordenadaEnY() {
		return coordenada_en_y;
	}

	public void setCoordenadaEnY(float coordenada_en_y) {
		this.coordenada_en_y = coordenada_en_y;
	}
	
	// --------------------------------------------------------------------------------

	public List<PersonajeDO> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<PersonajeDO> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------

	public List<ClaseLinternaDO> getClaseLinternaList() {
		return claseLinternaList;
	}

	public void setClaseLinternaList(List<ClaseLinternaDO> claseLinternaList) {
		this.claseLinternaList = claseLinternaList;
	}

	// --------------------------------------------------------------------------------

	public List<ObjetivoDO> getObjetivoList() {
		return objetivoList;
	}

	public void setObjetivoList(List<ObjetivoDO> objetivoList) {
		this.objetivoList = objetivoList;
	}

}
