package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Viajar;

import echopoint.ImageMap;

@SuppressWarnings("serial")
public class PanelViajarPlaneta extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private Label lblActual;

	public PanelViajarPlaneta() {

		Column col = new Column();
		col.setInsets(new Insets(10, 0, 10, 0));
		col.setCellSpacing(new Extent(10));

		col.add(PanelConstructor.initTopRow("Seleccione el Planeta Destino"));

		ImageMap imageMap = new ImageMap(new ResourceImageReference( //
				"com/ulasoft/lanterncorpsacademy/imagenes/mapa_molde.png"));

		imageMap.setWidth(new Extent(750));
		imageMap.setHeight(new Extent(500));

		lblActual = new Label("Nothing Selected");
		try {
			imageMap.addSections(Viajar.cargarPlanetas(this));
		} catch (Exception e) {
			e.printStackTrace();
		}

		imageMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					if (Viajar.viajarA(evt.getActionCommand())) {
						PlanetClicked();				
					}
					else {
						Desktop d = app.getDesktop();
						d.setWindowPaneEmergente("No tienes suficiente energía disponible para viajar");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				lblActual.setText("Voy a: " + evt.getActionCommand());
			}
		});
		col.add(PanelConstructor.initTopRow(lblActual.getText(), 14));

		col.add(imageMap);
		add(col);
	}

	protected void PlanetClicked() {

		PanelMain pnlMain = new PanelMain();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);

	}

	public Label getLblActual() {
		return lblActual;
	}

	public void setLblActual(Label lblActual) {
		this.lblActual = lblActual;
	}

}
