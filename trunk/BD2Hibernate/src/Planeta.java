

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IObjetivo;
import lcaInterfaceDAO.IPersonaje;
import lcaInterfaceDAO.IPlaneta;

@Entity
@Table(name = "t_planeta")
@Proxy(lazy = false)

public class Planeta implements IPlaneta {

	public static final String NOMBRE = "nombre";
	public static final String SECTOR = "sector";
	public static final String COORDENADA_EN_X = "coordenadaEnX";
	public static final String COORDENADA_EN_Y = "coordenadaEnY";
	// --------------------------------------------------------------------------------

	private int id;
	private String nombre;
	private String sector;
	private float coordenadaEnX;
	private float coordenadaEnY;

	// --------------------------------------------------------------------------------

	private List<IPersonaje> personajeList = new ArrayList<IPersonaje>();
	private List<IObjetivo> objetivoList = new ArrayList<IObjetivo>();
	
	// --------------------------------------------------------------------------------

	public Planeta() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
		return coordenadaEnX;
	}

	public void setCoordenadaEnX(float coordenadaEnX) {
		this.coordenadaEnX = coordenadaEnX;
	}

	// --------------------------------------------------------------------------------

	public float getCoordenadaEnY() {
		return coordenadaEnY;
	}

	public void setCoordenadaEnY(float coordenadaEnY) {
		this.coordenadaEnY = coordenadaEnY;
	}
	
	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "planetaRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<IPersonaje> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<IPersonaje> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------

	@OneToMany(mappedBy = "planetaRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<IObjetivo> getObjetivoList() {
		return objetivoList;
	}

	public void setObjetivoList(List<IObjetivo> objetivoList) {
		this.objetivoList = objetivoList;
	}

}
