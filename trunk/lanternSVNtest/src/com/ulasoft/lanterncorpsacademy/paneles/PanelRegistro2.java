package com.ulasoft.lanterncorpsacademy.paneles;

import lcaInterfaceDAO.IPersonajeDO;
import lcaInterfaceDAO.IUsuarioDO;
import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.RadioButton;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.Desktop;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.logic.Registro;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;
import com.valkirye.lanterncorpsacademy.extras.ClassSelect;
import com.valkirye.lanterncorpsacademy.extras.ClassSelectSection;

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

	private Desktop desktop;
	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	public PanelRegistro2(IUsuarioDO usuarioNuevo, IPersonajeDO personajeNuevo)
			throws Exception {

		usuario = usuarioNuevo;
		personaje = personajeNuevo;

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
		row.setStyle(GUIStyles.STYLECENTERROW);

		Column col = new Column();
		col.setStyle(GUIStyles.STYLECENTERROW);

		Column colTitle = new Column();
		colTitle.setInsets(new Insets(5, 5, 5, 15));
		colTitle.setCellSpacing(new Extent(20));
		colTitle.setBackground(Color.WHITE);
		colTitle.setStyle(GUIStyles.STYLECENTERROW);

		Label lblTitle = new Label("REGISTRO DE USUARIO");
		lblTitle.setTextAlignment(Alignment.ALIGN_CENTER);
		colTitle.add(lblTitle);

		Label lblSubTitle = new Label("Elegir Clase:");
		lblSubTitle.setTextAlignment(Alignment.ALIGN_CENTER);
		colTitle.add(lblSubTitle);
		
		col.add(colTitle);
		col.add(clases());

		Row rowFeet = new Row();
		rowFeet.add(btnBack);
		rowFeet.add(btnSend);
		rowFeet.setCellSpacing(new Extent(10));
		rowFeet.setAlignment(Alignment.ALIGN_CENTER);
		rowFeet.setBackground(Color.WHITE);
		col.add(rowFeet);

		row.add(col);
		add(row);

	}

	// ------------------------------------------------------------------------------

	private ClassSelect clases(){

		ClassSelect clase = new ClassSelect();

		clase.addSection(verde());
		clase.addSection(amarillo());
		clase.addSection(negro());
		clase.addSection(rojo());
		clase.addSection(azul());
		clase.addSection(indigo());
		clase.addSection(violeta());

		return clase;

	}

	// ------------------------------------------------------------------------------

	private ClassSelectSection verde() {

		RadioButton btnRadioVerde = new RadioButton("Verde - Green Lantern");
		btnRadioVerde.setIcon(new ResourceImageReference(
				"com/ulasoft/lanterncorpsacademy/imagenes/greenIcon.png",
				new Extent(20), new Extent(20)));
		btnRadioVerde.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = VERDE;
			}
		});

		String string = "Descripcion: Agrupados en los Green Lantern Corps.\n" +
			"\nRepresentan: Voluntad.\n"+
			"\nPlaneta Base: Oa, Sector 0.\n"+
			"\nHabilidad: Golpe de Mazo, el linterna manifiesta un mazo para ocasionar gran daño a sus oponentes.\n";

		ClassSelectSection classSelectSection = new ClassSelectSection(btnRadioVerde, string);
		classSelectSection.setBackgroundTextArea(GUIStyles.COLORVERDE);
		
		return classSelectSection;
	}

	// ------------------------------------------------------------------------------

	private ClassSelectSection amarillo() {
		
		RadioButton btnRadioAmarillo = new RadioButton("Amarillo - Sinistro Lantern");
		btnRadioAmarillo.setIcon(new ResourceImageReference(
				"com/ulasoft/lanterncorpsacademy/imagenes/yellowIcon.png",
				new Extent(20), new Extent(20)));
		btnRadioAmarillo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = AMARILLO;
			}
		});

		String string = "Descripcion: Agrupados en los Sinestro Corps.\n" +
			"\nRepresentan: El Miedo.\n" +
			"\nPlaneta Base: Qward, Sector -1 (“Universo Antimateria”).\n" +
			"\nHabilidad: Construcción, el linterna atrapa al oponente impidiéndole atacar y causándole daño continuo.\n";

		ClassSelectSection classSelectSection = new ClassSelectSection(btnRadioAmarillo, string);
		classSelectSection.setBackgroundTextArea(GUIStyles.COLORAMARILLO);

		return classSelectSection;

	}

	// ------------------------------------------------------------------------------

	private ClassSelectSection negro() {
		
		RadioButton btnRadioNegro = new RadioButton("Negro - Black Lantern");
		btnRadioNegro.setIcon(new ResourceImageReference(
				"com/ulasoft/lanterncorpsacademy/imagenes/blackIcon.png",
				new Extent(20), new Extent(20)));
		btnRadioNegro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = NEGRO;
			}
		});

		String string = "Descripcion: Agrupados en los Black Lantern Corps.\n" +
			"\nRepresentan: La Muerte.\n" +
			"\nPlaneta Base: El Mundo Muerto de Ryut, Sector 665.\n" +
			"\nHabilidad: Robo de Salud, el linterna puede robar puntos de salud a un oponente para aumentar los propios.\n";

		ClassSelectSection classSelectSection = new ClassSelectSection(btnRadioNegro, string);
		classSelectSection.setBackgroundTextArea(GUIStyles.COLORNEGRO);

		return classSelectSection;

	}

	// ------------------------------------------------------------------------------

	private ClassSelectSection rojo() {

		RadioButton btnRadioRojo = new RadioButton("Rojo - Red Lantern");
		btnRadioRojo.setIcon(new ResourceImageReference(
				"com/ulasoft/lanterncorpsacademy/imagenes/redIcon.png",
				new Extent(20), new Extent(20)));
		btnRadioRojo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = ROJO;
			}
		});

		String string = "Descripcion: Agrupados en los Red Lantern Corps.\n" +
			"\nRepresentan: La Ira.\n" +
			"\nPlaneta Base: Ysmault, Sector 666.\n" +
			"\nHabilidad: Puño Luminoso, el linterna concentra energía en su puño para infligir un golpe de alto daño.\n";

		ClassSelectSection classSelectSection = new ClassSelectSection(btnRadioRojo, string);
		classSelectSection.setBackgroundTextArea(GUIStyles.COLORROJO);

		return classSelectSection;

	}

	// ------------------------------------------------------------------------------

	private ClassSelectSection azul() {

		RadioButton btnRadioAzul = new RadioButton("Azul - Blue Lantern");
		btnRadioAzul.setIcon(new ResourceImageReference(
				"com/ulasoft/lanterncorpsacademy/imagenes/blueIcon.png",
				new Extent(20), new Extent(20)));
		btnRadioAzul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = AZUL;
			}
		});

		String string = "Descripcion: Agrupados en los Blue Lantern Corps.\n" +
			"\nRepresentan: La Esperanza.\n" +
			"\nPlaneta Base: Odym, Sector 1.\n" +
			"\nHabilidad: Curación, puede usar el anillo para restaurar sus puntos de salud.\n";

		ClassSelectSection classSelectSection = new ClassSelectSection(btnRadioAzul, string);
		classSelectSection.setBackgroundTextArea(GUIStyles.COLORAZUL);

		return classSelectSection;

	}

	// ------------------------------------------------------------------------------

	private ClassSelectSection indigo() {

		RadioButton btnRadioIndigo = new RadioButton("Indigo - Indigo Lantern");
		btnRadioIndigo.setIcon(new ResourceImageReference(
				"com/ulasoft/lanterncorpsacademy/imagenes/indigoIcon.png",
				new Extent(20), new Extent(20)));
		btnRadioIndigo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = INDIGO;
			}
		});

		String string = "Descripcion: Agrupados en la Tribu Indigo.\n" +
			"\nRepresentan: La Compasión.\n" +
			"\nPlaneta Base: desconocido, Sector 3.\n" +
			"\nHabilidad: Evasión de combate, el portador puede escapar de una batalla.\n";

		ClassSelectSection classSelectSection = new ClassSelectSection(btnRadioIndigo, string);
		classSelectSection.setBackgroundTextArea(GUIStyles.COLORINDIGO);

		return classSelectSection;

	}

	// ------------------------------------------------------------------------------

	private ClassSelectSection violeta() {

		RadioButton btnRadioVioleta = new RadioButton("Violeta - Star Sapphire");
		btnRadioVioleta.setIcon(new ResourceImageReference(
				"com/ulasoft/lanterncorpsacademy/imagenes/violetIcon.png",
				new Extent(20), new Extent(20)));
		btnRadioVioleta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = VIOLETA;
			}
		});

		String string = "Descripcion: Agrupados en los Star Sapphires.\n" +
			"\nRepresentan: El Amor.\n" +
			"\nPlaneta Base: Zamaron, Sector 1412.\n" +
			"\nHabilidad: Confusión, puede disminuir la efectividad de los ataques del oponente.\n";

		ClassSelectSection classSelectSection = new ClassSelectSection(btnRadioVioleta, string);
		classSelectSection.setBackgroundTextArea(GUIStyles.COLORVIOLETA);

		return classSelectSection;

	}

	// ------------------------------------------------------------------------------

	protected void btnBackClicked() throws Exception {
		PanelRegistro1 pnlregistro1 = new PanelRegistro1(usuario, personaje);
		desktop = app.getDesktop();
		desktop.setPanelCentral(pnlregistro1);
	}

	// ------------------------------------------------------------------------------

	protected void btnSendClicked() throws ClassNotFoundException, Exception {

		Registro.guardarUsuario(usuario, personaje, optClase);

		desktop = app.getDesktop();
		desktop.setWindowPaneEmergente("Has Completado el Registro Satisfactoriamente");
		PanelLogin pnlMain = new PanelLogin();
		desktop.setPanelCentral(pnlMain);

	}

}
