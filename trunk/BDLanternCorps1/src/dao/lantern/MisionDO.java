package dao.lantern;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IMisionClaseLinternaDO;
import lcaInterfaceDAO.IMisionDO;
import lcaInterfaceDAO.IMisionPersonajeDO;
import lcaInterfaceDAO.IOrdenDO;

public class MisionDO implements IMisionDO {

	public static final String NOMBRE 							= "nombre";
	public static final String DESCRIPCION 						= "descripcion";
	public static final String EXPERIENCIA_GANADA 				= "experiencia_ganada";
	public static final String PUNTOS_DE_ENTRENAMIENTO_GANADOS 	= "puntos_de_entrenamiento_ganados";
	public static final String NIVEL_NECESARIO 					= "nivel_necesario";
	
	// --------------------------------------------------------------------------------

	private int id;

	private String nombre;
	private String descripcion;
	private int experiencia_ganada;
	private int puntos_de_entrenamiento_ganados;
	private int nivel_necesario;

	private List<IOrdenDO> OrdenList = //
		new ArrayList<IOrdenDO>();
	
	private List<IMisionPersonajeDO> MisionPersonajeList = //
		new ArrayList<IMisionPersonajeDO>();
		
	private List<IMisionClaseLinternaDO> MisionClaselinternaList = //
		new ArrayList<IMisionClaseLinternaDO>();
	
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
		return experiencia_ganada;
	}

	public void setExperiencia_ganada(int experienciaGanada) {
		experiencia_ganada = experienciaGanada;
	}

	// --------------------------------------------------------------------------------
	
	public int getPuntos_de_entrenamiento_ganados() {
		return puntos_de_entrenamiento_ganados;
	}

	public void setPuntos_de_entrenamiento_ganados(int puntosDeEntrenamientoGanados) {
		puntos_de_entrenamiento_ganados = puntosDeEntrenamientoGanados;
	}
	
	// --------------------------------------------------------------------------------
	
	public int getNivel_necesario() {
		return nivel_necesario;
	}

	public void setNivel_necesario(int nivelNecesario) {
		nivel_necesario = nivelNecesario;
	}

	// --------------------------------------------------------------------------------

	public void setOrdenList(List<IOrdenDO> ordenList) {
		OrdenList = ordenList;
	}

	public List<IOrdenDO> getOrdenList() {
		return OrdenList;
	}

	// --------------------------------------------------------------------------------

	public void setMisionPersonajeList(List<IMisionPersonajeDO> misionPersonajeList) {
		MisionPersonajeList = misionPersonajeList;
	}

	public List<IMisionPersonajeDO> getMisionPersonajeList() {
		return MisionPersonajeList;
	}

	// --------------------------------------------------------------------------------

	public void setMisionClaselinternaList(List<IMisionClaseLinternaDO> misionClaselinternaList) {
		MisionClaselinternaList = misionClaselinternaList;
	}

	public List<IMisionClaseLinternaDO> getMisionClaselinternaList() {
		return MisionClaselinternaList;
	}

}
