package com.ulasoft.lanterncorpsacademy.stilos;

import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.MutableStyle;
import nextapp.echo.app.Style;

public class IndigoStyles {
	
	  public static final Style DEFAULT_STYLE_INDIGO;
	  static {
		  MutableStyle style = (MutableStyle) GUIStyles.DEFAULT_STYLE;
		  style.set(Button.PROPERTY_FOCUSED_BACKGROUND, GUIStyles.COLORINDIGO);
		  style.set(Button.PROPERTY_FOCUSED_BORDER, new Border(1, Color.MAGENTA, Border.STYLE_SOLID));

		  DEFAULT_STYLE_INDIGO = style;
	  }
	  
	  public static final Style STYLE_INDIGO;

	  static {
		  MutableStyle style = (MutableStyle) GUIStyles.STYLE;
		  style.set(Button.PROPERTY_ROLLOVER_BACKGROUND, GUIStyles.COLORINDIGO);
		  style.set(Button.PROPERTY_ROLLOVER_BORDER, new Border(1, Color.MAGENTA, Border.STYLE_SOLID));
		  
		  STYLE_INDIGO = style;
	  }
	  
	  public static final Style STYLE2_INDIGO;

	  static {
		  
		  MutableStyle style = (MutableStyle) GUIStyles.STYLE2;
		  style.set(Button.PROPERTY_FOCUSED_BACKGROUND, GUIStyles.COLORINDIGO);
		  style.set(Button.PROPERTY_FOCUSED_BORDER, new Border(1, Color.MAGENTA, Border.STYLE_SOLID));
		  
		  STYLE2_INDIGO = style;
	  }
}
