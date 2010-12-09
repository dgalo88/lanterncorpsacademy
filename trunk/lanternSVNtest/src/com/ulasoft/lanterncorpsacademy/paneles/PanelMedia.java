package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Color;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;

public class PanelMedia extends Panel {

	public PanelMedia() {
		Label lblMain = new Label("Media");
		lblMain.setForeground(new Color(255, 255, 255));
		add(lblMain);
	}
}
