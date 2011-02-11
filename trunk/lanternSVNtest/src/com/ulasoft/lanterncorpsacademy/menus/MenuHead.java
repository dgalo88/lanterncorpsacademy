package com.ulasoft.lanterncorpsacademy.menus;

import nextapp.echo.app.Button;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.ImgLoad;
import com.ulasoft.lanterncorpsacademy.paneles.PanelLogin;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMain;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class MenuHead extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	public MenuHead(final boolean loged) {

		Row row = new Row();
		row.setStyle(GUIStyles.STYLECENTERROW);

		Button btnRing = new Button();
		if (loged) {
			btnRing.setIcon(new ResourceImageReference(ImgLoad.menuHead(app
					.getAtributos().getPersonaje())));
		} else {
			btnRing.setIcon(new ResourceImageReference(
					"com/ulasoft/lanterncorpsacademy/imagenes/linterna.png"));
		}
		btnRing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRingClicked(loged);
			}
		});
		row.add(btnRing);

		add(row);
	}

	// -------------------------------------------------------------------------------

	private void btnRingClicked(final boolean loged) {

		Desktop d = app.getDesktop();
		Panel pnlMain;
		pnlMain = loged ? new PanelMain() : new PanelLogin();
		d.setPanelCentral(pnlMain);

	}

}
