package hlantern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lcaInterfaceDAO.IMisionDO;
import lcaInterfaceDAO.IObjetivoDO;
import lcaInterfaceDAO.IOrdenDO;
import dao.api.Reference;

@Entity
@Table(name = "t_orden")
@Proxy(lazy = false)
public class OrdenDO implements IOrdenDO {

	public static final String PRIORIDAD = "prioridad";
	public static final String OBJETIVO_ID = "objetivoId";
	public static final String MISION_ID = "misionId";

	// --------------------------------------------------------------------------------
	
	private int id;

	private int prioridad;
	
	// --------------------------------------------------------------------------------

	private Reference<IObjetivoDO> objetivoRef = new Reference<IObjetivoDO>();
	
	private Reference<IMisionDO> misionRef = new Reference<IMisionDO>();
		
	// --------------------------------------------------------------------------------

	public OrdenDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	@Override
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

	public void setObjetivoRef(Reference<IObjetivoDO> objetivoRef) {
		this.objetivoRef = objetivoRef;
	}
	
	@ManyToOne
	public Reference<IObjetivoDO> getObjetivoRef() {
		return objetivoRef;
	}

	// --------------------------------------------------------------------------------

	public void setMisionRef(Reference<IMisionDO> misionRef) {
		this.misionRef = misionRef;
	}

	@ManyToOne
	public Reference<IMisionDO> getMisionRef() {
		return misionRef;
	}

}
