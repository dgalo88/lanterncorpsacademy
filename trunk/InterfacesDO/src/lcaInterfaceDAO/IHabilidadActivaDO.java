package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IHabilidadActivaDO extends DataObject{

	public abstract int getNivel_habilidad();

	public abstract void setNivel_habilidad(int nivelHabilidad);

	public abstract Reference<IPersonajeDO> getPersonajeRef();

	public abstract void setPersonajeRef(Reference<IPersonajeDO> personajeRef);

	public abstract Reference<IHabilidadDO> getHabilidadRef();

	public abstract void setHabilidadRef(Reference<IHabilidadDO> habilidadRef);

}