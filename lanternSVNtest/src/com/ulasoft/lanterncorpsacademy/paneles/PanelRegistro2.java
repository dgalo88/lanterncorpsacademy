package com.ulasoft.lanterncorpsacademy.paneles;

import com.ulasoft.lanterncorpsacademy.GUIStyles;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.PasswordField;
import nextapp.echo.app.RadioButton;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
import nextapp.echo.app.button.ButtonGroup;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.extras.app.AccordionPane;
import nextapp.echo.extras.app.layout.AccordionPaneLayoutData;

public class PanelRegistro2 extends Panel {

	public PanelRegistro2() {

		Row row1 = new Row();
		row1.setStyle(GUIStyles.STYLE3);

		Column col = new Column();
		col.setInsets(new Insets(5, 5, 5, 5));
		col.setCellSpacing(new Extent(50));
		col.setBackground(Color.WHITE);

		Label lblTitle = new Label("REGISTRO");
		col.add(lblTitle);

//		Grid grid = new Grid();
//		grid.setStyle(GUIStyles.DEFAULT_STYLE);
		
		AccordionPane clases = new AccordionPane();
		Column colo1 = new Column();
		Label prueba = new Label("Funcionaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		colo1.add(prueba);
		AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
		acc.setTitle("assassaadjjl");
		colo1.setLayoutData(acc);
		clases.add(colo1);
		
		//clases.setLayoutData(acc);
		
		
//		ButtonGroup btnGroupClases = new ButtonGroup();
//		RadioButton btnRadioVerde = new RadioButton("Verde - Green Lantern Corps");
//		btnGroupClases.addButton(btnRadioVerde);
//		
//		clases.add(btnRadioVerde);
//
//		RadioButton btnRadioAmarillo = new RadioButton("Amarillo - Sinestro Corps");
//		btnGroupClases.addButton(btnRadioAmarillo);
//		
//		clases.add(btnRadioAmarillo);
//
//		RadioButton btnRadioNegro = new RadioButton("Negro - Black Lantern Corps");
//		btnGroupClases.addButton(btnRadioNegro);
//		
//		clases.add(btnRadioNegro);
//
//		RadioButton btnRadioRojo = new RadioButton("Rojo - Red Lantern Corps");
//		btnGroupClases.addButton(btnRadioRojo);
//		
//		clases.add(btnRadioRojo);
//
//		RadioButton btnRadioAzul = new RadioButton("Azul - Blue Lantern Corps");
//		btnGroupClases.addButton(btnRadioAzul);
//		
//		clases.add(btnRadioAzul);
//
//		RadioButton btnRadioIndigo = new RadioButton("Indigo - La Tribu Indigo");
//		btnGroupClases.addButton(btnRadioIndigo);
//		
//		clases.add(btnRadioIndigo);
//
//		RadioButton btnRadioVioleta = new RadioButton("Violeta - Star Sapphires");
//		btnGroupClases.addButton(btnRadioVioleta);
//		
//		clases.add(btnRadioVioleta);

		
		//grid.add(btnGroupClases);

//		grid.setColumnWidth(1, new Extent(600));
//		col.add(grid);
		

		Row row = new Row();
		Button btnBack = new Button("Atras");
		btnBack.setStyle(GUIStyles.STYLE);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnBackClicked();
			}

			private void btnBackClicked() {
				removeAll();
				PanelRegistro1 pnlMain = new PanelRegistro1();
				add(pnlMain);
			}
		});

		Button btnSend = new Button("Enviar");
		btnSend.setStyle(GUIStyles.STYLE);
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnSendClicked();
			}

			private void btnSendClicked() {
				// TODO Auto-generated method stub

			}
		});

		// btnNext.setAlignment(new Alignment(Alignment.ALIGN_RIGHT,
		// Alignment.BOTTOM));
		row.add(btnBack);
		row.add(btnSend);
		row.setCellSpacing(new Extent(10));
		col.add(row);
		row1.add(col);

		add(clases);
		//add(row1);

	}

}
