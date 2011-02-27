package com.ulasoft.lanterncorpsacademy;

import java.util.HashMap;
import java.util.Map;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Color;
import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.WindowPaneEvent;
import nextapp.echo.app.event.WindowPaneListener;

import com.ulasoft.lanterncorpsacademy.logic.ImgLoad;
import com.ulasoft.lanterncorpsacademy.menus.Menu;
import com.ulasoft.lanterncorpsacademy.menus.MenuButton;
import com.ulasoft.lanterncorpsacademy.menus.MenuHead;
import com.ulasoft.lanterncorpsacademy.menus.MenuInicial;
import com.ulasoft.lanterncorpsacademy.paneles.PanelLogin;
import com.ulasoft.lanterncorpsacademy.paneles.PanelMain;
import com.valkirye.lanterncorpsacademy.windows.WindowAsignarPrecio;
import com.valkirye.lanterncorpsacademy.windows.WindowData;
import com.valkirye.lanterncorpsacademy.windows.WindowInventary;
import com.valkirye.lanterncorpsacademy.windows.WindowLca;
import com.valkirye.lanterncorpsacademy.windows.WindowUnitSelect;

import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;

@SuppressWarnings("serial")
public class Desktop extends ContentPane {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private Map< Class<? extends WindowPane>, WindowPane> windowsByType = //
		new HashMap<Class<? extends WindowPane>, WindowPane>();

	private HtmlLayout htmlLayout;
	private HtmlLayoutData hld;
	private MenuHead menuHead;
	private WindowPane windowPane;

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
		menuHead = new MenuHead(false);
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

		htmlLayout.setBackground(new Color (0, 0, 0));
		htmlLayout.setBackgroundImage(new ResourceImageReference(ImgLoad.fondo(app
				.getAtributos().getPersonaje())));

		hld = new HtmlLayoutData("head");
		menuHead = new MenuHead(true);
		menuHead.setLayoutData(hld);
		htmlLayout.add(menuHead);
		htmlLayout.setAlignment(Alignment.ALIGN_CENTER);

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

	public void btnCancelarClicked() {

		PanelMain pnlMain = new PanelMain();
		setPanelCentral(pnlMain);

	}

	// --------------------------------------------------------------------------------

	public void setWindowPaneEmergente(String texto) {
		windowPane = new WindowLca(texto);
		add(windowPane);
	}

	public void setWindowData() {

		WindowData windowData = new WindowData();
		try {
			genericOpenWindow(windowData.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setWindowInventary() {

		WindowInventary windowInventary = new WindowInventary();
		try {
			genericOpenWindow(windowInventary.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setWindowUnitSelect() {

		WindowUnitSelect windowUnitSelect = new WindowUnitSelect();
		try {
			genericOpenWindow(windowUnitSelect.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setWindowAsignarPrecio() {

		WindowAsignarPrecio windowAsignarPrecio = new WindowAsignarPrecio();
		try {
			genericOpenWindow(windowAsignarPrecio.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// --------------------------------------------------------------------------------

	public MenuHead getMenuHead() {
		return menuHead;
	}

	public WindowPane getWindowPane() {
		return windowPane;
	}

	// --------------------------------------------------------------------------------

	private void genericOpenWindow(Class<? extends WindowPane> windowType) //
		throws Exception {

		WindowPane wp = windowsByType.get(windowType);

		if (wp == null) {
			// Esto crea un nuevo tipo según el Class pasado.
			wp = windowType.newInstance();
			add(wp);
			windowsByType.put(windowType, wp);

			wp.addWindowPaneListener(new WindowPaneListener() {
				@Override
				public void windowPaneClosing(WindowPaneEvent evt) {
					WindowPane source = (WindowPane) evt.getSource();
					windowsByType.remove(source.getClass());
				}
			});
		} /*else {
			raise(wp);
		}*/
	}

//	private void raise(WindowPane window) {
//
//		int maxZindex = 0;
//		List<WindowPane> listWindowPanes = new ArrayList<WindowPane>();
//		listWindowPanes.addAll(windowsByType.values());
//
//		for (int i = 0; i < listWindowPanes.size(); i++) {
//
//			WindowPane windowPane = listWindowPanes.get(i);
//
//			if (windowPane.getZIndex() > window.getZIndex()) {
//				maxZindex = windowPane.getZIndex();
//			}
//		}
//
//		window.setZIndex(maxZindex + 1);
//	}

}
