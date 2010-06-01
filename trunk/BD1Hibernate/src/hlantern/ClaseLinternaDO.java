package hlantern;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "claselinterna")
@Proxy(lazy = false)
public class ClaseLinternaDO  {

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
	
	private PlanetaDO planeta;
	
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
		return nombre_de_cuerpo_linterna;
	}
	
	public void setNombre_de_cuerpo_linterna(String nombreDeCuerpoLinterna) {
		nombre_de_cuerpo_linterna = nombreDeCuerpoLinterna;
	}
	
	// --------------------------------------------------------------------------------

	@OneToMany(mappedBy = "claseLinterna")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<PersonajeDO> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<PersonajeDO> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------

	@OneToMany(mappedBy = "claseLinterna")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<GrupoDO> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(List<GrupoDO> grupoList) {
		this.grupoList = grupoList;
	}

	// --------------------------------------------------------------------------------
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public PlanetaDO getPlaneta() {
		return planeta;
	}

	public void setPlaneta(PlanetaDO planeta) {
		this.planeta = planeta;
	}

	// --------------------------------------------------------------------------------
	
	public void setHabilidadClaseLinternaList(
			List<HabilidadClaseLinternaDO> habilidadClaseLinternaList) {
		this.habilidadClaseLinternaList = habilidadClaseLinternaList;
	}

	@OneToMany(mappedBy = "claseLinterna")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<HabilidadClaseLinternaDO> getHabilidadClaseLinternaList() {
		return habilidadClaseLinternaList;
	}

	// --------------------------------------------------------------------------------
	
	public void setMisionClaseLinternaList(List<MisionClaseLinternaDO> misionClaseLinternaList) {
		this.misionClaseLinternaList = misionClaseLinternaList;
	}

	@OneToMany(mappedBy = "claseLinterna")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<MisionClaseLinternaDO> getMisionClaseLinternaList() {
		return misionClaseLinternaList;
	}
	
	// --------------------------------------------------------------------------------

}
