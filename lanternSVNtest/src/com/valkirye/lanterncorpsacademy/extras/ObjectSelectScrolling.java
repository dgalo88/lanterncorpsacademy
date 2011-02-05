package com.valkirye.lanterncorpsacademy.extras;

import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;

@SuppressWarnings("serial")
public class ObjectSelectScrolling extends Column{

	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
		.getActive();

	private Row row = new Row();
	private Button btnLeft;
	private Button btnRight;
	private ObjectSelect obSelect;

	public ObjectSelectScrolling(ObjectSelect obSel) {

		btnLeft = new Button("<");
		btnLeft.setWidth(new Extent(20));
		btnLeft.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnLeftClicked();
			}
		});

		btnRight = new Button(">");
		btnRight.setWidth(new Extent(20));
		btnRight.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnRightClicked();
			}
		});

		obSelect = obSel;

		row.add(btnLeft);
		row.add(obSelect);
		row.add(btnRight);

		add(row);

	}

	private void btnLeftClicked() {

		obSelect.setCurrPage(obSelect.getCurrPage()-1);
		obSelect.currPageChanged();

	}

	private void btnRightClicked() {

		obSelect.setCurrPage(obSelect.getCurrPage()+1);
		obSelect.currPageChanged();

	}

}
