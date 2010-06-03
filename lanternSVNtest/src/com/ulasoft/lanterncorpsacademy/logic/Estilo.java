package com.ulasoft.lanterncorpsacademy.logic;

import nextapp.echo.app.Color;
import nextapp.echo.app.Style;

import com.ulasoft.lanterncorpsacademy.stilos.BlackStyles;
import com.ulasoft.lanterncorpsacademy.stilos.BlueStyles;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;
import com.ulasoft.lanterncorpsacademy.stilos.GreenStyles;
import com.ulasoft.lanterncorpsacademy.stilos.IndigoStyles;
import com.ulasoft.lanterncorpsacademy.stilos.RedStyles;
import com.ulasoft.lanterncorpsacademy.stilos.VioletStyles;
import com.ulasoft.lanterncorpsacademy.stilos.YellowStyles;

public class Estilo {
	
	public static Color getColor(Atributos atrr) {
		if(atrr==null || atrr.getPersonaje()==null){
			return GUIStyles.COLORVERDE;
		}
		switch (atrr.getPersonaje().getClaseLinternaRef().getRefIdent()) {
		case 1:
			return GUIStyles.COLORVERDE;
		case 2:
			return GUIStyles.COLORAMARILLO;
		case 3:
			return GUIStyles.COLORROJOBAR;
		case 4:
			return GUIStyles.COLORNEGRO;
		case 5:
			return GUIStyles.COLORAZUL;
		case 6:
			return GUIStyles.COLORINDIGO;
		case 7:
			return GUIStyles.COLORVIOLETA;
		default:
			break;
		}
		return GUIStyles.COLORVERDE;
	}
	
	public static Style getDefaultStyleColor (Atributos atrr) {
		if(atrr==null){
			return GreenStyles.DEFAULT_STYLE_GREEN;
		}
		switch (atrr.getPersonaje().getClaseLinternaRef().getRefIdent()) {
		case 1:
			return GreenStyles.DEFAULT_STYLE_GREEN;
		case 2:
			return YellowStyles.DEFAULT_STYLE_AMARILLO;
		case 3:
			return RedStyles.DEFAULT_STYLE_ROJOBAR;
		case 4:
			return BlackStyles.DEFAULT_STYLE_BLACK;
		case 5:
			return BlueStyles.DEFAULT_STYLE_AZUL;
		case 6:
			return IndigoStyles.DEFAULT_STYLE_INDIGO;
		case 7:
			return VioletStyles.DEFAULT_STYLE_VIOLETA;
		default:
			break;
		}
		return GreenStyles.DEFAULT_STYLE_GREEN;
	}
	
	public static Style getStyleColor (Atributos atrr) {
		if(atrr==null){
			return GreenStyles.STYLE_GREEN;
		}
		switch (atrr.getPersonaje().getClaseLinternaRef().getRefIdent()) {
		case 1:
			return GreenStyles.STYLE_GREEN;
		case 2:
			return YellowStyles.STYLE_AMARILLO;
		case 3:
			return RedStyles.STYLE_ROJOBAR;
		case 4:
			return BlackStyles.STYLE_BLACK;
		case 5:
			return BlueStyles.STYLE_AZUL;
		case 6:
			return IndigoStyles.STYLE_INDIGO;
		case 7:
			return VioletStyles.STYLE_VIOLETA;
		default:
			break;
		}
		return GreenStyles.STYLE_GREEN;
	}
	
	public static Style getStyle2Color (Atributos atrr) {
		if(atrr==null){
			return GreenStyles.STYLE2_GREEN;
		}
		switch (atrr.getPersonaje().getClaseLinternaRef().getRefIdent()) {
		case 1:
			return GreenStyles.STYLE2_GREEN;
		case 2:
			return YellowStyles.STYLE2_AMARILLO;
		case 3:
			return RedStyles.STYLE2_ROJOBAR;
		case 4:
			return BlackStyles.STYLE2_BLACK;
		case 5:
			return BlueStyles.STYLE2_AZUL;
		case 6:
			return IndigoStyles.STYLE2_INDIGO;
		case 7:
			return VioletStyles.STYLE2_VIOLETA;
		default:
			break;
		}
		return GreenStyles.STYLE2_GREEN;
	}
	
}
