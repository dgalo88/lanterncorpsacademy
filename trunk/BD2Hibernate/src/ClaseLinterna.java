

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_claseLinterna")
@Proxy(lazy = false)

public class ClaseLinterna {

	private int id;
	private String color;
	private String nombreDeCuerpoLinterna;
	
	// --------------------------------------------------------------------------------

	private List<Personaje> personajeList = new ArrayList<Personaje>();
	private List<Grupo> grupoList = new ArrayList<Grupo>();
	private List<HabilidadClaseLinterna> habilidadClaseLinternaList = new ArrayList<HabilidadClaseLinterna>();
	private List<MisionClaseLinterna> misionClaseLinternaList = new  ArrayList<MisionClaseLinterna>();
	private Planeta planetaRef;
	
	
	// --------------------------------------------------------------------------------

	public ClaseLinterna() {
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// --------------------------------------------------------------------------------
	
	public String getNombre_de_cuerpo_linterna() {
		return nombreDeCuerpoLinterna;
	}

	public void setNombre_de_cuerpo_linterna(String nombreDeCuerpoLinterna) {
		this.nombreDeCuerpoLinterna = nombreDeCuerpoLinterna;
	}
	
	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "claseRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<Personaje> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<Personaje> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "claseRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<Grupo> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(List<Grupo> grupoList) {
		this.grupoList = grupoList;
	}

	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "claseRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<HabilidadClaseLinterna> getHabilidadClaseLinternaList() {
		return habilidadClaseLinternaList;
	}

	public void setHabilidadClaseLinternaList(List<HabilidadClaseLinterna> habilidadClaseLinternaList) {
		this.habilidadClaseLinternaList = habilidadClaseLinternaList;
	}
	
	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "unoRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<MisionClaseLinterna> getMisionClaseLinternaList() {
		return misionClaseLinternaList;
	}

	public void setMisionClaseLinternaList(List<MisionClaseLinterna> misionClaseLinternaList) {
		this.misionClaseLinternaList = misionClaseLinternaList;
	}
	
	// --------------------------------------------------------------------------------
	
	@ManyToOne
	public Planeta getPlanetaRef() {
		return planetaRef;
	}

	public void setPlanetaRef(Planeta planetaRef) {
		this.planetaRef = planetaRef;
	}

}
