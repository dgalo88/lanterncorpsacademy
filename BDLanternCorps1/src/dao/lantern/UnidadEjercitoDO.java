package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IUnidadBasicaDO;
import lcaInterfaceDAO.IUnidadEjercitoDO;
import lcaInterfaceDAO.IUnidadEjercitoOfertaDO;
import lcaInterfaceDAO.IUnidadEjercitoPersonajeDO;
import dao.api.Reference;

public class UnidadEjercitoDO implements IUnidadEjercitoDO {

	public static final String NOMBRE = "nombre";

	public static final String EJERCITO_PERSONAJE_ID = "ejercitoPersonajeId";

	public static final String UNIDAD_BASICA_ARMA_ID = "unidadBasicaArma";

	public static final String UNIDAD_BASICA_ROBOT_ID = "unidadBasicaRobot";

	public static final String UNIDAD_BASICA_VEHICULO_ID = "unidadBasicaVehiculo";

	public static final String UNIDAD_BASICA_BALA_ID = "unidadBasicaBala";

	public static final String PLANETA_ID = "planetaId";

	// -------------------------------------------------------------------------------------------------

	private int id;

	private String nombre;

	// ---------------------------------------------------------------------------------------------------

	private List<IUnidadEjercitoPersonajeDO> unidadEjercitoPersonajeList = //
	new ArrayList<IUnidadEjercitoPersonajeDO>();

	private List<IUnidadEjercitoOfertaDO> unidadEjercitoOfertaList = //
	new ArrayList<IUnidadEjercitoOfertaDO>();

	private Reference<IUnidadBasicaDO> unidadBasicaArmaRef = //
	new Reference<IUnidadBasicaDO>();

	private Reference<IUnidadBasicaDO> unidadBasicaRobotRef = //
	new Reference<IUnidadBasicaDO>();

	private Reference<IUnidadBasicaDO> unidadBasicaVehiculoRef = //
	new Reference<IUnidadBasicaDO>();

	private Reference<IUnidadBasicaDO> unidadBasicaBalaRef = //
	new Reference<IUnidadBasicaDO>();

	private Reference<IPlanetaDO> planetaRef = //
	new Reference<IPlanetaDO>();

	// ---------------------------------------------------------------------------------------------

	public UnidadEjercitoDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	// ----------------------------------------------------------------------------------------------------

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// ----------------------------------------------------------------------------------------

	public List<IUnidadEjercitoPersonajeDO> getUnidadEjercitoPersonajeList() {

		return unidadEjercitoPersonajeList;
	}

	public void setUnidadEjercitoPersonajeList(
			List<IUnidadEjercitoPersonajeDO> unidadEjercitoPersonajeList) {

		this.unidadEjercitoPersonajeList = unidadEjercitoPersonajeList;
	}

	// ----------------------------------------------------------------------------------------------------

	public List<IUnidadEjercitoOfertaDO> getUnidadEjercitoOfertaList() {
		return unidadEjercitoOfertaList;
	}

	public void setUnidadEjercitoOfertaList(
			List<IUnidadEjercitoOfertaDO> unidadEjercitoOfertaList) {

		this.unidadEjercitoOfertaList = unidadEjercitoOfertaList;
	}

	// --------------------------------------------------------------------------------------

	public Reference<IUnidadBasicaDO> getUnidadBasicaArmaRef() {

		return unidadBasicaArmaRef;
	}

	public void setUnidadBasicaArmaRef(
			Reference<IUnidadBasicaDO> unidadBasicaArmaRef) {
		this.unidadBasicaArmaRef = unidadBasicaArmaRef;
	}

	// ------------------------------------------------------------------------------------

	public Reference<IUnidadBasicaDO> getUnidadBasicaRobotRef() {

		return unidadBasicaRobotRef;
	}

	public void setUnidadBasicaRobotRef(
			Reference<IUnidadBasicaDO> unidadBasicaRobotRef) {

		this.unidadBasicaRobotRef = unidadBasicaRobotRef;
	}

	// ----------------------------------------------------------------------------------------

	public Reference<IUnidadBasicaDO> getUnidadBasicaVehiculoRef() {
		return unidadBasicaVehiculoRef;
	}

	public void setUnidadBasicaVehiculoRef(
			Reference<IUnidadBasicaDO> unidadBasicaVehiculoRef) {

		this.unidadBasicaVehiculoRef = unidadBasicaVehiculoRef;
	}

	// ----------------------------------------------------------------------------------------
	public Reference<IUnidadBasicaDO> getUnidadBasicaBalaRef() {

		return unidadBasicaBalaRef;
	}

	public void setUnidadBasicaBalaRef(
			Reference<IUnidadBasicaDO> unidadBasicaBalaRef) {
		this.unidadBasicaBalaRef = unidadBasicaBalaRef;
	}
	// --------------------------------------------------------------------------------------------------

	@Override
	public Reference<IPlanetaDO> getPlanetaRef() {
		return planetaRef;
	}

	@Override
	public void setPlanetaRef(Reference<IPlanetaDO> planetaRef) {
		this.planetaRef = planetaRef;
		
	}

}
