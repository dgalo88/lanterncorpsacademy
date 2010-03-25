package com.ulasoft.lanterncorpsacademy;

import nextapp.echo.app.ApplicationInstance;
import nextapp.echo.app.Window;

public class LanternCorpsAcademyApp extends ApplicationInstance {

  public Window init() {
    Window window = new Window();
    window.setTitle("Lantern Corps Academy RPG");

    Desktop desktop = new Desktop();
    window.setContent(desktop);

    return window;
  }
}
