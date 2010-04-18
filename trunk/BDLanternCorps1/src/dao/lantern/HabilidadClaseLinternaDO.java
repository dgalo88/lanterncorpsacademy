package dao.lantern;

import dao.api.DataObject;
import dao.api.Reference;

public class HabilidadClaseLinternaDO implements DataObject {

	public static final String ID="id";
	public static final String  HAB_REF= "habilidad_ref";
	public static final String  CLASE_REF= "clase_ref";
	
	// --------------------------------------------------------------------------------

	private int id;
	
	// --------------------------------------------------------------------------------

	private Reference<HabilidadDO> habilidadRef = new Reference<HabilidadDO>();
	
	private Reference<ClaseLinternaDO> claseLinternaRef = new Reference<ClaseLinternaDO>();
	
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

	public void setHabilidadRef(Reference<HabilidadDO> habilidadRef) {
		this.habilidadRef = habilidadRef;
	}

	public Reference<HabilidadDO> getHabilidadRef() {
		return habilidadRef;
	}

	// --------------------------------------------------------------------------------

	public void setClaseLinternaRef(Reference<ClaseLinternaDO> claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}

	public Reference<ClaseLinternaDO> getClaseLinternaRef() {
		return claseLinternaRef;
	}
	
}
