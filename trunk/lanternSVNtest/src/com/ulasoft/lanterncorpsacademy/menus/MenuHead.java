package com.ulasoft.lanterncorpsacademy.menus;

import nextapp.echo.app.Button;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.paneles.PanelLogin;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class MenuHead extends Panel {

	public LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
			.getActive();


	public MenuHead() {
		Row row = new Row();
		row.setStyle(GUIStyles.STYLEMENUI);

		Button btnRing = new Button();
		btnRing.setIcon(new ResourceImageReference(
				"com/ulasoft/lanterncorpsacademy/imagenes/linterna.png"));
		btnRing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRingClicked();
			}
		});
		row.add(btnRing);

		add(row);
	}



	// -------------------------------------------------------------------------------

	private void btnRingClicked() {
		PanelLogin pnlMain = new PanelLogin();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);
	}

}
