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
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelSabotear extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	public PanelSabotear() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Grid grid = new Grid(1);
		grid.setInsets(new Insets(20, 20, 20, 20));
		grid.setBackground(Color.WHITE);

		Row row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		col.add(PanelConstructor.initTopRow("Sabotear Planeta"));

		Label lblUnidadesAtacante = new Label( //
				"Unidades de Saboteo Seleccionadas");
		Estilo.setFont(lblUnidadesAtacante, GUIStyles.ITALIC);
		row.add(lblUnidadesAtacante);
		grid.add(row);

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);
		row.add(PanelVerUnidades.getUnidades(4));
		grid.add(row);

		col.add(grid);

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);
		row.setCellSpacing(new Extent(10));

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancelar.setWidth(new Extent(120));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				app.getDesktop().btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

		Button btnSabotear = new Button("Sabotear");
		btnSabotear.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnSabotear.setWidth(new Extent(120));
		btnSabotear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnSabotearClicked();
			}
		});
		row.add(btnSabotear);

		col.add(row);
		add(col);
	}

	// --------------------------------------------------------------------------------

	private void btnSabotearClicked() {

//		if(personajeAtacar == null){
//			return;
//		}

//		switch (Atacar.atacarNPC(personajeAtacar)) {
//		case 1:
//			d.setWindowPaneEmergente("Ganaste el Combate");			
//			break;
//		case 2:
//			d.setWindowPaneEmergente("Perdiste el Combate");			
//			break;
//		default:
//			break;
//		}

		PanelAtacarDuenoPlaneta pnlMain = new PanelAtacarDuenoPlaneta();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);

	}

}
