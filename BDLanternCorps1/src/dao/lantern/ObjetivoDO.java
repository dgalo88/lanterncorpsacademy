package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public class ObjetivoDO implements DataObject {

	public static final String DESCRIPCION = "descripcion";
	public static final String PLANETA_ID = "planetaId";
	public static final String ORDEN_ID = "ordenId";
	
	// --------------------------------------------------------------------------------

	private int id;

	private String descripcion;
	private int numero_de_npc;
	
	private Reference<PlanetaDO> planetaRef = new Reference<PlanetaDO>();
	private Reference<OrdenDO> ordenRef = new Reference<OrdenDO>();
	
	// --------------------------------------------------------------------------------

	public ObjetivoDO() {
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// --------------------------------------------------------------------------------
	
	public int getNumeroDeNpc() {
		return numero_de_npc;
	}

	public void setNumeroDeNpc(int numeroDeNpc) {
		numero_de_npc = numeroDeNpc;
	}

	// --------------------------------------------------------------------------------

	public Reference<PlanetaDO> getPlanetaRef() {
		return planetaRef;
	}

	public void setPlanetaRef(Reference<PlanetaDO> planetaRef) {
		this.planetaRef = planetaRef;
	}

	// --------------------------------------------------------------------------------

	public Reference<OrdenDO> getOrdenRef() {
		return ordenRef;
	}

	public void setOrdenRef(Reference<OrdenDO> ordenRef) {
		this.ordenRef = ordenRef;
	}
	
}
