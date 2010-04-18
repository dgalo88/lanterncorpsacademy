package dao.lca;

import java.util.ArrayList;
import java.util.List;
import dao.api.DataObject;
import dao.api.Reference;

public class ObjetivoDO implements DataObject {

	public static final String DESCRIPCION = "descripcion";
	public static final String NUMERO = "numero_de_npc";
	public static final String PLANETA = "planeta_id";
	
	// --------------------------------------------------------------------------------

	private int id;
	private String descripcion;
	private int numero_de_npc;
	
	// --------------------------------------------------------------------------------
	
	private Reference<PlanetaDO> planetaRef = new Reference<PlanetaDO>();
	private List<OrdenDO> ordenList = new ArrayList<OrdenDO>();
	
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
	
	public int getNumero_de_npc() {
		return numero_de_npc;
	}

	public void setNumero_de_npc(int numeroDeNpc) {
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
	
	public void setOrdenList(List<OrdenDO> ordenList) {
		this.ordenList = ordenList;
	}

	public List<OrdenDO> getOrdenList() {
		return ordenList;
	}

}
