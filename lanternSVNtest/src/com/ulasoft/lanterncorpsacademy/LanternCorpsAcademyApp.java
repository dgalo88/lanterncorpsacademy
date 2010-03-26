/**
 * 
 */
package com.ulasoft.lanterncorpsacademy;


import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Window;

/**
 * @author typson, julian
 *
 */
public class LanternCorpsAcademyApp extends ApplicationInstance {

	/* (non-Javadoc)
	 * @see nextapp.echo.app.ApplicationInstance#init()
	 */
	public Window init() {
	    Window window = new Window();
	    window.setTitle("Lantern Corps Academy RPG");

	    Desktop desktop = new Desktop();
	    window.setContent(desktop);

	    return window;
	  }

}
