package com.ulasoft.lanterncorpsacademy.paneles;

import java.util.List;

import lcaInterfaceDAO.IPersonajeDO;
import nextapp.echo.app.Alignment;
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
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.minotauro.echo.table.base.ETable;
import com.minotauro.echo.table.base.ETableNavigation;
import com.minotauro.echo.table.base.TableColModel;
import com.minotauro.echo.table.base.TableColumn;
import com.minotauro.echo.table.base.TableSelModel;
import com.minotauro.echo.table.renderer.LabelCellRenderer;
import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.GUIStyles;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.TestTableModel;
import com.ulasoft.lanterncorpsacademy.logic.Atributos;
import com.ulasoft.lanterncorpsacademy.logic.CrearGrupo;
import com.ulasoft.lanterncorpsacademy.logic.MiGrupo;

@SuppressWarnings("serial")
public class PanelMiGrupo extends Panel {

	private TestTableModel tableDtaModel;
	List<IPersonajeDO> personajes;
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
	
	public PanelMiGrupo() {
		Column col = new Column();
		int flg = 0;
		Grid grid = new Grid(2);
		grid.setStyle(GUIStyles.DEFAULT_STYLE);
		grid.setWidth(new Extent(500));
		Label lblNombreGrupo = new Label("Nombre del Grupo:");
		//lblCorreo.
	    grid.add(lblNombreGrupo);
	    
	    Label lblNombreGrupoValue = new Label();
		try {
			lblNombreGrupoValue = new Label(CrearGrupo.obtenerNombreGrupo(app.getAtributos().getPersonaje()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(lblNombreGrupoValue.getText().equals("")){
			flg =1;
			lblNombreGrupoValue.setText("Ninguno");
		}
		
	    grid.add(lblNombreGrupoValue);
		col.add(grid);
		
		col.add(initTable());
		
		Row row = new Row();
		Button btnInvitarNuevoIntegrante = new Button("Invitar Nuevo Integrante");
		btnInvitarNuevoIntegrante.setStyle(GUIStyles.STYLE2);
		btnInvitarNuevoIntegrante.setWidth(new Extent(200));
		btnInvitarNuevoIntegrante.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	    	  btnInvitarNuevoIntegranteClicked();
	      }
	    });
			    
	    Button btnAbandonarGrupo = new Button("Abandonar Grupo");
	    btnAbandonarGrupo.setStyle(GUIStyles.STYLE2);
	    btnAbandonarGrupo.setWidth(new Extent(200));
	    btnAbandonarGrupo.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	    	  btnAbandonarGrupoClicked();
	      }
	    });
	    
	    
	    Button btnMensaje = new Button("Mensaje");
	    btnMensaje.setStyle(GUIStyles.STYLE2);
	    btnMensaje.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	    	  btnMensajeClicked();
	      }
	    });
	    
	    if(flg == 1){
	    	btnInvitarNuevoIntegrante.setEnabled(false);
	    	btnAbandonarGrupo.setEnabled(false);
	    	btnMensaje.setEnabled(false);
		}
	    
	    row.add(btnInvitarNuevoIntegrante);
	    row.add(btnAbandonarGrupo);
	    row.add(btnMensaje);
	    row.setAlignment(Alignment.ALIGN_CENTER);
	    col.add(row);
		add(col);
		}
	
	Desktop d = app.getDesktop();

		protected void btnMensajeClicked() {
			PanelMensaje pnlMain = new PanelMensaje();
			d.setPanelCentral(pnlMain);
		
	}

		protected void btnAbandonarGrupoClicked() {
			// TODO Auto-generated method stub
			
	}

		protected void btnInvitarNuevoIntegranteClicked() {
			// TODO Auto-generated method stub
			
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
		    tableDtaModel.setPageSize(10);
		    
		    Atributos atrr = app.getAtributos();
			try {
				personajes = MiGrupo.obtenerPersonClase(atrr.getPersonaje());
			} catch (Exception e) {
				e.printStackTrace();
			}
			tableDtaModel = MiGrupo.asignarPersonaje(tableDtaModel, personajes);
		    
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

		    return tableColModel;
		  }
}
