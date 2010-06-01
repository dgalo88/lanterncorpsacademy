package hlantern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "habilidad_clase_linterna")
@Proxy(lazy = false)
public class HabilidadClaseLinternaDO{

	public static final String  HABILIDAD_ID= "habilidadId";
	public static final String  CLASE_LINTERNA_ID= "claselinternaId";
	
	// --------------------------------------------------------------------------------

	private int id;
	
	// --------------------------------------------------------------------------------

	private HabilidadDO habilidad;
	
	private ClaseLinternaDO claseLinterna;
	
	// --------------------------------------------------------------------------------

	public HabilidadClaseLinternaDO() {
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

	public void setHabilidad(HabilidadDO habilidad) {
		this.habilidad = habilidad;
	}
	
	@ManyToOne
	public HabilidadDO getHabilidad() {
		return habilidad;
	}

	// --------------------------------------------------------------------------------

	public void setClaseLinterna(ClaseLinternaDO claseLinterna) {
		this.claseLinterna = claseLinterna;
	}

	@ManyToOne
	public ClaseLinternaDO getClaseLinterna() {
		return claseLinterna;
	}
	
}
