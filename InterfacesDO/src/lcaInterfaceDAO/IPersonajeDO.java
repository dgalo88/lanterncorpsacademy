package lcaInterfaceDAO;

import java.sql.Date;
import java.util.List;

import dao.api.DataObject;
import dao.api.Reference;

public interface IPersonajeDO extends DataObject {
	
	// --------------------------------------------------------------------------------

	public String getAlias();

	public void setAlias(String alias);

	// --------------------------------------------------------------------------------

	public int getExperiencia();

	public void setExperiencia(int experiencia);
	// --------------------------------------------------------------------------------

	public int getPuntosDeEntrenamiento();

	public void setPuntosDeEntrenamiento(int puntosDeEntrenamiento);
	
	// --------------------------------------------------------------------------------

	public int getSalud();

	public void setSalud(int salud);

	// --------------------------------------------------------------------------------

	public int getEnergiaDelAnillo();

	public void setEnergiaDelAnillo(int energiaDelAnillo);
	// --------------------------------------------------------------------------------

	public int getNivel();

	public void setNivel(int nivel);

	// --------------------------------------------------------------------------------
	
	public Date getUltimaFechaIngreso();

	public void setUltimaFechaIngreso(Date ultimaFechaIngreso);

	
	//-----------------------------------------------------------------------------------------
	
	public abstract List<IEjercitoPersonajeDO> getEjercitoPersonajeList();
	
	public abstract void setEjercitoPersonajeList(List<IEjercitoPersonajeDO> ejercitoPersonaList);
	// --------------------------------------------------------------------------------

	public Reference<IPlanetaDO> getPlanetaRef();

	public void setPlanetaRef(Reference<IPlanetaDO> planetaRef);

	//---------------------------------------------------------------------------------------
	public List<IRecursoPersonajeDO> getRecursoPersonajeList();

	public void setRecursoPersonajeList(List<IRecursoPersonajeDO> recursoPersonajeList);
	// --------------------------------------------------------------------------------
	
	public abstract List<ITecnologiaPersonajeDO> getTecnologiaPersonajeList();
	
	public abstract void setTecnologiaPersonajeList(List<ITecnologiaPersonajeDO> tecnologiaPersonajeList);
	//-----------------------------------------------------------------------------------------

	public List<IHabilidadActivaDO> getHabilidadActivaList();

	public void setHabilidadActivaList(List<IHabilidadActivaDO> habilidadActivaList);
	
	// --------------------------------------------------------------------------------

	public List<IMisionPersonajeDO> getMisionPersonajeList();
	
	public void setMisionPersonajelist(List<IMisionPersonajeDO> misionPersonajeList);
	
	//---------------------------------------------------------------------------------------

	public Reference<IGrupoDO> getGrupoRef();

	public void setGrupoRef(Reference<IGrupoDO> grupoRef);

	// --------------------------------------------------------------------------------

	public Reference<IClaseLinternaDO> getClaseLinternaRef();
	
	public void setClaseLinternaRef(Reference<IClaseLinternaDO> claseLinternaRef);

}
