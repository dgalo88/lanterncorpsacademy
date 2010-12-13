package com.ulasoft.lanterncorpsacademy.menus;

import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
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
import com.ulasoft.lanterncorpsacademy.paneles.PanelMain;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMiGrupo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelRanking;
import com.ulasoft.lanterncorpsacademy.paneles.PanelRecargarAnillo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelSelectAtacar;
import com.ulasoft.lanterncorpsacademy.paneles.PanelVerHabilidadesAnillo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelVerInvitaciones;
import com.ulasoft.lanterncorpsacademy.paneles.PanelViajarPlaneta;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class Menu extends Panel {

	private int c;

	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
			.getActive();
	Desktop d = app.getDesktop();

	public Menu(int ctl) {

		c = ctl;

		Row row = new Row();
		row.setStyle(GUIStyles.STYLEMENUI);

		Column col = new Column();
		col.setStyle(GUIStyles.STYLEMENUI);

		Button btnPersonaje = new Button("Personaje");
		btnPersonaje.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnPersonaje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnPersonajeClicked();
			}
		});
		col.add(btnPersonaje);

		if (ctl == 1) {
			Component menuPersonaje = menuPersonaje();
			col.add(menuPersonaje);
		}

		Button btnArmeria = new Button("Armeria");
		btnArmeria.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnArmeria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnArmeriaClicked();
			}
		});
		col.add(btnArmeria);

		if (ctl == 2) {
			Component menuArmeria = menuArmeria();
			col.add(menuArmeria);
		}

		Button btnAtacarConquistar = new Button("Atacar & Conquistar");
		btnAtacarConquistar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnAtacarConquistar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnAtacarConquistarClicked();
			}
		});
		col.add(btnAtacarConquistar);

		if (ctl == 3) {
			Component menuAtacarConquistar = menuAtacarConquistar();
			col.add(menuAtacarConquistar);
		}

		Button btnRecolectar = new Button("Recolectar");
		btnRecolectar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnRecolectar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRecolectarClicked();
			}
		});
		col.add(btnRecolectar);

		Button btnComerciar = new Button("Comerciar");
		btnComerciar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnComerciar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnComerciarClicked();
			}
		});
		col.add(btnComerciar);

		if (ctl == 4) {
			Component menuComerciar = menuComerciar();
			col.add(menuComerciar);
		}

		Button btnGrupos = new Button("Grupos");
		btnGrupos.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnGrupos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnGruposClicked();
			}
		});
		col.add(btnGrupos);

		if (ctl == 5) {
			Component menuGrupos = menuGrupos();
			col.add(menuGrupos);
		}

		Button btnRanking = new Button("Ver Clasificacion");
		btnRanking.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnRanking.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRankingClicked();
			}
		});
		col.add(btnRanking);

		Button btnAboutGame = new Button("Acerca del Juego");
		btnAboutGame.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnAboutGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnAboutGameClicked();
			}
		});
		col.add(btnAboutGame);

		Label lblMiniMapa = new Label();
		lblMiniMapa.setIcon(new ResourceImageReference(
				"com/ulasoft/lanterncorpsacademy/imagenes/miniMapa.png",
				new Extent(185), new Extent(184)));
		col.add(lblMiniMapa);

		Button btnVerMapa = new Button("Ver mapa");
		btnVerMapa.setForeground(new Color (255, 255, 255));
		btnVerMapa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnViajarPlanetaClicked();
			}
		});
		col.add(btnVerMapa);

		row.add(col);
		add(row);
	}

	// --------------------------------------------------------------------------------

	private Component menuPersonaje() {
		Column col = new Column();

		Button btnVerDatos = new Button("Ver Mis Datos");
		btnVerDatos.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnVerDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnVerDatosClicked();
			}
		});
		col.add(btnVerDatos);

		Button btnEditarDatos = new Button("Editar Mis Datos");
		btnEditarDatos.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnEditarDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnEditarDatosClicked();
			}
		});
		col.add(btnEditarDatos);

		Button btnVerHabilidades = new Button("Ver Habilidades");
		btnVerHabilidades.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnVerHabilidades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnVerHabilidadesClicked();
			}
		});
		col.add(btnVerHabilidades);
		
		Button btnRecargarAnillo = new Button("Recargar Anillo");
		btnRecargarAnillo.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnRecargarAnillo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRecargarAnilloClicked();
			}
		});
		col.add(btnRecargarAnillo);

		return col;
	}

	// --------------------------------------------------------------------------------

	private Component menuArmeria() {
		Column col = new Column();
		Grid [] grid = new Grid [4]; 
		for (int i = 0; i < grid.length; i++) {
			grid[i] = new Grid();
		}

		Button btnVerUnidades = new Button("Ver Unidades");
		btnVerUnidades.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnVerUnidades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnVerUnidadesClicked();
			}
		});
		col.add(grid[0]);
		grid[0].add(new Label("._._."));
		grid[0].add(btnVerUnidades);

		Button btnAdquirirTecnologia = new Button("Adquirir Tecnologia");
		btnAdquirirTecnologia.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnAdquirirTecnologia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnAdquirirTecnologiaClicked();
			}
		});
		col.add(grid[1]);
		grid[1].add(new Label("._._."));
		grid[1].add(btnAdquirirTecnologia);

		Button btnConstruir = new Button("Construir");
		btnConstruir.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnConstruir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnConstruirClicked();
			}
		});
		col.add(grid[2]);
		grid[2].add(new Label("._._."));
		grid[2].add(btnConstruir);
		
		Button btnReparar = new Button("Reparar");
		btnReparar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnReparar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnRepararClicked();
			}
		});
		col.add(grid[3]);
		grid[3].add(new Label("._._."));
		grid[3].add(btnReparar);

		return col;
	}

	// --------------------------------------------------------------------------------

	private Component menuAtacarConquistar() {
		Column col = new Column();
		Grid [] grid = new Grid [3]; 
		for (int i = 0; i < grid.length; i++) {
			grid[i] = new Grid();
		}

		Button btnAtacar = new Button("Atacar");
		btnAtacar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnAtacar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnAtacarClicked();
			}
		});
		col.add(grid[0]);
		grid[0].add(new Label("._._."));
		grid[0].add(btnAtacar);

		Button btnConquistar = new Button("Conquistar");
		btnConquistar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnConquistar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnConquistarClicked();
			}
		});
		col.add(grid[1]);
		grid[1].add(new Label("._._."));
		grid[1].add(btnConquistar);

		Button btnSabotear = new Button("Sabotear");
		btnSabotear.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnSabotear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnSabotearClicked();
			}
		});
		col.add(grid[2]);
		grid[2].add(new Label("._._."));
		grid[2].add(btnSabotear);

		return col;
	}

	// --------------------------------------------------------------------------------

	private Component menuComerciar() {
		Column col = new Column();
		Grid [] grid = new Grid [2]; 
		for (int i = 0; i < grid.length; i++) {
			grid[i] = new Grid();
		}

		Button btnOfertar = new Button("Ofertar");
		btnOfertar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnOfertar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnOfertarClicked();
			}
		});
		col.add(grid[0]);
		grid[0].add(new Label("._._."));
		grid[0].add(btnOfertar);

		Button btnIntercambiar = new Button("Intercambiar");
		btnIntercambiar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnIntercambiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnIntercambiarClicked();
			}
		});
		col.add(grid[1]);
		grid[1].add(new Label("._._."));
		grid[1].add(btnIntercambiar);

		return col;
	}

	// --------------------------------------------------------------------------------

	private Component menuGrupos() {
		Column col = new Column();
		Grid [] grid = new Grid [4]; 
		for (int i = 0; i < grid.length; i++) {
			grid[i] = new Grid();
		}

		Button btnCrearGrupo = new Button("Crear Grupo");
		btnCrearGrupo.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnCrearGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnCrearGrupoClicked();
			}
		});
		col.add(grid[0]);
		grid[0].add(new Label("._._."));
		grid[0].add(btnCrearGrupo);

		Button btnMiGrupo = new Button("Mi Grupo");
		btnMiGrupo.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnMiGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnMiGrupoClicked();
			}
		});
		col.add(grid[1]);
		grid[1].add(new Label("._._."));
		grid[1].add(btnMiGrupo);

		Button btnVerInvitaciones = new Button("Ver Invitaciones");
		btnVerInvitaciones.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnVerInvitaciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnVerInvitacionesClicked();
			}
		});
		col.add(grid[2]);
		grid[2].add(new Label("._._."));
		grid[2].add(btnVerInvitaciones);

		Button btnVerMensajes = new Button("Ver Mensajes");
		btnVerMensajes.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnVerMensajes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnVerMensajesClicked();
			}
		});
		col.add(grid[3]);
		grid[3].add(new Label("._._."));
		grid[3].add(btnVerMensajes);

		return col;
	}

	// --------------------------------------------------------------------------------

	private void setMenu(int ctl) {
		Menu menu = new Menu(ctl);
		d.setPanelMenu(menu);
	}

	// --------------------------------------------------------------------------------

	private void btnPersonajeClicked() {

		int ctl;
		ctl = (c == 1 ? 0 : 1 );
		setMenu(ctl);
		PanelMain pnlMain = new PanelMain();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnArmeriaClicked() {

		int ctl;
		ctl = (c == 2 ? 0 : 2 );
		setMenu(ctl);
		PanelMain pnlMain = new PanelMain();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnAtacarConquistarClicked() {

		int ctl;
		ctl = (c == 3 ? 0 : 3 );
		setMenu(ctl);
		PanelMain pnlMain = new PanelMain();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnComerciarClicked() {

		int ctl;
		ctl = (c == 4 ? 0 : 4 );
		setMenu(ctl);
		PanelMain pnlMain = new PanelMain();
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnGruposClicked() {

		int ctl;
		ctl = (c == 5 ? 0 : 5 );
		setMenu(ctl);
		PanelMain pnlMain = new PanelMain();
		d.setPanelCentral(pnlMain);

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

		
		setMenu(0);

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
		setMenu(0);
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	private void btnAboutGameClicked() {
		PanelAboutGame pnlMain = new PanelAboutGame("1");
		setMenu(0);
		d.setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	protected void btnViajarPlanetaClicked() {

		PanelViajarPlaneta pnlMain = new PanelViajarPlaneta();
		d.setPanelCentral(pnlMain);

	}

}
