package dao.lantern;

import lcaInterfaceDAO.IHabilidadActivaDO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.IPersonajeDO;
import dao.api.Reference;

public class HabilidadActivaDO implements IHabilidadActivaDO {

	public static final String NIVEL_HABILIDAD = "nivel_habilidad";
	
	public static final String PERSONAJE_ID = "personajeId";
	public static final String HABILIDAD_ID = "habilidadId";
	
// --------------------------------------------------------------------------------

	private int id;
	
	private int nivel_habilidad;
	
	// --------------------------------------------------------------------------------

	private Reference<IPersonajeDO> personajeRef = new Reference<IPersonajeDO>();
	
	private Reference<IHabilidadDO> habilidadRef = new Reference<IHabilidadDO>();
		
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

	public void setPersonajeRef(Reference<IPersonajeDO> personajeRef) {
		this.personajeRef = personajeRef;
	}

	public Reference<IPersonajeDO> getPersonajeRef() {
		return personajeRef;
	}
	
	// --------------------------------------------------------------------------------

	public void setHabilidadRef(Reference<IHabilidadDO> habilidadRef) {
		this.habilidadRef = habilidadRef;
	}

	public Reference<IHabilidadDO> getHabilidadRef() {
		return habilidadRef;
	}
	
}
