package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.ImgLoad;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

public class PanelRecargarAnillo extends Panel {

	LanternCorpsAcademyApp lca = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
	.getActive();
	
	public PanelRecargarAnillo() {
		Column col = new Column();
		col.setInsets(new Insets(2, 2, 2, 2));
		Label lblTitle = new Label("Recarga de Anillo");
		lblTitle.setBackground(Color.WHITE);
		col.add(lblTitle);

		Label lblImagen = new Label();
		lblImagen
				.setIcon(new ResourceImageReference(ImgLoad.panelRecarga(lca
								.getAtributos().getPersonaje()),
						new Extent(200), new Extent(300)));
		col.add(lblImagen);
		
		Label lblNivel = new Label("Nivel "+ lca.getAtributos().getPersonaje().getNivel());
		lblNivel.setBackground(Color.WHITE);
		col.add(lblNivel);
		
		Row row = new Row();

		// Button btnCargarBatPrin = new Button("Cargar con Bateria Central");
		// btnCargarBatPrin.setStyle(GUIStyles.DEFAULT_STYLE);
		// btnCargarBatPrin.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent arg0) {
		// btnCargarBatPrinClicked();
		// }
		// });
		// row.add(btnCargarBatPrin);

		Button btnCargarBatPort = new Button("Cargar con Bateria Portatil");
		btnCargarBatPort.setStyle(Estilo.getDefaultStyleColor(lca.getAtributos()));
		btnCargarBatPort.setWidth(new Extent(300));
		btnCargarBatPort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnCargarBatPortClicked();
			}
		});
		row.add(btnCargarBatPort);
		row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);
		this.add(col);
	}

	
	Atributos atrib = lca.getAtributos();
	Desktop d = lca.getDesktop();

	protected void btnCargarBatPortClicked() {

		try {
			atrib.recargaAnillo();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// protected void btnCargarBatPrinClicked() {
	// try {
	// atrib.recargaAnillo();
	// } catch (Exception e) {
	//
	// e.printStackTrace();
	// }
	//		
	// }
}
