package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public interface IAndroideDO extends DataObject {

	public abstract int getTipo();

	public abstract void setTipo(int tipo);

	//-----------------------------------------------------

	public abstract int getCantidad();

	public abstract void setCantidad(int cantidad);

	//-----------------------------------------------------

	public abstract String getNombre();

	public abstract void setNombre(String nombre);

	//--------------------------------------------------------------------------------------------------------------------

	public abstract Reference<ITecnologiaDO> getTecnologiaRef();

	public abstract void setTecnologiaRef(Reference<ITecnologiaDO> tecnologiaRef);

	//---------------------------------------------------------------

	public abstract List<IAndroidePersonajeDO> getAndroidePersonajeList();

	public abstract void setAndroidePersonajeList(List<IAndroidePersonajeDO> androidePersonajeList);

	//----------------------------------------------------------------------------------------------

	public abstract List<IAndroideRecursoDO> getAndroideRecursoList();

	public abstract void setAndroideRecursojeList(List<IAndroideRecursoDO> androideRecursoList);

}
