package factory;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IGrupoDO;
import lcaInterfaceDAO.IHabilidadActivaDO;
import lcaInterfaceDAO.IHabilidadClaseLinternaDO;
import lcaInterfaceDAO.IHabilidadDO;
import lcaInterfaceDAO.IMisionClaseLinternaDO;
import lcaInterfaceDAO.IMisionDO;
import lcaInterfaceDAO.IMisionPersonajeDO;
import lcaInterfaceDAO.INivelHabilidadDO;
import lcaInterfaceDAO.INpcDO;
import lcaInterfaceDAO.IObjetivoDO;
import lcaInterfaceDAO.IOrdenDO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IUsuarioDO;
import dao.api.DataObject;

public class GlobalDOFactory {

	public enum Grupo {
		LCA, LANTERN
	}

	// ----------------------------------------------------------------------

	private static final Grupo GRUPO = Grupo.LCA;

	// ----------------------------------------------------------------------

	public static DataObject getDO(Class<? extends DataObject> clazz)
			throws Exception {
		// clazz -> IXXXDO
		switch (GRUPO) {
		case LCA:
			return createDOLCA(clazz);
		case LANTERN:
			return createDOLANTERN(clazz);
		}

		throw new IllegalStateException();
	}

	// ----------------------------------------------------------------------

	private static DataObject createDOLCA(Class<? extends DataObject> clazz) {

		if (clazz.equals(IUsuarioDO.class)) {

			return new dao.lca.UsuarioDO();

		} else if (clazz.equals(IPlanetaDO.class)) {

			return new dao.lca.PlanetaDO();

		} else if (clazz.equals(IPersonajeDO.class)) {

			return new dao.lca.PersonajeDO();

		} else if (clazz.equals(IOrdenDO.class)) {

			return new dao.lca.OrdenDO();

		} else if (clazz.equals(IObjetivoDO.class)) {

			return new dao.lca.ObjetivoDO();

		} else if (clazz.equals(INpcDO.class)) {

			return new dao.lca.NpcDO();

		} else if (clazz.equals(INivelHabilidadDO.class)) {

			return new dao.lca.NivelHabilidadDO();

		} else if (clazz.equals(IMisionPersonajeDO.class)) {

			return new dao.lca.MisionPersonajeDO();

		} else if (clazz.equals(IMisionDO.class)) {

			return new dao.lca.MisionDO();

		} else if (clazz.equals(IMisionClaseLinternaDO.class)) {

			return new dao.lca.MisionClaseLinternaDO();

		} else if (clazz.equals(IHabilidadDO.class)) {

			return new dao.lca.HabilidadDO();

		} else if (clazz.equals(IHabilidadClaseLinternaDO.class)) {

			return new dao.lca.HabilidadClaseLinternaDO();

		} else if (clazz.equals(IHabilidadActivaDO.class)) {

			return new dao.lca.HabilidadActivaDO();

		} else if (clazz.equals(IGrupoDO.class)) {

			return new dao.lca.GrupoDO();

		} else if (clazz.equals(IClaseLinternaDO.class)) {

			return new dao.lca.ClaseLinternaDO();

		}

		throw new IllegalStateException();
	}

	// ----------------------------------------------------------------------

	private static DataObject createDOLANTERN(Class<? extends DataObject> clazz) {
		if (clazz.equals(IUsuarioDO.class)) {

			return new dao.lantern.UsuarioDO();

		} else if (clazz.equals(IPlanetaDO.class)) {

			return new dao.lantern.PlanetaDO();

		} else if (clazz.equals(IPersonajeDO.class)) {

			return new dao.lantern.PersonajeDO();

		} else if (clazz.equals(IOrdenDO.class)) {

			return new dao.lantern.OrdenDO();

		} else if (clazz.equals(IObjetivoDO.class)) {

			return new dao.lantern.ObjetivoDO();

		} else if (clazz.equals(INpcDO.class)) {

			return new dao.lantern.NpcDO();

		} else if (clazz.equals(INivelHabilidadDO.class)) {

			return new dao.lantern.NivelHabilidadDO();

		} else if (clazz.equals(IMisionPersonajeDO.class)) {

			return new dao.lantern.MisionPersonajeDO();

		} else if (clazz.equals(IMisionDO.class)) {

			return new dao.lantern.MisionDO();

		} else if (clazz.equals(IMisionClaseLinternaDO.class)) {

			return new dao.lantern.MisionClaseLinternaDO();

		} else if (clazz.equals(IHabilidadDO.class)) {

			return new dao.lantern.HabilidadDO();

		} else if (clazz.equals(IHabilidadClaseLinternaDO.class)) {

			return new dao.lantern.HabilidadClaseLinternaDO();

		} else if (clazz.equals(IHabilidadActivaDO.class)) {

			return new dao.lantern.HabilidadActivaDO();

		} else if (clazz.equals(IGrupoDO.class)) {

			return new dao.lantern.GrupoDO();

		} else if (clazz.equals(IClaseLinternaDO.class)) {

			return new dao.lantern.ClaseLinternaDO();

		}

		throw new IllegalStateException();
	}

}
