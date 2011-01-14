package com.ulasoft.lanterncorpsacademy.logic;

import lcaInterfaceDAO.IPersonajeDO;

public class ImgLoad {

	public static String panelMain(IPersonajeDO personaje) {
		switch (personaje.getClaseLinternaRef().getRefIdent()) {
		case 1:
			return "com/ulasoft/lanterncorpsacademy/imagenes/GreenLanternRebirthHC1.jpg";
		case 2:
			return "com/ulasoft/lanterncorpsacademy/imagenes/sinestro.png";
		case 3:
			return "com/ulasoft/lanterncorpsacademy/imagenes/redlanterns.jpg";
		case 4:
			return "com/ulasoft/lanterncorpsacademy/imagenes/black-lantern.jpg";
		case 5:
			return "com/ulasoft/lanterncorpsacademy/imagenes/bluelantern.jpg";
		case 6:
			return "com/ulasoft/lanterncorpsacademy/imagenes/tribuindigo.jpg";
		case 7:
			return "com/ulasoft/lanterncorpsacademy/imagenes/stars.jpg";
		default:
			break;
		}
		return "";
	}

	public static String menuHead(IPersonajeDO personaje) {
		switch (personaje.getClaseLinternaRef().getRefIdent()) {
		case 1:
			return "com/ulasoft/lanterncorpsacademy/imagenes/linterna_green.png";
		case 2:
			return "com/ulasoft/lanterncorpsacademy/imagenes/lantern_sinestro.png";
		case 3:
			return "com/ulasoft/lanterncorpsacademy/imagenes/lantern_red.png";
		case 4:
			return "com/ulasoft/lanterncorpsacademy/imagenes/linterna_negra.png";
		case 5:
			return "com/ulasoft/lanterncorpsacademy/imagenes/lantern_blue.png";
		case 6:
			return "com/ulasoft/lanterncorpsacademy/imagenes/lantern_indigo.png";
		case 7:
			return "com/ulasoft/lanterncorpsacademy/imagenes/lantern_star.png";
		default:
			break;
		}
		return "";
	}
	
	public static String panelRecarga(IPersonajeDO personaje) {
		switch (personaje.getClaseLinternaRef().getRefIdent()) {
		case 1:
			return "com/ulasoft/lanterncorpsacademy/imagenes/jim-lee-green-lantern.jpg";
		case 2:
			return "com/ulasoft/lanterncorpsacademy/imagenes/sinestro_recarga.png";
		case 3:
			return "com/ulasoft/lanterncorpsacademy/imagenes/red_recarga.jpg";
		case 4:
			return "com/ulasoft/lanterncorpsacademy/imagenes/black_recarga.jpg";
		case 5:
			return "com/ulasoft/lanterncorpsacademy/imagenes/blue_recarga.jpg";
		case 6:
			return "com/ulasoft/lanterncorpsacademy/imagenes/indigo_recarga.jpg";
		case 7:
			return "com/ulasoft/lanterncorpsacademy/imagenes/startsaphirre.jpg";
		default:
			break;
		}
		return "";
	}

	public static String fondo(IPersonajeDO personaje) {
		switch (personaje.getClaseLinternaRef().getRefIdent()) {
		case 1:
			return "com/ulasoft/lanterncorpsacademy/imagenes/fondoLCAVerde.jpg";
		case 2:
			return "com/ulasoft/lanterncorpsacademy/imagenes/fondoLCAAmarillo.jpg";
		case 3:
			return "com/ulasoft/lanterncorpsacademy/imagenes/fondoLCARojo.jpg";
		case 4:
			return "com/ulasoft/lanterncorpsacademy/imagenes/fondoLCANegro.jpg";
		case 5:
			return "com/ulasoft/lanterncorpsacademy/imagenes/fondoLCAAzul.jpg";
		case 6:
			return "com/ulasoft/lanterncorpsacademy/imagenes/fondoLCAIndigo.jpg";
		case 7:
			return "com/ulasoft/lanterncorpsacademy/imagenes/fondoLCARosado.jpg";
		default:
			break;
		}
		return "";
	}

}
