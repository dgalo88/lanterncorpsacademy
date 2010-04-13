package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;

public class OrdenDO implements DataObject {

	// --------------------------------------------------------------------------------

	private int id;

	private int prioridad;
	
	// --------------------------------------------------------------------------------

	private List<ObjetivoDO> objetivoList = //
	new ArrayList<ObjetivoDO>();

	private List<MisionDO> misionList = //
		new ArrayList<MisionDO>();
	
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


	public List<ObjetivoDO> getObjetivoList() {
		return objetivoList;
	}

	public void setObjetivoList(List<ObjetivoDO> objetivoList) {
		this.objetivoList = objetivoList;
	}

	// --------------------------------------------------------------------------------

	public List<MisionDO> getMisionList() {
		return misionList;
	}

	public void setMisionList(List<MisionDO> MisionList) {
		this.misionList = misionList;
	}

}
