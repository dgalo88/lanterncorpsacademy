package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Panel;
import echopoint.HtmlLayout;

@SuppressWarnings("serial")
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
