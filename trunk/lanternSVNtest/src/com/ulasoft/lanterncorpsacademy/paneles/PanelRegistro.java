package com.ulasoft.lanterncorpsacademy.paneles;

import lcaInterfaceDAO.IClaseLinternaDAO;
import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUsuarioDAO;
import lcaInterfaceDAO.IUsuarioDO;
import nextapp.echo.app.Panel;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;

import dao.api.Reference;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import echopoint.layout.HtmlLayoutData;
import factory.GlobalDAOFactory;
import factory.GlobalDOFactory;

@SuppressWarnings("serial")
public class PanelRegistro extends Panel {
	
	public HtmlLayoutData hld = new HtmlLayoutData("main");
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
	private IUsuarioDO usuario =  (IUsuarioDO) GlobalDOFactory.getDO(IUsuarioDO.class);
	private IPersonajeDO personaje = (IPersonajeDO) GlobalDOFactory.getDO(IPersonajeDO.class);
	
	public PanelRegistro() throws Exception{
		setId("main");
		setLayoutData(hld);
		PanelRegistro1 registro1 = new PanelRegistro1(usuario);
		add(registro1);
	}

	
	public void changePanel(Panel panel) {
		removeAll();
		add(panel);
	}


	public IUsuarioDO getUsuario() {
		return usuario;
	}


	public void setUsuario(IUsuarioDO usuario) {
		this.usuario = usuario;
	}


	public IPersonajeDO getPersonaje() {
		return personaje;
	}


	public void setPersonaje(IPersonajeDO personaje) {
		this.personaje = personaje;
	}


	public void Registrar(String optClase) throws ClassNotFoundException, Exception {
		
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IUsuarioDAO usDAO = (IUsuarioDAO) GlobalDAOFactory.getDAO(IUsuarioDAO.class, connectionBean);
		IPersonajeDAO perDAO = (IPersonajeDAO) GlobalDAOFactory.getDAO(IPersonajeDAO.class, connectionBean);
		IClaseLinternaDAO clDAO = (IClaseLinternaDAO) GlobalDAOFactory.getDAO(IClaseLinternaDAO.class, connectionBean);

		Reference<IClaseLinternaDO> refc = new Reference<IClaseLinternaDO>();

		IClaseLinternaDO clase = clDAO.loadByColor(optClase);

		refc.setRefIdent(clase.getId());

		personaje.setClaseLinternaRef(refc);
		personaje.setPlanetaRef(clase.getPlanetaRef());

		perDAO.insert(personaje);

		IPersonajeDO pers = perDAO.loadByAlias(personaje.getAlias());
		Reference<IPersonajeDO> refper = new Reference<IPersonajeDO>();
		refper.setRefIdent(pers.getId());
		usuario.setPersonajeRef(refper);
		usDAO.insert(usuario);

		Desktop d = app.getDesktop();

		d.setWindowPaneEmergente("Has Completado EL Registro Satisfactoriamente");

		PanelLogin pnlMain = new PanelLogin();
		d.setPanelCentral(pnlMain);

	}
	
	

}
