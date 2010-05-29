package dao.lca;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IGrupoDO;
import lcaInterfaceDAO.IHabilidadClaseLinternaDO;
import lcaInterfaceDAO.IMisionClaseLinternaDO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDO;
import dao.api.Reference;

@Entity
@Table(name = "t_claseLinterna")
@Proxy(lazy = false)

public class ClaseLinternaDO implements IClaseLinternaDO {

	public static final String COLOR /*                */= "color";
	public static final String NOMBRE_DE_CUERPO_LINTERNA = "nombreDeCuerpoLinterna";
	public static final String PLANETA_ID /*           */= "planetaId";

	// --------------------------------------------------------------------------------

	private int id;
	private String color;
	private String nombreDeCuerpoLinterna;
	
	// --------------------------------------------------------------------------------

	private List<IPersonajeDO> personajeList = new ArrayList<IPersonajeDO>();
	private List<IGrupoDO> grupoList = new ArrayList<IGrupoDO>();
	private List<IHabilidadClaseLinternaDO> habilidadClaseLinternaList = new ArrayList<IHabilidadClaseLinternaDO>();
	private List<IMisionClaseLinternaDO> misionClaseLinternaList = new  ArrayList<IMisionClaseLinternaDO>();
	private Reference<IPlanetaDO> planetaRef = new Reference<IPlanetaDO>();
	
	
	// --------------------------------------------------------------------------------

	public ClaseLinternaDO() {
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
	public List<IPersonajeDO> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<IPersonajeDO> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "claseRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<IGrupoDO> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(List<IGrupoDO> grupoList) {
		this.grupoList = grupoList;
	}

	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "claseRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<IHabilidadClaseLinternaDO> getHabilidadClaseLinternaList() {
		return habilidadClaseLinternaList;
	}

	public void setHabilidadClaseLinternaList(List<IHabilidadClaseLinternaDO> habilidadClaseLinternaList) {
		this.habilidadClaseLinternaList = habilidadClaseLinternaList;
	}
	
	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "unoRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<IMisionClaseLinternaDO> getMisionClaseLinternaList() {
		return misionClaseLinternaList;
	}

	public void setMisionClaseLinternaList(List<IMisionClaseLinternaDO> misionClaseLinternaList) {
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
