package dao.lca;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IGrupoDO;
import lcaInterfaceDAO.IHabilidadActivaDO;
import lcaInterfaceDAO.IMisionPersonajeDO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDO;
import dao.api.Reference;

public class PersonajeDO implements IPersonajeDO {

	public static final String ALIAS = "alias";
	public static final String EXPERIENCIA = "experiencia";
	public static final String PUNTOS_DE_ENTRENAMIENTO = "puntosDeEntrenamiento";
	public static final String SALUD = "salud";
	public static final String ENERGIA_DEL_ANILLO = "energiaDelAnillo";
	public static final String NIVEL = "nivel";
	public static final String ULTIMA_FECHA_INGRESO = "ultimaFechaIngreso";
	public static final String PLANETA_ID = "planetaId";
	public static final String GRUPO_ID = "grupoId";
	public static final String CLASE_LINTERNA_ID = "claseLinternaId";
	
	// --------------------------------------------------------------------------------

	private int id;
	private String alias;
	private int experiencia;
	private int puntosDeEntrenamiento;
	private int salud;
	private int energiaDelAnillo;
	private int nivel;
	private Date ultimaFechaIngreso;

	private Reference<IPlanetaDO> planetaRef = new Reference<IPlanetaDO>();
	private List<IHabilidadActivaDO> habilidadActivaList = new ArrayList<IHabilidadActivaDO>();
	private List<IMisionPersonajeDO> misionPersonajeList = new ArrayList<IMisionPersonajeDO>();
	private Reference<IGrupoDO> grupoRef = new Reference<IGrupoDO>();
	private Reference<IClaseLinternaDO> claseLinternaRef = new Reference<IClaseLinternaDO>();
	
		// --------------------------------------------------------------------------------

	public PersonajeDO() {
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	// --------------------------------------------------------------------------------

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	// --------------------------------------------------------------------------------

	public int getPuntosDeEntrenamiento() {
		return puntosDeEntrenamiento;
	}

	public void setPuntosDeEntrenamiento(int puntosDeEntrenamiento) {
		this.puntosDeEntrenamiento = puntosDeEntrenamiento;
	}	
	
	// --------------------------------------------------------------------------------

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	// --------------------------------------------------------------------------------

	public int getEnergiaDelAnillo() {
		return energiaDelAnillo;
	}

	public void setEnergiaDelAnillo(int energiaDelAnillo) {
		this.energiaDelAnillo = energiaDelAnillo;
	}

	// --------------------------------------------------------------------------------

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	// --------------------------------------------------------------------------------
	
	public Date getUltimaFechaIngreso() {
		return ultimaFechaIngreso;
	}

	public void setUltimaFechaIngreso(Date ultimaFechaIngreso) {
		this.ultimaFechaIngreso = ultimaFechaIngreso;
	}

	// --------------------------------------------------------------------------------

	public Reference<IPlanetaDO> getPlanetaRef() {
		return  planetaRef;
	}

	public void setPlanetaRef(Reference<IPlanetaDO> planetaRef) {
		this.planetaRef = planetaRef;
	}

	// --------------------------------------------------------------------------------

	public List<IHabilidadActivaDO> getHabilidadActivaList() {
		return  habilidadActivaList;
	}

	public void setHabilidadActivaList(List<IHabilidadActivaDO> habilidadActivaList) {
		this.habilidadActivaList = habilidadActivaList;
	}
	
	// --------------------------------------------------------------------------------

	public List<IMisionPersonajeDO> getMisionPersonajeList() {
		return  misionPersonajeList;
	}

	public void setMisionPersonajelist(List<IMisionPersonajeDO> misionPersonajeList) {
		this.misionPersonajeList = misionPersonajeList;
	}
	
	// --------------------------------------------------------------------------------

	public Reference<IGrupoDO> getGrupoRef() {
		return  grupoRef;
	}

	public void setGrupoRef(Reference<IGrupoDO> grupoRef) {
		this.grupoRef = grupoRef;
	}

	// --------------------------------------------------------------------------------

	public Reference<IClaseLinternaDO> getClaseLinternaRef() {
		return claseLinternaRef;
	}

	public void setClaseLinternaRef(Reference<IClaseLinternaDO> claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}
	
}
