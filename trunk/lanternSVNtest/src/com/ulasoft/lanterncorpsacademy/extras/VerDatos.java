package com.ulasoft.lanterncorpsacademy.extras;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUsuarioDO;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;

import com.ulasoft.lanterncorpsacademy.DatosClases;

@SuppressWarnings("serial")
public class VerDatos extends Row {

//	Desktop desktop;
//	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
//			.getActive();
//	Atributos atributos = app.getAtributos();
//
//	private IUsuarioDO usuario = atributos.getUsuario();
//	private IPersonajeDO personaje = atributos.getPersonaje();

	private IUsuarioDO usuario;
	private IPersonajeDO personaje;

	private Row row;
	private Column col;

	public VerDatos(IUsuarioDO user, IPersonajeDO pers) {

		usuario = user;
		personaje = pers;

		row = new Row();
		row.setCellSpacing(new Extent(5));
		col = new Column();
		col.setCellSpacing(new Extent(5));
		Grid grid;

		grid = new Grid();
		grid.add(new Label("Nombre de Usuario: "));
		grid.add(new Label(personaje.getAlias()));
		col.add(grid);

		grid = new Grid();
		grid.add(new Label("Nombre: "));
		grid.add(new Label(usuario.getNombre()));
		col.add(grid);

		grid = new Grid();
		grid.add(new Label("Correo: "));
		grid.add(new Label(usuario.getCorreo()));
		col.add(grid);

		grid = new Grid();
		grid.add(new Label("Clase: "));
		grid.add(new Label(DatosClases.clase(personaje.getClaseLinternaRef().getRefIdent())));
		col.add(grid);

		grid = new Grid();
		grid.add(new Label("Planeta Casa:"));
		grid.add(new Label(DatosClases.planetaCasa(personaje.getClaseLinternaRef().getRefIdent())));
		col.add(grid);

		grid = new Grid();
		grid.add(new Label("Nivel: "));
		grid.add(new Label(Integer.toString(personaje.getNivel())));
		col.add(grid);

		grid = new Grid();
		grid.add(new Label("Puntos de Entrenamiento: "));
		grid.add(new Label(Integer.toString(personaje.getPuntosDeEntrenamiento())));
		col.add(grid);

		grid = new Grid();
		grid.add(new Label("Ofertas:"));
		grid.add(new Label("Por Implementar"));
		col.add(grid);

		row.add(col);

	}

	public Row getDatos (){
		return row;
	}

}
