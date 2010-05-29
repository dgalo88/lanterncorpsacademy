package hlantern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IMisionClaseLinternaDO;
import lcaInterfaceDAO.IMisionDO;
import dao.api.Reference;

@Entity
@Table(name = "t_mision_clase_linterna")
@Proxy(lazy = false)
public class MisionClaseLinternaDO implements IMisionClaseLinternaDO {

	public static final String CLASE_LINTERNA_ID = "claseLinternaId";
	public static final String MISION_ID = "misionId";


	// --------------------------------------------------------------------------------

	private int id;

	// --------------------------------------------------------------------------------

	private Reference<IClaseLinternaDO> claseLinternaRef = new Reference<IClaseLinternaDO>();

	private Reference<IMisionDO> misionRef = new Reference<IMisionDO>();
		
	// --------------------------------------------------------------------------------

	public MisionClaseLinternaDO() {
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
	@ManyToOne
	public Reference<IClaseLinternaDO> getClaseLinternaRef() {
		return claseLinternaRef;
	}

	public void setClaseLinternaRef(Reference<IClaseLinternaDO> claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
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
