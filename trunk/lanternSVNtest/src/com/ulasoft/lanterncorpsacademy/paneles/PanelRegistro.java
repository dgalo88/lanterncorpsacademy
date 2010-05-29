package com.ulasoft.lanterncorpsacademy.paneles;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUsuarioDO;
import nextapp.echo.app.Panel;

import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;

import echopoint.layout.HtmlLayoutData;
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

	
//	Desktop d = app.getDesktop();
	
}

