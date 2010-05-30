package lcaInterfaceDAO;

import java.sql.SQLException;
import java.util.List;

import dao.api.InterfaceDAO;

public interface IHabilidadActivaDAO extends InterfaceDAO {

	public abstract List<IHabilidadActivaDO> listByHabilidadId(int HabilidadId)
			throws SQLException;

	public abstract List<IHabilidadActivaDO> listByPersonajeId(int PersonajeId)
			throws SQLException;

	public abstract void loadPersonajeRef(IHabilidadActivaDO habilidadDO)
			throws SQLException;

	public abstract void loadHabilidadRef(IHabilidadActivaDO habilidadActivaDO)
			throws SQLException;

}