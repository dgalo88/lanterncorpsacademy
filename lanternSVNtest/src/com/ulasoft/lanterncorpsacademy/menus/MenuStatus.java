package com.ulasoft.lanterncorpsacademy.menus;

import lcaInterfaceDAO.IPersonajeDO;
import nextapp.echo.app.Color;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;

import com.ulasoft.lanterncorpsacademy.ProgressBar;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class MenuStatus extends Panel {
	
	private ProgressBar salud;
	private ProgressBar energia;
	private ProgressBar experiencia;
	private IPersonajeDO personaje;

	public MenuStatus() {

		Grid grid = new Grid(2);
		grid.setInsets(new Insets(1, 1, 1, 1));
		grid.setForeground(Color.WHITE);
		grid.setHeight(new Extent(50));
		grid.setWidth(new Extent(265));

		Label lblSalud = new Label("Salud");
		Estilo.setFont(lblSalud, GUIStyles.NORMAL, 12);
		salud = new ProgressBar(13, 150, 0, null);
		grid.add(salud);
		grid.add(lblSalud);

		Label lblEnergia = new Label("Energía del Anillo");
		Estilo.setFont(lblEnergia, GUIStyles.NORMAL, 12);
		energia = new ProgressBar(13, 150, 1, null);
		grid.add(energia);
		grid.add(lblEnergia);

		Label lblExperiencia = new Label("Experiencia");
		Estilo.setFont(lblExperiencia, GUIStyles.NORMAL, 12);
		experiencia = new ProgressBar(13, 150, 2, null);
		grid.add(experiencia);
		grid.add(lblExperiencia);

		add(grid);
	}

	public IPersonajeDO getPersonaje() {
		return personaje;
	}

	public void setPersonaje(IPersonajeDO personaje) {
		this.personaje = personaje;
	}

	public ProgressBar getSalud() {
		return salud;
	}

	public void setSalud(ProgressBar salud) {
		this.salud = salud;
	}

	public ProgressBar getEnergia() {
		return energia;
	}

	public void setEnergia(ProgressBar energia) {
		this.energia = energia;
	}

	public ProgressBar getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(ProgressBar experiencia) {
		this.experiencia = experiencia;
	}

}
