package hlantern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lcaInterfaceDAO.IMisionDO;
import lcaInterfaceDAO.IMisionPersonajeDO;
import lcaInterfaceDAO.IPersonajeDO;
import dao.api.Reference;

@Entity
@Table(name = "t_mision_personaje")
@Proxy(lazy = false)
public class MisionPersonajeDO implements IMisionPersonajeDO {

	public static final String PERSONAJE_ID= "personajeId";
	public static final String MISION_ID= "misionId";
	
	// --------------------------------------------------------------------------------

	private int id;
	
	// --------------------------------------------------------------------------------

	private Reference<IPersonajeDO> personajeRef = new Reference<IPersonajeDO>();
	
	private Reference<IMisionDO> misionRef = new Reference<IMisionDO>();
	
	// --------------------------------------------------------------------------------

	public MisionPersonajeDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	@Override	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// --------------------------------------------------------------------------------

	public void setPersonajeRef(Reference<IPersonajeDO> personajeRef) {
		this.personajeRef = personajeRef;
	}
	@ManyToOne
	public Reference<IPersonajeDO> getPersonajeRef() {
		return personajeRef;
	}

	// --------------------------------------------------------------------------------

	public void setMisionRef(Reference<IMisionDO> misionRef) {
		this.misionRef = misionRef;
	}
	@ManyToOne
	public Reference<IMisionDO> getMisionRef() {
		return misionRef;
	}
	
}
