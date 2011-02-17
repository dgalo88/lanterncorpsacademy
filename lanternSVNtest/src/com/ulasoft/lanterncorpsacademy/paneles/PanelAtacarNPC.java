package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.List;

import lcaInterfaceDAO.INpcDO;
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
import com.ulasoft.lanterncorpsacademy.logic.Atacar;
import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;

@SuppressWarnings("serial")
public class PanelAtacarNPC extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private TestTableModel tableDtaModel;
	private List<INpcDO> personajes;
	private INpcDO personajeAtacar;

	private ButtonGroup btnGroupClases = new ButtonGroup();

	public PanelAtacarNPC() throws Exception {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		// ----------------------------------------
		// Carga a los Contrincantes
		// ----------------------------------------

		tableDtaModel = new TestTableModel();
		Atributos atrib = app.getAtributos();
		personajes = Atacar.obtenerContrincantesNPC(atrib.getPersonaje());
		tableDtaModel = Atacar.asignarRankingNPC(tableDtaModel, personajes);

		col.add(PanelConstructor.initTopRow("Lista de Contrincantes NPC"));
		col.add(PanelConstructor.initTable(tableDtaModel, initTableColModel(), true));

		Button btnAtacar = new Button("Atacar");
		btnAtacar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAtacar.setWidth(new Extent(100));
		btnAtacar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnAtacarClicked();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		row.add(btnAtacar);

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
				INpcDO personaje = (INpcDO) element;
				return personaje.getNombre();
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
				INpcDO personaje = (INpcDO) element;
				return personaje.getNivel();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Nivel");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				INpcDO personaje = (INpcDO) element;
				return personaje.getColor();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Clase");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(50));
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
					final ETable table, final Object value, final int col, //
					final int row) {

				boolean editable = ((TestTableModel) table.getTableDtaModel())
				.getEditable();

				RadioButton ret = new RadioButton();
				ret.setEnabled(editable);
				ret.setToolTipText("Selección");
				ret.setGroup(btnGroupClases);

				ret.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnRadioClicked(row);
					}
				});
				return ret;
			}
		});

		return nestedCellRenderer;
	}

	// --------------------------------------------------------------------------------

	private void btnRadioClicked(int row) {
		personajeAtacar = personajes.get(row);
	}

	// --------------------------------------------------------------------------------

	protected void btnAtacarClicked() throws Exception {

		if(personajeAtacar == null){
			return;
		}

		Desktop d = app.getDesktop();

		switch (Atacar.atacarNPC(personajeAtacar)) {
		case 1:
			d.setWindowPaneEmergente("Ganaste el Combate");			
			break;
		case 2:
			d.setWindowPaneEmergente("Perdiste el Combate");			
			break;
		default:
			break;
		}

		PanelMain pnlMain = new PanelMain();
		d.setPanelCentral(pnlMain);

	}

}
