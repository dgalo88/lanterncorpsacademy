package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.ImgLoad;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelAtacarDuenoPlaneta extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

//	private IPlanetaDO planeta;
	private Label lblAlias = new Label("Dueño de Planeta");
	private Label lblClase = new Label("Black Lantern Corp");
	private Label lblNivel = new Label("50000");

	public PanelAtacarDuenoPlaneta() {

//		Atributos atrib = app.getAtributos();

		Row row = new Row();
		Row rowBotones = new Row();
		rowBotones.setAlignment(Alignment.ALIGN_CENTER);
		rowBotones.setCellSpacing(new Extent(5));

		Column col = new Column();
		col.setCellSpacing(new Extent(10));
		Column colPane = new Column();
		colPane.setInsets(new Insets(10, 10, 10, 10));
		colPane.setCellSpacing(new Extent(10));
		Column colInf [] = new Column [4];
		for (int i = 0; i < colInf.length; i++) {
			colInf[i] = new Column();
		}

		Grid grid = new Grid(2);
		grid.setBackground(Color.WHITE);

		Label lblImagen = new Label();
		lblImagen.setIcon(new ResourceImageReference(ImgLoad.panelConquistar(4), //
				new Extent(200), new Extent(325)));
		grid.add(lblImagen);

//		lblAlias = new Label("");
//		lblClase = new Label("");
//		lblNivel = new Label("");

//		try {
//			atrib.updatePanelConquistar(this);
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}

		Label lblDuenoPlaneta = new Label("Dueño del Planeta:");
		Estilo.setFont(lblDuenoPlaneta, GUIStyles.BOLD);
		colInf[0].add(lblDuenoPlaneta);
		Estilo.setFont(lblAlias, GUIStyles.NORMAL);
		colInf[0].add(lblAlias);

		colPane.add(colInf[0]);

		Label lblClaseTitle = new Label("Clase:");
		Estilo.setFont(lblClaseTitle, GUIStyles.BOLD);
		colInf[1].add(lblClaseTitle);
		Estilo.setFont(lblClase, GUIStyles.NORMAL);
		colInf[1].add(lblClase);

		colPane.add(colInf[1]);

		Label lblNivelTitle = new Label("Nivel:");
		Estilo.setFont(lblNivelTitle, GUIStyles.BOLD);
		colInf[2].add(lblNivelTitle);
		Estilo.setFont(lblNivel, GUIStyles.NORMAL);
		colInf[2].add(lblNivel);

		colPane.add(colInf[2]);

		Label lblEstadisticas = new Label("Estadísticas");
		Estilo.setFont(lblEstadisticas, GUIStyles.BOLD);
		colInf[3].add(lblEstadisticas);

		Label lblCombatesGanados = new Label("Combates Ganados:");
		Estilo.setFont(lblCombatesGanados, GUIStyles.NORMAL);
		colInf[3].add(lblCombatesGanados);

		Label lblCombatesPerdidos = new Label("Combates Perdidos:");
		Estilo.setFont(lblCombatesPerdidos, GUIStyles.NORMAL);
		colInf[3].add(lblCombatesPerdidos);

		Label lblPlanetasConquistados = new Label("Planetas Conquistados:");
		Estilo.setFont(lblPlanetasConquistados, GUIStyles.NORMAL);
		colInf[3].add(lblPlanetasConquistados);

		colPane.add(colInf[3]);

		grid.add(colPane);
		col.add(grid);

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnCancelar.setWidth(new Extent(160));
		btnCancelar.setHeight(new Extent(20));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnCancelarClicked();
			}
		});
		rowBotones.add(btnCancelar);

		Button btnAtacar = new Button("Atacar");
		btnAtacar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnAtacar.setWidth(new Extent(160));
		btnAtacar.setHeight(new Extent(20));
		btnAtacar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					btnAtacarClicked();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		rowBotones.add(btnAtacar);

		col.add(rowBotones);
		row.add(col);
		add(row);

	}

	// --------------------------------------------------------------------------------

//	public IPlanetaDO getPlaneta() {
//		return planeta;
//	}
//
//	public void setPlaneta(IPlanetaDO planeta) {
//		this.planeta = planeta;
//	}
//
//	public void setLblAlias(Label lblAlias) {
//		this.lblAlias = lblAlias;
//	}
//
//	public Label getLblAlias() {
//		return lblAlias;
//	}
//
//	public void setLblClase(Label lblClase) {
//		this.lblClase = lblClase;
//	}
//
//	public Label getLblClase() {
//		return lblClase;
//	}
//
//	public void setLblNivel(Label lblNivel) {
//		this.lblNivel = lblNivel;
//	}
//
//	public Label getLblNivel() {
//		return lblNivel;
//	}

	// --------------------------------------------------------------------------------

	private void btnCancelarClicked() {

		PanelMain pnlMain = new PanelMain();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnAtacarClicked() throws Exception {

		PanelMain pnlMain = new PanelMain();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);

	}

}