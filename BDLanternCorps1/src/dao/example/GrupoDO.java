package dao.example;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public class GrupoDO implements DataObject {

	// --------------------------------------------------------------------------------
	
	public static final String NOMBRE = "nombre";
	
	// --------------------------------------------------------------------------------
	
	private int id;
	private int nombre;
	private boolean estado;
	
	// --------------------------------------------------------------------------------

	private List<GrupoPersonajeDO> grupoPersonajeList = //
	new ArrayList<GrupoPersonajeDO>();

	private Reference<ClaseLinternaDO> claseLinternaRef = new Reference<ClaseLinternaDO>();
	
	// --------------------------------------------------------------------------------

	public GrupoDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	// --------------------------------------------------------------------------------
	
	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	// --------------------------------------------------------------------------------
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	// --------------------------------------------------------------------------------

	public List<GrupoPersonajeDO> getGrupoPersonajeList() {
		return grupoPersonajeList;
	}

	public void setGrupoPersonajeList(List<GrupoPersonajeDO> grupoPersonajeList) {
		this.grupoPersonajeList = grupoPersonajeList;
	}

	// --------------------------------------------------------------------------------

	public Reference<ClaseLinternaDO> getClaseLinternaRef() {
		return claseLinternaRef;
	}

	public void setClaseLinternaRef(Reference<ClaseLinternaDO> claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}

}
