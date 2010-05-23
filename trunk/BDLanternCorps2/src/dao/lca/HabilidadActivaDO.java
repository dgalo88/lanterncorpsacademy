package dao.lca;

import lcaInterfaceDAO.IHabilidadActivaDO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.IPersonajeDO;
import dao.api.Reference;


public class HabilidadActivaDO implements IHabilidadActivaDO {
	
	public static final String NIVEL_HABILIDAD = "nivelHabilidad";
	public static final String PERSONAJE_ID = "personajeId";
	public static final String HABILIDAD_ID = "habilidadId";
	
	// --------------------------------------------------------------------------------

	private int id;
	private int nivelHabilidad;
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
		return nivelHabilidad;
	}

	public void setNivel_habilidad(int nivelHabilidad) {
		this.nivelHabilidad = nivelHabilidad;
	}
	
	// --------------------------------------------------------------------------------

	public Reference<IPersonajeDO> getPersonajeRef() {
		return personajeRef;
	}

	public void setPersonajeRef(Reference<IPersonajeDO> personajeRef) {
		this.personajeRef = personajeRef;
	}

	// --------------------------------------------------------------------------------

	public Reference<IHabilidadDO> getHabilidadRef() {
		return habilidadRef;
	}

	public void setHabilidadRef(Reference<IHabilidadDO> habilidadRef) {
		this.habilidadRef = habilidadRef;
	}

}
