package dao.lca;

import java.util.ArrayList;
import java.util.List;
import dao.api.DataObject;
import dao.api.Reference;

public class ObjetivoDO implements DataObject {

	public static final String DESCRIPCION = "descripcion";
	public static final String NUMERO_DE_NPC = "numeroDeNpc";
	public static final String PLANETA_ID = "planetaId";
	
	// --------------------------------------------------------------------------------

	private int id;
	private String descripcion;
	private int numeroDeNpc;
	
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
	
	public int getNumeroDeNpc() {
		return numeroDeNpc;
	}

	public void setNumeroDeNpc(int numeroDeNpc) {
		this.numeroDeNpc = numeroDeNpc;
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
