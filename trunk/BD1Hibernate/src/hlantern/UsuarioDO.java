package hlantern;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "usuario")
@Proxy(lazy = false)
public class UsuarioDO {

	public static final String ID = "id";
	public static final String NOMBRE = "nombre";
	public static final String CORREO = "correo";
	public static final String CLAVE  = "clave";
	
	public static final String PERSONAJE_ID = "personajeId";

	// --------------------------------------------------------------------------------

	private int id;

	private String nombre;
	private String correo;
	private String clave;
	//private Reference<IPersonajeDO> personajeRef = new Reference<IPersonajeDO>();

	private PersonajeDO personaje;
	// --------------------------------------------------------------------------------

	public UsuarioDO() {
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	// --------------------------------------------------------------------------------

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	// --------------------------------------------------------------------------------
	@OneToOne(cascade = CascadeType.ALL) //referencia al personaje, columna "personajeid"
	@PrimaryKeyJoinColumn
	public PersonajeDO getPersonaje() {
		return personaje;
	}

	public void setPersonaje(PersonajeDO personaje) {
		this.personaje = personaje;
	}

}
