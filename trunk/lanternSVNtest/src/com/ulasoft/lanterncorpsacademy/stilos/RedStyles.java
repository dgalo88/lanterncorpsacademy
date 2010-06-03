package com.ulasoft.lanterncorpsacademy.stilos;

import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.MutableStyle;
import nextapp.echo.app.Style;

public class RedStyles {

	  public static final Style DEFAULT_STYLE_ROJOBAR;
	  static {
		  MutableStyle style = (MutableStyle) GUIStyles.DEFAULT_STYLE;
		  style.set(Button.PROPERTY_FOCUSED_BACKGROUND, GUIStyles.COLORROJOBAR);
		  style.set(Button.PROPERTY_FOCUSED_BORDER, new Border(1, Color.RED, Border.STYLE_SOLID));

		  DEFAULT_STYLE_ROJOBAR = style;
	  }
	  
	  public static final Style STYLE_ROJOBAR;

	  static {
		  MutableStyle style = (MutableStyle) GUIStyles.STYLE;
		  style.set(Button.PROPERTY_ROLLOVER_BACKGROUND, GUIStyles.COLORROJOBAR);
		  style.set(Button.PROPERTY_ROLLOVER_BORDER, new Border(1, Color.RED, Border.STYLE_SOLID));
		  
		  STYLE_ROJOBAR = style;
	  }
	  
	  public static final Style STYLE2_ROJOBAR;

	  static {
		  
		  MutableStyle style = (MutableStyle) GUIStyles.STYLE2;
		  style.set(Button.PROPERTY_FOCUSED_BACKGROUND, GUIStyles.COLORROJOBAR);
		  style.set(Button.PROPERTY_FOCUSED_BORDER, new Border(1, Color.RED, Border.STYLE_SOLID));
		  
		  STYLE2_ROJOBAR = style;
	  }
}
