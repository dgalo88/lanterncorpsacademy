package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.ImgLoad;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelRecargarAnillo extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Atributos atrib = app.getAtributos();

	public PanelRecargarAnillo() {

		Column col = new Column();
		col.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		Label lblTitle = new Label("Recargar Energía del Anillo");
		lblTitle.setForeground(Color.WHITE);
		Estilo.setFont(lblTitle, GUIStyles.BOLD, 16);
		row.add(lblTitle);
		col.add(row);

		Label lblImagen = new Label();
		lblImagen.setIcon(new ResourceImageReference( //
				ImgLoad.panelRecarga(app.getAtributos().getPersonaje()), //
				new Extent(200), new Extent(300)));
		col.add(lblImagen);

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		Label lblNivel = new Label("Nivel " + atrib.getPersonaje().getNivel());
		lblNivel.setForeground(Estilo.getRolloverColor(atrib));
		Estilo.setFont(lblNivel, GUIStyles.BOLD);
		row.add(lblNivel);
		col.add(row);

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);
		row.setCellSpacing(new Extent(10));

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancelar.setWidth(new Extent(100));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				app.getDesktop().btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

		Button btnRecargar = new Button("Recargar");
		btnRecargar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnRecargar.setWidth(new Extent(100));
		btnRecargar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnCargarBatPortClicked();
			}
		});
		row.add(btnRecargar);

		col.add(row);
		add(col);
	}

	protected void btnCargarBatPortClicked() {

		try {
			atrib.recargaAnillo();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
