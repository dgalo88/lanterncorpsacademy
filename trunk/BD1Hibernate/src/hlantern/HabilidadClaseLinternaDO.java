package hlantern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IHabilidadClaseLinternaDO;
import lcaInterfaceDAO.IHabilidadDO;
import dao.api.Reference;

@Entity
@Table(name = "t_habilidad_clase_linterna")
@Proxy(lazy = false)
public class HabilidadClaseLinternaDO implements IHabilidadClaseLinternaDO {

	public static final String  HABILIDAD_ID= "habilidadId";
	public static final String  CLASE_LINTERNA_ID= "claselinternaId";
	
	// --------------------------------------------------------------------------------

	private int id;
	
	// --------------------------------------------------------------------------------

	private Reference<IHabilidadDO> habilidadRef = new Reference<IHabilidadDO>();
	
	private Reference<IClaseLinternaDO> claseLinternaRef = new Reference<IClaseLinternaDO>();
	
	// --------------------------------------------------------------------------------

	public HabilidadClaseLinternaDO() {
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

	public void setHabilidadRef(Reference<IHabilidadDO> habilidadRef) {
		this.habilidadRef = habilidadRef;
	}
	
	@ManyToOne
	public Reference<IHabilidadDO> getHabilidadRef() {
		return habilidadRef;
	}

	// --------------------------------------------------------------------------------

	public void setClaseLinternaRef(Reference<IClaseLinternaDO> claseLinternaRef) {
		this.claseLinternaRef = claseLinternaRef;
	}

	@ManyToOne
	public Reference<IClaseLinternaDO> getClaseLinternaRef() {
		return claseLinternaRef;
	}
	
}
