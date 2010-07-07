package lcaInterfaceDAO;

import dao.api.DataObject;
import dao.api.Reference;

public interface IMisionClaseLinternaDO extends DataObject{

	public abstract Reference<IMisionDO> getMisionRef();

	public abstract void setMisionRef(Reference<IMisionDO> misionRef);

	public abstract Reference<IClaseLinternaDO> getClaseLinternaRef();

	public abstract void setClaseLinternaRef(
			Reference<IClaseLinternaDO> claseLinternaRef);

}