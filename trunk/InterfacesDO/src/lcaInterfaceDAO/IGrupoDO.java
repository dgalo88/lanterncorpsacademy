package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public interface IGrupoDO extends DataObject{

	public abstract String getNombre();

	public abstract void setNombre(String nombre);

	public abstract boolean isEstado();

	public abstract void setEstado(boolean estado);

	public abstract List<IPersonajeDO> getPersonajeList();

	public abstract void setPersonajeList(List<IPersonajeDO> personajeList);

	public abstract Reference<IClaseLinternaDO> getClaseLinternaRef();

	public abstract void setClaseLinternaRef(
			Reference<IClaseLinternaDO> claseLinternaRef);

}