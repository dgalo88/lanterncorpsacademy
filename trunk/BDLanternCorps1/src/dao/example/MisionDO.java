package dao.example;

import java.util.ArrayList;
import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public class MisionDO implements DataObject {

	public static final String NOMBRE = "nombre";
	public static final String DESCRIPCION = "descripcion";
	
	// --------------------------------------------------------------------------------

	private int id;

	private String nombre;
	private String descripcion;
	private int experiencia_ganada;
	private int puntos_de_entrenamiento_ganados;
	private int nivel_necesario;

	private Reference<OrdenDO> ordenRef = new Reference<OrdenDO>();
	private Reference<MisionPersonajeDO> misionPersonajeRef = new Reference<MisionPersonajeDO>();
		
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

	public Reference<OrdenDO> getOrdenRef() {
		return ordenRef;
	}

	public void setOrdenRef(Reference<OrdenDO> ordenRef) {
		this.ordenRef = ordenRef;
	}

	// --------------------------------------------------------------------------------

	public Reference<MisionPersonajeDO> getMisionPersonajeRef() {
		return  misionPersonajeRef;
	}

	public void setMisionPersonajeRef(Reference<MisionPersonajeDO> misionPersonajeRef) {
		this.misionPersonajeRef = misionPersonajeRef;
	}

}
