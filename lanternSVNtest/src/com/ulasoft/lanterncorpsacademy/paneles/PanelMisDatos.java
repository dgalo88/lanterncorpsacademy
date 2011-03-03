package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPlanetaDO;
import lcaInterfaceDAO.IRecursoPersonajeDO;
import nextapp.echo.app.Border;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.Recursos;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelMisDatos extends Panel {

	private static final int SIZE2 = 11;
	private static final int SIZE = 12;

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private TestTableModel tableDtaModel;
	private List<IRecursoPersonajeDO> recursoPersonajeList = //
		new ArrayList<IRecursoPersonajeDO>();

	private IPlanetaDO planeta;
	private Label lblNombre;
	private Label lblCorreo;
	private Label lblAlias;
	private Label lblPlanetaCasa;
	private Label lblClase;
	private Label lblNivel;
	private Label lblPuntosEntrenamiento;
	private Label lblOfertas;

	public PanelMisDatos() {

		Atributos atrib = app.getAtributos();

		lblNombre = new Label("Nombre");
		lblCorreo = new Label("Correo");
		lblAlias = new Label("Alias");
		lblPlanetaCasa = new Label("Planeta Casa");
		lblClase = new Label("Clase");
		lblNivel = new Label("Nivel");
		lblPuntosEntrenamiento = new Label("Puntos de Entrenamiento");
		lblOfertas = new Label("Ofertas");

		try {
			recursoPersonajeList = Recursos.getRecursos( //
					app.getAtributos().getPersonaje());
			atrib.updatePanelMisDatos(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tableDtaModel = Recursos.asignarRecursos( //
				tableDtaModel, recursoPersonajeList);

		Grid grid = new Grid(3);
		grid.setWidth(new Extent(530));
		grid.setColumnWidth(0, new Extent(37, Extent.PERCENT));
		grid.setColumnWidth(1, new Extent(38, Extent.PERCENT));
		grid.setColumnWidth(2, new Extent(25, Extent.PERCENT));

		Column col;
		Column colInf [] = new Column [4];

		col = new Column();
		col.setInsets(new Insets(5, 0, 5, 0));
		col.setCellSpacing(new Extent(10));
		for (int i = 0; i < colInf.length; i++) {
			colInf[i] = new Column();
			colInf[i].setBorder(new Border( //
					new Extent(0), Color.BLACK, Border.STYLE_SOLID));
			colInf[i].setInsets(new Insets(5, 5, 5, 5));
		}

		Estilo.setFont(lblNombre, GUIStyles.NORMAL, SIZE);
		colInf[0].add(lblNombre);
		col.add(colInf[0]);

		Estilo.setFont(lblCorreo, GUIStyles.NORMAL, SIZE);
		colInf[1].add(lblCorreo);
		col.add(colInf[1]);

		Estilo.setFont(lblAlias, GUIStyles.NORMAL, SIZE);
		colInf[2].add(lblAlias);
		col.add(colInf[2]);

		Estilo.setFont(lblPlanetaCasa, GUIStyles.NORMAL, SIZE);
		colInf[3].add(lblPlanetaCasa);
		col.add(colInf[3]);

		grid.add(col);

		col = new Column();
		col.setInsets(new Insets(5, 0, 10, 0));
		col.setCellSpacing(new Extent(10));
		for (int i = 0; i < colInf.length; i++) {
			colInf[i] = new Column();
			colInf[i].setBorder(new Border( //
					new Extent(0), Color.BLACK, Border.STYLE_SOLID));
			colInf[i].setInsets(new Insets(5, 5, 5, 5));
		}

		Estilo.setFont(lblClase, GUIStyles.NORMAL, SIZE);
		colInf[0].add(lblClase);
		col.add(colInf[0]);

		Estilo.setFont(lblNivel, GUIStyles.NORMAL, SIZE);
		colInf[1].add(lblNivel);
		col.add(colInf[1]);

		Estilo.setFont(lblPuntosEntrenamiento, GUIStyles.NORMAL, SIZE);
		colInf[2].add(lblPuntosEntrenamiento);
		col.add(colInf[2]);

		Estilo.setFont(lblOfertas, GUIStyles.NORMAL, SIZE);
		colInf[3].add(lblOfertas);
		col.add(colInf[3]);

		grid.add(col);

		col = new Column();
		col.setInsets(new Insets(10, 0, 5, 0));
		col.setBorder(new Border(new Extent(1), Color.BLACK, Border.STYLE_SOLID));

		Label lblInventario = new Label("Inventario de Recursos");
		Estilo.setFont(lblInventario, GUIStyles.ITALIC, SIZE);
		col.add(lblInventario);

		grid.add(PanelConstructor.initTable( //
				tableDtaModel, initTableColModel(), false, 8, SIZE2));

		add(grid);

	}

	// --------------------------------------------------------------------------------

	private TableColModel initTableColModel() {

		TableColModel tableColModel = new TableColModel();
		TableColumn tableColumn;

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IRecursoPersonajeDO recurso = //
					(IRecursoPersonajeDO) element;
				try {
					return Recursos.getNombreRecurso(recurso);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "";
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
				IRecursoPersonajeDO recurso = //
					(IRecursoPersonajeDO) element;
				return recurso.getCantidad();
			}
		};
		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Cantidad");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		return tableColModel;
	}


	// --------------------------------------------------------------------------------

	public IPlanetaDO getPlaneta() {
		return planeta;
	}

	public void setPlaneta(IPlanetaDO planeta) {
		this.planeta = planeta;
	}

	public void setLblNombre(Label lblNombre) {
		this.lblNombre = lblNombre;
	}

	public Label getLblNombre() {
		return lblNombre;
	}

	public void setLblCorreo(Label lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	public Label getLblCorreo() {
		return lblCorreo;
	}

	public void setLblAlias(Label lblAlias) {
		this.lblAlias = lblAlias;
	}

	public Label getLblAlias() {
		return lblAlias;
	}

	public Label getLblPlanetaValue() {
		return lblPlanetaCasa;
	}

	public void setLblPlanetaValue(Label lblPlanetaValue) {
		this.lblPlanetaCasa = lblPlanetaValue;
	}

	public void setLblClase(Label lblClase) {
		this.lblClase = lblClase;
	}

	public Label getLblClase() {
		return lblClase;
	}

	public void setLblNivel(Label lblNivel) {
		this.lblNivel = lblNivel;
	}

	public Label getLblNivel() {
		return lblNivel;
	}

	public void setLblPuntosEntrenamiento(Label lblPuntosEntrenamiento) {
		this.lblPuntosEntrenamiento = lblPuntosEntrenamiento;
	}

	public Label getLblPuntosEntrenamiento() {
		return lblPuntosEntrenamiento;
	}

	public void setLblOfertas(Label lblOfertas) {
		this.lblOfertas = lblOfertas;
	}

	public Label getLblOfertas() {
		return lblOfertas;
	}

}