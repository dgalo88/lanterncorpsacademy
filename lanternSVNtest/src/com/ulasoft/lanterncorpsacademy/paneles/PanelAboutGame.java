package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;

import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;

@SuppressWarnings("serial")
public class PanelAboutGame extends Panel {

	private HtmlLayout htmlLayout;
	private HtmlLayoutData hld;
	private String pagina;

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();

	public PanelAboutGame(String pag) {

		pagina = pag;
		try {
			htmlLayout = new HtmlLayout( //
					getClass().getResourceAsStream( //
							"reglashtml/reglas" + pag + ".html"), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		hld = new HtmlLayoutData("title");
		Component lbltitle = new Label();
		lbltitle.setLayoutData(hld);
		htmlLayout.add(lbltitle);

		hld = new HtmlLayoutData("main");
		Component lbltext = new Label();
		lbltext.setLayoutData(hld);
		htmlLayout.add(lbltext);
		htmlLayout.setAlignment(Alignment.ALIGN_CENTER);

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		Button btnAtras = new Button("Atrás");
		btnAtras.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAtras.setWidth(new Extent(100));
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAtrasClicked();
			}
		});
		row.add(btnAtras);

		Button btnSiguiente = new Button("Siguiente");
		btnSiguiente.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnSiguiente.setWidth(new Extent(100));
		btnSiguiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnSiguienteClicked();
			}
		});
		row.add(btnSiguiente);

		hld = new HtmlLayoutData("footer");
		row.setLayoutData(hld);
		htmlLayout.add(row);
		htmlLayout.setBorder(new Border(2, Color.BLACK, Border.STYLE_SOLID));

		add(htmlLayout);

	}

	protected void btnSiguienteClicked() {

		int paginaInt = Integer.parseInt(pagina);
		paginaInt++;

		if (paginaInt > 7) {
			d.setWindowPaneEmergente("Esta es la última página de las reglas");
			return;
		}

		PanelAboutGame pnlMain = new PanelAboutGame(String.valueOf(paginaInt));
		d.setPanelCentral(pnlMain);
	}

	protected void btnAtrasClicked() {

		int paginaInt = Integer.parseInt(pagina);
		paginaInt--;

		if (paginaInt < 1) {
			d.setWindowPaneEmergente("Esta es la primera página de las reglas");
			return;
		}

		PanelAboutGame pnlMain = new PanelAboutGame(String.valueOf(paginaInt));
		d.setPanelCentral(pnlMain);

	}
}
