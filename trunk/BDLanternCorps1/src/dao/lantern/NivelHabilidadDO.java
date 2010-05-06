package dao.lantern;

import dao.api.DataObject;
import dao.api.Reference;

public class NivelHabilidadDO implements DataObject {

	// --------------------------------------------------------------------------------
	
	public static final String NIVEL_DE_HABILIDAD 	= "nivel_de_habilidad";
	public static final String EFECTIVIDAD 			= "efectividad";
	public static final String COSTO_DE_ENERGIA 	= "costo_de_energia";
	public static final String PROBABILIDAD 		= "probabilidad";

	public static final String HABILIDAD_ID = "habilidadId";
	
	// --------------------------------------------------------------------------------

	private int id;
	
	private int nivel_de_habilidad;
	private int efectividad;
	private int costo_de_energia;
	private int probabilidad;
	
	private Reference<HabilidadDO> habilidadRef = new Reference<HabilidadDO>();
	
	// --------------------------------------------------------------------------------

	public NivelHabilidadDO() {
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
	
	public int getNivelDeHabilidad() {
		return nivel_de_habilidad;
	}

	public void setNivelDeHabilidad(int nivelDeHabilidad) {
		nivel_de_habilidad = nivelDeHabilidad;
	}

	// --------------------------------------------------------------------------------
	
	public int getEfectividad() {
		return efectividad;
	}

	public void setEfectividad(int efectividad) {
		this.efectividad = efectividad;
	}

	// --------------------------------------------------------------------------------
	

	public int getCostoDeEnergia() {
		return costo_de_energia;
	}

	public void setCostoDeEnergia(int costoDeEnergia) {
		costo_de_energia = costoDeEnergia;
	}
	
	// --------------------------------------------------------------------------------
	
	public int getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(int probabilidad) {
		this.probabilidad = probabilidad;
	}
	
	// --------------------------------------------------------------------------------
	
	public Reference<HabilidadDO> getHabilidadRef() {
		return habilidadRef;
	}

	public void setHabilidadRef(Reference<HabilidadDO> habilidadRef) {
		this.habilidadRef = habilidadRef;
	}
	
}
