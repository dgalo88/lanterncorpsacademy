package dao.lca;

import dao.api.DataObject;
import dao.api.Reference;

public class HabilidadActivaDO implements DataObject {

	// --------------------------------------------------------------------------------

	private int id;
	private int nivel_habilidad;
	// --------------------------------------------------------------------------------

	private Reference<PersonajeDO> personajeRef = new Reference<PersonajeDO>();
	private Reference<HabilidadDO> habilidadRef = new Reference<HabilidadDO>();
	
	// --------------------------------------------------------------------------------

	public HabilidadActivaDO() {
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
	
	public int getNivel_habilidad() {
		return nivel_habilidad;
	}

	public void setNivel_habilidad(int nivelHabilidad) {
		nivel_habilidad = nivelHabilidad;
	}
	
	// --------------------------------------------------------------------------------

	public Reference<PersonajeDO> getPersonajeRef() {
		return personajeRef;
	}

	public void setPersonajeRef(Reference<PersonajeDO> personajeRef) {
		this.personajeRef = personajeRef;
	}

	// --------------------------------------------------------------------------------

	public Reference<HabilidadDO> getHabilidadRef() {
		return habilidadRef;
	}

	public void setHabilidadRef(Reference<HabilidadDO> habilidadRef) {
		this.habilidadRef = habilidadRef;
	}

}
