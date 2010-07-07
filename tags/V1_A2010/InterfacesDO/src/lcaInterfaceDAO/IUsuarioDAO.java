package lcaInterfaceDAO;

import java.sql.SQLException;

import dao.api.InterfaceDAO;

public interface IUsuarioDAO extends InterfaceDAO {

	// --------------------------------------------------------------------------------

	public void loadPersonajeRef(IUsuarioDO usuarioDO) throws SQLException;

	// --------------------------------------------------------------------------------

	public IPersonajeDO login(IUsuarioDO usuarioDO) throws SQLException;

	// --------------------------------------------------------------------------------

	public boolean checkIfUsuarioExists(String correo) throws SQLException;

	public IUsuarioDO loadByCorreo(String mail) throws SQLException;

}
