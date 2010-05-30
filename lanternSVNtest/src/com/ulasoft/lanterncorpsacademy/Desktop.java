package com.ulasoft.lanterncorpsacademy;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUsuarioDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.WindowPane;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.logic.Atributos;
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
	private WindowPane windowPane;
	//private IPersonajeDO personajeDO;

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

		return htmlLayout;
	}

	// --------------------------------------------------------------------------------

  // XXX: DMI: Ya no necesito pasar atrib, porque lo puedo sacar de la aplicación. Claro,
  // asumiendo que el usuario ya hizo login. Si la application retorna nulo para el atrib
  // entonces quiere decir que el usuario no ha hecho login
  // public Component initTemplate2(IPersonajeDO personaje, IUsuarioDO usuario, Atributos atrib) {
  public Component initTemplate2() {
		try {
			htmlLayout = new HtmlLayout( //
					getClass().getResourceAsStream(
							"templatehtml/template2.html"), "UTF-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
    // De esta forma se puede acceder universalmente a la aplicacion desde cualquier caso
    // Recordar que como es una aplicacion WEB, cada sesion o conexión de usuario (cliente)
    // tiene su propia App
    LanternCorpsAcademyApp lca = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
    Atributos atrib = lca.getAtributos();

		//Atributos atts= new Atributos();
//		atrib.setPersonaje(personaje);
//		atrib.setUsuario(usuario);
		
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

		//System.err.println("PERSONAJE ID en desk:"+personaje.getId());
		hld = new HtmlLayoutData("menud");
		Menud menud = new Menud();
		try {
			atrib.updateMenud(menud);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		menud.setPersonaje(personaje);
		menud.setLayoutData(hld);
		htmlLayout.add(menud);

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
		htmlLayout.add(panel);

	}

	// --------------------------------------------------------------------------------

	public void setWindowPaneEmergente(String texto) {
		Column col = new Column();
		windowPane = new WindowPane();
		windowPane.setStyle(GUIStyles.DEFAULT_STYLE);
		windowPane.setTitle("Informacion");
		windowPane.setModal(true);
		windowPane.setHeight(new Extent(200));
		windowPane.setWidth(new Extent(200));
		col.add(new Label(texto));
		Button btnOk = new Button("Ok");
		btnOk.setStyle(GUIStyles.STYLE2);
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				remove(windowPane);
			}
		});
		col.add(btnOk);
		windowPane.add(col);
		add(windowPane);
	}

//	public IPersonajeDO getPersonajeDO() {
//		return personajeDO;
//	}
//
//	public void setPersonajeDO(IPersonajeDO personajeDO) {
//		this.personajeDO = personajeDO;
//	}

}
