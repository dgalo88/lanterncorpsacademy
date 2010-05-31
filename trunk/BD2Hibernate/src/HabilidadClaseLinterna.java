import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "t_claseLinterna")
@Proxy(lazy = false)
public class HabilidadClaseLinterna{

	// --------------------------------------------------------------------------------

	private int id;
	
	// --------------------------------------------------------------------------------

	private Habilidad habilidadRef;
	private ClaseLinterna claseLinternaRef;
	
	// --------------------------------------------------------------------------------

	public HabilidadClaseLinterna() {
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
	public Habilidad getHabilidadRef() {
		return habilidadRef;
	}

	public void setHabilidadRef(Habilidad habilidadRef) {
		this.habilidadRef = habilidadRef;
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
