package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IGrupoDO;
import lcaInterfaceDAO.IHabilidadClaseLinternaDO;
import lcaInterfaceDAO.IMisionClaseLinternaDO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDO;
import dao.api.Reference;

public class ClaseLinternaDO implements IClaseLinternaDO {

	public static final String COLOR = "color";
	public static final String NOMBRE_DE_CUERPO_LINTERNA   = "nombre_de_cuerpo_linterna";
	
	public static final String PLANETA_ID = "planetaId";
	
	// --------------------------------------------------------------------------------

	private int id;
	
	private String color;
	private String nombre_de_cuerpo_linterna;
	
	// --------------------------------------------------------------------------------

	private List<IGrupoDO> grupoList = //
	new ArrayList<IGrupoDO>();

	private List<IPersonajeDO> personajeList = //
		new ArrayList<IPersonajeDO>();
	
	private List<IHabilidadClaseLinternaDO> habilidadClaseLinternaList = //
		new ArrayList<IHabilidadClaseLinternaDO>();
	
	private List<IMisionClaseLinternaDO> misionClaseLinternaList = //
		new ArrayList<IMisionClaseLinternaDO>();	
	
	private Reference<IPlanetaDO> planetaRef = new Reference<IPlanetaDO>();
	
	// --------------------------------------------------------------------------------

	public ClaseLinternaDO() {
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// --------------------------------------------------------------------------------
	
	public String getNombre_de_cuerpo_linterna() {
		return nombre_de_cuerpo_linterna;
	}
	
	public void setNombre_de_cuerpo_linterna(String nombreDeCuerpoLinterna) {
		this.nombre_de_cuerpo_linterna = nombreDeCuerpoLinterna;
	}
	
	// --------------------------------------------------------------------------------


	public List<IPersonajeDO> getPersonajeList() {
		return personajeList;
	}

	public void setPersonajeList(List<IPersonajeDO> personajeList) {
		this.personajeList = personajeList;
	}

	// --------------------------------------------------------------------------------

	public List<IGrupoDO> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(List<IGrupoDO> grupoList) {
		this.grupoList = grupoList;
	}

	// --------------------------------------------------------------------------------

	public Reference<IPlanetaDO> getPlanetaRef() {
		return planetaRef;
	}

	public void setPlanetaRef(Reference<IPlanetaDO> planetaRef) {
		this.planetaRef = planetaRef;
	}

	// --------------------------------------------------------------------------------
	
	public void setHabilidadClaseLinternaList(
			List<IHabilidadClaseLinternaDO> habilidadClaseLinternaList) {
		this.habilidadClaseLinternaList = habilidadClaseLinternaList;
	}

	public List<IHabilidadClaseLinternaDO> getHabilidadClaseLinternaList() {
		return habilidadClaseLinternaList;
	}

	// --------------------------------------------------------------------------------
	
	public void setMisionClaseLinternaList(List<IMisionClaseLinternaDO> misionClaseLinternaList) {
		this.misionClaseLinternaList = misionClaseLinternaList;
	}

	public List<IMisionClaseLinternaDO> getMisionClaseLinternaList() {
		return misionClaseLinternaList;
	}



	// --------------------------------------------------------------------------------

}
