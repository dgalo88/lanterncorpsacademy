package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface INivelHabilidadDO extends DataObject{

	public abstract int getNivel_de_habilidad();

	public abstract void setNivel_de_habilidad(int nivelDeHabilidad);

	public abstract float getEfectividad();

	public abstract void setEfectividad(int efectividad);

	public abstract float getCosto_de_energia();

	public abstract void setCosto_de_energia(float costoDeEnergia);

	public abstract int getProbabilidad();

	public abstract void setProbabilidad(int probabilidad);

	public abstract Reference<IHabilidadDO> getHabilidadRef();

	public abstract void setHabilidadRef(Reference<IHabilidadDO> habilidadRef);

}