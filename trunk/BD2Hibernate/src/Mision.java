import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_mision")
@Proxy(lazy = false)
public class Mision {

	// --------------------------------------------------------------------------------

	private int id;
	private String nombre;
	private String descripcion;
	private int experienciaGanada;
	private int puntosDeEntrenamientoGanados;
	private int nivelNecesario;

	private List<Orden> ordenList;
	private List<MisionPersonaje> misionPersonajeList;

	// --------------------------------------------------------------------------------

	public Mision() {
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
	@Column(nullable = false, length = 100)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// --------------------------------------------------------------------------------

	@Column(nullable = false)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// --------------------------------------------------------------------------------

	@Column(nullable = false)
	public int getExperiencia_ganada() {
		return experienciaGanada;
	}

	public void setExperiencia_ganada(int experienciaGanada) {
		if (experienciaGanada < 0)
			return;
		this.experienciaGanada = experienciaGanada;
	}

	// --------------------------------------------------------------------------------

	@Column(nullable = false)
	public int getPuntos_de_entrenamiento_ganados() {
		return puntosDeEntrenamientoGanados;
	}

	public void setPuntos_de_entrenamiento_ganados(
			int puntosDeEntrenamientoGanados) {
		if (puntosDeEntrenamientoGanados < 0)
			return;
		this.puntosDeEntrenamientoGanados = puntosDeEntrenamientoGanados;
	}

	// --------------------------------------------------------------------------------

	@Column(nullable = false)
	public int getNivel_necesario() {
		return nivelNecesario;
	}

	public void setNivel_necesario(int nivelNecesario) {
		if (nivelNecesario <= 0)
			return;
		this.nivelNecesario = nivelNecesario;
	}

	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "misionRef")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public void setOrdenList(List<Orden> ordenList) {
		this.ordenList = ordenList;
	}

	public List<Orden> getOrdenList() {
		return ordenList;
	}

	// --------------------------------------------------------------------------------
	@OneToMany(mappedBy = "misionRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL })
	public void setMisionPersonajeList(List<MisionPersonaje> misionPersonajeList) {
		this.misionPersonajeList = misionPersonajeList;
	}

	public List<MisionPersonaje> getMisionPersonajeList() {
		return misionPersonajeList;
	}

}
