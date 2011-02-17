package com.ulasoft.lanterncorpsacademy.logic;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class InvitarNuevosUsuarios {

	public static String checkEmptyFields(String nombre, String correo) {

		String campo = "No se enviará la invitación";

		if (correo.equals("") && nombre.equals("")) {
			return "Debe ingresar un nombre y un correo. " + campo;
		}
		if (correo.equals("")) {
			return "El campo correo se encuentra vacío. " + campo;
		}
		if (nombre.equals("")) {
			return "El campo nombre se encuentra vacío. " + campo;
		}
		return null;
	}

	public static String enviarMensaje(String nombre, String correo, String comentarios) //
			throws Exception {

		String campo = checkEmptyFields(nombre, correo);
		if (campo != null) {
			return campo;
		}

		String miCorreo = "valkiryelca@gmail.com";
		String miPass = "Valkirye2011";
		String miMensaje = "Valkirye te invita a jugar Lantern Corps Academy!!!\n\n" //
			+ "Descripción: Juego multijugador en línea con interfaz web basada en el navegador. " //
			+ "El juego explota la dinámica y equilibrio característicos de un Juego de Rol Multijugador Masivo, " //
			+ "basando su temática en las sagas de historietas del grupo Green Lantern Corps " //
			+ "del que procede el héroe conocido como Linterna Verde, publicadas por DC Comics\n\n"
			+ "Comentarios:\n";

		Properties props = new Properties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.user", miCorreo);
		props.setProperty("mail.smtp.auth", "true");

		System.out.println("Enviando Invitación");
		// Preparamos la sesión
		Session session = Session.getDefaultInstance(props);

		// Construimos el mensaje
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(miCorreo));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
		message.setSubject("Hola " + nombre + " Únete y Juega!!!");
		message.setText(miMensaje + comentarios);

		// Lo enviamos.
		Transport transport = session.getTransport("smtp");
		transport.connect(miCorreo, miPass);
		transport.sendMessage(message, message.getAllRecipients());

		// Cierre.
		transport.close();

		System.out.println("Invitación Enviada!!!");
		return "Invitación Enviada!!!";

	}

}
