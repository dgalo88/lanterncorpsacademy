package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPersonajeDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
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
import com.ulasoft.lanterncorpsacademy.logic.CrearGrupo;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelCrearGrupo extends Panel {

	private TestTableModel tableDtaModel;
	List<IPersonajeDO> personajes;
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
			.getActive();
	List<Integer> seleccion = new ArrayList<Integer>();
	TextField txtGrupo;
	
	public PanelCrearGrupo() {
		Column col = new Column();

		Grid grid = new Grid(2);
		grid.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		grid.setWidth(new Extent(500));
		Label lblCorreo = new Label("Nombre del Grupo");
		// lblCorreo.
		grid.add(lblCorreo);
		txtGrupo = new TextField();
		txtGrupo.setWidth(new Extent(300));
		// txtCorreo.validate();
		try {
			txtGrupo.setText(CrearGrupo.obtenerNombreGrupo(app.getAtributos()
					.getPersonaje()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		grid.add(txtGrupo);
		col.add(grid);

		col.add(initTable());

		Row row = new Row();
		Button btnSalir = new Button("Cancelar");
		btnSalir.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnSalirClicked();
			}
		});

		Button btnCrearGrupo = new Button("Crear Grupo");
		btnCrearGrupo.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCrearGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnCrearGrupoClicked();
			}
		});

		if (!txtGrupo.getText().equals("")) {
			btnSalir.setEnabled(false);
			btnCrearGrupo.setEnabled(false);
		}

		row.add(btnSalir);
		row.add(btnCrearGrupo);
		row.setAlignment(Alignment.ALIGN_CENTER);
		col.add(row);
		add(col);
	}

	Desktop d = app.getDesktop();

	protected void btnCrearGrupoClicked() {
		if(CrearGrupo.checkNombreGrupo(txtGrupo)){
			d.setWindowPaneEmergente("El Campo Nombre de Grupo se encuentran Vacio, NO se Creara el Grupo");
			return;
		}
		if(seleccion.isEmpty()){
			d.setWindowPaneEmergente("No ha Seleccionado Ningun Personaje para que Forme Parte de su Grupo, NO se Creara el Grupo");
			return;
		}
		try {
			CrearGrupo.crearGrupo(app.getAtributos()
					.getPersonaje(), personajes, seleccion, txtGrupo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		d.setWindowPaneEmergente("El Grupo se ha Crearado con Exito!");
		PanelMain pnlMain = new PanelMain();
		d.setPanelCentral(pnlMain);
	}

	protected void btnSalirClicked() {
		PanelMain pnlMain = new PanelMain();
		d.setPanelCentral(pnlMain);
	}

	private Component initTable() {
		setInsets(new Insets(2, 2, 2, 2));

		Column col = new Column();
		// col.setCellSpacing(new Extent(1));
		col.setBackground(Color.WHITE);

		col.add(initTopRow());

		// ----------------------------------------
		// The table models
		// ----------------------------------------

		TableColModel tableColModel = initTableColModel();
		TableSelModel tableSelModel = new TableSelModel();

		tableDtaModel = new TestTableModel();
		tableDtaModel.setEditable(true);
		tableDtaModel.setPageSize(10);

		Atributos atrr = app.getAtributos();
		try {
			personajes = CrearGrupo.obtenerPersonasClase(atrr.getPersonaje());
		} catch (Exception e) {
			e.printStackTrace();
		}
		tableDtaModel = CrearGrupo.asignarPersonaje(tableDtaModel, personajes, atrr.getPersonaje());

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
		row.setCellSpacing(new Extent(5));

		return row;
	}

	// --------------------------------------------------------------------------------

	private TableColModel initTableColModel() {
		TableColModel tableColModel = new TableColModel();

		TableColumn tableColumn;

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IPersonajeDO personaje = (IPersonajeDO) element;
				return personaje.getId();
			}
		};

		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Posicion");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IPersonajeDO personaje = (IPersonajeDO) element;
				return personaje.getAlias();
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
				IPersonajeDO personaje = (IPersonajeDO) element;
				return personaje.getNivel();
			}
		};

		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Nivel");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Actions");
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
			public Component getCellRenderer(
					//
					final ETable table, final Object value, final int col,
					final int row) {

				boolean editable = ((TestTableModel) table.getTableDtaModel())
						.getEditable();

				CheckBox ret = new CheckBox();
				// ret.setStyle(GUIStyles.DEFAULT_STYLE);
				ret.setEnabled(editable);
				ret.setToolTipText("Seleccion");

				ret.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnCheckBoxClicked(row);
					}
				});
				return ret;
			}
		});

		return nestedCellRenderer;
	}

	// --------------------------------------------------------------------------------

	private void btnCheckBoxClicked(int row) {
		Integer e = new Integer(row);
		for(int pos=0;pos<seleccion.size();pos++){
			if(seleccion.get(pos).equals(e)){
				seleccion.remove(pos);
				return;
			}
		}
		seleccion.add(e);
	}
}