package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;



public interface IRecursoDO extends DataObject{
	
	public abstract int getArticulo();
	
	public abstract void setArticulo(int articulo);
	
	public abstract String getNombre();
	
	public abstract void setNombre(String nombre);
	
	public abstract List<IPersonajeDO> getPersonajeList();
	
	public abstract void setPersonajeList(List<IPersonajeDO> personajeList);
	
	public abstract List<IUnidadBasicaDO> getUnidadBasicaList();
	
	public abstract void setUnidadBasicaList(List<IUnidadBasicaDO> unidadBasicaList);
	
	public abstract List<IAndroideDO> getAndroideList();
	
	public abstract void setAndroideList(List<IAndroideDO> androideList);
	
	public abstract List<ITecnologiaDO> getTecnologiaList();
	
	public abstract void setTecnologiaList(List<ITecnologiaDO> tecnologiaList);
	
	public abstract List<IOfertaDO> getOfertaList();
	
	public abstract void setOfertaList(List<IOfertaDO> ofertaList);
	
	public abstract List<IPlanetaDO> getPlanetaList();
	
	public abstract void setPlanetaList(List<IPlanetaDO> planetaList);
	
	
	

}
