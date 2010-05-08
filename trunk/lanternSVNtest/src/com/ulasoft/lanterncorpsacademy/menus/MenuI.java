package com.ulasoft.lanterncorpsacademy.menus;

import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.GUIStyles;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.paneles.PanelCrearGrupo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelEditarDatosUsuario;
import com.ulasoft.lanterncorpsacademy.paneles.PanelInvitarNuevosUsuarios;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMiGrupo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelVerHabilidadesAnillo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelVerInvitaciones;


public class MenuI extends Panel {
	
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
	Desktop d = app.getDesktop();
	
	public MenuI(){
		Row row = new Row();
		row.setStyle(GUIStyles.STYLE4);
				
		Column col = new Column();
		col.setStyle(GUIStyles.STYLE4);
		Button btnMiGrupo = new Button("Mi Grupo");
		btnMiGrupo.setStyle(GUIStyles.DEFAULT_STYLE);
		btnMiGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnMiGrupoClicked();
			}
		});
		col.add(btnMiGrupo);

		Button btnCrearGrupo = new Button("Crear Grupo");
		btnCrearGrupo.setStyle(GUIStyles.DEFAULT_STYLE);
		btnCrearGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnCrearGrupoClicked();
			}
		});
		col.add(btnCrearGrupo);

		Button btnVerInvitaciones = new Button("Ver Invitaciones");
		btnVerInvitaciones.setStyle(GUIStyles.DEFAULT_STYLE);
		btnVerInvitaciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnVerInvitacionesClicked();
			}
		});
		col.add(btnVerInvitaciones);

		Button btnInvitarNuevosUsuarios = new Button("Invitar Nuevos Usuarios");
		btnInvitarNuevosUsuarios.setStyle(GUIStyles.DEFAULT_STYLE);
		btnInvitarNuevosUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnInvitarNuevosUsuariosClicked();
			}
		});
		col.add(btnInvitarNuevosUsuarios);

		Button btnVerHabilidadesAnillo = new Button(
				"Ver Habilidades del Anillo");
		btnVerHabilidadesAnillo.setStyle(GUIStyles.DEFAULT_STYLE);
		btnVerHabilidadesAnillo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnVerHabilidadesAnilloClicked();
			}
		});
		col.add(btnVerHabilidadesAnillo);

		Button btnEditarDatosUsuario = new Button("Editar Datos del Usuario");
		btnEditarDatosUsuario.setStyle(GUIStyles.DEFAULT_STYLE);
		btnEditarDatosUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnEditarDatosUsuarioClicked();
			}
		});
		col.add(btnEditarDatosUsuario);

		Button btnExit = new Button("Exit");
		btnExit.setStyle(GUIStyles.DEFAULT_STYLE);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnExitClicked();
			}
		});
		col.add(btnExit);
		
		row.add(col);

		add(row);
		
	}

	// --------------------------------------------------------------------------------

	private void btnMiGrupoClicked() {
//		HtmlLayoutData hld = new HtmlLayoutData("main");
		PanelMiGrupo pnlMain = new PanelMiGrupo();
		d.setPanelCentral(pnlMain);
//		pnlMain.setId("main");
//		pnlMain.setLayoutData(hld);
//
//		// Remueve componente anterior del htmlLayout
//		htmlLayout.remove(htmlLayout.getComponent("main"));
//		htmlLayout.add(pnlMain);
	}

	// --------------------------------------------------------------------------------

	private void btnCrearGrupoClicked() {
//		HtmlLayoutData hld = new HtmlLayoutData("main");
		PanelCrearGrupo pnlMain = new PanelCrearGrupo();
		d.setPanelCentral(pnlMain);
//		pnlMain.setId("main");
//		pnlMain.setLayoutData(hld);
//
//		// Remueve componente anterior del htmlLayout
//		htmlLayout.remove(htmlLayout.getComponent("main"));
//		htmlLayout.add(pnlMain);
	}

	// --------------------------------------------------------------------------------

	private void btnVerInvitacionesClicked() {
//		HtmlLayoutData hld = new HtmlLayoutData("main");
		PanelVerInvitaciones pnlMain = new PanelVerInvitaciones();
		d.setPanelCentral(pnlMain);
//		pnlMain.setId("main");
//		pnlMain.setLayoutData(hld);
//
//		// Remueve componente anterior del htmlLayout
//		htmlLayout.remove(htmlLayout.getComponent("main"));
//		htmlLayout.add(pnlMain);
	}

	// --------------------------------------------------------------------------------

	private void btnInvitarNuevosUsuariosClicked() {
//		HtmlLayoutData hld = new HtmlLayoutData("main");
		PanelInvitarNuevosUsuarios pnlMain = new PanelInvitarNuevosUsuarios();
		d.setPanelCentral(pnlMain);
//		pnlMain.setId("main");
//		pnlMain.setLayoutData(hld);
//
//		// Remueve componente anterior del htmlLayout
//		htmlLayout.remove(htmlLayout.getComponent("main"));
//		htmlLayout.add(pnlMain);
	}

	// --------------------------------------------------------------------------------

	private void btnVerHabilidadesAnilloClicked() {
//		HtmlLayoutData hld = new HtmlLayoutData("main");
		PanelVerHabilidadesAnillo pnlMain = new PanelVerHabilidadesAnillo();
		d.setPanelCentral(pnlMain);
//		pnlMain.setId("main");
//		pnlMain.setLayoutData(hld);
//
//		// Remueve componente anterior del htmlLayout
//		htmlLayout.remove(htmlLayout.getComponent("main"));
//		htmlLayout.add(pnlMain);
	}

	// --------------------------------------------------------------------------------

	private void btnEditarDatosUsuarioClicked() {
//		HtmlLayoutData hld = new HtmlLayoutData("main");
		PanelEditarDatosUsuario pnlMain = new PanelEditarDatosUsuario();
		d.setPanelCentral(pnlMain);
//		pnlMain.setId("main");
//		pnlMain.setLayoutData(hld);
//
//		// Remueve componente anterior del htmlLayout
//		htmlLayout.remove(htmlLayout.getComponent("main"));
//		htmlLayout.add(pnlMain);
	}

	// --------------------------------------------------------------------------------

	private void btnExitClicked() {
		removeAll();
		add(d.initTemplate1());
	}

}
