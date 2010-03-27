/**
 * 
 */
package com.ulasoft.lanterncorpsacademy;

import java.util.ArrayList;
import java.util.List;

import org.informagen.echo.app.CapacityBar;

import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;

import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.FillImage;
import nextapp.echo.app.Grid;
import nextapp.echo.app.ImageReference;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.PasswordField;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
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
	      setInsets(new Insets(2, 2, 2, 2));
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
	    Component login = initLogin();
	    login.setId("main");
	    login.setLayoutData(hld);
	    htmlLayout.add(login);
	    htmlLayout.setAlignment(Alignment.ALIGN_CENTER);
	   // htmlLayout.setBackground(new Color(0x00, 0xFF, 0x00));
	    return htmlLayout;
	  }
	  private Component initLogin() {
		
		Row row1 = new Row();
		row1.setCellSpacing(new Extent(400));
		
		Label lbl = new Label("");
		row1.add(lbl);
		
		Column col = new Column();
		col.setInsets(new Insets(5,5,5,5));
		col.setCellSpacing(new Extent(10));
		col.setBackground(Color.WHITE);
		
		Label lblTitle = new Label("Ingresar al Sistema");
	    col.add(lblTitle);
	    
		Grid grid = new Grid();
		grid.setStyle(GUIStyles.DEFAULT_STYLE);
		Label lblCorreo = new Label("Correo");
	    grid.add(lblCorreo);
	    
	    TextField txtCorreo = new TextField();
	    txtCorreo.setWidth(new Extent(300));
	    txtCorreo.setText("HalJordan@greenlantern.corp");
	    grid.add(txtCorreo);
	    
	    Label lblPass = new Label("Contraseña");
	    grid.add(lblPass);
	    
	    PasswordField fldPass = new PasswordField();
	    fldPass.setWidth(new Extent(300));
	    grid.add(fldPass);
		col.add(grid);
		
		Row row = new Row();
		Button btnClickToEnter = new Button("Entrar");
	    btnClickToEnter.setStyle(GUIStyles.STYLE);
	    btnClickToEnter.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	        btnClickToEnterClicked();
	      }
	    });
	    row.add(btnClickToEnter);

	    Button btnClickToRegister = new Button("Eres Nuevo? Regístrate");
	    btnClickToRegister.setStyle(GUIStyles.STYLE);
	    btnClickToRegister.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	    	  btnClickToRegisterClicked();
	      }
	    });
	    row.add(btnClickToRegister);
	    row.setCellSpacing(new Extent(10));
		col.add(row);
		row1.add(col);
		
		//row1.add(lbl);
		return row1;
	}

	protected void btnClickToRegisterClicked() {
		 HtmlLayoutData hld = new HtmlLayoutData("main");
		 PanelRegistro1 pnlMain = new PanelRegistro1();
		 pnlMain.setId("main");
		 pnlMain.setLayoutData(hld);

	    // Remueve componente anterior del htmlLayout 
	    htmlLayout.remove(htmlLayout.getComponent("main"));
	    htmlLayout.add(pnlMain);	
	}

	// --------------------------------------------------------------------------------
	  private Component initMenuHead() {
		    Row row = new Row();
		    row.setInsets(new Insets(125,1,1,1));
		    
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

		    Button btnRing = new Button();
		    //btnRing.setDisabledBackgroundImage(new FillImage(new ResourceImageReference("com/ulasoft/lanterncorpsacademy/linterna.png")));
		    //btnRing.setAlignment(Alignment.ALIGN_CENTER);
		    btnRing.setIcon(new ResourceImageReference("com/ulasoft/lanterncorpsacademy/linterna.png"));
		    //btnRing.setStyle(GUIStyles.DEFAULT_STYLE);
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
	    htmlLayout.setAlignment(Alignment.ALIGN_CENTER);
	    
	    hld = new HtmlLayoutData("menui");
	    Component menui = initMenui();
	    menui.setLayoutData(hld);
	    htmlLayout.add(menui);

  	    hld = new HtmlLayoutData("main");
  	    Component main = main();
	    main.setLayoutData(hld);
	    main.setId("main"); // Para poder removerlo luego
	    main.setLayoutData(hld);
	    htmlLayout.add(main);

	    hld = new HtmlLayoutData("menud");
	    Component menud = initMenud();
	    menud.setLayoutData(hld);
	    htmlLayout.add(menud);
	    
	    htmlLayout.setAlignment(Alignment.ALIGN_CENTER);
	    return htmlLayout;
	  }
	  
	  private Component main() {
		Row row = new Row();
		row.setCellSpacing(new Extent(250));
		row.add(new Label(""));
		Grid grid = new Grid(2);
		grid.setBackground(Color.WHITE);
		Label lblImagen = new Label(); 
		lblImagen.setIcon(new ResourceImageReference("com/ulasoft/lanterncorpsacademy/GreenLanternRebirthHC1.jpg",new Extent(152), new Extent(232)));
		grid.add(lblImagen);
		Column col = new Column();
		col.add(new Label("Ubicación"));
		col.add(new Label("Planeta:"));
		col.add(new Label("Sector:"));
		col.add(new Label("Estadísticas"));
		col.add(new Label("Combates Ganados:"));
		col.add(new Label("Combates Perdidos:"));
		col.add(new Label("Misiones Realizadas:"));
		col.add(new Label("Ultimo Ingreso"));
		col.add(new Label("Fecha:"));
		col.add(new Label("Hora:"));
		grid.add(col);
		row.add(grid);
		return row;
	}

	private Component initMenuHead2() {
		    Row row = new Row();
		    row.setInsets(new Insets(30,1,1,1));
		    
		    Button btnMisiones = new Button("Misiones");
		    btnMisiones.setStyle(GUIStyles.STYLE2);
		    btnMisiones.setWidth(new Extent(100));
		    btnMisiones.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnMisionesClicked();
		      }
		    });
		    row.add(btnMisiones);
		    
		    Button btnAtacar = new Button("Atacar");
		    btnAtacar.setStyle(GUIStyles.STYLE2);
		    btnAtacar.setWidth(new Extent(100));
		    btnAtacar.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnAtacarClicked();
		      }
		    });
		    row.add(btnAtacar);

		    Button btnRecargarAnillo = new Button("Recargar Anillo");
		    btnRecargarAnillo.setStyle(GUIStyles.STYLE2);
		    btnRecargarAnillo.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnRecargarAnilloClicked();
		      }
		    });
		    row.add(btnRecargarAnillo);

		    Button btnViajarPlaneta = new Button("Viajar a Otro Planeta");
		    btnViajarPlaneta.setStyle(GUIStyles.STYLE2);
		    btnViajarPlaneta.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnViajarPlanetaClicked();
		      }
		    });
		    row.add(btnViajarPlaneta);

		    Button btnRing = new Button();
		    //btnRing.setBorder(new Border(new Extent(1), Color.BLACK, Border.STYLE_SOLID));
		    //btnRing.setBackground(Color.GREEN);
		    //btnRing.setDisabledIcon(new ResourceImageReference("com/ulasoft/lanterncorpsacademy/linterna.png"));
		    btnRing.setIcon(new ResourceImageReference("com/ulasoft/lanterncorpsacademy/linterna.png"));
		    //btnRing.setStyle(GUIStyles.STYLE);
		    btnRing.addActionListener(new ActionListener() {
		    	@Override
		    	public void actionPerformed(ActionEvent evt) {
		    		btnRing2Clicked();
		    	}
		    });
		    row.add(btnRing);
		    
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

		    Button btnForo = new Button("Foro");
		    btnForo.setStyle(GUIStyles.STYLE2);
		    btnForo.setWidth(new Extent(100));
		    btnForo.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent evt) {
		    	  btnForoClicked();
		      }
		    });
		    row.add(btnForo);

		    Button btnMedia = new Button("Multimedia");
		    btnMedia.setStyle(GUIStyles.STYLE2);
		    btnMedia.setWidth(new Extent(100));
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
		
		Label lblSalud = new Label("Salud");
	    grid.add(lblSalud);
		
	    //PROGRESS BAR AQUI
		CapacityBar salud= new CapacityBar(17,250);
		salud.setReflectivity(0.01);
		List<Color> colors= new ArrayList<Color>(2);
		colors.add(Color.RED);
		colors.add(Color.WHITE);
	    salud.setColors(colors);
	    List<Number> values= new ArrayList<Number>(2);
	    values.add(95);
	    values.add(5);
	    salud.setValues(values);
	    salud.setTickSpacing(20);
	    grid.add(salud);
	    
	    Label lblEnergia = new Label("Energia del Anillo");
	    grid.add(lblEnergia);
		
	    //PROGRESS BAR AQUI
	    CapacityBar energia= new CapacityBar(17,250);
	    energia.setReflectivity(0.02);
	    List<Color> colors2= new ArrayList<Color>(2);
	    colors2.add(Color.GREEN);
	    colors2.add(Color.WHITE);
	    energia.setColors(colors2);
	    List<Number> values2= new ArrayList<Number>(2);
	    values2.add(90);
	    values2.add(10);
	    energia.setValues(values2);
	    energia.setTickSpacing(20);
	    grid.add(energia);
	    
	    Label lblExperiencia = new Label("Experiencia");
	    grid.add(lblExperiencia);
		
	    CapacityBar experiencia= new CapacityBar(17, 250);
	    experiencia.setReflectivity(0.03);
	    List<Color> colors3= new ArrayList<Color>(2);
		colors3.add(Color.DARKGRAY);
		colors3.add(Color.WHITE);
	    experiencia.setColors(colors3);
	    List<Number> values3= new ArrayList<Number>(2);
	    values3.add(20);
	    values3.add(80);
	    experiencia.setValues(values3);
	    experiencia.setTickSpacing(20);
	    grid.add(experiencia);
	    //PROGRESS BAR AQUI
	    
	    Label lblTrains = new Label("Puntos de Entrenamiento:");
	    grid.add(lblTrains);
	    
	    Label lblTrainsValue = new Label("XXXXX");
	    grid.add(lblTrainsValue);
	    
	    Label lblNivel = new Label("NIvel");
	    grid.add(lblNivel);
	    
	    Label lblNiveLabel = new Label("XXXXX");
	    grid.add(lblNiveLabel);
		
	    grid.setStyle(GUIStyles.DEFAULT_STYLE);
	    grid.setHeight(new Extent(315));
	    
	    	    
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
