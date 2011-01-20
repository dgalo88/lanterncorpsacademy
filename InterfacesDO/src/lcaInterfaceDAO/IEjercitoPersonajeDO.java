package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IEjercitoPersonajeDO extends DataObject{

//---------------------------------------------------------------------------------------
	
	public abstract int getVidaMaxima();
	
	public abstract void setVidaMaxima(int vidaMaxima);
	
	//---------------------------------------------------------------------------------------
		
	public abstract int getVidaActual();
	
	public abstract void setVidaActual(int vidaActual);
	
	//---------------------------------------------------------------------------------------

	public abstract Reference<IPersonajeDO> getPersonajeRef();
	
	public abstract void setPersonajeRef(Reference<IPersonajeDO> personajeRef);
	
	//-----------------------------------------------------------------------------------------
	
	public abstract Reference<IUnidadEjercitoDO> getUnidadEjercitoRef();
	
	public abstract void setUnidadEjercitoRef(Reference<IUnidadEjercitoDO> unidadEjercitoRef);
	
	//----------------------------------------------------------------------------------------


}


