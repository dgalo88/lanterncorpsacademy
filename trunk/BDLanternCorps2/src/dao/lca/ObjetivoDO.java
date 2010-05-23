package dao.lca;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IObjetivoDO;
import lcaInterfaceDAO.IOrdenDO;
import lcaInterfaceDAO.IPlanetaDO;
import dao.api.Reference;

public class ObjetivoDO implements IObjetivoDO {

	public static final String DESCRIPCION = "descripcion";
	public static final String NUMERO_DE_NPC = "numeroDeNpc";
	public static final String PLANETA_ID = "planetaId";
	
	// --------------------------------------------------------------------------------

	private int id;
	private String descripcion;
	private int numeroDeNpc;
	
	// --------------------------------------------------------------------------------
	
	private Reference<IPlanetaDO> planetaRef = new Reference<IPlanetaDO>();
	private List<IOrdenDO> ordenList = new ArrayList<IOrdenDO>();
	
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

	public Reference<IPlanetaDO> getPlanetaRef() {
		return planetaRef;
	}

	public void setPlanetaRef(Reference<IPlanetaDO> planetaRef) {
		this.planetaRef = planetaRef;
	}

	// --------------------------------------------------------------------------------
	
	public void setOrdenList(List<IOrdenDO> ordenList) {
		this.ordenList = ordenList;
	}

	public List<IOrdenDO> getOrdenList() {
		return ordenList;
	}

}
