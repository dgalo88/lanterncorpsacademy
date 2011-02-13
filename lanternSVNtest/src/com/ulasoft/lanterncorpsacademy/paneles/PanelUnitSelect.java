package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPersonajeDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.CheckBox;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.ETableNavigation;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.base.TableSelModel;
import com.minotauro.echo.table.renderer.BaseCellRenderer;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.minotauro.echo.table.renderer.NestedCellRenderer;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.Ranking;


@SuppressWarnings("serial")
public class PanelUnitSelect extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private TestTableModel tableDtaModel;
	private List<IPersonajeDO> personajes;
	int pos=0;

	public PanelUnitSelect() {

		setInsets(new Insets(2, 2, 2, 2));

		Row row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);
		Column col = new Column();
		col.setCellSpacing(new Extent(1));
		col.setBackground(Color.WHITE);
		add(col);

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
		table.setBorder(new Border(1, Color.BLACK, Border.STYLE_SOLID));
		table.setInsets(new Insets(4, 2, 4, 2));
		col.add(table);

		// ----------------------------------------
		// The navigation control
		// ----------------------------------------

		ETableNavigation tableNavigation = new ETableNavigation(tableDtaModel);
		col.add(tableNavigation);

		// ----------------------------------------
		// Buttons
		// ----------------------------------------

		Button btnCancel = new Button("Cancelar");
		btnCancel.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancel.setWidth(new Extent(80));
		btnCancel.setHeight(new Extent(20));
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnCancelClicked();
			}
		});
		row.add(btnCancel);

		Button btnAcept = new Button("Aceptar");
		btnAcept.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAcept.setWidth(new Extent(80));
		btnAcept.setHeight(new Extent(20));
		btnAcept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnAceptClicked();
			}
		});
		row.add(btnAcept);

		col.add(row);

	}

	// --------------------------------------------------------------------------------

	private TableColModel initTableColModel() {

		TableColModel tableColModel = new TableColModel();
		TableColumn tableColumn;

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IPersonajeDO personaje = (IPersonajeDO) element;
				return personaje.getAlias();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Nombre");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IPersonajeDO personaje = (IPersonajeDO) element; 
				return personaje.getId();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Tipo");
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
				return personaje.getId();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Ataque");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IPersonajeDO personaje = (IPersonajeDO) element;
				return personaje.getId();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Defensa");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("");
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

				boolean editable = ((TestTableModel) table.getTableDtaModel()).getEditable();

				CheckBox checkBox = new CheckBox();
				checkBox.setEnabled(editable);
				checkBox.setToolTipText("Selección");

				checkBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnRadioClicked(row);
					}
				});
				return checkBox;
			}
		});

		return nestedCellRenderer;
	}

	// --------------------------------------------------------------------------------

	// TODO: Cambiar por lista de Unidades
	private List<Integer> seleccion = new ArrayList<Integer>();

	private void btnRadioClicked(int row) {

		Integer e = new Integer(row);
		for(int pos = 0; pos < seleccion.size(); pos++) {
			if(seleccion.get(pos).equals(e)){
				seleccion.remove(pos);
				return;
			}
		}
		seleccion.add(e);
	}

	// --------------------------------------------------------------------------------

	private void btnCancelClicked() {
		// Empty
	}

	private void btnAceptClicked() {
		// Empty
	}

}
