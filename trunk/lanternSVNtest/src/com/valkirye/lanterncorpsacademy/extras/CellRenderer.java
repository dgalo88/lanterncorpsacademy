/*
 * Created on 19/09/2008
 */
package com.valkirye.lanterncorpsacademy.extras;

import nextapp.echo.app.Component;
import nextapp.echo.app.layout.GridLayoutData;

/**
 * @author Demián Gutierrez
 */
public interface CellRenderer {

  public Component getCellRenderer( //
      ObjectSelect objectSelect, Object value, int pos);

  // --------------------------------------------------------------------------------

  public GridLayoutData getGridLayoutData();
}
