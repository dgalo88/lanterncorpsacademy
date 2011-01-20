package dao.lantern;

import dao.api.Reference;
import lcaInterfaceDAO.IAndroideDO;
import lcaInterfaceDAO.IAndroidePersonajeDO;
import lcaInterfaceDAO.IPersonajeDO;

public class AndroidePersonajeDO implements IAndroidePersonajeDO{

	
	public static  final String VIDA_NAXIMA="vidaMaxima";
	public static  final String VIDA_ACTUAL="vidaActual";
	
	public static  final String PERSONAJE_ID="personajeId";
	public static  final String ANDROIDE_ID="androideId";
	
	//-----------------------------------------------------------------------------------------------
	
	private int id;
	
	private int vidaMaxima;
	
	private int vidaActual;
	
	//-------------------------------------------------------------------------------------------------------
	
	private Reference<IAndroideDO> androideRef=//
		new Reference<IAndroideDO>();
	
	private Reference<IPersonajeDO> personajeRef=//
		new Reference<IPersonajeDO>();
	
	//--------------------------------------------------------------------------------------------------------
	
	public AndroidePersonajeDO(){
		
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
	
	public Reference<IAndroideDO> getAndroideRef(){
		
		return androideRef;
	}
	
	public void setAndroideRef(Reference<IAndroideDO> androideRef){
		
		this.androideRef=androideRef;
	}
	
	//----------------------------------------------------------------------------------------------------------
	
	public Reference<IPersonajeDO> getPersonajeRef(){
		
		return personajeRef;
	}
	
	public void setPersonajeRef(Reference<IPersonajeDO> personajeRef){
		
		this.personajeRef=personajeRef;
	}
	
}
