package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface ITecnologiaRecursoDO extends DataObject {
	
	
	public abstract int getCantidad();
	public abstract void setCantidad(int cantidad);
	
	public abstract int getRecurso();
	public abstract void setRecurso(int recurso);
	
	//----------------------------------------------------------------------------------------
	
	public abstract Reference<IRecursoDO> getRecursoRef();
	
	public abstract void setRecursoRef(Reference<IRecursoDO> recursoRef);
	//-----------------------------------------------------------------------------------------

	public abstract Reference<ITecnologiaDO> getTecnologiaRef();
	
	public abstract void setTecnologiaRef(Reference<ITecnologiaDO> tecnologiaRef);
	
}
