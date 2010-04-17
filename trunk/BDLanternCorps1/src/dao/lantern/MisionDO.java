package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;

public class MisionDO implements DataObject {

	public static final String NOMBRE 							= "nombre";
	public static final String DESCRIPCION 						= "descripcion";
	public static final String EXPERIENCIA_GANADA 				= "experiencia_ganada";
	public static final String PUNTOS_DE_ENTRENAMIENTO_GANADOS 	= "puntos_de_entrenamiento_ganados";
	public static final String NIVEL_NECESARIO 					= "nivel_necesario";
	
	public static final String ORDEN_ID 						= "ordenId";
	public static final String MISION_PERSONAJE_ID 				= "misionPersonajeId";
	
	// --------------------------------------------------------------------------------

	private int id;

	private String nombre;
	private String descripcion;
	private int experiencia_ganada;
	private int puntos_de_entrenamiento_ganados;
	private int nivel_necesario;


	private List<OrdenDO> OrdenList = //
		new ArrayList<OrdenDO>();
	
	private List<MisionPersonajeDO> MisionPersonajeList = //
		new ArrayList<MisionPersonajeDO>();
		
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
	
	public int getExperienciaGanada() {
		return experiencia_ganada;
	}

	public void setExperienciaGanada(int experienciaGanada) {
		experiencia_ganada = experienciaGanada;
	}

	// --------------------------------------------------------------------------------
	
	public int getPuntosDeEntrenamientoGanados() {
		return puntos_de_entrenamiento_ganados;
	}

	public void setPuntosDeEntrenamientoGanados(int puntosDeEntrenamientoGanados) {
		puntos_de_entrenamiento_ganados = puntosDeEntrenamientoGanados;
	}
	
	// --------------------------------------------------------------------------------
	
	public int getNivelNecesario() {
		return nivel_necesario;
	}

	public void setNivelNecesario(int nivelNecesario) {
		nivel_necesario = nivelNecesario;
	}

	// --------------------------------------------------------------------------------

	public void setOrdenList(List<OrdenDO> ordenList) {
		OrdenList = ordenList;
	}

	public List<OrdenDO> getOrdenList() {
		return OrdenList;
	}

	// --------------------------------------------------------------------------------

	public void setMisionPersonajeList(List<MisionPersonajeDO> misionPersonajeList) {
		MisionPersonajeList = misionPersonajeList;
	}

	public List<MisionPersonajeDO> getMisionPersonajeList() {
		return MisionPersonajeList;
	}

}
