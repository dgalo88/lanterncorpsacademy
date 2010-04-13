package dao.example;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;

public class HabilidadClaseLinternaDO implements DataObject {

	// --------------------------------------------------------------------------------

	private int id;
	
	// --------------------------------------------------------------------------------

	private List<HabilidadDO> habilidadList = //
	new ArrayList<HabilidadDO>();

	private List<ClaseLinternaDO> claseLinternaList = //
		new ArrayList<ClaseLinternaDO>();
	
	// --------------------------------------------------------------------------------

	public HabilidadClaseLinternaDO() {
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

	public List<HabilidadDO> getHabilidadList() {
		return habilidadList;
	}

	public void setHabilidadList(List<HabilidadDO> habilidadList) {
		this.habilidadList = habilidadList;
	}

	// --------------------------------------------------------------------------------

	public List<ClaseLinternaDO> getClaseLinternaList() {
		return claseLinternaList;
	}

	public void setClaseLinternaList(List<ClaseLinternaDO> ClaseLinternaList) {
		this.claseLinternaList = claseLinternaList;
	}

}
