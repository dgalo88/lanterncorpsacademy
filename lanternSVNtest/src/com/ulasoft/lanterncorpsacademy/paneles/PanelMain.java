package com.ulasoft.lanterncorpsacademy.paneles;

import lcaInterfaceDAO.IPersonajeDO;

import com.ulasoft.lanterncorpsacademy.GUIStyles;

import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;

public class PanelMain extends Panel {

	public PanelMain() {
		Row row = new Row();
		row.setStyle(GUIStyles.STYLE3);
		//row.setCellSpacing(new Extent(250));
		//row.add(new Label(""));
		Grid grid = new Grid(2);
		grid.setBackground(Color.WHITE);
		Label lblImagen = new Label();
		lblImagen
				.setIcon(new ResourceImageReference(
						"com/ulasoft/lanterncorpsacademy/imagenes/GreenLanternRebirthHC1.jpg",
						new Extent(152), new Extent(232)));
		grid.add(lblImagen);
		Column col = new Column();
		col.add(new Label("Ubicación"));
		col.add(new Label("Planeta:"));
		col.add(new Label("Sector:"));
		col.add(new Label("Estadísticas"));
		col.add(new Label("Combates Ganados:"));
		col.add(new Label("Combates Perdidos:"));
		col.add(new Label("Misiones Realizadas:"));
		col.add(new Label("Ultimo Ingreso"));
		col.add(new Label("Fecha:"));
		col.add(new Label("Hora:"));
		grid.add(col);
		row.add(grid);
		add(row);
	}
	
}
