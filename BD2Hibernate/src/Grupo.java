

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "t_grupo")
@Proxy(lazy = false)

public class Grupo {

	// --------------------------------------------------------------------------------
	
	public static final String NOMBRE = "nombre";
	public static final String ESTADO = "estado";
	public static final String CLASE_LINTERNA_ID = "claseLinternaId";
	
	// --------------------------------------------------------------------------------
	
	private int id;
	private String nombre;
	private boolean estado;
	
	// --------------------------------------------------------------------------------

	private List<Personaje> personajeList =new ArrayList<Personaje>();
	private clase ClaseRef;
	// --------------------------------------------------------------------------------

	public Grupo() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@OneToMany(mappedBy = "grupoRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<Personaje> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<Personaje> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------


	@ManyToOne
	public clase getClaseRef() {
		return claseRef;
	}

	public void setClaseRef(Clase claseRef) {
		this.claseRef = claseRef;
	}

}
