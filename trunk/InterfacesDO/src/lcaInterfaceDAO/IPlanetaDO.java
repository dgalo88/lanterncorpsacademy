package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public interface IPlanetaDO extends DataObject {

	public abstract String getNombre();

	public abstract void setNombre(String nombre);

	public abstract String getSector();

	public abstract void setSector(String sector);

	public abstract float getCoordenadaEnX();

	public abstract void setCoordenadaEnX(float coordenadaEnX);

	public abstract float getCoordenadaEnY();

	public abstract void setCoordenadaEnY(float coordenadaEnY);

	public abstract List<IPersonajeDO> getPersonajeList();

	public abstract void setPersonajeList(List<IPersonajeDO> personajeList);

	public abstract List<IObjetivoDO> getObjetivoList();

	public abstract void setObjetivoList(List<IObjetivoDO> objetivoList);

	public abstract List<IRecursoPlanetaDO> getRecursoPlanetaList();

	public abstract void setRecursoPlanetaList(List<IRecursoPlanetaDO> recursoPlanetaList);
	
	public abstract Reference<IPersonajeDO> getPlanetaEsCasaRef();
	
	public abstract void setPlanetaEsCasaRef(Reference<IPersonajeDO> planetaEsCasaRef);

}