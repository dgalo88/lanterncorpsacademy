package com.ulasoft.lanterncorpsacademy.logic;

import lcaInterfaceDAO.IUsuarioDAO;
import lcaInterfaceDAO.IUsuarioDO;
import nextapp.echo.app.PasswordField;
import nextapp.echo.app.TextField;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import factory.GlobalDAOFactory;

public class EditarDatosUsuario {

	public static boolean allEmptyFields(TextField txtNombre, //
			PasswordField fldOldPass, PasswordField fldNewPass, //
			PasswordField fldConfirPass) {

		if (txtNombre.getText().equals("") && fldOldPass.getText().equals("") //
				&& fldNewPass.getText().equals("") //
				&& fldConfirPass.getText().equals("")) {
			return true;
		}
		return false;
	}

	public static boolean checkNewPassFields( //
			PasswordField fldConfirPass, PasswordField fldNewPass) {

		if (fldConfirPass.getText().equals(fldNewPass.getText())) {
			return true;
		}
		return false;
	}

	public static boolean checkOldPassField( //
			PasswordField fldOldPass, IUsuarioDO user) {

		if (fldOldPass.getText().equals(user.getClave())) {
			return true;
		}
		return false;
	}

	public static void updateDatosBD(IUsuarioDO user) throws Exception {

		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();
		IUsuarioDAO usuario = (IUsuarioDAO) //
			GlobalDAOFactory.getDAO(IUsuarioDAO.class, connectionBean);
		usuario.update(user);
		connectionBean.getConnection().close();

	}

	public static IUsuarioDO updateDatos( //
			IUsuarioDO user, TextField txtNombre, PasswordField fldNewPass) {

		if (!txtNombre.getText().equals("")) {
			user.setNombre(txtNombre.getText());
		}
		if (!fldNewPass.getText().equals("")) {
			user.setClave(fldNewPass.getText());
		}
		return user;
	}

}
