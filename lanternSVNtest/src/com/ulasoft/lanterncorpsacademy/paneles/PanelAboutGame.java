package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Component;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;

@SuppressWarnings("serial")
public class PanelAboutGame extends Panel {
	private HtmlLayout htmlLayout;
	private HtmlLayoutData hld;
	private String pagina;

	public PanelAboutGame(String pag) {
		pagina = pag;
		try {
			htmlLayout = new HtmlLayout( //
					getClass().getResourceAsStream(
							"reglashtml/reglas" + pag + ".html"), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		hld = new HtmlLayoutData("title");
		Component lbltitle = new Label();
		lbltitle.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		lbltitle.setLayoutData(hld);
		lbltitle.setBackground(Color.LIGHTGRAY);
		htmlLayout.add(lbltitle);

		hld = new HtmlLayoutData("main");
		Component lbltext = new Label();
		lbltext.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		lbltext.setLayoutData(hld);
		lbltitle.setBackground(Color.WHITE);
		htmlLayout.add(lbltext);

		Row row = new Row();

		Button btnAtras = new Button("Atras");
		btnAtras.setStyle(Estilo.getStyle2Color(app.getAtributos()));
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAtrasClicked();
			}
		});
		row.add(btnAtras);

		Button btnSiguiente = new Button("Siguiente");
		btnSiguiente.setStyle(Estilo.getStyle2Color(app.getAtributos()));
		btnSiguiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnSiguienteClicked();
			}
		});
		row.add(btnSiguiente);
		row.setAlignment(Alignment.ALIGN_CENTER);
		hld = new HtmlLayoutData("footer");
		row.setLayoutData(hld);
		htmlLayout.add(row);
		htmlLayout.setBorder(new Border(3, new Color(0x00, 0x00, 0x00),
				Border.STYLE_SOLID));
		add(htmlLayout);
	}

	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
			.getActive();
	Desktop d = app.getDesktop();

	protected void btnSiguienteClicked() {
		int paginaInt = Integer.parseInt(pagina);
		paginaInt += 1;
		if (paginaInt > 6) {
			d.setWindowPaneEmergente("Esta es la Ultima Pagina de las Reglas");
			return;
		}
		PanelAboutGame pnlMain = new PanelAboutGame(String.valueOf(paginaInt));
		d.setPanelCentral(pnlMain);

	}

	protected void btnAtrasClicked() {
		int paginaInt = Integer.parseInt(pagina);
		paginaInt -= 1;
		if (paginaInt < 1) {
			d.setWindowPaneEmergente("Esta es la Primera Pagina de las Reglas");
			return;
		}
		PanelAboutGame pnlMain = new PanelAboutGame(String.valueOf(paginaInt));
		d.setPanelCentral(pnlMain);
	}
}
