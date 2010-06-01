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
			return "com/ulasoft/lanterncorpsacademy/imagenes/startsaphirre.jpg";
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
}
