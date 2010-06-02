package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.GUIStyles;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;

@SuppressWarnings("serial")
public class PanelSelectAtacar extends Panel {

	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
	LanternCorpsAcademyApp.getActive();
	
	
	
	public PanelSelectAtacar() {
		
		setInsets(new Insets(2, 2, 2, 2));
		Column col = new Column();
		col.setBackground(Color.WHITE);
		

		Button btnAtacar = new Button("ATACAR Personaje");
		btnAtacar.setStyle(GUIStyles.DEFAULT_STYLE);
		btnAtacar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					btnAtacarClicked();
			}
		});
		
		
		Button btnAtacarNPC = new Button("ATACAR Personaje");
		btnAtacarNPC.setStyle(GUIStyles.DEFAULT_STYLE);
		btnAtacarNPC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					try {
						btnAtacarNPCClicked();
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
		});
		if(app.getAtributos().getPersonaje().getPlanetaRef().getRefIdent() == app.getAtributos().getPersonaje().getClaseLinternaRef().getRefIdent()){
			Desktop d = app.getDesktop();
			btnAtacarNPC.setEnabled(false);
			btnAtacar.setEnabled(false);
			Row row = new Row();
		    Label lblTitle = new Label("No Puedes Atacar por que Te Encuentras en el Planeta Base");
		    d.setWindowPaneEmergente("No Puedes Atacar por que Te Encuentras en el Planeta Base");
			row.add(lblTitle);
			row.setStyle(GUIStyles.DEFAULT_STYLE);
			col.add(row);
		}
		Row row = new Row();
		row.add(btnAtacarNPC);
		row.add(btnAtacar);
		row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);
		add(col);
	}

	protected void btnAtacarNPCClicked() throws Exception {
		Desktop d = app.getDesktop();
		PanelAtacarNPC pnlMain = new PanelAtacarNPC();
		d.setPanelCentral(pnlMain);
		
	}

	protected void btnAtacarClicked(){		
		Desktop d = app.getDesktop();
		PanelAtacarPersonaje pnlMain = new PanelAtacarPersonaje();
		d.setPanelCentral(pnlMain);
	}

	// --------------------------------------------------------------------------------

}
