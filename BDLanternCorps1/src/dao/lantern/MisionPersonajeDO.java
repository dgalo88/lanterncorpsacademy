package dao.lantern;

import dao.api.DataObject;
import dao.api.Reference;

public class MisionPersonajeDO implements DataObject {

	// --------------------------------------------------------------------------------

	private int id;
	
	// --------------------------------------------------------------------------------

	private Reference<PersonajeDO> personajeRef = new Reference<PersonajeDO>();
	
	private Reference<MisionDO> misionRef = new Reference<MisionDO>();
	
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

	public void setPersonajeRef(Reference<PersonajeDO> personajeRef) {
		this.personajeRef = personajeRef;
	}

	public Reference<PersonajeDO> getPersonajeRef() {
		return personajeRef;
	}

	// --------------------------------------------------------------------------------

	public void setMisionRef(Reference<MisionDO> misionRef) {
		this.misionRef = misionRef;
	}

	public Reference<MisionDO> getMisionRef() {
		return misionRef;
	}
	
}
