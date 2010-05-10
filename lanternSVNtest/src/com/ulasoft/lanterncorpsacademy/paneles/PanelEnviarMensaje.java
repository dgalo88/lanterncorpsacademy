package com.ulasoft.lanterncorpsacademy.paneles;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.GUIStyles;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextArea;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

public class PanelEnviarMensaje extends Panel {
	
	public PanelEnviarMensaje(){
		Column col = new Column();
		Row row1 = new Row();
		row1.setStyle(GUIStyles.DEFAULT_STYLE);
		Label lblTitle = new Label("Enviar Mensaje al Grupo:");
		row1.add(lblTitle);
		col.add(row1);
		
		Row row2 = new Row();
		TextArea texArea = new TextArea();
		texArea.setHeight(new Extent(300));
		texArea.setWidth(new Extent(600));
		row2.setBackground(Color.WHITE);
	    row2.setAlignment(Alignment.ALIGN_CENTER);
		row2.add(texArea);
		col.setBorder(new Border(3, new Color(0x00, 0x00, 0x00), Border.STYLE_SOLID));
		col.add(row2);
		
		Row row = new Row();
		
		Button btnCancelar = new Button("Cancelar");
	    btnCancelar.setStyle(GUIStyles.STYLE2);
	    btnCancelar.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	    	  btnCancelarClicked();
	      }
	    });
	    
	    row.add(btnCancelar);
	    
		Button btnEnviar = new Button("Enviar");
	    btnEnviar.setStyle(GUIStyles.STYLE2);
	    btnEnviar.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	    	  btnEnviarClicked();
	      }
	    });
	    
	    row.add(btnEnviar);
	    row.setAlignment(Alignment.ALIGN_CENTER);
	    col.add(row);
		add(col);
	}
	
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
	Desktop d = app.getDesktop();

	protected void btnEnviarClicked() {
		// TODO Auto-generated method stub
		
	}

	protected void btnCancelarClicked() {
		PanelMensaje pnlMain = new PanelMensaje();
		d.setPanelCentral(pnlMain);	
	}

}
