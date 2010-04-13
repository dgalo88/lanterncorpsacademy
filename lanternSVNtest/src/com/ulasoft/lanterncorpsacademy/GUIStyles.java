package com.ulasoft.lanterncorpsacademy;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.IntData;

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

	public static final Style DEFAULT_STYLE;

	  static {
	    MutableStyle style = new MutableStyle();
	    style.set(Grid.PROPERTY_WIDTH, new Extent(500));
	    style.set(Button.PROPERTY_LINE_WRAP, false);

	    style.set(Button.PROPERTY_BACKGROUND, new Color(0xF2, 0xF2, 0xED));
	    style.set(Button.PROPERTY_BORDER, new Border(1, new Color(0xD6, 0xD3, 0xCE), Border.STYLE_SOLID));

	    style.set(Button.PROPERTY_ROLLOVER_ENABLED, true);
	    style.set(Button.PROPERTY_ROLLOVER_BACKGROUND, new Color(0x32, 0xCD, 0x32));
	    style.set(Button.PROPERTY_ROLLOVER_BORDER, new Border(1, Color.GREEN, Border.STYLE_SOLID));

	    style.set(Button.PROPERTY_INSETS, new Insets(2,2,2,2));	    
	    style.set(Button.PROPERTY_ALIGNMENT, new Alignment(Alignment.CENTER, Alignment.CENTER));
	    style.set(Button.PROPERTY_HEIGHT, new Extent(40));
	    style.set(Button.PROPERTY_WIDTH, new Extent(200));
	    style.set(Button.PROPERTY_TEXT_ALIGNMENT, new Alignment(Alignment.CENTER, Alignment.CENTER));
	    style.set(Button.PROPERTY_ICON_TEXT_MARGIN, new Extent(3));
	    //style.set(Button.PROPERTY_MOUSE_CURSOR, CURSOR_POINTER);

	    style.set(Button.PROPERTY_DISABLED_FOREGROUND, Color.LIGHTGRAY);
	    style.set(Button.PROPERTY_TEXT_POSITION, new Alignment(Alignment.CENTER, Alignment.CENTER));

	    DEFAULT_STYLE = style;
	  }
	  
	  public static final Style STYLE;

	  static {
	    MutableStyle style = new MutableStyle();

	    style.set(Button.PROPERTY_LINE_WRAP, false);

	    style.set(Button.PROPERTY_BACKGROUND, new Color(0xF2, 0xF2, 0xED));
	    style.set(Button.PROPERTY_BORDER, new Border(1, new Color(0xD6, 0xD3, 0xCE), Border.STYLE_SOLID));

	    style.set(Button.PROPERTY_ROLLOVER_ENABLED, true);
	    style.set(Button.PROPERTY_ROLLOVER_BACKGROUND, new Color(0x32, 0xCD, 0x32));
	    style.set(Button.PROPERTY_ROLLOVER_BORDER, new Border(1, Color.GREEN, Border.STYLE_SOLID));

	    style.set(Button.PROPERTY_INSETS, new Insets(3));
	    //style.set(Button.PROPERTY_OUTSETS, new Insets(1));
	    
	    style.set(Button.PROPERTY_ALIGNMENT, new Alignment(Alignment.CENTER, Alignment.CENTER));
	    style.set(Button.PROPERTY_TEXT_ALIGNMENT, new Alignment(Alignment.CENTER, Alignment.CENTER));
	    style.set(Button.PROPERTY_ICON_TEXT_MARGIN, new Extent(3));
	    //style.set(Button.PROPERTY_MOUSE_CURSOR, CURSOR_POINTER);
	    

	    style.set(Button.PROPERTY_DISABLED_FOREGROUND, Color.LIGHTGRAY);
	    style.set(Button.PROPERTY_TEXT_POSITION, new Alignment(Alignment.CENTER, Alignment.CENTER));


	    STYLE = style;
	  }
	  public static final Style STYLE2;

	  static {
		  MutableStyle style = new MutableStyle();

		    style.set(Button.PROPERTY_LINE_WRAP, false);

		    style.set(Button.PROPERTY_BACKGROUND, new Color(0xF2, 0xF2, 0xED));
		    style.set(Button.PROPERTY_BORDER, new Border(1, new Color(0xD6, 0xD3, 0xCE), Border.STYLE_SOLID));

		    style.set(Button.PROPERTY_ROLLOVER_ENABLED, true);
		    style.set(Button.PROPERTY_ROLLOVER_BACKGROUND, new Color(0x32, 0xCD, 0x32));
		    style.set(Button.PROPERTY_ROLLOVER_BORDER, new Border(1, Color.GREEN, Border.STYLE_SOLID));

		    style.set(Button.PROPERTY_INSETS, new Insets(2,2,2,2));
		    //style.set(Button.PROPERTY_OUTSETS, new Insets(1));
		    
		    style.set(Button.PROPERTY_ALIGNMENT, new Alignment(Alignment.CENTER, Alignment.CENTER));
		    style.set(Button.PROPERTY_HEIGHT, new Extent(40));
		    style.set(Button.PROPERTY_WIDTH, new Extent(150));
		    style.set(Button.PROPERTY_TEXT_ALIGNMENT, new Alignment(Alignment.CENTER, Alignment.CENTER));
		    style.set(Button.PROPERTY_ICON_TEXT_MARGIN, new Extent(3));
		    //style.set(Button.PROPERTY_MOUSE_CURSOR, CURSOR_POINTER);
		    style.set(Button.PROPERTY_PRESSED_ENABLED, Color.RED);

		    style.set(Button.PROPERTY_DISABLED_FOREGROUND, Color.LIGHTGRAY);
		    style.set(Button.PROPERTY_TEXT_POSITION, new Alignment(Alignment.CENTER, Alignment.CENTER));
		    style.set(Button.PROPERTY_FOCUSED_BORDER, new Border(1, Color.GREEN, Border.STYLE_SOLID));


	    STYLE2 = style;
	  }

}
