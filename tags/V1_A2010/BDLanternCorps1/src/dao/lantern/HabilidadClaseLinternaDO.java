package dao.lantern;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IHabilidadClaseLinternaDO;
import lcaInterfaceDAO.IHabilidadDO;
import dao.api.Reference;

public class HabilidadClaseLinternaDO implements IHabilidadClaseLinternaDO {

	public static final String  HABILIDAD_ID= "habilidadId";
	public static final String  CLASE_LINTERNA_ID= "claselinternaId";
	
	// --------------------------------------------------------------------------------

	private int id;
	
	// --------------------------------------------------------------------------------

	private Reference<IHabilidadDO> habilidadRef = new Reference<IHabilidadDO>();
	
	private Reference<IClaseLinternaDO> claseLinternaRef = new Reference<IClaseLinternaDO>();
	
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

	public void setHabilidadRef(Reference<IHabilidadDO> habilidadRef) {
		this.habilidadRef = habilidadRef;
	}

	public Reference<IHabilidadDO> getHabilidadRef() {
		return habilidadRef;
	}

	// --------------------------------------------------------------------------------

	public void setClaseLinternaRef(Reference<IClaseLinternaDO> claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}

	public Reference<IClaseLinternaDO> getClaseLinternaRef() {
		return claseLinternaRef;
	}
	
}
