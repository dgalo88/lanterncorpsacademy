package com.ulasoft.lanterncorpsacademy.paneles;

import com.ulasoft.lanterncorpsacademy.GUIStyles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.ImageReference;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

public class PanelRecargarAnillo extends Panel{

	public PanelRecargarAnillo() {
		Column col = new Column();
		col.setInsets(new Insets(2,2,2,2));
		
		col.add(new Label("Recarga de Anillo"));
		
		Label lblImagen = new Label(); 
		lblImagen.setIcon(new ResourceImageReference("com/ulasoft/lanterncorpsacademy/imagenes/jim-lee-green-lantern.jpg",new Extent(152), new Extent(232)));
		col.add(lblImagen);
		
		col.add(new Label("Nivel	xx"));
		
		Row row = new Row(); 
		
		Button btnCargarBatPrin = new Button("Cargar con Bateria Central");
		btnCargarBatPrin.setStyle(GUIStyles.DEFAULT_STYLE);
		btnCargarBatPrin.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	    	  btnCargarBatPrinClicked();
	      }
	    });
	    row.add(btnCargarBatPrin);
		
	    Button btnCargarBatPort = new Button("Cargar con Bateria Portatil");
	    btnCargarBatPort.setStyle(GUIStyles.DEFAULT_STYLE);
	    btnCargarBatPort.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	    	  btnCargarBatPortClicked();
	      }
	    });
	    row.add(btnCargarBatPort);
	    
	    col.add(row);
	    col.setBackground(Color.WHITE);
	    this.add(col);
	}

	protected void btnCargarBatPortClicked() {
		// TODO Auto-generated method stub
		
	}

	protected void btnCargarBatPrinClicked() {
		// TODO Auto-generated method stub
		
	}
}
