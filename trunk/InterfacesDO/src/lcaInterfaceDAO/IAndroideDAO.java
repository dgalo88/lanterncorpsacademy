package lcaInterfaceDAO;


import java.sql.SQLException;
import lcaInterfaceDAO.IAndroideDO;
import java.util.List;
import dao.api.InterfaceDAO;

public interface IAndroideDAO extends InterfaceDAO{

	public abstract void loadTecnologiaRef(
			IAndroideDO androideDO) throws Exception;

	public abstract void loadAndroidePersonajeList(
			IAndroideDO androideDO) throws Exception;

	public abstract void loadAndroideRecursoList(IAndroideDO androideDO)
			throws Exception;
	
	//----------------------------------------------------------------------------
	
	public boolean checkIfTipoExists(String tipo) throws SQLException;
	
	//-----------------------------------------------------------------------------
	
	public List<IAndroideDO> listAndroides() throws SQLException;
	
	
	public IAndroideDO loadByTipo () throws SQLException;
	

}
