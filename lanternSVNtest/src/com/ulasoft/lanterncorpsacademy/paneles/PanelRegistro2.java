package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.RadioButton;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.SplitPane;
import nextapp.echo.app.TextField;
import nextapp.echo.app.button.ButtonGroup;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.extras.app.AccordionPane;
import nextapp.echo.extras.app.layout.AccordionPaneLayoutData;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.GUIStyles;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;

//import dao.lca.UsuarioDO;
import dao.lantern.PersonajeDO;
import dao.lantern.UsuarioDO;

import echopoint.layout.HtmlLayoutData;

@SuppressWarnings("serial")
public class PanelRegistro2 extends Panel {
	
	protected static final int VERDE = 0;
	protected static final int AMARILLO = 1;
	protected static final int ROJO = 2;
	protected static final int NEGRO = 3;
	protected static final int AZUL = 4;
	protected static final int INDIGO = 5;
	protected static final int VIOLETA = 6;
		
	protected UsuarioDO usuarioNuevo;
	protected PersonajeDO personajeNuevo;

	public PanelRegistro2(UsuarioDO usuario) {
		
		LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();
		Desktop d = app.getDesktop(); //XXX:JUL: ORGANIZAAAAAAAR
		d.setPanelCentral();
		
		
		Row aliasRow = new Row();
		Label lblAlias = new Label("Alias");
		aliasRow.add(lblAlias);
		TextField txtAlias = new TextField();
		txtAlias.setToolTipText("Nombre con el que otros jugadores te verán en el universo.");
		txtAlias.setWidth(new Extent(200));
		aliasRow.add(txtAlias);
		aliasRow.setStyle(GUIStyles.DEFAULT_STYLE);

		usuarioNuevo = usuario;
		
		Label lblTitle = new Label("REGISTRO");
		Row row2 = new Row();
		row2.add(lblTitle);
		row2.setBackground(Color.WHITE);
		row2.setAlignment(Alignment.ALIGN_CENTER);
		

		// ------------------------------------------------------------------------------

		Button btnBack = new Button("Atras");
		btnBack.setStyle(GUIStyles.STYLE);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnBackClicked();
			}
		});

		// ------------------------------------------------------------------------------

		Button btnSend = new Button("Enviar");
		btnSend.setStyle(GUIStyles.STYLE);
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnSendClicked();
			}
		});

		// ------------------------------------------------------------------------------

		Row row = new Row();
		row.add(btnBack);
		row.add(btnSend);
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_RIGHT);
		row.setBackground(Color.WHITE);

		// ------------------------------------------------------------------------------

		Row row1 = initgroup();
		row1.setBackground(Color.WHITE);

		// ------------------------------------------------------------------------------

		SplitPane sp2 = new SplitPane(
				SplitPane.ORIENTATION_VERTICAL_TOP_BOTTOM, new Extent(15));
		sp2.add(row2);
		sp2.add(row1);

		// ------------------------------------------------------------------------------

		SplitPane sp = new SplitPane(SplitPane.ORIENTATION_VERTICAL_TOP_BOTTOM,
				new Extent(33));
		sp.add(sp2);
		sp.add(new initclases());

		// ------------------------------------------------------------------------------

		ContentPane cp = new ContentPane();
		cp.add(sp);

		// ------------------------------------------------------------------------------

		SplitPane sp1 = new SplitPane(
				SplitPane.ORIENTATION_VERTICAL_TOP_BOTTOM, new Extent(350));
		sp1.add(cp);
		sp1.add(row);

		// ------------------------------------------------------------------------------

		SplitPane sp3 = new SplitPane(SplitPane.ORIENTATION_VERTICAL_TOP_BOTTOM,
				new Extent(25));
		sp3.add(aliasRow);
		sp3.add(sp1);

		ContentPane cp2 = new ContentPane();
		cp2.add(sp3);
		add(cp2);

		
// careful...
//		ContentPane cp2 = new ContentPane();
//		cp2.add(sp1);
//		add(cp2);

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	private Row initgroup() {

		ButtonGroup btnGroupClases = new ButtonGroup();

		// ------------------------------------------------------------------------------

		RadioButton btnRadioVerde = new RadioButton("Verde");
		btnRadioVerde.setIcon(new ResourceImageReference( //
			"com/ulasoft/lanterncorpsacademy/imagenes/greenIcon.png",new Extent(20), new Extent(20)));
		btnRadioVerde.setGroup(btnGroupClases);
		btnRadioVerde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//personajeNuevo.setClaseLinternaRef(claseLinternaRef)
			}
		});

		RadioButton btnRadioAmarillo = new RadioButton("Amarillo");
		btnRadioAmarillo.setIcon(new ResourceImageReference( //
			"com/ulasoft/lanterncorpsacademy/imagenes/yellowIcon.png",new Extent(20), new Extent(20)));
		btnRadioAmarillo.setGroup(btnGroupClases);
		btnRadioAmarillo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		RadioButton btnRadioNegro = new RadioButton("Negro");
		btnRadioNegro.setIcon(new ResourceImageReference( //
			"com/ulasoft/lanterncorpsacademy/imagenes/blackIcon.png",new Extent(20), new Extent(20)));
		btnRadioNegro.setGroup(btnGroupClases);
		btnRadioNegro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		RadioButton btnRadioRojo = new RadioButton("Rojo");
		btnRadioRojo.setIcon(new ResourceImageReference( //
			"com/ulasoft/lanterncorpsacademy/imagenes/redIcon.png",new Extent(20), new Extent(20)));
		btnRadioRojo.setGroup(btnGroupClases);
		btnRadioRojo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		RadioButton btnRadioAzul = new RadioButton("Azul");
		btnRadioAzul.setIcon(new ResourceImageReference( //
			"com/ulasoft/lanterncorpsacademy/imagenes/blueIcon.png",new Extent(20), new Extent(20)));
		btnRadioAzul.setGroup(btnGroupClases);
		btnRadioAzul.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		RadioButton btnRadioIndigo = new RadioButton("Indigo");
		btnRadioIndigo.setIcon(new ResourceImageReference( //
			"com/ulasoft/lanterncorpsacademy/imagenes/indigoIcon.png",new Extent(20), new Extent(20)));
		btnRadioIndigo.setGroup(btnGroupClases);
		btnRadioIndigo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		RadioButton btnRadioVioleta = new RadioButton("Violeta");
		btnRadioVioleta.setIcon(new ResourceImageReference( //
			"com/ulasoft/lanterncorpsacademy/imagenes/violetIcon.png",new Extent(20), new Extent(20)));
		btnRadioVioleta.setGroup(btnGroupClases);
		btnRadioVioleta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		// ------------------------------------------------------------------------------

		Row row = new Row();
		row.add(btnRadioVerde);
		row.add(btnRadioAmarillo);
		row.add(btnRadioNegro);
		row.add(btnRadioRojo);
		row.add(btnRadioAzul);
		row.add(btnRadioIndigo);
		row.add(btnRadioVioleta);
		row.setBorder(new Border(1, Color.BLACK, Border.STYLE_SOLID));
		row.setAlignment(Alignment.ALIGN_CENTER);
		row.setCellSpacing(new Extent(40));

		return row;

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public class initclases extends AccordionPane {

		public initclases() {
			add(verde());
			add(amarillo());
			add(negro());
			add(rojo());
			add(azul());
			add(indigo());
			add(violeta());
		}

		// ------------------------------------------------------------------------------

		private ContentPane verde() {
			ContentPane cp = new ContentPane();
			AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
			acc.setTitle("Verde - Green Lantern Corps");
			acc.setIcon(new ResourceImageReference( //
			"com/ulasoft/lanterncorpsacademy/imagenes/greenIcon.png",new Extent(20), new Extent(20)));
			cp.setLayoutData(acc);
			Column c = new Column();
			c.add(new Label("firstPane label 1"));
			c.add(new Label("firstPane label 2"));
			c.add(new Label("firstPane label 3"));
			cp.add(c);
			cp.setBackground(Color.WHITE);
			return cp;
		}

		// ------------------------------------------------------------------------------

		private ContentPane amarillo() {
			ContentPane cp = new ContentPane();
			AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
			acc.setTitle("Amarillo - Sinestro Corps");
			acc.setIcon(new ResourceImageReference( //
					"com/ulasoft/lanterncorpsacademy/imagenes/yellowIcon.png",new Extent(20), new Extent(20)));
			cp.setLayoutData(acc);
			Column c = new Column();
			c.add(new Label("firstPane label 1"));
			c.add(new Label("firstPane label 2"));
			c.add(new Label("firstPane label 3"));
			cp.add(c);
			cp.setBackground(Color.WHITE);
			return cp;
		}

		// ------------------------------------------------------------------------------

		private ContentPane negro() {
			ContentPane cp = new ContentPane();
			AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
			acc.setTitle("Negro - Black Lantern Corps");
			acc.setIcon(new ResourceImageReference( //
					"com/ulasoft/lanterncorpsacademy/imagenes/blackIcon.png",new Extent(20), new Extent(20)));
			cp.setLayoutData(acc);
			Column c = new Column();
			c.add(new Label("firstPane label 1"));
			c.add(new Label("firstPane label 2"));
			c.add(new Label("firstPane label 3"));
			cp.add(c);
			cp.setBackground(Color.WHITE);
			return cp;
		}

		// ------------------------------------------------------------------------------

		private ContentPane rojo() {
			ContentPane cp = new ContentPane();
			AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
			acc.setIcon(new ResourceImageReference( //
					"com/ulasoft/lanterncorpsacademy/imagenes/redIcon.png",new Extent(20), new Extent(20)));
			acc.setTitle("Rojo - Red Lantern Corps");
			cp.setLayoutData(acc);
			Column c = new Column();
			c.add(new Label("firstPane label 1"));
			c.add(new Label("firstPane label 2"));
			c.add(new Label("firstPane label 3"));
			cp.add(c);
			cp.setBackground(Color.WHITE);
			return cp;
		}

		// ------------------------------------------------------------------------------

		private ContentPane azul() {
			ContentPane cp = new ContentPane();
			AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
			acc.setTitle("Azul - Blue Lantern Corps");
			acc.setIcon(new ResourceImageReference( //
					"com/ulasoft/lanterncorpsacademy/imagenes/blueIcon.png",new Extent(20), new Extent(20)));
			cp.setLayoutData(acc);
			Column c = new Column();
			c.add(new Label("firstPane label 1"));
			c.add(new Label("firstPane label 2"));
			c.add(new Label("firstPane label 3"));
			cp.add(c);
			cp.setBackground(Color.WHITE);
			return cp;
		}

		// ------------------------------------------------------------------------------

		private ContentPane indigo() {
			ContentPane cp = new ContentPane();
			AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
			acc.setTitle("Indigo - La Tribu Indigo");
			acc.setIcon(new ResourceImageReference( //
					"com/ulasoft/lanterncorpsacademy/imagenes/indigoIcon.png",new Extent(20), new Extent(20)));
			cp.setLayoutData(acc);
			Column c = new Column();
			c.add(new Label("firstPane label 1"));
			c.add(new Label("firstPane label 2"));
			c.add(new Label("firstPane label 3"));
			cp.add(c);
			cp.setBackground(Color.WHITE);
			return cp;
		}

		// ------------------------------------------------------------------------------

		private ContentPane violeta() {
			ContentPane cp = new ContentPane();
			AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
			acc.setIcon(new ResourceImageReference( //
					"com/ulasoft/lanterncorpsacademy/imagenes/violetIcon.png",new Extent(20), new Extent(20)));
			acc.setTitle("Violeta - Star Sapphires");
			cp.setLayoutData(acc);
			Column c = new Column();
			c.add(new Label("firstPane label 1"));
			c.add(new Label("firstPane label 2"));
			c.add(new Label("firstPane label 3"));
			cp.add(c);
			cp.setBackground(Color.WHITE);
			return cp;
		}

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	protected void btnBackClicked() {
		removeAll();
		HtmlLayoutData hld = new HtmlLayoutData("main");
		PanelRegistro1 pnlMain = new PanelRegistro1(usuarioNuevo);
		pnlMain.setLayoutData(hld);
		add(pnlMain);
}
	
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	protected void btnSendClicked() {
		// TODO Aqui viene el...
		
		
		
		
	}
	
}
