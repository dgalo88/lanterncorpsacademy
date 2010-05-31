package Object;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_habilidadActiva")
@Proxy(lazy = false)
public class HabilidadActiva{

	
	// --------------------------------------------------------------------------------

	private int id;
	private int nivelHabilidad;
	// --------------------------------------------------------------------------------

	private Personaje personajeRef ;
	private Habilidad habilidadRef;
	
	// --------------------------------------------------------------------------------

	public HabilidadActiva() {
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
	
	public int getNivel_habilidad() {
		return nivelHabilidad;
	}

	public void setNivel_habilidad(int nivelHabilidad) {
		this.nivelHabilidad = nivelHabilidad;
	}
	
	// --------------------------------------------------------------------------------
	@ManyToOne
	public Personaje getPersonajeRef() {
		return personajeRef;
	}

	public void setPersonajeRef(Personaje personajeRef) {
		this.personajeRef = personajeRef;
	}

	// --------------------------------------------------------------------------------

	@ManyToOne
	public Habilidad getHabilidadRef() {
		return habilidadRef;
	}

	public void setHabilidadRef(Habilidad habilidadRef) {
		this.habilidadRef = habilidadRef;
	}

}
