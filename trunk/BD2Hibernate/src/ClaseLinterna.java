

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_claseLinterna")
@Proxy(lazy = false)

public class ClaseLinterna {

	private int id;
	private String color;
	private String nombreDeCuerpoLinterna;
	
	// --------------------------------------------------------------------------------

	private List<Personaje> personajeList;
	private List<Grupo> grupoList;
	private List<HabilidadClaseLinterna> habilidadClaseLinternaList;
	private List<MisionClaseLinterna> misionClaseLinternaList;
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
