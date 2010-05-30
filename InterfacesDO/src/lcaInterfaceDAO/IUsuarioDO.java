package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IUsuarioDO extends DataObject {

	// --------------------------------------------------------------------------------

	public String getNombre();

	public void setNombre(String nombre);

	// --------------------------------------------------------------------------------

	public String getCorreo();

	public void setCorreo(String correo);

	// --------------------------------------------------------------------------------

	public String getClave();

	public void setClave(String clave);

	// --------------------------------------------------------------------------------

	public Reference<IPersonajeDO> getPersonajeRef();

	public void setPersonajeRef(Reference<IPersonajeDO> personajeRef);
}
