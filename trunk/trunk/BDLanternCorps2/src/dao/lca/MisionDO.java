package dao.lca;

import java.util.ArrayList;
import java.util.List;
import dao.api.DataObject;


public class MisionDO implements DataObject {

	public static final String NOMBRE = "nombre";
	public static final String DESCRIPCION = "descripcion";
	public static final String EXPERIENCIA_GANADA = "experienciaGanada";
	public static final String PUNTOS_DE_ENTRENAMIENTO_GANADOS = "puntosDeEntrenamientoGanados";
	public static final String NIVEL_NECESARIO = "nivelNecesario";
	
	// --------------------------------------------------------------------------------

	private int id;
	private String nombre;
	private String descripcion;
	private int experienciaGanada;
	private int puntosDeEntrenamientoGanados;
	private int nivelNecesario;

	private List<OrdenDO> ordenList = new ArrayList<OrdenDO>();
	private List<MisionPersonajeDO> misionPersonajeList = new ArrayList<MisionPersonajeDO>();
		
	// --------------------------------------------------------------------------------

	public MisionDO() {
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
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// --------------------------------------------------------------------------------
	
	public int getExperiencia_ganada() {
		return experienciaGanada;
	}

	public void setExperiencia_ganada(int experienciaGanada) {
		this.experienciaGanada = experienciaGanada;
	}

	// --------------------------------------------------------------------------------
	
	public int getPuntos_de_entrenamiento_ganados() {
		return puntosDeEntrenamientoGanados;
	}

	public void setPuntos_de_entrenamiento_ganados(int puntosDeEntrenamientoGanados) {
		this.puntosDeEntrenamientoGanados = puntosDeEntrenamientoGanados;
	}
	
	// --------------------------------------------------------------------------------
	
	public int getNivel_necesario() {
		return nivelNecesario;
	}

	public void setNivel_necesario(int nivelNecesario) {
		this.nivelNecesario = nivelNecesario;
	}
	
	// --------------------------------------------------------------------------------
	
	public void setOrdenList(List<OrdenDO> ordenList) {
		this.ordenList = ordenList;
	}

	public List<OrdenDO> getOrdenList() {
		return ordenList;
	}

	// --------------------------------------------------------------------------------
	
	public void setMisionPersonajeList(List<MisionPersonajeDO> misionPersonajeList) {
		this.misionPersonajeList = misionPersonajeList;
	}

	public List<MisionPersonajeDO> getMisionPersonajeList() {
		return misionPersonajeList;
	}

}
