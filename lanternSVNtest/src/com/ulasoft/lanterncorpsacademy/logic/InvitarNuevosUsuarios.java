package com.ulasoft.lanterncorpsacademy.logic;

import nextapp.echo.app.TextArea;
import nextapp.echo.app.TextField;

public class InvitarNuevosUsuarios {

	public static String checkEmptyFields(TextField txtCorreo,
			TextField txtNombre, TextArea fldComentarios) {
		String campo = "No se enviara la Invitancion";
		if (txtCorreo.getText() == "" && txtNombre.getText() == ""
				&& fldComentarios.getText() == "") {
			return "Todos los Campos se Encuentran Vacios, " + campo;
		}
		if (txtCorreo.getText() == "") {
			return "El Campo Correo se Encuentra Vacio, " + campo;
		}
		if (txtNombre.getText() == "") {
			return "El Campo Nombre se Encuentra Vacio, " + campo;
		}
		if (fldComentarios.getText() == "") {
			return "El Comentario se Encuentra Vacio, " + campo;
		}
		return null;
	}

}
