package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

public interface IHabilidadClaseLinternaDAO extends InterfaceDAO{

	public abstract List<IHabilidadClaseLinternaDO> listByHabilidadId(
			int HabilidadId) throws SQLException;

	public abstract List<IHabilidadClaseLinternaDO> listByClaseId(int claseId)
			throws SQLException;

}