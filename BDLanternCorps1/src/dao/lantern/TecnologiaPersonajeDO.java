package dao.lantern;

import dao.api.Reference;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.ITecnologiaPersonajeDO;

public class TecnologiaPersonajeDO implements ITecnologiaPersonajeDO{
	
	public static final String PERSONAJE_ID="personajeId";
	public static final String TECNOLOGIA_ID="tecnologiaId";
	
	//----------------------------------------------------------------------------------------
	
	private int id;
	private int personaje;
	private int tecnologia;
	
	//------------------------------------------------------------------------------------------
	
	private Reference<IPersonajeDO> personajeRef=//
		new Reference<IPersonajeDO>();
	
	private Reference<ITecnologiaDO> tecnologiaRef=//
		new Reference<ITecnologiaDO>();
	//-----------------------------------------------------------------------------------------
	
	public TecnologiaPersonajeDO(){
		//empty
	}
		
	//-----------------------------------------------------------------------------------------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	//----------------------------------------------------------------------------------------
	
	public int getPersonaje() {
			return personaje;
		}

	public void setPersonaje(int personaje) {
			this.personaje = personaje;
		}
	//-------------------------------------------------------------------------------------------
	
	public int getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(int tecnologia) {
		this.tecnologia = tecnologia;
	}
	
	//----------------------------------------------------------------------------------------
	
	public Reference<IPersonajeDO> getPersonajeRef()
	{
		return personajeRef;
	}
	
	public void setPersonajeRef(Reference<IPersonajeDO> personajeRef){
		
		this.personajeRef=personajeRef;
	}
	//-----------------------------------------------------------------------------------------

	public Reference<ITecnologiaDO> getTecnologiaRef(){
		
		return tecnologiaRef;
	}
	
	public void setTecnologiaRef(Reference<ITecnologiaDO> tecnologiaRef)
	{
		this.tecnologiaRef=tecnologiaRef;
	}

}
