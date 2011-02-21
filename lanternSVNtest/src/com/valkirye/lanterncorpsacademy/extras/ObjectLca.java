package com.valkirye.lanterncorpsacademy.extras;

import nextapp.echo.app.CheckBox;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Font;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;

@SuppressWarnings("serial")
public class ObjectLca extends Row {

	private CheckBox checkBox;
	private Label lblImage;

	public ObjectLca(boolean selectable, int i, ResourceImageReference image) {
		initItem(selectable, i, image);
	}

	private void initItem(boolean selectable, int i, ResourceImageReference image) {

		setCellSpacing(new Extent(2));
		setInsets(new Insets(5, 0, 5, 0));
		Column col = new Column();

//		ResourceImageReference image = new ResourceImageReference( //
//				"com/ulasoft/lanterncorpsacademy/imagenes/anilloverde.jpg", //
//				new Extent(40), new Extent(40));

		if (selectable) {
			checkBox = new CheckBox(image);
			add(checkBox);
		} else {
			lblImage = new Label(image);
			add(lblImage);
		}

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
