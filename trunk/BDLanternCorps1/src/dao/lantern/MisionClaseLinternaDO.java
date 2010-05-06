package dao.lantern;

import dao.api.DataObject;
import dao.api.Reference;

public class MisionClaseLinternaDO implements DataObject {

	public static final String CLASE_LINTERNA_ID = "claseLinternaId";
	public static final String MISION_ID = "misionId";


	// --------------------------------------------------------------------------------

	private int id;

	// --------------------------------------------------------------------------------

	private Reference<ClaseLinternaDO> claseLinternaRef = new Reference<ClaseLinternaDO>();

	private Reference<MisionDO> misionRef = new Reference<MisionDO>();
		
	// --------------------------------------------------------------------------------

	public MisionClaseLinternaDO() {
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

	public Reference<ClaseLinternaDO> getClaseLinternaRef() {
		return claseLinternaRef;
	}

	public void setClaseLinternaRef(Reference<ClaseLinternaDO> claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}

	// --------------------------------------------------------------------------------

	public void setMisionRef(Reference<MisionDO> misionRef) {
		this.misionRef = misionRef;
	}

	public Reference<MisionDO> getMisionRef() {
		return misionRef;
	}
	
}
