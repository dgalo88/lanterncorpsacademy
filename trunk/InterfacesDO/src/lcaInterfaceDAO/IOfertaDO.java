package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;



public interface IOfertaDO extends DataObject {
	
	public abstract String getArticulo();
	
	//public abstract int getID(); Verificar si se ha de colocar aca o en OfertaDO
	public abstract void setArticulo(String articulo);
	
	public abstract List<IRecursoDO> getRecursoList();
	
	public abstract void setRecursoList(List<IRecursoDO>recursoList);
	
	public abstract List<IPersonajeDO> getPersonajeList();
	
	public abstract void setPersonajeList(List<IPersonajeDO> personajeList);
	
	public abstract List<IUnidadEjercitoDO> getUnidadEjercitoList();
	
	public abstract void setUnidadEjercito(List<IUnidadEjercitoDO> unidadEjercitoList);
		

}
