package lcaInterfaceDAO;

import dao.api.InterfaceDAO;

public interface IMisionDAO extends InterfaceDAO{

	public abstract void loadOrdenList(IMisionDO misionDO) throws Exception;

	public abstract void loadMisionPersonajeList(IMisionDO misionDO)
			throws Exception;

}