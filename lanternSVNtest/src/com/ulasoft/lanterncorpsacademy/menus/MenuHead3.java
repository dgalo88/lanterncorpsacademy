package com.ulasoft.lanterncorpsacademy.menus;

import nextapp.echo.app.Button;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.ImgLoad;
import com.ulasoft.lanterncorpsacademy.paneles.PanelAboutGame;
import com.ulasoft.lanterncorpsacademy.paneles.PanelForo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelInvitarNuevosUsuarios;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMain;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMedia;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMisiones;
import com.ulasoft.lanterncorpsacademy.paneles.PanelRanking;
import com.ulasoft.lanterncorpsacademy.paneles.PanelRecargarAnillo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelSelectAtacar;
import com.ulasoft.lanterncorpsacademy.paneles.PanelViajarPlaneta;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class MenuHead3 extends Panel {
	
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
	.getActive();
	
	public MenuHead3() {
		Row row = new Row();
		row.setStyle(GUIStyles.STYLECENTERROW);
		// row.setInsets(new Insets(30, 1, 1, 1));

		Button btnMisiones = new Button("Misiones");
		btnMisiones.setStyle(Estilo.getStyle2Color(app.getAtributos()));
		// btnMisiones.setWidth(new Extent(100));
		btnMisiones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnMisionesClicked();
			}
		});
		row.add(btnMisiones);

//		Button btnAtacar = new Button("Atacar");
//		btnAtacar.setStyle(Estilo.getStyle2Color(app.getAtributos()));
//		btnAtacar.setWidth(new Extent(100));
//		// btnAtacar.setWidth(new Extent(100));
//		btnAtacar.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent evt) {
//				btnAtacarClicked();
//			}
//		});
//		row.add(btnAtacar);

		Button btnViajarPlaneta = new Button("Viajar a Otro Planeta");
		btnViajarPlaneta.setStyle(Estilo.getStyle2Color(app.getAtributos()));
		btnViajarPlaneta.setWidth(new Extent(160));
		btnViajarPlaneta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnViajarPlanetaClicked();
			}
		});
		row.add(btnViajarPlaneta);

		Button btnRing = new Button();
		btnRing.setIcon(new ResourceImageReference(ImgLoad.menuHead(app
				.getAtributos().getPersonaje())));
		btnRing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRing2Clicked();
			}
		});
		row.add(btnRing);

		Button btnForo = new Button("Foro");
		btnForo.setStyle(Estilo.getStyle2Color(app.getAtributos()));
		btnForo.setWidth(new Extent(100));
		btnForo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnForoClicked();
			}
		});
		row.add(btnForo);

		Button btnInvitarNuevosUsuarios = new Button("Invitar Nuevos Usuarios");
		btnInvitarNuevosUsuarios.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnInvitarNuevosUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnInvitarNuevosUsuariosClicked();
			}
		});
		row.add(btnInvitarNuevosUsuarios);

		Button btnMedia = new Button("Multimedia");
		btnMedia.setStyle(Estilo.getStyle2Color(app.getAtributos()));
		btnMedia.setWidth(new Extent(100));
		btnMedia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnMediaClicked();
			}
		});
		row.add(btnMedia);

		add(row);
	}

	Desktop d = app.getDesktop();

	// --------------------------------------------------------------------------------

	private void btnForoClicked() {

		PanelForo pnlMain = new PanelForo();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnMediaClicked() {

		PanelMedia pnlMain = new PanelMedia();
		d.setPanelCentral(pnlMain);

	}

	// -------------------------------------------------------------------------------

	protected void btnRing2Clicked() {
		// removeAll();
		// add(initTemplate2());
		PanelMain pnlMain = new PanelMain();
		// d = app.getDesktop();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	protected void btnViajarPlanetaClicked() {

		PanelViajarPlaneta pnlMain = new PanelViajarPlaneta();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	protected void btnMisionesClicked() {

		PanelMisiones pnlMain = new PanelMisiones();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnInvitarNuevosUsuariosClicked() {

		PanelInvitarNuevosUsuarios pnlMain = new PanelInvitarNuevosUsuarios();
		d.setPanelCentral(pnlMain);

	}

}
