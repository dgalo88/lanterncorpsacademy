package com.ulasoft.lanterncorpsacademy.paneles;

import java.sql.SQLException;

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
import dao.api.FactoryDAO;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.lantern.ClaseLinternaDO;
import dao.lantern.PersonajeDAO;
import dao.lantern.PersonajeDO;
import dao.lantern.UsuarioDAO;
import dao.lantern.UsuarioDO;

import echopoint.layout.HtmlLayoutData;

@SuppressWarnings("serial")
public class PanelRegistro2 extends Panel {
	
	protected static final String VERDE = "Verde";
	protected static final String AMARILLO = "Amarillo";
	protected static final String ROJO = "Rojo";
	protected static final String NEGRO = "Negro";
	protected static final String AZUL = "Azul";
	protected static final String INDIGO = "Indigo";
	protected static final String VIOLETA = "Violeta";
		
	protected UsuarioDO usuarioNuevo;
	public PersonajeDO personajeNuevo;
	private ClaseLinternaDO claseSelect;
	private String optClase;
	private TextField txtAlias;
	
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp.getActive();

	public PanelRegistro2(PersonajeDO personaje) {
		
			
		personajeNuevo=personaje;
		
		
		Row aliasRow = new Row();
		Label lblAlias = new Label("Alias");
		aliasRow.add(lblAlias);
		txtAlias = new TextField();
		txtAlias.setToolTipText("Nombre con el que otros jugadores te verán en el universo.");
		txtAlias.setWidth(new Extent(200));
		txtAlias.setText(personajeNuevo.getAlias());
		aliasRow.add(txtAlias);
		aliasRow.setStyle(GUIStyles.DEFAULT_STYLE);

				
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
				try {
					btnSendClicked();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
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
				optClase=VERDE;
			}
		});

		RadioButton btnRadioAmarillo = new RadioButton("Amarillo");
		btnRadioAmarillo.setIcon(new ResourceImageReference( //
			"com/ulasoft/lanterncorpsacademy/imagenes/yellowIcon.png",new Extent(20), new Extent(20)));
		btnRadioAmarillo.setGroup(btnGroupClases);
		btnRadioAmarillo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase=AMARILLO;
				
			}
		});

		RadioButton btnRadioNegro = new RadioButton("Negro");
		btnRadioNegro.setIcon(new ResourceImageReference( //
			"com/ulasoft/lanterncorpsacademy/imagenes/blackIcon.png",new Extent(20), new Extent(20)));
		btnRadioNegro.setGroup(btnGroupClases);
		btnRadioNegro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase=NEGRO;
				
			}
		});

		RadioButton btnRadioRojo = new RadioButton("Rojo");
		btnRadioRojo.setIcon(new ResourceImageReference( //
			"com/ulasoft/lanterncorpsacademy/imagenes/redIcon.png",new Extent(20), new Extent(20)));
		btnRadioRojo.setGroup(btnGroupClases);
		btnRadioRojo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase=ROJO;
				
			}
		});

		RadioButton btnRadioAzul = new RadioButton("Azul");
		btnRadioAzul.setIcon(new ResourceImageReference( //
			"com/ulasoft/lanterncorpsacademy/imagenes/blueIcon.png",new Extent(20), new Extent(20)));
		btnRadioAzul.setGroup(btnGroupClases);
		btnRadioAzul.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase=AZUL;
				
			}
		});

		RadioButton btnRadioIndigo = new RadioButton("Indigo");
		btnRadioIndigo.setIcon(new ResourceImageReference( //
			"com/ulasoft/lanterncorpsacademy/imagenes/indigoIcon.png",new Extent(20), new Extent(20)));
		btnRadioIndigo.setGroup(btnGroupClases);
		btnRadioIndigo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase=INDIGO;
				
			}
		});

		RadioButton btnRadioVioleta = new RadioButton("Violeta");
		btnRadioVioleta.setIcon(new ResourceImageReference( //
			"com/ulasoft/lanterncorpsacademy/imagenes/violetIcon.png",new Extent(20), new Extent(20)));
		btnRadioVioleta.setGroup(btnGroupClases);
		btnRadioVioleta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase=VIOLETA;
				
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
		// removeAll();
		// HtmlLayoutData hld = new HtmlLayoutData("main");
		// pnlMain.setLayoutData(hld);
		// add(pnlMain);
		PanelRegistro pr = (PanelRegistro) getParent();
		personajeNuevo.setAlias(txtAlias.getText());
		pr.setPersonaje(personajeNuevo);

		PanelRegistro1 pnlMain = new PanelRegistro1(pr.getUsuario());
		// pnlMain.set(PROPERTY_HEIGHT, new Extent(400));
		// pnlMain.set(PROPERTY_WIDTH, new Extent(900));
		pr.changePanel(pnlMain);

	}
	
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	protected void btnSendClicked() throws ClassNotFoundException, Exception {
		// TODO Aqui viene el...
		
		if ((txtAlias.getText())=="") {
			Desktop d = app.getDesktop();
			d.setWindowPaneEmergente("Escoge el Alias para tu Personaje!");
			return;
		}
		
		ConnectionBean connectionBean = ConnectionFactory.getConnectionBean();

		PersonajeDAO usuarioDAO = //
		(PersonajeDAO) FactoryDAO.getDAO(PersonajeDAO.class, connectionBean);
		personajeNuevo.setAlias(txtAlias.getText());

		try {

			if (usuarioDAO.checkIfAliasExists(personajeNuevo.getAlias())) {
				Desktop d = app.getDesktop();
				d.setWindowPaneEmergente("Ya existe un jugador con ese Alias.");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		PanelRegistro pr = (PanelRegistro) getParent();
		pr.setPersonaje(personajeNuevo);
		pr.Registrar(optClase);
		
	}
	
}
