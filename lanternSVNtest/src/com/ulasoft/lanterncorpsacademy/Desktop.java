/**
 * 
 */
package com.ulasoft.lanterncorpsacademy;

import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

/**
 * @author typson julian
 *
 */
public class Desktop extends ContentPane {

	private HtmlLayout htmlLayout;

	  // --------------------------------------------------------------------------------

	  public Desktop() {
	    initGUI();
	  }

	  // --------------------------------------------------------------------------------

	  private void initGUI() {
	    add(initTemplate1());
	  }

	  // --------------------------------------------------------------------------------

	  private Component initTemplate1() {
	    try {
	      htmlLayout = new HtmlLayout( //
	          getClass().getResourceAsStream("template1.html"), "UTF-8");
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }

	    HtmlLayoutData hld;

	    hld = new HtmlLayoutData("head");
	    Component menuHead = initMenuHead();;
	    menuHead.setLayoutData(hld);
	    htmlLayout.add(menuHead);
	    
	    hld = new HtmlLayoutData("main");
	    Button btnClickToEnter = new Button("Click me to enter!!!");
	    btnClickToEnter.setStyle(GUIStyles.DEFAULT_STYLE);
	    btnClickToEnter.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	        btnClickToEnterClicked();
	      }
	    });
	    btnClickToEnter.setId("main"); // Para poder removerlo luego
	    btnClickToEnter.setLayoutData(hld);
	    htmlLayout.add(btnClickToEnter);

	    return htmlLayout;
	  }
	  // --------------------------------------------------------------------------------
	  private Component initMenuHead() {
		    Row row = new Row();

		    Button btnRanking = new Button("Ver Clasificacion");
		    btnRanking.setStyle(GUIStyles.DEFAULT_STYLE);
		    btnRanking.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnRankingClicked();
		      }
		    });
		    row.add(btnRanking);

		    Button btnAboutGame = new Button("Acerca del Juego");
		    btnAboutGame.setStyle(GUIStyles.DEFAULT_STYLE);
		    btnAboutGame.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnAboutGameClicked();
		      }
		    });
		    row.add(btnAboutGame);

		    Button btnRing = new Button("HOME anillo aqui");
		    btnRing.setStyle(GUIStyles.DEFAULT_STYLE);
		    btnRing.addActionListener(new ActionListener() {
		    	@Override
		    	public void actionPerformed(ActionEvent evt) {
		    		btnRingClicked();
		    	}
		    });
		    row.add(btnRing);

		    Button btnForo = new Button("Foro");
		    btnForo.setStyle(GUIStyles.DEFAULT_STYLE);
		    btnForo.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnForoClicked();
		      }
		    });
		    row.add(btnForo);

		    Button btnMedia = new Button("Multimedia");
		    btnMedia.setStyle(GUIStyles.DEFAULT_STYLE);
		    btnMedia.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnMediaClicked();
		      }
		    });
		    row.add(btnMedia);


		    return row;
		  }

	  // --------------------------------------------------------------------------------

	  private void btnRankingClicked() {
		    HtmlLayoutData hld = new HtmlLayoutData("main");
		    PanelRanking pnlMain = new PanelRanking();
		    pnlMain.setId("main");
		    pnlMain.setLayoutData(hld);

		    // Remueve componente anterior del htmlLayout 
		    htmlLayout.remove(htmlLayout.getComponent("main"));
		    htmlLayout.add(pnlMain);
		  }

	  // --------------------------------------------------------------------------------

	  private void btnAboutGameClicked() {
		  HtmlLayoutData hld = new HtmlLayoutData("main");
		  PanelAboutGame pnlMain = new PanelAboutGame();
		  pnlMain.setId("main");
		  pnlMain.setLayoutData(hld);

		  // Remueve componente anterior del htmlLayout 
		  htmlLayout.remove(htmlLayout.getComponent("main"));
		  htmlLayout.add(pnlMain);
		  }

	  // --------------------------------------------------------------------------------

	  private void btnForoClicked() {
		    HtmlLayoutData hld = new HtmlLayoutData("main");
		    PanelForo pnlMain = new PanelForo();
		    pnlMain.setId("main");
		    pnlMain.setLayoutData(hld);

		    // Remueve componente anterior del htmlLayout 
		    htmlLayout.remove(htmlLayout.getComponent("main"));
		    htmlLayout.add(pnlMain);
		  }

	  // --------------------------------------------------------------------------------

	  private void btnMediaClicked() {
		    HtmlLayoutData hld = new HtmlLayoutData("main");
		    PanelMedia pnlMain = new PanelMedia();
		    pnlMain.setId("main");
		    pnlMain.setLayoutData(hld);

		    // Remueve componente anterior del htmlLayout 
		    htmlLayout.remove(htmlLayout.getComponent("main"));
		    htmlLayout.add(pnlMain);
		  }

	  //-------------------------------------------------------------------------------

	  private void btnRingClicked() {
		    removeAll();
		    add(initTemplate1());
		  }

	  
	  // --------------------------------------------------------------------------------

	  private void btnClickToEnterClicked() {
	    removeAll();
	    add(initTemplate2());
	  }

	  // --------------------------------------------------------------------------------

	  private Component initTemplate2() {
	    try {
	      htmlLayout = new HtmlLayout( //
	          getClass().getResourceAsStream("template2.html"), "UTF-8");
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }

	    HtmlLayoutData hld;

	    hld = new HtmlLayoutData("head");
	    Component menuHead = initMenuHead2();;
	    menuHead.setLayoutData(hld);
	    htmlLayout.add(menuHead);

	    hld = new HtmlLayoutData("menui");
	    Component menui = initMenui();
	    menui.setLayoutData(hld);
	    htmlLayout.add(menui);

  	    hld = new HtmlLayoutData("main");
	    Label lblMain = new Label("¡...main...!");
	    lblMain.setId("main"); // Para poder removerlo luego
	    lblMain.setLayoutData(hld);
	    htmlLayout.add(lblMain);

	    hld = new HtmlLayoutData("menud");
	    Component menud = initMenud();
	    menud.setLayoutData(hld);
	    htmlLayout.add(menud);

	    return htmlLayout;
	  }
	  
	  private Component initMenuHead2() {
		    Row row = new Row();
		    
		    Button btnMisiones = new Button("Misiones");
		    btnMisiones.setStyle(GUIStyles.DEFAULT_STYLE);
		    btnMisiones.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnMisionesClicked();
		      }
		    });
		    row.add(btnMisiones);

		    Button btnRecargarAnillo = new Button("Recargar Anillo");
		    btnRecargarAnillo.setStyle(GUIStyles.DEFAULT_STYLE);
		    btnRecargarAnillo.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnRecargarAnilloClicked();
		      }
		    });
		    row.add(btnRecargarAnillo);

		    Button btnAtacar = new Button("Atacar");
		    btnAtacar.setStyle(GUIStyles.DEFAULT_STYLE);
		    btnAtacar.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnAtacarClicked();
		      }
		    });
		    row.add(btnAtacar);

		    Button btnViajarPlaneta = new Button("Viajar a Otro Planeta");
		    btnViajarPlaneta.setStyle(GUIStyles.DEFAULT_STYLE);
		    btnViajarPlaneta.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnViajarPlanetaClicked();
		      }
		    });
		    row.add(btnViajarPlaneta);

		    Button btnRing = new Button("HOME anillo aqui");
		    btnRing.setStyle(GUIStyles.DEFAULT_STYLE);
		    btnRing.addActionListener(new ActionListener() {
		    	@Override
		    	public void actionPerformed(ActionEvent evt) {
		    		btnRing2Clicked();
		    	}
		    });
		    row.add(btnRing);
		    
		    Button btnRanking = new Button("Ver Clasificacion");
		    btnRanking.setStyle(GUIStyles.DEFAULT_STYLE);
		    btnRanking.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnRankingClicked();
		      }
		    });
		    row.add(btnRanking);

		    Button btnAboutGame = new Button("Acerca del Juego");
		    btnAboutGame.setStyle(GUIStyles.DEFAULT_STYLE);
		    btnAboutGame.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnAboutGameClicked();
		      }
		    });
		    row.add(btnAboutGame);

		    Button btnForo = new Button("Foro");
		    btnForo.setStyle(GUIStyles.DEFAULT_STYLE);
		    btnForo.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnForoClicked();
		      }
		    });
		    row.add(btnForo);

		    Button btnMedia = new Button("Multimedia");
		    btnMedia.setStyle(GUIStyles.DEFAULT_STYLE);
		    btnMedia.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnMediaClicked();
		      }
		    });
		    row.add(btnMedia);


		    return row;
		  }
	  
	  protected void btnRing2Clicked() {
		  	removeAll();
		    add(initTemplate2());
		
	}

	protected void btnViajarPlanetaClicked() {
		  HtmlLayoutData hld = new HtmlLayoutData("main");
		    PanelViajarPlaneta pnlMain = new PanelViajarPlaneta();
		    pnlMain.setId("main");
		    pnlMain.setLayoutData(hld);

		    // Remueve componente anterior del htmlLayout 
		    htmlLayout.remove(htmlLayout.getComponent("main"));
		    htmlLayout.add(pnlMain);
	}

	protected void btnAtacarClicked() {
		  	HtmlLayoutData hld = new HtmlLayoutData("main");
		    PanelAtacar pnlMain = new PanelAtacar();
		    pnlMain.setId("main");
		    pnlMain.setLayoutData(hld);

		    // Remueve componente anterior del htmlLayout 
		    htmlLayout.remove(htmlLayout.getComponent("main"));
		    htmlLayout.add(pnlMain);
		
	}

	protected void btnRecargarAnilloClicked() {
		  	HtmlLayoutData hld = new HtmlLayoutData("main");
		    PanelRecargarAnillo pnlMain = new PanelRecargarAnillo();
		    pnlMain.setId("main");
		    pnlMain.setLayoutData(hld);

		    // Remueve componente anterior del htmlLayout 
		    htmlLayout.remove(htmlLayout.getComponent("main"));
		    htmlLayout.add(pnlMain);

	}

	protected void btnMisionesClicked() {
		  	HtmlLayoutData hld = new HtmlLayoutData("main");
		    PanelMisiones pnlMain = new PanelMisiones();
		    pnlMain.setId("main");
		    pnlMain.setLayoutData(hld);

		    // Remueve componente anterior del htmlLayout 
		    htmlLayout.remove(htmlLayout.getComponent("main"));
		    htmlLayout.add(pnlMain);

	}

	private Component initMenud() {
		Grid grid = new Grid(2);
		return grid;
	}

	private Component initMenui() {
		Column col = new Column();

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

	    Button btnVerHabilidadesAnillo = new Button("Ver Habilidades del Anillo");
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

	    return col;		
	}

	// --------------------------------------------------------------------------------


	  private void btnMiGrupoClicked() {
	    HtmlLayoutData hld = new HtmlLayoutData("main");
	    PanelMiGrupo pnlMain = new PanelMiGrupo();
	    pnlMain.setId("main");
	    pnlMain.setLayoutData(hld);

	    // Remueve componente anterior del htmlLayout 
	    htmlLayout.remove(htmlLayout.getComponent("main"));
	    htmlLayout.add(pnlMain);
	  }

	  // --------------------------------------------------------------------------------

	  private void btnCrearGrupoClicked() {
	    HtmlLayoutData hld = new HtmlLayoutData("main");
	    PanelCrearGrupo pnlMain = new PanelCrearGrupo();
	    pnlMain.setId("main");
	    pnlMain.setLayoutData(hld);

	    // Remueve componente anterior del htmlLayout 
	    htmlLayout.remove(htmlLayout.getComponent("main"));
	    htmlLayout.add(pnlMain);
	  }

	  // --------------------------------------------------------------------------------

	  private void btnVerInvitacionesClicked() {
	    HtmlLayoutData hld = new HtmlLayoutData("main");
	    PanelVerInvitaciones pnlMain = new PanelVerInvitaciones();
	    pnlMain.setId("main");
	    pnlMain.setLayoutData(hld);

	    // Remueve componente anterior del htmlLayout 
	    htmlLayout.remove(htmlLayout.getComponent("main"));
	    htmlLayout.add(pnlMain);
	  }

	  // --------------------------------------------------------------------------------

	  private void btnInvitarNuevosUsuariosClicked() {
	    HtmlLayoutData hld = new HtmlLayoutData("main");
	    PanelInvitarNuevosUsuarios pnlMain = new PanelInvitarNuevosUsuarios();
	    pnlMain.setId("main");
	    pnlMain.setLayoutData(hld);

	    // Remueve componente anterior del htmlLayout 
	    htmlLayout.remove(htmlLayout.getComponent("main"));
	    htmlLayout.add(pnlMain);
	  }

	  // --------------------------------------------------------------------------------

	  private void btnVerHabilidadesAnilloClicked() {
		    HtmlLayoutData hld = new HtmlLayoutData("main");
		    PanelVerHabilidadesAnillo pnlMain = new PanelVerHabilidadesAnillo();
		    pnlMain.setId("main");
		    pnlMain.setLayoutData(hld);

		    // Remueve componente anterior del htmlLayout 
		    htmlLayout.remove(htmlLayout.getComponent("main"));
		    htmlLayout.add(pnlMain);
		  }
	// --------------------------------------------------------------------------------
	  private void btnEditarDatosUsuarioClicked() {
		    HtmlLayoutData hld = new HtmlLayoutData("main");
		    PanelEditarDatosUsuario pnlMain = new PanelEditarDatosUsuario();
		    pnlMain.setId("main");
		    pnlMain.setLayoutData(hld);

		    // Remueve componente anterior del htmlLayout 
		    htmlLayout.remove(htmlLayout.getComponent("main"));
		    htmlLayout.add(pnlMain);
		  }

	// --------------------------------------------------------------------------------
	  private void btnExitClicked() {
	    removeAll();
	    add(initTemplate1());
	  }
}
