package dao.lantern;

import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoPlanetaDO;
import dao.api.Reference;

public class RecursoPlanetaDO implements IRecursoPlanetaDO {

	public static final String RECURSO_ID = "recursoId";
	public static final String PLANETA_ID = "planetaId";
	public static final String CANTIDAD_MAXIMA_RECURSO = "cantidad_maxima_recurso";

	// --------------------------------------------------------------------------------

	private int id;
	private int cantidad_maxima_recurso;

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

	public void setCantidad_maxima_recurso(int cantidad_maxima_recurso) {
		this.cantidad_maxima_recurso = cantidad_maxima_recurso;
	}

	public int getCantidad_maxima_recurso() {
		return cantidad_maxima_recurso;
	}

}
