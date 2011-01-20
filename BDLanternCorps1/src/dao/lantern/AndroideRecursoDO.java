package dao.lantern;

import dao.api.Reference;
import lcaInterfaceDAO.IAndroideDO;
import lcaInterfaceDAO.IAndroideRecursoDO;
import lcaInterfaceDAO.IRecursoDO;

public class AndroideRecursoDO implements IAndroideRecursoDO{
	
	public static final String CANTIDAD ="cantidad";
	public static final String RECURSO_ID = "recursoId";
	public static final String ANDROIDE_ID ="androideId";
	
	//--------------------------------------------------------------------------------------------
	
	private int id;
	
	private int cantidad;
	
	//-----------------------------------------------------------------------------------------
	
	private Reference<IRecursoDO> recursoRef=//
		new Reference<IRecursoDO>();
	
	private Reference<IAndroideDO> androideRef=//
		new Reference<IAndroideDO>();
	
	//----------------------------------------------------------------------------------------
	
	public AndroideRecursoDO(){
		
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
	
	public Reference<IAndroideDO> getAndroideRef(){
		
		return androideRef;
	}
	
	public void setAndroideRef(Reference<IAndroideDO> androideRef)
	{
		this.androideRef=androideRef;
	}
}
