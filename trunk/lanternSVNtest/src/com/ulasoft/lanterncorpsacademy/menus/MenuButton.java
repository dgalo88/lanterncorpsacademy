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
	
	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();
	
	public MenuButton() {

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_RIGHT);

		Button btnInvitarAmigo = new Button("Invitar Amigo");
		btnInvitarAmigo.setStyle(Estilo.getStyleColor(app.getAtributos()));
		Estilo.setFont(btnInvitarAmigo, GUIStyles.BOLD, 12);
		btnInvitarAmigo.setWidth(new Extent(110));
		btnInvitarAmigo.setHeight(new Extent(15));
		btnInvitarAmigo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnInvitarAmigoClicked();
			}
		});
		row.add(btnInvitarAmigo);

		Button btnSalir = new Button("Salir");
		btnSalir.setStyle(Estilo.getStyleColor(app.getAtributos()));
		Estilo.setFont(btnSalir, GUIStyles.BOLD, 12);
		btnSalir.setWidth(new Extent(110));
		btnSalir.setHeight(new Extent(15));
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnSalirClicked();
			}
		});
		row.add(btnSalir);

		add(row);
	}

	// --------------------------------------------------------------------------------

	private void btnInvitarAmigoClicked() {

		PanelInvitarNuevosUsuarios pnlMain = new PanelInvitarNuevosUsuarios();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnSalirClicked() {

		// El usuario está haciendo logout,
		// así que ponemos los atributos a null
		// en la aplicación después de guardarlos en BD.
		try {
			app.getAtributos().guardarAtts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		app.setAtributos(null);

		d.removeAll();
		Desktop desktop = app.getDesktop();
		d.add(desktop.initTemplate1());
	}

}
