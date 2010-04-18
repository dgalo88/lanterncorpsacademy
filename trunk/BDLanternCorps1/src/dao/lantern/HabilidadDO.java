package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;

public class HabilidadDO implements DataObject {

	public static final String ID     	= "id";
	public static final String NOMBRE 	= "nombre";
	public static final String COST   	= "costo_aprendizaje";
	public static final String TIPO     = "tipo";
	
	public static final String NIVEL_ID = "nivel";
	public static final String CLASE_ID = "clase_linterna";
	public static final String HAB_ACTIVA_ID = "habilidad_activa";
    	
	// --------------------------------------------------------------------------------

	private int id;
	
	private String nombre;
	private int costo_de_aprendizaje;
	private int tipo;
	
	private List<HabilidadClaseLinternaDO> HabilidadClaseLinternaList = //
		new ArrayList<HabilidadClaseLinternaDO>();
	
	private List<NivelHabilidadDO> nivelHabilidadList = //
		new ArrayList<NivelHabilidadDO>();

	private List<HabilidadActivaDO> habilidadActivaList = //
		new ArrayList<HabilidadActivaDO>();

	
	// --------------------------------------------------------------------------------

	public HabilidadDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	//@Override
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
	
	public int getCostoDeAprendizaje() {
		return costo_de_aprendizaje;
	}

	public void setCostoDeAprendizaje(int costoDeAprendizaje) {
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

	public void setHabilidadClaseLinternaList(
			List<HabilidadClaseLinternaDO> habilidadClaseLinternaList) {
		HabilidadClaseLinternaList = habilidadClaseLinternaList;
	}

	public List<HabilidadClaseLinternaDO> getHabilidadClaseLinternaList() {
		return HabilidadClaseLinternaList;
	}
	
	// --------------------------------------------------------------------------------
	
	public void setNivelHabilidadList(List<NivelHabilidadDO> nivelHabilidadList) {
		this.nivelHabilidadList = nivelHabilidadList;
	}

	public List<NivelHabilidadDO> getNivelHabilidadList() {
		return nivelHabilidadList;
	}

	// --------------------------------------------------------------------------------
	
	public void setHabilidadActivaList(List<HabilidadActivaDO> habilidadActivaList) {
		this.habilidadActivaList = habilidadActivaList;
	}

	public List<HabilidadActivaDO> getHabilidadActivaList() {
		return habilidadActivaList;
	}	
	
}
