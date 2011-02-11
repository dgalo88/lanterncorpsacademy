package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.DataObject;
import dao.api.InterfaceDAO;

public interface IRecursoOfertaCompraDAO extends InterfaceDAO {

	public abstract List<IRecursoOfertaCompraDO> listByOfertaId(int OfertaId)
			throws SQLException;

	public abstract List<IRecursoOfertaCompraDO> listByRecursoId(int RecursoId)
			throws SQLException;

	public abstract void loadOfertaRef(IRecursoOfertaCompraDO recursoDO)
			throws SQLException;

	public abstract void loadRecursoRef(
			IRecursoOfertaCompraDO recursoOfertaCompraDO) throws SQLException;

	DataObject loadByRecursoId(int recurso, int ofertaId) throws SQLException;

}