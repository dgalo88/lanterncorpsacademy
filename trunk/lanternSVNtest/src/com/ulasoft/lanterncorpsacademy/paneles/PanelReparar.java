package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IHabilidadDO;
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
import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.HabilidadesAnillo;

@SuppressWarnings("serial")
public class PanelReparar extends Panel{

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();
	private Atributos atrib = app.getAtributos();

	private TestTableModel tableDtaModel;
	private List<Integer> seleccion = new ArrayList<Integer>();

	private ButtonGroup btnGroupClases = new ButtonGroup();

	public PanelReparar() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		// ----------------------------------------
		// Carga Habilidades
		// ----------------------------------------

		tableDtaModel = new TestTableModel();
		try {
			tableDtaModel = HabilidadesAnillo.obtenerHabilidades( //
					atrib.getPersonaje(), tableDtaModel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		col.add(PanelConstructor.initTopRow( //
				"Selecciona Unidad para Reparar"));
		col.add(PanelConstructor.initTable( //
				tableDtaModel, initTableColModel(), true));

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancelar.setWidth(new Extent(100));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				d.btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

		Button btnReparar = new Button("Reparar");
		btnReparar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnReparar.setWidth(new Extent(100));
		btnReparar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnRepararClicked();
			}
		});
		row.add(btnReparar);

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
				IHabilidadDO habilidad = (IHabilidadDO) element;
				return habilidad.getNombre();
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
				IHabilidadDO habilidad = (IHabilidadDO) element;
				try {
					return HabilidadesAnillo.obtenerNivel( //
							atrib.getPersonaje().getId(),habilidad);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return 0;
			}
		};
		tableColumn.setWidth(new Extent(25));
		tableColumn.setHeadValue("Nivel");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IHabilidadDO habilidad = (IHabilidadDO) element;
				return HabilidadesAnillo.determinarTipo(habilidad.getTipo());
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
				IHabilidadDO habilidad = (IHabilidadDO) element;
				try {
					return (int)(Math.pow(2, HabilidadesAnillo.obtenerNivel( //
							atrib.getPersonaje().getId(), habilidad))*100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return 0;
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Costo de Reparar");
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

				boolean editable = ((TestTableModel) //
						table.getTableDtaModel()).getEditable();

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

		Integer e = new Integer(row);
		for(int pos = 0; pos < seleccion.size(); pos++) {
			if(seleccion.get(pos).equals(e)) {
				seleccion.remove(pos);
				return;
			}
		}
		seleccion.add(e);

	}

	protected void btnRepararClicked() {

		if(seleccion.isEmpty()) {
			d.setWindowPaneEmergente( //
					"No ha seleccionado ninguna hablidad para entrenar, No se entrenará nada");
			return;
		}
 
//		IPersonajeDO personaje = atrib.getPersonaje();
//
//		try {
//			if(HabilidadesAnillo.entrenarHabilidades(seleccion, personaje)) {
//				d.setWindowPaneEmergente( //
//						"No se poseen suficientes puntos de entrenamiento, No se entrenará nada");
//				return;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		atrib.setPersonaje(personaje);
//		d.setWindowPaneEmergente("Se han entrenado las habilidades con éxito");
//		return;

		PanelRepararUnidad pnlMain = new PanelRepararUnidad();
		d.setPanelCentral(pnlMain);

	}

}
