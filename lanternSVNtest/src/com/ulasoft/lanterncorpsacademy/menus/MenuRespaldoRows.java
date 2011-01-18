package com.ulasoft.lanterncorpsacademy.menus;

import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelAboutGame;
import com.ulasoft.lanterncorpsacademy.paneles.PanelCrearGrupo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelEditarDatosUsuario;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMiGrupo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelRanking;
import com.ulasoft.lanterncorpsacademy.paneles.PanelRecargarAnillo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelSelectAtacar;
import com.ulasoft.lanterncorpsacademy.paneles.PanelVerHabilidadesAnillo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelVerInvitaciones;
import com.ulasoft.lanterncorpsacademy.paneles.PanelViajarPlaneta;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;
import com.valkirye.lanterncorpsacademy.extras.Accordion;
import com.valkirye.lanterncorpsacademy.extras.AccordionSection;

@SuppressWarnings("serial")
public class MenuRespaldoRows extends Panel {

	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
			.getActive();
	Desktop d = app.getDesktop();

	public MenuRespaldoRows() {

		Row row = new Row();
		row.setStyle(GUIStyles.STYLEMENUI);

		Accordion acc = new Accordion();
		acc.setStyle(GUIStyles.STYLEMENUI);

		// Menu Personaje
		AccordionSection personaje = new AccordionSection("Personaje");
		personaje.setStyleButton(Estilo.getDefaultStyleColor(app.getAtributos()));

		Button btnVerDatos = new Button("Ver Mis Datos");
		btnVerDatos.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnVerDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnVerDatosClicked();
			}
		});
		personaje.addItem(btnVerDatos);
		
		Button btnEditarDatos = new Button("Editar Mis Datos");
		btnEditarDatos.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnEditarDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnEditarDatosClicked();
			}
		});
		personaje.addItem(btnEditarDatos);

		Button btnVerHabilidades = new Button("Ver Habilidades");
		btnVerHabilidades.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnVerHabilidades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnVerHabilidadesClicked();
			}
		});
		personaje.addItem(btnVerHabilidades);
		
		Button btnRecargarAnillo = new Button("Recargar Anillo");
		btnRecargarAnillo.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnRecargarAnillo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRecargarAnilloClicked();
			}
		});
		personaje.addItem(btnRecargarAnillo);

		acc.addSection(personaje);

		// Menu Armería
		AccordionSection armeria = new AccordionSection("Armería");
		armeria.setStyleButton(Estilo.getDefaultStyleColor(app.getAtributos()));
		
		Button btnVerUnidades = new Button("Ver Unidades");
		btnVerUnidades.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnVerUnidades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnVerUnidadesClicked();
			}
		});
		armeria.addItem(btnVerUnidades);

		Button btnAdquirirTecnologia = new Button("Adquirir Tecnologia");
		btnAdquirirTecnologia.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnAdquirirTecnologia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnAdquirirTecnologiaClicked();
			}
		});
		armeria.addItem(btnAdquirirTecnologia);

		Button btnConstruir = new Button("Construir");
		btnConstruir.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnConstruir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnConstruirClicked();
			}
		});
		armeria.addItem(btnConstruir);
		
		Button btnReparar = new Button("Reparar");
		btnReparar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnReparar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnRepararClicked();
			}
		});
		armeria.addItem(btnReparar);
		
		acc.addSection(armeria);

		// Atacar & Conquistar
		AccordionSection atacarConquistar = new AccordionSection("Atacar & Conquistar");
		atacarConquistar.setStyleButton(Estilo.getDefaultStyleColor(app.getAtributos()));

		Button btnAtacar = new Button("Atacar");
		btnAtacar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnAtacar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnAtacarClicked();
			}
		});
		atacarConquistar.addItem(btnAtacar);

		Button btnConquistar = new Button("Conquistar");
		btnConquistar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnConquistar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnConquistarClicked();
			}
		});
		atacarConquistar.addItem(btnConquistar);

		Button btnSabotear = new Button("Sabotear");
		btnSabotear.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnSabotear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnSabotearClicked();
			}
		});
		atacarConquistar.addItem(btnSabotear);

		acc.addSection(atacarConquistar);

		// Recolectar
		Button btnRecolectar = new Button("Recolectar");
		btnRecolectar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnRecolectar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRecolectarClicked();
			}
		});
		AccordionSection recolectar = new AccordionSection(btnRecolectar);
		recolectar.setStyleButton(Estilo.getDefaultStyleColor(app.getAtributos()));
		acc.addSection(recolectar);

		// Comerciar
		AccordionSection comerciar = new AccordionSection("Comerciar");
		comerciar.setStyleButton(Estilo.getDefaultStyleColor(app.getAtributos()));

		Button btnOfertar = new Button("Ofertar");
		btnOfertar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnOfertar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnOfertarClicked();
			}
		});
		comerciar.addItem(btnOfertar);

		Button btnIntercambiar = new Button("Intercambiar");
		btnIntercambiar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnIntercambiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnIntercambiarClicked();
			}
		});
		comerciar.addItem(btnIntercambiar);

		acc.addSection(comerciar);

		// Grupos
		AccordionSection grupos = new AccordionSection("Grupos");
		grupos.setStyleButton(Estilo.getDefaultStyleColor(app.getAtributos()));

		Button btnCrearGrupo = new Button("Crear Grupo");
		btnCrearGrupo.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnCrearGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnCrearGrupoClicked();
			}
		});
		grupos.addItem(btnCrearGrupo);

		Button btnMiGrupo = new Button("Mi Grupo");
		btnMiGrupo.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnMiGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnMiGrupoClicked();
			}
		});
		grupos.addItem(btnMiGrupo);

		Button btnVerInvitaciones = new Button("Ver Invitaciones");
		btnVerInvitaciones.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnVerInvitaciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnVerInvitacionesClicked();
			}
		});
		grupos.addItem(btnVerInvitaciones);

		Button btnVerMensajes = new Button("Ver Mensajes");
		btnVerMensajes.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnVerMensajes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnVerMensajesClicked();
			}
		});
		grupos.addItem(btnVerMensajes);
		
		acc.addSection(grupos);

		// Ver Clasificación
		Button btnRanking = new Button("Ver Clasificacion");
		btnRanking.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnRanking.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRankingClicked();
			}
		});
		AccordionSection ranking = new AccordionSection(btnRanking);
		ranking.setStyleButton(Estilo.getDefaultStyleColor(app.getAtributos()));
		acc.addSection(ranking);

		// Acerca del Juego
		Button btnAboutGame = new Button("Acerca del Juego");
		btnAboutGame.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnAboutGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnAboutGameClicked();
			}
		});
		AccordionSection aboutGame = new AccordionSection(btnAboutGame);
		aboutGame.setStyleButton(Estilo.getDefaultStyleColor(app.getAtributos()));
		acc.addSection(aboutGame);

		// Mini Mapa
		Label lblMiniMapa = new Label();
		lblMiniMapa.setIcon(new ResourceImageReference(
				"com/ulasoft/lanterncorpsacademy/imagenes/miniMapa.png",
				new Extent(185), new Extent(184)));
		acc.add(lblMiniMapa);

		// Ver Mapa
		Button btnVerMapa = new Button("Ver mapa");
		btnVerMapa.setForeground(new Color (255, 255, 255));
		btnVerMapa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnViajarPlanetaClicked();
			}
		});
		AccordionSection verMapa = new AccordionSection(btnVerMapa);
//		verMapa.setStyleButton(Estilo.getDefaultStyleColor(app.getAtributos()));
		acc.addSection(verMapa);

		row.add(acc);
		add(row);
	}

	// --------------------------------------------------------------------------------

	private void btnVerDatosClicked() {

//		PanelVerDatos pnlMain = new PanelVerDatos();
//		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnEditarDatosClicked() {

		PanelEditarDatosUsuario pnlMain = new PanelEditarDatosUsuario();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnVerHabilidadesClicked() {

		PanelVerHabilidadesAnillo pnlMain = new PanelVerHabilidadesAnillo();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	protected void btnRecargarAnilloClicked() {
		PanelRecargarAnillo pnlMain = new PanelRecargarAnillo();
		d.setPanelCentral(pnlMain);
	}

	// --------------------------------------------------------------------------------

	protected void btnAtacarClicked() {

		PanelSelectAtacar pnlMain = new PanelSelectAtacar();
		d.setPanelCentral(pnlMain);
	}

	// --------------------------------------------------------------------------------

	private void btnRecolectarClicked() {

		//

	}

	// --------------------------------------------------------------------------------

	private void btnCrearGrupoClicked() {

		PanelCrearGrupo pnlMain = new PanelCrearGrupo();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnMiGrupoClicked() {

		PanelMiGrupo pnlMain = new PanelMiGrupo();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnVerInvitacionesClicked() {

		PanelVerInvitaciones pnlMain = new PanelVerInvitaciones();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnRankingClicked() {

		PanelRanking pnlMain = new PanelRanking();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnAboutGameClicked() {

		PanelAboutGame pnlMain = new PanelAboutGame("1");
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	protected void btnViajarPlanetaClicked() {

		PanelViajarPlaneta pnlMain = new PanelViajarPlaneta();
		d.setPanelCentral(pnlMain);

	}

}