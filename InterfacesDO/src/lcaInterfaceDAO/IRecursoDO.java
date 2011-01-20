package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;



public interface IRecursoDO extends DataObject{
	
	public abstract int getArticulo();
	
	public abstract void setArticulo(int articulo);
	
	public abstract String getNombre();
	
	public abstract void setNombre(String nombre);
	
	//------------------------------------------------------------------------------------------
	public abstract List<IRecursoPersonajeDO> getRecursoPersonajeList();
	
	public abstract  void setRecursoPersonajeList(List<IRecursoPersonajeDO> recursoPersonajeList);
	//-----------------------------------------------------------------------------------------
	public abstract List<IUnidadBasicaDO> getUnidadBasicaList();
	
	public abstract void setUnidadBasicaList(List<IUnidadBasicaDO> unidadBasicaList);
	//------------------------------------------------------------------------------------------
	public abstract List<IAndroideRecursoDO> getAndroideRecursoList();
	
	public abstract void setAndroideList(List<IAndroideRecursoDO> androideRecursoList);
	//-----------------------------------------------------------------------------------------
	public abstract List<ITecnologiaDO> getTecnologiaList();
	
	public abstract void setTecnologiaList(List<ITecnologiaDO> tecnologiaList);
	//-------------------------------------------------------------------------------------
	public abstract List<IRecursoOfertaCompraDO> getRecursoOfertaCompraList();
	
	public abstract void setRecursoOfertaCompraList(List<IRecursoOfertaCompraDO> recursoOfertaCompraList);
	//---------------------------------------------------------------------------------------
	public abstract List<IRecursoOfertaVentaDO> getRecursoOfertaVentaList();
	
	public abstract void setRecursoOfertaVentaList(List<IRecursoOfertaVentaDO> recursoOfertaVentaList);
	//---------------------------------------------------------------------------------------
	public abstract List<IPlanetaDO> getPlanetaList();
	
	public abstract void setPlanetaList(List<IPlanetaDO> planetaList);
	
	
	

}
