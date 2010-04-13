package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;

public class GrupoPersonajeDO implements DataObject {

	// --------------------------------------------------------------------------------

	private int id;
	
	// --------------------------------------------------------------------------------

	private List<PersonajeDO> personajeList = //
	new ArrayList<PersonajeDO>();

	private List<GrupoDO> grupoList = //
		new ArrayList<GrupoDO>();
	
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

	public List<PersonajeDO> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<PersonajeDO> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------

	public List<GrupoDO> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(List<GrupoDO> grupoList) {
		this.grupoList = grupoList;
	}

}
