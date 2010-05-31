package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.List;

import lcaInterfaceDAO.IPlanetaDO;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.GUIStyles;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.Viajar;

import dao.api.DataObject;
import echopoint.ImageMap;
import echopoint.model.CircleSection;
import echopoint.model.MapSection;
import echopoint.model.Point;
import factory.GlobalDOFactory;

public class PanelViajarPlaneta extends Panel{

	private Label lblSelected;

	@SuppressWarnings("serial")
	public PanelViajarPlaneta() {
				
		Column col = new Column();
		Label lblTitle = new Label("Seleccione un Planeta");
		lblTitle.setBackground(Color.WHITE);
		col.add(lblTitle);
		lblSelected = new Label("nothing selected");
		lblSelected.setStyle(GUIStyles.STYLE2);
		col.add(lblSelected);		

		
		ImageMap imageMap = new ImageMap(new ResourceImageReference(
				"com/ulasoft/lanterncorpsacademy/imagenes/mapa_molde.png"));
//				new Extent(652), new Extent(332)));

		imageMap.setWidth(new Extent(750));
	    imageMap.setHeight(new Extent(500));

	    try {
	    	imageMap.addSections(Viajar.cargarPlanetas());
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
		imageMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					Viajar.viajarA(evt.getActionCommand());
				} catch (Exception e) {

					e.printStackTrace();
				}
				PlanetClicked();				
				lblSelected.setText("Voy a:"+evt.getActionCommand());
			
			}
		});

		LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
		Atributos atts = app.getAtributos();

		//CircleSection(int x, int y, int radius, String... values) 
		//LAS COORDENADAS TIENEN Q SALIR DE LA BD repetir para el resto de los planetas..
		//puede usarse una lista de sections inicializada en otra parte y pasarla al imageMap..
		
		
		col.add(imageMap);
				
		add(col);
	}
	
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
	
	protected void PlanetClicked() {
		PanelMain pnlMain = new PanelMain();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);
		
	}
}
