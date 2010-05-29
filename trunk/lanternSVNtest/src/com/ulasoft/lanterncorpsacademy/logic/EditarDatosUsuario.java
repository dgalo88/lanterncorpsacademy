package com.ulasoft.lanterncorpsacademy.logic;

import nextapp.echo.app.PasswordField;
import nextapp.echo.app.TextField;

public class EditarDatosUsuario {

	public static boolean allEmptyFields(TextField txtNombre,
			PasswordField fldOldPass, PasswordField fldNewPass,
			PasswordField fldConfirPass) {
		if(txtNombre.getText()=="" && fldOldPass.getText()=="" &&//
				fldNewPass.getText()=="" && fldConfirPass.getText()==""){
			return true;
		}
		return false;
	}

	public static boolean checkNewPassFields(PasswordField fldConfirPass,
			PasswordField fldNewPass) {
		if(fldConfirPass.getText().equals(fldNewPass.getText())){
			return true;
		}
		return false;
	}

}
