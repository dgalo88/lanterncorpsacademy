package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

public interface IOfertaPersonajeDAO extends InterfaceDAO {

	public abstract List<IOfertaPersonajeDO> listByOfertaId(int OfertaId)
			throws SQLException;

	public abstract List<IOfertaPersonajeDO> listByPersonajeId(int claseId)
			throws SQLException;

}