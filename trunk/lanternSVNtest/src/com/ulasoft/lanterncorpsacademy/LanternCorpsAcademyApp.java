/**
 * 
 */
package com.ulasoft.lanterncorpsacademy;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Window;


public class LanternCorpsAcademyApp extends ApplicationInstance {

	private Desktop desktop;

	/*
	 * (non-Javadoc)
	 * 
	 * @see nextapp.echo.app.ApplicationInstance#init()
	 */
	
	public Window init() {
		Window window = new Window();
		window.setTitle("Lantern Corps Academy");

		desktop = new Desktop();
		window.setContent(getDesktop());

		return window;
	}

	public Desktop getDesktop() {
		return desktop;
	}
}
