package dao.lantern;

import dao.api.Reference;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUnidadBasicaDO;
import lcaInterfaceDAO.IUnidadBasicaPersonajeDO;

public class UnidadBasicaPersonajeDO implements IUnidadBasicaPersonajeDO {

	public static final String CANTIDAD="cantidad";
	public static final String UNIDAD_BASICA_ID="unidadBasicaId";
	public static final String PERSONAJE_ID="personajeId";
	
	//------------------------------------------------------------------------------------------
	
	private int id;
	private int cantidad;
	
	//-----------------------------------------------------------------------------------------
	
	private Reference<IPersonajeDO> personajeRef=//
		new Reference<IPersonajeDO>();
	
	private Reference<IUnidadBasicaDO> unidadBasicaRef=//
		new Reference<IUnidadBasicaDO>();
	//--------------------------------------------------------------------------------------------
	
	public UnidadBasicaPersonajeDO(){
		
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
	
	public Reference<IPersonajeDO> getPersonajeRef()
	{
		return personajeRef;
	}
	
	public void setPersonajeRef(Reference<IPersonajeDO> personajeRef){
		
		this.personajeRef=personajeRef;
	}
	
	//----------------------------------------------------------------------------------------
}
