package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.List;

import lcaInterfaceDAO.IPersonajeDO;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Panel;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Data;
import com.ulasoft.lanterncorpsacademy.logic.Ranking;

@SuppressWarnings("serial")
public class PanelRanking extends Panel {

	private TestTableModel tableDtaModel;
	private List<IPersonajeDO> personajes;

	public PanelRanking() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		// ----------------------------------------
		// Carga el Ranking de los personajes
		// ----------------------------------------

		tableDtaModel = new TestTableModel();
		try {
			personajes = Ranking.obtenerRanking();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tableDtaModel = Ranking.asignarRanking(tableDtaModel, personajes);

		col.add(PanelConstructor.initTopRow("Clasificación Mejores Jugadores"));
		col.add(PanelConstructor.initTable(tableDtaModel, initTableColModel(), true));

		add(col);
	}

	// --------------------------------------------------------------------------------

	private TableColModel initTableColModel() {

		TableColModel tableColModel = new TableColModel();
		TableColumn tableColumn;

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IPersonajeDO personaje = (IPersonajeDO) element; 
				return personaje.getId();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Ranking");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IPersonajeDO personaje = (IPersonajeDO) element;
				return personaje.getAlias();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Alias");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IPersonajeDO personaje = (IPersonajeDO) element;
				return personaje.getNivel();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Nivel");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IPersonajeDO personaje = (IPersonajeDO) element;
				return Data.getClase((personaje.getClaseLinternaRef()).getRefIdent());
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Clase");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		return tableColModel;
	}

}
