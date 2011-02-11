package com.ulasoft.lanterncorpsacademy.menus;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelInvitarNuevosUsuarios;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class MenuButton extends Panel {
	
	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
		.getActive();
	private Desktop d = app.getDesktop();
	
	public MenuButton() {
		Row row = new Row();
		row.setStyle(GUIStyles.STYLEBUTTON);

		Button btnInvitarNuevosUsuarios = new Button("Invitar Nuevos Usuarios");
		btnInvitarNuevosUsuarios.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnInvitarNuevosUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnInvitarNuevosUsuariosClicked();
			}
		});
		btnInvitarNuevosUsuarios.setAlignment(Alignment.ALIGN_RIGHT);
		row.add(btnInvitarNuevosUsuarios);

		Button btnExit = new Button("Exit");
		btnExit.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnExit.setWidth(new Extent(60));
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnExitClicked();
			}
		});
		btnInvitarNuevosUsuarios.setAlignment(Alignment.ALIGN_RIGHT);
		row.add(btnExit);

		add(row);
	}

	// --------------------------------------------------------------------------------

	private void btnInvitarNuevosUsuariosClicked() {

		PanelInvitarNuevosUsuarios pnlMain = new PanelInvitarNuevosUsuarios();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnExitClicked() {

		// El usuario está haciendo logout, así que ponemos los atributos a null
		// en la aplicación
		// después de guardarlos en BD..
		try {
			app.getAtributos().guardarAtts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		app.setAtributos(null);

		Desktop desktop = app.getDesktop();
		d.removeAll();
		d.add(desktop.initTemplate1());
	}

}
