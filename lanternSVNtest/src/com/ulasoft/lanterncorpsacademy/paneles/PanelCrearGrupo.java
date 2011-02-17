package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPersonajeDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.CheckBox;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
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
import com.ulasoft.lanterncorpsacademy.logic.CrearGrupo;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelCrearGrupo extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();
	private Atributos atrib = app.getAtributos();

	private TestTableModel tableDtaModel;
	private List<IPersonajeDO> personajes;
	private List<IPersonajeDO> listPersonajes;
	private List<Integer> seleccion = new ArrayList<Integer>();
	private TextField txtGrupo;

	public PanelCrearGrupo() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		Grid gridPane = new Grid(1);
		gridPane.setInsets(new Insets(10));
		gridPane.setBackground(Color.WHITE);

		Grid grid = new Grid();
		grid.setStyle(Estilo.getDefaultStyleColor(atrib));
		grid.setWidth(new Extent(500));

		col.add(PanelConstructor.initTopRow("Crear Grupo"));

		Label lblCorreo = new Label("Nombre del Grupo:");
		Estilo.setFont(lblCorreo, GUIStyles.BOLD);
		grid.add(lblCorreo);

		txtGrupo = new TextField();
		txtGrupo.setWidth(new Extent(300));
		try {
			txtGrupo.setText(CrearGrupo.obtenerNombreGrupo( //
					atrib.getPersonaje()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		grid.add(txtGrupo);
		gridPane.add(grid);

		// ----------------------------------------
		// Carga de los Personajes
		// ----------------------------------------

		listPersonajes = new ArrayList<IPersonajeDO>();
		listPersonajes.add(atrib.getPersonaje());
		tableDtaModel = new TestTableModel();
		try {
			personajes = CrearGrupo.obtenerPersonajesClase(atrib.getPersonaje());
		} catch (Exception e) {
			e.printStackTrace();
		}
		tableDtaModel = CrearGrupo.asignarPersonaje(tableDtaModel, personajes, atrib.getPersonaje());

		gridPane.add(PanelConstructor.initTable(tableDtaModel, initTableColModel(), true));
		col.add(gridPane);

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(atrib));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				d.btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

		Button btnCrearGrupo = new Button("Crear Grupo");
		btnCrearGrupo.setStyle(Estilo.getStyleColor(atrib));
		btnCrearGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnCrearGrupoClicked();
			}
		});
		row.add(btnCrearGrupo);

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
				return personaje.getNivel();
			}
		};
		tableColumn.setWidth(new Extent(40));
		tableColumn.setHeadValue("Nivel");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IPersonajeDO personaje = (IPersonajeDO) element;
				return personaje.getId();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Ranking");
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

				boolean editable = ((TestTableModel) table.getTableDtaModel())//
						.getEditable();

				CheckBox checkBox = new CheckBox();
				checkBox.setEnabled(editable);
				checkBox.setToolTipText("Selección");

				checkBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnCheckBoxClicked(row);
					}
				});
				return checkBox;
			}
		});

		return nestedCellRenderer;
	}

	// --------------------------------------------------------------------------------

	private void btnCheckBoxClicked(int row) {

		Integer e = new Integer(row);
		for(int pos = 0; pos < seleccion.size(); pos++) {
			if(seleccion.get(pos).equals(e)) {
				seleccion.remove(pos);
				return;
			}
		}
		seleccion.add(e);

		IPersonajeDO personaje = personajes.get(row);

		for (int i = 0; i < listPersonajes.size(); i++) {
			if (listPersonajes.get(i).equals(personaje)) {
				listPersonajes.remove(i);
				return;
			}
		}
		listPersonajes.add(personaje);

	}

	protected void btnCrearGrupoClicked() {

		if(CrearGrupo.checkNombreGrupoIsEmpty(txtGrupo)) {
			d.setWindowPaneEmergente( //
					"El campo nombre de grupo se encuentran vacío, No se creará el grupo");
			return;
		}
		if(seleccion.isEmpty()) {
			d.setWindowPaneEmergente( //
					"No ha seleccionado ningun personaje para que forme parte del grupo, No se creará el grupo");
			return;
		}

//		try {
//			CrearGrupo.crearGrupo( //
//					atrib.getPersonaje(), personajes, seleccion, txtGrupo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		try {
			CrearGrupo.crearGrupo2(listPersonajes, txtGrupo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		d.setWindowPaneEmergente("El grupo se ha creado con éxito!");
		PanelMain pnlMain = new PanelMain();
		d.setPanelCentral(pnlMain);

	}

}