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
import com.ulasoft.lanterncorpsacademy.logic.Estilo;

@SuppressWarnings("serial")
public class PanelAtacar extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Atributos atrib = app.getAtributos();

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

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.setStyle(Estilo.getStyleColor(atrib));
		btnCancelar.setWidth(new Extent(100));
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				app.getDesktop().btnCancelarClicked();
			}
		});
		row.add(btnCancelar);

		Button btnAtacar = new Button("Atacar");
		btnAtacar.setStyle(Estilo.getStyleColor(atrib));
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

		if(atrib.getPersonaje().getPlanetaRef().getRefIdent() == //
			atrib.getPersonaje().getClaseLinternaRef().getRefIdent()) {

			btnAtacar.setEnabled(false);
			col.setCellSpacing(new Extent(50));
			col.add(PanelConstructor.initTopRow( //
					"No puedes atacar porque te encuentras en el Planeta Base"));
			col.add(row);
			add(col);

			app.getDesktop().setWindowPaneEmergente( //
					"No puedes atacar porque te encuentras en el Planeta Base");
			return;

		}

		// ----------------------------------------
		// Carga a los Contrincantes
		// ----------------------------------------

		tableDtaModel = new TestTableModel();
		try {
			personajes = Atacar.obtenerContrincantes(atrib.getPersonaje());
			npcList = Atacar.obtenerContrincantesNPC(atrib.getPersonaje());
		} catch (Exception e) {
			e.printStackTrace();
		}
		tableDtaModel = Atacar.asignarRankingNpcPersonaje( //
				tableDtaModel, personajes, npcList);

		col.add(PanelConstructor.initTopRow("Atacar Jugadores & NPC`s"));
		col.add(PanelConstructor.initTable( //
				tableDtaModel, initTableColModel(), true));

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
		tableColumn.setWidth(new Extent(100));
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
		tableColumn.setWidth(new Extent(25));
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
					lblClase.setText(personaje.getClaseLinternaRef() //
							.getRefValue().getNombre_de_cuerpo_linterna());
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
		tableColumn.setWidth(new Extent(150));
		tableColumn.setHeadValue("Clase");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {

				Label lblTipo = new Label();

				try {
					@SuppressWarnings("unused")
					IPersonajeDO personaje = (IPersonajeDO) element;
					lblTipo.setText("Jugador");
				} catch (Exception e) {
//					e.printStackTrace();
				}
				try {
					@SuppressWarnings("unused")
					INpcDO personaje = (INpcDO) element;
					lblTipo.setText("NPC");
				} catch (Exception e) {
//					e.printStackTrace();
				}

				return lblTipo.getText();
			}
		};
		tableColumn.setWidth(new Extent(100));
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
//			e.printStackTrace();
		}
		try {
			npcAtacar = npcList.get(row);
			personajeAtacar = null;
		}  catch (Exception e) {
//			e.printStackTrace();			
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
