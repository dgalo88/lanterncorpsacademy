package com.ulasoft.lanterncorpsacademy.logic;

import lcaInterfaceDAO.IPersonajeDO;

public class Main {

	public static String loadImg(IPersonajeDO personaje) {
		switch (personaje.getClaseLinternaRef().getRefIdent()){
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

}
