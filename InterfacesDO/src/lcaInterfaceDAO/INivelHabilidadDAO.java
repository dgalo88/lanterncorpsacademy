package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

public interface INivelHabilidadDAO extends InterfaceDAO{

	public abstract List<INivelHabilidadDO> listByHabilidadId(int HabilidadId)
			throws SQLException;

	public abstract void loadHabilidadRef(IHabilidadActivaDO habilidadActivaDO)
			throws SQLException;

}