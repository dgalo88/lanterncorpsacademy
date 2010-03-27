package com.ulasoft.lanterncorpsacademy;

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

public class PanelRegistro2 extends Panel {

	public PanelRegistro2() {
		
		Row row1 = new Row();
		
		row1.setCellSpacing(new Extent(400));
		
		
		Label lbl = new Label("");
		row1.add(lbl);
		
		Column col = new Column();
		col.setInsets(new Insets(5,5,5,5));
		col.setCellSpacing(new Extent(50));
		col.setBackground(Color.WHITE);
		
		Label lblTitle = new Label("REGISTRO");
	    col.add(lblTitle);
	    
		Grid grid = new Grid();
		grid.setStyle(GUIStyles.DEFAULT_STYLE);
		
		ButtonGroup btnGroupClases = new ButtonGroup();
		
		RadioButton btnRadioVerde = new RadioButton("Verde - Green Lantern Corps");
		btnGroupClases.addButton(btnRadioVerde);
		
		RadioButton btnRadioAmarillo = new RadioButton("Amarillo - Sinestro Corps");
		btnGroupClases.addButton(btnRadioAmarillo);
		
		RadioButton btnRadioNegro = new RadioButton("Negro - Black Lantern Corps");
		btnGroupClases.addButton(btnRadioNegro);
		
		RadioButton btnRadioRojo = new RadioButton("Rojo - Red Lantern Corps");
		btnGroupClases.addButton(btnRadioRojo);
		
		RadioButton btnRadioAzul = new RadioButton("Azul - Blue Lantern Corps");
		btnGroupClases.addButton(btnRadioAzul);
		
		RadioButton btnRadioIndigo = new RadioButton("Indigo - La Tribu Indigo");
		btnGroupClases.addButton(btnRadioIndigo);
		
		RadioButton btnRadioVioleta = new RadioButton("Violeta - Star Sapphires");
		btnGroupClases.addButton(btnRadioVioleta);
		
		//grid.add(btnGroupClases);
	        
	    grid.setColumnWidth(1, new Extent(600));
	    col.add(grid);
		
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
		
		    
	    //btnNext.setAlignment(new Alignment(Alignment.ALIGN_RIGHT, Alignment.BOTTOM));
	    row.add(btnBack);
	    row.add(btnSend);
	    row.setCellSpacing(new Extent(10));
		col.add(row);
		row1.add(col);
		
		add(row1);
		
		}	
	
}
