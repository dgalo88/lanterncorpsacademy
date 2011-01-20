package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IOfertaDO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IUnidadEjercitoDO;

public class OfertaDO implements IOfertaDO {

	
	//--------------------------------------------------
	public static final String OFERTA_ID ="oferta" ;
	public static final String ARTICULO="articulo";
	
	public static final String RECURSO_OFERTA_COMPRA_ID="recursoOfertaCompra";
	public static final String RECURSO_OFERTA_VENTA_ID="recursoOfertaVenta";
	public static final String PERSONAJE_ID="personje";
	
	//----------------------------------------------------------------
	
	private int id;
	private String articulo;
	
	//-----------------------------------------------------------------------
	
	private List<IRecursoDO>recursoList=//
		new ArrayList<IRecursoDO>();
	
	private List<IPersonajeDO>personajeList=//
		new ArrayList<IPersonajeDO>();
	
	private List<IUnidadEjercitoDO>unidadEjercitoList=//
		new ArrayList<IUnidadEjercitoDO>();
	
	//-----------------------------------------------------------------------
	
	public OfertaDO() {
		// empty
	}
	
	//---------------------------------------------------------------------------
	
	public  String getArticulo(){
		
		return articulo;
	}
	
	public void setArticulo(String articulo){
		this.articulo=articulo;
		
	}
	//-------------------------------------------------------------------------
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// --------------------------------------------------------------------------------

	public  List<IRecursoDO> getRecursoList(){
		return recursoList;
	}	
	
	public void setRecursoList(List<IRecursoDO>recursoList){
		this.recursoList=recursoList;
	}
	//-----------------------------------------------------------------------------------
	public List<IPersonajeDO> getPersonajeList(){
		
		return personajeList;
	}
	
	public void setPersonajeList(List<IPersonajeDO> personajeList){
		
		this.personajeList=personajeList;
	}
	//-----------------------------------------------------------------------------------------
	
	public List<IUnidadEjercitoDO> getUnidadEjercitoList(){
		
		return unidadEjercitoList;
	}
	
	public void setUnidadEjercito(List<IUnidadEjercitoDO> unidadEjercitoList){
		
		this.unidadEjercitoList=unidadEjercitoList;
		
	}
	
	

}
