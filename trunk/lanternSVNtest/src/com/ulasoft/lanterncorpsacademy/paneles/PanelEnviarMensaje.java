package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
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

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();

	private TextArea texArea;

	public PanelEnviarMensaje() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		col.add(PanelConstructor.initTopRow("Enviar Mensaje al Grupo"));

		texArea = new TextArea();
		texArea.setHeight(new Extent(300));
		texArea.setWidth(new Extent(600));

		col.add(texArea);

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancelar.setWidth(new Extent(100));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				d.btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

		Button btnEnviar = new Button("Enviar");
		btnEnviar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnEnviar.setWidth(new Extent(100));
		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnEnviarClicked();
			}
		});
		row.add(btnEnviar);

		col.add(row);
		add(col);
	}

	// --------------------------------------------------------------------------------

	private void btnEnviarClicked() {

		if (EnviarMensaje.checkMensaje(texArea)) {
			d.setWindowPaneEmergente( //
					"El mensaje se encuentra vacío, " //
					+ "no se enviará el mensaje al grupo");
		}
	}

}
