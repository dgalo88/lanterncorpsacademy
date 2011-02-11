package com.ulasoft.lanterncorpsacademy.stilos;

import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.MutableStyle;
import nextapp.echo.app.Style;

public class BlackStyles {

	public static final Style DEFAULT_STYLE_BLACK;
	static {
		MutableStyle style = (MutableStyle) GUIStyles.DEFAULT_STYLE;

		style.set(Button.PROPERTY_FOCUSED_BACKGROUND, GUIStyles.COLORNEGRO);
		style.set(Button.PROPERTY_FOCUSED_BORDER, new Border(1, GUIStyles.BORDENEGRO, Border.STYLE_SOLID));

		DEFAULT_STYLE_BLACK = style;
	}

	public static final Style STYLE_BLACK;
	static {
		MutableStyle style = (MutableStyle) GUIStyles.STYLE;

		style.set(Button.PROPERTY_FOCUSED_BACKGROUND, GUIStyles.COLORNEGRO);
		style.set(Button.PROPERTY_FOCUSED_BORDER, new Border(1, GUIStyles.BORDENEGRO, Border.STYLE_SOLID));
		style.set(Button.PROPERTY_FOCUSED_FONT, Color.WHITE);

		style.set(Button.PROPERTY_ROLLOVER_BACKGROUND, GUIStyles.ROLLOVERNEGRO);
		style.set(Button.PROPERTY_ROLLOVER_BORDER, new Border(1, Color.BLACK, Border.STYLE_SOLID));
		style.set(Button.PROPERTY_ROLLOVER_FONT, Color.WHITE);

		STYLE_BLACK = style;
	}
}
