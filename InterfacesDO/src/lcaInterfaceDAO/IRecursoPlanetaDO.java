package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IRecursoPlanetaDO extends DataObject {

	public abstract int getCantidad_maxima_recurso();

	public abstract void setCantidad_maxima_recurso(int cantidad_maxima_recurso);

	public abstract Reference<IRecursoDO> getRecursoRef();

	public abstract void setRecursoRef(Reference<IRecursoDO> recursoRef);

	public abstract Reference<IPlanetaDO> getPlanetaRef();

	public abstract void setPlanetaRef(Reference<IPlanetaDO> planetaRef);

}
