package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IRecursoPlanetaDO extends DataObject {

	public abstract Reference<IRecursoDO> getRecursoRef();

	public abstract void setRecursoRef(Reference<IRecursoDO> recursoRef);

	public abstract Reference<IPlanetaDO> getPlanetaRef();

	public abstract void setPlanetaRef(Reference<IPlanetaDO> planetaRef);

}
