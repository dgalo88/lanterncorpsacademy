package hlantern;

import lcaInterfaceDAO.IMisionDO;
import lcaInterfaceDAO.IMisionPersonajeDO;
import lcaInterfaceDAO.IPersonajeDO;
import dao.api.Reference;

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

	public Reference<IPersonajeDO> getPersonajeRef() {
		return personajeRef;
	}

	// --------------------------------------------------------------------------------

	public void setMisionRef(Reference<IMisionDO> misionRef) {
		this.misionRef = misionRef;
	}

	public Reference<IMisionDO> getMisionRef() {
		return misionRef;
	}
	
}
