package com.valkirye.lanterncorpsacademy.extras;
import nextapp.echo.app.CheckBox;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;

@SuppressWarnings("serial")
public class itemPrb extends Column{

	private CheckBox checkBox;

	public itemPrb(){

		Row row = new Row();
		Column col = new Column();
		setCellSpacing(new Extent(2));

		checkBox = new CheckBox(new ResourceImageReference(
				"com/ulasoft/lanterncorpsacademy/imagenes/anilloverde.jpg",
				new Extent(40), new Extent(40)));
		row.add(checkBox);

		Label lblTitulo = new Label("$Nombre");
		Label lblAtaque = new Label("Ataque: AA");
		Label lblDefensa = new Label("Defensa: DD");

		col.add(lblTitulo);
		col.add(lblAtaque);
		col.add(lblDefensa);
		row.add(col);
		add(row);

	}

	public boolean isSelected() {
		return checkBox.isSelected();
	}

}
