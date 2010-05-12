package com.ulasoft.lanterncorpsacademy.paneles;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;

import nextapp.echo.app.Component;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Panel;
import dao.api.FactoryDAO;
import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.lantern.ClaseLinternaDAO;
import dao.lantern.ClaseLinternaDO;
import dao.lantern.PersonajeDAO;
import dao.lantern.PersonajeDO;
import dao.lantern.UsuarioDAO;
import dao.lantern.UsuarioDO;
import echopoint.HtmlLayout;
import echopoint.layout.HtmlLayoutData;

public class PanelRegistro extends Panel {
	
	
	public HtmlLayoutData hld = new HtmlLayoutData("main");

	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
	
	private UsuarioDO usuario = new UsuarioDO();
	private PersonajeDO personaje = new PersonajeDO();
	private PanelRegistro2 registro2;
	private PanelRegistro1 registro1;

	private HtmlLayout htmlLayout;
	
	public PanelRegistro(){
		setId("main");
		setLayoutData(hld);
		registro1 = new PanelRegistro1(usuario);
		add(registro1);
	}

	
	public void changePanel(Panel panel) {
		//hld = new HtmlLayoutData("main");
		//htmlLayout.remove(htmlLayout.getComponent("main"));
//		Desktop d = app.getDesktop();
//		d.remove(caller);
		removeAll();
//		panel.setId("main");
//		panel.setLayoutData(hld);
		//htmlLayout.add(panel);
		add(panel);
	}


	public UsuarioDO getUsuario() {
		return usuario;
	}


	public void setUsuario(UsuarioDO usuario) {
		this.usuario = usuario;
	}


	public PersonajeDO getPersonaje() {
		return personaje;
	}


	public void setPersonaje(PersonajeDO personaje) {
		this.personaje = personaje;
	}


	public void Registrar(String optClase) throws ClassNotFoundException, Exception {
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		UsuarioDAO usDAO = //
		(UsuarioDAO) FactoryDAO.getDAO(UsuarioDAO.class, connectionBean);

		PersonajeDAO perDAO = //
		(PersonajeDAO) FactoryDAO.getDAO(PersonajeDAO.class, connectionBean);

		ClaseLinternaDAO clDAO = //
		(ClaseLinternaDAO) FactoryDAO.getDAO(ClaseLinternaDAO.class,
				connectionBean);

		Reference<ClaseLinternaDO> refc = new Reference<ClaseLinternaDO>();

		ClaseLinternaDO clase = clDAO.loadByColor(optClase);

		refc.setRefIdent(clase.getId());

		personaje.setClaseLinternaRef(refc);
		personaje.setPlanetaRef(clase.getPlanetaRef());

		perDAO.insert(personaje);

		PersonajeDO pers = perDAO.loadByAlias(personaje.getAlias());
		Reference<PersonajeDO> refper = new Reference<PersonajeDO>();
		refper.setRefIdent(pers.getId());
		usuario.setPersonajeRef(refper);
		usDAO.insert(usuario);

		Desktop d = app.getDesktop();

		d.setWindowPaneEmergente("Has Completado EL Registro Satisfactoriamente");

		PanelLogin pnlMain = new PanelLogin();
		d.setPanelCentral(pnlMain);

	}
	
	

}
