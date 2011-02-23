package factory;

import lcaInterfaceDAO.IAndroideDO;
import lcaInterfaceDAO.IAndroidePersonajeDO;
import lcaInterfaceDAO.IAndroideRecursoDO;
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
import lcaInterfaceDAO.IRecursoDO;
import lcaInterfaceDAO.IRecursoOfertaCompraDO;
import lcaInterfaceDAO.IRecursoOfertaVentaDO;
import lcaInterfaceDAO.IRecursoPersonajeDO;
import lcaInterfaceDAO.IRecursoPlanetaDO;
import lcaInterfaceDAO.ITecnologiaDO;
import lcaInterfaceDAO.ITecnologiaPersonajeDO;
import lcaInterfaceDAO.ITecnologiaRecursoDO;
import lcaInterfaceDAO.IUnidadBasicaDO;
import lcaInterfaceDAO.IUnidadBasicaPersonajeDO;
import lcaInterfaceDAO.IUnidadBasicaRecursoDO;
import lcaInterfaceDAO.IUnidadEjercitoDO;
import lcaInterfaceDAO.IUnidadEjercitoOfertaDO;
import lcaInterfaceDAO.IUnidadEjercitoPersonajeDO;
import lcaInterfaceDAO.IUsuarioDO;
import dao.api.DataObject;
import factory.BD.Grupo;

public class GlobalDOFactory {

	private static Grupo grupo = BD.GRUPO;

	// ----------------------------------------------------------------------

	public static DataObject getDO(Class<? extends DataObject> clazz)
			throws Exception {
		// clazz -> IXXXDO
//		switch (grupo) {
//		case LCA:
//			return createDOLCA(clazz);
//		case LANTERN:
//			return createDOLANTERN(clazz);
//		}
		return createDOLANTERN(clazz);
//		throw new IllegalStateException();
	}

	// ----------------------------------------------------------------------

//	private static DataObject createDOLCA(Class<? extends DataObject> clazz) {
//
//		if (clazz.equals(IAndroideDO.class)) {
//
//			return new dao.lantern.AndroideDO();
//
//		} else if (clazz.equals(IAndroidePersonajeDO.class)) {
//
//			return new dao.lantern.AndroidePersonajeDO();
//
//		} else if (clazz.equals(IAndroideRecursoDO.class)) {
//
//			return new dao.lantern.AndroideRecursoDO();
//
//		} else if (clazz.equals(IClaseLinternaDO.class)) {
//
//			return new dao.lca.ClaseLinternaDO();
//
//		} else if (clazz.equals(IGrupoDO.class)) {
//
//			return new dao.lca.GrupoDO();
//
//		} else if (clazz.equals(IHabilidadActivaDO.class)) {
//
//			return new dao.lca.HabilidadActivaDO();
//
//		} else if (clazz.equals(IHabilidadClaseLinternaDO.class)) {
//
//			return new dao.lca.HabilidadClaseLinternaDO();
//
//		} else if (clazz.equals(IHabilidadDO.class)) {
//
//			return new dao.lca.HabilidadDO();
//
//		} else if (clazz.equals(IMisionClaseLinternaDO.class)) {
//
//			return new dao.lca.MisionClaseLinternaDO();
//
//		} else if (clazz.equals(IMisionDO.class)) {
//
//			return new dao.lca.MisionDO();
//
//		} else if (clazz.equals(IMisionPersonajeDO.class)) {
//
//			return new dao.lca.MisionPersonajeDO();
//
//		} else if (clazz.equals(INivelHabilidadDO.class)) {
//
//			return new dao.lca.NivelHabilidadDO();
//
//		} else if (clazz.equals(INpcDO.class)) {
//
//			return new dao.lca.NpcDO();
//
//		} else if (clazz.equals(IObjetivoDO.class)) {
//
//			return new dao.lca.ObjetivoDO();
//
//		} else if (clazz.equals(IOrdenDO.class)) {
//
//			return new dao.lca.OrdenDO();
//
//		} else if (clazz.equals(IPersonajeDO.class)) {
//
//			return new dao.lca.PersonajeDO();
//
//		} else if (clazz.equals(IPlanetaDO.class)) {
//
//			return new dao.lca.PlanetaDO();
//
//		} else if (clazz.equals(IRecursoDO.class)) {
//
//			return new dao.lantern.RecursoDO();
//
//		} else if (clazz.equals(IRecursoOfertaCompraDO.class)) {
//
//			return new dao.lantern.RecursoOfertaCompraDO();
//
//		} else if (clazz.equals(IRecursoOfertaVentaDO.class)) {
//
//			return new dao.lantern.RecursoOfertaVentaDO();
//
//		} else if (clazz.equals(IRecursoPersonajeDO.class)) {
//
//			return new dao.lantern.RecursoPersonajeDO();
//
//		} else if (clazz.equals(IRecursoPlanetaDO.class)) {
//
//			return new dao.lantern.RecursoPlanetaDO();
//
//		} else if (clazz.equals(ITecnologiaDO.class)) {
//
//			return new dao.lantern.TecnologiaDO();
//
//		} else if (clazz.equals(ITecnologiaPersonajeDO.class)) {
//
//			return new dao.lantern.TecnologiaPersonajeDO();
//
//		} else if (clazz.equals(ITecnologiaRecursoDO.class)) {
//
//			return new dao.lantern.TecnologiaRecursoDO();
//
//		} else if (clazz.equals(IUnidadBasicaDO.class)) {
//
//			return new dao.lantern.UnidadBasicaDO();
//
//		} else if (clazz.equals(IUnidadBasicaPersonajeDO.class)) {
//
//			return new dao.lantern.UnidadBasicaPersonajeDO();
//
//		} else if (clazz.equals(IUnidadBasicaRecursoDO.class)) {
//
//			return new dao.lantern.UnidadBasicaRecursoDO();
//
//		} else if (clazz.equals(IUnidadEjercitoDO.class)) {
//
//			return new dao.lantern.UnidadEjercitoDO();
//
//		} else if (clazz.equals(IUnidadEjercitoOfertaDO.class)) {
//
//			return new dao.lantern.UnidadEjercitoOfertaDO();
//
//		} else if (clazz.equals(IUnidadEjercitoPersonajeDO.class)) {
//
//			return new dao.lantern.UnidadEjercitoPersonajeDO();
//
//		} else if (clazz.equals(IUsuarioDO.class)) {
//
//			return new dao.lca.UsuarioDO();
//
//		}
//
//		throw new IllegalStateException();
//	}

	// ----------------------------------------------------------------------

	private static DataObject createDOLANTERN(Class<? extends DataObject> clazz) {

		if (clazz.equals(IAndroideDO.class)) {

			return new dao.lantern.AndroideDO();

		} else if (clazz.equals(IAndroidePersonajeDO.class)) {

			return new dao.lantern.AndroidePersonajeDO();

		} else if (clazz.equals(IAndroideRecursoDO.class)) {

			return new dao.lantern.AndroideRecursoDO();

		} else if (clazz.equals(IClaseLinternaDO.class)) {

			return new dao.lantern.ClaseLinternaDO();

		} else if (clazz.equals(IGrupoDO.class)) {

			return new dao.lantern.GrupoDO();

		} else if (clazz.equals(IHabilidadActivaDO.class)) {

			return new dao.lantern.HabilidadActivaDO();

		} else if (clazz.equals(IHabilidadClaseLinternaDO.class)) {

			return new dao.lantern.HabilidadClaseLinternaDO();

		} else if (clazz.equals(IHabilidadDO.class)) {

			return new dao.lantern.HabilidadDO();

		} else if (clazz.equals(IMisionClaseLinternaDO.class)) {

			return new dao.lantern.MisionClaseLinternaDO();

		} else if (clazz.equals(IMisionDO.class)) {

			return new dao.lantern.MisionDO();

		} else if (clazz.equals(IMisionPersonajeDO.class)) {

			return new dao.lantern.MisionPersonajeDO();

		} else if (clazz.equals(INivelHabilidadDO.class)) {

			return new dao.lantern.NivelHabilidadDO();

		} else if (clazz.equals(INpcDO.class)) {

			return new dao.lantern.NpcDO();

		} else if (clazz.equals(IObjetivoDO.class)) {

			return new dao.lantern.ObjetivoDO();

		} else if (clazz.equals(IOrdenDO.class)) {

			return new dao.lantern.OrdenDO();

		} else if (clazz.equals(IPersonajeDO.class)) {

			return new dao.lantern.PersonajeDO();

		} else if (clazz.equals(IPlanetaDO.class)) {

			return new dao.lantern.PlanetaDO();

		} else if (clazz.equals(IRecursoDO.class)) {

			return new dao.lantern.RecursoDO();

		} else if (clazz.equals(IRecursoOfertaCompraDO.class)) {

			return new dao.lantern.RecursoOfertaCompraDO();

		} else if (clazz.equals(IRecursoOfertaVentaDO.class)) {

			return new dao.lantern.RecursoOfertaVentaDO();

		} else if (clazz.equals(IRecursoPersonajeDO.class)) {

			return new dao.lantern.RecursoPersonajeDO();

		} else if (clazz.equals(IRecursoPlanetaDO.class)) {

			return new dao.lantern.RecursoPlanetaDO();

		} else if (clazz.equals(ITecnologiaDO.class)) {

			return new dao.lantern.TecnologiaDO();

		} else if (clazz.equals(ITecnologiaPersonajeDO.class)) {

			return new dao.lantern.TecnologiaPersonajeDO();

		} else if (clazz.equals(ITecnologiaRecursoDO.class)) {

			return new dao.lantern.TecnologiaRecursoDO();

		} else if (clazz.equals(IUnidadBasicaDO.class)) {

			return new dao.lantern.UnidadBasicaDO();

		} else if (clazz.equals(IUnidadBasicaPersonajeDO.class)) {

			return new dao.lantern.UnidadBasicaPersonajeDO();

		} else if (clazz.equals(IUnidadBasicaRecursoDO.class)) {

			return new dao.lantern.UnidadBasicaRecursoDO();

		} else if (clazz.equals(IUnidadEjercitoDO.class)) {

			return new dao.lantern.UnidadEjercitoDO();

		} else if (clazz.equals(IUnidadEjercitoOfertaDO.class)) {

			return new dao.lantern.UnidadEjercitoOfertaDO();

		} else if (clazz.equals(IUnidadEjercitoPersonajeDO.class)) {

			return new dao.lantern.UnidadEjercitoPersonajeDO();

		} else if (clazz.equals(IUsuarioDO.class)) {

			return new dao.lantern.UsuarioDO();

		}

		throw new IllegalStateException();
	}

}
