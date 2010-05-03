package com.ulasoft.lanterncorpsacademy.paneles;

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
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import com.ulasoft.lanterncorpsacademy.GUIStyles;
import dao.lca.UsuarioDO;
import echopoint.layout.HtmlLayoutData;

@SuppressWarnings("serial")
public class PanelRegistro1 extends Panel {
	
	public HtmlLayoutData hld = new HtmlLayoutData("main");
	public UsuarioDO usuarioNuevo;
	public TextField txtNombre;
	public TextField txtCorreo;
	public PasswordField fldPass;
	public PasswordField fldConfirmPass;
	
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public PanelRegistro1(UsuarioDO usuario) {

		usuarioNuevo = usuario;
		
		Row row1 = new Row();
		row1.setStyle(GUIStyles.STYLE3);

		Column col = new Column();
		col.setInsets(new Insets(5, 5, 5, 5));
		col.setCellSpacing(new Extent(50));
		col.setBackground(Color.WHITE);

		Label lblTitle = new Label("REGISTRO");
		col.add(lblTitle);

		Grid grid = new Grid();
		grid.setStyle(GUIStyles.DEFAULT_STYLE);

		Label lblNombre = new Label("Nombre");
		grid.add(lblNombre);
		txtNombre = new TextField();
		txtNombre.setWidth(new Extent(400));
		txtNombre.setText(usuarioNuevo.getNombre());
		grid.add(txtNombre);
		

		Label lblCorreo = new Label("Correo");
		grid.add(lblCorreo);
		txtCorreo = new TextField();
		txtCorreo.setWidth(new Extent(400));
		txtCorreo.setText(usuarioNuevo.getCorreo());
		grid.add(txtCorreo);

		Label lblPass = new Label("Contraseña");
		grid.add(lblPass);
		fldPass = new PasswordField();
		fldPass.setWidth(new Extent(400));
		grid.add(fldPass);

		Label lblConfirmPass = new Label("Confirmar Contraseña");
		grid.add(lblConfirmPass);
		fldConfirmPass = new PasswordField();
		fldConfirmPass.setWidth(new Extent(400));
		grid.add(fldConfirmPass);

		grid.setColumnWidth(1, new Extent(600));
		col.add(grid);

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		Button btnNext = new Button("Siguiente");
		btnNext.setStyle(GUIStyles.STYLE);
		row.add(btnNext);
		col.add(row);
		
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnNextClicked();
			}

		});

		row1.add(col);
		add(row1);
		
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	private void btnNextClicked() {
		
		
		usuarioNuevo.setNombre(txtNombre.getText());
		usuarioNuevo.setCorreo(txtCorreo.getText());
		
		
		if (fldConfirmPass.getText().equals(fldPass.getText())) {
			usuarioNuevo.setClave(fldPass.getText());
			removeAll();
			PanelRegistro2 pnlMain = new PanelRegistro2(usuarioNuevo);
			pnlMain.setLayoutData(hld);
			pnlMain.set(PROPERTY_HEIGHT, new Extent(400));
			pnlMain.set(PROPERTY_WIDTH, new Extent(900));
			add(pnlMain);
		
		} else {
//			ContentPane cp = new ContentPane();
//			WindowPane wrongPasswdPane = new WindowPane();
//			wrongPasswdPane.setModal(true);
//			wrongPasswdPane.setTitle("Error");
//			wrongPasswdPane.add(new Label("Las contraseñas no concuerdan"));
//			cp.add(wrongPasswdPane);
//			add(cp); FIXME : JOSE 
		}
			


	}

}
