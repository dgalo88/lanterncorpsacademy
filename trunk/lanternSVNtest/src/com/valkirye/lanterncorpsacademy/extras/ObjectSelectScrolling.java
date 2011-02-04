package com.valkirye.lanterncorpsacademy.extras;

import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

@SuppressWarnings("serial")
public class ObjectSelectScrolling extends Column{

	private Row row = new Row();
	private Button btnLeft;
	private Button btnRight;
	private ObjectSelect obSelect;

	public ObjectSelectScrolling(ObjectSelect obSel) {

		btnLeft = new Button("<");
		btnLeft.setWidth(new Extent(20));
//		btnLeft.setStyle(ButtonStyle.MENU_STYLE);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnLeftClicked();
			}
		});

		btnRight = new Button(">");
		btnRight.setWidth(new Extent(20));
//		btnRight.setStyle(ButtonStyle.MENU_STYLE);
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
//		selected = objects.get(getComponentCount()-1);
	}

	private void btnRightClicked() {
//		selected = objects.get(getComponentCount()+1);
	}

}
