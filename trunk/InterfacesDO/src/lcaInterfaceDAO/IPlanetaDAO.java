package lcaInterfaceDAO;

import dao.api.InterfaceDAO;

public interface IPlanetaDAO extends InterfaceDAO {

	public abstract void loadPersonajeList(IPlanetaDO planetaDO)
			throws Exception;

}