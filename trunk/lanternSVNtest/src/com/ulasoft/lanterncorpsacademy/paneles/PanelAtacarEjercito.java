package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Font;
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
import com.valkirye.lanterncorpsacademy.extras.VerDatos;

@SuppressWarnings("serial")
public class PanelAtacarEjercito extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

//	private INpcDO personajeAtacar;

	public PanelAtacarEjercito() {

		Column col = new Column();
		col.setInsets(new Insets(15, 15, 15, 15));
		col.setCellSpacing(new Extent(30));
		col.setBackground(Color.WHITE);

		Row row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);
		Label lblAtacarEjercito = new Label( //
				"Atacar Ejército");
		lblAtacarEjercito.setFont(new Font(Font.VERDANA, Font.BOLD, new Extent(16)));
		row.add(lblAtacarEjercito);
		col.add(row);

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);
		Label lblUnidadesAtacante = new Label( //
				"Unidades de Ejército Seleccionadas");
		Estilo.setFont(lblUnidadesAtacante, GUIStyles.ITALIC);
		row.add(lblUnidadesAtacante);
		col.add(row);

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);
		row.add(VerDatos.getUnidades());
		col.add(row);

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);
		Label lblUnidadesDueno = new Label( //
				"Unidades de Ejército del Dueño del Planeta");
		Estilo.setFont(lblUnidadesDueno, GUIStyles.ITALIC);
		row.add(lblUnidadesDueno);
		col.add(row);

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);
		row.add(VerDatos.getUnidades());
		col.add(row);

		row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnCancelar.setWidth(new Extent(160));
		btnCancelar.setHeight(new Extent(20));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

		Button btnAtacar = new Button("Atacar");
		btnAtacar.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnAtacar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAtacarClicked();
			}
		});
		row.add(btnAtacar);

		col.add(row);
		add(col);
	}

	// --------------------------------------------------------------------------------

	private void btnAtacarClicked() {

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

	// --------------------------------------------------------------------------------

	private void btnCancelarClicked() {

		PanelMain pnlMain = new PanelMain();
		Desktop d = app.getDesktop();
		d.setPanelCentral(pnlMain);

	}

}
