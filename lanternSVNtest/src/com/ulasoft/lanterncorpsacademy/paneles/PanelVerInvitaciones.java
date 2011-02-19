package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.List;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IPersonajeDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Panel;
import nextapp.echo.app.RadioButton;
import nextapp.echo.app.Row;
import nextapp.echo.app.button.ButtonGroup;
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
import com.ulasoft.lanterncorpsacademy.logic.Ranking;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelVerInvitaciones extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private TestTableModel tableDtaModel;
	private List<IPersonajeDO> personajes;
	private ButtonGroup btnGroupRecursos = new ButtonGroup();

	public PanelVerInvitaciones() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		// ----------------------------------------
		// TODO: Carga las Invitaciones
		// ----------------------------------------

		tableDtaModel = new TestTableModel();
		try {
			personajes = Ranking.obtenerRanking();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tableDtaModel = Ranking.asignarRanking(tableDtaModel, personajes);

		col.add(PanelConstructor.initTopRow("Invitaciones"));
		col.add(PanelConstructor.initTable( //
				tableDtaModel, initTableColModel(), true, 5));

		Button btnRechazarTodos = new Button("Rechazar Todos");
		btnRechazarTodos.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnRechazarTodos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnRechazarTodosClicked();
			}
		});
		row.add(btnRechazarTodos);

		Button btnAceptar = new Button("Aceptar");
		btnAceptar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAceptarClicked();
			}
		});
		row.add(btnAceptar);

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
				IPersonajeDO personaje = (IPersonajeDO) element;
				return personaje.getAlias();
			}
		};
		tableColumn.setWidth(new Extent(100));
		tableColumn.setHeadValue("Alias");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IPersonajeDO personaje = (IPersonajeDO) element;
				IClaseLinternaDO claseLinternaDO = (IClaseLinternaDO) //
						personaje.getClaseLinternaRef().getRefValue();
				return claseLinternaDO.getNombre_de_cuerpo_linterna();
			}
		};
		tableColumn.setWidth(new Extent(100));
		tableColumn.setHeadValue("Nombre del Grupo");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Detalles");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(initNestedCellRendererButton());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(20));
		tableColumn.setHeadValue("");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(initNestedCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		return tableColModel;

	}

	// --------------------------------------------------------------------------------
	// Setup command bar renderer
	// --------------------------------------------------------------------------------

	private NestedCellRenderer initNestedCellRendererButton() {

		NestedCellRenderer nestedCellRenderer = new NestedCellRenderer();
		nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
			@Override
			public Component getCellRenderer( //
					final ETable table, final Object value, //
					final int col, final int row) {

				boolean editable = ((TestTableModel) table.getTableDtaModel()).getEditable();

				Button btnDetalles = new Button("Detalles");

				btnDetalles.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
				Estilo.setFont(btnDetalles, GUIStyles.NORMAL, 12);
				btnDetalles.setWidth(new Extent(70));
				btnDetalles.setHeight(new Extent(15));
				btnDetalles.setEnabled(editable);

				btnDetalles.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						btnDetallesClicked(row);
					}
				});
				return btnDetalles;
			}
		});

		return nestedCellRenderer;
	}

	private NestedCellRenderer initNestedCellRenderer() {

		NestedCellRenderer nestedCellRenderer = new NestedCellRenderer();
		nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
			@Override
			public Component getCellRenderer(
					//
					final ETable table, final Object value, final int col,
					final int row) {

				boolean editable = ((TestTableModel) //
						table.getTableDtaModel()).getEditable();

				RadioButton radioButton = new RadioButton();
				radioButton.setEnabled(editable);
				radioButton.setToolTipText("Selección");
				radioButton.setGroup(btnGroupRecursos);

				radioButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnRadioClicked(row);
					}
				});
				return radioButton;
			}
		});

		return nestedCellRenderer;
	}

	// --------------------------------------------------------------------------------

	private void btnRadioClicked(int row) {

	}

	private void btnDetallesClicked(int row) {

	}

	protected void btnAceptarClicked() {

	}

	protected void btnRechazarTodosClicked() {

	}

	protected void btnRechazarClicked() {

	}

}
