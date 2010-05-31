package Object;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_usuario")
@Proxy(lazy = false)
public class Usuario {

	// --------------------------------------------------------------------------------

	private int id;
	private String nombre;
	private String correo;
	private String clave;

	// --------------------------------------------------------------------------------

	private Personaje personajeRef;

	// --------------------------------------------------------------------------------

	public Usuario() {
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

	@Column(length = 50, nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// --------------------------------------------------------------------------------
	@Column(unique = true, nullable = false)
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	// --------------------------------------------------------------------------------

	@Column(length = 12, nullable = false)
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		if (clave.length() < 6)
			return;
		this.clave = clave;
	}

	// --------------------------------------------------------------------------------

	@OneToOne(cascade = CascadeType.ALL)
	public Personaje getPersonajeRef() {
		return personajeRef;
	}

	public void setPersonajeRef(Personaje personajeRef) {
		this.personajeRef = personajeRef;
	}

}
