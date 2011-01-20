package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IAndroidePersonajeDO extends DataObject{
	
	
	
	public abstract int getVidaMaxima();
	
	public abstract void setVidaMaxima(int vidaMaxima);
	
	//--------------------------------------------------------------------------------------------------------
	

	public abstract int getVidaActual();
	
	public abstract void setVidaActual(int vidaActual);
	
	//------------------------------------------------------------------------------------------------------------
	
	public abstract Reference<IAndroideDO> getAndroideRef();
	
	public abstract void setAndroideRef(Reference<IAndroideDO> androideRef);
	
	//----------------------------------------------------------------------------------------------------------
	
	public abstract Reference<IPersonajeDO> getPersonajeRef();
	
	public abstract void setPersonajeRef(Reference<IPersonajeDO> personajeRef);
		
	
	

}
