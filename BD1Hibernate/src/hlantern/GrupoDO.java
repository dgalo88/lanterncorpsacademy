package hlantern;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_grupo")
@Proxy(lazy = false)
public class GrupoDO {

	// --------------------------------------------------------------------------------
	
	public static final String NOMBRE = "nombre";
	public static final String ESTADO = "estado";
	
	public static final String CLASE_LINTERNA_ID = "claseLinternaId";
	
	// --------------------------------------------------------------------------------
	
	private int id;
	
	private String nombre;
	private boolean estado;
	
	// --------------------------------------------------------------------------------

	private List<PersonajeDO> PersonajeList = //
		new ArrayList<PersonajeDO>();

	
		
	private ClaseLinternaDO claseLinterna;
	
	// --------------------------------------------------------------------------------

	public GrupoDO() {
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

	@OneToMany(mappedBy = "grupo")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<PersonajeDO> getPersonajeList() {
		return PersonajeList;
	}

	public void setPersonajeList(List<PersonajeDO> personajeList) {
		PersonajeList = personajeList;
	}

	// --------------------------------------------------------------------------------


	@ManyToOne
	public ClaseLinternaDO getClaseLinterna() {
		return claseLinterna;
	}

	public void setClaseLinterna(ClaseLinternaDO claseLinterna) {
		this.claseLinterna = claseLinterna;
	}

}
