package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

public interface IMisionPersonajeDAO extends InterfaceDAO{

	public abstract List<IMisionPersonajeDO> listByIdMisionId(int misionId)
			throws SQLException;

	public abstract List<IMisionPersonajeDO> listByIdPersonajeId(int personajeId)
			throws SQLException;

	public abstract void loadPersonajeRef(IMisionPersonajeDO misionpersonajeDO)
			throws SQLException;

	public abstract void loadMisionRef(IMisionPersonajeDO misionpersonajeDO)
			throws SQLException;

}