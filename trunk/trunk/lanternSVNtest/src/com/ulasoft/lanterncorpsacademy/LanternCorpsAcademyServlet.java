/**
 * 
 */
package com.ulasoft.lanterncorpsacademy;


import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.webcontainer.WebContainerServlet;

/**
 * @author typson
 *
 */
public class LanternCorpsAcademyServlet extends WebContainerServlet{

	public ApplicationInstance newApplicationInstance() {
	    return new LanternCorpsAcademyApp();
	  }
}
