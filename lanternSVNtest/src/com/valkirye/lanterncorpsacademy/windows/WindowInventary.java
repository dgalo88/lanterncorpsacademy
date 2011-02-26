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
import com.ulasoft.lanterncorpsacademy.paneles.PanelVerUnidades;

@SuppressWarnings("serial")
public class WindowInventary extends WindowPane {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private PanelVerUnidades pnlMain = new PanelVerUnidades();

	public WindowInventary() {
		initWindow();
	}

	public void initWindow() {

		setTitle("Inventario de Unidades");
		setModal(false);
		setWidth(new Extent(500));
		setHeight(new Extent(180));
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
