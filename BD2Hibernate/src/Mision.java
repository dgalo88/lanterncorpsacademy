
import java.util.List;

public class Mision {


	// --------------------------------------------------------------------------------

	private int id;
	private String nombre;
	private String descripcion;
	private int experienciaGanada;
	private int puntosDeEntrenamientoGanados;
	private int nivelNecesario;

	private List<Orden> ordenList;
	private List<MisionPersonaje> misionPersonajeList;
		
	// --------------------------------------------------------------------------------

	public Mision() {
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
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// --------------------------------------------------------------------------------
	
	public int getExperiencia_ganada() {
		return experienciaGanada;
	}

	public void setExperiencia_ganada(int experienciaGanada) {
		this.experienciaGanada = experienciaGanada;
	}

	// --------------------------------------------------------------------------------
	
	public int getPuntos_de_entrenamiento_ganados() {
		return puntosDeEntrenamientoGanados;
	}

	public void setPuntos_de_entrenamiento_ganados(int puntosDeEntrenamientoGanados) {
		this.puntosDeEntrenamientoGanados = puntosDeEntrenamientoGanados;
	}
	
	// --------------------------------------------------------------------------------
	
	public int getNivel_necesario() {
		return nivelNecesario;
	}

	public void setNivel_necesario(int nivelNecesario) {
		this.nivelNecesario = nivelNecesario;
	}
	
	// --------------------------------------------------------------------------------
	
	public void setOrdenList(List<Orden> ordenList) {
		this.ordenList = ordenList;
	}

	public List<Orden> getOrdenList() {
		return ordenList;
	}

	// --------------------------------------------------------------------------------
	
	public void setMisionPersonajeList(List<MisionPersonaje> misionPersonajeList) {
		this.misionPersonajeList = misionPersonajeList;
	}

	public List<MisionPersonaje> getMisionPersonajeList() {
		return misionPersonajeList;
	}

}
