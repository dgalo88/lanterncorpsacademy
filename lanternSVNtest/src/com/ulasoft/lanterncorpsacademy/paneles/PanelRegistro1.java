package com.ulasoft.lanterncorpsacademy.paneles;

import java.awt.Font;
import java.sql.SQLException;

import lcaInterfaceDAO.IUsuarioDAO;
import lcaInterfaceDAO.IUsuarioDO;
import nextapp.echo.app.Alignment;
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
import com.ulasoft.lanterncorpsacademy.GUIStyles;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import echopoint.layout.HtmlLayoutData;
import factory.GlobalDAOFactory;

@SuppressWarnings("serial")
public class PanelRegistro1 extends Panel {

	public HtmlLayoutData hld = new HtmlLayoutData("main");
	private IUsuarioDO usuarioNuevo;
	private TextField txtNombre;
	private TextField txtCorreo;
	private PasswordField fldPass;
	private PasswordField fldConfirmPass;
	private Grid grid;
	private Column col;
	private Row errorRow;

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public PanelRegistro1(IUsuarioDO usuario) throws Exception{

	    usuarioNuevo = usuario;

		Row row1 = new Row();
		row1.setStyle(GUIStyles.STYLE3);

		col = new Column();
		col.setInsets(new Insets(5, 5, 5, 5));
		col.setCellSpacing(new Extent(50));
		col.setBackground(Color.WHITE);

		Label lblTitle = new Label("REGISTRO");
		lblTitle.setTextAlignment(Alignment.ALIGN_CENTER);
		col.add(lblTitle);

		grid = new Grid();
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
		btnNext.setAlignment(Alignment.ALIGN_RIGHT);
		row.add(btnNext);
		col.add(row);

		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnNextClicked();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

		row1.add(col);
		add(row1);

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	private void btnNextClicked() throws ClassNotFoundException, Exception {

		usuarioNuevo.setNombre(txtNombre.getText());
		usuarioNuevo.setCorreo(txtCorreo.getText());

		if (!(fldConfirmPass.getText().equals(fldPass.getText()))) { // JUL:defensive..
			if (col.getComponentCount() > 3) {
				System.out.println("COL:" + col.getComponentCount());
				col.remove(errorRow);
			}
			errorRow = new Row();
			Label lblErr = new Label("Por favor confirme su contraseña.");
			lblErr.set(PROPERTY_FONT, Font.BOLD);
			errorRow.add(lblErr);
			errorRow.setAlignment(Alignment.ALIGN_CENTER);
			col.add(errorRow);
			fldPass.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			fldConfirmPass.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			return;
		}

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		IUsuarioDAO usuarioDAO = (IUsuarioDAO) GlobalDAOFactory.getDAO(IUsuarioDAO.class, connectionBean);

		try {

			if (usuarioDAO.checkIfUsuarioExists(usuarioNuevo.getCorreo())) {
				if (col.getComponentCount() > 3) {
					System.out.println("COL:" + col.getComponentCount());
					col.remove(errorRow);
				}
				errorRow = new Row();
				errorRow.add(new Label("Ya existe una cuenta con ese correo."));
				col.add(errorRow);
				txtCorreo.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Si no hay campos vacios proceder a la siguiente etapa del registro

		if (!(checkEmptyFields())) {
			usuarioNuevo.setClave(fldPass.getText());
			// removeAll();
			PanelRegistro pr = (PanelRegistro) getParent();
			PanelRegistro2 pnlMain = new PanelRegistro2(pr.getPersonaje());
			// pnlMain.setLayoutData(hld);
			pnlMain.set(PROPERTY_HEIGHT, new Extent(400));
			pnlMain.set(PROPERTY_WIDTH, new Extent(900));
			// add(pnlMain);
			pr.setUsuario(usuarioNuevo);
			pr.changePanel(pnlMain);
		}

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	private boolean checkEmptyFields() {

		boolean flg = false;
		if (txtNombre.getText() == "") {
			txtNombre.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			flg = true;
		}

		if (txtCorreo.getText() == "") {
			txtCorreo.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			flg = true;
		}
		if (fldPass.getText() == "") {
			fldPass.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			flg = true;
		}
		if (fldConfirmPass.getText() == "") {
			fldConfirmPass.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			flg = true;
		}

		if (flg) {
			if (col.getComponentCount() > 3) {
				System.out.println("COL:" + col.getComponentCount());
				col.remove(errorRow);
			}
			errorRow = new Row();
			Label lblErr = new Label("Todos los campos son obligatorios.");
			lblErr.set(PROPERTY_FONT, Font.BOLD);
			errorRow.add(lblErr);
			errorRow.setAlignment(Alignment.ALIGN_CENTER);
			col.add(errorRow);
			return true;
		}

		return false;
	}

}
