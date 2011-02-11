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
public class MenuHeadViejo extends Panel {

	public LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
			.getActive();

	// public Desktop d = app.getDesktop();

	public MenuHeadViejo() {
		Row row = new Row();
		row.setStyle(GUIStyles.STYLEMENUI);
		// row.setInsets(new Insets(125, 1, 1, 1));

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

//		Label lblBienvenido = new Label("BIENVENIDO A LANTERN CORPS ACADEMY");
//		row.add(lblBienvenido);

//		Button btnRanking = new Button("Ver Clasificacion");
//		btnRanking.setStyle(Estilo.getStyle2Color(app.getAtributos()));
//		btnRanking.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent evt) {
//				btnRankingClicked();
//			}
//		});
//		row.add(btnRanking);
//
//		Button btnAboutGame = new Button("Acerca del Juego");
//		btnAboutGame.setStyle(Estilo.getStyle2Color(app.getAtributos()));
//		btnAboutGame.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent evt) {
//				btnAboutGameClicked();
//			}
//		});
//		row.add(btnAboutGame);

//		Button btnForo = new Button("Foro");
//		btnForo.setStyle(Estilo.getStyle2Color(app.getAtributos()));
//		btnForo.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent evt) {
//				btnForoClicked();
//			}
//		});
//		row.add(btnForo);
//
//		Button btnMedia = new Button("Multimedia");
//		btnMedia.setStyle(Estilo.getStyle2Color(app.getAtributos()));
//		btnMedia.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent evt) {
//				btnMediaClicked();
//			}
//		});
//		row.add(btnMedia);

		add(row);
	}

	// --------------------------------------------------------------------------------

//	private void btnRankingClicked() {
//
//		PanelRanking pnlMain = new PanelRanking();
//		Desktop d = app.getDesktop();
//		d.setPanelCentral(pnlMain);
//
//	}
//
//	// --------------------------------------------------------------------------------
//
//	private void btnAboutGameClicked() {
//
//		PanelAboutGame pnlMain = new PanelAboutGame("1");
//		Desktop d = app.getDesktop();
//		d.setPanelCentral(pnlMain);
//
//	}
//
//	// --------------------------------------------------------------------------------
//
//	private void btnForoClicked() {
//
//		PanelForo pnlMain = new PanelForo();
//		Desktop d = app.getDesktop();
//		d.setPanelCentral(pnlMain);
//
//	}
//
//	// --------------------------------------------------------------------------------
//
//	private void btnMediaClicked() {
//
//		PanelMedia pnlMain = new PanelMedia();
//		Desktop d = app.getDesktop();
//		d.setPanelCentral(pnlMain);
//
//	}

	// -------------------------------------------------------------------------------

	private void btnRingClicked() {
		PanelLogin pnlMain = new PanelLogin();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);
	}

}
