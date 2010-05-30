

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
@Table(name = "t_grupo")
@Proxy(lazy = false)

public class Grupo {

	// --------------------------------------------------------------------------------
	
	private int id;
	private String nombre;
	private boolean estado;
	
	// --------------------------------------------------------------------------------

	private List<Personaje> personajeList = new ArrayList<Personaje>();
	private ClaseLinterna claseLinternaRef;
	// --------------------------------------------------------------------------------

	public Grupo() {
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
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "grupoRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<Personaje> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<Personaje> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------


	@ManyToOne
	public ClaseLinterna getClaseLinternaRef() {
		return claseLinternaRef;
	}

	public void setClaseLinternaRef(ClaseLinterna claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}

}
