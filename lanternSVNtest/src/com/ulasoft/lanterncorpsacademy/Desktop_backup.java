package com.ulasoft.lanterncorpsacademy;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.menus.Menu;
import com.ulasoft.lanterncorpsacademy.menus.MenuButton;
import com.ulasoft.lanterncorpsacademy.menus.MenuHead;
import com.ulasoft.lanterncorpsacademy.menus.MenuInicial;
import com.ulasoft.lanterncorpsacademy.menus.MenuStatus;
import com.ulasoft.lanterncorpsacademy.paneles.PanelLogin;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMain;

import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;

/**
 * @author typson julian Jose
 * 
 * Update 07/12/2010 -> Donato Galo
 * 
 */

@SuppressWarnings("serial")
public class Desktop_backup extends ContentPane {

	private HtmlLayout htmlLayout;
	private HtmlLayoutData hld;
	private WindowPane windowPane;
	//private IPersonajeDO personajeDO;
	private MenuStatus menud;
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
	LanternCorpsAcademyApp.getActive();

	// --------------------------------------------------------------------------------

	public Desktop_backup() {
		initGUI();
	}

	// --------------------------------------------------------------------------------

	private void initGUI() {
		add(initTemplate1());
	}

	// --------------------------------------------------------------------------------

	public Component initTemplate1() {
		try {
			setInsets(new Insets(2, 2, 2, 2));
			htmlLayout = new HtmlLayout(getClass().getResourceAsStream(
					"templatehtml/template1.html"), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		hld = new HtmlLayoutData("head");
		MenuHead menuHead = new MenuHead(false);
		menuHead.setLayoutData(hld);
		htmlLayout.add(menuHead);

		hld = new HtmlLayoutData("title");
		Component lbltitle = new Label();
//		lbltitle.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		lbltitle.setLayoutData(hld);
		htmlLayout.add(lbltitle);

		hld = new HtmlLayoutData("menui");
		MenuInicial menuInicial = new MenuInicial();
		menuInicial.setLayoutData(hld);
		htmlLayout.add(menuInicial);

		hld = new HtmlLayoutData("main");
		PanelLogin login = new PanelLogin();
		login.setId("main");
		login.setLayoutData(hld);
		htmlLayout.add(login);

		htmlLayout.setAlignment(Alignment.ALIGN_CENTER);

		return htmlLayout;
	}

	// --------------------------------------------------------------------------------

		public Component initTemplate2() {
			try {
				htmlLayout = new HtmlLayout( //
						getClass().getResourceAsStream(
							"templatehtml/template2.html"), "UTF-8");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		LanternCorpsAcademyApp lca = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
		@SuppressWarnings("unused")
		Atributos atrib = lca.getAtributos();

		hld = new HtmlLayoutData("head");
		MenuButton menuHead = new MenuButton();
		menuHead.setLayoutData(hld);
		htmlLayout.add(menuHead);
		htmlLayout.setAlignment(Alignment.ALIGN_CENTER);

		hld = new HtmlLayoutData("menui");
		Menu menui = new Menu();
		menui.setLayoutData(hld);
		htmlLayout.add(menui);

		PanelMain main = new PanelMain();
		hld = new HtmlLayoutData("main");
		main.setId("main");

		main.setLayoutData(hld);
		htmlLayout.add(main);

//		hld = new HtmlLayoutData("menud");
//		menud = new Menud();
//		try {
//			atrib.updateMenud(menud);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		menud.setLayoutData(hld);
//		htmlLayout.add(menud);

		htmlLayout.setAlignment(Alignment.ALIGN_CENTER);
		return htmlLayout;
	}

	  // --------------------------------------------------------------------------------

//  // XXX: DMI: Ya no necesito pasar atrib, porque lo puedo sacar de la aplicación. Claro,
//  // asumiendo que el usuario ya hizo login. Si la application retorna nulo para el atrib
//  // entonces quiere decir que el usuario no ha hecho login
//  // public Component initTemplate2(IPersonajeDO personaje, IUsuarioDO usuario, Atributos atrib) {
//  public Component initTemplate2() {
//		try {
//			htmlLayout = new HtmlLayout( //
//					getClass().getResourceAsStream(
//							"templatehtml/template2.html"), "UTF-8");
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//		
//    // De esta forma se puede acceder universalmente a la aplicacion desde cualquier caso
//    // Recordar que como es una aplicacion WEB, cada sesion o conexión de usuario (cliente)
//    // tiene su propia App
//		LanternCorpsAcademyApp lca = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
//		Atributos atrib = lca.getAtributos();
//		
//
//
//		//Atributos atts= new Atributos();
////		atrib.setPersonaje(personaje);
////		atrib.setUsuario(usuario);
//		
//		hld = new HtmlLayoutData("head");
//		MenuHead2 menuHead = new MenuHead2();
//		menuHead.setLayoutData(hld);
//		htmlLayout.add(menuHead);
//		htmlLayout.setAlignment(Alignment.ALIGN_CENTER);
//
//		hld = new HtmlLayoutData("menui");
//		MenuI menui = new MenuI();
//		menui.setLayoutData(hld);
//		htmlLayout.add(menui);
//
//		PanelMain main = new PanelMain();
//		hld = new HtmlLayoutData("main");
//		main.setId("main");
////		try {
////			atrib.updatePanelMain (main);
////		} catch (Exception e1) {
////			e1.printStackTrace();
////		}
//		main.setLayoutData(hld);
//		htmlLayout.add(main);
//
//		//System.err.println("PERSONAJE ID en desk:"+personaje.getId());
//		hld = new HtmlLayoutData("menud");
//		menud = new Menud();
//		try {
//			atrib.updateMenud(menud);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
////		menud.setPersonaje(personaje);
//		menud.setLayoutData(hld);
//		htmlLayout.add(menud);
//
//		htmlLayout.setAlignment(Alignment.ALIGN_CENTER);
//		return htmlLayout;
//	}

	// --------------------------------------------------------------------------------

	public void setPanelCentral(Panel panel) {
		hld = new HtmlLayoutData("main");
		panel.setId("main");
		panel.setLayoutData(hld);
		// Remueve componente anterior del htmlLayout
		htmlLayout.remove(htmlLayout.getComponent("main"));
		htmlLayout.add(panel);

	}

	// --------------------------------------------------------------------------------

	public void setWindowPaneEmergente(String texto) {
		Column col = new Column();
		Row row = new Row();
		windowPane = new WindowPane();
		windowPane.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		windowPane.setTitle("Informacion");
		windowPane.setModal(true);
		windowPane.setHeight(new Extent(150));
		windowPane.setWidth(new Extent(300));
		windowPane.setTitleBackground(Estilo.getColor(app.getAtributos()));
		windowPane.setBackground(Color.WHITE);
		Label txt = new Label(texto);
		txt.setTextAlignment(Alignment.ALIGN_CENTER);
		row.add(txt);
		row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);
		Button btnOk = new Button("Ok");
		btnOk.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				remove(windowPane);
			}
		});
		row = new Row();
		row.add(btnOk);
		row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);
		windowPane.add(col);
		add(windowPane);
	}

	public MenuStatus getMenud() {
		return menud;
	}

	public void setMenud(MenuStatus menud) {
		this.menud = menud;
	}

//	public IPersonajeDO getPersonajeDO() {
//		return personajeDO;
//	}
//
//	public void setPersonajeDO(IPersonajeDO personajeDO) {
//		this.personajeDO = personajeDO;
//	}

}
