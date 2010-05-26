package hlantern;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IObjetivoDO;
import lcaInterfaceDAO.IOrdenDO;
import lcaInterfaceDAO.IPlanetaDO;
import dao.api.Reference;

public class ObjetivoDO implements IObjetivoDO {

	public static final String DESCRIPCION = "descripcion";
	public static final String NUMERO_DE_NPC = "numero_de_npc";
	
	public static final String PLANETA_ID = "planetaId";
	public static final String ORDEN_ID = "ordenId";
	
	// --------------------------------------------------------------------------------

	private int id;

	private String descripcion;
	private int numero_de_npc;
	
	// --------------------------------------------------------------------------------
	
	private Reference<IPlanetaDO> planetaRef = new Reference<IPlanetaDO>();
	
	private List<IOrdenDO> OrdenList = //
		new ArrayList<IOrdenDO>();
	
	private Reference<IOrdenDO> ordenRef = new Reference<IOrdenDO>();
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

	public Reference<IPlanetaDO> getPlanetaRef() {
		return planetaRef;
	}

	public void setPlanetaRef(Reference<IPlanetaDO> planetaRef) {
		this.planetaRef = planetaRef;
	}
	
	// --------------------------------------------------------------------------------

	public void setOrdenList(List<IOrdenDO> ordenList) {
		OrdenList = ordenList;
	}

	public List<IOrdenDO> getOrdenList() {
		return OrdenList;
	}
	
	// --------------------------------------------------------------------------------

	public Reference<IOrdenDO> getOrdenRef() {
		return ordenRef;
	}

	public void setOrdenRef(Reference<IOrdenDO> ordenRef) {
		this.ordenRef = ordenRef;
	}
}
