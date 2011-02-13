package com.valkirye.lanterncorpsacademy.extras;

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

import com.minotauro.echo.table.base.ETable;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;

@SuppressWarnings("serial")
public class WindowLca extends WindowPane {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	public WindowLca(String texto) {

		Column col = new Column();
		Row row = new Row();

		setTitle("Información");
		setWidth(new Extent(300));
		setHeight(new Extent(150));
		setModal(true);
		setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		setTitleBackground(Estilo.getColor(app.getAtributos()));
		setBackground(Color.WHITE);
		setBorder(new FillImageBorder(Color.BLACK, new Insets(2), new Insets(2)));

		Label txt = new Label(texto);
		txt.setTextAlignment(Alignment.ALIGN_CENTER);
		row.add(txt);
		row.setAlignment(Alignment.ALIGN_CENTER);
		row.setInsets(new Insets(10, 10, 10, 10));
		col.add(row);

		Button btnOk = new Button("Ok");
		btnOk.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				userClose();
			}
		});
		row = new Row();
		row.add(btnOk);
		row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);
		add(col);

	}

	// --------------------------------------------------------------------------------

	public WindowLca(Component component, String titulo) {

		Column col = new Column();
		Row row = new Row();

		setTitle(titulo);
		setWidth(new Extent(600));
		setHeight(new Extent(230));
		setModal(false);
		setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		setTitleBackground(Estilo.getColor(app.getAtributos()));
		setBackground(Color.WHITE);
		setBorder(new FillImageBorder(Color.BLACK, new Insets(2), new Insets(2)));
		setResizable(false);

		row.add(component);
		row.setAlignment(Alignment.ALIGN_CENTER);
		row.setInsets(new Insets(10, 10, 10, 10));

		col.add(row);
		add(col);

	}

	public WindowLca(ETable table) {

		Column col = new Column();
		Row row = new Row();

		setTitle("Mis Datos");
		setWidth(new Extent(500));
		setHeight(new Extent(600));
		setModal(true);
		setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		setTitleBackground(Estilo.getColor(app.getAtributos()));
		setBackground(Color.WHITE);
		setBorder(new FillImageBorder(Color.BLACK, new Insets(2), new Insets(2)));
		setResizable(false);

		row.add(table);
		row.setAlignment(Alignment.ALIGN_CENTER);
		row.setInsets(new Insets(10, 10, 10, 10));

		col.add(row);
		add(col);

	}
}
