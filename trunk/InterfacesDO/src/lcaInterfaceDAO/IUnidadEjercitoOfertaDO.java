package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IUnidadEjercitoOfertaDO extends DataObject {

//---------------------------------------------------------------------------------------
	
	public abstract int getCantidad();
	
	public abstract void setCantidad(int cantidad);
	
	//---------------------------------------------------------------------------------------

	public abstract Reference<IUnidadEjercitoDO> getUnidadEjercitoaRef();
	
	public abstract void setUnidadEjercitoRef(Reference<IUnidadEjercitoDO> unidadEjercitoRef);
	
	//-----------------------------------------------------------------------------------------
	
	public abstract Reference<IOfertaDO> getOfertaRef();
	
	public abstract void setOfertaRef(Reference<IOfertaDO> ofertaRef);
	
	//----------------------------------------------------------------------------------------


}
