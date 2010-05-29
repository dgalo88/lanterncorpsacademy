package hlantern;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IObjetivoDO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDO;
import dao.api.Reference;

@Entity
@Table(name = "t_planeta")
@Proxy(lazy = false)
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@OneToOne(mappedBy = "planetaRef") //referenciado por: claseLinterna
	public Reference<IClaseLinternaDO> getClaseLinternaRef() {
		return claseLinternaRef;
	}

	public void setClaseLinternaRef(Reference<IClaseLinternaDO> claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}
	
	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "planetaRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<IPersonajeDO> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<IPersonajeDO> personajeList) {
		this.personajeList = personajeList;
	}


	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "planetaRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<IObjetivoDO> getObjetivoList() {
		return objetivoList;
	}

	public void setObjetivoList(List<IObjetivoDO> objetivoList) {
		this.objetivoList = objetivoList;
	}

}
