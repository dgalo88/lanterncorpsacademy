package dao.lca;

import dao.api.DataObject;
import dao.api.Reference;


public class HabilidadActivaDO implements DataObject {
	
	public static final String NIVEL_HABILIDAD = "nivelHabilidad";
	public static final String PERSONAJE_ID = "personajeId";
	public static final String HABILIDAD_ID = "habilidadId";
	
	// --------------------------------------------------------------------------------

	private int id;
	private int nivelHabilidad;
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
		return nivelHabilidad;
	}

	public void setNivel_habilidad(int nivelHabilidad) {
		this.nivelHabilidad = nivelHabilidad;
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
