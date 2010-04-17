package dao.lantern;

import dao.api.DataObject;
import dao.api.Reference;

public class HabilidadActivaDO implements DataObject {

	public static final String NIVEL_HABILIDAD = "nivel_habilidad";
	
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
	
	public int getNivelHabilidad() {
		return nivel_habilidad;
	}

	public void setNivelHabilidad(int nivelHabilidad) {
		nivel_habilidad = nivelHabilidad;
	}

	// --------------------------------------------------------------------------------

	public void setPersonajeRef(Reference<PersonajeDO> personajeRef) {
		this.personajeRef = personajeRef;
	}

	public Reference<PersonajeDO> getPersonajeRef() {
		return personajeRef;
	}
	
	// --------------------------------------------------------------------------------

	public void setHabilidadRef(Reference<HabilidadDO> habilidadRef) {
		this.habilidadRef = habilidadRef;
	}

	public Reference<HabilidadDO> getHabilidadRef() {
		return habilidadRef;
	}
	
}
