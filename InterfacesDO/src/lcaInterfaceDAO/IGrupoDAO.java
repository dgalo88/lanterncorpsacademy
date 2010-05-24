package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

public interface IGrupoDAO extends InterfaceDAO{

	public abstract List<IGrupoDO> listByClaseLinternaId(int claseLinternaId)
			throws SQLException;

	public abstract void loadPersonajeList(IGrupoDO grupoDO) throws Exception;

	public abstract void loadClaseLinternaRef(IGrupoDO grupoDO)
			throws SQLException;

}