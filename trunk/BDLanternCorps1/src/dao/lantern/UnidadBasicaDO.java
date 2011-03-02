package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.IUnidadBasicaDO;
import lcaInterfaceDAO.IUnidadBasicaPersonajeDO;
import lcaInterfaceDAO.IUnidadBasicaRecursoDO;
import dao.api.Reference;

public class UnidadBasicaDO implements IUnidadBasicaDO {

	public static final String NOMBRE ="nombre";
	public static final String DEFENSA="defensa";
	public static final String ATAQUE="ataque";
	public static final String TIPO="tipo";
	public static final String IMAGEN_UNIDAD_BASICA="imagenUnidadBasica";
	
	
	public static final String TECNOLOGIA_ID ="tecnologiaId";
	
	
	private int id;
	
	private String nombre;
	private int defensa;
	private int ataque;
	private int tipo;
	private String imagenUnidadBasica;
	
	
	private List<IUnidadBasicaPersonajeDO> unidadBasicaPersonajeList=//
		new ArrayList<IUnidadBasicaPersonajeDO>();
	
	private Reference<ITecnologiaDO> tecnologiaRef = //
		new Reference<ITecnologiaDO>();
	
	private List<IUnidadBasicaRecursoDO> unidadBasicaRecursoList = //
		new ArrayList<IUnidadBasicaRecursoDO>();

	
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
	//------------------------------------------------------------------------------------------------------------------------

	public String getImagenUnidadBasica(){
		
		return imagenUnidadBasica;
	}
	
	public void setImagenUnidadBasica(String imagenUnidadBasica){
		
		this.imagenUnidadBasica= imagenUnidadBasica;
	}
	//----
	//------------------------------------------------------------------------------------------------------------------------
	
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
	
	
}
