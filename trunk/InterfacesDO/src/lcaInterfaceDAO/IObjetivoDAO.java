package lcaInterfaceDAO;

import java.sql.SQLException;

import dao.api.InterfaceDAO;

public interface IObjetivoDAO extends InterfaceDAO{

	public abstract void loadPlanetaRef(IObjetivoDO objetivoDO)
			throws SQLException;
	
	public void loadOrdenList(IObjetivoDO objetivoDO) throws Exception;

}