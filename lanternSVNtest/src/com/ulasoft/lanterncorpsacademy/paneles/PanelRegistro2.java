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
import nextapp.echo.app.Row;
import nextapp.echo.app.SplitPane;
import nextapp.echo.app.button.ButtonGroup;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.extras.app.AccordionPane;
import nextapp.echo.extras.app.layout.AccordionPaneLayoutData;

import com.ulasoft.lanterncorpsacademy.GUIStyles;

import echopoint.layout.HtmlLayoutData;

@SuppressWarnings("serial")
public class PanelRegistro2 extends Panel {

	public PanelRegistro2() {

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

			private void btnBackClicked() {
				removeAll();
				HtmlLayoutData hld = new HtmlLayoutData("main");
				PanelRegistro1 pnlMain = new PanelRegistro1();
				pnlMain.setLayoutData(hld);
				add(pnlMain);
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

			private void btnSendClicked() {

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

		ContentPane cp2 = new ContentPane();
		cp2.add(sp1);
		add(cp2);

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	private Row initgroup() {

		ButtonGroup btnGroupClases = new ButtonGroup();

		// ------------------------------------------------------------------------------

		RadioButton btnRadioVerde = new RadioButton("Verde");
		btnRadioVerde.setGroup(btnGroupClases);

		RadioButton btnRadioAmarillo = new RadioButton("Amarillo");
		btnRadioAmarillo.setGroup(btnGroupClases);

		RadioButton btnRadioNegro = new RadioButton("Negro");
		btnRadioNegro.setGroup(btnGroupClases);

		RadioButton btnRadioRojo = new RadioButton("Rojo");
		btnRadioRojo.setGroup(btnGroupClases);

		RadioButton btnRadioAzul = new RadioButton("Azul");
		btnRadioAzul.setGroup(btnGroupClases);

		RadioButton btnRadioIndigo = new RadioButton("Indigo");
		btnRadioIndigo.setGroup(btnGroupClases);

		RadioButton btnRadioVioleta = new RadioButton("Violeta");
		btnRadioVioleta.setGroup(btnGroupClases);

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
		row.setCellSpacing(new Extent(50));

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

}
