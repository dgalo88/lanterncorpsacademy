package hlantern;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IHabilidadActivaDO;
import lcaInterfaceDAO.IHabilidadClaseLinternaDO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.INivelHabilidadDO;

public class HabilidadDO implements IHabilidadDO {

	public static final String ID     	= "id";
	public static final String NOMBRE 	= "nombre";
	public static final String COSTO_DE_APRENDIZAJE   	= "costo_aprendizaje";
	public static final String TIPO     = "tipo";
	
	public static final String CLASE_ID= "claseId";
	public static final String NIVEL_ID= "nivelId";
	public static final String HAB_ACTIVA_ID= "hab_activa_id";
	
	// --------------------------------------------------------------------------------

	private int id;
	
	private String nombre;
	private int costo_de_aprendizaje;
	private int tipo;
	
	private List<IHabilidadClaseLinternaDO> habilidadClaseLinternaList = //
		new ArrayList<IHabilidadClaseLinternaDO>();
	
	private List<INivelHabilidadDO> nivelHabilidadList = //
		new ArrayList<INivelHabilidadDO>();

	private List<IHabilidadActivaDO> habilidadActivaList = //
		new ArrayList<IHabilidadActivaDO>();

	
	// --------------------------------------------------------------------------------

	public HabilidadDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	//@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// --------------------------------------------------------------------------------
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// --------------------------------------------------------------------------------
	
	public int getCosto_de_aprendizaje() {
		return costo_de_aprendizaje;
	}

	public void setCosto_de_aprendizaje(int costoDeAprendizaje) {
		costo_de_aprendizaje = costoDeAprendizaje;
	}


	// --------------------------------------------------------------------------------
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	// --------------------------------------------------------------------------------

	public void setHabilidadClaseLinternaList(List<IHabilidadClaseLinternaDO> habilidadClaseLinternaList) {
		this.habilidadClaseLinternaList = habilidadClaseLinternaList;
	}

	public List<IHabilidadClaseLinternaDO> getHabilidadClaseLinternaList() {
		return habilidadClaseLinternaList;
	}
	
	// --------------------------------------------------------------------------------
	
	public void setNivelHabilidadList(List<INivelHabilidadDO> nivelHabilidadList) {
		this.nivelHabilidadList = nivelHabilidadList;
	}

	public List<INivelHabilidadDO> getNivelHabilidadList() {
		return nivelHabilidadList;
	}

	// --------------------------------------------------------------------------------
	
	public void setHabilidadActivaList(List<IHabilidadActivaDO> habilidadActivaList) {
		this.habilidadActivaList = habilidadActivaList;
	}

	public List<IHabilidadActivaDO> getHabilidadActivaList() {
		return habilidadActivaList;
	}

	
}
