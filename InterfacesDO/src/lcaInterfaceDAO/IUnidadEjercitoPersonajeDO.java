package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IUnidadEjercitoPersonajeDO extends DataObject {

	// ---------------------------------------------------------------------------------------

	public abstract int getVidaMaxima();

	public abstract void setVidaMaxima(int vidaMaxima);

	public abstract int getVidaMinima();

	public abstract void setVidaMinima(int vidaMinima);

	// ---------------------------------------------------------------------------------------

	public abstract Reference<IUnidadEjercitoDO> getUnidadEjercitoRef();

	public abstract void setUnidadEjercitoRef(
			Reference<IUnidadEjercitoDO> unidadEjercitoRef);

	// -----------------------------------------------------------------------------------------

	public abstract Reference<IPersonajeDO> getPersonajeRef();

	public abstract void setPersonajeRef(Reference<IPersonajeDO> personajeRef);

	// ----------------------------------------------------------------------------------------
}
