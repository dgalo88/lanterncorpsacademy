package dao.lca;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IHabilidadActivaDO;
import lcaInterfaceDAO.IHabilidadClaseLinternaDO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.INivelHabilidadDO;


public class HabilidadDO implements IHabilidadDO {

	public static final String NOMBRE = "nombre";
	public static final String COSTO_DE_APRENDIZAJE = "costoDeAprendizaje";
	public static final String TIPO = "tipo";


	
	// --------------------------------------------------------------------------------

	private int id;
	private String nombre;
	private int costoDeAprendizaje;
	private int tipo;
	
	private List<IHabilidadClaseLinternaDO> habilidadClaseLinternaList = new ArrayList<IHabilidadClaseLinternaDO>();
	private List<INivelHabilidadDO> nivelHabilidadList = new ArrayList<INivelHabilidadDO>();
	private List<IHabilidadActivaDO> habilidadActivaList = new ArrayList<IHabilidadActivaDO>();
		// --------------------------------------------------------------------------------

	public HabilidadDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	@Override
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
		return costoDeAprendizaje;
	}

	public void setCosto_de_aprendizaje(int costoDeAprendizaje) {
		this.costoDeAprendizaje = costoDeAprendizaje;
	}

	// --------------------------------------------------------------------------------
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	// --------------------------------------------------------------------------------
	
	public List<IHabilidadClaseLinternaDO> getHabilidadClaseLinternaList() {
		return habilidadClaseLinternaList;
	}

	public void setHabilidadClaseLinternaList(List<IHabilidadClaseLinternaDO> habilidadClaseLinternaList) {
		this.habilidadClaseLinternaList = habilidadClaseLinternaList;
	}

	// --------------------------------------------------------------------------------

	public List<INivelHabilidadDO> getNivelHabilidadList() {
		return nivelHabilidadList;
	}

	public void setNivelHabilidadList(List<INivelHabilidadDO> nivelHabilidadList) {
		this.nivelHabilidadList = nivelHabilidadList;
	}

	// --------------------------------------------------------------------------------
	
	public void setHabilidadActivaList(List<IHabilidadActivaDO> habilidadActivaList) {
		this.habilidadActivaList = habilidadActivaList;
	}

	public List<IHabilidadActivaDO> getHabilidadActivaList() {
		return habilidadActivaList;
	}
	
}
