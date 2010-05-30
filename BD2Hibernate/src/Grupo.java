

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IClaseLinterna;
import lcaInterfaceDAO.IGrupo;
import lcaInterfaceDAO.IPersonaje;
import dao.api.Reference;

@Entity
@Table(name = "t_grupo")
@Proxy(lazy = false)

public class Grupo implements IGrupo {

	// --------------------------------------------------------------------------------
	
	public static final String NOMBRE = "nombre";
	public static final String ESTADO = "estado";
	public static final String CLASE_LINTERNA_ID = "claseLinternaId";
	
	// --------------------------------------------------------------------------------
	
	private int id;
	private String nombre;
	private boolean estado;
	
	// --------------------------------------------------------------------------------

	private List<IPersonaje> personajeList =new ArrayList<IPersonaje>();
//	private Reference<IClaseLinternaDO> claseLinternaRef = new Reference<IClaseLinternaDO>();
	private clase getClaseRef;
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
	public List<IPersonaje> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<IPersonaje> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------

//	public Reference<IClaseLinternaDO> getClaseLinternaRef() {
//		return claseLinternaRef;
//	}
//
//	public void setClaseLinternaRef(Reference<IClaseLinternaDO> claseLinternaRef) {
//		this.claseLinternaRef = claseLinternaRef;
//	}
	
	@ManyToOne
	public clase getClaseRef() {
		return claseRef;
	}

	public void setClaseRef(Clase claseRef) {
		this.claseRef = claseRef;
	}

}
