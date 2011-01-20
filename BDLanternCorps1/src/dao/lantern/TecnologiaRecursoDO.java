package dao.lantern;

import dao.api.Reference;
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.ITecnologiaRecursoDO;

public class TecnologiaRecursoDO implements ITecnologiaRecursoDO {
	
	
	public static final String CANTIDAD="cantidad";
	public static final String RECURSO_ID="recursoId";
	public static final String TECNOLOGIA_ID="tecnologiaId";
	
	//----------------------------------------------------------------------------------------

	private int id;
	private int cantidad;
	private int recurso;
	//-----------------------------------------------------------------------------------------
	
	private Reference<IRecursoDO> recursoRef=//
		new Reference<IRecursoDO>();
	
	private Reference<ITecnologiaDO> tecnologiaRef=//
		new Reference<ITecnologiaDO>();
	//-----------------------------------------------------------------------------------------
	
	public TecnologiaRecursoDO(){
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
	
	public int getCantidad() {
			return cantidad;
		}

	public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
	
	public int getRecurso() {
		return recurso;
	}

	public void setRecurso(int recurso) {
		this.recurso = recurso;
	}
	
	//-----------------------------------------------------------------------------------------
	
	public Reference<IRecursoDO> getRecursoRef(){
		
		return recursoRef;
	}
	
	public void setRecursoRef(Reference<IRecursoDO> recursoRef)
	{
		this.recursoRef=recursoRef;
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
