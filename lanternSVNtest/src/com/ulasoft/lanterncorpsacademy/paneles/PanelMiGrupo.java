package com.ulasoft.lanterncorpsacademy.paneles;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.ETableNavigation;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.base.TableSelModel;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.ulasoft.lanterncorpsacademy.GUIStyles;
import com.ulasoft.lanterncorpsacademy.PersonBean;
import com.ulasoft.lanterncorpsacademy.TestTableModel;

import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
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

public class PanelMiGrupo extends Panel {

	private TestTableModel tableDtaModel;
	
	public PanelMiGrupo() {
		Column col = new Column();
		
		Grid grid = new Grid(2);
		grid.setStyle(GUIStyles.DEFAULT_STYLE);
		grid.setWidth(new Extent(500));
		Label lblNombreGrupo = new Label("Nombre del Grupo:");
		//lblCorreo.
	    grid.add(lblNombreGrupo);
	    
	    Label lblNombreGrupoValue = new Label("Green Lantern Corp");
	    grid.add(lblNombreGrupoValue);
		col.add(grid);
		
		col.add(initTable());
		
		Row row = new Row();
		Button btnInvitarNuevoIntegrante = new Button("Invitar Nuevo Integrante");
		btnInvitarNuevoIntegrante.setStyle(GUIStyles.DEFAULT_STYLE);
		btnInvitarNuevoIntegrante.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	    	  btnInvitarNuevoIntegranteClicked();
	      }
	    });
	    row.add(btnInvitarNuevoIntegrante);
	    
	    Button btnAbandonarGrupo = new Button("Abandonar Grupo");
	    btnAbandonarGrupo.setStyle(GUIStyles.DEFAULT_STYLE);
	    btnAbandonarGrupo.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	    	  btnAbandonarGrupoClicked();
	      }
	    });
	    
	    row.add(btnAbandonarGrupo);
	    
	    Button btnMensaje = new Button("Mensaje");
	    btnMensaje.setStyle(GUIStyles.DEFAULT_STYLE);
	    btnMensaje.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	    	  btnMensajeClicked();
	      }
	    });
	    
	    row.add(btnMensaje);
	    col.add(row);
		add(col);
		}

		protected void btnMensajeClicked() {

		
	}

		protected void btnAbandonarGrupoClicked() {
		
	}

		protected void btnInvitarNuevoIntegranteClicked() {
		
	}

		private Component initTable() {
			setInsets(new Insets(2, 2, 2, 2));

		    Column col = new Column();
		    //col.setCellSpacing(new Extent(1));
		    col.setBackground(Color.WHITE);

		    col.add(initTopRow());

		    // ----------------------------------------
		    // The table models
		    // ----------------------------------------

		    TableColModel tableColModel = initTableColModel();
		    TableSelModel tableSelModel = new TableSelModel();

		    tableDtaModel = new TestTableModel();
		    tableDtaModel.setEditable(true);
		    tableDtaModel.setPageSize(3);

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
		        PersonBean personaBean = (PersonBean) element;
		        return personaBean.getFrstName();
		      }
		    };
		    
		    
		    
		    tableColumn.setWidth(new Extent(50));
		    tableColumn.setHeadValue("Posicion");
		    tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		    tableColumn.setDataCellRenderer(new LabelCellRenderer());
		    tableColModel.getTableColumnList().add(tableColumn);
		    
		    tableColumn.setWidth(new Extent(50));
		    tableColumn.setHeadValue("Nombre");
		    tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		    tableColumn.setDataCellRenderer(new LabelCellRenderer());
		    tableColModel.getTableColumnList().add(tableColumn);

		    tableColumn = new TableColumn() {
		      @Override
		      public Object getValue(ETable table, Object element) {
		        PersonBean personaBean = (PersonBean) element;
		        return personaBean.getLastName();
		      }
		    };
		    tableColumn.setWidth(new Extent(50));
		    tableColumn.setHeadValue("Nivel");
		    tableColumn.setHeadCellRenderer(new LabelCellRenderer());
		    tableColumn.setDataCellRenderer(new LabelCellRenderer());
		    tableColModel.getTableColumnList().add(tableColumn);

		    return tableColModel;
		  }
}
