package dao.lantern;
import lcaInterfaceDAO.IOfertaDO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoOfertaVentaDO;
import dao.api.Reference;


public class RecursoOfertaVentaDO implements IRecursoOfertaVentaDO {
	
	public static final String CANTIDAD ="cantidad";
	public static final String RECURSO_ID = "recursoId";
	public static final String OFERTA_ID ="ofertaId";
	
	//--------------------------------------------------------------------------------------------
	
	private int id;
	
	private int cantidad;
	
	//-----------------------------------------------------------------------------------------
	
	private Reference<IRecursoDO> recursoRef=//
		new Reference<IRecursoDO>();
	
	private Reference<IOfertaDO> ofertaRef=//
		new Reference<IOfertaDO>();
	
	//----------------------------------------------------------------------------------------
	
	public RecursoOfertaVentaDO(){
		
		//empty
	}
	// --------------------------------------------------------------------------------

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
// --------------------------------------------------------------------------------

	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	//--------------------------------------------------------------------------------------------------

	public Reference<IRecursoDO> getRecursoRef(){
		
		return recursoRef;
	}
	
	public void setRecursoRef(Reference<IRecursoDO> recursoRef){
	
		this.recursoRef=recursoRef;
	}
	
	//----------------------------------------------------------------------------------------------
	
	public Reference<IOfertaDO> getOfertaRef(){
		
		return ofertaRef;
	}
	
	public void setOfertaRef(Reference<IOfertaDO> ofertaRef)
	{
		this.ofertaRef=ofertaRef;
	}

}
