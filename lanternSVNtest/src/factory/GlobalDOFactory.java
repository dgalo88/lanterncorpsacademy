package factory;

import lcaInterfaceDAO.IUsuarioDO;
import dao.api.DataObject;

public class GlobalDOFactory {
	
	public enum Grupo {
		LCA, LANTERN
	}
	
	//----------------------------------------------------------------------
	
	private static final Grupo GRUPO = Grupo.LCA;
	
	//----------------------------------------------------------------------

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
	
	//----------------------------------------------------------------------

	private static DataObject createDOLCA(Class<? extends DataObject> clazz) {
		if (clazz.equals(IUsuarioDO.class)) {
			return new dao.lca.UsuarioDO();
		} else if (true) {
			// ....
		}

		throw new IllegalStateException();
	}
	
	//----------------------------------------------------------------------

	private static DataObject createDOLANTERN(Class<? extends DataObject> clazz) {
		if (clazz.equals(IUsuarioDO.class)) {
			return new dao.lca.UsuarioDO();
		} else if (true) {
			// ....
		}

		throw new IllegalStateException();
	}

}
