package hlantern;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_mision")
@Proxy(lazy = false)
public class MisionDO {

	public static final String NOMBRE 							= "nombre";
	public static final String DESCRIPCION 						= "descripcion";
	public static final String EXPERIENCIA_GANADA 				= "experiencia_ganada";
	public static final String PUNTOS_DE_ENTRENAMIENTO_GANADOS 	= "puntos_de_entrenamiento_ganados";
	public static final String NIVEL_NECESARIO 					= "nivel_necesario";
	
	// --------------------------------------------------------------------------------

	private int id;

	private String nombre;
	private String descripcion;
	private int experiencia_ganada;
	private int puntos_de_entrenamiento_ganados;
	private int nivel_necesario;

	private List<OrdenDO> OrdenList = //
		new ArrayList<OrdenDO>();
	
	private List<MisionPersonajeDO> MisionPersonajeList = //
		new ArrayList<MisionPersonajeDO>();
		
	private List<MisionClaseLinternaDO> MisionClaselinternaList = //
		new ArrayList<MisionClaseLinternaDO>();
	
	// --------------------------------------------------------------------------------

	public MisionDO() {
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// --------------------------------------------------------------------------------
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// --------------------------------------------------------------------------------
	
	public int getExperiencia_ganada() {
		return experiencia_ganada;
	}

	public void setExperiencia_ganada(int experienciaGanada) {
		experiencia_ganada = experienciaGanada;
	}

	// --------------------------------------------------------------------------------
	
	public int getPuntos_de_entrenamiento_ganados() {
		return puntos_de_entrenamiento_ganados;
	}

	public void setPuntos_de_entrenamiento_ganados(int puntosDeEntrenamientoGanados) {
		puntos_de_entrenamiento_ganados = puntosDeEntrenamientoGanados;
	}
	
	// --------------------------------------------------------------------------------
	
	public int getNivel_necesario() {
		return nivel_necesario;
	}

	public void setNivel_necesario(int nivelNecesario) {
		nivel_necesario = nivelNecesario;
	}

	// --------------------------------------------------------------------------------

	public void setOrdenList(List<OrdenDO> ordenList) {
		OrdenList = ordenList;
	}
	
	@OneToMany(mappedBy = "mision")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<OrdenDO> getOrdenList() {
		return OrdenList;
	}

	// --------------------------------------------------------------------------------

	public void setMisionPersonajeList(List<MisionPersonajeDO> misionPersonajeList) {
		MisionPersonajeList = misionPersonajeList;
	}

	@OneToMany(mappedBy = "mision")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<MisionPersonajeDO> getMisionPersonajeList() {
		return MisionPersonajeList;
	}

	// --------------------------------------------------------------------------------

	public void setMisionClaselinternaList(List<MisionClaseLinternaDO> misionClaselinternaList) {
		MisionClaselinternaList = misionClaselinternaList;
	}
	
	@OneToMany(mappedBy = "mision")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<MisionClaseLinternaDO> getMisionClaselinternaList() {
		return MisionClaselinternaList;
	}

}
