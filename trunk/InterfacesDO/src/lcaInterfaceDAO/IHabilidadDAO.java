package lcaInterfaceDAO;

import dao.api.InterfaceDAO;

public interface IHabilidadDAO extends InterfaceDAO{

	public abstract void loadHabilidadClaseLinternaList(IHabilidadDO habilidadDO)
			throws Exception;

	public abstract void loadNivelHabilidadList(IHabilidadDO habilidadDO)
			throws Exception;

	public abstract void loadHabilidadActivaList(IHabilidadDO habilidadDO)
			throws Exception;

}