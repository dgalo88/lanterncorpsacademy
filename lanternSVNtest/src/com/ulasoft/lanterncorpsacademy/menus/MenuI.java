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

@SuppressWarnings("serial")
public class MenuI extends Panel {
	
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
	Desktop d = app.getDesktop();
	//JUL: en estos si se puede usar esta variable porque con certeza el desktop ya fue cargado.
	
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

		PanelMiGrupo pnlMain = new PanelMiGrupo();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnCrearGrupoClicked() {

		PanelCrearGrupo pnlMain = new PanelCrearGrupo();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnVerInvitacionesClicked() {

		PanelVerInvitaciones pnlMain = new PanelVerInvitaciones();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnInvitarNuevosUsuariosClicked() {

		PanelInvitarNuevosUsuarios pnlMain = new PanelInvitarNuevosUsuarios();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnVerHabilidadesAnilloClicked() {

		PanelVerHabilidadesAnillo pnlMain = new PanelVerHabilidadesAnillo();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnEditarDatosUsuarioClicked() {

		PanelEditarDatosUsuario pnlMain = new PanelEditarDatosUsuario();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnExitClicked() {
		Desktop desktop = app.getDesktop();
		d.removeAll();
    d.add(desktop.initTemplate1());
    // El usuario está haciendo logout, asi que ponemos los atributos a null en la aplicacion
    LanternCorpsAcademyApp lca = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
    lca.setAtributos(null);
	  }
	}


