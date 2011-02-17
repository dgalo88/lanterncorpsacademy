package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextArea;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.EnviarMensaje;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;

@SuppressWarnings("serial")
public class PanelEnviarMensaje extends Panel {

	private TextArea texArea;

	public PanelEnviarMensaje() {

		Column col = new Column();
		Row row1 = new Row();
		row1.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		Label lblTitle = new Label("Enviar Mensaje al Grupo:");
		row1.add(lblTitle);
		col.add(row1);

		Row row2 = new Row();
		texArea = new TextArea();
		texArea.setHeight(new Extent(300));
		texArea.setWidth(new Extent(600));
		row2.setBackground(Color.WHITE);
		row2.setAlignment(Alignment.ALIGN_CENTER);
		row2.add(texArea);
		col.setBorder(new Border(3, new Color(0x00, 0x00, 0x00),
				Border.STYLE_SOLID));
		col.add(row2);

		Row row = new Row();

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnCancelarClicked();
			}
		});

		row.add(btnCancelar);

		Button btnEnviar = new Button("Enviar");
		btnEnviar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnEnviarClicked();
			}
		});

		row.add(btnEnviar);
		row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);
		add(col);
	}

	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
	.getActive();
	Desktop d = app.getDesktop();

	protected void btnEnviarClicked() {
		if (EnviarMensaje.checkMensaje(texArea)) {
			d
			.setWindowPaneEmergente("El Campo Mensaje se Encuentra Vacio no se Enviara el Mensaje al Grupo");
			texArea.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
		}
	}

	protected void btnCancelarClicked() {
		PanelMensaje pnlMain = new PanelMensaje();
		d.setPanelCentral(pnlMain);
	}

}
