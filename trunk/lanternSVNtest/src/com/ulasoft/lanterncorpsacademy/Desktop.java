package com.ulasoft.lanterncorpsacademy;

import nextapp.echo.app.Button;
import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;

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
    Label lblHead = new Label("¡...head...!");
    lblHead.setLayoutData(hld);
    htmlLayout.add(lblHead);

    hld = new HtmlLayoutData("cent");
    Button btnClickToEnter = new Button("Click me to enter!!!");
    btnClickToEnter.setStyle(GUIStyles.DEFAULT_STYLE);
    btnClickToEnter.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        btnClickToEnterClicked();
      }
    });
    btnClickToEnter.setLayoutData(hld);
    htmlLayout.add(btnClickToEnter);

    hld = new HtmlLayoutData("foot");
    Label lblFoot = new Label("¡...foot...!");
    lblFoot.setLayoutData(hld);
    htmlLayout.add(lblFoot);

    return htmlLayout;
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

    hld = new HtmlLayoutData("menu");
    Component menu = initMenu();
    menu.setLayoutData(hld);
    htmlLayout.add(menu);

    hld = new HtmlLayoutData("head");
    Label lblHead = new Label("¡...head...!");
    lblHead.setLayoutData(hld);
    htmlLayout.add(lblHead);

    hld = new HtmlLayoutData("main");
    Label lblMain = new Label("¡...main...!");
    lblMain.setId("main"); // Para poder removerlo luego
    lblMain.setLayoutData(hld);
    htmlLayout.add(lblMain);

    hld = new HtmlLayoutData("foot");
    Label lblFoot = new Label("¡...foot...!");
    lblFoot.setLayoutData(hld);
    htmlLayout.add(lblFoot);

    return htmlLayout;
  }

  // --------------------------------------------------------------------------------

  private Component initMenu() {
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
    PanelItem1 pnlMain = new PanelItem1();
    pnlMain.setId("main");
    pnlMain.setLayoutData(hld);

    // Remueve componente anterior del htmlLayout 
    htmlLayout.remove(htmlLayout.getComponent("main"));
    htmlLayout.add(pnlMain);
  }

  // --------------------------------------------------------------------------------

  private void btnAboutGameClicked() {
    HtmlLayoutData hld = new HtmlLayoutData("main");
    PanelItem2 pnlMain = new PanelItem2();
    pnlMain.setId("main");
    pnlMain.setLayoutData(hld);

    // Remueve componente anterior del htmlLayout 
    htmlLayout.remove(htmlLayout.getComponent("main"));
    htmlLayout.add(pnlMain);
  }

  // --------------------------------------------------------------------------------

  private void btnForoClicked() {
    HtmlLayoutData hld = new HtmlLayoutData("main");
    PanelItem3 pnlMain = new PanelItem3();
    pnlMain.setId("main");
    pnlMain.setLayoutData(hld);

    // Remueve componente anterior del htmlLayout 
    htmlLayout.remove(htmlLayout.getComponent("main"));
    htmlLayout.add(pnlMain);
  }

  // --------------------------------------------------------------------------------

  private void btnMediaClicked() {
    HtmlLayoutData hld = new HtmlLayoutData("main");
    PanelItem4 pnlMain = new PanelItem4();
    pnlMain.setId("main");
    pnlMain.setLayoutData(hld);

    // Remueve componente anterior del htmlLayout 
    htmlLayout.remove(htmlLayout.getComponent("main"));
    htmlLayout.add(pnlMain);
  }

  // --------------------------------------------------------------------------------

  private void btnRingClicked() {
    removeAll();
    add(initTemplate1());
  }
}
