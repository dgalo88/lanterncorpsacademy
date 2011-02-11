package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IOfertaPersonajeDO extends DataObject {

	public abstract Reference<IOfertaDO> getOfertaRef();

	public abstract void setOfertaRef(Reference<IOfertaDO> ofertaRef);

	public abstract Reference<IPersonajeDO> getPersonajeRef();

	public abstract void setPersonajeRef(Reference<IPersonajeDO> personajeRef);

}
