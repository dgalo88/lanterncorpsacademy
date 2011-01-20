package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IRecursoPersonajeDO extends DataObject{
	
	//----------------------------------------------------------------------------------------
	public abstract int getCantidad();
	
	public abstract void setCantidad(int cantidad);
	
	//--------------------------------------------------------------------------------------------------
	public abstract Reference<IPersonajeDO> getPersonajeRef();
	
	public abstract void setPersonajeRef(Reference<IPersonajeDO> personajeRef);
	
	//----------------------------------------------------------------------------------------------
	
	public abstract Reference<IRecursoDO> getRecursoRef();
	
	public abstract void setRecursoRef(Reference<IRecursoDO> recursoRef);

}
