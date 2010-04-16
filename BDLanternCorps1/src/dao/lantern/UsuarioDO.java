package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public class UsuarioDO implements DataObject {

	public static final String NOMBRE = "nombre";
	public static final String CORREO = "correo";
	public static final String CLAVE  = "clave";
	public static final String PERSONAJE_ID = "personajeId";

	// --------------------------------------------------------------------------------

	private int id;

	private String nombre;
	private String correo;
	private String clave;

	private Reference<PersonajeDO> personajeRef = new Reference<PersonajeDO>();

	// --------------------------------------------------------------------------------

	public UsuarioDO() {
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

	public Reference<PersonajeDO> getPersonajeRef() {
		return personajeRef;
	}

	public void setPersonajeRef(Reference<PersonajeDO> personajeRef) {
		this.personajeRef = personajeRef;
	}

}
