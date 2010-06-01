package lcaInterfaceDAO;

import java.util.List;

import dao.api.InterfaceDAO;

public interface IMisionDAO extends InterfaceDAO{

	public abstract void loadOrdenList(IMisionDO misionDO) throws Exception;

	public abstract void loadMisionPersonajeList(IMisionDO misionDO)
			throws Exception;

	public List<IMisionDO> listPlayable(int id) throws Exception;
	
}