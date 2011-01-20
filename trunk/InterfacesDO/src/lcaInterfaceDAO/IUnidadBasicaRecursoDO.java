package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IUnidadBasicaRecursoDO extends DataObject {
	
	//---------------------------------------------------------------------------------------
	
	public abstract int getCantidad();
	
	public abstract void setCantidad(int cantidad);
	
	//---------------------------------------------------------------------------------------

	public abstract Reference<IUnidadBasicaDO> getUnidadBasicaRef();
	
	public abstract void setUnidadBasicaRef(Reference<IUnidadBasicaDO> unidadBasicaRef);
	
	//-----------------------------------------------------------------------------------------
	
	public abstract Reference<IRecursoDO> getRecursoRef();
	
	public abstract void setRecursoRef(Reference<IRecursoDO> recursoRef);
	
	//----------------------------------------------------------------------------------------


}
