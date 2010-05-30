package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IHabilidadClaseLinternaDO extends DataObject{

	public abstract Reference<IHabilidadDO> getHabilidadRef();

	public abstract void setHabilidadRef(Reference<IHabilidadDO> habilidadRef);

	public abstract Reference<IClaseLinternaDO> getClaseLinternaRef();

	public abstract void setClaseLinternaRef(
			Reference<IClaseLinternaDO> claseLinternaRef);

}