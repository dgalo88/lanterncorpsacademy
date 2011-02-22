package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IRecursoDO;
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
import com.ulasoft.lanterncorpsacademy.logic.Recolectar;

@SuppressWarnings("serial")
public class PanelPruebaRecolectar extends Panel{

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();
	private Atributos atrib = app.getAtributos();

	private TestTableModel tableDtaModel;
	private List<Integer> seleccion = new ArrayList<Integer>();

	public PanelPruebaRecolectar() {

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
			tableDtaModel = Recolectar.getRecursosPlaneta( //
					atrib.getPersonaje(), tableDtaModel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		col.add(PanelConstructor.initTopRow("Recolectar"));
		col.add(PanelConstructor.initTable(tableDtaModel, initTableColModel(), true));

		Button btnAdquirirHabilidad = new Button("Adquirir Nueva Habilidad");
		btnAdquirirHabilidad.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAdquirirHabilidad.setWidth(new Extent(180));
		btnAdquirirHabilidad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnAdquirirHabilidadClicked();
			}
		});
		row.add(btnAdquirirHabilidad);

		Button btnEntrenarHabilidad = new Button("Entrenar Habilidad");
		btnEntrenarHabilidad.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnEntrenarHabilidad.setWidth(new Extent(180));
		btnEntrenarHabilidad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnEntrenarHabilidadClicked();
			}
		});
		row.add(btnEntrenarHabilidad);

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
				IRecursoDO recurso = (IRecursoDO) element;
				return recurso.getNombre();
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
				IRecursoDO recurso = (IRecursoDO) element;
				return recurso.getArticulo();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Articulo");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IRecursoDO recurso = (IRecursoDO) element;
				return recurso.getId();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("ID");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

//		tableColumn = new TableColumn() {
//			@Override
//			public Object getValue(ETable table, Object element) {
//				IHabilidadDO habilidad = (IHabilidadDO) element;
//				try {
//					return (int)(Math.pow(2, HabilidadesAnillo.obtenerNivel( //
//							atrib.getPersonaje().getId(), habilidad))*100);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				return 0;
//			}
//		};
//		tableColumn.setWidth(new Extent(50));
//		tableColumn.setHeadValue("Costo de Entrenar");
//		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
//		tableColumn.setDataCellRenderer(new LabelCellRenderer());
//		tableColModel.getTableColumnList().add(tableColumn);

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

	protected void btnAdquirirHabilidadClicked() {

		PanelAdquirirHabilidades pnlMain = new PanelAdquirirHabilidades();		
		d.setPanelCentral(pnlMain);

	}

	protected void btnEntrenarHabilidadClicked() {

//		if(seleccion.isEmpty()) {
//			d.setWindowPaneEmergente( //
//					"No ha seleccionado ninguna habilidad para entrenar, No se entrenará nada");
//			return;
//		}
// 
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
		d.setWindowPaneEmergente("Se han entrenado las habilidades con éxito");
		return;

	}

}
