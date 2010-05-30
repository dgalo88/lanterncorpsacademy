package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

public interface IMisionClaseLinternaDAO extends InterfaceDAO{

	public abstract List<IMisionClaseLinternaDO> listByMisionId(int misionId)
			throws SQLException;

	public abstract List<IMisionClaseLinternaDO> listByClaseLinternaId(
			int claseLinternaId) throws SQLException;

	public abstract void loadMisionRef(IMisionClaseLinternaDO misionClaseDO)
			throws SQLException;

	public abstract void loadClaseLinternaRef(IMisionClaseLinternaDO misionClaseDO) throws SQLException;

}