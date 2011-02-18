package com.ulasoft.lanterncorpsacademy.paneles;

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
import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.Login;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

import factory.GlobalDOFactory;

@SuppressWarnings("serial")
public class PanelLogin extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop desktop;

	private IUsuarioDO usuario;
	private IPersonajeDO personaje;
	private TextField txtCorreo;
	private PasswordField fldPass;

	public PanelLogin() {

		Row row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		Row rowBotones = new Row();
		rowBotones.setCellSpacing(new Extent(10));
		rowBotones.setAlignment(Alignment.ALIGN_CENTER);

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));
		col.setBackground(Color.WHITE);

		Grid gridPane = new Grid(1);
		gridPane.setHeight(new Extent(100));
		gridPane.setInsets(new Insets(10, 10, 10, 10));

		Grid grid = new Grid();
		grid.setWidth(new Extent(410));
		grid.setHeight(new Extent(25));
		grid.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));

		col.add(initTopRow());

		Label lblCorreo = new Label("Correo");
		Estilo.setFont(lblCorreo, GUIStyles.BOLD);
		grid.add(lblCorreo);

		txtCorreo = new TextField();
		txtCorreo.setWidth(new Extent(300));
		txtCorreo.setText("");
		grid.add(txtCorreo);

		Label lblPass = new Label("Contraseña");
		Estilo.setFont(lblPass, GUIStyles.BOLD);
		grid.add(lblPass);

		fldPass = new PasswordField();
		fldPass.setWidth(new Extent(300));
		grid.add(fldPass);

		gridPane.add(grid);
		col.add(gridPane);

		Button btnEnter = new Button("Entrar");
		btnEnter.setStyle(Estilo.getStyleColor(app.getAtributos()));
		Estilo.setFont(btnEnter, GUIStyles.BOLD);
		btnEnter.setWidth(new Extent(120));
		btnEnter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					btnEnterClicked();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		rowBotones.add(btnEnter);

		Button btnRegister = new Button("Registrarse");
		btnRegister.setStyle(Estilo.getStyleColor(app.getAtributos()));
		Estilo.setFont(btnRegister, GUIStyles.BOLD);
		btnRegister.setWidth(new Extent(120));
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					btnRegisterClicked();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		rowBotones.add(btnRegister);

		col.add(rowBotones);
		row.add(col);
		add(row);

	}

	// --------------------------------------------------------------------------------

	private Row initTopRow() {

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);
		Label lblTitle = new Label("Ingresar al Sistema");
		lblTitle.setForeground(Color.BLACK);
		Estilo.setFont(lblTitle, GUIStyles.BOLD, 16);
		row.add(lblTitle);
		return row;

	}

	// --------------------------------------------------------------------------------

	protected void btnRegisterClicked() throws Exception {

		IUsuarioDO usuario = (IUsuarioDO) //
			GlobalDOFactory.getDO(IUsuarioDO.class);
		IPersonajeDO personaje = (IPersonajeDO) //
			GlobalDOFactory.getDO(IPersonajeDO.class);

		PanelRegistro1 pnlMain = new PanelRegistro1(usuario, personaje);
		desktop = app.getDesktop();
		desktop.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnEnterClicked() throws Exception {

		// TODO: verifica campos vacíos antes de enviar...
		usuario = Login.verificarLogin(txtCorreo.getText(), fldPass.getText());
		desktop = app.getDesktop();

		if (usuario == null) {
			desktop.setWindowPaneEmergente( //
					"La información de correo o contraseña proporcionada no es correcta.");
			return;
		}

		personaje = Login.cargarPersonaje( //
				usuario.getPersonajeRef().getRefIdent());
		System.err.println("PERSONAJE ID en PanelLogin: " + personaje.getId());

		Atributos atrib = new Atributos(); // FIXME: FIXMEEEEEEEEE
		atrib.setPersonaje(personaje);
		atrib.setUsuario(usuario);
		app.setAtributos(atrib);
		desktop.removeAll();
		desktop.add(desktop.initTemplate2());
	}

}
