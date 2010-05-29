package hlantern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_mision_personaje")
@Proxy(lazy = false)
public class MisionPersonajeDO {

	public static final String PERSONAJE_ID= "personajeId";
	public static final String MISION_ID= "misionId";
	
	// --------------------------------------------------------------------------------

	private int id;
	
	// --------------------------------------------------------------------------------

	private PersonajeDO personaje;
	
	private MisionDO mision;
	
	// --------------------------------------------------------------------------------

	public MisionPersonajeDO() {
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

	public void setPersonajeRef(PersonajeDO personajeRef) {
		this.personaje = personajeRef;
	}
	@ManyToOne
	public PersonajeDO getPersonajeRef() {
		return personaje;
	}

	// --------------------------------------------------------------------------------

	public void setMisionRef(MisionDO misionRef) {
		this.mision = misionRef;
	}
	@ManyToOne
	public MisionDO getMisionRef() {
		return mision;
	}
	
}
