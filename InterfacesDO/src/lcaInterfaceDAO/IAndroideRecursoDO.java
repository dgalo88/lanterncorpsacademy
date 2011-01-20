package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public interface IAndroideRecursoDO extends DataObject {

	public abstract int getCantidad();
	public abstract void setCantidad(int cantidad);
	
	
	//--------------------------------------------------------------------------------------------------
	public abstract Reference<IRecursoDO> getRecursoRef();
	
	public abstract void setRecursoRef(Reference<IRecursoDO> recursoRef);
	
	//----------------------------------------------------------------------------------------------
	
	public abstract Reference<IAndroideDO> getAndroideRef();
	
	public abstract void setAndroideRef(Reference<IAndroideDO> androideRef);

}
