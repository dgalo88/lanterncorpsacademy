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

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();
	private Desktop d = app.getDesktop();

	private IUsuarioDO usuario;
	private IPersonajeDO personaje;
	private String optClase;

	public PanelRegistro2(IUsuarioDO usuarioNuevo, IPersonajeDO personajeNuevo) //
			throws Exception {

		usuario = usuarioNuevo;
		personaje = personajeNuevo;

		Row row = new Row();
		row.setAlignment(Alignment.ALIGN_CENTER);

		Row rowBotones = new Row();
		rowBotones.setCellSpacing(new Extent(10));
		rowBotones.setAlignment(Alignment.ALIGN_CENTER);

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 0, 10));
		col.setCellSpacing(new Extent(10));
		col.setBackground(Color.WHITE);

		col.add(initTopRow("Registro de Usuario", 16));
		col.add(initTopRow("Elegir Clase:", 14));

		col.add(clases());

		Button btnAtras = new Button("Atrás");
		btnAtras.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnAtrasClicked();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		rowBotones.add(btnAtras);

		Button btnEnviar = new Button("Enviar");
		btnEnviar.setStyle(Estilo.getStyleColor(app.getAtributos()));
		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					btnEnviarClicked();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		rowBotones.add(btnEnviar);

		col.add(rowBotones);
		row.add(col);
		add(row);
	}

	// --------------------------------------------------------------------------------

	private Row initTopRow(String texto, int size) {

		Row row = new Row();
		row.setCellSpacing(new Extent(10));
		row.setAlignment(Alignment.ALIGN_CENTER);
		Label lblTitle = new Label(texto);
		lblTitle.setForeground(Color.BLACK);
		Estilo.setFont(lblTitle, GUIStyles.BOLD, size);
		row.add(lblTitle);
		return row;

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
		btnRadioVerde.setIcon(new ResourceImageReference( //
				"com/ulasoft/lanterncorpsacademy/imagenes/greenIcon.png", //
				new Extent(20), new Extent(20)));
		btnRadioVerde.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = VERDE;
			}
		});

		String string = "Descripción: Agrupados en los Green Lantern Corps.\n" //
			+ "\nRepresentan: Voluntad.\n" //
			+ "\nPlaneta Base: Oa, Sector 0.\n" //
			+ "\nHabilidad: Golpe de Mazo, el linterna manifiesta " //
			+ "un mazo para ocasionar gran daño a sus oponentes.\n";

		ClassSelectSection classSelectSection = //
			new ClassSelectSection(btnRadioVerde, string);
		classSelectSection.setBackgroundTextArea(GUIStyles.COLORVERDE);
		
		return classSelectSection;
	}

	// ------------------------------------------------------------------------------

	private ClassSelectSection amarillo() {
		
		RadioButton btnRadioAmarillo = new RadioButton("Amarillo - Sinistro Lantern");
		btnRadioAmarillo.setIcon(new ResourceImageReference( //
				"com/ulasoft/lanterncorpsacademy/imagenes/yellowIcon.png", //
				new Extent(20), new Extent(20)));
		btnRadioAmarillo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = AMARILLO;
			}
		});

		String string = "Descripción: Agrupados en los Sinestro Corps.\n" //
			+ "\nRepresentan: El Miedo.\n" //
			+ "\nPlaneta Base: Qward, Sector -1 (“Universo Antimateria”).\n" //
			+ "\nHabilidad: Construcción, el linterna atrapa al oponente " //
			+ "impidiéndole atacar y causándole daño continuo.\n";

		ClassSelectSection classSelectSection = //
			new ClassSelectSection(btnRadioAmarillo, string);
		classSelectSection.setBackgroundTextArea(GUIStyles.COLORAMARILLO);

		return classSelectSection;

	}

	// ------------------------------------------------------------------------------

	private ClassSelectSection negro() {
		
		RadioButton btnRadioNegro = new RadioButton("Negro - Black Lantern");
		btnRadioNegro.setIcon(new ResourceImageReference( //
				"com/ulasoft/lanterncorpsacademy/imagenes/blackIcon.png", //
				new Extent(20), new Extent(20)));
		btnRadioNegro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = NEGRO;
			}
		});

		String string = "Descripción: Agrupados en los Black Lantern Corps.\n" //
			+ "\nRepresentan: La Muerte.\n" //
			+ "\nPlaneta Base: El Mundo Muerto de Ryut, Sector 665.\n" //
			+ "\nHabilidad: Robo de Salud, el linterna puede robar " //
			+ "puntos de salud a un oponente para aumentar los propios.\n";

		ClassSelectSection classSelectSection = //
			new ClassSelectSection(btnRadioNegro, string);
		classSelectSection.setBackgroundTextArea(GUIStyles.COLORNEGRO);

		return classSelectSection;

	}

	// ------------------------------------------------------------------------------

	private ClassSelectSection rojo() {

		RadioButton btnRadioRojo = new RadioButton("Rojo - Red Lantern");
		btnRadioRojo.setIcon(new ResourceImageReference( //
				"com/ulasoft/lanterncorpsacademy/imagenes/redIcon.png", //
				new Extent(20), new Extent(20)));
		btnRadioRojo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = ROJO;
			}
		});

		String string = "Descripción: Agrupados en los Red Lantern Corps.\n" //
			+ "\nRepresentan: La Ira.\n" //
			+ "\nPlaneta Base: Ysmault, Sector 666.\n" //
			+ "\nHabilidad: Puño Luminoso, el linterna concentra energía " //
			+ "en su puño para infligir un golpe de alto daño.\n";

		ClassSelectSection classSelectSection = //
			new ClassSelectSection(btnRadioRojo, string);
		classSelectSection.setBackgroundTextArea(GUIStyles.COLORROJO);

		return classSelectSection;

	}

	// ------------------------------------------------------------------------------

	private ClassSelectSection azul() {

		RadioButton btnRadioAzul = new RadioButton("Azul - Blue Lantern");
		btnRadioAzul.setIcon(new ResourceImageReference( //
				"com/ulasoft/lanterncorpsacademy/imagenes/blueIcon.png", //
				new Extent(20), new Extent(20)));
		btnRadioAzul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = AZUL;
			}
		});

		String string = "Descripción: Agrupados en los Blue Lantern Corps.\n" //
			+ "\nRepresentan: La Esperanza.\n" //
			+ "\nPlaneta Base: Odym, Sector 1.\n" //
			+ "\nHabilidad: Curación, puede usar el anillo " //
			+ "para restaurar sus puntos de salud.\n";

		ClassSelectSection classSelectSection = //
			new ClassSelectSection(btnRadioAzul, string);
		classSelectSection.setBackgroundTextArea(GUIStyles.COLORAZUL);

		return classSelectSection;

	}

	// ------------------------------------------------------------------------------

	private ClassSelectSection indigo() {

		RadioButton btnRadioIndigo = new RadioButton("Indigo - Indigo Lantern");
		btnRadioIndigo.setIcon(new ResourceImageReference( //
				"com/ulasoft/lanterncorpsacademy/imagenes/indigoIcon.png", //
				new Extent(20), new Extent(20)));
		btnRadioIndigo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = INDIGO;
			}
		});

		String string = "Descripción: Agrupados en la Tribu Indigo.\n" //
			+ "\nRepresentan: La Compasión.\n" //
			+ "\nPlaneta Base: desconocido, Sector 3.\n" //
			+ "\nHabilidad: Evasión de combate, " //
			+ "el portador puede escapar de una batalla.\n";

		ClassSelectSection classSelectSection = //
			new ClassSelectSection(btnRadioIndigo, string);
		classSelectSection.setBackgroundTextArea(GUIStyles.COLORINDIGO);

		return classSelectSection;

	}

	// ------------------------------------------------------------------------------

	private ClassSelectSection violeta() {

		RadioButton btnRadioVioleta = new RadioButton("Violeta - Star Sapphire");
		btnRadioVioleta.setIcon(new ResourceImageReference( //
				"com/ulasoft/lanterncorpsacademy/imagenes/violetIcon.png", //
				new Extent(20), new Extent(20)));
		btnRadioVioleta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				optClase = VIOLETA;
			}
		});

		String string = "Descripción: Agrupados en los Star Sapphires.\n" //
			+ "\nRepresentan: El Amor.\n" //
			+ "\nPlaneta Base: Zamaron, Sector 1412.\n" //
			+ "\nHabilidad: Confusión, puede disminuir " //
			+ "la efectividad de los ataques del oponente.\n";

		ClassSelectSection classSelectSection = //
			new ClassSelectSection(btnRadioVioleta, string);
		classSelectSection.setBackgroundTextArea(GUIStyles.COLORVIOLETA);

		return classSelectSection;

	}

	// ------------------------------------------------------------------------------

	protected void btnAtrasClicked() throws Exception {

		PanelRegistro1 pnlregistro1 = new PanelRegistro1(usuario, personaje);
		d.setPanelCentral(pnlregistro1);

	}

	// ------------------------------------------------------------------------------

	protected void btnEnviarClicked() throws ClassNotFoundException, Exception {

		Registro.guardarUsuario(usuario, personaje, optClase);
		d.setWindowPaneEmergente("Has completado el registro satisfactoriamente");
		PanelLogin pnlMain = new PanelLogin();
		d.setPanelCentral(pnlMain);

	}

}
