package dao.lantern;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IMisionClaseLinternaDO;
import lcaInterfaceDAO.IMisionDO;
import dao.api.Reference;

public class MisionClaseLinternaDO implements IMisionClaseLinternaDO {

	public static final String CLASE_LINTERNA_ID = "claseLinternaId";
	public static final String MISION_ID = "misionId";


	// --------------------------------------------------------------------------------

	private int id;

	// --------------------------------------------------------------------------------

	private Reference<IClaseLinternaDO> claseLinternaRef = new Reference<IClaseLinternaDO>();

	private Reference<IMisionDO> misionRef = new Reference<IMisionDO>();
		
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

	public Reference<IClaseLinternaDO> getClaseLinternaRef() {
		return claseLinternaRef;
	}

	public void setClaseLinternaRef(Reference<IClaseLinternaDO> claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}

	// --------------------------------------------------------------------------------

	public void setMisionRef(Reference<IMisionDO> misionRef) {
		this.misionRef = misionRef;
	}

	public Reference<IMisionDO> getMisionRef() {
		return misionRef;
	}
	
}
