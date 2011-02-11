package com.valkirye.lanterncorpsacademy.extras;

import nextapp.echo.app.CheckBox;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Font;
import nextapp.echo.app.Label;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;

@SuppressWarnings("serial")
public class ObjectLca extends Row {

	private CheckBox checkBox;

	public ObjectLca(int j) {
		initItem(j);
	}

	private void initItem(int i){

		Column col = new Column();
		setCellSpacing(new Extent(2));

		checkBox = new CheckBox(new ResourceImageReference( //
				"com/ulasoft/lanterncorpsacademy/imagenes/anilloverde.jpg", //
				new Extent(40), new Extent(40)));
		add(checkBox);

		set(Label.PROPERTY_FONT, new Font(Font.VERDANA, Font.PLAIN, new Extent(12)));

		Label lblTitulo = new Label("$Nombre" + i);
		Label lblAtaque = new Label("Ataque: AA");
		Label lblDefensa = new Label("Defensa: DD");

		col.add(lblTitulo);
		col.add(lblAtaque);
		col.add(lblDefensa);
		add(col);

	}

	public boolean isSelected() {
		return checkBox.isSelected();
	}

}
