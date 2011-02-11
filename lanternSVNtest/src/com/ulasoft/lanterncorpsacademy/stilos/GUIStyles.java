package com.ulasoft.lanterncorpsacademy.stilos;

import java.awt.Font;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.MutableStyle;
import nextapp.echo.app.Row;
import nextapp.echo.app.Style;

public class GUIStyles {

	public static final Color COLORDEFAULT = new Color(100, 110, 105);
	public static final Color COLORVERDE = new Color(75, 185, 75);
	public static final Color COLORAMARILLO = new Color(225, 225, 115);
	public static final Color COLORROJO = new Color (205, 65, 65);
	public static final Color COLORNEGRO = new Color(175, 185, 195);
	public static final Color COLORAZUL = new Color(75, 135, 185);
	public static final Color COLORINDIGO = new Color(115, 115, 205);
	public static final Color COLORVIOLETA = new Color(225, 100, 235);

	public static final Color BORDEDEFAULT = new Color(95, 95, 95);
	public static final Color BORDEVERDE = new Color(75, 135, 75);
	public static final Color BORDEAMARILLO = new Color(225, 225, 65);
	public static final Color BORDEROJO = new Color (205, 30, 30);
	public static final Color BORDENEGRO = new Color(125, 125, 125);
	public static final Color BORDEAZUL = new Color(30, 95, 145);
	public static final Color BORDEINDIGO = new Color(95, 95, 150);
	public static final Color BORDEVIOLETA = new Color(160, 75, 170);

	public static final Color ROLLOVERDEFAULT = new Color(135, 135, 140);
	public static final Color ROLLOVERVERDE = new Color(115, 200, 115);
	public static final Color ROLLOVERAMARILLO = new Color(245, 255, 105);
	public static final Color ROLLOVERROJO = new Color (245, 105, 105);
	public static final Color ROLLOVERNEGRO = new Color(200, 200, 205);
	public static final Color ROLLOVERAZUL = new Color(140, 175, 205);
	public static final Color ROLLOVERINDIGO = new Color(160, 160, 205);
	public static final Color ROLLOVERVIOLETA = new Color(230, 160, 235);

	public static final Style DEFAULT_STYLE;
	static {
		MutableStyle style = new MutableStyle();

		style.set(Grid.PROPERTY_WIDTH, new Extent(500));
		style.set(Row.PROPERTY_ALIGNMENT, new Alignment(Alignment.CENTER, Alignment.CENTER));

		style.set(Button.PROPERTY_HEIGHT, new Extent(20));
		style.set(Button.PROPERTY_WIDTH, new Extent(190));
		style.set(Button.PROPERTY_INSETS, new Insets(2,2,2,2));
		style.set(Button.PROPERTY_ALIGNMENT, new Alignment(Alignment.CENTER, Alignment.CENTER));

		style.set(Button.PROPERTY_LINE_WRAP, false);
		style.set(Button.PROPERTY_BACKGROUND, new Color(245, 245, 235));
		style.set(Button.PROPERTY_BORDER, new Border(1, new Color(215, 210, 205), Border.STYLE_SOLID));
		style.set(Button.PROPERTY_FONT, Font.DIALOG);

		style.set(Button.PROPERTY_TEXT_ALIGNMENT, new Alignment(Alignment.CENTER, Alignment.CENTER));
		style.set(Button.PROPERTY_TEXT_POSITION, new Alignment(Alignment.CENTER, Alignment.CENTER));
		style.set(Button.PROPERTY_ICON_TEXT_MARGIN, new Extent(3));

		style.set(Button.PROPERTY_DISABLED_FOREGROUND, Color.LIGHTGRAY);

		//Aquí hay que cambiar el color para cada clase
		style.set(Button.PROPERTY_FOCUSED_ENABLED,true);
		style.set(Button.PROPERTY_FOCUSED_BACKGROUND, COLORDEFAULT);
		style.set(Button.PROPERTY_FOCUSED_BORDER, new Border(1, BORDEDEFAULT, Border.STYLE_SOLID));

		DEFAULT_STYLE = style;
	}

	public static final Style STYLE;
	static {
		MutableStyle style = new MutableStyle();

		style.set(Button.PROPERTY_HEIGHT, new Extent(20));
		style.set(Button.PROPERTY_WIDTH, new Extent(190));
		style.set(Button.PROPERTY_INSETS, new Insets(3));
		style.set(Button.PROPERTY_ALIGNMENT, new Alignment(Alignment.CENTER, Alignment.CENTER));

		style.set(Button.PROPERTY_LINE_WRAP, false);
		style.set(Button.PROPERTY_BACKGROUND, new Color(245, 245, 235));
		style.set(Button.PROPERTY_BORDER, new Border(1, new Color(215, 210, 205), Border.STYLE_SOLID));

		style.set(Button.PROPERTY_TEXT_ALIGNMENT, new Alignment(Alignment.CENTER, Alignment.CENTER));
		style.set(Button.PROPERTY_TEXT_POSITION, new Alignment(Alignment.CENTER, Alignment.CENTER));
		style.set(Button.PROPERTY_ICON_TEXT_MARGIN, new Extent(3));

		style.set(Button.PROPERTY_DISABLED_FOREGROUND, Color.LIGHTGRAY);

		//Aquí hay que cambiar el color para cada clase
		style.set(Button.PROPERTY_FOCUSED_ENABLED,true);
		style.set(Button.PROPERTY_FOCUSED_BACKGROUND, COLORDEFAULT);
		style.set(Button.PROPERTY_FOCUSED_BORDER, new Border(1, BORDEDEFAULT, Border.STYLE_SOLID));

		//Aquí hay que cambiar el color para cada clase
		style.set(Button.PROPERTY_ROLLOVER_ENABLED, true);
		style.set(Button.PROPERTY_ROLLOVER_BACKGROUND, ROLLOVERDEFAULT);
		style.set(Button.PROPERTY_ROLLOVER_BORDER, new Border(1, Color.BLACK, Border.STYLE_SOLID));

		STYLE = style;
	}

	public static final Style STYLECENTERROW;
	static {
		MutableStyle style = new MutableStyle();

		style.set(Row.PROPERTY_ALIGNMENT, new Alignment(Alignment.CENTER, Alignment.CENTER));
		style.set(Row.PROPERTY_FONT, new Alignment(Alignment.CENTER, Alignment.CENTER));
		style.set(Column.PROPERTY_CELL_SPACING, new Extent(1));
		style.set(Column.PROPERTY_INSETS, new Insets(2,2,2,2));

		STYLECENTERROW = style;
	}

	public static final Style STYLEMENUI;
	static {
		MutableStyle style = new MutableStyle();

		style.set(Row.PROPERTY_ALIGNMENT, new Alignment(Alignment.LEFT, Alignment.DEFAULT));
		style.set(Column.PROPERTY_CELL_SPACING, new Extent(1));
		style.set(Column.PROPERTY_INSETS, new Insets(2,2,2,2));

		STYLEMENUI = style;
	}

	public static final Style STYLEBUTTON;
	static {
		MutableStyle style = new MutableStyle();

		style.set(Row.PROPERTY_ALIGNMENT, new Alignment(Alignment.RIGHT, Alignment.DEFAULT));
		style.set(Column.PROPERTY_CELL_SPACING, new Extent(1));
		style.set(Column.PROPERTY_INSETS, new Insets(2,2,2,2));

		STYLEBUTTON = style;
	}

}
