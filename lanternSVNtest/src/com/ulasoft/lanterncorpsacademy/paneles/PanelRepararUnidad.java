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
public class PanelRepararUnidad extends Panel{

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();

	public PanelRepararUnidad() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Column colInfo = new Column();
		colInfo.setCellSpacing(new Extent(5));

		Row row;

		Grid gridPane = new Grid();
		gridPane.setInsets(new Insets(30, 30, 30, 30));
		gridPane.setWidth(new Extent(400));
		gridPane.setColumnWidth(1, new Extent(50, Extent.PERCENT));
		gridPane.setColumnWidth(2, new Extent(50, Extent.PERCENT));
		gridPane.setBackground(Color.WHITE);

		col.add(PanelConstructor.initTopRow("Reparar Unidad"));

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		row.add(new Label(new ResourceImageReference( //
				ImgLoad.menuHead(app.getAtributos().getPersonaje()), //
				new Extent(90), new Extent(90))));
		gridPane.add(row);

		row = new Row();
		row.setInsets(new Insets(5, 5, 5, 5));
		row.setAlignment(Alignment.ALIGN_CENTER);
		row.setBackground(Estilo.getRolloverColor(app.getAtributos()));

		Label lblNombre = new Label("$Nombre");
		Estilo.setFont(lblNombre, GUIStyles.BOLD, 14);
		row.add(lblNombre);
		colInfo.add(row);

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		Label lblDurabilidad = new Label("Durabilidad: xx/yy");
		Estilo.setFont(lblDurabilidad, GUIStyles.NORMAL, 14);
		row.add(lblDurabilidad);
		colInfo.add(row);

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		Label lblAtaque = new Label("Ataque: AA");
		Estilo.setFont(lblAtaque, GUIStyles.NORMAL, 14);
		row.add(lblAtaque);
		colInfo.add(row);

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		Label lblDefensa = new Label("Defensa: DD");
		Estilo.setFont(lblDefensa, GUIStyles.NORMAL, 14);
		row.add(lblDefensa);
		colInfo.add(row);

		gridPane.add(colInfo);
		col.add(gridPane);

		col.add(PanelConstructor.initTopRow( //
				"Costo de Reparación: XX", //
				Estilo.getColor(app.getAtributos()), 14));

		row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancelar.setWidth(new Extent(100));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				d.btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

		Button btnReparar = new Button("Reparar");
		btnReparar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnReparar.setWidth(new Extent(100));
		btnReparar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRepararClicked();
			}
		});
		row.add(btnReparar);

		col.add(row);
		add(col);
	}

	// --------------------------------------------------------------------------------

	protected void btnRepararClicked() {

		//

	}

}
