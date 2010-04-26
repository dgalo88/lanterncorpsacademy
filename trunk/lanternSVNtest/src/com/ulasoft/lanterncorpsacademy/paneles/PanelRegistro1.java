package com.ulasoft.lanterncorpsacademy.paneles;

import com.ulasoft.lanterncorpsacademy.GUIStyles;
import echopoint.layout.HtmlLayoutData;
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
import nextapp.echo.app.TextField;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

@SuppressWarnings("serial")
public class PanelRegistro1 extends Panel {
	
	public HtmlLayoutData hld = new HtmlLayoutData("main");
	
	public PanelRegistro1() {
		
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
		TextField txtNombre = new TextField();
		txtNombre.setWidth(new Extent(400));
		grid.add(txtNombre);

		Label lblApellido = new Label("Apellido");
		grid.add(lblApellido);
		TextField txtApellido = new TextField();
		txtApellido.setWidth(new Extent(400));
		grid.add(txtApellido);

		Label lblAlias = new Label("Nickname");
		grid.add(lblAlias);
		TextField txtAlias = new TextField();
		txtAlias
				.setToolTipText("Nombre con el que otros jugadores te verán en el universo.");
		txtAlias.setWidth(new Extent(400));
		grid.add(txtAlias);

		Label lblCorreo = new Label("Correo");
		grid.add(lblCorreo);
		TextField txtCorreo = new TextField();
		txtCorreo.setWidth(new Extent(400));
		grid.add(txtCorreo);

		Label lblPass = new Label("Contraseña");
		grid.add(lblPass);
		PasswordField fldPass = new PasswordField();
		fldPass.setWidth(new Extent(400));
		grid.add(fldPass);

		Label lblConfirmPass = new Label("Confirmar Contraseña");
		grid.add(lblConfirmPass);
		PasswordField fldConfirmPass = new PasswordField();
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

	private void btnNextClicked() {
		removeAll();
		PanelRegistro2 pnlMain = new PanelRegistro2();
		add(pnlMain);

	}

}
