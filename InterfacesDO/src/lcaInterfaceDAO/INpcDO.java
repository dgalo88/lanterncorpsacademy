package lcaInterfaceDAO;

import dao.api.DataObject;

public interface INpcDO extends DataObject{

	public abstract int getId();

	public abstract String getNombre();

	public abstract void setNombre(String nombre);

	public abstract void setNivel(int nivel);

	public abstract int getNivel();

	public abstract void setSalud(int salud);

	public abstract int getSalud();

	public abstract void setDano(int dano);

	public abstract int getDano();

	public abstract void setColor(String color);

	public abstract String getColor();

}