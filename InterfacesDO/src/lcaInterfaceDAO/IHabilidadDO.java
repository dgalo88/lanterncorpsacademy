package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;

public interface IHabilidadDO extends DataObject{

	public abstract String getNombre();

	public abstract void setNombre(String nombre);

	public abstract int getCosto_de_aprendizaje();

	public abstract void setCosto_de_aprendizaje(int costoDeAprendizaje);

	public abstract int getTipo();

	public abstract void setTipo(int tipo);

	public abstract List<IHabilidadClaseLinternaDO> getHabilidadClaseLinternaList();

	public abstract void setHabilidadClaseLinternaList(
			List<IHabilidadClaseLinternaDO> habilidadClaseLinternaList);

	public abstract List<INivelHabilidadDO> getNivelHabilidadList();

	public abstract void setNivelHabilidadList(
			List<INivelHabilidadDO> nivelHabilidadList);

	public abstract void setHabilidadActivaList(
			List<IHabilidadActivaDO> habilidadActivaList);

	public abstract List<IHabilidadActivaDO> getHabilidadActivaList();

}