package com.ulasoft.lanterncorpsacademy.paneles;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUsuarioDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.ContentPane;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
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
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.Registro;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelRegistro2 extends Panel {

	protected static final String VERDE = "Verde";
	protected static final String AMARILLO = "Amarillo";
	protected static final String ROJO = "Rojo";
	protected static final String NEGRO = "Negro";
	protected static final String AZUL = "Azul";
	protected static final String INDIGO = "Indigo";
	protected static final String VIOLETA = "Violeta";

	private IUsuarioDO usuario;
	private IPersonajeDO personaje;
	private String optClase;
	private TextField txtAlias;

	Desktop desktop;
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
			.getActive();

	public PanelRegistro2(IUsuarioDO usuarioNuevo, IPersonajeDO personajeNuevo)
			throws Exception {

		usuario = usuarioNuevo;
		personaje = personajeNuevo;

		setInsets(new Insets(100, 0, 100, 0));

		Row rgistroRow = new Row();
		Label lblTitle = new Label("REGISTRO");
		rgistroRow.add(lblTitle);
		rgistroRow.setBackground(Color.WHITE);
		rgistroRow.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));

		// ------------------------------------------------------------------------------

		Row aliasRow = new Row();
		Label lblAlias = new Label("Alias");
		aliasRow.add(lblAlias);
		txtAlias = new TextField();
		txtAlias
				.setToolTipText("Nombre con el que otros jugadores te verán en el universo.");
		txtAlias.setWidth(new Extent(200));
		txtAlias.setText(personaje.getAlias());
		aliasRow.add(txtAlias);
		aliasRow.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));

		// ------------------------------------------------------------------------------

		Button btnBack = new Button("Atras");
		btnBack.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnBackClicked();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// ------------------------------------------------------------------------------

		Button btnSend = new Button("Enviar");
		btnSend.setStyle(Estilo.getStyleColor(app.getAtributos()));
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
		row.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		// row.setAlignment(Alignment.ALIGN_RIGHT);
		row.setBackground(Color.WHITE);

		// ------------------------------------------------------------------------------

		Row row1 = initgroup();
		row.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		row1.setBackground(Color.WHITE);

		// ------------------------------------------------------------------------------

		SplitPane sp = new SplitPane(SplitPane.ORIENTATION_VERTICAL_TOP_BOTTOM,
				new Extent(31));
		sp.add(aliasRow);
		sp.add(row1);

		// ------------------------------------------------------------------------------

		SplitPane sp1 = new SplitPane(
				SplitPane.ORIENTATION_VERTICAL_TOP_BOTTOM, new Extent(53));
		sp1.add(sp);
		sp1.add(new initclases());

		// ------------------------------------------------------------------------------

		ContentPane cp = new ContentPane();
		cp.add(sp1);

		// ------------------------------------------------------------------------------

		SplitPane sp2 = new SplitPane(
				SplitPane.ORIENTATION_VERTICAL_TOP_BOTTOM, new Extent(350));
		sp2.add(cp);
		sp2.add(row);

		// ------------------------------------------------------------------------------

		SplitPane sp3 = new SplitPane(
				SplitPane.ORIENTATION_VERTICAL_TOP_BOTTOM, new Extent(20));
		sp3.add(rgistroRow);
		sp3.add(sp2);

		// ------------------------------------------------------------------------------

		ContentPane cp1 = new ContentPane();
		cp1.add(sp3);
		add(cp1);
		set(PROPERTY_HEIGHT, new Extent(400));
		set(PROPERTY_WIDTH, new Extent(900));
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	private Row initgroup() {

		ButtonGroup btnGroupClases = new ButtonGroup();

		// ------------------------------------------------------------------------------

		RadioButton btnRadioVerde = new RadioButton("Verde");
		btnRadioVerde.setIcon(new ResourceImageReference(
				//
				"com/ulasoft/lanterncorpsacademy/imagenes/greenIcon.png",
				new Extent(20), new Extent(20)));
		btnRadioVerde.setGroup(btnGroupClases);
		btnRadioVerde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = VERDE;
			}
		});

		RadioButton btnRadioAmarillo = new RadioButton("Amarillo");
		btnRadioAmarillo.setIcon(new ResourceImageReference(
				//
				"com/ulasoft/lanterncorpsacademy/imagenes/yellowIcon.png",
				new Extent(20), new Extent(20)));
		btnRadioAmarillo.setGroup(btnGroupClases);
		btnRadioAmarillo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = AMARILLO;

			}
		});

		RadioButton btnRadioNegro = new RadioButton("Negro");
		btnRadioNegro.setIcon(new ResourceImageReference(
				//
				"com/ulasoft/lanterncorpsacademy/imagenes/blackIcon.png",
				new Extent(20), new Extent(20)));
		btnRadioNegro.setGroup(btnGroupClases);
		btnRadioNegro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = NEGRO;

			}
		});

		RadioButton btnRadioRojo = new RadioButton("Rojo");
		btnRadioRojo.setIcon(new ResourceImageReference(
				//
				"com/ulasoft/lanterncorpsacademy/imagenes/redIcon.png",
				new Extent(20), new Extent(20)));
		btnRadioRojo.setGroup(btnGroupClases);
		btnRadioRojo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = ROJO;

			}
		});

		RadioButton btnRadioAzul = new RadioButton("Azul");
		btnRadioAzul.setIcon(new ResourceImageReference(
				//
				"com/ulasoft/lanterncorpsacademy/imagenes/blueIcon.png",
				new Extent(20), new Extent(20)));
		btnRadioAzul.setGroup(btnGroupClases);
		btnRadioAzul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = AZUL;

			}
		});

		RadioButton btnRadioIndigo = new RadioButton("Indigo");
		btnRadioIndigo.setIcon(new ResourceImageReference(
				//
				"com/ulasoft/lanterncorpsacademy/imagenes/indigoIcon.png",
				new Extent(20), new Extent(20)));
		btnRadioIndigo.setGroup(btnGroupClases);
		btnRadioIndigo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = INDIGO;

			}
		});

		RadioButton btnRadioVioleta = new RadioButton("Violeta");
		btnRadioVioleta.setIcon(new ResourceImageReference(
				//
				"com/ulasoft/lanterncorpsacademy/imagenes/violetIcon.png",
				new Extent(20), new Extent(20)));
		btnRadioVioleta.setGroup(btnGroupClases);
		btnRadioVioleta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = VIOLETA;

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
			acc.setIcon(new ResourceImageReference(
					//
					"com/ulasoft/lanterncorpsacademy/imagenes/greenIcon.png",
					new Extent(20), new Extent(20)));
			cp.setLayoutData(acc);

			Column c = new Column();
			Label label1 = new Label(
					"Descripcion: Agrupados en los Green Lantern Corps. Representando voluntad.");
			Label label2 = new Label("Planeta Base: Oa, Sector 0");
			Label label3 = new Label(
					"Habilidad: Golpe de Mazo: el linterna manifiesta un mazo para ocasionar gran daño a sus oponentes.");
			label1.set(PROPERTY_FONT, new Extent(0));
			label2.set(PROPERTY_FONT, new Extent(0));
			label3.set(PROPERTY_FONT, new Extent(0));
			c.add(label1);
			c.add(label2);
			c.add(label3);
			c.setInsets(new Insets(0, 15, 0, 0));

			Label lblImagen = new Label("");
			lblImagen.setIcon(new ResourceImageReference(
					"com/ulasoft/lanterncorpsacademy/imagenes/anilloverde.jpg",
					new Extent(90), new Extent(92)));

			Column c1 = new Column();
			c1.add(lblImagen);

			SplitPane sp = new SplitPane(
					SplitPane.ORIENTATION_HORIZONTAL_LEFT_RIGHT,
					new Extent(110));
			sp.add(c1);
			sp.add(c);

			cp.add(sp);
			cp.setBackground(new Color(0x32, 0xCD, 0x32));
			return cp;
		}

		// ------------------------------------------------------------------------------

		private ContentPane amarillo() {
			ContentPane cp = new ContentPane();
			AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
			acc.setTitle("Amarillo - Sinestro Corps");
			acc.setIcon(new ResourceImageReference(
					//
					"com/ulasoft/lanterncorpsacademy/imagenes/yellowIcon.png",
					new Extent(20), new Extent(20)));
			cp.setLayoutData(acc);

			Column c = new Column();
			Label label1 = new Label(
					"Descripcion: Agrupados en los Sinestro Corps. Representando el miedo.");
			Label label2 = new Label(
					"Qward, Sector -1 (“Universo Antimateria”).");
			Label label3 = new Label(
					"Habilidad: Construcción: el linterna atrapa al oponente impidiéndole atacar y causándole daño continuo.");
			label1.set(PROPERTY_FONT, new Extent(0));
			label2.set(PROPERTY_FONT, new Extent(0));
			label3.set(PROPERTY_FONT, new Extent(0));
			c.add(label1);
			c.add(label2);
			c.add(label3);
			c.setInsets(new Insets(0, 15, 0, 0));

			Label lblImagen = new Label("");
			lblImagen
					.setIcon(new ResourceImageReference(
							"com/ulasoft/lanterncorpsacademy/imagenes/anilloamarillo.jpg",
							new Extent(90), new Extent(92)));

			Column c1 = new Column();
			c1.add(lblImagen);

			SplitPane sp = new SplitPane(
					SplitPane.ORIENTATION_HORIZONTAL_LEFT_RIGHT,
					new Extent(110));
			sp.add(c1);
			sp.add(c);

			cp.add(sp);
			cp.setBackground(new Color(238, 255, 58));
			return cp;

		}

		// ------------------------------------------------------------------------------

		private ContentPane negro() {
			ContentPane cp = new ContentPane();
			AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
			acc.setTitle("Negro - Black Lantern Corps");
			acc.setIcon(new ResourceImageReference(
					//
					"com/ulasoft/lanterncorpsacademy/imagenes/blackIcon.png",
					new Extent(20), new Extent(20)));
			cp.setLayoutData(acc);

			Column c = new Column();
			Label label1 = new Label(
					"Descripcion: Agrupados en los Black Lantern Corps. Representando la Muerte.");
			Label label2 = new Label(
					"Planeta Base:El Mundo Muerto de Ryut, Sector 665.");
			Label label3 = new Label(
					"Habilidad: Robo de Salud: el linterna puede robar puntos de salud a un oponente para aumentar los propios.");
			label1.set(PROPERTY_FOREGROUND, Color.WHITE);
			label2.set(PROPERTY_FOREGROUND, Color.WHITE);
			label3.set(PROPERTY_FOREGROUND, Color.WHITE);
			label1.set(PROPERTY_FONT, new Extent(0));
			label2.set(PROPERTY_FONT, new Extent(0));
			label3.set(PROPERTY_FONT, new Extent(0));
			c.add(label1);
			c.add(label2);
			c.add(label3);
			c.setInsets(new Insets(0, 15, 0, 0));

			Label lblImagen = new Label("");
			lblImagen.setIcon(new ResourceImageReference(
					"com/ulasoft/lanterncorpsacademy/imagenes/anillonegro.jpg",
					new Extent(90), new Extent(92)));

			Column c1 = new Column();
			c1.add(lblImagen);

			SplitPane sp = new SplitPane(
					SplitPane.ORIENTATION_HORIZONTAL_LEFT_RIGHT,
					new Extent(110));
			sp.add(c1);
			sp.add(c);

			cp.add(sp);
			cp.setBackground(new Color(0, 0, 0));
			return cp;
		}

		// ------------------------------------------------------------------------------

		private ContentPane rojo() {
			ContentPane cp = new ContentPane();
			AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
			acc.setIcon(new ResourceImageReference(
					//
					"com/ulasoft/lanterncorpsacademy/imagenes/redIcon.png",
					new Extent(20), new Extent(20)));
			acc.setTitle("Rojo - Red Lantern Corps");
			cp.setLayoutData(acc);

			Column c = new Column();
			Label label1 = new Label(
					"Descripcion: Agrupados en los Red Lantern Corps. Representando la ira.");
			Label label2 = new Label("Planeta Base: Ysmault, Sector 666.");
			Label label3 = new Label(
					"Habilidad: Puño Luminoso: el linterna concentra energía en su puño para infligir un golpe de alto daño.");
			label1.set(PROPERTY_FONT, new Extent(0));
			label2.set(PROPERTY_FONT, new Extent(0));
			label3.set(PROPERTY_FONT, new Extent(0));
			c.add(label1);
			c.add(label2);
			c.add(label3);
			c.setInsets(new Insets(0, 15, 0, 0));

			Label lblImagen = new Label("");
			lblImagen.setIcon(new ResourceImageReference(
					"com/ulasoft/lanterncorpsacademy/imagenes/anillorojo.jpg",
					new Extent(90), new Extent(92)));

			Column c1 = new Column();
			c1.add(lblImagen);

			SplitPane sp = new SplitPane(
					SplitPane.ORIENTATION_HORIZONTAL_LEFT_RIGHT,
					new Extent(110));
			sp.add(c1);
			sp.add(c);

			cp.add(sp);
			cp.setBackground(new Color(255, 0, 0));
			return cp;
		}

		// ------------------------------------------------------------------------------

		private ContentPane azul() {
			ContentPane cp = new ContentPane();
			AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
			acc.setTitle("Azul - Blue Lantern Corps");
			acc.setIcon(new ResourceImageReference(
					//
					"com/ulasoft/lanterncorpsacademy/imagenes/blueIcon.png",
					new Extent(20), new Extent(20)));
			cp.setLayoutData(acc);

			Column c = new Column();
			Label label1 = new Label(
					"Descripcion: Agrupados en los Blue Lantern Corps. Representado la esperanza.");
			Label label2 = new Label("Planeta Base: Odym, Sector 1.");
			Label label3 = new Label(
					"Habilidad: Curación: puede usar el anillo para restaurar sus puntos de salud.");
			label1.set(PROPERTY_FONT, new Extent(0));
			label2.set(PROPERTY_FONT, new Extent(0));
			label3.set(PROPERTY_FONT, new Extent(0));
			c.add(label1);
			c.add(label2);
			c.add(label3);
			c.setInsets(new Insets(0, 15, 0, 0));

			Label lblImagen = new Label("");
			lblImagen.setIcon(new ResourceImageReference(
					"com/ulasoft/lanterncorpsacademy/imagenes/anilloazul.jpg",
					new Extent(90), new Extent(92)));

			Column c1 = new Column();
			c1.add(lblImagen);

			SplitPane sp = new SplitPane(
					SplitPane.ORIENTATION_HORIZONTAL_LEFT_RIGHT,
					new Extent(110));
			sp.add(c1);
			sp.add(c);

			cp.add(sp);
			cp.setBackground(new Color(0, 153, 255));
			return cp;
		}

		// ------------------------------------------------------------------------------

		private ContentPane indigo() {
			ContentPane cp = new ContentPane();
			AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
			acc.setTitle("Indigo - La Tribu Indigo");
			acc.setIcon(new ResourceImageReference(
					//
					"com/ulasoft/lanterncorpsacademy/imagenes/indigoIcon.png",
					new Extent(20), new Extent(20)));
			cp.setLayoutData(acc);

			Column c = new Column();
			Label label1 = new Label(
					"Descripcion:  Agrupados en la Tribu Indigo. Representando la compasión.");
			Label label2 = new Label("Planeta Base: desconocido, Sector 3.");
			Label label3 = new Label(
					"Habilidad:  Evasión de combate: el portador puede escapar de una batalla.");
			label1.set(PROPERTY_FONT, new Extent(0));
			label2.set(PROPERTY_FONT, new Extent(0));
			label3.set(PROPERTY_FONT, new Extent(0));
			c.add(label1);
			c.add(label2);
			c.add(label3);
			c.setInsets(new Insets(0, 15, 0, 0));

			Label lblImagen = new Label("");
			lblImagen
					.setIcon(new ResourceImageReference(
							"com/ulasoft/lanterncorpsacademy/imagenes/anilloindigo.jpg",
							new Extent(90), new Extent(92)));

			Column c1 = new Column();
			c1.add(lblImagen);

			SplitPane sp = new SplitPane(
					SplitPane.ORIENTATION_HORIZONTAL_LEFT_RIGHT,
					new Extent(110));
			sp.add(c1);
			sp.add(c);

			cp.add(sp);
			cp.setBackground(new Color(148, 71, 148));
			return cp;
		}

		// ------------------------------------------------------------------------------

		private ContentPane violeta() {
			ContentPane cp = new ContentPane();
			AccordionPaneLayoutData acc = new AccordionPaneLayoutData();
			acc.setIcon(new ResourceImageReference(
					//
					"com/ulasoft/lanterncorpsacademy/imagenes/violetIcon.png",
					new Extent(20), new Extent(20)));
			acc.setTitle("Violeta - Star Sapphires");
			cp.setLayoutData(acc);
			Column c = new Column();
			Label label1 = new Label(
					"Descripcion: Agrupados en los Star Sapphires. Representando el amor.");
			Label label2 = new Label("Planeta Base: Zamaron, Sector 1412.");
			Label label3 = new Label(
					"Habilidad: Confusión: puede disminuir la efectividad de los ataques del oponente.");
			label1.set(PROPERTY_FONT, new Extent(0));
			label2.set(PROPERTY_FONT, new Extent(0));
			label3.set(PROPERTY_FONT, new Extent(0));
			c.add(label1);
			c.add(label2);
			c.add(label3);
			c.setInsets(new Insets(0, 15, 0, 0));

			Label lblImagen = new Label("");
			lblImagen
					.setIcon(new ResourceImageReference(
							"com/ulasoft/lanterncorpsacademy/imagenes/anillovioleta.jpg",
							new Extent(90), new Extent(92)));

			Column c1 = new Column();
			c1.add(lblImagen);

			SplitPane sp = new SplitPane(
					SplitPane.ORIENTATION_HORIZONTAL_LEFT_RIGHT,
					new Extent(110));
			sp.add(c1);
			sp.add(c);

			cp.add(sp);
			cp.setBackground(new Color(255, 0, 255));
			return cp;
		}

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	protected void btnBackClicked() throws Exception {
		personaje.setAlias(txtAlias.getText());
		PanelRegistro1 pnlregistro1 = new PanelRegistro1(usuario, personaje);
		desktop = app.getDesktop();
		desktop.setPanelCentral(pnlregistro1);
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	protected void btnSendClicked() throws ClassNotFoundException, Exception {

		if ((txtAlias.getText()) == "") {
			Desktop d = app.getDesktop();
			d.setWindowPaneEmergente("Escoge el Alias para tu Personaje!");
			return;
		}

		personaje.setAlias(txtAlias.getText());

		if (Registro.verificarAlias(personaje.getAlias())) {
			Desktop d = app.getDesktop();
			d.setWindowPaneEmergente("Ya existe un jugador con ese Alias.");
			return;
		}

		Registro.guardarUsuario(usuario, personaje, optClase);

		desktop = app.getDesktop();
		desktop
				.setWindowPaneEmergente("Has Completado EL Registro Satisfactoriamente");
		PanelLogin pnlMain = new PanelLogin();
		desktop.setPanelCentral(pnlMain);

	}

}
