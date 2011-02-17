package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.List;

import lcaInterfaceDAO.IPersonajeDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
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
import com.ulasoft.lanterncorpsacademy.logic.CrearGrupo;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.MiGrupo;

@SuppressWarnings("serial")
public class PanelMiGrupo extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();

	private TestTableModel tableDtaModel;
	private List<IPersonajeDO> personajes;
	private String nombreGrupo;

	public PanelMiGrupo() {

		try {
			nombreGrupo = CrearGrupo.obtenerNombreGrupo( //
					app.getAtributos().getPersonaje());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (nombreGrupo.equals("")) {
			add(PanelConstructor.initTopRow("No pertences a ningún grupo"));
		} else {
			add(initPanelMiGrupo());
		}

	}

	// --------------------------------------------------------------------------------

	private Component initPanelMiGrupo() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);

		Grid grid = new Grid();
		grid.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		grid.setWidth(new Extent(500));

		// ----------------------------------------
		// Carga a los Miembros del Grupo
		// ----------------------------------------

		tableDtaModel = new TestTableModel();
		try {
			personajes = MiGrupo.obtenerPersonClase( //
					app.getAtributos().getPersonaje());
		} catch (Exception e) {
			e.printStackTrace();
		}
		tableDtaModel = MiGrupo.asignarPersonaje(tableDtaModel, personajes);

		col.add(PanelConstructor.initTopRow(nombreGrupo));
		col.add(PanelConstructor.initTable(tableDtaModel, initTableColModel(), true));

		Button btnInvitarNuevoMiembro = new Button("Invitar Nuevo Miembro");
		btnInvitarNuevoMiembro.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnInvitarNuevoMiembro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnInvitarNuevoMiembroClicked();
			}
		});
		row.add(btnInvitarNuevoMiembro);

		Button btnAbandonarGrupo = new Button("Abandonar Grupo");
		btnAbandonarGrupo.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAbandonarGrupo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnAbandonarGrupoClicked();
			}
		});
		row.add(btnAbandonarGrupo);

		Button btnEnviarMensaje = new Button("Enviar Mensaje");
		btnEnviarMensaje.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnEnviarMensaje.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnEnviarMensajeClicked();
			}
		});
		row.add(btnEnviarMensaje);

		col.add(row);
		return col;
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
		tableColumn.setWidth(new Extent(50));
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

		return tableColModel;

	}

	// --------------------------------------------------------------------------------

	protected void btnEnviarMensajeClicked() {

		PanelMensaje pnlMain = new PanelMensaje();
		d.setPanelCentral(pnlMain);

	}

	protected void btnAbandonarGrupoClicked() {

		String cad = "";
		try {
			int flg = MiGrupo.abandonarGrupo( //
					app.getAtributos().getPersonaje());
			if(flg == 1) {
				cad = " y el grupo se encuentra inactivo por tener solo 1 miembro";
			}
			else if (flg == 0) {
				cad = " y el grupo se ha eliminado por no tener miembros";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		d.setWindowPaneEmergente("Has abandonado el grupo exitosamente" + cad);
		PanelMain pnlMain = new PanelMain();
		d.setPanelCentral(pnlMain);

	}

	protected void btnInvitarNuevoMiembroClicked() {

		PanelInvitarUsuariosGrupo pnlMain = new PanelInvitarUsuariosGrupo();
		d.setPanelCentral(pnlMain);

	}

}
