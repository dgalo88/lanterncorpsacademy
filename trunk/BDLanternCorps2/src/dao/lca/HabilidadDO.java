package dao.lca;

import java.util.ArrayList;
import java.util.List;
import dao.api.DataObject;


public class HabilidadDO implements DataObject {

	public static final String NOMBRE = "nombre";
	public static final String COSTO_DE_APRENDIZAJE = "costoDeAprendizaje";
	public static final String TIPO = "tipo";


	
	// --------------------------------------------------------------------------------

	private int id;
	private String nombre;
	private int costoDeAprendizaje;
	private int tipo;
	
	private List<HabilidadClaseLinternaDO> habilidadClaseLinternaList = new ArrayList<HabilidadClaseLinternaDO>();
	private List<NivelHabilidadDO> nivelHabilidadList = new ArrayList<NivelHabilidadDO>();
	private List<HabilidadActivaDO> habilidadActivaList = new ArrayList<HabilidadActivaDO>();
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
		return costoDeAprendizaje;
	}

	public void setCosto_de_aprendizaje(int costoDeAprendizaje) {
		this.costoDeAprendizaje = costoDeAprendizaje;
	}

	// --------------------------------------------------------------------------------
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	// --------------------------------------------------------------------------------
	
	public List<HabilidadClaseLinternaDO> getHabilidadClaseLinternaList() {
		return habilidadClaseLinternaList;
	}

	public void setHabilidadClaseLinternaList(List<HabilidadClaseLinternaDO> habilidadClaseLinternaList) {
		this.habilidadClaseLinternaList = habilidadClaseLinternaList;
	}

	// --------------------------------------------------------------------------------

	public List<NivelHabilidadDO> getNivelHabilidadList() {
		return nivelHabilidadList;
	}

	public void setNivelHabilidadList(List<NivelHabilidadDO> nivelHabilidadList) {
		this.nivelHabilidadList = nivelHabilidadList;
	}

	// --------------------------------------------------------------------------------
	
	public void setHabilidadActivaList(List<HabilidadActivaDO> habilidadActivaList) {
		this.habilidadActivaList = habilidadActivaList;
	}

	public List<HabilidadActivaDO> getHabilidadActivaList() {
		return habilidadActivaList;
	}
	
}
