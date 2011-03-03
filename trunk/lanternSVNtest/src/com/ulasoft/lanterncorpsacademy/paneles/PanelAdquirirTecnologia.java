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
import com.ulasoft.lanterncorpsacademy.logic.Tecnologia;

@SuppressWarnings("serial")
public class PanelAdquirirTecnologia extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();

	private TestTableModel tableDtaModel;
	private List<ITecnologiaDO> tecnologiaList;
	private ITecnologiaDO tecnologia;
	private ButtonGroup btnGroupClases = new ButtonGroup();

	public PanelAdquirirTecnologia() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		// ----------------------------------------
		// Carga Tecnología Disponible
		// ----------------------------------------

		tableDtaModel = new TestTableModel();
		try {
			tecnologiaList = Tecnologia.getTecnologiaPersonaje( //
					app.getAtributos().getPersonaje());
		} catch (Exception e) {
			e.printStackTrace();
		}
		tableDtaModel = Tecnologia.asignarTecnologia( //
				tableDtaModel, tecnologiaList);

		col.add(PanelConstructor.initTopRow( //
				"Lista de Tecnologías Disponibles"));
		col.add(PanelConstructor.initTable( //
				tableDtaModel, initTableColModel(), true, 8));

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(app.getAtributos()));
//		btnCancelar.setWidth(new Extent(200));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				d.btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

		Button btnAdquirirTecnologia = new Button("Adquirir Tecnología");
		btnAdquirirTecnologia.setStyle(Estilo.getStyleColor(app.getAtributos()));
//		btnAdquirirTecnologia.setWidth(new Extent(200));
		btnAdquirirTecnologia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAdquirirTecnologiaClicked();
			}
		});
		row.add(btnAdquirirTecnologia);

//		Button btnAdquirirUnidades = new Button("Adquirir Unidades Básicas");
//		btnAdquirirUnidades.setStyle(Estilo.getStyleColor(app.getAtributos()));
//		btnAdquirirUnidades.setWidth(new Extent(200));
//		btnAdquirirUnidades.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				btnAdquirirUnidadesClicked();
//			}
//		});
//		row.add(btnAdquirirUnidades);

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
				return tecnologia.getNombre();
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
				Label lblCosto = new Label();
				ITecnologiaDO tecnologia = (ITecnologiaDO) element;
				try {
					 lblCosto.setText(Tecnologia.getCostoString(tecnologia));
				} catch (Exception e) {
					e.printStackTrace();
				}
				return lblCosto.getText();
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

	private void btnRadioClicked(int row) {
		tecnologia = tecnologiaList.get(row);
	}

	private void btnAdquirirTecnologiaClicked() {

		String result = "";

		if (tecnologia != null) {

			try {
				result = Tecnologia.adquirirTecnologia( //
						app.getAtributos().getPersonaje(), //
						tecnologia);
				d.setWindowPaneEmergente(result);
				return;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		d.setWindowPaneEmergente("No hay selección");

	}

//	private void btnAdquirirUnidadesClicked() {
//
//		PanelAdquirirUnidades pnlMain = new PanelAdquirirUnidades();
//		d.setPanelCentral(pnlMain);
//
//	}

}
