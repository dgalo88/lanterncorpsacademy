package dao.lantern;

import dao.api.DataObject;

public class NpcDO implements DataObject {

	public static final String NOMBRE 	= "nombre";
	public static final String NIVEL 	= "nivel";
	public static final String SALUD 	= "salud";
	public static final String DANO 	= "dano";
	public static final String COLOR 	= "color";


	// --------------------------------------------------------------------------------

	private int id;

	private String nombre;
	private int nivel;
	private int salud;
	private int dano;
	private String color;


	// --------------------------------------------------------------------------------

	public NpcDO() {
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

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getNivel() {
		return nivel;
	}

	// --------------------------------------------------------------------------------
	
	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getSalud() {
		return salud;
	}

	// --------------------------------------------------------------------------------
	
	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getDano() {
		return dano;
	}

	// --------------------------------------------------------------------------------
	
	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

}
