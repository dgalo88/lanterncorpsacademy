package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public interface IUnidadEjercitoDO extends DataObject{
	
	
	public abstract String getNombre();
	
	public abstract void setNombre(String nombre);
	//-----------------------------------------------------------------------
	
	public abstract List<IUnidadEjercitoOfertaDO> getUnidadEjercitoOfertaList();
	
	public abstract void setUnidadEjercitoOfertaList(List<IUnidadEjercitoOfertaDO> unidadEjercitoOfertaList);
	
	//---------------------------------------------------------------------------------------------------------------
	 
	public abstract Reference<IUnidadBasicaDO> getUnidadBasicaArmaRef();
	
	public abstract void setUnidadBasicaArmaRef(Reference<IUnidadBasicaDO> unidadBasicaArmaRef);
	
	//-------------------------------------------------------------------------------------------------------------------
	
	public abstract Reference<IUnidadBasicaDO> getUnidadBasicaRobotRef();
	
	public abstract void setUnidadBasicaRobotRef(Reference<IUnidadBasicaDO> unidadBasicaRobotRef);	
	
	//----------------------------------------------------------------------------------------------------------------------
	
	public abstract Reference<IUnidadBasicaDO> getUnidadBasicaVehiculoRef();
	
	public abstract void setUnidadBasicaVehiculoRef(Reference<IUnidadBasicaDO> unidadBasicaVehiculoRef);
	
	//-----------------------------------------------------------------------------------------

	public abstract Reference<IUnidadBasicaDO> getUnidadBasicaBalaRef();
	
	public abstract void setUnidadBasicaBalaRef(Reference<IUnidadBasicaDO> unidadBasicaBalaRef);
	
	//-----------------------------------------------------------------------------------------------------------------------
	public abstract List<IUnidadEjercitoPersonajeDO> getUnidadEjercitoPersonajeList();
	
	public abstract void setUnidadEjercitoPersonajeList(List<IUnidadEjercitoPersonajeDO> unidadEjercitoPersonajeLis);
	
	//---------------------------------------------------------------------------------------------------------------------
	
	public abstract Reference<IPlanetaDO> getPlanetaRef();
	
	public abstract void setPlanetaRef(Reference<IPlanetaDO> planetaRef);
	
	//---------------------------------------------------------------------------------------------------------------
	

	public abstract String getImagenUnidadEjercito();
	
	public  abstract void setImagenUnidadEjercito(String imagenUnidadEjercito);
		

}
