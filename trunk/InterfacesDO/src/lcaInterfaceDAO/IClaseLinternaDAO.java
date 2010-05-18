package lcaInterfaceDAO;

import java.sql.SQLException;

import dao.api.InterfaceDAO;

public interface IClaseLinternaDAO extends InterfaceDAO{

	public abstract void loadMisionClaseLinternaList(
			IClaseLinternaDO claseLinternaDO) throws Exception;

	public abstract void loadHabilidadClaseLinternaList(
			IClaseLinternaDO claseLinternaDO) throws Exception;

	public abstract void loadGrupoList(IClaseLinternaDO claseLinternaDO)
			throws Exception;

	public abstract void loadPersonajeList(IClaseLinternaDO claseLinternaDO)
			throws Exception;

	public abstract void loadPlanetaRef(IClaseLinternaDO claseLinternaDO)
			throws SQLException;

	public abstract IClaseLinternaDO loadByName(String nombre)
			throws SQLException;

	public abstract IClaseLinternaDO loadByColor(String color)
			throws SQLException;

}