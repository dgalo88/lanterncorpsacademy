package com.valkirye.lanterncorpsacademy.windows;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
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
public class WindowInfo extends WindowPane {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private String texto;

	public WindowInfo() {
		initWindow();
	}

	public void initWindow() {

		setTitle("Información");
		setWidth(new Extent(300));
		setHeight(new Extent(150));
		setModal(true);
		setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		setTitleBackground(Estilo.getColor(app.getAtributos()));
		setBackground(Color.WHITE);
		setBorder(new FillImageBorder(Color.BLACK, new Insets(2), new Insets(2)));

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		Label txt = new Label(getTexto());
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

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

}
