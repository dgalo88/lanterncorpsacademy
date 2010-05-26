package hlantern;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IGrupoDO;
import lcaInterfaceDAO.IHabilidadActivaDO;
import lcaInterfaceDAO.IMisionPersonajeDO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IUsuarioDO;
import dao.api.Reference;

public class PersonajeDO implements IPersonajeDO {

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

	private Reference<IUsuarioDO> usuarioRef = new Reference<IUsuarioDO>();

	private Reference<IPlanetaDO> planetaRef = new Reference<IPlanetaDO>();
	
	private Reference<IGrupoDO> grupoRef = new Reference<IGrupoDO>();
	
	private Reference<IClaseLinternaDO> claseLinternaRef = new Reference<IClaseLinternaDO>();
	
	private List<IHabilidadActivaDO> habilidadActivaList = //
		new ArrayList<IHabilidadActivaDO>();

	private List<IMisionPersonajeDO> misionPersonajeList = //
		new ArrayList<IMisionPersonajeDO>();
	
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

	public Reference<IPlanetaDO> getPlanetaRef() {
		return  planetaRef;
	}

	public void setPlanetaRef(Reference<IPlanetaDO> planetaRef) {
		this.planetaRef = planetaRef;
	}

	// --------------------------------------------------------------------------------

	public Reference<IGrupoDO> getGrupoRef() {
		return grupoRef;
	}

	public void setGrupoRef(Reference<IGrupoDO> grupoRef) {
		this.grupoRef = grupoRef;
	}
	//----------------------------------------------------------------------------------
	
	public void setHabilidadActivaList(List<IHabilidadActivaDO> habilidadActivaList) {
		this.habilidadActivaList = habilidadActivaList;
	}

	public List<IHabilidadActivaDO> getHabilidadActivaList() {
		return habilidadActivaList;
	}
	
	// --------------------------------------------------------------------------------

	public void setMisionPersonajelist(List<IMisionPersonajeDO> misionPersonajeList) {
		this.misionPersonajeList = misionPersonajeList;
	}

	public List<IMisionPersonajeDO> getMisionPersonajeList() {
		return misionPersonajeList;
	}
	
	// --------------------------------------------------------------------------------

	public void setClaseLinternaRef(Reference<IClaseLinternaDO> claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}

	public Reference<IClaseLinternaDO> getClaseLinternaRef() {
		return claseLinternaRef;
	}

	// --------------------------------------------------------------------------------

	public void setUsuarioRef(Reference<IUsuarioDO> usuarioRef) {
		this.usuarioRef = usuarioRef;
	}

	public Reference<IUsuarioDO> getUsuarioRef() {
		return usuarioRef;
	}
	
}
