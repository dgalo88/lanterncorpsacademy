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

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUsuarioDO;
import dao.api.Reference;


@Entity
@Table(name = "t_usuario")
@Proxy(lazy = false)
public class UsuarioDO implements IUsuarioDO {

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

	private Reference<IPersonajeDO> personajeRef = new Reference<IPersonajeDO>();

	// --------------------------------------------------------------------------------

	public UsuarioDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	@Override
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
	public Reference<IPersonajeDO> getPersonajeRef() {
		return personajeRef;
	}

	public void setPersonajeRef(Reference<IPersonajeDO> personajeRef) {
		this.personajeRef = personajeRef;
	}

}
