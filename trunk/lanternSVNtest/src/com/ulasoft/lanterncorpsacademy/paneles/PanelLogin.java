package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.ArrayList;
import java.util.List;

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
import com.valkirye.lanterncorpsacademy.extras.ObjectLca;
import com.valkirye.lanterncorpsacademy.extras.ObjectSelectModel;
import com.valkirye.lanterncorpsacademy.extras.ObjectSelectScrolling;
import com.valkirye.lanterncorpsacademy.extras.TestCellRenderer;

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
		row.setStyle(GUIStyles.STYLECENTERROW);

		Column col = new Column();
		col.setInsets(new Insets(5, 5, 5, 5));
		col.setCellSpacing(new Extent(10));
		col.setBackground(Color.WHITE);

		Label lblTitle = new Label("Ingresar al Sistema");
		Estilo.setFont(lblTitle, GUIStyles.BOLD);
		row.add(lblTitle);
		col.add(row);

		Grid grid = new Grid();
		grid.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));

		Label lblCorreo = new Label("Correo");
		Estilo.setFont(lblCorreo, GUIStyles.BOLD);
		grid.add(lblCorreo);
		txtCorreo = new TextField();
		txtCorreo.setWidth(new Extent(300));
		txtCorreo.setText("");
		Estilo.setFont(lblCorreo, GUIStyles.NORMAL);
		grid.add(txtCorreo);

		Label lblPass = new Label("Contraseña");
		Estilo.setFont(lblPass, GUIStyles.BOLD);
		grid.add(lblPass);
		fldPass = new PasswordField();
		fldPass.setWidth(new Extent(300));
		grid.add(fldPass);
		col.add(grid);

		row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setStyle(GUIStyles.STYLECENTERROW);

		Button btnEnter = new Button("Entrar");
		btnEnter.setStyle(Estilo.getStyleColor(app.getAtributos()));
		Estilo.setFont(btnEnter, GUIStyles.NORMAL);
		btnEnter.setWidth(new Extent(80));
		btnEnter.setHeight(new Extent(20));
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
		row.add(btnEnter);

		Button btnRegister = new Button("Registrarse");
		btnRegister.setStyle(Estilo.getStyleColor(app.getAtributos()));
		Estilo.setFont(btnRegister, GUIStyles.NORMAL);
		btnRegister.setWidth(new Extent(80));
		btnRegister.setHeight(new Extent(20));
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
		row.add(btnRegister);

		col.add(row);

//		List<ObjectLca> list = new ArrayList<ObjectLca>();
//		for (int i = 0; i < 10; i++) {
//			ObjectLca item = new ObjectLca(i);
//			list.add(item);
//		}
//
//		ObjectSelectModel oModel = new ObjectSelectModel(list);
//		TestCellRenderer tcr = new TestCellRenderer();
//		ObjectSelectScrolling oSelectScrolling = new ObjectSelectScrolling(oModel, tcr);
//		col.add(oSelectScrolling);

		row = new Row();
		row.setStyle(GUIStyles.STYLECENTERROW);

		row.add(col);
		add(row);

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
					"La informacion de correo o Contraseña proporcionada no es Correcta.");
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
