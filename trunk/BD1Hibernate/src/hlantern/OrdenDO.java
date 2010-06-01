package hlantern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_orden")
@Proxy(lazy = false)
public class OrdenDO {

	public static final String PRIORIDAD = "prioridad";
	public static final String OBJETIVO_ID = "objetivoId";
	public static final String MISION_ID = "misionId";

	// --------------------------------------------------------------------------------
	
	private int id;

	private int prioridad;
	
	// --------------------------------------------------------------------------------

	private ObjetivoDO objetivo;
	
	private MisionDO mision;
		
	// --------------------------------------------------------------------------------

	public OrdenDO() {
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

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
		
	// --------------------------------------------------------------------------------

	public void setObjetivo(ObjetivoDO objetivo) {
		this.objetivo = objetivo;
	}
	
	@ManyToOne
	public ObjetivoDO getObjetivo() {
		return objetivo;
	}

	// --------------------------------------------------------------------------------

	public void setMision(MisionDO mision) {
		this.mision = mision;
	}

	@ManyToOne
	public MisionDO getMision() {
		return mision;
	}

}
