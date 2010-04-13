package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public class HabilidadDO implements DataObject {

	public static final String NOMBRE = "nombre";
	
	// --------------------------------------------------------------------------------

	private int id;
	private String nombre;
	private int costo_de_aprendizaje;
	private int tipo;
	
	private Reference<HabilidadClaseLinternaDO> habilidadClaseLinternaRef = new Reference<HabilidadClaseLinternaDO>();
	
	private List<NivelHabilidadDO> nivelHabilidadList = //
		new ArrayList<NivelHabilidadDO>();
	
		// --------------------------------------------------------------------------------

	public HabilidadDO() {
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
	
	public int getCosto_de_aprendizaje() {
		return costo_de_aprendizaje;
	}

	public void setCosto_de_aprendizaje(int costoDeAprendizaje) {
		costo_de_aprendizaje = costoDeAprendizaje;
	}

	// --------------------------------------------------------------------------------
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	// --------------------------------------------------------------------------------
	
	public Reference<HabilidadClaseLinternaDO> getHabilidadClaseLinternaRef() {
		return habilidadClaseLinternaRef;
	}

	public void setHabilidadClaseLinternaRef(Reference<HabilidadClaseLinternaDO> habilidadClaseLinternaRef) {
		this.habilidadClaseLinternaRef = habilidadClaseLinternaRef;
	}

	// --------------------------------------------------------------------------------

	public List<NivelHabilidadDO> getNivelHabilidadList() {
		return nivelHabilidadList;
	}

	public void setNivelHabilidadList(List<NivelHabilidadDO> NivelHabilidadList) {
		this.nivelHabilidadList = nivelHabilidadList;
	}
	
}
