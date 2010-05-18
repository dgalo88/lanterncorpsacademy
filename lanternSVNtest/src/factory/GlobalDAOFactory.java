package factory;

import lcaInterfaceDAO.IClaseLinternaDAO;
import lcaInterfaceDAO.IGrupoDAO;
import lcaInterfaceDAO.IHabilidadActivaDAO;
import lcaInterfaceDAO.IHabilidadClaseLinternaDAO;
import lcaInterfaceDAO.IHabilidadDAO;
import lcaInterfaceDAO.IMisionClaseLinternaDAO;
import lcaInterfaceDAO.IMisionDAO;
import lcaInterfaceDAO.IMisionPersonajeDAO;
import lcaInterfaceDAO.INivelHabilidadDAO;
import lcaInterfaceDAO.INpcDAO;
import lcaInterfaceDAO.IObjetivoDAO;
import lcaInterfaceDAO.IOrdenDAO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPlanetaDAO;
import lcaInterfaceDAO.IUsuarioDAO;
import dao.api.FactoryDAO;
import dao.api.InterfaceDAO;
import dao.connection.ConnectionBean;

public class GlobalDAOFactory {

	public enum Grupo {
		LCA, LANTERN
	}

	// ----------------------------------------------------------------------

	private static final Grupo GRUPO = Grupo.LCA;

	// ----------------------------------------------------------------------

	public static InterfaceDAO getDAO(Class<? extends InterfaceDAO> clazz,
			ConnectionBean connectionBean) throws Exception {
		// clazz -> IXXXDAO

		switch (GRUPO) {
		case LCA:
			return createDAOLCA(clazz, connectionBean);
		case LANTERN:
			return createDAOLANTERN(clazz, connectionBean);
		}

		throw new IllegalStateException();
	}

	// ----------------------------------------------------------------------

	private static InterfaceDAO createDAOLCA(
			Class<? extends InterfaceDAO> clazz, ConnectionBean connectionBean)
			throws Exception {

		if (clazz.equals(IUsuarioDAO.class)) {

			return FactoryDAO.getDAO(dao.lca.UsuarioDAO.class, connectionBean);

		} else if (clazz.equals(IPlanetaDAO.class)) {

			return FactoryDAO.getDAO(dao.lca.PlanetaDAO.class, connectionBean);

		} else if (clazz.equals(IPersonajeDAO.class)) {

			return FactoryDAO
					.getDAO(dao.lca.PersonajeDAO.class, connectionBean);

		} else if (clazz.equals(IOrdenDAO.class)) {

			return FactoryDAO.getDAO(dao.lca.OrdenDAO.class, connectionBean);

		} else if (clazz.equals(IObjetivoDAO.class)) {

			return FactoryDAO.getDAO(dao.lca.ObjetivoDAO.class, connectionBean);

		} else if (clazz.equals(INpcDAO.class)) {

			return FactoryDAO.getDAO(dao.lca.NpcDAO.class, connectionBean);

		} else if (clazz.equals(INivelHabilidadDAO.class)) {

			return FactoryDAO.getDAO(dao.lca.NivelHabilidadDAO.class,
					connectionBean);

		} else if (clazz.equals(IMisionPersonajeDAO.class)) {

			return FactoryDAO.getDAO(dao.lca.MisionPersonajeDAO.class,
					connectionBean);

		} else if (clazz.equals(IMisionDAO.class)) {

			return FactoryDAO.getDAO(dao.lca.MisionDAO.class, connectionBean);

		} else if (clazz.equals(IMisionClaseLinternaDAO.class)) {

			return FactoryDAO.getDAO(dao.lca.MisionClaseLinternaDAO.class,
					connectionBean);

		} else if (clazz.equals(IHabilidadDAO.class)) {

			return FactoryDAO
					.getDAO(dao.lca.HabilidadDAO.class, connectionBean);

		} else if (clazz.equals(IHabilidadClaseLinternaDAO.class)) {

			return FactoryDAO.getDAO(dao.lca.HabilidadClaseLinternaDAO.class,
					connectionBean);

		} else if (clazz.equals(IHabilidadActivaDAO.class)) {

			return FactoryDAO.getDAO(dao.lca.HabilidadActivaDAO.class,
					connectionBean);

		} else if (clazz.equals(IGrupoDAO.class)) {

			return FactoryDAO.getDAO(dao.lca.GrupoDAO.class, connectionBean);

		} else if (clazz.equals(IClaseLinternaDAO.class)) {

			return FactoryDAO.getDAO(dao.lca.ClaseLinternaDAO.class,
					connectionBean);

		}

		throw new IllegalStateException();
	}

	// ----------------------------------------------------------------------

	private static InterfaceDAO createDAOLANTERN(
			Class<? extends InterfaceDAO> clazz, ConnectionBean connectionBean)
			throws Exception {

		if (clazz.equals(IUsuarioDAO.class)) {

			return FactoryDAO.getDAO(dao.lantern.UsuarioDAO.class,
					connectionBean);

		} else if (clazz.equals(IPlanetaDAO.class)) {

			return FactoryDAO.getDAO(dao.lantern.PlanetaDAO.class,
					connectionBean);

		} else if (clazz.equals(IPersonajeDAO.class)) {

			return FactoryDAO.getDAO(dao.lantern.PersonajeDAO.class,
					connectionBean);

		} else if (clazz.equals(IOrdenDAO.class)) {

			return FactoryDAO
					.getDAO(dao.lantern.OrdenDAO.class, connectionBean);

		} else if (clazz.equals(IObjetivoDAO.class)) {

			return FactoryDAO.getDAO(dao.lantern.ObjetivoDAO.class,
					connectionBean);

		} else if (clazz.equals(INpcDAO.class)) {

			return FactoryDAO.getDAO(dao.lantern.NpcDAO.class, connectionBean);

		} else if (clazz.equals(INivelHabilidadDAO.class)) {

			return FactoryDAO.getDAO(dao.lantern.NivelHabilidadDAO.class,
					connectionBean);

		} else if (clazz.equals(IMisionPersonajeDAO.class)) {

			return FactoryDAO.getDAO(dao.lantern.MisionPersonajeDAO.class,
					connectionBean);

		} else if (clazz.equals(IMisionDAO.class)) {

			return FactoryDAO.getDAO(dao.lantern.MisionDAO.class,
					connectionBean);

		} else if (clazz.equals(IMisionClaseLinternaDAO.class)) {

			return FactoryDAO.getDAO(dao.lantern.MisionClaseLinternaDAO.class,
					connectionBean);

		} else if (clazz.equals(IHabilidadDAO.class)) {

			return FactoryDAO.getDAO(dao.lantern.HabilidadDAO.class,
					connectionBean);

		} else if (clazz.equals(IHabilidadClaseLinternaDAO.class)) {

			return FactoryDAO
					.getDAO(dao.lantern.HabilidadClaseLinternaDAO.class,
							connectionBean);

		} else if (clazz.equals(IHabilidadActivaDAO.class)) {

			return FactoryDAO.getDAO(dao.lantern.HabilidadActivaDAO.class,
					connectionBean);

		} else if (clazz.equals(IGrupoDAO.class)) {

			return FactoryDAO
					.getDAO(dao.lantern.GrupoDAO.class, connectionBean);

		} else if (clazz.equals(IClaseLinternaDAO.class)) {

			return FactoryDAO.getDAO(dao.lantern.ClaseLinternaDAO.class,
					connectionBean);

		}

		throw new IllegalStateException();
	}

}
