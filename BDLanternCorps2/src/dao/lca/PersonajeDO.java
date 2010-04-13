package dao.lca;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import dao.api.DataObject;
import dao.api.Reference;

public class PersonajeDO implements DataObject {

	public static final String ALIAS = "alias";
	
	// --------------------------------------------------------------------------------

	private int id;
	private String alias;
	private int experiencia;
	private int puntos_de_entrenamiento;
	private int salud;
	private int energia_del_anillo;
	private int nivel;
	private Date ultima_fecha_ingreso;

	private Reference<UsuarioDO> usuarioRef = new Reference<UsuarioDO>();
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
		return puntos_de_entrenamiento;
	}

	public void setPuntosDeEntrenamiento(int puntos_de_entrenamiento) {
		this.puntos_de_entrenamiento = puntos_de_entrenamiento;
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
		return energia_del_anillo;
	}

	public void setEnergiaDelAnillo(int energia_del_anillo) {
		this.energia_del_anillo = energia_del_anillo;
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
		return ultima_fecha_ingreso;
	}

	public void setUltimaFechaIngreso(Date ultima_fecha_ingreso) {
		this.ultima_fecha_ingreso = ultima_fecha_ingreso;
	}

	// --------------------------------------------------------------------------------

	public Reference<UsuarioDO> getUsuarioRef() {
		return usuarioRef;
	}

	public void setUsuarioRef(Reference<UsuarioDO> usuarioRef) {
		this.usuarioRef = usuarioRef;
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
