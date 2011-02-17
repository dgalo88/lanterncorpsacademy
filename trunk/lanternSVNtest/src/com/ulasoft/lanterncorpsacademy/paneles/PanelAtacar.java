package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.List;

import lcaInterfaceDAO.INpcDO;
import lcaInterfaceDAO.IPersonajeDO;
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
import com.ulasoft.lanterncorpsacademy.logic.Atacar;
import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.Data;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;

@SuppressWarnings("serial")
public class PanelAtacar extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private TestTableModel tableDtaModel;
	private List<IPersonajeDO> personajes;
	private IPersonajeDO personajeAtacar;
	private List<INpcDO> npcList;
	private INpcDO npcAtacar;

	private ButtonGroup btnGroupClases = new ButtonGroup();

	public PanelAtacar() {

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
		try {
			personajes = Atacar.obtenerContrincantes(atrib.getPersonaje());
			npcList = Atacar.obtenerContrincantesNPC(atrib.getPersonaje());
		} catch (Exception e) {
			e.printStackTrace();
		}
		tableDtaModel = Atacar.asignarRankingNpcPersonaje(tableDtaModel, personajes, npcList);

		col.add(PanelConstructor.initTopRow("Atacar Jugadores & NPC`s"));
		col.add(PanelConstructor.initTable(tableDtaModel, initTableColModel(), true));

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnCancelar.setWidth(new Extent(100));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				app.getDesktop().btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

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

//	private Row initTopRow() {
//
//		Row row = new Row();
//		row.setCellSpacing(new Extent(10));
//		row.setAlignment(Alignment.ALIGN_CENTER);
//		Label lblTitle = new Label("Atacar Jugadores & NPC`s");
//		lblTitle.setForeground(Color.WHITE);
//		Estilo.setFont(lblTitle, GUIStyles.BOLD, 16);
//		row.add(lblTitle);
//		return row;
//
//	}

	// --------------------------------------------------------------------------------

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
//		// ----------------------------------------
//		// Carga a los Contrincantes
//		// ----------------------------------------
//
//		Atributos atrib = app.getAtributos();
//		try {
//			personajes = Atacar.obtenerContrincantes(atrib.getPersonaje());
//			npcList = Atacar.obtenerContrincantesNPC(atrib.getPersonaje());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		tableDtaModel = Atacar.asignarRankingNpcPersonaje(tableDtaModel, personajes, npcList);
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
//	}

	// --------------------------------------------------------------------------------

	private TableColModel initTableColModel() {
		TableColModel tableColModel = new TableColModel();

		TableColumn tableColumn;

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {

				Label lblNombre = new Label();

				try {
					IPersonajeDO personaje = (IPersonajeDO) element;
					lblNombre.setText(personaje.getAlias());
				} catch (Exception e) {
//					e.printStackTrace();
				}
				try {
					INpcDO personaje = (INpcDO) element;
					lblNombre.setText(personaje.getNombre());
				} catch (Exception e) {
//					e.printStackTrace();
				}

				return lblNombre.getText();
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

				Label lblNivel = new Label();

				try {
					IPersonajeDO personaje = (IPersonajeDO) element;
					lblNivel.setText(Integer.toString(personaje.getNivel()));
				} catch (Exception e) {
//					e.printStackTrace();
				}
				try {
					INpcDO personaje = (INpcDO) element;
					lblNivel.setText(Integer.toString(personaje.getNivel()));
				} catch (Exception e) {
//					e.printStackTrace();
				}

				return lblNivel.getText();
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

				Label lblClase = new Label();

				try {
					IPersonajeDO personaje = (IPersonajeDO) element;
					lblClase.setText(Data.getClase(personaje.getClaseLinternaRef().getRefIdent()));
				} catch (Exception e) {
//					e.printStackTrace();
				}
				try {
					INpcDO personaje = (INpcDO) element;
					lblClase.setText(personaje.getColor());
				} catch (Exception e) {
//					e.printStackTrace();
				}

				return lblClase.getText();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Clase");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {

				Label lblTipo = new Label();

				try {
					IPersonajeDO personaje = (IPersonajeDO) element;
					lblTipo.setText(Data.getTipo(personaje.getClass()));
				} catch (Exception e) {
//					e.printStackTrace();
				}
				try {
					INpcDO personaje = (INpcDO) element;
					lblTipo.setText(Data.getTipo(personaje.getClass()));
				} catch (Exception e) {
//					e.printStackTrace();
				}

				return lblTipo.getText();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Tipo");
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

		try {
			personajeAtacar = personajes.get(row);
			npcAtacar = null;
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			npcAtacar = npcList.get(row);
			personajeAtacar = null;
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	// --------------------------------------------------------------------------------

	protected void btnAtacarClicked() throws Exception {

		Desktop d = app.getDesktop();
		int result = -1;

		if((personajeAtacar == null) && (npcAtacar == null)) {
			return;
		}
		if (personajeAtacar != null) {
			result = Atacar.combate(personajeAtacar);
		}
		if (npcAtacar != null) {
			result = Atacar.atacarNPC(npcAtacar);
		}

		switch (result) {
		case 0:
			d.setWindowPaneEmergente("El Combate ha resultado un Empate");			
			break;
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
