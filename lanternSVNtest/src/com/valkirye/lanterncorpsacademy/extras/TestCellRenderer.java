package com.valkirye.lanterncorpsacademy.extras;

import nextapp.echo.app.Component;
import nextapp.echo.app.Label;
import nextapp.echo.app.layout.GridLayoutData;

public class TestCellRenderer implements CellRenderer {

  @Override
  public Component getCellRenderer(ObjectSelect objectSelect, Object value, int pos) {
    ItemPrb ip = (ItemPrb) value;
    return new Label(ip.getName());
  }

  @Override
  public GridLayoutData getGridLayoutData() {
    // TODO Auto-generated method stub
    return null;
  }
}
