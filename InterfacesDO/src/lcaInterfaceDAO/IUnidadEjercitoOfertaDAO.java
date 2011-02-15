package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

public interface IUnidadEjercitoOfertaDAO extends InterfaceDAO {

	public abstract List<IUnidadEjercitoOfertaDO> listByOfertaId(int OfertaId)
			throws SQLException;

	public abstract List<IUnidadEjercitoOfertaDO> listByUnidadEjercitoId(
			int UnidadEjercitoId) throws SQLException;

}
