package com.valkirye.lanterncorpsacademy.extras;
import nextapp.echo.app.Column;

@SuppressWarnings("serial")
public class ItemPrb extends Column{

  private String name;

  public ItemPrb() {
    // TODO Auto-generated constructor stub
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
//	private CheckBox checkBox;
//
//	public itemPrb(){
//
//		Row row = new Row();
//		Column col = new Column();
//		setCellSpacing(new Extent(2));
//
//		checkBox = new CheckBox(new ResourceImageReference(
//				"com/ulasoft/lanterncorpsacademy/imagenes/anilloverde.jpg",
//				new Extent(40), new Extent(40)));
//		row.add(checkBox);
//
//		Label lblTitulo = new Label("$Nombre");
//		Label lblAtaque = new Label("Ataque: AA");
//		Label lblDefensa = new Label("Defensa: DD");
//
//		col.add(lblTitulo);
//		col.add(lblAtaque);
//		col.add(lblDefensa);
//		row.add(col);
//		add(row);
//
//	}
//
//	public boolean isSelected() {
//		return checkBox.isSelected();
//	}

}
