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
import com.ulasoft.lanterncorpsacademy.extras.ClassSelect;
import com.ulasoft.lanterncorpsacademy.extras.ClassSelectSection;
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

	Desktop desktop;
	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
			.getActive();

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

		Column cp = new Column();

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

		Label label1 = new Label(
				"Descripcion:");
		Label label2 = new Label(
				"Agrupados en los Green Lantern Corps. Representando voluntad.");
		Label label3 = new Label("Planeta Base: Oa, Sector 0.");
		Label label4 = new Label(
				"Habilidad: Golpe de Mazo, el linterna manifiesta un mazo para ocasionar gran daño a sus oponentes.");

		label1.set(PROPERTY_FONT, new Extent(0));
		label2.set(PROPERTY_FONT, new Extent(0));
		label3.set(PROPERTY_FONT, new Extent(0));
		label4.set(PROPERTY_FONT, new Extent(0));

		cp.add(label1);
		cp.add(label2);
		cp.add(label3);
		cp.add(label4);
		cp.setBackground(new Color(0x32, 0xCD, 0x32));

		ClassSelectSection classSelectSection = new ClassSelectSection(btnRadioVerde, cp);

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

		Column cp = new Column();

		Label label1 = new Label(
				"Descripcion:");
		Label label2 = new Label(
				"Agrupados en los Sinestro Corps. Representando el miedo.");
		Label label3 = new Label("Planeta Base: Qward, Sector -1 (“Universo Antimateria”).");
		Label label4 = new Label(
				"Habilidad: Construcción, el linterna atrapa al oponente impidiéndole atacar y causándole daño continuo.");

		label1.set(PROPERTY_FONT, new Extent(0));
		label2.set(PROPERTY_FONT, new Extent(0));
		label3.set(PROPERTY_FONT, new Extent(0));
		label4.set(PROPERTY_FONT, new Extent(0));

		cp.add(label1);
		cp.add(label2);
		cp.add(label3);
		cp.add(label4);
		cp.setBackground(new Color(238, 255, 58));

		ClassSelectSection classSelectSection = new ClassSelectSection(btnRadioAmarillo, cp);

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

		Column cp = new Column();

		Label label1 = new Label(
				"Descripcion:");
		Label label2 = new Label(
				"Agrupados en los Black Lantern Corps. Representando la Muerte.");
		Label label3 = new Label("El Mundo Muerto de Ryut, Sector 665.");
		Label label4 = new Label(
				"Habilidad: Robo de Salud, el linterna puede robar puntos de salud a un oponente para aumentar los propios.");

		label1.set(PROPERTY_FONT, new Extent(0));
		label2.set(PROPERTY_FONT, new Extent(0));
		label3.set(PROPERTY_FONT, new Extent(0));
		label4.set(PROPERTY_FONT, new Extent(0));

		cp.add(label1);
		cp.add(label2);
		cp.add(label3);
		cp.add(label4);
		cp.setBackground(new Color(0, 0, 0));
		cp.setForeground(new Color (255, 255, 255));

		ClassSelectSection classSelectSection = new ClassSelectSection(btnRadioNegro, cp);

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

		Column cp = new Column();

		Label label1 = new Label(
				"Descripcion:");
		Label label2 = new Label(
				"Agrupados en los Red Lantern Corps. Representando la ira.");
		Label label3 = new Label("Planeta Base: Ysmault, Sector 666.");
		Label label4 = new Label(
				"Habilidad: Puño Luminoso, el linterna concentra energía en su puño para infligir un golpe de alto daño.");

		label1.set(PROPERTY_FONT, new Extent(0));
		label2.set(PROPERTY_FONT, new Extent(0));
		label3.set(PROPERTY_FONT, new Extent(0));
		label4.set(PROPERTY_FONT, new Extent(0));

		cp.add(label1);
		cp.add(label2);
		cp.add(label3);
		cp.add(label4);
		cp.setBackground(new Color(175, 0, 0));

		ClassSelectSection classSelectSection = new ClassSelectSection(btnRadioRojo, cp);

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

		Column cp = new Column();

		Label label1 = new Label(
				"Descripcion:");
		Label label2 = new Label(
				"Agrupados en los Blue Lantern Corps. Representado la esperanza.");
		Label label3 = new Label("Planeta Base: Odym, Sector 1.");
		Label label4 = new Label(
				"Habilidad: Curación, puede usar el anillo para restaurar sus puntos de salud.");

		label1.set(PROPERTY_FONT, new Extent(0));
		label2.set(PROPERTY_FONT, new Extent(0));
		label3.set(PROPERTY_FONT, new Extent(0));
		label4.set(PROPERTY_FONT, new Extent(0));

		cp.add(label1);
		cp.add(label2);
		cp.add(label3);
		cp.add(label4);
		cp.setBackground(new Color(0, 153, 255));

		ClassSelectSection classSelectSection = new ClassSelectSection(btnRadioAzul, cp);

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

		Column cp = new Column();

		Label label1 = new Label(
				"Descripcion:");
		Label label2 = new Label(
				"Agrupados en la Tribu Indigo. Representando la compasión.");
		Label label3 = new Label("Planeta Base: desconocido, Sector 3.");
		Label label4 = new Label(
				"Habilidad: Evasión de combate, el portador puede escapar de una batalla.");

		label1.set(PROPERTY_FONT, new Extent(0));
		label2.set(PROPERTY_FONT, new Extent(0));
		label3.set(PROPERTY_FONT, new Extent(0));
		label4.set(PROPERTY_FONT, new Extent(0));

		cp.add(label1);
		cp.add(label2);
		cp.add(label3);
		cp.add(label4);
		cp.setBackground(new Color(148, 71, 148));

		ClassSelectSection classSelectSection = new ClassSelectSection(btnRadioIndigo, cp);

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

		Column cp = new Column();

		Label label1 = new Label(
				"Descripcion:");
		Label label2 = new Label(
				"Agrupados en los Star Sapphires. Representando el amor.");
		Label label3 = new Label("Planeta Base: Zamaron, Sector 1412.");
		Label label4 = new Label(
				"Habilidad: Confusión, puede disminuir la efectividad de los ataques del oponente.");

		label1.set(PROPERTY_FONT, new Extent(0));
		label2.set(PROPERTY_FONT, new Extent(0));
		label3.set(PROPERTY_FONT, new Extent(0));
		label4.set(PROPERTY_FONT, new Extent(0));

		cp.add(label1);
		cp.add(label2);
		cp.add(label3);
		cp.add(label4);
		cp.setBackground(new Color(255, 0, 255));

		ClassSelectSection classSelectSection = new ClassSelectSection(btnRadioVioleta, cp);

		return classSelectSection;

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	protected void btnBackClicked() throws Exception {
		PanelRegistro1 pnlregistro1 = new PanelRegistro1(usuario, personaje);
		desktop = app.getDesktop();
		desktop.setPanelCentral(pnlregistro1);
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	protected void btnSendClicked() throws ClassNotFoundException, Exception {

		Registro.guardarUsuario(usuario, personaje, optClase);

		desktop = app.getDesktop();
		desktop.setWindowPaneEmergente("Has Completado EL Registro Satisfactoriamente");
		PanelLogin pnlMain = new PanelLogin();
		desktop.setPanelCentral(pnlMain);

	}

}
