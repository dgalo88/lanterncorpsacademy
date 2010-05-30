package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IOrdenDO extends DataObject{

	public abstract int getPrioridad();

	public abstract void setPrioridad(int prioridad);

	public abstract void setObjetivoRef(Reference<IObjetivoDO> objetivoRef);

	public abstract Reference<IObjetivoDO> getObjetivoRef();

	public abstract void setMisionRef(Reference<IMisionDO> misionRef);

	public abstract Reference<IMisionDO> getMisionRef();

}