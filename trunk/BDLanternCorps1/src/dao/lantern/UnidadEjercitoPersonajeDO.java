package dao.lantern;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUnidadEjercitoDO;
import lcaInterfaceDAO.IUnidadEjercitoPersonajeDO;
import dao.api.Reference;

public class UnidadEjercitoPersonajeDO implements IUnidadEjercitoPersonajeDO {

	public static final String VIDA_MAXIMA = "vidaMaxima";
	public static final String VIDA_MINIMA = "vidaMinima";
	public static final String UNIDAD_EJERCITO_ID = "unidadEjercitoId";
	public static final String PERSONAJE_ID = "personajeId";

	// ------------------------------------------------------------------------------------------

	private int id;
	private int vidaMaxima;
	private int vidaMinima;

	// -----------------------------------------------------------------------------------------

	private Reference<IPersonajeDO> personajeRef = //
	new Reference<IPersonajeDO>();

	private Reference<IUnidadEjercitoDO> unidadEjercitoRef = //
	new Reference<IUnidadEjercitoDO>();

	// --------------------------------------------------------------------------------------------

	public UnidadEjercitoPersonajeDO() {

		// empty
	}

	// --------------------------------------------------------------------------------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// -----------------------------------------------------------------------------------------

	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public void setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
	}

	public int getVidaMinima() {
		return vidaMinima;
	}

	public void setVidaMinima(int vidaMinima) {
		this.vidaMinima = vidaMinima;
	}

	// ---------------------------------------------------------------------------------------

	public Reference<IUnidadEjercitoDO> getUnidadEjercitoRef() {
		return unidadEjercitoRef;
	}

	public void setUnidadEjercitoRef(
			Reference<IUnidadEjercitoDO> unidadEjercitoRef) {
		this.unidadEjercitoRef = unidadEjercitoRef;
	}

	// -----------------------------------------------------------------------------------------

	public Reference<IPersonajeDO> getPersonajeRef() {
		return personajeRef;
	}

	public void setPersonajeRef(Reference<IPersonajeDO> personajeRef) {

		this.personajeRef = personajeRef;
	}

	// ----------------------------------------------------------------------------------------
}
