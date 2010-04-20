package dao.lca;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import dao.api.DataObject;
import dao.api.Reference;

public class PersonajeDO implements DataObject {

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

	private Reference<PlanetaDO> planetaRef = new Reference<PlanetaDO>();
	private List<HabilidadActivaDO> habilidadActivaList = new ArrayList<HabilidadActivaDO>();
	private List<MisionPersonajeDO> misionPersonajeList = new ArrayList<MisionPersonajeDO>();
	private Reference<GrupoDO> grupoRef = new Reference<GrupoDO>();
	private Reference<ClaseLinternaDO> claseLinternaRef = new Reference<ClaseLinternaDO>();
	
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

	public Reference<PlanetaDO> getPlanetaRef() {
		return  planetaRef;
	}

	public void setPlanetaRef(Reference<PlanetaDO> planetaRef) {
		this.planetaRef = planetaRef;
	}

	// --------------------------------------------------------------------------------

	public List<HabilidadActivaDO> getHabilidadActivaList() {
		return  habilidadActivaList;
	}

	public void setHabilidadActivaList(List<HabilidadActivaDO> habilidadActivaList) {
		this.habilidadActivaList = habilidadActivaList;
	}
	
	// --------------------------------------------------------------------------------

	public List<MisionPersonajeDO> getMisionPersonajeList() {
		return  misionPersonajeList;
	}

	public void setMisionPersonajelist(List<MisionPersonajeDO> misionPersonajeList) {
		this.misionPersonajeList = misionPersonajeList;
	}
	
	// --------------------------------------------------------------------------------

	public Reference<GrupoDO> getGrupoRef() {
		return  grupoRef;
	}

	public void setGrupoRef(Reference<GrupoDO> grupoRef) {
		this.grupoRef = grupoRef;
	}

	// --------------------------------------------------------------------------------

	public Reference<ClaseLinternaDO> getClaseLinternaRef() {
		return claseLinternaRef;
	}

	public void setClaseLinternaRef(Reference<ClaseLinternaDO> claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}
	
}
