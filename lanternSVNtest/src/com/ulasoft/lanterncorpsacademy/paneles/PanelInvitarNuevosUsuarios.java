package com.ulasoft.lanterncorpsacademy.paneles;

import com.ulasoft.lanterncorpsacademy.GUIStyles;

import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.PasswordField;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextArea;
import nextapp.echo.app.TextField;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

public class PanelInvitarNuevosUsuarios extends Panel{
	
	public  PanelInvitarNuevosUsuarios() {
		Column col = new Column();
		col.setInsets(new Insets(5,5,5,5));
		col.setCellSpacing(new Extent(10));
		col.setBackground(Color.WHITE);
		
		Label lblTitle = new Label("Invitar Nuevos Usuarios");
	    col.add(lblTitle);
	    
		Grid grid = new Grid();
		grid.setStyle(GUIStyles.DEFAULT_STYLE);
		Label lblCorreo = new Label("Nombre");
	    grid.add(lblCorreo);
	    
	    TextField txtCorreo = new TextField();
	    txtCorreo.setWidth(new Extent(300));
	    grid.add(txtCorreo);
	    
	    Label lblPass = new Label("Correo");
	    grid.add(lblPass);
	    
	    TextField fldPass = new TextField();
	    fldPass.setWidth(new Extent(300));
	    grid.add(fldPass);
	
	    Label lblConfirPass = new Label("Comentarios");
	    grid.add(lblConfirPass);
	    
	    TextArea fldConfirPass = new TextArea();
	    fldConfirPass.setWidth(new Extent(300));
	    grid.add(fldConfirPass);
	    
		col.add(grid);
		
		Row row = new Row();
		Button btnGuardar = new Button("Enviar Invitacion");
	    btnGuardar.setStyle(GUIStyles.STYLE2);
	    btnGuardar.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	        btnGuardarClicked();
	      }
	    });
	    row.add(btnGuardar);
	    row.setCellSpacing(new Extent(10));
		col.add(row);
		col.setBorder(new Border(3, new Color(0x00, 0x00, 0x00), Border.STYLE_SOLID));
		add(col);
	}

	protected void btnGuardarClicked() {
		// TODO Auto-generated method stub
		
	}


}
