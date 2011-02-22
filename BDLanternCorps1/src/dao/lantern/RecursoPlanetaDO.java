package dao.lantern;

import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoPlanetaDO;
import dao.api.Reference;

public class RecursoPlanetaDO implements IRecursoPlanetaDO {

	public static final String RECURSO_ID = "recursoId";
	public static final String PLANETA_ID = "planetaId";

	// --------------------------------------------------------------------------------

	private int id;

	// --------------------------------------------------------------------------------

	private Reference<IRecursoDO> recursoRef = new Reference<IRecursoDO>();

	private Reference<IPlanetaDO> planetaRef = new Reference<IPlanetaDO>();

	// --------------------------------------------------------------------------------

	public RecursoPlanetaDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	@Override
	public Reference<IRecursoDO> getRecursoRef() {
		return recursoRef;
	}

	@Override
	public Reference<IPlanetaDO> getPlanetaRef() {
		return planetaRef;
	}

	@Override
	public void setRecursoRef(Reference<IRecursoDO> recursoRef) {
		this.recursoRef = recursoRef;

	}

	@Override
	public void setPlanetaRef(Reference<IPlanetaDO> planetaRef) {
		this.planetaRef = planetaRef;

	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;

	}

}
