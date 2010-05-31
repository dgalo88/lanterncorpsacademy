
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;


@Entity
@Table(name = "t_habilidad")
@Proxy(lazy = false)

public class Habilidad {

	// --------------------------------------------------------------------------------

	private int id;
	private String nombre;
	private int costoDeAprendizaje;
	private int tipo;
	
	private List<HabilidadClaseLinterna> habilidadClaseLinternaList = new ArrayList<HabilidadClaseLinterna>();
	private List<NivelHabilidad> nivelHabilidadList = new ArrayList<NivelHabilidad>();
	private List<HabilidadActiva> habilidadActivaList = new ArrayList<HabilidadActiva>();
		// --------------------------------------------------------------------------------

	public Habilidad() {
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
	
	public int getCosto_de_aprendizaje() {
		return costoDeAprendizaje;
	}

	public void setCosto_de_aprendizaje(int costoDeAprendizaje) {
		this.costoDeAprendizaje = costoDeAprendizaje;
	}

	// --------------------------------------------------------------------------------
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "habilidadRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<HabilidadClaseLinterna> getHabilidadClaseLinternaList() {
		return habilidadClaseLinternaList;
	}

	public void setHabilidadClaseLinternaList(List<HabilidadClaseLinterna> habilidadClaseLinternaList) {
		this.habilidadClaseLinternaList = habilidadClaseLinternaList;
	}

	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "habilidadRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<NivelHabilidad> getNivelHabilidadList() {
		return nivelHabilidadList;
	}

	public void setNivelHabilidadList(List<NivelHabilidad> nivelHabilidadList) {
		this.nivelHabilidadList = nivelHabilidadList;
	}

	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "habilidadRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<HabilidadActiva> getHabilidadActivaList() {
		return habilidadActivaList;
	}
	public void setHabilidadActivaList(List<HabilidadActiva> habilidadActivaList) {
		this.habilidadActivaList = habilidadActivaList;
	}

	
}
