package com.ulasoft.lanterncorpsacademy;

public class DatosClases {

	public static String clase(int ref) {
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

	public static String planetaCasa(int ref) {
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
	
}
