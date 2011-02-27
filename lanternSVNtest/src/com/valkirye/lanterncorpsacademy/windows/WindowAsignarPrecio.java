package com.valkirye.lanterncorpsacademy.windows;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.FillImageBorder;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Row;
import nextapp.echo.app.WindowPane;

import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelAsignarPrecio;

@SuppressWarnings("serial")
public class WindowAsignarPrecio extends WindowPane {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private PanelAsignarPrecio pnlMain = new PanelAsignarPrecio();

	public WindowAsignarPrecio() {
		initWindow();
	}

	public void initWindow() {

		setTitle("Asignar Precio");
		setModal(true);
		setWidth(new Extent(250));
		setHeight(new Extent(380));
		setTitleBackground(Estilo.getColor(app.getAtributos()));
		setBackground(Color.WHITE);
		setBorder(new FillImageBorder(Color.BLACK, new Insets(2), new Insets(2)));
		setResizable(false);

		Column col = new Column();
		Row row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);
		row.setInsets(new Insets(5, 5, 5, 5));

		row.add(pnlMain);
		col.add(row);
		add(col);

	}

}