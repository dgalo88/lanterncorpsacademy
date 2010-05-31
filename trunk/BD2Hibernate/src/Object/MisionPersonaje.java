package Object;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_misionpersonaje")
@Proxy(lazy = false)
public class MisionPersonaje {

	// --------------------------------------------------------------------------------

	private int id;

	// --------------------------------------------------------------------------------

	private Personaje personajeRef;
	private Mision misionRef;

	// --------------------------------------------------------------------------------

	public MisionPersonaje() {
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

	@ManyToOne
	public Personaje getPersonajeRef() {
		return personajeRef;
	}

	public void setPersonajeRef(Personaje personajeRef) {
		this.personajeRef = personajeRef;
	}

	// --------------------------------------------------------------------------------

	@ManyToOne
	public Mision getMisionRef() {
		return misionRef;
	}

	public void setMisionRef(Mision misionRef) {
		this.misionRef = misionRef;
	}

}
