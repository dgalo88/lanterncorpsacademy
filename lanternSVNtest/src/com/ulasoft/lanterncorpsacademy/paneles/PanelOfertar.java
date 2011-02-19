package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelOfertar extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private Grid gridBotones;
	private Row rowSel;
	private Row rowAsignar;

	public PanelOfertar() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		Column colPane = new Column();
		colPane.setInsets(new Insets(20, 20, 20, 20));

		Grid gridTitulo = new Grid();
		gridTitulo.setWidth(new Extent(400));
		gridTitulo.setHeight(new Extent(40));
		gridTitulo.setColumnWidth(1, new Extent(50, Extent.PERCENT));
		gridTitulo.setColumnWidth(2, new Extent(50, Extent.PERCENT));
		gridTitulo.setBorder(new Border(1, Color.BLACK, Border.STYLE_INSET));
		gridTitulo.setBackground(Color.WHITE);

		gridBotones = new Grid();
		gridBotones.setWidth(new Extent(400));
		gridBotones.setHeight(new Extent(50));
		gridBotones.setColumnWidth(1, new Extent(50, Extent.PERCENT));
		gridBotones.setColumnWidth(2, new Extent(50, Extent.PERCENT));
		gridBotones.setBorder(new Border(1, Color.BLACK, Border.STYLE_INSET));
		gridBotones.setBackground(new Color(230, 230, 230));

		col.add(PanelConstructor.initTopRow("Realizar Oferta"));

		gridTitulo.add(PanelConstructor.initTopRow("Artículo", Color.BLACK, 14));
		gridTitulo.add(PanelConstructor.initTopRow("Precio", Color.BLACK, 14));
		colPane.add(gridTitulo);

		rowSel = new Row();
		rowSel.setAlignment(Alignment.ALIGN_CENTER);

		Button btnSeleccionar = new Button("Seleccionar");
		btnSeleccionar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		Estilo.setFont(btnSeleccionar, GUIStyles.NORMAL, 12);
		btnSeleccionar.setWidth(new Extent(90));
		btnSeleccionar.setHeight(new Extent(15));
		btnSeleccionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnSeleccionarClicked();
			}
		});
		rowSel.add(btnSeleccionar);
		gridBotones.add(rowSel);

		rowAsignar = new Row();
		rowAsignar.setAlignment(Alignment.ALIGN_CENTER);

		Button btnAsignar = new Button("Asignar");
		btnAsignar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		Estilo.setFont(btnAsignar, GUIStyles.NORMAL, 12);
		btnAsignar.setWidth(new Extent(90));
		btnAsignar.setHeight(new Extent(15));
		btnAsignar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAsignarClicked();
			}
		});
		rowAsignar.add(btnAsignar);
		gridBotones.add(rowAsignar);

		colPane.add(gridBotones);
		col.add(colPane);

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancelar.setWidth(new Extent(100));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				app.getDesktop().btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

		Button btnAceptar = new Button("Aceptar");
		btnAceptar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAceptar.setWidth(new Extent(100));
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAceptarClicked();
			}
		});
		row.add(btnAceptar);

		col.add(row);
		add(col);

	}

	// --------------------------------------------------------------------------------

	protected void btnAceptarClicked() {

		//

	}


	private void btnSeleccionarClicked() {

		gridBotones.removeAll();
		rowSel = new Row();
		rowSel.setAlignment(Alignment.ALIGN_CENTER);
		rowSel.add(PanelConstructor.initTopRow("Selección", Color.BLACK, 14));
		gridBotones.add(rowSel);
		gridBotones.add(rowAsignar);

	}

	private void btnAsignarClicked() {

		gridBotones.removeAll();
		rowAsignar = new Row();
		rowAsignar.setAlignment(Alignment.ALIGN_CENTER);
		rowAsignar.add(PanelConstructor.initTopRow("Precio", Color.BLACK, 14));
		gridBotones.add(rowSel);
		gridBotones.add(rowAsignar);

	}

}
