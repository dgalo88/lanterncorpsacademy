package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IMisionPersonajeDO extends DataObject{

	public abstract void setPersonajeRef(Reference<IPersonajeDO> personajeRef);

	public abstract Reference<IPersonajeDO> getPersonajeRef();

	public abstract void setMisionRef(Reference<IMisionDO> misionRef);

	public abstract Reference<IMisionDO> getMisionRef();

}