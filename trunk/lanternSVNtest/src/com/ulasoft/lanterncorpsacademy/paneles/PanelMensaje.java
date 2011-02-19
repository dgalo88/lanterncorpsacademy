package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.List;

import lcaInterfaceDAO.IClaseLinternaDO;
import lcaInterfaceDAO.IPersonajeDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.CheckBox;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
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
import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.Ranking;

@SuppressWarnings("serial")
public class PanelMensaje extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();

	private TestTableModel tableDtaModel;
	private List<IPersonajeDO> personajes;

	public PanelMensaje() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		// ----------------------------------------
		// TODO: Carga los Mensajes
		// ----------------------------------------

		tableDtaModel = new TestTableModel();
		try {
			personajes = Ranking.obtenerRanking();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tableDtaModel = Ranking.asignarRanking(tableDtaModel, personajes);

		col.add(PanelConstructor.initTopRow("Bandeja de Entrada"));
		col.add(PanelConstructor.initTable( //
				tableDtaModel, initTableColModel(), true, 5));

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancelar.setWidth(new Extent(140));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				d.btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

		Button btnBorrarSeleccionado = new Button("Borrar Seleccionado");
		btnBorrarSeleccionado.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnBorrarSeleccionado.setWidth(new Extent(140));
		btnBorrarSeleccionado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnBorrarSeleccionadoClicked();
			}
		});
		row.add(btnBorrarSeleccionado);

		Button btnBorrarTodo = new Button("Borrar Todo");
		btnBorrarTodo.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnBorrarTodo.setWidth(new Extent(140));
		btnBorrarTodo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnBorrarTodoClicked();
			}
		});
		row.add(btnBorrarTodo);

		Button btnEnviarMensaje = new Button("Enviar Mensaje");
		btnEnviarMensaje.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnEnviarMensaje.setWidth(new Extent(140));
		btnEnviarMensaje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnEnviarMensajeClicked();
			}
		});
		row.add(btnEnviarMensaje);

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
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("Nombre");
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
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("Asunto");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(20));
		tableColumn.setHeadValue("");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(initNestedCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		return tableColModel;

	}

	private NestedCellRenderer initNestedCellRenderer() {

		NestedCellRenderer nestedCellRenderer = new NestedCellRenderer();
		nestedCellRenderer.getCellRendererList().add(new BaseCellRenderer() {
			@Override
			public Component getCellRenderer( //
					final ETable table, final Object value, //
					final int col, final int row) {

				boolean editable = ((TestTableModel) //
						table.getTableDtaModel()).getEditable();

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

	private void btnRadioClicked(int row) {
		// TODO Auto-generated method stub
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

}
