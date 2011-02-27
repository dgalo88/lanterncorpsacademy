package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.List;

import lcaInterfaceDAO.IRecursoDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.renderer.BaseCellRenderer;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.minotauro.echo.table.renderer.NestedCellRenderer;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.Recursos;
import com.valkirye.lanterncorpsacademy.components.SpinButton;

@SuppressWarnings("serial")
public class PanelAsignarPrecio extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private TestTableModel tableDtaModel;
	private List<IRecursoDO> recursos;

	public PanelAsignarPrecio() {

		Column col = new Column();
		col.setCellSpacing(new Extent(10));
		col.setBackground(Color.WHITE);

		Row row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		tableDtaModel = new TestTableModel();
		try {
			recursos = Recursos.getRecursos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tableDtaModel = Recursos.asignarRecursos(tableDtaModel, recursos);

		col.add(PanelConstructor.initTable( //
				tableDtaModel, initTableColModel(), false));

		// ----------------------------------------
		// Buttons
		// ----------------------------------------

		Button btnAcept = new Button("Aceptar");
		btnAcept.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAcept.setWidth(new Extent(90));
		btnAcept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnAceptClicked();
			}
		});
		row.add(btnAcept);

		col.add(row);
		add(col);
	}

	// --------------------------------------------------------------------------------

	private TableColModel initTableColModel() {

		TableColModel tableColModel = new TableColModel();
		TableColumn tableColumn;

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IRecursoDO recurso = (IRecursoDO) element;
				return recurso.getNombre();
			}
		};
		tableColumn.setWidth(new Extent(100));
		tableColumn.setHeadValue("Nombre");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Cantidad");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(initNestedCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		return tableColModel;
	}

	// --------------------------------------------------------------------------------
	// Setup command bar renderer
	// --------------------------------------------------------------------------------

	private NestedCellRenderer initNestedCellRenderer() {

		NestedCellRenderer nestedCellRenderer = new NestedCellRenderer();
		nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
			@Override
			public Component getCellRenderer( //
					final ETable table, final Object value, //
					final int col, final int row) {

				SpinButton spinButton = new SpinButton();
				return spinButton;
			}
		});

		return nestedCellRenderer;
	}

	// --------------------------------------------------------------------------------

	private void btnAceptClicked() {
		// Empty
	}

}
