package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IHabilidadDO;
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
import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.HabilidadesAnillo;

@SuppressWarnings("serial")
public class PanelAdquirirHabilidades extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();
	private Atributos atrib = app.getAtributos();

	private TestTableModel tableDtaModel;
	private List<Integer> seleccion = new ArrayList<Integer>();

	public PanelAdquirirHabilidades() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		// ----------------------------------------
		// Carga las Habilidades Disponibles
		// ----------------------------------------

		tableDtaModel = new TestTableModel();
		try {
			tableDtaModel = HabilidadesAnillo.obtenerHabilidadesCompra( //
					atrib.getPersonaje(), tableDtaModel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		col.add(PanelConstructor.initTopRow("Habilidades Disponibles"));
		col.add(PanelConstructor.initTable(tableDtaModel, initTableColModel(), true));

		Button btnAtras = new Button("Atrás");
		btnAtras.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAtras.setWidth(new Extent(160));
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnAtrasClicked();
			}
		});
		row.add(btnAtras);

		Button btnAdquirirHabilidad = new Button("Adquirir Habilidad");
		btnAdquirirHabilidad.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAdquirirHabilidad.setWidth(new Extent(160));
		btnAdquirirHabilidad.setAlignment(Alignment.ALIGN_CENTER);
		btnAdquirirHabilidad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnAdquirirHabilidadClicked();
			}
		});
		row.add(btnAdquirirHabilidad);

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
		tableColumn.setWidth(new Extent(80));
		tableColumn.setHeadValue("Tipo");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IHabilidadDO habilidad = (IHabilidadDO) element;
				return habilidad.getCosto_de_aprendizaje();
			}
		};
		tableColumn.setWidth(new Extent(80));
		tableColumn.setHeadValue("Costo de Adquisición");
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

		Integer e = new Integer(row);
		for(int pos = 0; pos < seleccion.size(); pos++) {
			if(seleccion.get(pos).equals(e)) {
				seleccion.remove(pos);
				return;
			}
		}
		seleccion.add(e);
	}

	protected void btnAtrasClicked() {

		PanelVerHabilidadesAnillo pnlMain = new PanelVerHabilidadesAnillo();
		d.setPanelCentral(pnlMain);

	}

	protected void btnAdquirirHabilidadClicked() {

		if(seleccion.isEmpty()) {
			d.setWindowPaneEmergente( //
					"No ha seleccionado ninguna hablidad para adquirir, No se adquiere nada");
			return;
		}

		IPersonajeDO personaje = atrib.getPersonaje();

		try {
			if(HabilidadesAnillo.adquirirHabilidades(seleccion, personaje)) {
				d.setWindowPaneEmergente( //
						"No se poseen suficientes puntos de entrenamiento, No se adquiere nada");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		atrib.setPersonaje(personaje);
		d.setWindowPaneEmergente("Se han adquirido las habilidades con éxito");
		return;

	}

}
