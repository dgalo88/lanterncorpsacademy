package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.Reference;


import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.IUnidadBasicaDO;
import lcaInterfaceDAO.IUnidadBasicaPersonajeDO;
import lcaInterfaceDAO.IUnidadBasicaRecursoDO;
import lcaInterfaceDAO.IUnidadEjercitoDO;

public class UnidadBasicaDO implements IUnidadBasicaDO {

	public static final String NOMBRE ="nombre";
	public static final String DEFENSA="defensa";
	public static final String ATAQUE="ataque";
	public static final String TIPO="tipo";
	
//	public static final String UNIDAD_EJERCITO_ARMA_ID ="unidadEjercitoArma";
//	
//	public static final String UNIDAD_EJERCITO_ROBOT_ID ="unidadEjercitoRobot";
//	
//	public static final String UNIDAD_EJERCITO_VEHICULO_ID ="unidadEjercitoVehiculo";
//	
//	public static final String UNIDAD_EJERCITO_BALA_ID ="unidadEjercitoBala";
	
	public static final String TECNOLOGIA_ID ="tecnologiaId";
	
	
	private int id;
	
	private String nombre;
	private int defensa;
	private int ataque;
	private int tipo;
	
	
	private List<IUnidadBasicaPersonajeDO> unidadBasicaPersonajeList=//
		new ArrayList<IUnidadBasicaPersonajeDO>();
	
	private Reference<ITecnologiaDO> tecnologiaRef = //
		new Reference<ITecnologiaDO>();
	
	private List<IUnidadBasicaRecursoDO> unidadBasicaRecursoList = //
		new ArrayList<IUnidadBasicaRecursoDO>();

	private Reference<IUnidadEjercitoDO> unidadEjercitoArmaRef =//
		new Reference<IUnidadEjercitoDO>();
	
	private Reference<IUnidadEjercitoDO> unidadEjercitoRobotRef=//
		new Reference<IUnidadEjercitoDO>();
	
	private Reference<IUnidadEjercitoDO> unidadEjercitoVehiculoRef=//
		new Reference<IUnidadEjercitoDO>();
	
	private Reference<IUnidadEjercitoDO> unidadEjercitoBalaRef=//
		new Reference<IUnidadEjercitoDO>();
	
	//----------------------------------------------------------------------------------------------------------------
	public UnidadBasicaDO()
	{
		//empty
	}
	
	//----------------------------------------------------------------------------------------------------
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	//---------------------------------------------------------------------------------------
	
	public  String getNombre(){
		
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
		
	}
	//------------------------------------------------------------------------------------------------------
	
	public int getDefensa(){
		
		return defensa;
	}
	
	public void setDefensa(int defensa){
		this.defensa=defensa;
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	
	public int getAtaque(){
		
		return ataque;
	}
	
	public void setAtaque(int ataque){
		this.ataque=ataque;
		
	}
	
	//----------------------------------------------------------------------------------------------------------------
	
	public int getTipo(){
		
		return tipo;
	}
	
	public void setTipo(int tipo){
		this.tipo=tipo;
		
	}
	//-----------------------------------------------------------------------------------------------
	
	public List<IUnidadBasicaPersonajeDO> getUnidadBasicaPersonajeList(){
		
		return unidadBasicaPersonajeList;
	}
	
	public void setUnidadBasicaPersonajeList(List<IUnidadBasicaPersonajeDO> unidadBasicaPersonajeList){
		
		this.unidadBasicaPersonajeList=unidadBasicaPersonajeList;
	}
	
	//-----------------------------------------------------------------------------------------------------------
	
	public Reference<ITecnologiaDO> getTecnologiaRef(){
		
		return tecnologiaRef;
	}
	
	public void setTecnologiaRef(Reference<ITecnologiaDO> tecnologiaRef){
		
		this.tecnologiaRef=tecnologiaRef;
	}
	
	//--------------------------------------------------------------------------------------------------
	
	public List<IUnidadBasicaRecursoDO> getUnidadBasicaRecursoList(){
		
		return unidadBasicaRecursoList;
	}
	
	public void setUnidadBasicaRecursoList(List<IUnidadBasicaRecursoDO> unidadBasicaRecursoList){
		
		this.unidadBasicaRecursoList=unidadBasicaRecursoList;
	}
	
	//-------------------------------------------------------------------------------------------------------
	
	public Reference<IUnidadEjercitoDO> getUnidadEjercitoArmaRef(){
		
		return unidadEjercitoArmaRef;
	}
	
	public void setUnidadEjercitoArma(Reference<IUnidadEjercitoDO> unidadEjercitoArmaRef){
		
		this.unidadEjercitoArmaRef=unidadEjercitoArmaRef;
	}
	
	//--------------------------------------------------------------------------------------------------
	
	public Reference<IUnidadEjercitoDO> getUnidadEjercitoRobotRef(){
		
		return unidadEjercitoRobotRef;
	}
	
	public void setUnidadEjercitoRobotRef(Reference<IUnidadEjercitoDO> unidadEjercitoRobotRef){
		
		this.unidadEjercitoRobotRef=unidadEjercitoRobotRef;
	}
	
	//---------------------------------------------------------------------------------------------------
	
	public Reference<IUnidadEjercitoDO> getUnidadEjercitoVehiculoRef(){
		
		return unidadEjercitoVehiculoRef;
	}
	
	public void setUnidadEjercitoVehiculoRef(Reference<IUnidadEjercitoDO> unidadEjercitoVehiculoRef)
	{
		this.unidadEjercitoVehiculoRef=unidadEjercitoVehiculoRef;
	}
	
	//--------------------------------------------------------------------------------------------------------
	
	public Reference<IUnidadEjercitoDO> getUnidadEjercitoBalaRef(){
		
		return unidadEjercitoBalaRef;
	}
	
	public void setUnidadEjercitoBalaRef(Reference<IUnidadEjercitoDO> unidadEjercitoBalaRef){
		
		this.unidadEjercitoBalaRef=unidadEjercitoBalaRef;
	}
	
}
