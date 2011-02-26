package com.valkirye.lanterncorpsacademy.windows;

import java.util.Calendar;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IRecursoPlanetaDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.FillImageBorder;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;

@SuppressWarnings("serial")
public class WindowLca extends WindowPane {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private Column col = new Column();
	private Row row = new Row();

	public WindowLca(String texto) {

		setTitle("Información");
		setWidth(new Extent(300));
		setHeight(new Extent(150));
		setModal(true);
		setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		setTitleBackground(Estilo.getColor(app.getAtributos()));
		setBackground(Color.WHITE);
		setBorder(new FillImageBorder(Color.BLACK, new Insets(2), new Insets(2)));

		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		row.setAlignment(Alignment.ALIGN_CENTER);

		Label txt = new Label(texto);
		row.add(txt);
		col.add(row);

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		Button btnOk = new Button("Ok");
		btnOk.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnOk.setWidth(new Extent(80));
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				userClose();
			}
		});
		row.add(btnOk);

		col.add(row);
		add(col);

	}

	// --------------------------------------------------------------------------------

	public WindowLca(Component component, String titulo, int width, int height) {

		setTitle(titulo);
		setWidth(new Extent(width));
		setHeight(new Extent(height));
		setModal(true);
		setTitleBackground(Estilo.getColor(app.getAtributos()));
		setBackground(Color.WHITE);
		setBorder(new FillImageBorder(Color.BLACK, new Insets(2), new Insets(2)));
		setResizable(false);

		row.setAlignment(Alignment.ALIGN_CENTER);
		row.setInsets(new Insets(5, 5, 5, 5));

		row.add(component);
		col.add(row);
		add(col);

	}

	public WindowLca(IPersonajeDO personaje, //
			IRecursoPlanetaDO recursoPlanetaDO, Calendar date) {

		setTitle("Recolectando");
		setWidth(new Extent(200));
		setHeight(new Extent(100));
		setModal(false);
		setTitleBackground(Estilo.getColor(app.getAtributos()));
		setBackground(Color.WHITE);
		setBorder(new FillImageBorder(Color.BLACK, new Insets(2), new Insets(2)));
		setResizable(false);

		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		row.setAlignment(Alignment.ALIGN_CENTER);

		Label txt = new Label("Recolectando, continúe jugando");
		row.add(txt);
		col.add(row);

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		Button btnStop = new Button("Dejar de Recolectar");
		btnStop.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnStop.setWidth(new Extent(120));
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				userClose();
			}
		});
		row.add(btnStop);

		col.add(row);
		add(col);

	}

}
