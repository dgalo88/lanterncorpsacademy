import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_personaje")
@Proxy(lazy = false)
public class Personaje {

	// --------------------------------------------------------------------------------

	private int id;
	private String alias;
	private int experiencia;
	private int puntosDeEntrenamiento;
	private int salud;
	private int energiaDelAnillo;
	private int nivel;
	private Date ultimaFechaIngreso;

	private Planeta planetaRef;
	private List<HabilidadActiva> habilidadActivaList = new ArrayList<HabilidadActiva>();
	private List<MisionPersonaje> misionPersonajeList = new ArrayList<MisionPersonaje>();
	private Grupo grupoRef;
	private ClaseLinterna claseLinternaRef;

	// --------------------------------------------------------------------------------

	public Personaje() {
		// Empty
	}

	// --------------------------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OneToOne(mappedBy = "personajeRef")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// --------------------------------------------------------------------------------
	@Column(unique = true, nullable = false)
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
		if (experiencia < this.experiencia)
			return;
		this.experiencia = experiencia;
	}

	// --------------------------------------------------------------------------------

	public int getPuntosDeEntrenamiento() {
		return puntosDeEntrenamiento;
	}

	public void setPuntosDeEntrenamiento(int puntosDeEntrenamiento) {
		if (puntosDeEntrenamiento < 0)
			return;
		this.puntosDeEntrenamiento = puntosDeEntrenamiento;
	}

	// --------------------------------------------------------------------------------

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		if (salud < 0)
			return;
		this.salud = salud;
	}

	// --------------------------------------------------------------------------------

	public int getEnergiaDelAnillo() {
		return energiaDelAnillo;
	}

	public void setEnergiaDelAnillo(int energiaDelAnillo) {
		if (energiaDelAnillo < 0)
			return;
		this.energiaDelAnillo = energiaDelAnillo;
	}

	// --------------------------------------------------------------------------------

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		if (nivel <= this.nivel)
			return;
		this.nivel = nivel;
	}

	// --------------------------------------------------------------------------------

	public Date getUltimaFechaIngreso() {
		return ultimaFechaIngreso;
	}

	public void setUltimaFechaIngreso(Date ultimaFechaIngreso) {
		if (ultimaFechaIngreso.before(this.ultimaFechaIngreso))
			return;
		this.ultimaFechaIngreso = ultimaFechaIngreso;
	}

	// --------------------------------------------------------------------------------

	@ManyToOne
	public Planeta getPlanetaRef() {
		return planetaRef;
	}

	public void setPlanetaRef(Planeta planetaRef) {

		this.planetaRef = planetaRef;
	}

	// --------------------------------------------------------------------------------

	@OneToMany(mappedBy = "habilidadRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<HabilidadActiva> getHabilidadActivaList() {
		return habilidadActivaList;
	}

	public void setHabilidadActivaList(List<HabilidadActiva> habilidadActivaList) {
		this.habilidadActivaList = habilidadActivaList;
	}

	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "personajeRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<MisionPersonaje> getMisionPersonajeList() {
		return misionPersonajeList;
	}

	public void setMisionPersonajelist(List<MisionPersonaje> misionPersonajeList) {
		this.misionPersonajeList = misionPersonajeList;
	}

	// --------------------------------------------------------------------------------

	@ManyToOne
	public Grupo getGrupoRef() {
		return grupoRef;
	}

	public void setGrupoRef(Grupo grupoRef) {
		this.grupoRef = grupoRef;
	}

	// --------------------------------------------------------------------------------

	@ManyToOne
	public ClaseLinterna getClaseLinternaRef() {
		return claseLinternaRef;
	}

	public void setClaseLinternaRef(ClaseLinterna claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}

}
