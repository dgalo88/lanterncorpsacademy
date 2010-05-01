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

		
		row.add(btnBack);
		row.add(btnSend);
		row.setCellSpacing(new Extent(10));
		col.add(row);
		row1.add(col);
		add(row1);

	}
	
	
	private AccordionPane initClases() {
		
		AccordionPane clases = new AccordionPane();
		ButtonGroup btnGroupClases = new ButtonGroup();

		// ------------------------------------------------------------------------------

		RadioButton btnRadioVerde = new RadioButton("Verde - Green Lantern Corps");
		btnGroupClases.addButton(btnRadioVerde);
		AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
		acc.setTitle("Verde - Green Lantern Corps");
		ContentPane cp = new ContentPane();
		cp.setLayoutData(acc);
		cp.add(btnRadioVerde);
		cp.setBackground(Color.WHITE);
		clases.add(cp);

		// ------------------------------------------------------------------------------

		RadioButton btnRadioAmarillo = new RadioButton("Amarillo - Sinestro Corps");
		btnGroupClases.addButton(btnRadioAmarillo);
		AccordionPaneLayoutData acc1 = new AccordionPaneLayoutData();
		acc1.setTitle("Amarillo - Sinestro Corps");
		ContentPane cp1 = new ContentPane();
		cp1.setLayoutData(acc1);
		cp1.add(btnRadioAmarillo);
		cp1.setBackground(Color.WHITE);
		clases.add(cp1);

		// ------------------------------------------------------------------------------

		RadioButton btnRadioNegro = new RadioButton("Negro - Black Lantern Corps");
		btnGroupClases.addButton(btnRadioNegro);
		AccordionPaneLayoutData acc2 = new AccordionPaneLayoutData();
		acc2.setTitle("Negro - Black Lantern Corps");
		ContentPane cp2 = new ContentPane();
		cp2.setLayoutData(acc2);
		cp2.add(btnRadioNegro);
		cp2.setBackground(Color.WHITE);
		clases.add(cp2);

		// ------------------------------------------------------------------------------

		RadioButton btnRadioRojo = new RadioButton("Rojo - Red Lantern Corps");
		btnGroupClases.addButton(btnRadioRojo);
		AccordionPaneLayoutData acc3 = new AccordionPaneLayoutData();
		acc3.setTitle("Rojo - Red Lantern Corps");
		ContentPane cp3 = new ContentPane();
		cp3.setLayoutData(acc3);
		cp3.add(btnRadioRojo);
		cp3.setBackground(Color.WHITE);
		clases.add(cp3);

		// ------------------------------------------------------------------------------

		RadioButton btnRadioAzul = new RadioButton("Azul - Blue Lantern Corps");
		btnGroupClases.addButton(btnRadioAzul);
		AccordionPaneLayoutData acc4 = new AccordionPaneLayoutData();
		acc4.setTitle("Azul - Blue Lantern Corps");
		ContentPane cp4 = new ContentPane();
		cp4.setLayoutData(acc4);
		cp4.add(btnRadioAzul);
		cp4.setBackground(Color.WHITE);
		clases.add(cp4);
		
		//------------------------------------------------------------------------------

		RadioButton btnRadioIndigo = new RadioButton("Indigo - La Tribu Indigo");
		btnGroupClases.addButton(btnRadioIndigo);
		AccordionPaneLayoutData acc5 = new AccordionPaneLayoutData();
		acc5.setTitle("Indigo - La Tribu Indigo");
		ContentPane cp5 = new ContentPane();
		cp5.setLayoutData(acc5);
		cp5.add(btnRadioIndigo);
		cp5.setBackground(Color.WHITE);
		clases.add(cp5);

		//------------------------------------------------------------------------------

		RadioButton btnRadioVioleta = new RadioButton("Violeta - Star Sapphires");
		btnGroupClases.addButton(btnRadioVioleta);
		AccordionPaneLayoutData acc6 = new AccordionPaneLayoutData();
		acc6.setTitle("Violeta - Star Sapphires");
		ContentPane cp6 = new ContentPane();
		cp6.setLayoutData(acc6);
		cp6.add(btnRadioVioleta);
		cp6.setBackground(Color.WHITE);
		clases.add(cp6);
		
		//------------------------------------------------------------------------------
		
		clases.setAnimationTime(300);
		clases.set(PROPERTY_BORDER, Border.STYLE_SOLID);
		
		
		return clases;
		
	}

}
