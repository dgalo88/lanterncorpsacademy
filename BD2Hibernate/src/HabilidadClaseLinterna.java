
public class HabilidadClaseLinterna{

	// --------------------------------------------------------------------------------

	private int id;
	
	// --------------------------------------------------------------------------------

	private Habilidad habilidadRef;
	private ClaseLinterna claseLinternaRef;
	
	// --------------------------------------------------------------------------------

	public HabilidadClaseLinterna() {
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

	public Habilidad getHabilidadRef() {
		return habilidadRef;
	}

	public void setHabilidadRef(Habilidad habilidadRef) {
		this.habilidadRef = habilidadRef;
	}

	// --------------------------------------------------------------------------------

	public ClaseLinterna getClaseLinternaRef() {
		return claseLinternaRef;
	}

	public void setClaseLinternaRef(ClaseLinterna claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}

}
