
import java.util.List;

public class Habilidad {

	// --------------------------------------------------------------------------------

	private int id;
	private String nombre;
	private int costoDeAprendizaje;
	private int tipo;
	
	private List<HabilidadClaseLinterna> habilidadClaseLinternaList;
	private List<NivelHabilidad> nivelHabilidadList;
	private List<HabilidadActiva> habilidadActivaList;
		// --------------------------------------------------------------------------------

	public Habilidad() {
		// Empty
	}

	// --------------------------------------------------------------------------------


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
	
	public List<HabilidadClaseLinterna> getHabilidadClaseLinternaList() {
		return habilidadClaseLinternaList;
	}

	public void setHabilidadClaseLinternaList(List<HabilidadClaseLinterna> habilidadClaseLinternaList) {
		this.habilidadClaseLinternaList = habilidadClaseLinternaList;
	}

	// --------------------------------------------------------------------------------

	public List<NivelHabilidad> getNivelHabilidadList() {
		return nivelHabilidadList;
	}

	public void setNivelHabilidadList(List<NivelHabilidad> nivelHabilidadList) {
		this.nivelHabilidadList = nivelHabilidadList;
	}

	// --------------------------------------------------------------------------------
	
	public void setHabilidadActivaList(List<HabilidadActiva> habilidadActivaList) {
		this.habilidadActivaList = habilidadActivaList;
	}

	public List<HabilidadActiva> getHabilidadActivaList() {
		return habilidadActivaList;
	}
	
}
