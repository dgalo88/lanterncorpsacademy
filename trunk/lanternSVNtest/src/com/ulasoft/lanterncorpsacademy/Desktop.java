package com.ulasoft.lanterncorpsacademy;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.FillImageBorder;
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
import com.ulasoft.lanterncorpsacademy.menus.MenuStatus;
import com.ulasoft.lanterncorpsacademy.paneles.PanelLogin;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMain;

import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;

@SuppressWarnings("serial")
public class Desktop extends ContentPane {

	private HtmlLayout htmlLayout;
	private HtmlLayoutData hld;
	private WindowPane windowPane;
	private WindowPane windowData;
	private MenuStatus menuStatus;
	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
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
			htmlLayout = new HtmlLayout(getClass().getResourceAsStream( //
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

	public Component initTemplate2() {
		try {
			setInsets(new Insets(2, 2, 2, 2));
			htmlLayout = new HtmlLayout(getClass().getResourceAsStream( //
					"templatehtml/template2.html"), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		Atributos atrib = app.getAtributos();

		htmlLayout.setBackground(new Color (0, 0, 0));
		htmlLayout.setBackgroundImage(new ResourceImageReference(ImgLoad.fondo(app
				.getAtributos().getPersonaje())));

		hld = new HtmlLayoutData("head");
		MenuHead menuHead = new MenuHead(true);
		menuHead.setLayoutData(hld);
		htmlLayout.add(menuHead);
		htmlLayout.setAlignment(Alignment.ALIGN_CENTER);

		hld = new HtmlLayoutData("headStatus");
		menuStatus = new MenuStatus();
		try {
			atrib.updateMenuStatus(menuStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		menuStatus.setLayoutData(hld);
		htmlLayout.add(menuStatus);
		htmlLayout.setAlignment(Alignment.ALIGN_LEFT);

		hld = new HtmlLayoutData("headButton");
		MenuButton menuButton = new MenuButton();
		menuButton.setLayoutData(hld);
		htmlLayout.add(menuButton);
		htmlLayout.setAlignment(Alignment.ALIGN_RIGHT);

		hld = new HtmlLayoutData("menu");
		Menu menu = new Menu();
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

	public void setWindowPaneEmergente(String texto) {

		Column col = new Column();
		Row row = new Row();
		windowPane = new WindowPane("Información", new Extent(300), new Extent(150));
		windowPane.setModal(true);
		windowPane.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		windowPane.setTitleBackground(Estilo.getColor(app.getAtributos()));
		windowPane.setBackground(Color.WHITE);
		windowPane.setBorder(new FillImageBorder(Color.BLACK, new Insets(2), new Insets(2)));

		Label txt = new Label(texto);
		txt.setTextAlignment(Alignment.ALIGN_CENTER);
		row.add(txt);
		row.setAlignment(Alignment.ALIGN_CENTER);
		row.setInsets(new Insets(10, 10, 10, 10));
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

	// --------------------------------------------------------------------------------

	public void setWindowData(Component component) {

		Column col = new Column();
		Row row = new Row();
		windowData = new WindowPane("Mis Datos", new Extent(600), new Extent(250));
		windowData.setModal(false);
		windowData.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		windowData.setTitleBackground(Estilo.getColor(app.getAtributos()));
		windowData.setBackground(Color.WHITE);
		windowData.setBorder(new FillImageBorder(Color.BLACK, new Insets(2), new Insets(2)));

		row.add(component);
		row.setAlignment(Alignment.ALIGN_CENTER);
		row.setInsets(new Insets(10, 10, 10, 10));

		col.add(row);
		windowData.add(col);
		add(windowData);

	}

	// --------------------------------------------------------------------------------

	public MenuStatus getMenuStatus() {
		return menuStatus;
	}

	public void setMenud(MenuStatus menuStatus) {
		this.menuStatus = menuStatus;
	}

}
