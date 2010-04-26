package com.ulasoft.lanterncorpsacademy.paneles;

import echopoint.HtmlLayout;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;

public class PanelAboutGame extends Panel{
	private HtmlLayout htmlLayout;
	public  PanelAboutGame() {
		try {
		      htmlLayout = new HtmlLayout( //
		          getClass().getResourceAsStream("../reglas.html"), "UTF-8");
		    } catch (Exception e) {
		      throw new RuntimeException(e);
		    }
		 add(htmlLayout);
	}
}
