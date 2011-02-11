package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.DataObject;
import dao.api.InterfaceDAO;

public interface IRecursoOfertaVentaDAO extends InterfaceDAO {

	public abstract List<IRecursoOfertaVentaDO> listByOfertaId(int OfertaId)
			throws SQLException;

	public abstract List<IRecursoOfertaVentaDO> listByRecursoId(int RecursoId)
			throws SQLException;

	public abstract void loadOfertaRef(IRecursoOfertaVentaDO recursoDO)
			throws SQLException;

	public abstract void loadRecursoRef(
			IRecursoOfertaVentaDO recursoOfertaVentaDO) throws SQLException;

	DataObject loadByRecursoId(int recurso, int ofertaId) throws SQLException;

}