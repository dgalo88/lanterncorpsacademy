package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IUnidadBasicaPersonajeDO extends DataObject{
	

	//---------------------------------------------------------------------------------------
	
	public abstract int getCantidad();
	
	public abstract void setCantidad(int cantidad);
	
	//---------------------------------------------------------------------------------------

	public abstract Reference<IUnidadBasicaDO> getUnidadBasicaRef();
	
	public abstract void setUnidadBasicaRef(Reference<IUnidadBasicaDO> unidadBasicaRef);
	
	//-----------------------------------------------------------------------------------------
	
	public abstract Reference<IPersonajeDO> getPersonajeRef();
	
	public abstract void setPersonajeRef(Reference<IPersonajeDO> personajeRef);
	
	//----------------------------------------------------------------------------------------
}
