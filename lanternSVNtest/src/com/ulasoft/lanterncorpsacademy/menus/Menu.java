package com.ulasoft.lanterncorpsacademy.menus;

import java.util.ArrayList;
import java.util.List;

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
import com.ulasoft.lanterncorpsacademy.paneles.PanelAdquirirTecnologia;
import com.ulasoft.lanterncorpsacademy.paneles.PanelConquistar;
import com.ulasoft.lanterncorpsacademy.paneles.PanelCrearGrupo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelEditarDatosUsuario;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMiGrupo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMisDatos;
import com.ulasoft.lanterncorpsacademy.paneles.PanelRanking;
import com.ulasoft.lanterncorpsacademy.paneles.PanelRecargarAnillo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelSelectAtacar;
import com.ulasoft.lanterncorpsacademy.paneles.PanelVerHabilidadesAnillo;
import com.ulasoft.lanterncorpsacademy.paneles.PanelVerInvitaciones;
import com.ulasoft.lanterncorpsacademy.paneles.PanelViajarPlaneta;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;
import com.valkirye.lanterncorpsacademy.components.Accordion;
import com.valkirye.lanterncorpsacademy.components.AccordionSection;
import com.valkirye.lanterncorpsacademy.extras.ObjectLca;
import com.valkirye.lanterncorpsacademy.extras.ObjectSelectModel;
import com.valkirye.lanterncorpsacademy.extras.ObjectSelectScrolling;
import com.valkirye.lanterncorpsacademy.extras.TestCellRenderer;

@SuppressWarnings("serial")
public class Menu extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();

	public Menu() {

		Row row = new Row();
		row.setStyle(GUIStyles.STYLEMENUI);

		Accordion acc = new Accordion();
		acc.setStyle(GUIStyles.STYLEMENUI);

		// Menu Personaje
		AccordionSection personaje = new AccordionSection("Personaje");
		personaje.setStyleButton(Estilo.getDefaultStyleColor(app.getAtributos()));

		Component menuPersonaje = menuPersonaje();
		personaje.addItem(menuPersonaje);

		acc.addSection(personaje);

		// Menu Armería
		AccordionSection armeria = new AccordionSection("Armería");
		armeria.setStyleButton(Estilo.getDefaultStyleColor(app.getAtributos()));
		
		Component menuArmeria = menuArmeria();
		armeria.addItem(menuArmeria);

		acc.addSection(armeria);

		// Atacar & Conquistar
		AccordionSection atacarConquistar = new AccordionSection("Atacar & Conquistar");
		atacarConquistar.setStyleButton(Estilo.getDefaultStyleColor(app.getAtributos()));

		Component menuAtacarConquistar = menuAtacarConquistar();
		atacarConquistar.addItem(menuAtacarConquistar);

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

		Component menuComerciar = menuComerciar();
		comerciar.addItem(menuComerciar);

		acc.addSection(comerciar);

		// Grupos
		AccordionSection grupos = new AccordionSection("Grupos");
		grupos.setStyleButton(Estilo.getDefaultStyleColor(app.getAtributos()));

		Component menuGrupos = menuGrupos();
		grupos.addItem(menuGrupos);
		
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


	private Component menuPersonaje() {

		Column col = new Column();
		Label [] lblImagen = new Label [4];
		Grid [] grid = new Grid [4];
		setArray(grid, lblImagen, "com/ulasoft/lanterncorpsacademy/imagenes/btnPer.gif");

		Button btnVerDatos = new Button("Ver Mis Datos");
		btnVerDatos.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnVerDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnVerDatosClicked();
			}
		});
		col.add(grid[0]);
		grid[0].add(btnVerDatos);
		

		Button btnEditarDatos = new Button("Editar Mis Datos");
		btnEditarDatos.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnEditarDatos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnEditarDatosClicked();
			}
		});
		col.add(grid[1]);
		grid[1].add(btnEditarDatos);

		Button btnVerHabilidades = new Button("Ver Habilidades");
		btnVerHabilidades.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnVerHabilidades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnVerHabilidadesClicked();
			}
		});
		col.add(grid[2]);
		grid[2].add(btnVerHabilidades);
		
		Button btnRecargarAnillo = new Button("Recargar Anillo");
		btnRecargarAnillo.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnRecargarAnillo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRecargarAnilloClicked();
			}
		});
		col.add(grid[3]);
		grid[3].add(btnRecargarAnillo);

		return col;

	}

	// --------------------------------------------------------------------------------


	private Component menuArmeria() {

		Column col = new Column();
		Label [] lblImagen = new Label [4];
		Grid [] grid = new Grid [4];
		setArray(grid, lblImagen, "com/ulasoft/lanterncorpsacademy/imagenes/btnArm.gif");

		Button btnVerUnidades = new Button("Ver Unidades");
		btnVerUnidades.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnVerUnidades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnVerUnidadesClicked();
			}
		});
		col.add(grid[0]);
		grid[0].add(btnVerUnidades);

		Button btnAdquirirTecnologia = new Button("Adquirir Tecnologia");
		btnAdquirirTecnologia.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnAdquirirTecnologia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnAdquirirTecnologiaClicked();
			}
		});
		col.add(grid[1]);
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
		grid[3].add(btnReparar);

		return col;
	}


	// --------------------------------------------------------------------------------


	private Component menuAtacarConquistar() {

		Column col = new Column();
		Label [] lblImagen = new Label [3];
		Grid [] grid = new Grid [3];
		setArray(grid, lblImagen, "com/ulasoft/lanterncorpsacademy/imagenes/btnAC.gif");

		Button btnAtacar = new Button("Atacar");
		btnAtacar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnAtacar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnAtacarClicked();
			}
		});
		col.add(grid[0]);
		grid[0].add(btnAtacar);

		Button btnConquistar = new Button("Conquistar");
		btnConquistar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnConquistar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnConquistarClicked();
			}
		});
		col.add(grid[1]);
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
		grid[2].add(btnSabotear);

		return col;
	}


	// --------------------------------------------------------------------------------


	private Component menuComerciar() {

		Column col = new Column();
		Label [] lblImagen = new Label [2];
		Grid [] grid = new Grid [2];
		setArray(grid, lblImagen, "com/ulasoft/lanterncorpsacademy/imagenes/btnCom.gif");

		Button btnOfertar = new Button("Ofertar");
		btnOfertar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnOfertar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				btnOfertarClicked();
			}
		});
		col.add(grid[0]);
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
		grid[1].add(btnIntercambiar);

		return col;
	}


	// --------------------------------------------------------------------------------

	private Component menuGrupos() {

		Column col = new Column();
		Label [] lblImagen = new Label [4];
		Grid [] grid = new Grid [4];
		setArray(grid, lblImagen, "com/ulasoft/lanterncorpsacademy/imagenes/btnGr.gif");


		Button btnCrearGrupo = new Button("Crear Grupo");
		btnCrearGrupo.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnCrearGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnCrearGrupoClicked();
			}
		});
		col.add(grid[0]);
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
		grid[3].add(btnVerMensajes);

		return col;
	}

	// --------------------------------------------------------------------------------

	private void setArray(Grid [] grid, Label [] lblImagen, String image) {

		for (int i = 0; i < grid.length; i++) {
			lblImagen[i] = new Label();
			lblImagen[i].setIcon(new ResourceImageReference(image, //
					new Extent(20), new Extent(20)));
			grid[i] = new Grid();
			grid[i].add(lblImagen[i]);
		}
	}

	// --------------------------------------------------------------------------------

	private void btnVerDatosClicked() {

		PanelMisDatos pnlMain = new PanelMisDatos();
		d.setWindowData(pnlMain, "Mis Datos", 650, 260);

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

	private void btnVerUnidadesClicked() {

		// XXX: Inventario

		List<ObjectLca> list = new ArrayList<ObjectLca>();
		for (int i = 0; i < 10; i++) {
			ObjectLca item = new ObjectLca(i);
			list.add(item);
		}

		ObjectSelectModel oModel = new ObjectSelectModel(list);
		TestCellRenderer tcr = new TestCellRenderer();
		ObjectSelectScrolling oSelectScrolling = new ObjectSelectScrolling(oModel, tcr);

		d.setWindowData(oSelectScrolling, "Inventario de Unidades", 600, 230);

	}

	// --------------------------------------------------------------------------------

	private void btnConquistarClicked() {

		PanelConquistar pnlMain = new PanelConquistar();
		d.setPanelCentral(pnlMain);
	}

	// --------------------------------------------------------------------------------

	private void btnRecolectarClicked() {

//		PanelRecolectar pnlMain = new PanelRecolectar();
//		d.setPanelCentral(pnlMain);

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
	// --------------------------------------------------------------------------------

	protected void btnAdquirirTecnologiaClicked() {

		PanelAdquirirTecnologia pnlMain = new PanelAdquirirTecnologia();
		d.setPanelCentral(pnlMain);

	}
}