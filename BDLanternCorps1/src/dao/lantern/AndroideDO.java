package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.Reference;
import lcaInterfaceDAO.IAndroideDO;
import lcaInterfaceDAO.IAndroidePersonajeDO;
import lcaInterfaceDAO.IAndroideRecursoDO;
import lcaInterfaceDAO.ITecnologiaDO;

public class AndroideDO implements IAndroideDO{

	public static final String NOMBRE="nombre";

	public static final String TIPO="tipo";

	public static final String CANTIDAD="cantidad";

	public static final String TECNOLOGIA_ID = "tecnologiaId";

	//------------------------------------------------------------------------------------------

	private String nombre;

	private int id;

	private int tipo;

	private int cantidad;
	//------------------------------------------------------------------------------------------

	private Reference<ITecnologiaDO> tecnologiaRef=//
		new Reference<ITecnologiaDO>();

	private List<IAndroidePersonajeDO> androidePersonajeList=//
		new ArrayList<IAndroidePersonajeDO>();

	private List<IAndroideRecursoDO> androideRecursoList=//
		new ArrayList<IAndroideRecursoDO>();

	//-----------------------------------------------------------------------------------------------------------------

	public AndroideDO(){

		//empty
	}

	//-------------------------------------------------------------------------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//-------------------------------------------------------------------------

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//-------------------------------------------------------------------------

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	//-------------------------------------------------------------------------

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	//------------------------------------------------------------------------

	public Reference<ITecnologiaDO> getTecnologiaRef(){

		return tecnologiaRef;
	}

	public void setTecnologiaRef(Reference<ITecnologiaDO> tecnologiaRef){

		this.tecnologiaRef=tecnologiaRef;
	}
	//---------------------------------------------------------------------------------------------------------------

	public List<IAndroidePersonajeDO> getAndroidePersonajeList(){

		return androidePersonajeList;
	}

	public void setAndroidePersonajeList(List<IAndroidePersonajeDO> androidePersonajeList){

		this.androidePersonajeList=androidePersonajeList;
	}
	//--------------------------------------------------------------------------------------------------------

	public  List<IAndroideRecursoDO> getAndroideRecursoList(){

		return androideRecursoList;
	}

	public void setAndroideRecursojeList(List<IAndroideRecursoDO> androideRecursoList){

		this.androideRecursoList=androideRecursoList;
	}

}
