package com.ulasoft.lanterncorpsacademy.paneles;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Insets;
import nextapp.echo.app.Label;
import nextapp.echo.app.Panel;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.ulasoft.lanterncorpsacademy.logic.Estilo;
import com.ulasoft.lanterncorpsacademy.stilos.GUIStyles;

@SuppressWarnings("serial")
public class PanelMedia extends Panel {

	final Label lblImagen1;
	final Label lblImagen2;
	final Label lblImagen3;
	final Label lblImagen4;

	public PanelMedia() {

		Column col = new Column();
		col.setInsets(new Insets(10, 10, 10, 10));
		col.setCellSpacing(new Extent(10));

		Row row = new Row();
		row.setCellSpacing(new Extent(30));
		row.setAlignment(Alignment.ALIGN_CENTER);

		col.add(PanelConstructor.initTopRow("Fondos de Escritorio"));

		lblImagen1 = new Label(new ResourceImageReference( //
				"/com/ulasoft/lanterncorpsacademy/imagenes/blackest_night_2_1600x1200.jpg", //
				new Extent(200), new Extent(140)));
		row.add(lblImagen1);

		lblImagen2 = new Label(new ResourceImageReference( //
				"/com/ulasoft/lanterncorpsacademy/imagenes/fondo.jpg", //
				new Extent(200), new Extent(140)));
		row.add(lblImagen2);

		col.add(row);

		row = new Row();
		row.setCellSpacing(new Extent(30));
		row.setAlignment(Alignment.ALIGN_CENTER);

		Button btnImagen1Link = new Button("1600x1200");
		Estilo.setFont(btnImagen1Link, GUIStyles.UNDERLINE, 12);
		btnImagen1Link.setTextAlignment(Alignment.ALIGN_CENTER);
		btnImagen1Link.setForeground(Color.WHITE);
		btnImagen1Link.setWidth(new Extent(200));
		btnImagen1Link.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnImagenLinkClicked(lblImagen1);
			}
		});
		row.add(btnImagen1Link);

		Button btnImagen2Link = new Button("1442x720");
		Estilo.setFont(btnImagen2Link, GUIStyles.UNDERLINE, 12);
		btnImagen2Link.setTextAlignment(Alignment.ALIGN_CENTER);
		btnImagen2Link.setForeground(Color.WHITE);
		btnImagen2Link.setWidth(new Extent(200));
		btnImagen2Link.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnImagenLinkClicked(lblImagen2);
			}
		});
		row.add(btnImagen2Link);

		col.add(row);

		row = new Row();
		row.setCellSpacing(new Extent(30));
		row.setAlignment(Alignment.ALIGN_CENTER);

		lblImagen3 = new Label(new ResourceImageReference( //
				"/com/ulasoft/lanterncorpsacademy/imagenes/Green-Lantern-corps.jpg", //
				new Extent(200), new Extent(140)));
		row.add(lblImagen3);

		lblImagen4 = new Label(new ResourceImageReference( //
				"/com/ulasoft/lanterncorpsacademy/imagenes/sinestros.jpg", //
				new Extent(200), new Extent(140)));
		row.add(lblImagen4);

		col.add(row);

		row = new Row();
		row.setCellSpacing(new Extent(30));
		row.setAlignment(Alignment.ALIGN_CENTER);

		Button btnImagen3Link = new Button("1280x960");
		Estilo.setFont(btnImagen3Link, GUIStyles.UNDERLINE, 12);
		btnImagen3Link.setTextAlignment(Alignment.ALIGN_CENTER);
		btnImagen3Link.setForeground(Color.WHITE);
		btnImagen3Link.setWidth(new Extent(200));
		btnImagen3Link.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnImagenLinkClicked(lblImagen3);
			}
		});
		row.add(btnImagen3Link);

		Button btnImagen4Link = new Button("726x488");
		Estilo.setFont(btnImagen4Link, GUIStyles.UNDERLINE, 12);
		btnImagen4Link.setTextAlignment(Alignment.ALIGN_CENTER);
		btnImagen4Link.setForeground(Color.WHITE);
		btnImagen4Link.setWidth(new Extent(200));
		btnImagen4Link.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				btnImagenLinkClicked(lblImagen4);
			}
		});
		row.add(btnImagen4Link);

		col.add(row);
		add(col);
	}

	private void btnImagenLinkClicked(Label label) {

		//

	}
}
