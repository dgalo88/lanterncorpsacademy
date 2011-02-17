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
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Grid gridPane = new Grid(1);
		gridPane.setBackground(Color.WHITE);
		gridPane.setInsets(new Insets(30, 30, 30, 30));

		Grid grid = new Grid();
		grid.setWidth(new Extent(490));
		grid.setHeight(new Extent(25));
		grid.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		Label lblTitle = new Label("Editar Mis Datos");
		lblTitle.setForeground(Color.WHITE);
		Estilo.setFont(lblTitle, GUIStyles.BOLD, 16);
		col.add(lblTitle);

		Label lblNombre = new Label("Nombre");
		grid.add(lblNombre);

		txtNombre = new TextField();
		txtNombre.setWidth(new Extent(300));
		txtNombre.setText(app.getAtributos().getUsuario().getNombre());
		grid.add(txtNombre);

		Label lblOldPass = new Label("Contraseña Actual");
		grid.add(lblOldPass);

		fldOldPass = new PasswordField();
		fldOldPass.setWidth(new Extent(300));
		grid.add(fldOldPass);

		Label lblNewPass = new Label("Contraseña Nueva");
		grid.add(lblNewPass);

		fldNewPass = new PasswordField();
		fldNewPass.setWidth(new Extent(300));
		grid.add(fldNewPass);

		Label lblConfirPass = new Label("Confirmar Contraseña");
		grid.add(lblConfirPass);

		fldConfirPass = new PasswordField();
		fldConfirPass.setWidth(new Extent(300));
		grid.add(fldConfirPass);

		gridPane.add(grid);
		col.add(gridPane);

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancelar.setWidth(new Extent(100));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				app.getDesktop().btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

		Button btnGuardar = new Button("Guardar");
		btnGuardar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnGuardar.setWidth(new Extent(100));
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnGuardarClicked();
			}
		});
		row.add(btnGuardar);

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
					"Todos los campos se encuentran vacíos no se actualizará la información");
			return;
		}
		if (!EditarDatosUsuario.checkNewPassFields(fldConfirPass, fldNewPass)) {
			d.setWindowPaneEmergente("Los campos de la nueva clave no concuerdan");
			fldNewPass.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			fldConfirPass.set(PROPERTY_BACKGROUND, new Color(255, 160, 160));
			return;
		}
		if (!EditarDatosUsuario.checkOldPassField(fldOldPass, atrib.getUsuario())) {
			d.setWindowPaneEmergente("Ingresó una clave incorrecta");
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
		d.setWindowPaneEmergente("Los datos se han actualizado correctamente");
		d.setPanelCentral(pnlMain);

	}

}
