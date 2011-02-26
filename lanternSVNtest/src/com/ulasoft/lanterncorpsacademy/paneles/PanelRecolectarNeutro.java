package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lcaInterfaceDAO.IRecursoPlanetaDO;
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
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.Recolectar;

@SuppressWarnings("serial")
public class PanelRecolectarNeutro extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();

	private TestTableModel tableDtaModel;
	private List<IRecursoPlanetaDO> recursoPlanetaList;
	private IRecursoPlanetaDO recursoPlanetaDO;
	private List<Integer> seleccion = new ArrayList<Integer>();
	private ButtonGroup btnGroupRecursos = new ButtonGroup();

	public PanelRecolectarNeutro() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		// ----------------------------------------
		// Carga los Recursos Disponibles
		// ----------------------------------------
		tableDtaModel = new TestTableModel();
		try {
			recursoPlanetaList = Recolectar.getRecursosPlaneta( //
					app.getAtributos().getPersonaje());
		} catch (Exception e) {
			e.printStackTrace();
		}
		tableDtaModel = Recolectar.asignarRecursos(tableDtaModel, recursoPlanetaList);

		col.add(PanelConstructor.initTopRow("Lista de Recursos Disponibles"));
		col.add(PanelConstructor.initTable( //
				tableDtaModel, initTableColModel(), false, 2));

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				d.btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

		Button btnRecolectar = new Button("Recolectar");
		btnRecolectar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnRecolectar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnRecolectarClicked();
			}
		});
		row.add(btnRecolectar);

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
				IRecursoPlanetaDO recursoPlanetaDO = (IRecursoPlanetaDO) element;
				try {
					return Recolectar.getRecurso(recursoPlanetaDO).getNombre();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
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
				IRecursoPlanetaDO recursoPlanetaDO = (IRecursoPlanetaDO) element;
				return recursoPlanetaDO.getCantidad_maxima_recurso();
			}
		};
		tableColumn.setWidth(new Extent(100));
		tableColumn.setHeadValue("Cantidad Máxima Disponible");
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
		recursoPlanetaDO = recursoPlanetaList.get(row);
	}

	private void btnRecolectarClicked() {

		if(recursoPlanetaDO.equals(null)){
			d.setWindowPaneEmergente("Seleccione un recurso");
			return;
		}

		Calendar dateInit = Calendar.getInstance();

//		Atributos atrib = app.getAtributos();
//		IPersonajeDO person = atrib.getPersonaje();
//		try {
//			if(HabilidadesAnillo.adquirirHabilidades(seleccion,person)) {
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

}
