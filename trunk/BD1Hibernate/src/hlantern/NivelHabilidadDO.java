package hlantern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "nivel_habilidad")
@Proxy(lazy = false)
public class NivelHabilidadDO {

	// --------------------------------------------------------------------------------
	
	public static final String NIVEL_DE_HABILIDAD 	= "nivel_de_habilidad";
	public static final String EFECTIVIDAD 			= "efectividad";
	public static final String COSTO_DE_ENERGIA 	= "costo_de_energia";
	public static final String PROBABILIDAD 		= "probabilidad";

	public static final String HABILIDAD_ID = "habilidadId";
	
	// --------------------------------------------------------------------------------

	private int id;
	
	private int nivel_de_habilidad;
	private float efectividad;
	private double costo_de_energia;
	private int probabilidad;
	
	private HabilidadDO habilidad;
	
	// --------------------------------------------------------------------------------

	public NivelHabilidadDO() {
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
	
	public int getNivel_de_habilidad() {
		return nivel_de_habilidad;
	}

	public void setNivel_de_habilidad(int nivelDeHabilidad) {
		nivel_de_habilidad = nivelDeHabilidad;
	}

	// --------------------------------------------------------------------------------
	
	public float getEfectividad() {
		return efectividad;
	}

	public void setEfectividad(int efectividad) {
		this.efectividad = efectividad;
	}

	// --------------------------------------------------------------------------------
	

	public double getCosto_de_energia() {
		return costo_de_energia;
	}

	public void setCosto_de_energia(double costoDeEnergia) {
		costo_de_energia = costoDeEnergia;
	}

	// --------------------------------------------------------------------------------
	
	public int getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(int probabilidad) {
		this.probabilidad = probabilidad;
	}
	
	// --------------------------------------------------------------------------------
	
	@ManyToOne
	public HabilidadDO getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(HabilidadDO habilidad) {
		this.habilidad = habilidad;
	}

}
