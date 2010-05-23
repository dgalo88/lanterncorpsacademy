package com.ulasoft.lanterncorpsacademy.paneles;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.GUIStyles;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;

import echopoint.ImageMap;
import echopoint.jquery.TooltipContainer;
import echopoint.model.CircleSection;
import echopoint.model.Point;
import echopoint.model.PolygonSection;
import echopoint.model.RectangleSection;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.ImageReference;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.extras.app.ToolTipContainer;

public class PanelViajarPlaneta extends Panel{

	private Label lblSelected;

	public PanelViajarPlaneta() {
		
		
		
		Column col = new Column();
		Label lblTitle = new Label("Seleccione un Planeta");
		lblTitle.setBackground(Color.WHITE);
		col.add(lblTitle);
		lblSelected = new Label("nothing selected");
		lblSelected.setStyle(GUIStyles.STYLE2);
		col.add(lblSelected);		
//		Label lblImagen = new Label(); 
//		lblImagen.setIcon(new ResourceImageReference("com/ulasoft/lanterncorpsacademy/imagenes/space.png",new Extent(652), new Extent(332)));
//		col.add(lblImagen);
	
		
//	    ContentPane contentPane = new ContentPane();
//	    contentPane.setInsets(new Insets(2, 2, 2, 2));
//	    window.setContent(contentPane);
//
//	    ImageReference ir = new ResourceImageReference( //
//	        "com/tutorial/imagemap/back.png");
//
//	    Column col = new Column();
//	    contentPane.add(col);
//
//		ImageMap imageMap = new ImageMap(new ResourceImageReference(
//				"com/ulasoft/lanterncorpsacademy/imagenes/space.png",
//				new Extent(652), new Extent(332)));
		
		ImageMap imageMap = new ImageMap(new ResourceImageReference(
				"com/ulasoft/lanterncorpsacademy/imagenes/mapa_molde.png"));
//				new Extent(652), new Extent(332)));

		imageMap.setWidth(new Extent(750));
	    imageMap.setHeight(new Extent(500));

	    
		imageMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (evt.getActionCommand().equals("mine")){
					MineClicked();
				}
				lblSelected.setText(evt.getActionCommand());
			
			}
		});


//		imageMap.addSection(new CircleSection(70, 70, 50, "circle"));
//		imageMap
//				.addSection(new RectangleSection(90, 220, 290, 270, "rectangle"));
//		imageMap.addSection(new PolygonSection(new int[] { 275, 120, 450, 120,
//				500, 75, 425, 35, 330, 100, 275, 50 }, "polygon"));
//		RectangleSection rs= new RectangleSection(10,10,20,20, "mine");
//		rs.setAltText("MINE: this is a really loong string with lots of info and bulshit bla bla bla//" +
//				"\nbla bla bla bla bla bla potencialmente info del planeta");
//		imageMap.addSection(rs);
		
		CircleSection oa = new CircleSection(373, 250, 10, "mine");
		oa.setAltText("Oa - Sector 0 - Base de los Green Lantern Corps");
		imageMap.addSection(oa);
		
		CircleSection qward = new CircleSection(10, 125, 10, "voy a qward");
		qward.setAltText("Qward - Sector -1 - Base de los Sinestro Corps");
		imageMap.addSection(qward);
		
		CircleSection odym = new CircleSection(101, 395, 10, "voy a odym");
		odym.setAltText("Odym - Sector 2682 - Base de los Blue Lantern Corps");
		odym.setCentre(new Point(101, 395));
		imageMap.addSection(odym);
		
//		TooltipContainer tooltip= new TooltipContainer();
//		tooltip.setStyle(GUIStyles.STYLE2);
//		tooltip.setPositionTooltip(new Pos(101, 395));
//		
//		imageMap.add(tooltip);
		
		
		CircleSection indigo = new CircleSection(501,10, 10, "voy a no se donde q ladilla");
		indigo.setAltText("Se desconoce el nombre - Sector 200 - Base de la tribu Indigo");
		imageMap.addSection(indigo);
		
		CircleSection ryut = new CircleSection(739, 156, 10, "voy a ryut");
		ryut.setAltText("Ryut - Sector 665 - Base de los Black Lantern Corps");
		imageMap.addSection(ryut);
		
		CircleSection ysmault = new CircleSection(721, 289, 10, "voy a ysmault");
		ysmault.setAltText("Ysmault - Sector 666 - Base de los Red Lantern Corps");
		imageMap.addSection(ysmault);
		
		CircleSection zamaron = new CircleSection(493, 483, 10, "voy a zamaron");
		zamaron.setAltText("Zamaron - Sector 1416 - Base de las Star Sapphires");
		imageMap.addSection(zamaron);
		
		//CircleSection(int x, int y, int radius, String... values) 
		//LAS COORDENADAS TIENEN Q SALIR DE LA BD repetir para el resto de los planetas..
		//puede usarse una lista de sections inicializada en otra parte y pasarla al imageMap..

		col.add(imageMap);

				
		add(col);
	}
	
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
	
	protected void MineClicked() {
		PanelMain pnlMain = new PanelMain();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);
		
	}
}
