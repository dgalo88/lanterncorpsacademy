package com.ulasoft.lanterncorpsacademy.menus;

import nextapp.echo.app.Button;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.GUIStyles;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.paneles.PanelAboutGame;
import com.ulasoft.lanterncorpsacademy.paneles.PanelForo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelLogin;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMedia;
import com.ulasoft.lanterncorpsacademy.paneles.PanelRanking;

@SuppressWarnings("serial")
public class MenuHead extends Panel {

	public LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
//	public Desktop d = app.getDesktop();
	
	public MenuHead() {
		Row row = new Row();
		row.setStyle(GUIStyles.STYLE3);
	//	row.setInsets(new Insets(125, 1, 1, 1));

		Button btnRanking = new Button("Ver Clasificacion");
		btnRanking.setStyle(GUIStyles.STYLE2);
		btnRanking.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRankingClicked();
			}
		});
		row.add(btnRanking);

		Button btnAboutGame = new Button("Acerca del Juego");
		btnAboutGame.setStyle(GUIStyles.STYLE2);
		btnAboutGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnAboutGameClicked();
			}
		});
		row.add(btnAboutGame);

		Button btnRing = new Button();
		// btnRing.setDisabledBackgroundImage(new FillImage(new
		// ResourceImageReference("com/ulasoft/lanterncorpsacademy/linterna.png")));
		// btnRing.setAlignment(Alignment.ALIGN_CENTER);
		btnRing.setIcon(new ResourceImageReference(
				"com/ulasoft/lanterncorpsacademy/imagenes/linterna.png"));
		// btnRing.setStyle(GUIStyles.DEFAULT_STYLE);
		btnRing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRingClicked();
			}
		});
		row.add(btnRing);

		Button btnForo = new Button("Foro");
		btnForo.setStyle(GUIStyles.STYLE2);
		btnForo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnForoClicked();
			}
		});
		row.add(btnForo);

		Button btnMedia = new Button("Multimedia");
		btnMedia.setStyle(GUIStyles.STYLE2);
		btnMedia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnMediaClicked();
			}
		});
		row.add(btnMedia);
		add(row);
	}

	// --------------------------------------------------------------------------------

	private void btnRankingClicked() {

		PanelRanking pnlMain = new PanelRanking();
		Desktop d = app.getDesktop(); 
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnAboutGameClicked() {

		PanelAboutGame pnlMain = new PanelAboutGame("1");
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnForoClicked() {

		PanelForo pnlMain = new PanelForo();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnMediaClicked() {

		PanelMedia pnlMain = new PanelMedia();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);

	}

	// -------------------------------------------------------------------------------

	private void btnRingClicked() {
		PanelLogin pnlMain = new PanelLogin();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);
	}

	
	
}
