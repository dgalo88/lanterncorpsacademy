package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.DataObject;
import dao.api.InterfaceDAO;

public interface IHabilidadDAO extends InterfaceDAO{

	public abstract void loadHabilidadClaseLinternaList(IHabilidadDO habilidadDO)
			throws Exception;

	public abstract void loadNivelHabilidadList(IHabilidadDO habilidadDO)
			throws Exception;

	public abstract void loadHabilidadActivaList(IHabilidadDO habilidadDO)
			throws Exception;
	
	public abstract List<DataObject> listHabIniciales(int claseid)
			throws Exception;

	IHabilidadDO loadByNombre(String nombre) throws SQLException;
	
	public List<DataObject> listToBuy(int id) throws  Exception;

}