package com.valkirye.lanterncorpsacademy.extras;

import nextapp.echo.app.Component;
import nextapp.echo.app.layout.GridLayoutData;

public class TestCellRenderer implements CellRenderer {

	@Override
	public Component getCellRenderer(ObjectSelect objectSelect, Object value, int pos) {

		ObjectLca object = (ObjectLca) value;
		return object;

	}

	@Override
	public GridLayoutData getGridLayoutData() {
		return null;
	}
}
