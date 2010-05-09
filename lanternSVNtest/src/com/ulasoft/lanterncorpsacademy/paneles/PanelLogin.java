package com.ulasoft.lanterncorpsacademy.paneles;

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
import com.ulasoft.lanterncorpsacademy.GUIStyles;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;

public class PanelLogin extends Panel {

  LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();

  // Por alguna extraña razon, cuando se construye el panel aun no se
  // ha asignado la referencia a desktop en LanternCorpsAcademyApp (ver
  // el comentario ahi)
  // Desktop d = app.getDesktop();

  public PanelLogin() {

    Row row1 = new Row();
    row1.setStyle(GUIStyles.STYLE3);
    Column col = new Column();
    col.setInsets(new Insets(5, 5, 5, 5));
    col.setCellSpacing(new Extent(10));
    col.setBackground(Color.WHITE);
    Label lblTitle = new Label("Ingresar al Sistema");
    col.add(lblTitle);
    Grid grid = new Grid();
    grid.setStyle(GUIStyles.DEFAULT_STYLE);

    Label lblCorreo = new Label("Correo");
    grid.add(lblCorreo);
    TextField txtCorreo = new TextField();
    txtCorreo.setWidth(new Extent(300));
    txtCorreo.setText("");
    grid.add(txtCorreo);

    Label lblPass = new Label("Contraseña");
    grid.add(lblPass);
    PasswordField fldPass = new PasswordField();
    fldPass.setWidth(new Extent(300));
    grid.add(fldPass);
    col.add(grid);

    Row row = new Row();

    Button btnClickToEnter = new Button("Entrar");
    btnClickToEnter.setStyle(GUIStyles.STYLE);
    btnClickToEnter.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        btnClickToEnterClicked();
      }
    });
    row.add(btnClickToEnter);

    Button btnClickToRegister = new Button("Regístrarse");
    btnClickToRegister.setStyle(GUIStyles.STYLE);
    btnClickToRegister.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        btnClickToRegisterClicked();
      }
    });
    row.add(btnClickToRegister);

    row.setCellSpacing(new Extent(10));
    col.add(row);
    row1.add(col);
    add(row1);

  }

  // --------------------------------------------------------------------------------

  protected void btnClickToRegisterClicked() {
    PanelRegistro pnlregistro = new PanelRegistro();
    
    // Generalmente tratan de mantener la menor cantidad posible de variables de instancia
    // posible (esto es algo que hay que poner en las transparencias de codificación.
    // Es decir, no necesitan una variable de instancia para guardar una referencia al desktop.
    // cada vez que lo necesiten pueden ponerlo como una variable local y llamar a app.getDesktop().
    // El desktop lo usan así:
    Desktop desktop = app.getDesktop();
    desktop.setPanelCentral(pnlregistro);
  }

  // --------------------------------------------------------------------------------

  private void btnClickToEnterClicked() {
    removeAll();
    Desktop desktop = app.getDesktop();
    add(desktop.initTemplate2());
  }

}
