package com.ulasoft.lanterncorpsacademy.logic;

import nextapp.echo.app.TextArea;

public class EnviarMensaje {

	public static boolean checkMensaje(TextArea texArea) {
		if(texArea.getText()==""){
			return true;
		}
		return false;
	}

}
