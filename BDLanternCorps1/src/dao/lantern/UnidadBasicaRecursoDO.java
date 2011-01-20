package dao.lantern;

import dao.api.Reference;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IUnidadBasicaDO;
import lcaInterfaceDAO.IUnidadBasicaRecursoDO;

public class UnidadBasicaRecursoDO implements IUnidadBasicaRecursoDO{
	

	public static final String CANTIDAD="cantidad";
	public static final String UNIDAD_BASICA_ID="unidadBasicaId";
	public static final String RECURSO_ID="recursoId";
	
	//------------------------------------------------------------------------------------------
	
	private int id;
	private int cantidad;
	
	//-----------------------------------------------------------------------------------------
	
	private Reference<IRecursoDO> recursoRef=//
		new Reference<IRecursoDO>();
	
	private Reference<IUnidadBasicaDO> unidadBasicaRef=//
		new Reference<IUnidadBasicaDO>();
	//--------------------------------------------------------------------------------------------
	
	public UnidadBasicaRecursoDO(){
		
		//empty
	}
	
	//--------------------------------------------------------------------------------
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	//-----------------------------------------------------------------------------------------
		
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	//---------------------------------------------------------------------------------------

	public Reference<IUnidadBasicaDO> getUnidadBasicaRef()
	{
		return unidadBasicaRef;
	}
	
	public void setUnidadBasicaRef(Reference<IUnidadBasicaDO> unidadBasicaRef)
	{
		this.unidadBasicaRef=unidadBasicaRef;
	}
	
	//-----------------------------------------------------------------------------------------
	
	public Reference<IRecursoDO> getRecursoRef()
	{
		return recursoRef;
	}
	
	public void setRecursoRef(Reference<IRecursoDO> recursoRef){
		
		this.recursoRef=recursoRef;
	}
	
	//----------------------------------------------------------------------------------------

}
