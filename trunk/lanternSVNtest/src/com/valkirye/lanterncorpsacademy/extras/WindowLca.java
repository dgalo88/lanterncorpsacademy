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

		Label txt = new Label(texto);
		row.add(txt);
		row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);

		Button btnOk = new Button("Ok");
		btnOk.setWidth(new Extent(80));
		btnOk.setHeight(new Extent(20));
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

}
