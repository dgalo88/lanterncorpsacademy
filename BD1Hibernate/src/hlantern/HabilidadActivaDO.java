package hlantern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_hablilidad_activa")
@Proxy(lazy = false)
public class HabilidadActivaDO {

	public static final String NIVEL_HABILIDAD = "nivel_habilidad";
	
	public static final String PERSONAJE_ID = "personajeId";
	public static final String HABILIDAD_ID = "habilidadId";
	
// --------------------------------------------------------------------------------

	private int id;
	
	private int nivel_habilidad;
	
	// --------------------------------------------------------------------------------

	private PersonajeDO personaje;
	
	private HabilidadDO habilidad;
		
	// --------------------------------------------------------------------------------

	public HabilidadActivaDO() {
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
		return nivel_habilidad;
	}

	public void setNivel_habilidad(int nivelHabilidad) {
		nivel_habilidad = nivelHabilidad;
	}

	// --------------------------------------------------------------------------------

	public void setPersonaje(PersonajeDO personaje) {
		this.personaje = personaje;
	}
	
	@ManyToOne
	public PersonajeDO getPersonaje() {
		return personaje;
	}
	
	// --------------------------------------------------------------------------------

	public void setHabilidad(HabilidadDO habilidad) {
		this.habilidad = habilidad;
	}
	
	@ManyToOne
	public HabilidadDO getHabilidad() {
		return habilidad;
	}
	
}
