package dao.lca;

import dao.api.DataObject;
import dao.api.Reference;

public class OrdenDO implements DataObject {
	
	public static final String PRIORIDAD = "prioridad";
	public static final String OBJETIVO_ID = "objetivoId";
	public static final String MISION_ID = "misionId";

	// --------------------------------------------------------------------------------

	private int id;
	private int prioridad;
	
	// --------------------------------------------------------------------------------

	private Reference<ObjetivoDO> objetivoRef = new Reference<ObjetivoDO>();
	private Reference<MisionDO> misionRef = new Reference<MisionDO>();
	
	// --------------------------------------------------------------------------------

	public OrdenDO() {
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

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	// --------------------------------------------------------------------------------
	
	public void setObjetivoRef(Reference<ObjetivoDO> objetivoRef) {
		this.objetivoRef = objetivoRef;
	}

	public Reference<ObjetivoDO> getObjetivoRef() {
		return objetivoRef;
	}

	// --------------------------------------------------------------------------------
	
	public void setMisionRef(Reference<MisionDO> misionRef) {
		this.misionRef = misionRef;
	}

	public Reference<MisionDO> getMisionRef() {
		return misionRef;
	}
		
}
