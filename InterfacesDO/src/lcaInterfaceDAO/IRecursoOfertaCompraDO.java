package lcaInterfaceDAO;
import dao.api.DataObject;
import dao.api.Reference;


public interface IRecursoOfertaCompraDO extends DataObject{

	
	//----------------------------------------------------------------------------------------
	public abstract int getCantidad();
	
	public abstract void setCantidad(int cantidad);
	
	//--------------------------------------------------------------------------------------------------
	public abstract Reference<IRecursoDO> getRecursoRef();
	
	public abstract void setRecursoRef(Reference<IRecursoDO> recursoRef);
	
	//----------------------------------------------------------------------------------------------
	
	public abstract Reference<IOfertaDO> getOfertaRef();
	
	public abstract void setOfertaRef(Reference<IOfertaDO> ofertaRef);

}
