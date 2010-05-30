package dao.lca;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IGrupoDO;
import lcaInterfaceDAO.IPersonajeDO;
import dao.api.Reference;

public class GrupoDO implements IGrupoDO {

	// --------------------------------------------------------------------------------
	
	public static final String NOMBRE = "nombre";
	public static final String ESTADO = "estado";
	public static final String CLASE_LINTERNA_ID = "claseLinternaId";
	
	// --------------------------------------------------------------------------------
	
	private int id;
	private String nombre;
	private boolean estado;
	
	// --------------------------------------------------------------------------------

	private List<IPersonajeDO> personajeList =new ArrayList<IPersonajeDO>();
	private Reference<IClaseLinternaDO> claseLinternaRef = new Reference<IClaseLinternaDO>();
	
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

	public List<IPersonajeDO> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<IPersonajeDO> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------

	public Reference<IClaseLinternaDO> getClaseLinternaRef() {
		return claseLinternaRef;
	}

	public void setClaseLinternaRef(Reference<IClaseLinternaDO> claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}

}
