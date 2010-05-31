package Object;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_objetivo")
@Proxy(lazy = false)
public class Objetivo {

	// --------------------------------------------------------------------------------

	private int id;
	private String descripcion;
	private int numeroDeNpc;

	// --------------------------------------------------------------------------------

	private Planeta planetaRef;
	private List<Orden> ordenList = new ArrayList<Orden>();

	// --------------------------------------------------------------------------------

	public Objetivo() {
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

	@Column(nullable = false)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// --------------------------------------------------------------------------------

	@Column(nullable = false)
	public int getNumeroDeNpc() {
		return numeroDeNpc;
	}

	public void setNumeroDeNpc(int numeroDeNpc) {
		this.numeroDeNpc = numeroDeNpc;
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

	@OneToMany(mappedBy = "objetivoRef")
	@LazyCollection(LazyCollectionOption.TRUE)
	@Cascade( { CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	public List<Orden> getOrdenList() {
		return ordenList;
	}

	public void setOrdenList(List<Orden> ordenList) {
		this.ordenList = ordenList;
	}

}
