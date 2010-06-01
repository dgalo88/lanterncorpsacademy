package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;

public class PanelForo extends Panel {

	public PanelForo() {
		Column col = new Column();
		
		Row row = new Row();
		Label lblMain = new Label("PROXIMAMENTE");
		lblMain.set(PROPERTY_FONT, new Extent(100));
		lblMain.setBackground(Color.WHITE);
		row.add(lblMain);
		row.set(PROPERTY_WIDTH, new Extent(950));
		row.setAlignment(Alignment.ALIGN_CENTER);
		
		col.add(row);
		
		row = new Row();
		Label lblImagen = new Label();
		lblImagen.setIcon(new ResourceImageReference(//
				"com/ulasoft/lanterncorpsacademy/imagenes/glcbanner.gif"));
		row.add(lblImagen);
		row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);
		add(col);
		
	}
}
