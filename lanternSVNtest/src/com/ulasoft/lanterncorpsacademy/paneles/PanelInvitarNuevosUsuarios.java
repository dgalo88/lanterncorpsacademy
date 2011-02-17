package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextArea;
import nextapp.echo.app.TextField;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.InvitarNuevosUsuarios;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelInvitarNuevosUsuarios extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private TextField txtCorreo;
	private TextField txtNombre;
	private TextArea txtComentarios;

	public PanelInvitarNuevosUsuarios() {

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Grid gridPane = new Grid(1);
		gridPane.setInsets(new Insets(20, 20, 20, 20));
		gridPane.setBackground(Color.WHITE);

		Grid grid = new Grid();
		grid.setWidth(new Extent(420));

		col.add(PanelConstructor.initTopRow("Invitar Amigo"));

		Label lblNombre = new Label("Nombre");
		Estilo.setFont(lblNombre, GUIStyles.BOLD);
		grid.add(lblNombre);

		txtNombre = new TextField();
		txtNombre.setWidth(new Extent(390));
		txtNombre.setText("");
		grid.add(txtNombre);

		Label lblCorreo = new Label("Correo");
		Estilo.setFont(lblCorreo, GUIStyles.BOLD);
		grid.add(lblCorreo);

		txtCorreo = new TextField();
		txtCorreo.setWidth(new Extent(390));
		txtCorreo.setText("");
		grid.add(txtCorreo);

		Label lblMensaje = new Label("Comentarios");
		Estilo.setFont(lblMensaje, GUIStyles.BOLD);
		grid.add(lblMensaje);

		txtComentarios = new TextArea();
		txtComentarios.setWidth(new Extent(390));
		txtComentarios.setHeight(new Extent(150));
		txtComentarios.setText("");
		Estilo.setFont(txtComentarios, GUIStyles.NORMAL, 13);
		grid.add(txtComentarios);

		gridPane.add(grid);
		col.add(gridPane);

		Button btnLimpiarCampos = new Button("Limpiar Campos");
		btnLimpiarCampos.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnLimpiarCampos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limpiarCampos();
			}
		});
		row.add(btnLimpiarCampos);

		Button btnEnviarInvitacion = new Button("Enviar Invitación");
		btnEnviarInvitacion.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnEnviarInvitacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnEnviarInvitacionClicked();
			}
		});
		row.add(btnEnviarInvitacion);

		col.add(row);
		add(col);
	}

	private void limpiarCampos() {

		txtCorreo.setText("");
		txtNombre.setText("");
		txtComentarios.setText("");

	}

	protected void btnEnviarInvitacionClicked() {

		Desktop d = app.getDesktop();
		String campo;

		try {
			campo = InvitarNuevosUsuarios.enviarMensaje(txtNombre.getText(), //
					txtCorreo.getText(), txtComentarios.getText());
		} catch (Exception e) {
			campo = "Se ha producido un error al intentar enviar la invitación";
			e.printStackTrace();
		}

		d.setWindowPaneEmergente(campo);
	}

}
