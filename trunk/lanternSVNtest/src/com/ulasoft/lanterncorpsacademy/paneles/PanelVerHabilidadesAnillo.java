package com.ulasoft.lanterncorpsacademy.paneles;

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
import nextapp.echo.app.RadioButton;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

public class PanelVerHabilidadesAnillo extends Panel{

	private TestTableModel tableDtaModel;
	
	public PanelVerHabilidadesAnillo() {
		Column col = new Column();
		
		Label lblTitle = new Label("Habilidades que Posee");
		lblTitle.setBackground(Color.WHITE);
		//lblCorreo.
	    col.add(lblTitle);
		
		col.add(initTable());
		
		Row row = new Row();
		Button btnSalir = new Button("Adquirir Nueva Habilidad");
	    btnSalir.setStyle(GUIStyles.DEFAULT_STYLE);
	    btnSalir.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	    	  btnSalirClicked();
	      }
	    });
	    row.add(btnSalir);
	    
	    Button btnCrearGrupo = new Button("Entrenar Habilidad");
	    btnCrearGrupo.setStyle(GUIStyles.DEFAULT_STYLE);
	    btnCrearGrupo.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	    	  btnCrearGrupoClicked();
	      }
	    });
	    
	    row.add(btnCrearGrupo);
	    col.add(row);
		add(col);
		}

		protected void btnCrearGrupoClicked() {

			
		}

		protected void btnSalirClicked() {
					
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
		    
		    tableColumn = new TableColumn();

		    tableColumn = new TableColumn() {
		      @Override
		      public Object getValue(ETable table, Object element) {
		        PersonBean personaBean = (PersonBean) element;
		        return personaBean.getFrstName();
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
		        PersonBean personaBean = (PersonBean) element;
		        return personaBean.getLastName();
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
			        PersonBean personaBean = (PersonBean) element;
			        return personaBean.getLastName();
			      }
			    };
		    
		    tableColumn.setWidth(new Extent(50));
		    tableColumn.setHeadValue("Caracteristica");
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
		    tableColumn.setHeadValue("Costo de Entrenar");
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
		          final ETable table, final Object value, final int col, final int row) {

		        boolean editable = ((TestTableModel) table.getTableDtaModel()).getEditable();

		        CheckBox ret = new CheckBox();
		        ret.setStyle(GUIStyles.DEFAULT_STYLE);
		        ret.setEnabled(editable);
		        ret.setToolTipText("Seleccion");

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
		    
		  }
		
}