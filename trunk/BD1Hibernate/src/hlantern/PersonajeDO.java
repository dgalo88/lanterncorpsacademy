package hlantern;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lcaInterfaceDAO.IHabilidadActivaDO;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "personaje")
@Proxy(lazy = false)
public class PersonajeDO {

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
	private int salud=200; //los defaults de las tablas... t_
	private int energia_del_anillo=100;
	private int nivel=1;
	private Date ultima_fecha_ingreso;

	private UsuarioDO usuario;

	private PlanetaDO planeta;
	
	private GrupoDO grupo;
	
	private ClaseLinternaDO claseLinterna;
	
	private List<HabilidadActivaDO> habilidadActivaList = //
		new ArrayList<HabilidadActivaDO>();

	private List<MisionPersonajeDO> misionPersonajeList = //
		new ArrayList<MisionPersonajeDO>();
	
		// --------------------------------------------------------------------------------

	public PersonajeDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@ManyToOne
	public PlanetaDO getPlaneta() {
		return  planeta;
	}

	public void setPlaneta(PlanetaDO planeta) {
		this.planeta = planeta;
	}

	// --------------------------------------------------------------------------------
	@ManyToOne
	public GrupoDO getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoDO grupo) {
		this.grupo = grupo;
	}
	//----------------------------------------------------------------------------------
	
	public void setHabilidadActivaList(List<HabilidadActivaDO> habilidadActivaList) {
		this.habilidadActivaList = habilidadActivaList;
	}
	@OneToMany(mappedBy = "personaje")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<HabilidadActivaDO> getHabilidadActivaList() {
		return habilidadActivaList;
	}
	
	// --------------------------------------------------------------------------------
	            // MisionPersonajeList
	public void setMisionPersonajeList(List<MisionPersonajeDO> misionPersonajeList) {
		this.misionPersonajeList = misionPersonajeList;
	}
	@OneToMany(mappedBy = "personaje")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<MisionPersonajeDO> getMisionPersonajeList() {
		return misionPersonajeList;
	}
	
	// --------------------------------------------------------------------------------

	public void setClaseLinterna(ClaseLinternaDO claseLinterna) {
		this.claseLinterna = claseLinterna;
	}
	
	@ManyToOne
	public ClaseLinternaDO getClaseLinterna() {
		return claseLinterna;
	}

	// --------------------------------------------------------------------------------
	public void setUsuario(UsuarioDO usuario) {
		this.usuario = usuario;
	}

	@OneToOne(mappedBy = "personaje") //referenciado por: usuario, mediante personajeRef
	public UsuarioDO getUsuario() {
		return usuario;
	}
//	
}
