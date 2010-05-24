package com.ulasoft.lanterncorpsacademy;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Window;

@SuppressWarnings("serial")
public class LanternCorpsAcademyApp extends ApplicationInstance {

  public Desktop desktop;

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
