package hlantern;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_habilidad")
@Proxy(lazy = false)
public class HabilidadDO{

	public static final String ID     	= "id";
	public static final String NOMBRE 	= "nombre";
	public static final String COSTO_DE_APRENDIZAJE   	= "costo_aprendizaje";
	public static final String TIPO     = "tipo";
	
	public static final String CLASE_ID= "claseId";
	public static final String NIVEL_ID= "nivelId";
	public static final String HAB_ACTIVA_ID= "hab_activa_id";
	
	// --------------------------------------------------------------------------------

	private int id;
	
	private String nombre;
	private int costo_de_aprendizaje;
	private int tipo;
	
	private List<HabilidadClaseLinternaDO> habilidadClaseLinternaList = //
		new ArrayList<HabilidadClaseLinternaDO>();
	
	private List<NivelHabilidadDO> nivelHabilidadList = //
		new ArrayList<NivelHabilidadDO>();

	private List<HabilidadActivaDO> habilidadActivaList = //
		new ArrayList<HabilidadActivaDO>();

	
	// --------------------------------------------------------------------------------

	public HabilidadDO() {
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
		return costo_de_aprendizaje;
	}

	public void setCosto_de_aprendizaje(int costoDeAprendizaje) {
		costo_de_aprendizaje = costoDeAprendizaje;
	}


	// --------------------------------------------------------------------------------
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	// --------------------------------------------------------------------------------

	public void setHabilidadClaseLinternaList(List<HabilidadClaseLinternaDO> habilidadClaseLinternaList) {
		this.habilidadClaseLinternaList = habilidadClaseLinternaList;
	}

	@OneToMany(mappedBy = "hablidadRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<HabilidadClaseLinternaDO> getHabilidadClaseLinternaList() {
		return habilidadClaseLinternaList;
	}
	
	// --------------------------------------------------------------------------------
	
	public void setNivelHabilidadList(List<NivelHabilidadDO> nivelHabilidadList) {
		this.nivelHabilidadList = nivelHabilidadList;
	}

	@OneToMany(mappedBy = "hablidadRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<NivelHabilidadDO> getNivelHabilidadList() {
		return nivelHabilidadList;
	}

	// --------------------------------------------------------------------------------
	
	public void setHabilidadActivaList(List<HabilidadActivaDO> habilidadActivaList) {
		this.habilidadActivaList = habilidadActivaList;
	}

	@OneToMany(mappedBy = "hablidadRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<HabilidadActivaDO> getHabilidadActivaList() {
		return habilidadActivaList;
	}

}
