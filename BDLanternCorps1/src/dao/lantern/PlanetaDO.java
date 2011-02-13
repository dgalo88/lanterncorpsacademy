package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IObjetivoDO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDO;
import dao.api.Reference;

public class PlanetaDO implements IPlanetaDO {

	public static final String NOMBRE = "nombre";
	public static final String SECTOR = "sector";
	public static final String COORDENADA_EN_X = "coordenada_en_x";
	public static final String COORDENADA_EN_Y = "coordenada_en_y";
	
	// --------------------------------------------------------------------------------

	private int id;

	private String nombre;
	private String sector;
	private float coordenada_en_x;
	private float coordenada_en_y;

	private Reference<IClaseLinternaDO> claseLinternaRef = new Reference<IClaseLinternaDO>();

	// --------------------------------------------------------------------------------

	private List<IPersonajeDO> personajeList = //
		new ArrayList<IPersonajeDO>();


	private List<IObjetivoDO> objetivoList = //
		new ArrayList<IObjetivoDO>();
	
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

	public Reference<IClaseLinternaDO> getClaseLinternaRef() {
		return claseLinternaRef;
	}

	public void setClaseLinternaRef(Reference<IClaseLinternaDO> claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}
	
	// --------------------------------------------------------------------------------

	public List<IPersonajeDO> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<IPersonajeDO> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------

	public List<IObjetivoDO> getObjetivoList() {
		return objetivoList;
	}

	public void setObjetivoList(List<IObjetivoDO> objetivoList) {
		this.objetivoList = objetivoList;
	}

}
