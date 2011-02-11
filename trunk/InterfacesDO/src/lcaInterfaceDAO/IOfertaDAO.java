package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.DataObject;
import dao.api.InterfaceDAO;

@SuppressWarnings("unused")
public interface IOfertaDAO extends InterfaceDAO {

	public abstract void loadRecursoOfertaCompraList(IOfertaDO ofertaDO)
			throws Exception;

	public abstract void loadRecursoOfertaVentaList(IOfertaDO ofertaDO)
			throws Exception;

	public abstract void loadOfertaPersonajeList(IOfertaDO ofertaDO)
			throws Exception;

	public abstract void loadUnidadEjercitoOfertaList(IOfertaDO ofertaDO)
			throws Exception;

	public List<IOfertaDO> listPlayable(int id) throws Exception;

	IRecursoDO loadByNombre(String nombre) throws SQLException;

}
