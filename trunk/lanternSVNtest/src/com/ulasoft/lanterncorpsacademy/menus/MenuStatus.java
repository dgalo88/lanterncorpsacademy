package com.ulasoft.lanterncorpsacademy.menus;

import lcaInterfaceDAO.IPersonajeDO;
import nextapp.echo.app.Color;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;

import com.ulasoft.lanterncorpsacademy.ProgressBar;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class MenuStatus extends Panel {
	
	private ProgressBar salud;
	private ProgressBar energia;
	private ProgressBar experiencia;
	private Label lblTrainsValue;
	private Label lblNiveLabelValue;
	private IPersonajeDO personaje;

	public MenuStatus(){

		Grid grid = new Grid(2);
		grid.setStyle(GUIStyles.STYLEMENUI);

		Label lblSalud = new Label("Salud");
		salud = new ProgressBar(15, 180, 0, null);

		Label lblEnergia = new Label("Energia del Anillo");
		energia = new ProgressBar(15, 180, 1, null);

		Label lblExperiencia = new Label("Experiencia");
		experiencia = new ProgressBar(15, 180, 2, null);

//		Label lblTrains = new Label("Puntos de Entrenamiento:");
		lblTrainsValue = new Label("XX");
//		Label lblNivel = new Label("Nivel");
		lblNiveLabelValue = new Label("XX");

		grid.add(salud);
		grid.add(lblSalud);
		grid.add(energia);
		grid.add(lblEnergia);
		grid.add(experiencia);
		grid.add(lblExperiencia);

		grid.setForeground(new Color (255, 255, 255));
		grid.setHeight(new Extent(50));

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

	public Label getLblTrainsValue() {
		return lblTrainsValue;
	}

	public void setLblTrainsValue(Label lblTrainsValue) {
		this.lblTrainsValue = lblTrainsValue;
	}

	public Label getLblNiveLabelValue() {
		return lblNiveLabelValue;
	}

	public void setLblNiveLabelValue(Label lblNiveLabelValue) {
		this.lblNiveLabelValue = lblNiveLabelValue;
	}

}
