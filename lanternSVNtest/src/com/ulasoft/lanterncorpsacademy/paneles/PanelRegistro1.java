package com.ulasoft.lanterncorpsacademy.paneles;

import java.sql.SQLException;

import lcaInterfaceDAO.IPersonajeDO;
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

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.Registro;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelRegistro1 extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();

	private IUsuarioDO usuario;
	private IPersonajeDO personaje;

	private TextField txtAlias;
	private TextField txtNombre;
	private TextField txtCorreo;
	private PasswordField fldPass;
	private PasswordField fldConfirmPass;

	private Column col;
	private Row errorRow;

	public PanelRegistro1(IUsuarioDO usuarioNuevo, IPersonajeDO personajeNuevo) //
			throws Exception {

		usuario = usuarioNuevo;
		personaje = personajeNuevo;

		Row row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		Row rowBotones = new Row();
		rowBotones.setCellSpacing(new Extent(10));
		rowBotones.setAlignment(Alignment.ALIGN_CENTER);

		col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));
		col.setBackground(Color.WHITE);

		Grid gridPane = new Grid(1);
		gridPane.setHeight(new Extent(100));
		gridPane.setInsets(new Insets(10, 10, 10, 10));

		Grid grid = new Grid();
		grid.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		grid.setWidth(new Extent(500));

		col.add(initTopRow("Registro de Usuario", 16));
		col.add(initTopRow("Datos Personales:", 14));

		Label lblAlias = new Label("Nombre de Usuario");
		Estilo.setFont(lblAlias, GUIStyles.NORMAL);
		grid.add(lblAlias);

		txtAlias = new TextField();
		txtAlias.setToolTipText("Nombre con el que otros jugadores te verán en el universo.");
		txtAlias.setWidth(new Extent(300));
		txtAlias.setText(personaje.getAlias());
		grid.add(txtAlias);

		Label lblNombre = new Label("Nombre");
		Estilo.setFont(lblNombre, GUIStyles.NORMAL);
		grid.add(lblNombre);

		txtNombre = new TextField();
		txtNombre.setWidth(new Extent(300));
		txtNombre.setText(usuario.getNombre());
		grid.add(txtNombre);

		Label lblCorreo = new Label("Correo");
		Estilo.setFont(lblCorreo, GUIStyles.NORMAL);
		grid.add(lblCorreo);

		txtCorreo = new TextField();
		txtCorreo.setWidth(new Extent(300));
		txtCorreo.setText(usuario.getCorreo());
		grid.add(txtCorreo);

		Label lblPass = new Label("Contraseña");
		Estilo.setFont(lblPass, GUIStyles.NORMAL);
		grid.add(lblPass);

		fldPass = new PasswordField();
		fldPass.setWidth(new Extent(300));
		grid.add(fldPass);

		Label lblConfirmPass = new Label("Confirmar Contraseña");
		Estilo.setFont(lblConfirmPass, GUIStyles.NORMAL);
		grid.add(lblConfirmPass);

		fldConfirmPass = new PasswordField();
		fldConfirmPass.setWidth(new Extent(300));
		grid.add(fldConfirmPass);

		gridPane.add(grid);
		col.add(gridPane);

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnCancelarClicked();
			}
		});
		rowBotones.add(btnCancelar);

		Button btnNext = new Button("Siguiente");
		btnNext.setStyle(Estilo.getStyleColor(app.getAtributos()));
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
		rowBotones.add(btnNext);

		col.add(rowBotones);
		row.add(col);
		add(row);

	}

	// --------------------------------------------------------------------------------

	private Row initTopRow(String texto, int size) {

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);
		Label lblTitle = new Label(texto);
		lblTitle.setForeground(Color.BLACK);
		Estilo.setFont(lblTitle, GUIStyles.BOLD, size);
		row.add(lblTitle);
		return row;

	}

	// --------------------------------------------------------------------------------

	private void btnCancelarClicked() {

		PanelLogin pnlMain = new PanelLogin();
		d.setPanelCentral(pnlMain);

	}

	private void btnNextClicked() throws ClassNotFoundException, Exception {

		usuario.setNombre(txtNombre.getText());
		usuario.setCorreo(txtCorreo.getText());

		if ((txtAlias.getText()) == "") {
			d.setWindowPaneEmergente("Escoge el alias para tu personaje!");
			return;
		}

		personaje.setAlias(txtAlias.getText());

		if (Registro.verificarAlias(personaje.getAlias())) {
			d.setWindowPaneEmergente("Ya existe un jugador con ese alias.");
			return;
		}

		if (!(fldConfirmPass.getText().equals(fldPass.getText()))) { // JUL:defensive..
			if (col.getComponentCount() > 3) {
				System.out.println("COL:" + col.getComponentCount());
				col.remove(errorRow);
			}
			errorRow = new Row();
			Label lblErr = new Label("Por favor confirma tu contraseña.");
			Estilo.setFont(lblErr, GUIStyles.ITALIC);
			errorRow.add(lblErr);
			errorRow.setAlignment(Alignment.ALIGN_CENTER);
			col.add(errorRow);
			fldPass.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			fldConfirmPass.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			return;
		}

		try {

			if (Registro.verificarCorreo(usuario.getCorreo())) {
				if (col.getComponentCount() > 3) {
					System.out.println("COL:" + col.getComponentCount());
					col.remove(errorRow);
				}
				errorRow = new Row();
				Label lblErr = new Label("Ya existe una cuenta con ese correo.");
				Estilo.setFont(lblErr, GUIStyles.ITALIC);
				errorRow.add(lblErr);
				errorRow.setAlignment(Alignment.ALIGN_CENTER);
				col.add(errorRow);
				txtCorreo.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Si no hay campos vacíos proceder a la siguiente etapa del registro
		if (!(checkEmptyFields())) {

			usuario.setClave(fldPass.getText());
			PanelRegistro2 pnlregistro2 = new PanelRegistro2(usuario, personaje);
			d.setPanelCentral(pnlregistro2);

		}

	}

	// --------------------------------------------------------------------------------

	private boolean checkEmptyFields() {

		boolean flg = false;
		if (txtAlias.getText() == "") {
			txtAlias.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			flg = true;
		}

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
			Estilo.setFont(lblErr, GUIStyles.ITALIC);
			errorRow.add(lblErr);
			errorRow.setAlignment(Alignment.ALIGN_CENTER);
			col.add(errorRow);
			return true;
		}

		return false;
	}

}
