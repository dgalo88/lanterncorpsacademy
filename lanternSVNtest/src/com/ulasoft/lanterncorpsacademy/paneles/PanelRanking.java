package com.ulasoft.lanterncorpsacademy.paneles;

import java.sql.SQLException;
import java.util.List;

import lcaInterfaceDAO.IPersonajeDAO;
import lcaInterfaceDAO.IPersonajeDO;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.ETableNavigation;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.base.TableSelModel;
import com.minotauro.echo.table.renderer.BaseCellRenderer;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.minotauro.echo.table.renderer.NestedCellRenderer;
import com.ulasoft.lanterncorpsacademy.GUIStyles;
import com.ulasoft.lanterncorpsacademy.PersonBean;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Ranking;

import dao.api.DataObject;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.RadioButton;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;


@SuppressWarnings("serial")
public class PanelRanking extends Panel {
	
	private TestTableModel tableDtaModel;
	List<IPersonajeDO> personajes;
	int pos=0;

	public PanelRanking() {
		
		setInsets(new Insets(2, 2, 2, 2));
	    Column col = new Column();
	    col.setCellSpacing(new Extent(1));
	    col.setBackground(Color.WHITE);
	    add(col);
	    col.add(initTopRow());
	    try {
			personajes = Ranking.obtenerRanking();
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
	    tableDtaModel.setPageSize(10);
	    
	    tableDtaModel=Ranking.asignarRanking(tableDtaModel, personajes);
	    // ----------------------------------------
	    // The table
	    // ----------------------------------------

	    ETable table = new ETable();
	    table.setTableDtaModel(tableDtaModel);
	    table.setTableColModel(tableColModel);
	    table.setTableSelModel(tableSelModel);
	    table.setEasyview(true);
	    table.setBorder(new Border(1, Color.BLACK, Border.STYLE_SOLID));
	    table.setInsets(new Insets(5, 2, 5, 2));
	    col.add(table);

	    // ----------------------------------------
	    // The navigation control
	    // ----------------------------------------

	    ETableNavigation tableNavigation = new ETableNavigation(tableDtaModel);
	    col.add(tableNavigation);
	  }

	// --------------------------------------------------------------------------------

	  private Row initTopRow() {
	    Row row = new Row();
	    row.setStyle(GUIStyles.STYLE3);
	    //row.setCellSpacing(new Extent(5));
	    row.add(new Label("Lista de Mejores Jugadores"));
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

		tableColumn = new TableColumn() {
			@Override
			public Object getValue(ETable table, Object element) {
				IPersonajeDO personaje = (IPersonajeDO) element;
				return Ranking.determinarClase((personaje.getClaseLinternaRef()).getRefIdent());
			}
		};
	    
	    tableColumn.setWidth(new Extent(50));
	    tableColumn.setHeadValue("Clase");
	    tableColumn.setHeadCellRenderer(new LabelCellRenderer());
	    tableColumn.setDataCellRenderer(new LabelCellRenderer());
	    tableColModel.getTableColumnList().add(tableColumn);

	    return tableColModel;
	  }

}
