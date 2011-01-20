package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.Reference;
import lcaInterfaceDAO.IEjercitoPersonajeDO;
import lcaInterfaceDAO.IUnidadBasicaDO;
import lcaInterfaceDAO.IUnidadEjercitoDO;
import lcaInterfaceDAO.IUnidadEjercitoOfertaDO;

public class UnidadEjercitoDO implements IUnidadEjercitoDO {

	
	public static final String NOMBRE="nombre";
	
	public static final String EJERCITO_PERSONAJE_ID="ejercitoPersonajeId";
	
	public static final String UNIDAD_BASICA_ARMA_ID ="unidadBasicaArma";
	
	public static final String UNIDAD_BASICA_ROBOT_ID ="unidadBasicaRobot";
	
	public static final String UNIDAD_BASICA_VEHICULO_ID ="unidadBasicaVehiculo";
	
	public static final String UNIDAD_BASICA_BALA_ID ="unidadBasicaBala";
	
	//-------------------------------------------------------------------------------------------------
	
	private int id;
	
	private String nombre;
	
	//---------------------------------------------------------------------------------------------------
	
	private List<IEjercitoPersonajeDO> ejercitoPersonajeList=//
		new ArrayList<IEjercitoPersonajeDO>();
		
	private List<IUnidadEjercitoOfertaDO> unidadEjercitoOfertaList=//
		new ArrayList<IUnidadEjercitoOfertaDO>();
	
	private Reference<IUnidadBasicaDO> unidadBasicaArmaRef=//
		new Reference<IUnidadBasicaDO>();
	
	private Reference<IUnidadBasicaDO> unidadBasicaRobotRef=//
		new Reference<IUnidadBasicaDO>();
	
	private Reference<IUnidadBasicaDO> unidadBasicaVehiculoRef=//
		new Reference<IUnidadBasicaDO>();
	
	private Reference<IUnidadBasicaDO> unidadBasicaBalaRef=//
		new Reference<IUnidadBasicaDO>();
	
	//---------------------------------------------------------------------------------------------
	
	public UnidadEjercitoDO(){
		//Empty
	}
	//--------------------------------------------------------------------------------------------
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		
		this.id=id;
	}
	//----------------------------------------------------------------------------------------------------
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	//----------------------------------------------------------------------------------------
	
	public List<IEjercitoPersonajeDO> getEjercitoPersonajeList(){
		
		return ejercitoPersonajeList;
	}
	
	public void setEjercitoPersonajeList(List<IEjercitoPersonajeDO> ejercitoPersonajeList){
		
		this.ejercitoPersonajeList=ejercitoPersonajeList;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	public List<IUnidadEjercitoOfertaDO> getUnidadEjercitoOfertaList(){
		return unidadEjercitoOfertaList;
	}
	
	public void setUnidadEjercitoOfertaList(List<IUnidadEjercitoOfertaDO> unidadEjercitoOfertaList)
	{
		
		this.unidadEjercitoOfertaList=unidadEjercitoOfertaList;
	}

	//--------------------------------------------------------------------------------------
	
	public Reference<IUnidadBasicaDO> getUnidadBasicaArmaRef(){
		
		return unidadBasicaArmaRef;
	}
	
	public void setUnidadBasicaArmaRef(Reference<IUnidadBasicaDO> unidadBasicaArmaRef)
	{
		this.unidadBasicaArmaRef=unidadBasicaArmaRef;
	}
	
	//------------------------------------------------------------------------------------
	
	public Reference<IUnidadBasicaDO> getUnidadBasicaRobotRef(){
		
		return unidadBasicaRobotRef;
	}
	
	public void setUnidadBasicaRobotRef(Reference<IUnidadBasicaDO> unidadBasicaRobotRef){
		
		this.unidadBasicaRobotRef=unidadBasicaRobotRef;
	}
	//----------------------------------------------------------------------------------------
	
	public Reference<IUnidadBasicaDO> getUnidadBasicaVehiculoRef()
	{
		return unidadBasicaVehiculoRef;
	}
	
	public void setUnidadBasicaVehiculoRef(Reference<IUnidadBasicaDO> unidadBasicaVehiculoRef){
		
		this.unidadBasicaVehiculoRef=unidadBasicaVehiculoRef;
	}	
	
	//----------------------------------------------------------------------------------------
	public Reference<IUnidadBasicaDO> getUnidadBasicaBalaRef(){
		
		return unidadBasicaBalaRef;
	}
	
	public void setUnidadBasicaBalaRef(Reference<IUnidadBasicaDO> unidadBasicaBalaRef)
	{
		this.unidadBasicaBalaRef=unidadBasicaBalaRef;
	}
	//--------------------------------------------------------------------------------------------------
	
}
