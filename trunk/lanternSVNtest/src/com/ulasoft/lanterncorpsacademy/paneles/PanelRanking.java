package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.List;

import lcaInterfaceDAO.IPersonajeDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.ETableNavigation;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.base.TableSelModel;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Data;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.Ranking;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelRanking extends Panel {

	private TestTableModel tableDtaModel;
	private List<IPersonajeDO> personajes;

	public PanelRanking() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		col.add(initTopRow());
		col.add(initTable());

		add(col);
	}

	// --------------------------------------------------------------------------------

	private Row initTopRow() {

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);
		Label lblTitle = new Label("Clasificación Mejores Jugadores");
		lblTitle.setForeground(Color.WHITE);
		Estilo.setFont(lblTitle, GUIStyles.BOLD, 16);
		row.add(lblTitle);
		return row;

	}

	// --------------------------------------------------------------------------------

	private Component initTable() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));
		col.setBackground(Color.WHITE);

		try {
			personajes = Ranking.obtenerRanking();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ----------------------------------------
		// The table models
		// ----------------------------------------

		TableColModel tableColModel = initTableColModel();
		TableSelModel tableSelModel = new TableSelModel();
		tableDtaModel = new TestTableModel();
		tableDtaModel.setEditable(true);
		tableDtaModel.setPageSize(10);

		tableDtaModel = Ranking.asignarRanking(tableDtaModel, personajes);

		// ----------------------------------------
		// The table
		// ----------------------------------------

		ETable table = new ETable();
		table.setTableDtaModel(tableDtaModel);
		table.setTableColModel(tableColModel);
		table.setTableSelModel(tableSelModel);
		table.setEasyview(true);
		table.setBorder(new Border(1, Color.BLACK, Border.STYLE_NONE));
		table.setInsets(new Insets(5, 2, 5, 2));
		Estilo.setFont(table, GUIStyles.NORMAL);
		col.add(table);

		// ----------------------------------------
		// The navigation control
		// ----------------------------------------

		Row row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		ETableNavigation tableNavigation = new ETableNavigation(tableDtaModel);
		row.add(tableNavigation);
		col.add(row);

		return col;

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
		tableColumn.setHeadValue("Posicion");
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
