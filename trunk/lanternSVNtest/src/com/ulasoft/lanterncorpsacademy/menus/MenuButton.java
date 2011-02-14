package com.ulasoft.lanterncorpsacademy.menus;

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

		Button btnAmigo = new Button("Invitar Amigo");
		btnAmigo.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnAmigo.setWidth(new Extent(120));
		btnAmigo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnInvitarNuevosUsuariosClicked();
			}
		});
		row.add(btnAmigo);

		Button btnExit = new Button("Salir");
		btnExit.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnExit.setWidth(new Extent(120));
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnExitClicked();
			}
		});
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
