package com.ulasoft.lanterncorpsacademy.logic;


public class Data {

	public static String getClase(int ref) {
		switch (ref) {
		case 1:
			return "Green Lantern Corps";
		case 2:
			return "Sinestro Corps";
		case 3:
			return "Red Lantern Corps";
		case 4:
			return "Black Lantern Corps";
		case 5:
			return "Blue Lantern Corps";
		case 6:
			return "Tribu Indigo";
		case 7:
			return "Star Sapphires";
		default:
			break;
		}
		return "";
	}

	public static String getPlanetaBase(int ref) {
		switch (ref) {
		case 1:
			return "Oa";
		case 2:
			return "Qward";
		case 3:
			return "Ysmault";
		case 4:
			return "Ryut";
		case 5:
			return "Odym";
		case 6:
			return "Aku";
		case 7:
			return "Zamaron";
		default:
			break;
		}
		return "";
	}

	public static String getTipo(Class<?> clase) {

		if (clase.toString().equals("class dao.lca.PersonajeDO")) {
			return "Jugador";
		} else {
			return "NPC";
		}

	}

	public static String getRecurso(int ref) {
		switch (ref) {
		case 1:
			return "Plomo";
		case 2:
			return "Hierro";
		case 3:
			return "Acero";
		case 4:
			return "Uranio";
		case 5:
			return "Titanio";
		case 6:
			return "Cristalo";
		case 7:
			return "Adamantium";
		case 8:
			return "Vibratium";
		default:
			break;
		}
		return "";
	}

	public static String panelMain(int i) {
		switch (i) {
		case 1:
			return "com/ulasoft/lanterncorpsacademy/imagenes/GreenLanternRebirthHC1.jpg";
		case 2:
			return "com/ulasoft/lanterncorpsacademy/imagenes/sinestro.png";
		case 3:
			return "com/ulasoft/lanterncorpsacademy/imagenes/redlanterns.jpg";
		case 4:
			return "com/ulasoft/lanterncorpsacademy/imagenes/black-lantern.jpg";
		default:
			break;
		}
		return "";
	}

}
