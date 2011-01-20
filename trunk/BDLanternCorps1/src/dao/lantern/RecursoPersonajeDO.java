package dao.lantern;

import dao.api.Reference;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoPersonajeDO;

public class RecursoPersonajeDO implements IRecursoPersonajeDO{

	public static final String CANTIDAD ="cantidad";
	public static final String RECURSO_ID = "recursoId";
	public static final String PERSONAJE_ID ="personajeId";
	
	//--------------------------------------------------------------------------------------------
	
	private int id;
	
	private int cantidad;
	
	//-----------------------------------------------------------------------------------------
	
	private Reference<IRecursoDO> recursoRef=//
		new Reference<IRecursoDO>();
	
	private Reference<IPersonajeDO> personajeRef=//
		new Reference<IPersonajeDO>();
	
	//----------------------------------------------------------------------------------------
	
	public RecursoPersonajeDO(){
		
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
	
	public Reference<IPersonajeDO> getPersonajeRef(){
		
		return personajeRef;
	}
	
	public void setPersonajeRef(Reference<IPersonajeDO> personajeRef)
	{
		this.personajeRef=personajeRef;
	}
}
