package lcaInterfaceDAO;

import java.util.List;

import dao.api.InterfaceDAO;

public interface INpcDAO extends InterfaceDAO{
	public List<INpcDO> listNpc(int id) throws ClassNotFoundException, Exception;

}