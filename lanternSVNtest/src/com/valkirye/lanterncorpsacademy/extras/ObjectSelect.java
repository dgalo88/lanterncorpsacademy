package com.valkirye.lanterncorpsacademy.extras;

import nextapp.echo.app.Component;
import nextapp.echo.app.Row;

@SuppressWarnings("serial")
public class ObjectSelect extends Row {

	private ObjectSelectModel objectSelectModel;
	private CellRenderer cellRenderer;

	public ObjectSelect(ObjectSelectModel objectSelectModel, //
			CellRenderer cellRenderer) {

		this.objectSelectModel = objectSelectModel;
		this.cellRenderer = cellRenderer;

		initElements();
	}

	protected void initElements() {

		removeAll();
		for (int i = 0; i < objectSelectModel.getObjectsCount(); i++) {
			Component component = cellRenderer.getCellRenderer(this, //
					objectSelectModel.getElementAt(i), i);
		
			add(component);
		}
	}

}
