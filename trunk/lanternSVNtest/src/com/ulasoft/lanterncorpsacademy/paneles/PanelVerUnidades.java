package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.ArrayList;
import java.util.List;

import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.SelectField;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.logic.Data;
import com.valkirye.lanterncorpsacademy.extras.ObjectLca;
import com.valkirye.lanterncorpsacademy.extras.ObjectSelectModel;
import com.valkirye.lanterncorpsacademy.extras.ObjectSelectScrolling;
import com.valkirye.lanterncorpsacademy.extras.TestCellRenderer;

@SuppressWarnings("serial")
public class PanelVerUnidades extends Panel {

	private Column col;
	private ObjectSelectScrolling oSelectScrolling;
	private List<ObjectLca> list = new ArrayList<ObjectLca>();

	private ResourceImageReference image;
	private SelectField selectField;

	public PanelVerUnidades() {

		col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		String [] menuSelect = new String[5];
		menuSelect[0] = "Seleccionar Tipo de Unidades";
		menuSelect[1] = "Unidades Básicas";
		menuSelect[2] = "Unidades de Ejército";
		menuSelect[3] = "Unidades Recolectoras";
		menuSelect[4] = "Unidades Saboteadoras";

		selectField = new SelectField(menuSelect);
		selectField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				menuSelected(selectField.getSelectedIndex());
			}
		});
		col.add(selectField);

		image = new ResourceImageReference(Data.panelMain(1), //
				new Extent(40), new Extent(40));

		for (int i = 0; i < 10; i++) {
			ObjectLca item = new ObjectLca(false, i, image);
			list.add(item);
		}

		ObjectSelectModel oModel = new ObjectSelectModel(list);
		TestCellRenderer tcr = new TestCellRenderer();
		oSelectScrolling = new ObjectSelectScrolling(oModel, tcr);
		col.add(oSelectScrolling);

		add(col);
	}

	// --------------------------------------------------------------------------------

	private void menuSelected(int index) {

		if (index == 0) {
			return;
		}
//		index = index == 0 ? 1 : index;
		col.remove(oSelectScrolling);

		image = new ResourceImageReference( //
				Data.panelMain(index), new Extent(40), new Extent(40));

		list.removeAll(list);
		for (int i = 0; i < 10; i++) {
			ObjectLca item = new ObjectLca(false, i, image);
			list.add(item);
		}

		ObjectSelectModel oModel = new ObjectSelectModel(list);
		TestCellRenderer tcr = new TestCellRenderer();
		oSelectScrolling = new ObjectSelectScrolling(oModel, tcr);

		col.add(oSelectScrolling);

	}

	// --------------------------------------------------------------------------------

	/**
	 * @param tipoUnidad 1 = Unidades Básicas
	 *					 2 = Unidades de Ejército
	 *					 3 = Unidades Recolectoras
	 *					 4 = Unidades Saboteadoras
	 */
	public static ObjectSelectScrolling getUnidades(int tipoUnidad) {

		tipoUnidad = tipoUnidad < 1 && tipoUnidad > 4 ? 1 : tipoUnidad;

		List<ObjectLca> list = new ArrayList<ObjectLca>();

		ResourceImageReference image = new ResourceImageReference( //
				Data.panelMain(tipoUnidad), //
				new Extent(40), new Extent(40));

		for (int i = 0; i < 10; i++) {
			ObjectLca item = new ObjectLca(false, i, image);
			list.add(item);
		}

		ObjectSelectModel oModel = new ObjectSelectModel(list);
		TestCellRenderer tcr = new TestCellRenderer();
		ObjectSelectScrolling oSelectScrolling = new ObjectSelectScrolling(oModel, tcr);

		return oSelectScrolling;
		
	}
}
