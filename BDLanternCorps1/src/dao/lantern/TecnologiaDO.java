package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.Reference;
import lcaInterfaceDAO.IAndroideDO;
import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.ITecnologiaPersonajeDO;
import lcaInterfaceDAO.ITecnologiaRecursoDO;
import lcaInterfaceDAO.IUnidadBasicaDO;

public class TecnologiaDO implements ITecnologiaDO{

	public static final String NOMBRE="nombre";
	
	public static final String UNIDAD_BASICA_ID="unidadBasicaId";
	
	public static final String TECNOLOGIA_PERSONAJE_ID="tecnologiaPersonajeId";
	
	public static final String TECNOLOGIA_RECURSO_ID="tecnologiaRecursoId";

	public static final String COSTO_DE_TECNOLOGIA = "costoDeTecnologia";
	
	//-------------------------------------------------------------------------------------------------
	
	private int id;
	
	private String nombre;
	
	//--------------------------------------------------------------------------------------------------
	
	private Reference<IUnidadBasicaDO> unidadBasicaRef=//
		new Reference<IUnidadBasicaDO>();
	
	private List<IAndroideDO> androideList=//
		new ArrayList<IAndroideDO>();
	
	private List<ITecnologiaRecursoDO> tecnologiaRecursoList=//
		new ArrayList<ITecnologiaRecursoDO>();
	
	private List<ITecnologiaPersonajeDO> tecnologiaPersonajeList=//
		new ArrayList<ITecnologiaPersonajeDO>();
	
	//-----------------------------------------------------------------------------------------------
	
	public TecnologiaDO(){
		
		//empty
	}
	
	//---------------------------------------------------------------------------------------------------
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	//--------------------------------------------------------------------------------------------------
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//------------------------------------------------------------------------------------------------------
	
	public Reference<IUnidadBasicaDO> getUnidadBasicaRef(){
		
		return unidadBasicaRef;
	}
	
	public void setUnidadBasicaRef(Reference<IUnidadBasicaDO> unidadBasicaRef){
		
		this.unidadBasicaRef=unidadBasicaRef;
	}
	
	//---------------------------------------------------------------------------------------------
	
	public List<IAndroideDO> getAndroideList(){
		
		return androideList;
	}
	
	public  void setAndroideList(List<IAndroideDO> androideList){
		
		this.androideList=androideList;
	}
	
	//---------------------------------------------------------------------------------------------------
	
	public List<ITecnologiaRecursoDO> getTecnologiaRecursoList()
	{	
		return tecnologiaRecursoList;
	}
	
	
	public void setTecnologiaRecursoList (List<ITecnologiaRecursoDO> tecnologiaRecursoList)
	{
		this.tecnologiaRecursoList=tecnologiaRecursoList;
	}
	
	//------------------------------------------------------------------------------------------------------
	
	public List<ITecnologiaPersonajeDO> getTecnologiaPersonajeList(){
		
		return tecnologiaPersonajeList;
	}
	
	public void setTecnologiaPersonajeList(List<ITecnologiaPersonajeDO> tecnologiaPersonajeList){
		
		this.tecnologiaPersonajeList=tecnologiaPersonajeList;
	}

	//-----------------------------------------------------------------------------------------------------------------	

	
	public void setCosto_de_tecnologia(int i) {
		// TODO Auto-generated method stub
		
	}
	
	//---------------------------------------------------------------------------------------------------------
	
}
