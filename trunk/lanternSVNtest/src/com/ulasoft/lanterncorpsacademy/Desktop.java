package com.ulasoft.lanterncorpsacademy;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Color;
import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;

import com.ulasoft.lanterncorpsacademy.menus.MenuHead;
import com.ulasoft.lanterncorpsacademy.menus.MenuHead2;
import com.ulasoft.lanterncorpsacademy.menus.MenuI;
import com.ulasoft.lanterncorpsacademy.menus.Menud;
import com.ulasoft.lanterncorpsacademy.paneles.PanelLogin;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMain;

import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;

/**
 * @author typson julian Jose
 *
 */

@SuppressWarnings("serial")
public class Desktop extends ContentPane {

	private HtmlLayout htmlLayout;
	private HtmlLayoutData hld;
	

	// --------------------------------------------------------------------------------

	public Desktop() {
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
			htmlLayout = new HtmlLayout( //
					getClass().getResourceAsStream("template1.html"), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}


		hld = new HtmlLayoutData("head");
		MenuHead menuHead = new MenuHead();
		menuHead.setLayoutData(hld);
		htmlLayout.add(menuHead);

		hld = new HtmlLayoutData("main");
		PanelLogin login = new PanelLogin();
		login.setId("main");
		login.setLayoutData(hld);
		htmlLayout.add(login);
		htmlLayout.setAlignment(Alignment.ALIGN_CENTER);
		// htmlLayout.setBackground(new Color(0x00, 0xFF, 0x00));
		return htmlLayout;
	}


	// --------------------------------------------------------------------------------

	public Component initTemplate2() {
		try {
			htmlLayout = new HtmlLayout( //
					getClass().getResourceAsStream("template2.html"), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		hld = new HtmlLayoutData("head");
		MenuHead2 menuHead = new MenuHead2();
		menuHead.setLayoutData(hld);
		htmlLayout.add(menuHead);
		htmlLayout.setAlignment(Alignment.ALIGN_CENTER);

		hld = new HtmlLayoutData("menui");
		MenuI menui = new MenuI();
		menui.setLayoutData(hld);
		htmlLayout.add(menui);

		hld = new HtmlLayoutData("main");
		PanelMain main = new PanelMain();
		main.setLayoutData(hld);
		main.setId("main"); // Para poder removerlo luego
		main.setLayoutData(hld);
		htmlLayout.add(main);

		hld = new HtmlLayoutData("menud");
		Menud menud = new Menud();
		menud.setLayoutData(hld);
		htmlLayout.add(menud);

		htmlLayout.setAlignment(Alignment.ALIGN_CENTER);
		return htmlLayout;
	}

	// --------------------------------------------------------------------------------
	
	public void setPanelCentral(Panel panel){
		hld = new HtmlLayoutData("main");
		panel.setId("main");
		panel.setLayoutData(hld);
		// Remueve componente anterior del htmlLayout
		htmlLayout.remove(htmlLayout.getComponent("main"));
		htmlLayout.add(panel);
	
	}

}
