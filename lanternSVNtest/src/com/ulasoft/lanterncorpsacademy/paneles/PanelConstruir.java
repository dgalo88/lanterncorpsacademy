package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelConstruir extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private Grid gridUnits;
	private Grid gridData;
	private Column colInfo;
	private Row rowInfo;

	public PanelConstruir() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Grid gridPane = new Grid(1);
		gridPane.setInsets(new Insets(20, 20, 20, 20));
		gridPane.setBackground(Color.WHITE);

		gridUnits = new Grid(4);
		gridUnits.setWidth(new Extent(500));
		gridUnits.setHeight(new Extent(80));
		gridUnits.setBackground(Estilo.getRolloverColor(app.getAtributos()));
		gridUnits.setBorder(new Border(1, Color.BLACK, Border.STYLE_SOLID));
		gridUnits.setColumnWidth(1, new Extent(25, Extent.PERCENT));
		gridUnits.setColumnWidth(2, new Extent(25, Extent.PERCENT));
		gridUnits.setColumnWidth(3, new Extent(25, Extent.PERCENT));
		gridUnits.setColumnWidth(4, new Extent(25, Extent.PERCENT));

		gridData = new Grid(2);
		gridData.setWidth(new Extent(500));
//		gridData.setHeight(new Extent(40));
		gridData.setColumnWidth(1, new Extent(50, Extent.PERCENT));
		gridData.setColumnWidth(2, new Extent(50, Extent.PERCENT));

		colInfo = new Column();
		colInfo.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		col.add(PanelConstructor.initTopRow("Construir Ejército"));

		Label lblUnidadesAtacante = new Label( //
				"Unidades Básicas Seleccionadas");
		Estilo.setFont(lblUnidadesAtacante, GUIStyles.ITALIC);
		row.add(lblUnidadesAtacante);
		gridPane.add(row);

		Button btnRobot = new Button("Robot");
		btnRobot.setTextAlignment(Alignment.ALIGN_CENTER);
		Estilo.setFont(btnRobot, GUIStyles.ITALIC, 12);
		btnRobot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				btnAtacarClicked();
			}
		});
		gridUnits.add(btnRobot);

		Button btnVehiculo = new Button("Vehículo");
		btnVehiculo.setTextAlignment(Alignment.ALIGN_CENTER);
		Estilo.setFont(btnVehiculo, GUIStyles.ITALIC, 12);
		btnVehiculo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				btnAtacarClicked();
			}
		});
		gridUnits.add(btnVehiculo);

		Button btnArma = new Button("Arma");
		btnArma.setTextAlignment(Alignment.ALIGN_CENTER);
		Estilo.setFont(btnArma, GUIStyles.ITALIC, 12);
		btnArma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				btnAtacarClicked();
			}
		});
		gridUnits.add(btnArma);

		Button btnMunicion = new Button("Munición");
		btnMunicion.setTextAlignment(Alignment.ALIGN_CENTER);
		Estilo.setFont(btnMunicion, GUIStyles.ITALIC, 12);
		btnMunicion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				btnAtacarClicked();
			}
		});
		gridUnits.add(btnMunicion);

		gridPane.add(gridUnits);

//		Label lblImagen = new Label(new ResourceImageReference( //
//				"/com/ulasoft/lanterncorpsacademy/imagenes/ring2.png"));
//		gridData.add(lblImagen);

		rowInfo = new Row();
		rowInfo.setAlignment(Alignment.ALIGN_CENTER);

		Button btnImagen = new Button("Seleccione Imagen");
		btnImagen.setTextAlignment(Alignment.ALIGN_CENTER);
		btnImagen.setWidth(new Extent(150));
		btnImagen.setHeight(new Extent(150));
		btnImagen.setBackground(Estilo.getRolloverColor(app.getAtributos()));
		btnImagen.setBorder(new Border(1, Color.BLACK, Border.STYLE_SOLID));
		Estilo.setFont(btnImagen, GUIStyles.ITALIC, 12);
		btnImagen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				btnAtacarClicked();
			}
		});
		rowInfo.add(btnImagen);
		gridData.add(rowInfo);

		rowInfo = new Row();
		rowInfo.setAlignment(Alignment.ALIGN_CENTER);

		TextField textField = new TextField();
		textField.setText("");
		textField.setWidth(new Extent(80));
		rowInfo.add(textField);
		colInfo.add(rowInfo);

		rowInfo = new Row();
		rowInfo.setAlignment(Alignment.ALIGN_CENTER);

		Label lblAtaque = new Label("Ataque: XX");
		Estilo.setFont(lblAtaque, GUIStyles.NORMAL, 12);
		rowInfo.add(lblAtaque);
		colInfo.add(rowInfo);

		rowInfo = new Row();
		rowInfo.setAlignment(Alignment.ALIGN_CENTER);

		Label lblDefensa = new Label("Defensa: XX");
		Estilo.setFont(lblDefensa, GUIStyles.NORMAL, 12);
		rowInfo.add(lblDefensa);
		colInfo.add(rowInfo);

		gridData.add(colInfo);
		gridPane.add(gridData);
		col.add(gridPane);

		col.add(gridPane);

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);
		row.setCellSpacing(new Extent(10));

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancelar.setWidth(new Extent(120));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				app.getDesktop().btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

		Button btnConstruir = new Button("Construir");
		btnConstruir.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnConstruir.setWidth(new Extent(120));
		btnConstruir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnConstruirClicked();
			}
		});
		row.add(btnConstruir);

		col.add(row);
		add(col);
	}

	// --------------------------------------------------------------------------------

	private void btnConstruirClicked() {

		PanelAtacarDuenoPlaneta pnlMain = new PanelAtacarDuenoPlaneta();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);

	}

}
