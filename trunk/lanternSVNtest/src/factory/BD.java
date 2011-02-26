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

	}

}
