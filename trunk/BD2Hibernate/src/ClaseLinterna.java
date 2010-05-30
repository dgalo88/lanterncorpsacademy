

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IClaseLinterna;
import lcaInterfaceDAO.IGrupo;
import lcaInterfaceDAO.IHabilidadClaseLinterna;
import lcaInterfaceDAO.IMisionClaseLinterna;
import lcaInterfaceDAO.IPersonaje;
import lcaInterfaceDAO.IPlaneta;
import dao.api.Reference;

@Entity
@Table(name = "t_claseLinterna")
@Proxy(lazy = false)

public class ClaseLinterna implements IClaseLinterna {

	public static final String COLOR /*                */= "color";
	public static final String NOMBRE_DE_CUERPO_LINTERNA = "nombreDeCuerpoLinterna";
	public static final String PLANETA_ID /*           */= "planetaId";

	// --------------------------------------------------------------------------------

	private int id;
	private String color;
	private String nombreDeCuerpoLinterna;
	
	// --------------------------------------------------------------------------------

	private List<IPersonaje> personajeList = new ArrayList<IPersonaje>();
	private List<IGrupo> grupoList = new ArrayList<IGrupo>();
	private List<IHabilidadClaseLinterna> habilidadClaseLinternaList = new ArrayList<IHabilidadClaseLinterna>();
	private List<IMisionClaseLinterna> misionClaseLinternaList = new  ArrayList<IMisionClaseLinterna>();
	private Reference<IPlaneta> planetaRef = new Reference<IPlaneta>();
	
	
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
	public List<IPersonaje> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<IPersonaje> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "claseRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<IGrupo> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(List<IGrupo> grupoList) {
		this.grupoList = grupoList;
	}

	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "claseRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<IHabilidadClaseLinterna> getHabilidadClaseLinternaList() {
		return habilidadClaseLinternaList;
	}

	public void setHabilidadClaseLinternaList(List<IHabilidadClaseLinterna> habilidadClaseLinternaList) {
		this.habilidadClaseLinternaList = habilidadClaseLinternaList;
	}
	
	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "unoRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<IMisionClaseLinterna> getMisionClaseLinternaList() {
		return misionClaseLinternaList;
	}

	public void setMisionClaseLinternaList(List<IMisionClaseLinterna> misionClaseLinternaList) {
		this.misionClaseLinternaList = misionClaseLinternaList;
	}
	
	// --------------------------------------------------------------------------------
	
//	public Reference<IPlanetaDO> getPlanetaRef() {
//		return planetaRef;
//	}
//
//	public void setPlanetaRef(Reference<IPlanetaDO> planetaRef) {
//		this.planetaRef = planetaRef;
//	}

	@ManyToOne
	public Planeta getPlanetaRef() {
		return planetaRef;
	}

	public void setPlanetaRef(Planeta planetaRef) {
		this.planetaRef = planetaRef;
	}

}
