package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface ITecnologiaPersonajeDO extends DataObject {
	
	public abstract int getPersonaje();
	public abstract void setPersonaje(int personaje);
	
	public abstract int getTecnologia();
	public abstract void setTecnologia(int tecnologia);
	
	//----------------------------------------------------------------------------------------
	
	public abstract Reference<IPersonajeDO> getPersonajeRef();
	
	public abstract void setPersonajeRef(Reference<IPersonajeDO> personajeRef);
	//-----------------------------------------------------------------------------------------

	public abstract Reference<ITecnologiaDO> getTecnologiaRef();
	
	public abstract void setTecnologiaRef(Reference<ITecnologiaDO> tecnologiaRef);

}
