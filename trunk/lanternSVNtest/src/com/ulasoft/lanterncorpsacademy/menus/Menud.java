package com.ulasoft.lanterncorpsacademy.menus;

import nextapp.echo.app.Color;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;

import com.ulasoft.lanterncorpsacademy.GUIStyles;
import com.ulasoft.lanterncorpsacademy.ProgressBar;

@SuppressWarnings("serial")
public class Menud extends Panel {
	
	public Menud(){
		Grid grid = new Grid(2);

		Label lblSalud = new Label("Salud");
		grid.add(lblSalud);

		// PROGRESS BAR AQUI HEALTH
		ProgressBar salud = new ProgressBar(17, 180, 0, null);
		salud.setCurrValue(95);
		grid.add(salud);

		Label lblEnergia = new Label("Energia del Anillo");
		grid.add(lblEnergia);

		// PROGRESS BAR AQUI ENERGIA
		ProgressBar energia = new ProgressBar(17, 180, 1, Color.GREEN);
		energia.setCurrValue(90);
		grid.add(energia);

		Label lblExperiencia = new Label("Experiencia");
		grid.add(lblExperiencia);

		// PROGRESS BAR EXP
		ProgressBar experiencia = new ProgressBar(17, 180, 2, null);
		experiencia.setCurrValue(80);
		grid.add(experiencia);

		Label lblTrains = new Label("Puntos de Entrenamiento:");
		grid.add(lblTrains);

		Label lblTrainsValue = new Label("XXXXX");
		grid.add(lblTrainsValue);

		Label lblNivel = new Label("NIvel");
		grid.add(lblNivel);

		Label lblNiveLabel = new Label("XXXXX");
		grid.add(lblNiveLabel);

		grid.setStyle(GUIStyles.DEFAULT_STYLE);
		grid.setHeight(new Extent(315));

		add(grid);
	}

}
