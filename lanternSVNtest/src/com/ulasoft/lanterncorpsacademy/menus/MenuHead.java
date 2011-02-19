package com.ulasoft.lanterncorpsacademy.menus;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Extent;
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

@SuppressWarnings("serial")
public class MenuHead extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private MenuStatus menuStatus;

	public MenuHead(final boolean loged) {

		Row row = new Row();
		row.setCellSpacing(new Extent(4));

		Button btnRing = new Button();

		if (loged) {

			row.setAlignment(Alignment.ALIGN_LEFT);

			btnRing.setIcon(new ResourceImageReference( //
					ImgLoad.menuHead(app.getAtributos().getPersonaje()), //
					new Extent(120), new Extent(120)));
		} else {

			row.setAlignment(Alignment.ALIGN_CENTER);

			btnRing.setIcon(new ResourceImageReference( //
					"com/ulasoft/lanterncorpsacademy/imagenes/ring2.png", //
					new Extent(120), new Extent(120)));
		}

		btnRing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRingClicked(loged);
			}
		});
		row.add(btnRing);

		if (loged) {
			menuStatus = new MenuStatus();
			try {
				app.getAtributos().updateMenuStatus(menuStatus);
			} catch (Exception e) {
				e.printStackTrace();
			}
			row.add(menuStatus);
		}

		add(row);
	}

	// -------------------------------------------------------------------------------

	private void btnRingClicked(final boolean loged) {

		Desktop d = app.getDesktop();
		Panel pnlMain;
		pnlMain = loged ? new PanelMain() : new PanelLogin();
		d.setPanelCentral(pnlMain);

	}

	// -------------------------------------------------------------------------------

	public MenuStatus getMenuStatus() {
		return menuStatus;
	}

	public void setMenud(MenuStatus menuStatus) {
		this.menuStatus = menuStatus;
	}

}
