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
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.ImgLoad;
import com.ulasoft.lanterncorpsacademy.menus.Menu;
import com.ulasoft.lanterncorpsacademy.menus.MenuButton;
import com.ulasoft.lanterncorpsacademy.menus.MenuHead;
import com.ulasoft.lanterncorpsacademy.menus.MenuInicial;
import com.ulasoft.lanterncorpsacademy.menus.Menud;
import com.ulasoft.lanterncorpsacademy.paneles.PanelLogin;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMain;

import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;

/**
 * @author Donato Galo
 * 
 */

@SuppressWarnings("serial")
public class Desktop extends ContentPane {
	private HtmlLayout htmlLayout;
	private HtmlLayoutData hld;
	private WindowPane windowPane;
	private Menud menud;
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
		LanternCorpsAcademyApp.getActive();

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
			htmlLayout = new HtmlLayout(getClass().getResourceAsStream(
					"templatehtml/template1.html"), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		htmlLayout.setBackground(new Color (0, 0, 0));

		hld = new HtmlLayoutData("head");
		MenuHead menuHead = new MenuHead(false);
		menuHead.setLayoutData(hld);
		htmlLayout.add(menuHead);

		hld = new HtmlLayoutData("title");
		Component lbltitle = new Label();
		lbltitle.setLayoutData(hld);
		htmlLayout.add(lbltitle);

		hld = new HtmlLayoutData("menu");
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

		public Component initTemplate2(int ctl) {
			try {
				htmlLayout = new HtmlLayout( //
						getClass().getResourceAsStream(
							"templatehtml/template2.html"), "UTF-8");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		LanternCorpsAcademyApp lca = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
		Atributos atrib = lca.getAtributos();

		htmlLayout.setBackground(new Color (0, 0, 0));
		htmlLayout.setBackgroundImage(new ResourceImageReference(ImgLoad.fondo(lca
				.getAtributos().getPersonaje())));

		hld = new HtmlLayoutData("head");
		MenuHead menuHead = new MenuHead(true);
		menuHead.setLayoutData(hld);
		htmlLayout.add(menuHead);
		htmlLayout.setAlignment(Alignment.ALIGN_CENTER);

		hld = new HtmlLayoutData("headStatus");
		menud = new Menud();
		try {
			atrib.updateMenud(menud);
		} catch (Exception e) {
			e.printStackTrace();
		}
		menud.setLayoutData(hld);
		htmlLayout.add(menud);
		htmlLayout.setAlignment(Alignment.ALIGN_LEFT);

		hld = new HtmlLayoutData("headButton");
		MenuButton menuButton = new MenuButton();
		menuButton.setLayoutData(hld);
		htmlLayout.add(menuButton);
		htmlLayout.setAlignment(Alignment.ALIGN_RIGHT);

		hld = new HtmlLayoutData("menu");
		Menu menu = new Menu(ctl);
		menu.setId("menu");
		menu.setLayoutData(hld);
		htmlLayout.add(menu);
		htmlLayout.setAlignment(Alignment.ALIGN_RIGHT);

		PanelMain main = new PanelMain();
		hld = new HtmlLayoutData("main");
		main.setId("main");
		main.setLayoutData(hld);
		htmlLayout.add(main);

		htmlLayout.setAlignment(Alignment.ALIGN_CENTER);
		return htmlLayout;
	}

	// --------------------------------------------------------------------------------

	public void setPanelCentral(Panel panel) {
		hld = new HtmlLayoutData("main");
		panel.setId("main");
		panel.setLayoutData(hld);
		// Remueve componente anterior del htmlLayout
		htmlLayout.remove(htmlLayout.getComponent("main"));
		htmlLayout.setAlignment(Alignment.ALIGN_CENTER);
		htmlLayout.add(panel);

	}

	// --------------------------------------------------------------------------------

	public void setPanelMenu(Panel panel) {
		hld = new HtmlLayoutData("menu");
		panel.setId("menu");
		panel.setLayoutData(hld);
		// Remueve componente anterior del htmlLayout
		htmlLayout.remove(htmlLayout.getComponent("menu"));
		htmlLayout.setAlignment(Alignment.ALIGN_CENTER);
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
		btnOk.setStyle(Estilo.getStyle2Color(app.getAtributos()));
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

	public Menud getMenud() {
		return menud;
	}

	public void setMenud(Menud menud) {
		this.menud = menud;
	}

}
