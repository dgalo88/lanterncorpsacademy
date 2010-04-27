package com.ulasoft.lanterncorpsacademy.paneles;

import com.ulasoft.lanterncorpsacademy.GUIStyles;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
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
//		ContentPane cp = new ContentPane();
//		Column colo1 = new Column();
//		Label prueba = new Label("Funcionaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//		colo1.add(prueba);
//		cp.add(colo1);
//		acc.setTitle("assassaadjjl");
//		cp.setLayoutData(acc);
//		clases.add(cp);
//		
		//clases.setLayoutData(acc);
		
		
//		ButtonGroup btnGroupClases = new ButtonGroup();
		RadioButton btnRadioVerde = new RadioButton("Verde - Green Lantern Corps");
//		btnGroupClases.addButton(btnRadioVerde);
		AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
		acc.setTitle("Verde - Green Lantern Corps");
		ContentPane cp = new ContentPane();
		cp.setLayoutData(acc);
		cp.add(btnRadioVerde);

		clases.add(cp);
//
		RadioButton btnRadioAmarillo = new RadioButton("Amarillo - Sinestro Corps");
//		btnGroupClases.addButton(btnRadioAmarillo);
		AccordionPaneLayoutData acc1 = new AccordionPaneLayoutData();
		acc1.setTitle("Amarillo - Sinestro Corps");
		ContentPane cp1 = new ContentPane();
		cp1.setLayoutData(acc1);
		cp1.add(btnRadioAmarillo);

		clases.add(cp1);
	

		RadioButton btnRadioNegro = new RadioButton("Negro - Black Lantern Corps");
//		btnGroupClases.addButton(btnRadioNegro);
		AccordionPaneLayoutData acc2 = new AccordionPaneLayoutData();
		acc2.setTitle("Negro - Black Lantern Corps");
		ContentPane cp2 = new ContentPane();
		cp2.setLayoutData(acc2);
		cp2.add(btnRadioNegro);

		clases.add(cp2);		


		RadioButton btnRadioRojo = new RadioButton("Rojo - Red Lantern Corps");
//		btnGroupClases.addButton(btnRadioRojo);
		AccordionPaneLayoutData acc3 = new AccordionPaneLayoutData();
		acc3.setTitle("Rojo - Red Lantern Corps");
		ContentPane cp3 = new ContentPane();
		cp3.setLayoutData(acc3);
		cp3.add(btnRadioRojo);

		clases.add(cp3);


		RadioButton btnRadioAzul = new RadioButton("Azul - Blue Lantern Corps");
//		btnGroupClases.addButton(btnRadioAzul);
		AccordionPaneLayoutData acc4 = new AccordionPaneLayoutData();
		acc4.setTitle("Azul - Blue Lantern Corps");
		ContentPane cp4 = new ContentPane();
		cp4.setLayoutData(acc4);
		cp4.add(btnRadioAzul);

		clases.add(cp4);
		
		
		RadioButton btnRadioIndigo = new RadioButton("Indigo - La Tribu Indigo");
//		btnGroupClases.addButton(btnRadioIndigo);
		AccordionPaneLayoutData acc5 = new AccordionPaneLayoutData();
		acc5.setTitle("Indigo - La Tribu Indigo");
		ContentPane cp5 = new ContentPane();
		cp5.setLayoutData(acc5);
		cp5.set(PROPERTY_BACKGROUND, Color.LIGHTGRAY);
		cp5.add(btnRadioIndigo);

		clases.add(cp5);
		
		RadioButton btnRadioVioleta = new RadioButton("Violeta - Star Sapphires");
//		btnGroupClases.addButton(btnRadioVioleta);
		AccordionPaneLayoutData acc6 = new AccordionPaneLayoutData();
		acc6.setTitle("Violeta - Star Sapphires");
		ContentPane cp6 = new ContentPane();
		cp6.setLayoutData(acc6);
		cp6.set(PROPERTY_BACKGROUND, Color.LIGHTGRAY);
		cp6.add(btnRadioVioleta);

		clases.add(cp6);
		
		//grid.add(btnGroupClases);

//		grid.setColumnWidth(1, new Extent(600));
//		col.add(clases); TODO:no funciona yet
		

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
