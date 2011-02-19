package com.ulasoft.lanterncorpsacademy.logic;

import nextapp.echo.app.Color;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Font;
import nextapp.echo.app.Style;
import nextapp.echo.app.Font.Typeface;

import com.ulasoft.lanterncorpsacademy.stilos.BlackStyles;
import com.ulasoft.lanterncorpsacademy.stilos.BlueStyles;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;
import com.ulasoft.lanterncorpsacademy.stilos.GreenStyles;
import com.ulasoft.lanterncorpsacademy.stilos.IndigoStyles;
import com.ulasoft.lanterncorpsacademy.stilos.RedStyles;
import com.ulasoft.lanterncorpsacademy.stilos.VioletStyles;
import com.ulasoft.lanterncorpsacademy.stilos.YellowStyles;

public class Estilo {

	public static Color getColor(Atributos atrib) {

		if(atrib == null || atrib.getPersonaje() == null) {
			return GUIStyles.COLORDEFAULT;
		}

		switch (atrib.getPersonaje().getClaseLinternaRef().getRefIdent()) {
		case 1:
			return GUIStyles.COLORVERDE;
		case 2:
			return GUIStyles.COLORAMARILLO;
		case 3:
			return GUIStyles.COLORROJO;
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
		return GUIStyles.COLORDEFAULT;
	}

	public static Color getRolloverColor(Atributos atrib) {

		if(atrib == null || atrib.getPersonaje() == null) {
			return GUIStyles.ROLLOVERDEFAULT;
		}

		switch (atrib.getPersonaje().getClaseLinternaRef().getRefIdent()) {
		case 1:
			return GUIStyles.ROLLOVERVERDE;
		case 2:
			return GUIStyles.ROLLOVERAMARILLO;
		case 3:
			return GUIStyles.ROLLOVERROJO;
		case 4:
			return GUIStyles.ROLLOVERNEGRO;
		case 5:
			return GUIStyles.ROLLOVERAZUL;
		case 6:
			return GUIStyles.ROLLOVERINDIGO;
		case 7:
			return GUIStyles.ROLLOVERVIOLETA;
		default:
			break;
		}
		return GUIStyles.ROLLOVERDEFAULT;
	}

	public static Style getDefaultStyleColor (Atributos atrib) {

		if(atrib == null) {
			return GUIStyles.DEFAULT_STYLE_INITIAL;
		}

		switch (atrib.getPersonaje().getClaseLinternaRef().getRefIdent()) {
		case 1:
			return GreenStyles.DEFAULT_STYLE_GREEN;
		case 2:
			return YellowStyles.DEFAULT_STYLE_AMARILLO;
		case 3:
			return RedStyles.DEFAULT_STYLE_ROJO;
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
		return GUIStyles.DEFAULT_STYLE_INITIAL;
	}

	public static Style getStyleColor (Atributos atrib) {

		if(atrib == null) {
			return GUIStyles.STYLE_INITIAL;
		}

		switch (atrib.getPersonaje().getClaseLinternaRef().getRefIdent()) {
		case 1:
			return GreenStyles.STYLE_GREEN;
		case 2:
			return YellowStyles.STYLE_AMARILLO;
		case 3:
			return RedStyles.STYLE_ROJO;
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
		return GUIStyles.STYLE_INITIAL;
	}

	public static void setFont(Component component, int font) {

		int size = 14;
		Typeface typeface = Font.VERDANA;

		switch (font) {
		case 0:
			component.setFont(new Font(typeface, Font.PLAIN, new Extent(size)));
			break;
		case 1:
			component.setFont(new Font(typeface, Font.BOLD, new Extent(size)));
			break;
		case 2:
			component.setFont(new Font(typeface, Font.ITALIC, new Extent(size)));
			break;
		case 3:
			component.setFont(new Font(typeface, Font.UNDERLINE, new Extent(size)));
			break;
		case 4:
			component.setFont(new Font(typeface, Font.OVERLINE, new Extent(size)));
			break;
		default:
			break;
		}
	}

	public static void setFont(Component component, int font, int size) {

		Typeface typeface = Font.VERDANA;

		switch (font) {
		case 0:
			component.setFont(new Font(typeface, Font.PLAIN, new Extent(size)));
			break;
		case 1:
			component.setFont(new Font(typeface, Font.BOLD, new Extent(size)));
			break;
		case 2:
			component.setFont(new Font(typeface, Font.ITALIC, new Extent(size)));
			break;
		case 3:
			component.setFont(new Font(typeface, Font.UNDERLINE, new Extent(size)));
			break;
		case 4:
			component.setFont(new Font(typeface, Font.OVERLINE, new Extent(size)));
			break;
		default:
			break;
		}
	}

}
