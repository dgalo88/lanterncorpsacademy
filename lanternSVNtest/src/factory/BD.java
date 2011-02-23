package factory;

public class BD {

	public enum Grupo {
		LCA, LANTERN
	}

	// ----------------------------------------------------------------------

	public static final Grupo GRUPO = Grupo.LANTERN;

	// ----------------------------------------------------------------------

	public static String nombreBD() throws Exception {

		return "lantern";

//		switch (GRUPO) {
//		case LCA:
//			return "lca";
//		case LANTERN:
//			return "lantern";
//		}
//		throw new IllegalStateException();
	}

}
