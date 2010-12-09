package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.RadioButton;
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
import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;

@SuppressWarnings("serial")
public class PanelMensaje extends Panel {

	private TestTableModel tableDtaModel;

	public PanelMensaje() {
		Column col = new Column();
		Row row1 = new Row();
		row1.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		Label lblTitle = new Label("Bandeja de Entrada:");
		row1.add(lblTitle);
		col.add(row1);

		col.add(initTable());

		Row row = new Row();

		Button btnAtras = new Button("Atras");
		btnAtras.setStyle(Estilo.getStyle2Color(app.getAtributos()));
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAtrasClicked();
			}
		});

		row.add(btnAtras);

		Button btnBorrarSeleccionado = new Button("Borrar Seleccionado");
		btnBorrarSeleccionado.setStyle(Estilo.getStyle2Color(app.getAtributos()));
		btnBorrarSeleccionado.setWidth(new Extent(200));
		btnBorrarSeleccionado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnBorrarSeleccionadoClicked();
			}
		});
		row.add(btnBorrarSeleccionado);

		Button btnBorrarTodo = new Button("Borrar Todo");
		btnBorrarTodo.setStyle(Estilo.getStyle2Color(app.getAtributos()));
		btnBorrarTodo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnBorrarTodoClicked();
			}
		});

		row.add(btnBorrarTodo);

		Button btnEnviarMensaje = new Button("Enviar Mensaje");
		btnEnviarMensaje.setStyle(Estilo.getStyle2Color(app.getAtributos()));
		btnEnviarMensaje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnEnviarMensajeClicked();
			}
		});

		row.add(btnEnviarMensaje);
		row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);
		add(col);
	}

	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
			.getActive();
	Desktop d = app.getDesktop();

	protected void btnAtrasClicked() {
		PanelMiGrupo pnlMain = new PanelMiGrupo();
		d.setPanelCentral(pnlMain);

	}

	protected void btnEnviarMensajeClicked() {
		PanelEnviarMensaje pnlMain = new PanelEnviarMensaje();
		d.setPanelCentral(pnlMain);

	}

	protected void btnBorrarTodoClicked() {
		// TODO Auto-generated method stub

	}

	protected void btnBorrarSeleccionadoClicked() {
		// TODO Auto-generated method stub
	}

	private Component initTable() {
		setInsets(new Insets(2, 2, 2, 2));

		Column col = new Column();
		// col.setCellSpacing(new Extent(1));
		col.setBackground(Color.WHITE);

		col.add(initTopRow());

		// ----------------------------------------
		// The table models
		// ----------------------------------------

		TableColModel tableColModel = initTableColModel();
		TableSelModel tableSelModel = new TableSelModel();

		tableDtaModel = new TestTableModel();
		tableDtaModel.setEditable(true);
		tableDtaModel.setPageSize(3);

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
		col.add(table);

		// ----------------------------------------
		// The navigation control
		// ----------------------------------------

		ETableNavigation tableNavigation = new ETableNavigation(tableDtaModel);
		col.add(tableNavigation);
		return col;
	}

	private Row initTopRow() {
		Row row = new Row();
		row.setCellSpacing(new Extent(5));

		return row;
	}

	// --------------------------------------------------------------------------------

	private TableColModel initTableColModel() {
		TableColModel tableColModel = new TableColModel();

		TableColumn tableColumn;

		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Actions");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(initNestedCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
//				PersonBean personaBean = (PersonBean) element;
				return "";//personaBean.getFrstName();
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
//				PersonBean personaBean = (PersonBean) element;
				return "";//personaBean.getLastName();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Asunto");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		return tableColModel;
	}

	private NestedCellRenderer initNestedCellRenderer() {
		NestedCellRenderer nestedCellRenderer = new NestedCellRenderer();
		nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
			@Override
			public Component getCellRenderer(
					//
					final ETable table, final Object value, final int col,
					final int row) {

				boolean editable = ((TestTableModel) table.getTableDtaModel())
						.getEditable();

				RadioButton ret = new RadioButton();
				ret.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
				ret.setEnabled(editable);
				ret.setToolTipText("Seleccion");

				ret.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnRadioClicked(row);
					}
				});
				return ret;
			}
		});

		return nestedCellRenderer;
	}

	// --------------------------------------------------------------------------------

	private void btnRadioClicked(int row) {
		// TODO Auto-generated method stub
	}
}
