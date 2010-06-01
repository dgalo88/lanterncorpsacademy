package hlantern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "mision_clase_linterna")
@Proxy(lazy = false)
public class MisionClaseLinternaDO {

	public static final String CLASE_LINTERNA_ID = "claseLinternaId";
	public static final String MISION_ID = "misionId";


	// --------------------------------------------------------------------------------

	private int id;

	// --------------------------------------------------------------------------------

	private ClaseLinternaDO claseLinterna;

	private MisionDO mision;
		
	// --------------------------------------------------------------------------------

	public MisionClaseLinternaDO() {
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
	@ManyToOne
	public ClaseLinternaDO getClaseLinterna() {
		return claseLinterna;
	}

	public void setClaseLinterna(ClaseLinternaDO claseLinterna) {
		this.claseLinterna = claseLinterna;
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
