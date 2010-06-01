package com.ulasoft.lanterncorpsacademy.paneles;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.GUIStyles;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.InvitarNuevosUsuarios;

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
import nextapp.echo.app.PasswordField;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextArea;
import nextapp.echo.app.TextField;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

@SuppressWarnings("serial")
public class PanelInvitarNuevosUsuarios extends Panel{
	
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
	private TextField txtCorreo;
	private TextField txtNombre;
	private TextArea fldComentarios;
	
	public  PanelInvitarNuevosUsuarios() {
		Column col = new Column();
		col.setInsets(new Insets(5,5,5,5));
		col.setCellSpacing(new Extent(10));
		col.setBackground(Color.WHITE);
		
		Label lblTitle = new Label("Invitar Nuevos Usuarios");
	    col.add(lblTitle);
	    
		Grid grid = new Grid();
		grid.setStyle(GUIStyles.DEFAULT_STYLE);
		Label lblNombre = new Label("Nombre");
	    grid.add(lblNombre);
	    
	    txtNombre = new TextField();
	    txtNombre.setWidth(new Extent(300));
	    grid.add(txtNombre);
	    
	    Label lblPass = new Label("Correo");
	    grid.add(lblPass);
	    
	    txtCorreo = new TextField();
	    txtCorreo.setWidth(new Extent(300));
	    grid.add(txtCorreo);
	
	    Label lblComentarios = new Label("Comentarios");
	    grid.add(lblComentarios);
	    
	    fldComentarios = new TextArea();
	    fldComentarios.setWidth(new Extent(300));
	    grid.add(fldComentarios);
		col.add(grid);
		
		Row row = new Row();
		Button btnEnviarInvitacion = new Button("Enviar Invitacion");
	    btnEnviarInvitacion.setStyle(GUIStyles.STYLE2);
	    btnEnviarInvitacion.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	        btnEnviarInvitacionClicked();
	      }
	    });
	    row.add(btnEnviarInvitacion);
	    row.setCellSpacing(new Extent(10));
	    row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);
		col.setBorder(new Border(3, new Color(0x00, 0x00, 0x00), Border.STYLE_SOLID));
		add(col);
	}

	protected void btnEnviarInvitacionClicked() {
		Desktop d = app.getDesktop();
		String campo=InvitarNuevosUsuarios.checkEmptyFields(txtCorreo , txtNombre , fldComentarios);
		if(campo!=null){
			d.setWindowPaneEmergente(campo);
			return;
		}
	}
}



