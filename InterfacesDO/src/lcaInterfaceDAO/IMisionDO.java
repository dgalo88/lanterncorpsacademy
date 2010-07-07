package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;

public interface IMisionDO extends DataObject{

	public abstract String getNombre();

	public abstract void setNombre(String nombre);

	public abstract String getDescripcion();

	public abstract void setDescripcion(String descripcion);

	public abstract int getExperiencia_ganada();

	public abstract void setExperiencia_ganada(int experienciaGanada);

	public abstract int getPuntos_de_entrenamiento_ganados();

	public abstract void setPuntos_de_entrenamiento_ganados(
			int puntosDeEntrenamientoGanados);

	public abstract int getNivel_necesario();

	public abstract void setNivel_necesario(int nivelNecesario);

	public abstract void setOrdenList(List<IOrdenDO> ordenList);

	public abstract List<IOrdenDO> getOrdenList();

	public abstract void setMisionPersonajeList(
			List<IMisionPersonajeDO> misionPersonajeList);

	public abstract List<IMisionPersonajeDO> getMisionPersonajeList();

}