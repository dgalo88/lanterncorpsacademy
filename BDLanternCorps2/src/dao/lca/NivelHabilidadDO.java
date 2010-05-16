package dao.lca;

import dao.api.DataObject;
import dao.api.Reference;

public class NivelHabilidadDO implements DataObject {

	public static final String NIVEL_DE_HABILIDAD = "nivelDeHabilidad";
	public static final String EFECTIVIDAD = "efectividad";
	public static final String COSTO_DE_ENERGIA = "costoDeEnergia";
	public static final String PROBABILIDAD = "probabilidad";
	public static final String HABILIDAD_ID = "habilidadId";
	
	// --------------------------------------------------------------------------------

	private int id;
	private int nivelDeHabilidad;
	private float efectividad;
	private float costoDeEnergia;
	private int probabilidad;
	
	// --------------------------------------------------------------------------------
	
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
	
	public int getNivel_de_habilidad() {
		return nivelDeHabilidad;
	}

	public void setNivel_de_habilidad(int nivelDeHabilidad) {
		this.nivelDeHabilidad = nivelDeHabilidad;
	}

	// --------------------------------------------------------------------------------
	
	public float getEfectividad() {
		return efectividad;
	}

	public void setEfectividad(int efectividad) {
		this.efectividad = efectividad;
	}

	// --------------------------------------------------------------------------------
	

	public float getCosto_de_energia() {
		return costoDeEnergia;
	}

	public void setCosto_de_energia(int costoDeEnergia) {
		this.costoDeEnergia = costoDeEnergia;
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
