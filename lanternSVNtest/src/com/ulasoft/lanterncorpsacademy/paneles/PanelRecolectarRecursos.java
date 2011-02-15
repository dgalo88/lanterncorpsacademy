package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IHabilidadDO;
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
import nextapp.echo.app.Label;
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
import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.HabilidadesAnillo;

@SuppressWarnings("serial")
public class PanelRecolectarRecursos extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();

	private TestTableModel tableDtaModel;
	private List<Integer> seleccion = new ArrayList<Integer>();

	public PanelRecolectarRecursos() {

		Column col = new Column();
		col.add(initTopRow());
		col.add(initTable());

		Row row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		Button btnAtras = new Button("Salir");
		btnAtras.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAtras.setWidth(new Extent(160));
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAtrasClicked();
			}
		});
		row.add(btnAtras);

		Button btnAdquirirHabilidad = new Button("Recolectar");
		btnAdquirirHabilidad.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAdquirirHabilidad.setWidth(new Extent(200));
		btnAdquirirHabilidad.setAlignment(Alignment.ALIGN_CENTER);
		btnAdquirirHabilidad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAdquirirHabilidadClicked();
			}
		});
		row.add(btnAdquirirHabilidad);

		col.add(row);
		add(col);
	}

	protected void btnAdquirirHabilidadClicked() {

		if(seleccion.isEmpty()){
			d.setWindowPaneEmergente( //
					"No hay selección");
			return;
		}
//
//		Atributos atrib = app.getAtributos();
//		IPersonajeDO person = atrib.getPersonaje();
//		try {
//			if(HabilidadesAnillo.adquirirHabilidades(seleccion,person)){
//				d.setWindowPaneEmergente( //
//						"No se Poseen Suficientes Puntos de Entrenamiento, No se Adquiere Nada");
//				return;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		atrib.setPersonaje(person);
		d.setWindowPaneEmergente("En construcción");
		return;

	}

	protected void btnAtrasClicked() {

		PanelMain pnlMain = new PanelMain();
		d.setPanelCentral(pnlMain);

	}

	private Component initTable() {

		setInsets(new Insets(2, 2, 2, 2));

		Column col = new Column();
		col.setBackground(Color.WHITE);

		// ----------------------------------------
		// The table models
		// ----------------------------------------

		TableColModel tableColModel = initTableColModel();
		TableSelModel tableSelModel = new TableSelModel();

		tableDtaModel = new TestTableModel();
		tableDtaModel.setEditable(true);
		tableDtaModel.setPageSize(10);

		Atributos atrr=app.getAtributos();
		try {
			tableDtaModel = HabilidadesAnillo.obtenerHabilidadesCompra( //
					atrr.getPersonaje(), tableDtaModel);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
		Label lblTitle = new Label("Lista de Recursos Disponibles");
		row.add(lblTitle);
		row.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		return row;

	}

	// --------------------------------------------------------------------------------

	private TableColModel initTableColModel() {

		TableColModel tableColModel = new TableColModel();
		TableColumn tableColumn;

		tableColumn = new TableColumn() {
//			@Override
//			public Object getValue(ETable table, Object element) {
//				IHabilidadDO habilidad = (IHabilidadDO) element;
//				return habilidad.getNombre();
//			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Nombre");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
//			@Override
//			public Object getValue(ETable table, Object element) {
//				IHabilidadDO habilidad = (IHabilidadDO) element;
//				Atributos atr=app.getAtributos();		    	  
//				try {
//					return HabilidadesAnillo.obtenerNivel( //
//							atr.getPersonaje().getId(),habilidad);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				return 0;
//			}
		};
		tableColumn.setWidth(new Extent(25));
		tableColumn.setHeadValue("Cantidad Máxima Disponible");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);


//		tableColumn = new TableColumn() {
//			@Override
//			public Object getValue(ETable table, Object element) {
//				IHabilidadDO habilidad = (IHabilidadDO) element;
//				return HabilidadesAnillo.determinarTipo(habilidad.getTipo());
//			}
//		};
//		tableColumn.setWidth(new Extent(25));
//		tableColumn.setHeadValue("Tipo");
//		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
//		tableColumn.setDataCellRenderer(new LabelCellRenderer());
//		tableColModel.getTableColumnList().add(tableColumn);
//
//		tableColumn = new TableColumn() {
//			@Override
//			public Object getValue(ETable table, Object element) {
//				IHabilidadDO habilidad = (IHabilidadDO) element;
//				return habilidad.getCosto_de_aprendizaje();
//			}
//		};
//		tableColumn.setWidth(new Extent(25));
//		tableColumn.setHeadValue("Costo de Adquisición");
//		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
//		tableColumn.setDataCellRenderer(new LabelCellRenderer());
//		tableColModel.getTableColumnList().add(tableColumn);

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

}
