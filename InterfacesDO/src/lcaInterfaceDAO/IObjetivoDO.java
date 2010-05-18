package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public interface IObjetivoDO extends DataObject {

	public abstract String getDescripcion();

	public abstract void setDescripcion(String descripcion);

	public abstract int getNumeroDeNpc();

	public abstract void setNumeroDeNpc(int numeroDeNpc);

	public abstract Reference<IPlanetaDO> getPlanetaRef();

	public abstract void setPlanetaRef(Reference<IPlanetaDO> planetaRef);

	public abstract void setOrdenList(List<IOrdenDO> ordenList);

	public abstract List<IOrdenDO> getOrdenList();

}