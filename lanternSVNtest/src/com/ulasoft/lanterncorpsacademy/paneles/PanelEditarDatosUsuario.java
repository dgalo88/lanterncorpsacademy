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
import nextapp.echo.app.PasswordField;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.EditarDatosUsuario;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelEditarDatosUsuario extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private TextField txtNombre;
	private PasswordField fldOldPass;
	private PasswordField fldNewPass;
	private PasswordField fldConfirPass;

	public PanelEditarDatosUsuario() {

		Column col = new Column();
		col.setInsets(new Insets(5, 5, 5, 5));
		col.setCellSpacing(new Extent(10));
		col.setBackground(Color.WHITE);

		Label lblTitle = new Label("Editar Datos del Usuario");
		Estilo.setFont(lblTitle, GUIStyles.BOLD);
		col.add(lblTitle);

		Grid grid = new Grid();
		grid.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		Label lblNombre = new Label("Nombre");

		grid.add(lblNombre);

		txtNombre = new TextField();
		txtNombre.setWidth(new Extent(300));
		txtNombre.setText(app.getAtributos().getUsuario().getNombre());
		grid.add(txtNombre);

		Label lblOldPass = new Label("Antigua Contraseña");
		grid.add(lblOldPass);

		fldOldPass = new PasswordField();
		fldOldPass.setWidth(new Extent(300));
		grid.add(fldOldPass);

		Label lblNewPass = new Label("Nueva Contraseña");
		grid.add(lblNewPass);

		fldNewPass = new PasswordField();
		fldNewPass.setWidth(new Extent(300));
		grid.add(fldNewPass);

		Label lblConfirPass = new Label("Confirmar Nueva Contraseña");
		grid.add(lblConfirPass);

		fldConfirPass = new PasswordField();
		fldConfirPass.setWidth(new Extent(300));
		grid.add(fldConfirPass);
		Row row = new Row();
		row.add(grid);
		row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);

		row = new Row();

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				app.getDesktop().btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

		Button btnGuardar = new Button("Guardar");
		btnGuardar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnGuardarClicked();
			}
		});
		row.add(btnGuardar);

		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);
		add(col);

	}

	// --------------------------------------------------------------------------------

	protected void btnGuardarClicked() {

		Desktop d = app.getDesktop();
		Atributos atrib = app.getAtributos();

		if (EditarDatosUsuario.allEmptyFields(txtNombre, fldOldPass, //
				fldNewPass, fldConfirPass)) {
			d.setWindowPaneEmergente( //
					"Todos los Campos se encuentran Vacios no se Actualizará ninguna Información");
			return;
		}
		if (!EditarDatosUsuario.checkNewPassFields(fldConfirPass, fldNewPass)) {
			d.setWindowPaneEmergente("Los Campos de la Nueva Clave No concuerdan");
			fldNewPass.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			fldConfirPass.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			return;
		}
		if (!EditarDatosUsuario.checkOldPassField(fldOldPass, atrib.getUsuario())) {
			d.setWindowPaneEmergente( //
					"El Campo de la Clave Antigua No concuerda con su Clave Actual");
			fldNewPass.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			return;
		}
		try {
			EditarDatosUsuario.updateDatosBD(EditarDatosUsuario.updateDatos( //
					atrib.getUsuario(), txtNombre, fldNewPass));
		} catch (Exception e) {
			e.printStackTrace();
		}

		PanelMain pnlMain = new PanelMain();
		d.setWindowPaneEmergente("Los Datos se han Actualizado Correctamente");
		d.setPanelCentral(pnlMain);

	}

}
