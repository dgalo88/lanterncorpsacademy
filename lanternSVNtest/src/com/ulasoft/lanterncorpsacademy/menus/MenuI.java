package com.ulasoft.lanterncorpsacademy.menus;

import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelCrearGrupo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelEditarDatosUsuario;
import com.ulasoft.lanterncorpsacademy.paneles.PanelInvitarNuevosUsuarios;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMiGrupo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelVerHabilidadesAnillo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelVerInvitaciones;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class MenuI extends Panel {

	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
			.getActive();
	Desktop d = app.getDesktop();

	// JUL: en estos si se puede usar esta variable porque con certeza el
	// desktop ya fue cargado.

	public MenuI() {

		Row row = new Row();
		row.setStyle(GUIStyles.STYLEMENUI);

		Column col = new Column();
		col.setStyle(GUIStyles.STYLEMENUI);
		Button btnMiGrupo = new Button("Mi Grupo");
		btnMiGrupo.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnMiGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnMiGrupoClicked();
			}
		});
		col.add(btnMiGrupo);

		Button btnCrearGrupo = new Button("Crear Grupo");
		btnCrearGrupo.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnCrearGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnCrearGrupoClicked();
			}
		});
		col.add(btnCrearGrupo);

		Button btnVerInvitaciones = new Button("Ver Invitaciones");
		btnVerInvitaciones.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnVerInvitaciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnVerInvitacionesClicked();
			}
		});
		col.add(btnVerInvitaciones);

		Button btnInvitarNuevosUsuarios = new Button("Invitar Nuevos Usuarios");
		btnInvitarNuevosUsuarios.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnInvitarNuevosUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnInvitarNuevosUsuariosClicked();
			}
		});
		col.add(btnInvitarNuevosUsuarios);

		Button btnVerHabilidadesAnillo = new Button(
				"Ver Habilidades del Anillo");
		btnVerHabilidadesAnillo.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnVerHabilidadesAnillo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnVerHabilidadesAnilloClicked();
			}
		});
		col.add(btnVerHabilidadesAnillo);

		Button btnEditarDatosUsuario = new Button("Editar Datos del Usuario");
		btnEditarDatosUsuario.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnEditarDatosUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnEditarDatosUsuarioClicked();
			}
		});
		col.add(btnEditarDatosUsuario);

		Button btnExit = new Button("Exit");
		btnExit.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
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
		// LanternCorpsAcademyApp lca = (LanternCorpsAcademyApp)
		// LanternCorpsAcademyApp
		// .getActive();
		// El usuario está haciendo logout, asi que ponemos los atributos a null
		// en la aplicacion
		// despues de guardarlos en BD..
		try {
			app.getAtributos().guardarAtts();
		} catch (Exception e) {
			e.printStackTrace();
		}

		app.setAtributos(null);
	}
}
