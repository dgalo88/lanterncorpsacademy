package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public class GrupoDO implements DataObject {

	// --------------------------------------------------------------------------------
	
	public static final String NOMBRE = "nombre";
	public static final String CLASE_LINTERNA_ID = "claseLinternaId";
	public static final String ESTADO = "estado";
	
	// --------------------------------------------------------------------------------
	
	private int id;
	private String nombre;
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
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
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
