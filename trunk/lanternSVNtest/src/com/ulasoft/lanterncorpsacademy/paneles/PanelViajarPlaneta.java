package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;

public class PanelViajarPlaneta extends Panel{

	public PanelViajarPlaneta() {
		Column col = new Column();
		Label lblTitle = new Label("Seleccione un Planeta");
		lblTitle.setBackground(Color.WHITE);
		col.add(lblTitle);
		Label lblImagen = new Label(); 
		lblImagen.setIcon(new ResourceImageReference("com/ulasoft/lanterncorpsacademy/imagenes/space.png",new Extent(652), new Extent(332)));
		col.add(lblImagen);
		add(col);
	}
}
