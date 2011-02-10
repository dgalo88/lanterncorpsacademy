package com.valkirye.lanterncorpsacademy.extras;

import nextapp.echo.app.Component;
import nextapp.echo.app.Row;

@SuppressWarnings("serial")
public class ObjectSelect extends Row {

	private ObjectSelectModel objectSelectModel;

	public ObjectSelect(ObjectSelectModel objectSelectModel, CellRenderer cellRenderer) {

		this.objectSelectModel = objectSelectModel;

		for (int i = 0; i < objectSelectModel.getObjectsCount(); i++) {

			Component component = cellRenderer.getCellRenderer(this, objectSelectModel.getElementAt(i), i);

			//component.setLayoutData(cellRenderer.getGridLayoutData());

			add(component);
		}
	}

	public ObjectSelectModel getObjectSelectModel() {
		return this.objectSelectModel;
	}
}
