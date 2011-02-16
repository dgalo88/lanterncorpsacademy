package com.valkirye.lanterncorpsacademy.extras;


import java.util.ArrayList;
import java.util.List;

import com.ulasoft.lanterncorpsacademy.logic.Data;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUsuarioDO;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;


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
		grid.add(new Label(Data.getClase(personaje.getClaseLinternaRef().getRefIdent())));
		col.add(grid);

		grid = new Grid();
		grid.add(new Label("Planeta Casa:"));
		grid.add(new Label(Data.getPlanetaBase(personaje.getClaseLinternaRef().getRefIdent())));
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

	// --------------------------------------------------------------------------------

	public static ObjectSelectScrolling getUnidades(boolean selectable) {

		List<ObjectLca> list = new ArrayList<ObjectLca>();
		for (int i = 0; i < 10; i++) {
			ObjectLca item = new ObjectLca(selectable, i);
			list.add(item);
		}

		ObjectSelectModel oModel = new ObjectSelectModel(list);
		TestCellRenderer tcr = new TestCellRenderer();
		ObjectSelectScrolling oSelectScrolling = new ObjectSelectScrolling(oModel, tcr);

		return oSelectScrolling;

	}

	// --------------------------------------------------------------------------------

	public Row getDatos (){
		return row;
	}

}
