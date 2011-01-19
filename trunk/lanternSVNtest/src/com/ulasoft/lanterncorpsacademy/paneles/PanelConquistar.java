package com.ulasoft.lanterncorpsacademy.paneles;

import java.sql.Date;

import lcaInterfaceDAO.IPlanetaDO;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.ImgLoad;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelConquistar extends Panel {

	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
		.getActive();
	private Label lblAlias;
	private IPlanetaDO planeta;
	private Date fecha;
	private Label lblFechaValue;
//	private Label lblMisionesValue;
	private Label lblSectorValue;
	private Label lblPlanetaValue;

	public PanelConquistar() {

		Row row = new Row();
		row.setStyle(GUIStyles.STYLECENTERROW);

		Column col = new Column();
		col.setStyle(GUIStyles.STYLECENTERROW);

		Grid grid = new Grid(2);
		grid.setBackground(Color.WHITE);

		Column colInf = new Column();

		Label lblImagen = new Label();
		lblImagen.setIcon(new ResourceImageReference(
				ImgLoad.panelMain(app.getAtributos().getPersonaje()),
				new Extent(236), new Extent(360)));
		grid.add(lblImagen);

		lblPlanetaValue = new Label("PL");
		lblSectorValue = new Label("00");
		lblFechaValue = new Label("Ult Ing");

//		lblAlias = new Label("alias");
//		lblAlias.setForeground(new Color(255, 255, 255));
//		lblAlias.set(PROPERTY_FONT, Font.BOLD);
//		col.add(lblAlias);

		colInf.add(new Label("DUEÑO DEL PLANETA"));
		colInf.add(new Label("$Nombre"));
		colInf.add(new Label("Clase: XXX"));
		colInf.add(new Label("Nivel: XX"));

		colInf.add(new Label("ESTADÍSTICAS"));
		colInf.add(new Label("Combates Ganados:"));
		colInf.add(new Label("Combates Perdidos:"));
		colInf.add(new Label("Planetas Conquistados:"));

		grid.add(colInf);
		col.add(grid);

		Row rowBotones = new Row();
		rowBotones.setStyle(GUIStyles.STYLECENTERROW);
		rowBotones.setCellSpacing(new Extent(10));

		Button btnSalir = new Button("Salir");
		btnSalir.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				btnSalirClicked();
			}
		});
		rowBotones.add(btnSalir);

		Button btnConquistar = new Button("Conquistar");
		btnConquistar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnConquistar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
		//		btnConquistarClicked();
			}
		});
		rowBotones.add(btnConquistar);

		col.add(rowBotones);
		row.add(col);
		row.set(PROPERTY_WIDTH, new Extent(700));
		row.set(PROPERTY_HEIGHT, new Extent(800));
		add(row);

	}


	// public PanelMain() {
	//
	// SplitPane splitPane= new
	// SplitPane(SplitPane.ORIENTATION_HORIZONTAL_LEFT_RIGHT);
	// splitPane.setBackground(Color.LIGHTGRAY);
	// splitPane.set(PROPERTY_WIDTH, new Extent(400));
	// splitPane.set(PROPERTY_HEIGHT, new Extent(300));
	//		
	// ContentPane contenPane = new ContentPane();
	// ImageMap imageMap = new ImageMap(new ResourceImageReference(
	// "com/ulasoft/lanterncorpsacademy/imagenes/GreenLanternRebirthHC1.jpg"));
	// imageMap.setWidth(new Extent(200));
	// imageMap.setHeight(new Extent(300));
	//	    
	// contenPane.add(imageMap);
	//	    
	// splitPane.add(contenPane);
	//		
	// ContentPane contentPane2 = new ContentPane();
	// Grid grid = new Grid(2);
	// Row row = new Row();
	//
	// Label lblUbicacion = new Label("Ubicacion:");
	//
	// Label lblPlaneta = new Label("PLaneta:");
	// lblPlanetaValue = new Label("PL");
	//
	// Label lblSector = new Label("Sector");
	// lblSectorValue = new Label(" ");
	//
	// Label lblFecha = new Label("Ultimo Ingreso:");
	// lblFechaValue = new Label("Ult Ing");
	//
	// lblUbicacion.setTextAlignment(Alignment.ALIGN_CENTER);
	// row.add(lblUbicacion);
	//		
	// LanternCorpsAcademyApp app = (LanternCorpsAcademyApp)
	// LanternCorpsAcademyApp.getActive();
	// Atributos atrib = app.getAtributos();
	//
	// // try {
	// // atrib.updatePanelMain(this);
	// // } catch (Exception e) {
	// // e.printStackTrace();
	// // }
	//				
	// grid.add(lblPlaneta);
	// grid.add(lblPlanetaValue);
	// grid.add(lblSector);
	// grid.add(lblSectorValue);
	// grid.add(lblFecha);
	// grid.add(lblFechaValue);
	//			
	// grid.setStyle(GUIStyles.DEFAULT_STYLE);
	// grid.setHeight(new Extent(300));
	// contentPane2.add(grid);
	// splitPane.add(contentPane2);
	// add(splitPane);
	//		
	// }

	public Label getLblAlias() {
		return lblAlias;
	}

	public void setLblAlias(Label lblAlias) {
		this.lblAlias = lblAlias;
	}

	public IPlanetaDO getPlaneta() {
		return planeta;
	}

	public void setPlaneta(IPlanetaDO planeta) {
		this.planeta = planeta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Label getLblFechaValue() {
		return lblFechaValue;
	}

	public void setLblFechaValue(Label lblFechaValue) {
		this.lblFechaValue = lblFechaValue;
	}

//	public Label getLblMisionesValue() {
//		return lblMisionesValue;
//	}
//
//	public void setLblMisionesValue(Label lblMisionesValue) {
//		this.lblMisionesValue = lblMisionesValue;
//	}

	public Label getLblSectorValue() {
		return lblSectorValue;
	}

	public void setLblSectorValue(Label lblSectorValue) {
		this.lblSectorValue = lblSectorValue;
	}

	public Label getLblPlanetaValue() {
		return lblPlanetaValue;
	}

	public void setLblPlanetaValue(Label lblPlanetaValue) {
		this.lblPlanetaValue = lblPlanetaValue;
	}

}