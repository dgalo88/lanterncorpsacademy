package hlantern;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IGrupoDO;
import lcaInterfaceDAO.IHabilidadClaseLinternaDO;
import lcaInterfaceDAO.IMisionClaseLinternaDO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDO;
import dao.api.Reference;

@Entity
@Table(name = "t_claselinterna")
@Proxy(lazy = false)
public class ClaseLinternaDO implements IClaseLinternaDO {

	public static final String COLOR = "color";
	public static final String NOMBRE_DE_CUERPO_LINTERNA   = "nombre_de_cuerpo_linterna";
	
	public static final String PLANETA_ID = "planetaId";
	
	// --------------------------------------------------------------------------------

	private int id;
	
	private String color;
	private String nombre_de_cuerpo_linterna;
	
	// --------------------------------------------------------------------------------

	private List<IGrupoDO> grupoList = //
	new ArrayList<IGrupoDO>();

	private List<IPersonajeDO> personajeList = //
		new ArrayList<IPersonajeDO>();
	
	private List<IHabilidadClaseLinternaDO> habilidadClaseLinternaList = //
		new ArrayList<IHabilidadClaseLinternaDO>();
	
	private List<IMisionClaseLinternaDO> misionClaseLinternaList = //
		new ArrayList<IMisionClaseLinternaDO>();	
	
	private Reference<IPlanetaDO> planetaRef = new Reference<IPlanetaDO>();
	
	// --------------------------------------------------------------------------------

	public ClaseLinternaDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	@Override
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
		return nombre_de_cuerpo_linterna;
	}
	
	public void setNombre_de_cuerpo_linterna(String nombreDeCuerpoLinterna) {
		nombre_de_cuerpo_linterna = nombreDeCuerpoLinterna;
	}
	
	// --------------------------------------------------------------------------------

	@OneToMany(mappedBy = "clase_linternaRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<IPersonajeDO> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<IPersonajeDO> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------

	@OneToMany(mappedBy = "clase_linternaRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<IGrupoDO> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(List<IGrupoDO> grupoList) {
		this.grupoList = grupoList;
	}

	// --------------------------------------------------------------------------------
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public Reference<IPlanetaDO> getPlanetaRef() {
		return planetaRef;
	}

	public void setPlanetaRef(Reference<IPlanetaDO> planetaRef) {
		this.planetaRef = planetaRef;
	}

	// --------------------------------------------------------------------------------
	
	public void setHabilidadClaseLinternaList(
			List<IHabilidadClaseLinternaDO> habilidadClaseLinternaList) {
		this.habilidadClaseLinternaList = habilidadClaseLinternaList;
	}

	@OneToMany(mappedBy = "clase_linternaRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<IHabilidadClaseLinternaDO> getHabilidadClaseLinternaList() {
		return habilidadClaseLinternaList;
	}

	// --------------------------------------------------------------------------------
	
	public void setMisionClaseLinternaList(List<IMisionClaseLinternaDO> misionClaseLinternaList) {
		this.misionClaseLinternaList = misionClaseLinternaList;
	}

	@OneToMany(mappedBy = "clase_linternaRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<IMisionClaseLinternaDO> getMisionClaseLinternaList() {
		return misionClaseLinternaList;
	}



	// --------------------------------------------------------------------------------

}
