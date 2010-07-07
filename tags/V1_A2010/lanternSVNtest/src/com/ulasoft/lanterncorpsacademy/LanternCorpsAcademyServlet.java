/**
 * 
 */
package com.ulasoft.lanterncorpsacademy;


import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.webcontainer.WebContainerServlet;


@SuppressWarnings("serial")
public class LanternCorpsAcademyServlet extends WebContainerServlet{
	
	public ApplicationInstance newApplicationInstance() {
		return new LanternCorpsAcademyApp();
	}	
}
