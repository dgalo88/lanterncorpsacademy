package lcaInterfaceDAO;

import java.util.List;

import dao.api.DataObject;
import dao.api.InterfaceDAO;

public interface IUnidadBasicaDAO extends InterfaceDAO {
	
	public abstract void loadUnidadBasicaRecursoList(IUnidadBasicaDO unidadBasicaDO)
	throws Exception;

	public abstract void loadUnidadBasicaPersonajeList(IUnidadBasicaDO unidadBasicaDO)
	throws Exception;

	public abstract void loadTecnologiaRef(IUnidadBasicaDO unidadBasicaDO)
	throws Exception;


	public List<DataObject> listToBuy(int id) throws  Exception;
	
	  

}