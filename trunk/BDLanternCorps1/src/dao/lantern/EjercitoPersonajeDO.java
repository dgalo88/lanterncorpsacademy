package dao.lantern;

import dao.api.Reference;
import lcaInterfaceDAO.IEjercitoPersonajeDO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUnidadEjercitoDO;

public class EjercitoPersonajeDO implements IEjercitoPersonajeDO {

	public static  final String VIDA_NAXIMA="vidaMaxima";
	public static  final String VIDA_ACTUAL="vidaActual";
	
	public static  final String PERSONAJE_ID="personajeId";
	public static  final String UNIDAD_EJERCITO_ID="unidadEjercitoId";
	
	//-----------------------------------------------------------------------------------------------
	
	private int id;
	
	private int vidaMaxima;
	
	private int vidaActual;
	
	//-------------------------------------------------------------------------------------------------------
	
	private Reference<IUnidadEjercitoDO> unidadEjercitoRef=//
		new Reference<IUnidadEjercitoDO>();
	
	private Reference<IPersonajeDO> personajeRef=//
		new Reference<IPersonajeDO>();
	
	//--------------------------------------------------------------------------------------------------------
	
	public EjercitoPersonajeDO(){
		
		//empty
	}
	//---------------------------------------------------------------------------------------------------------------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
//-------------------------------------------------------------------------
	
	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}
	
	//-------------------------------------------------------------------------
	
	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual= vidaActual;
	}
	
	//------------------------------------------------------------------------------------------------------------
	
	public Reference<IUnidadEjercitoDO> getUnidadEjercitoRef(){
		
		return unidadEjercitoRef;
	}
	
	public void setUnidadEjercitoRef(Reference<IUnidadEjercitoDO> unidadEjercitoRef){
		
		this.unidadEjercitoRef=unidadEjercitoRef;
	}
	
	//----------------------------------------------------------------------------------------------------------
	
	public Reference<IPersonajeDO> getPersonajeRef(){
		
		return personajeRef;
	}
	
	public void setPersonajeRef(Reference<IPersonajeDO> personajeRef){
		
		this.personajeRef=personajeRef;
	}
	
}

