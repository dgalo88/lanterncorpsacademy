
public class HabilidadActiva{

	
	// --------------------------------------------------------------------------------

	private int id;
	private int nivelHabilidad;
	// --------------------------------------------------------------------------------

	private Personaje personajeRef ;
	private Habilidad habilidadRef;
	
	// --------------------------------------------------------------------------------

	public HabilidadActiva() {
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
	
	public int getNivel_habilidad() {
		return nivelHabilidad;
	}

	public void setNivel_habilidad(int nivelHabilidad) {
		this.nivelHabilidad = nivelHabilidad;
	}
	
	// --------------------------------------------------------------------------------

	public Personaje getPersonajeRef() {
		return personajeRef;
	}

	public void setPersonajeRef(Personaje personajeRef) {
		this.personajeRef = personajeRef;
	}

	// --------------------------------------------------------------------------------

	public Habilidad getHabilidadRef() {
		return habilidadRef;
	}

	public void setHabilidadRef(Habilidad habilidadRef) {
		this.habilidadRef = habilidadRef;
	}

}
