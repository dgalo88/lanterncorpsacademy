package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.ArrayList;
import java.util.List;

import lcaInterfaceDAO.IPlanetaDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Font;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.Row;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.base.TableSelModel;
import com.minotauro.echo.table.renderer.BaseCellRenderer;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.minotauro.echo.table.renderer.NestedCellRenderer;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.Recursos;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelMisDatos extends Panel {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	private TestTableModel tableDtaModel;
	private ETable table;
	private List<Recursos> recursos = new ArrayList<Recursos>();
	private Recursos recurso;

	private final int SIZE = 12;

	private IPlanetaDO planeta;
	private Label lblNombre;
	private Label lblCorreo;
	private Label lblAlias;
	private Label lblPlanetaValue;
	private Label lblClase;
	private Label lblNivel;
	private Label lblPuntosEntrenamiento;
	private Label lblOfertas;

	// Recursos
	private Label lblPlomo;
	private Label lblHierro;
	private Label lblAcero;
	private Label lblUranio;
	private Label lblTitanio;
	private Label lblCristalo;
	private Label lblAdamantium;
	private Label lblVibratium;

	public PanelMisDatos() {

		Atributos atrib = app.getAtributos();

		lblNombre = new Label("");
		lblCorreo = new Label("");
		lblAlias = new Label("");
		lblPlanetaValue = new Label("PL");
		lblClase = new Label("");
		lblNivel = new Label("");
		lblPuntosEntrenamiento = new Label("00");
		lblOfertas = new Label("00");

		// Recursos
		lblPlomo = new Label("00");
		lblHierro = new Label("00");
		lblAcero = new Label("00");
		lblUranio = new Label("00");
		lblTitanio = new Label("00");
		lblCristalo = new Label("00");
		lblAdamantium = new Label("00");
		lblVibratium = new Label("00");

		try {
			atrib.updatePanelMisDatos(this);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		Row row = new Row();
		Column col;
		Column colInf [] = new Column [4];

		col = new Column();
		col.setInsets(new Insets(5, 0, 5, 0));
		col.setCellSpacing(new Extent(10));
		for (int i = 0; i < colInf.length; i++) {
			colInf[i] = new Column();
			colInf[i].setBorder(new Border( //
					new Extent(1), Color.BLACK, Border.STYLE_SOLID));
			colInf[i].setInsets(new Insets(3, 3, 3, 3));
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

		Estilo.setFont(lblPlanetaValue, GUIStyles.NORMAL, SIZE);
		colInf[3].add(lblPlanetaValue);
		col.add(colInf[3]);

		row.add(col);

		col = new Column();
		col.setInsets(new Insets(5, 0, 10, 0));
		col.setCellSpacing(new Extent(10));
		for (int i = 0; i < colInf.length; i++) {
			colInf[i] = new Column();
			colInf[i].setBorder(new Border( //
					new Extent(1), Color.BLACK, Border.STYLE_SOLID));
			colInf[i].setInsets(new Insets(3, 3, 3, 3));
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

		row.add(col);

		col = new Column();
		col.setInsets(new Insets(10, 0, 5, 0));
		col.setBorder(new Border(new Extent(1), Color.BLACK, Border.STYLE_SOLID));

//		Label lblInventario = new Label("Inventario de Recursos");
//		Estilo.setFont(lblInventario, GUIStyles.ITALIC, SIZE);
//		col.add(lblInventario);
//
//		Estilo.setFont(lblPlomo, GUIStyles.NORMAL, SIZE2);
//		col.add(lblPlomo);
//
//		Estilo.setFont(lblHierro, GUIStyles.NORMAL, SIZE2);
//		col.add(lblHierro);
//
//		Estilo.setFont(lblAcero, GUIStyles.NORMAL, SIZE2);
//		col.add(lblAcero);
//
//		Estilo.setFont(lblUranio, GUIStyles.NORMAL, SIZE2);
//		col.add(lblUranio);
//
//		Estilo.setFont(lblTitanio, GUIStyles.NORMAL, SIZE2);
//		col.add(lblTitanio);
//
//		Estilo.setFont(lblCristalo, GUIStyles.NORMAL, SIZE2);
//		col.add(lblCristalo);
//
//		Estilo.setFont(lblAdamantium, GUIStyles.NORMAL, SIZE2);
//		col.add(lblAdamantium);
//
//		Estilo.setFont(lblVibratium, GUIStyles.NORMAL, SIZE2);
//		col.add(lblVibratium);

		col.add(getTableRecursos());

		row.add(col);
		add(row);

	}

	// --------------------------------------------------------------------------------

	private Column getTableRecursos() {

		Column col = new Column();
		col.setBackground(Color.WHITE);
		col.add(initTopRow());

		try {
			for (int i = 0; i < 8; i++) {
				recurso = new Recursos(i);
				recursos.add(recurso);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ----------------------------------------
		// The table models
		// ----------------------------------------

		TableColModel tableColModel = initTableColModel();
		TableSelModel tableSelModel = new TableSelModel();
		tableDtaModel = new TestTableModel();
		tableDtaModel.setEditable(true);

//		tableDtaModel = Recursos.asignarRecursos(tableDtaModel, recursos);
		tableDtaModel = Recursos.asignarRec(tableDtaModel, recursos);

		// ----------------------------------------
		// The table
		// ----------------------------------------

		table = new ETable();
		table.setTableDtaModel(tableDtaModel);
		table.setTableColModel(tableColModel);
		table.setTableSelModel(tableSelModel);
		table.setEasyview(true);
		table.setFont(new Font(Font.VERDANA, Font.PLAIN, new Extent(10)));
		col.add(table);

		return col;

	}

	// --------------------------------------------------------------------------------

	private Row initTopRow() {

		Row row = new Row();
		row.setStyle(GUIStyles.STYLECENTERROW);
		Label lblTitle = new Label("Inventario de Unidades");
		Estilo.setFont(lblTitle, GUIStyles.BOLD, 11);
		row.add(lblTitle);
		row.setAlignment(new Alignment(Alignment.CENTER, Alignment.CENTER));
		return row;

	}

	// --------------------------------------------------------------------------------

	private TableColModel initTableColModel() {

		TableColModel tableColModel = new TableColModel();
		TableColumn tableColumn;

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				Recursos recurso = (Recursos) element;
				return recurso.getNombre();
			}
		};
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Nombre");
		tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		tableColumn.setDataCellRenderer(new LabelCellRenderer());
		tableColModel.getTableColumnList().add(tableColumn);

		tableColumn = new TableColumn();
		tableColumn.setWidth(new Extent(50));
		tableColumn.setHeadValue("Cantidad");
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

				Label lblCant = new Label("00");
				return lblCant;
			}
		});

		return nestedCellRenderer;
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
		return lblPlanetaValue;
	}

	public void setLblPlanetaValue(Label lblPlanetaValue) {
		this.lblPlanetaValue = lblPlanetaValue;
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

	// Getters y Setters Recursos

	public void setLblPlomo(Label lblPlomo) {
		this.lblPlomo = lblPlomo;
	}

	public Label getLblPlomo() {
		return lblPlomo;
	}

	public void setLblHierro(Label lblHierro) {
		this.lblHierro = lblHierro;
	}

	public Label getLblHierro() {
		return lblHierro;
	}

	public void setLblAcero(Label lblAcero) {
		this.lblAcero = lblAcero;
	}

	public Label getLblAcero() {
		return lblAcero;
	}

	public void setLblUranio(Label lblUranio) {
		this.lblUranio = lblUranio;
	}

	public Label getLblUranio() {
		return lblUranio;
	}

	public void setLblTitanio(Label lblTitanio) {
		this.lblTitanio = lblTitanio;
	}

	public Label getLblTitanio() {
		return lblTitanio;
	}

	public void setLblCristalo(Label lblCristalo) {
		this.lblCristalo = lblCristalo;
	}

	public Label getLblCristalo() {
		return lblCristalo;
	}

	public void setLblAdamantium(Label lblAdamantium) {
		this.lblAdamantium = lblAdamantium;
	}

	public Label getLblAdamantium() {
		return lblAdamantium;
	}

	public void setLblVibratium(Label lblVibratium) {
		this.lblVibratium = lblVibratium;
	}

	public Label getLblVibratium() {
		return lblVibratium;
	}

}