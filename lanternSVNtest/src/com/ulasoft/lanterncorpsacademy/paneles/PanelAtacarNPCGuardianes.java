package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.List;

import lcaInterfaceDAO.INpcDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.Conquistar;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;

@SuppressWarnings("serial")
public class PanelAtacarNPCGuardianes extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private TestTableModel tableDtaModel;
	private List<INpcDO> personajes;

	public PanelAtacarNPCGuardianes() throws Exception {

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
		personajes = Conquistar.obtenerNPCGuardianes(atrib.getPersonaje());
		tableDtaModel = Conquistar.asignarRankingNPC(tableDtaModel, personajes);

		col.add(PanelConstructor.initTopRow("Lista de Contrincantes NPC"));
		col.add(PanelConstructor.initTable(tableDtaModel, initTableColModel(), true));

		Button btnConquistar = new Button("Conquistar");
		btnConquistar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnConquistar.setWidth(new Extent(100));
		btnConquistar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnConquistarClicked();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		row.add(btnConquistar);

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
		tableColumn.setWidth(new Extent(100));
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
		tableColumn.setWidth(new Extent(100));
		tableColumn.setHeadValue("Clase");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		return tableColModel;

	}

	// --------------------------------------------------------------------------------

	protected void btnConquistarClicked() throws Exception {

		if(personajes == null){
			return;
		}

		Desktop d = app.getDesktop();

		switch (Conquistar.atacarNPCGuardianes(tableDtaModel, personajes)) {
		case 1:
			d.setWindowPaneEmergente("Ganaste el Combate. Has conquistado el planeta");
			break;
		case 2:
			d.setWindowPaneEmergente("Perdiste el Combate. Fallaste conquistando el planeta");
			break;
		default:
			break;
		}

		PanelMain pnlMain = new PanelMain();
		d.setPanelCentral(pnlMain);

	}

}
