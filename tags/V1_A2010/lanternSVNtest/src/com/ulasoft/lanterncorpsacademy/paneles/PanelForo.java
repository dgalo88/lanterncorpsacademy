package com.ulasoft.lanterncorpsacademy.paneles;

import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.ImgLoad;

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
	
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
	.getActive();

	public PanelForo() {
		int ancho;
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
		if(app.getAtributos()==null){
			ancho= 950;
		}
		else{
			ancho= 725;
		}
		
		lblImagen.setIcon(new ResourceImageReference(//
				"com/ulasoft/lanterncorpsacademy/imagenes/glcbanner.gif",new Extent(ancho),new Extent(196)));
		row.add(lblImagen);
		row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);
		add(col);
		
	}
}
