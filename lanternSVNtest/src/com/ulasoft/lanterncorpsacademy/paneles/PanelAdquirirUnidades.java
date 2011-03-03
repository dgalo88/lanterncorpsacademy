package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.List;

import lcaInterfaceDAO.ITecnologiaDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
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
import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.Unidades;

@SuppressWarnings("serial")
public class PanelAdquirirUnidades extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();

	private TestTableModel tableDtaModel;
	private List<ITecnologiaDO> tecnologiaList;
	private ITecnologiaDO tecnologia;
	private ButtonGroup btnGroupClases = new ButtonGroup();

	public PanelAdquirirUnidades() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		// ----------------------------------------
		// TODO: Carga Unidades Disponible
		// ----------------------------------------

		tableDtaModel = new TestTableModel();
		try {
			tecnologiaList = Unidades.getUnidades( //
					app.getAtributos().getPersonaje());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Button btnAtras = new Button("Atrás");
		btnAtras.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAtrasClicked();
			}
		});

		Button btnAdquirir = new Button("Adquirir Unidades");
		btnAdquirir.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAdquirir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAdquirirClicked();
			}
		});

		if (tecnologiaList == null) {

			app.getDesktop().setWindowPaneEmergente( //
					"Para adquirir unidades básicas necesitas " + //
					"poseer la tecnología correspondiente");

			col.add(PanelConstructor.initTopRow("No posees tecnología", 16));

			row.add(btnAtras);
			btnAdquirir.setEnabled(false);
			row.add(btnAdquirir);
			col.add(row);
			add(col);

			return;
		}

		tableDtaModel = Unidades.asignarUnidades( //
				tableDtaModel, tecnologiaList);

		col.add(PanelConstructor.initTopRow( //
				"Lista de Unidades Disponibles"));
		col.add(PanelConstructor.initTable( //
				tableDtaModel, initTableColModel(), true, 8));

		row.add(btnAtras);
		row.add(btnAdquirir);

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
				ITecnologiaDO tecnologia = (ITecnologiaDO) element;
				try {
					return Unidades.getNombre(tecnologia);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "*";
			}
		};
		tableColumn.setWidth(new Extent(100));
		tableColumn.setHeadValue("Nombre");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {

				ITecnologiaDO tecnologia = (ITecnologiaDO) element;
				Label lblCosto = new Label();
				try {
					lblCosto.setText(Unidades.getCostoUnidadBasicaString( //
							tecnologia));
					return lblCosto.getText();
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					lblCosto.setText(Unidades.getCostoAndroideString( //
							tecnologia));
					return lblCosto.getText();
				} catch (Exception e) {
					// TODO: handle exception
				}
				return "";
			}
		};
		tableColumn.setWidth(new Extent(100));
		tableColumn.setHeadValue("Costo");
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

				RadioButton radioButton = new RadioButton();
				radioButton.setEnabled(editable);
				radioButton.setToolTipText("Selección");
				radioButton.setGroup(btnGroupClases);

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

	private void btnAtrasClicked() {

		PanelAdquirirTecnologia pnlMain = new PanelAdquirirTecnologia();
		d.setPanelCentral(pnlMain);

	}

	private void btnRadioClicked(int row) {
		tecnologia = tecnologiaList.get(row);
	}

	private void btnAdquirirClicked() {

		String result = "";

		if (tecnologia != null) {
			try {
				result = Unidades.adquirirUnidades( //
						app.getAtributos().getPersonaje(), tecnologia);
			} catch (Exception e) {
//				e.printStackTrace();
			}
			try {
				result = Unidades.adquirirAndroides( //
						app.getAtributos().getPersonaje(), tecnologia);
			} catch (Exception e) {
//				e.printStackTrace();
			}
			d.setWindowPaneEmergente(result);
			return;
		}


		d.setWindowPaneEmergente("ERROR: No se han adquirido las unidades");
		return;

	}

}
