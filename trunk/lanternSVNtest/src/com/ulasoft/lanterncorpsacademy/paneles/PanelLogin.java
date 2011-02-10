package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUsuarioDO;
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
import com.valkirye.lanterncorpsacademy.extras.ItemPrb;
import com.valkirye.lanterncorpsacademy.extras.ObjectSelect;
import com.valkirye.lanterncorpsacademy.extras.ObjectSelectModel;
import com.valkirye.lanterncorpsacademy.extras.ObjectSelectScrolling;
import com.valkirye.lanterncorpsacademy.extras.TestCellRenderer;

import factory.GlobalDOFactory;

@SuppressWarnings("serial")
public class PanelLogin extends Panel {

	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
			.getActive();
	private IUsuarioDO usuario;
	private IPersonajeDO personaje;
	private TextField txtCorreo;
	private PasswordField fldPass;
	Desktop desktop;

	public PanelLogin() {

		Row row1 = new Row();
		row1.setStyle(GUIStyles.STYLECENTERROW);
		Column col = new Column();
		col.setInsets(new Insets(5, 5, 5, 5));
		col.setCellSpacing(new Extent(10));
		col.setBackground(Color.WHITE);
		Label lblTitle = new Label("Ingresar al Sistema");
		col.add(lblTitle);
		Grid grid = new Grid();
		grid.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));

		Label lblCorreo = new Label("Correo");
		grid.add(lblCorreo);
		txtCorreo = new TextField();
		txtCorreo.setWidth(new Extent(300));
		txtCorreo.setText("");
		grid.add(txtCorreo);

		Label lblPass = new Label("Contraseña");
		grid.add(lblPass);
		fldPass = new PasswordField();
		fldPass.setWidth(new Extent(300));
		grid.add(fldPass);
		col.add(grid);

		Row row = new Row();

		Button btnClickToEnter = new Button("Entrar");
		btnClickToEnter.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnClickToEnter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnClickToEnterClicked();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		row.add(btnClickToEnter);

		Button btnClickToRegister = new Button("Registrarse");
		btnClickToRegister.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnClickToRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnClickToRegisterClicked();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		row.add(btnClickToRegister);

		row.setCellSpacing(new Extent(10));

		col.add(row);

//		List<ItemPrb> list = new ArrayList<ItemPrb>();
//
//		ItemPrb item0 = new ItemPrb();
//		ItemPrb item1 = new ItemPrb();
//		ItemPrb item2 = new ItemPrb();
//		ItemPrb item3 = new ItemPrb();
//		ItemPrb item4 = new ItemPrb();
//		ItemPrb item5 = new ItemPrb();
//		ItemPrb item6 = new ItemPrb();
//		ItemPrb item7 = new ItemPrb();
//		ItemPrb item8 = new ItemPrb();
//		ItemPrb item9 = new ItemPrb();
//
//		list.add(item0);
//		list.add(item1);
//		list.add(item2);
//		list.add(item3);
//		list.add(item4);
//		list.add(item5);
//		list.add(item6);
//		list.add(item7);
//		list.add(item8);
//		list.add(item9);
//
//		ObjectSelectModel oModel = new ObjectSelectModel(list);
//		ObjectSelect obSel = new ObjectSelect(oModel, new TestCellRenderer());
//		ObjectSelectScrolling oSelectScrolling = new ObjectSelectScrolling(obSel);
//		col.add(oSelectScrolling);

		row1.add(col);
		add(row1);

	}

	// --------------------------------------------------------------------------------

	protected void btnClickToRegisterClicked() throws Exception {
		IUsuarioDO usuario = (IUsuarioDO) GlobalDOFactory
				.getDO(IUsuarioDO.class);
		IPersonajeDO personaje = (IPersonajeDO) GlobalDOFactory
				.getDO(IPersonajeDO.class);
		PanelRegistro1 pnlregistro1 = new PanelRegistro1(usuario, personaje);
		desktop = app.getDesktop();
		desktop.setPanelCentral(pnlregistro1);
	}

	// --------------------------------------------------------------------------------

	private void btnClickToEnterClicked() throws Exception {
		// TODO: verifica campos vacíos antes de enviar...

		usuario = Login.verificarLogin(txtCorreo.getText(), fldPass.getText());
		desktop = app.getDesktop();

		if (usuario == null) {
			desktop.setWindowPaneEmergente("La informacion de correo o Contraseña proporcionada no es Correcta.");
			return;
		}
		personaje = Login.cargarPersonaje(usuario.getPersonajeRef()
				.getRefIdent());
		System.err.println("PERSONAJE ID en PLogin:" + personaje.getId());

		Atributos atts = new Atributos(); // FIXME: FIXMEEEEEEEEE
		atts.setPersonaje(personaje);
		atts.setUsuario(usuario);
		app.setAtributos(atts);
		desktop.removeAll();
		desktop.add(desktop.initTemplate2());
	}

}
