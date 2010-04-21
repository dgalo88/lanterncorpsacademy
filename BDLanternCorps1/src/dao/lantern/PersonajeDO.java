package dao.lantern;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public class PersonajeDO implements DataObject {

	public static final String ALIAS 					= "alias";
	public static final String EXPERIENCIA 				= "experiencia";
	public static final String PUNTOS_DE_ENTRENAMIENTO 	= "puntos_de_entrenamiento";
	public static final String SALUD 					= "salud";
	public static final String ENERGIA_DEL_ANILLO 		= "energia_del_anillo";
	public static final String NIVEL 					= "nivel";
	public static final String ULTIMA_FECHA_INGRESO 	= "ultima_fecha_ingreso";
	
	public static final String USUARIO_ID = "usuarioId";
	public static final String PLANETA_ID = "planetaId";
	public static final String GRUPO_ID = "grupoId";
	public static final String CLASE_LINTERNA_ID = "claseLinternaId";

	
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
	
	private Reference<GrupoDO> grupoRef = new Reference<GrupoDO>();
	
	private Reference<ClaseLinternaDO> claseLinternaRef = new Reference<ClaseLinternaDO>();
	
	private List<HabilidadActivaDO> habilidadActivaList = //
		new ArrayList<HabilidadActivaDO>();

	private List<MisionPersonajeDO> misionPersonajeList = //
		new ArrayList<MisionPersonajeDO>();
	
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

	public void setUltimaFechaIngreso(Date ultimaFechaIngreso) {
		ultima_fecha_ingreso = ultimaFechaIngreso;
	}

	// --------------------------------------------------------------------------------

	public Reference<PlanetaDO> getPlanetaRef() {
		return  planetaRef;
	}

	public void setPlanetaRef(Reference<PlanetaDO> planetaRef) {
		this.planetaRef = planetaRef;
	}

	// --------------------------------------------------------------------------------

	public Reference<GrupoDO> getGrupoRef() {
		return grupoRef;
	}

	public void setGrupoRef(Reference<GrupoDO> grupoRef) {
		this.grupoRef = grupoRef;
	}
	//----------------------------------------------------------------------------------
	
	public void setHabilidadActivaList(List<HabilidadActivaDO> habilidadActivaList) {
		this.habilidadActivaList = habilidadActivaList;
	}

	public List<HabilidadActivaDO> getHabilidadActivaList() {
		return habilidadActivaList;
	}
	
	// --------------------------------------------------------------------------------

	public void setMisionPersonajeList(List<MisionPersonajeDO> misionPersonajeList) {
		this.misionPersonajeList = misionPersonajeList;
	}

	public List<MisionPersonajeDO> getMisionPersonajeList() {
		return misionPersonajeList;
	}
	
	// --------------------------------------------------------------------------------

	public void setClaseLinternaRef(Reference<ClaseLinternaDO> claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}

	public Reference<ClaseLinternaDO> getClaseLinternaRef() {
		return claseLinternaRef;
	}

	// --------------------------------------------------------------------------------

	public void setUsuarioRef(Reference<UsuarioDO> usuarioRef) {
		this.usuarioRef = usuarioRef;
	}

	public Reference<UsuarioDO> getUsuarioRef() {
		return usuarioRef;
	}
	
}
