

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IMisionDO;
import lcaInterfaceDAO.IMisionPersonajeDO;
import lcaInterfaceDAO.IOrdenDO;


public class MisionDO implements IMisionDO {


	// --------------------------------------------------------------------------------

	private int id;
	private String nombre;
	private String descripcion;
	private int experienciaGanada;
	private int puntosDeEntrenamientoGanados;
	private int nivelNecesario;

	private List<IOrdenDO> ordenList = new ArrayList<IOrdenDO>();
	private List<IMisionPersonajeDO> misionPersonajeList = new ArrayList<IMisionPersonajeDO>();
		
	// --------------------------------------------------------------------------------

	public MisionDO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

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
	
	public void setOrdenList(List<IOrdenDO> ordenList) {
		this.ordenList = ordenList;
	}

	public List<IOrdenDO> getOrdenList() {
		return ordenList;
	}

	// --------------------------------------------------------------------------------
	
	public void setMisionPersonajeList(List<IMisionPersonajeDO> misionPersonajeList) {
		this.misionPersonajeList = misionPersonajeList;
	}

	public List<IMisionPersonajeDO> getMisionPersonajeList() {
		return misionPersonajeList;
	}

}
