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
public class PanelVerHabilidadesAnillo extends Panel{

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();
	private Atributos atrib = app.getAtributos();

	private TestTableModel tableDtaModel;
	private List<Integer> seleccion = new ArrayList<Integer>();

	public PanelVerHabilidadesAnillo() {

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

		col.add(PanelConstructor.initTopRow("Habilidades del Anillo"));
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

//	private Row initTopRow() {
//
//		Row row = new Row();
//		Label lblTitle = new Label("Habilidades del Anillo");
//		lblTitle.setForeground(Color.WHITE);
//		Estilo.setFont(lblTitle, GUIStyles.BOLD, 16);
//		row.add(lblTitle);
//		row.setAlignment(Alignment.ALIGN_CENTER);
//		return row;
//
//	}
//
//	// --------------------------------------------------------------------------------
//
//	private Component initTable() {
//
//		Column col = new Column();
//		col.setInsets(new Insets(10, 10, 10, 10));
//		col.setCellSpacing(new Extent(10));
//		col.setBackground(Color.WHITE);
//
//		// ----------------------------------------
//		// The table models
//		// ----------------------------------------
//
//		TableColModel tableColModel = initTableColModel();
//		TableSelModel tableSelModel = new TableSelModel();
//		tableDtaModel = new TestTableModel();
//		tableDtaModel.setEditable(true);
//		tableDtaModel.setPageSize(10);
//
//		try {
//			tableDtaModel = HabilidadesAnillo.obtenerHabilidades( //
//					atrib.getPersonaje(), tableDtaModel);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		// ----------------------------------------
//		// The table
//		// ----------------------------------------
//
//		ETable table = new ETable();
//		table.setTableDtaModel(tableDtaModel);
//		table.setTableColModel(tableColModel);
//		table.setTableSelModel(tableSelModel);
//		table.setEasyview(true);
//		table.setBorder(new Border(1, Color.BLACK, Border.STYLE_NONE));
//		table.setInsets(new Insets(5, 2, 5, 2));
//		Estilo.setFont(table, GUIStyles.NORMAL);
//		col.add(table);
//
//		// ----------------------------------------
//		// The navigation control
//		// ----------------------------------------
//
//		ETableNavigation tableNavigation = new ETableNavigation(tableDtaModel);
//		col.add(tableNavigation);
//
//		return col;
//
//	}

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
		tableColumn.setWidth(new Extent(50));
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
		tableColumn.setWidth(new Extent(25));
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
		tableColumn.setWidth(new Extent(25));
		tableColumn.setHeadValue("Costo de Entrenar");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(25));
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

		if(seleccion.isEmpty()) {
			d.setWindowPaneEmergente( //
					"No ha seleccionado ninguna hablidad para entrenar, No se entrenará nada");
			return;
		}
 
		IPersonajeDO personaje = atrib.getPersonaje();

		try {
			if(HabilidadesAnillo.entrenarHabilidades(seleccion, personaje)) {
				d.setWindowPaneEmergente( //
						"No se poseen suficientes puntos de entrenamiento, No se entrenará nada");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		atrib.setPersonaje(personaje);
		d.setWindowPaneEmergente("Se han entrenado las habilidades con éxito");
		return;

	}

}
