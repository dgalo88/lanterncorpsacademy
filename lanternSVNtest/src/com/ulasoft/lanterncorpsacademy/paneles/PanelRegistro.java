package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Panel;
import dao.lantern.UsuarioDO;

public class PanelRegistro extends Panel {
	
	private UsuarioDO usuario = new UsuarioDO();
	private PanelRegistro2 registro2;
	private PanelRegistro1 registro1;
	
	public PanelRegistro(){
		registro1 = new PanelRegistro1();
		add(registro1);
	}

}
