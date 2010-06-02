package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.GUIStyles;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Viajar;

import echopoint.ImageMap;

public class PanelViajarPlaneta extends Panel{

	private Label lblActual;
	LanternCorpsAcademyApp aplicacion = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();

	@SuppressWarnings("serial")
	public PanelViajarPlaneta() {
				
		Column col = new Column();
		Label lblTitle = new Label("Seleccione un Planeta");
		lblTitle.setBackground(Color.WHITE);
		col.add(lblTitle);
		lblActual = new Label("nothing selected");
		lblActual.setStyle(GUIStyles.STYLE2);

		
		ImageMap imageMap = new ImageMap(new ResourceImageReference(
				"com/ulasoft/lanterncorpsacademy/imagenes/mapa_molde.png"));
//				new Extent(652), new Extent(332)));

		imageMap.setWidth(new Extent(750));
	    imageMap.setHeight(new Extent(500));

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
						Desktop d=app.getDesktop();
						d.setWindowPaneEmergente("No tienes suficiente energia disponible para llegar.");
						}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				lblActual.setText("Voy a:"+evt.getActionCommand());
			
			}
		});

		col.add(lblActual);		
		
		col.add(imageMap);
				
		add(col);
	}
	
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
	
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
