package hlantern;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "objetivo")
@Proxy(lazy = false)
public class ObjetivoDO {

	public static final String DESCRIPCION = "descripcion";
	public static final String NUMERO_DE_NPC = "numero_de_npc";
	
	public static final String PLANETA_ID = "planetaId";
	public static final String ORDEN_ID = "ordenId";
	
	// --------------------------------------------------------------------------------

	private int id;

	private String descripcion;
	private int numero_de_npc;
	
	// --------------------------------------------------------------------------------
	
	private PlanetaDO planeta;
	
	private List<OrdenDO> OrdenList = //
		new ArrayList<OrdenDO>();
	
	// --------------------------------------------------------------------------------

	public ObjetivoDO() {
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// --------------------------------------------------------------------------------
	
	public int getNumeroDeNpc() {
		return numero_de_npc;
	}

	public void setNumeroDeNpc(int numeroDeNpc) {
		numero_de_npc = numeroDeNpc;
	}

	// --------------------------------------------------------------------------------
	
	@ManyToOne
	public PlanetaDO getPlaneta() {
		return planeta;
	}

	public void setPlaneta(PlanetaDO planeta) {
		this.planeta = planeta;
	}
	
	// --------------------------------------------------------------------------------

	public void setOrdenList(List<OrdenDO> ordenList) {
		OrdenList = ordenList;
	}
	
	@OneToMany(mappedBy = "objetivo")
	@LazyCollection(LazyCollectionOption.FALSE)
	@Cascade({org.hibernate.annotations.CascadeType.ALL, org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	public List<OrdenDO> getOrdenList() {
		return OrdenList;
	}
	
	// --------------------------------------------------------------------------------
}
