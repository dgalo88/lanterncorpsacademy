package com.ulasoft.lanterncorpsacademy.paneles;

import java.sql.Date;

import lcaInterfaceDAO.IPlanetaDO;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Font;
import nextapp.echo.app.Grid;
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
public class PanelMain extends Panel {

	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
		.getActive();
	private Label lblAlias;
	private IPlanetaDO planeta;
	private Date fecha;
	private Label lblFechaValue;
//	private Label lblMisionesValue;
	private Label lblSectorValue;
	private Label lblPlanetaValue;
	private Label lblUbicacion;
	private Label lblEstadisticas;
	private Label lblFecha;
	
	public PanelMain() {

		Row row = new Row();
		row.setStyle(GUIStyles.STYLECENTERROW);
		
		Column col = new Column();
		col.setStyle(GUIStyles.STYLECENTERROW);
		
		Grid grid = new Grid(2);
		grid.setBackground(Color.WHITE);
		
		Column colInf = new Column();
		
		Label lblImagen = new Label();
		lblImagen.setIcon(new ResourceImageReference(ImgLoad.panelMain(app
				.getAtributos().getPersonaje())//
				, new Extent(236), new Extent(360)));
		grid.add(lblImagen);
		
		lblAlias = new Label("alias");
		lblAlias.setForeground(new Color(255, 255, 255));
		lblAlias.set(PROPERTY_FONT, Font.BOLD);
		
		lblPlanetaValue = new Label("PL");
		lblSectorValue = new Label("00");
		lblFechaValue = new Label("Ult Ing");
		
		LanternCorpsAcademyApp lca = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
				.getActive();
		Atributos atrib = lca.getAtributos();
		
		try {
			atrib.updatePanelMain(this);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		col.add(lblAlias);
		
		lblUbicacion = new Label("UBICACIÓN ACTUAL");
		lblUbicacion.set(PROPERTY_FONT, Font.BOLD);
		colInf.add(lblUbicacion);
		colInf.add(new Label("Planeta:"));
		colInf.add(lblPlanetaValue);
		colInf.add(new Label("Sector:"));
		colInf.add(lblSectorValue);
		colInf.add(new Label("Dueño:"));
		
		lblEstadisticas = new Label("ESTADÍSTICAS");
		colInf.add(lblEstadisticas);
		lblEstadisticas.set(PROPERTY_FONT, Font.BOLD);
		colInf.add(lblEstadisticas);
		colInf.add(new Label("Combates Ganados:"));
		colInf.add(new Label("Combates Perdidos:"));
		colInf.add(new Label("Planetas Conquistados:"));
		
		lblFecha = new Label("ÚLTIMO ACCESO");
		colInf.add(lblFecha);
		lblFecha.set(PROPERTY_FONT, Font.BOLD);
		colInf.add(lblFecha);
		colInf.add(new Label("Fecha:"));
		colInf.add(lblFechaValue);
		
		grid.add(colInf);
		col.add(grid);

		Row rowBotones = new Row();
		rowBotones.setStyle(GUIStyles.STYLECENTERROW);
		rowBotones.setCellSpacing(new Extent(10));
		
		Button btnPlanetaCasa = new Button("Definir Planeta Casa");
		btnPlanetaCasa.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnPlanetaCasa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				btnPlanetaCasaClicked();
			}
		});
		rowBotones.add(btnPlanetaCasa);
		
		Button btnAsignarDefensas = new Button("Asignar Defensas");
		btnAsignarDefensas.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnAsignarDefensas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
		//		btnAsignarDefensasClicked();
			}
		});
		rowBotones.add(btnAsignarDefensas);
		
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