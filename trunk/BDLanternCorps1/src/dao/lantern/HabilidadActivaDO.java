package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;

public class HabilidadActivaDO implements DataObject {

	// --------------------------------------------------------------------------------

	private int id;
	private int nivel_habilidad;
	// --------------------------------------------------------------------------------

	private List<PersonajeDO> personajeList = //
	new ArrayList<PersonajeDO>();

	private List<HabilidadDO> habilidadList = //
		new ArrayList<HabilidadDO>();
	
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

	public List<PersonajeDO> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<PersonajeDO> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------

	public List<HabilidadDO> getHabilidadList() {
		return habilidadList;
	}

	public void setHabilidadList(List<HabilidadDO> habilidadList) {
		this.habilidadList = habilidadList;
	}

}
