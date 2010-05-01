package com.ulasoft.lanterncorpsacademy.paneles;

import java.awt.Component;

import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.RadioButton;
import nextapp.echo.app.Row;
import nextapp.echo.app.button.ButtonGroup;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.extras.app.AccordionPane;
import nextapp.echo.extras.app.layout.AccordionPaneLayoutData;

import com.ulasoft.lanterncorpsacademy.GUIStyles;

public class PanelRegistro2 extends Panel {

	public PanelRegistro2() {

		Row row1 = new Row();
		row1.setStyle(GUIStyles.STYLE3);

		// ------------------------------------------------------------------------------

		Column col = new Column();
		col.setInsets(new Insets(7, 7, 7, 7));
		col.setCellSpacing(new Extent(150));
		col.setBackground(Color.WHITE);

		// ------------------------------------------------------------------------------

		Label lblTitle = new Label("REGISTRO");
		col.add(lblTitle);

		// ------------------------------------------------------------------------------

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

		// ------------------------------------------------------------------------------

		Button btnSend = new Button("Enviar");
		btnSend.setStyle(GUIStyles.STYLE);
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnSendClicked();
			}

			private void btnSendClicked() {
			
			}
		});

		// ------------------------------------------------------------------------------

//		row.add(btnBack);
//		row.add(btnSend);
//		row.setCellSpacing(new Extent(10));
//		col.add(row);
//		row1.add(col);
//		add(row1);
		
		AccordionPane claseslinternas = initclases();
		add(claseslinternas);

	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	private ButtonGroup initgroup() {
		
		ButtonGroup btnGroupClases = new ButtonGroup();
		RadioButton btnRadioVerde = new RadioButton();
		btnGroupClases.addButton(btnRadioVerde);
		RadioButton btnRadioAmarillo = new RadioButton();
		btnGroupClases.addButton(btnRadioAmarillo);
		RadioButton btnRadioNegro = new RadioButton();
		btnGroupClases.addButton(btnRadioNegro);
		RadioButton btnRadioRojo = new RadioButton();
		btnGroupClases.addButton(btnRadioRojo);
		RadioButton btnRadioAzul = new RadioButton();
		btnGroupClases.addButton(btnRadioAzul);
		RadioButton btnRadioIndigo = new RadioButton();
		btnGroupClases.addButton(btnRadioIndigo);
		RadioButton btnRadioVioleta = new RadioButton();
		btnGroupClases.addButton(btnRadioVioleta);
		
		return btnGroupClases;

		
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	private AccordionPane initclases() {
		
		AccordionPane clases = new AccordionPane();

		// ------------------------------------------------------------------------------

		
		// ------------------------------------------------------------------------------

		AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
		acc.setTitle("Verde - Green Lantern Corps");
		ContentPane cp = new ContentPane();
		cp.setLayoutData(acc);
		cp.setBackground(Color.WHITE);
		clases.add(cp);

		// ------------------------------------------------------------------------------
		
		AccordionPaneLayoutData acc1 = new AccordionPaneLayoutData();
		acc1.setTitle("Amarillo - Sinestro Corps");
		ContentPane cp1 = new ContentPane();
		cp1.setLayoutData(acc1);
		cp1.setBackground(Color.WHITE);
		clases.add(cp1);

		// ------------------------------------------------------------------------------

		AccordionPaneLayoutData acc2 = new AccordionPaneLayoutData();
		acc2.setTitle("Negro - Black Lantern Corps");
		ContentPane cp2 = new ContentPane();
		cp2.setLayoutData(acc2);
		cp2.setBackground(Color.WHITE);
		clases.add(cp2);

		// ------------------------------------------------------------------------------

		AccordionPaneLayoutData acc3 = new AccordionPaneLayoutData();
		acc3.setTitle("Rojo - Red Lantern Corps");
		ContentPane cp3 = new ContentPane();
		cp3.setLayoutData(acc3);
		cp3.setBackground(Color.WHITE);
		clases.add(cp3);

		// ------------------------------------------------------------------------------


		AccordionPaneLayoutData acc4 = new AccordionPaneLayoutData();
		acc4.setTitle("Azul - Blue Lantern Corps");
		ContentPane cp4 = new ContentPane();
		cp4.setLayoutData(acc4);
		cp4.setBackground(Color.WHITE);
		clases.add(cp4);
		
		//------------------------------------------------------------------------------

//		AccordionPaneLayoutData acc5 = new AccordionPaneLayoutData();
//		acc5.setTitle("Indigo - La Tribu Indigo");
//		ContentPane cp5 = new ContentPane();
//		cp5.setLayoutData(acc5);
//		cp5.setBackground(Color.WHITE);
//		clases.add(cp5);
//
//		//------------------------------------------------------------------------------
//
//		AccordionPaneLayoutData acc6 = new AccordionPaneLayoutData();
//		acc6.setTitle("Violeta - Star Sapphires");
//		ContentPane cp6 = new ContentPane();
//		cp6.setLayoutData(acc6);
//		cp6.setBackground(Color.WHITE);
//		clases.add(cp6);
		
		//------------------------------------------------------------------------------
			
		
		clases.setAnimationTime(300);
		clases.set(PROPERTY_BORDER, Border.STYLE_SOLID);
		
		
		return clases;
		
	}

}
