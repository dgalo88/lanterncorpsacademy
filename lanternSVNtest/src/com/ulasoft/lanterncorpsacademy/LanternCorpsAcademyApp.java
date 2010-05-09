/**
 * 
 */
package com.ulasoft.lanterncorpsacademy;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Window;


public class LanternCorpsAcademyApp extends ApplicationInstance {

  public Desktop desktop;

  /*
   * (non-Javadoc)
   * 
   * @see nextapp.echo.app.ApplicationInstance#init()
   */
  
  public Window init() {
    Window window = new Window();
    window.setTitle("Lantern Corps Academy");
    // Cuando se ejecuta el constructor es que se estan creando los paneles.
    // los paneles estan declarando como una variable de instancia al desktop
    // pero estan llamando a getDesktop antes de que se le asigne realmente
    // el valor a la variable desktop, por lo tanto getDesktop esta devolviendo nulo
    desktop = new Desktop();
    window.setContent(getDesktop());
    return window;
  }

  public Desktop getDesktop() {
    return desktop;
  }
}
