package Object;
import javax.persistence.Column;
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
public class Orden {

	// --------------------------------------------------------------------------------

	private int id;
	private int prioridad;

	// --------------------------------------------------------------------------------

	private Objetivo objetivoRef;
	private Mision misionRef;

	// --------------------------------------------------------------------------------

	public Orden() {
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
	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		if (prioridad <= 0)
			return;
		this.prioridad = prioridad;
	}

	// --------------------------------------------------------------------------------

	@ManyToOne
	@Column(nullable = false)
	public void setObjetivoRef(Objetivo objetivoRef) {
		this.objetivoRef = objetivoRef;
	}

	public Objetivo getObjetivoRef() {
		return objetivoRef;
	}

	// --------------------------------------------------------------------------------

	@ManyToOne
	@Column(nullable = false)
	public void setMisionRef(Mision misionRef) {
		this.misionRef = misionRef;
	}

	public Mision getMisionRef() {
		return misionRef;
	}

}
