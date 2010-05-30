package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public interface IClaseLinternaDO extends DataObject{

	public abstract String getColor();

	public abstract void setColor(String color);

	public abstract String getNombre_de_cuerpo_linterna();

	public abstract void setNombre_de_cuerpo_linterna(
			String nombreDeCuerpoLinterna);

	public abstract List<IPersonajeDO> getPersonajeList();

	public abstract void setPersonajeList(List<IPersonajeDO> personajeList);

	public abstract List<IGrupoDO> getGrupoList();

	public abstract void setGrupoList(List<IGrupoDO> grupoList);

	public abstract List<IHabilidadClaseLinternaDO> getHabilidadClaseLinternaList();

	public abstract void setHabilidadClaseLinternaList(
			List<IHabilidadClaseLinternaDO> habilidadClaseLinternaList);

	public abstract List<IMisionClaseLinternaDO> getMisionClaseLinternaList();

	public abstract void setMisionClaseLinternaList(
			List<IMisionClaseLinternaDO> misionClaseLinternaList);

	public abstract Reference<IPlanetaDO> getPlanetaRef();

	public abstract void setPlanetaRef(Reference<IPlanetaDO> planetaRef);

}