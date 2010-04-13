package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;

public class MisionPersonajeDO implements DataObject {

	// --------------------------------------------------------------------------------

	private int id;
	
	// --------------------------------------------------------------------------------

	private List<PersonajeDO> personajeList = //
	new ArrayList<PersonajeDO>();

	private List<MisionDO> misionList = //
		new ArrayList<MisionDO>();
	
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

	public List<PersonajeDO> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<PersonajeDO> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------

	public List<MisionDO> getMisionList() {
		return misionList;
	}

	public void setMisionList(List<MisionDO> MisionList) {
		this.misionList = misionList;
	}

}
