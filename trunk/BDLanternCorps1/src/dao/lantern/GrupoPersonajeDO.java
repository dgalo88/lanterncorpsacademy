package dao.lantern;

import dao.api.DataObject;
import dao.api.Reference;

public class GrupoPersonajeDO implements DataObject {

	public static final String PERSONAJE_ID = "personajeId";
	public static final String GRUPO_ID 	= "grupoId";
	
	// --------------------------------------------------------------------------------

	private int id;
	
	// --------------------------------------------------------------------------------

	private Reference<PersonajeDO> personajeRef = new Reference<PersonajeDO>();
	
	private Reference<GrupoDO> grupoRef = new Reference<GrupoDO>();
	
	// --------------------------------------------------------------------------------

	public GrupoPersonajeDO() {
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

	public void setGrupoRef(Reference<GrupoDO> grupoRef) {
		this.grupoRef = grupoRef;
	}

	public Reference<GrupoDO> getGrupoRef() {
		return grupoRef;
	}

}
