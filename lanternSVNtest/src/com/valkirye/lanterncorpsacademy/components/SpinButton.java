package com.valkirye.lanterncorpsacademy.components;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Border;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.FillImage;
import nextapp.echo.app.Font;
import nextapp.echo.app.ResourceImageReference;
import nextapp.echo.app.Row;
import nextapp.echo.app.TextField;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

/**
 * Author: Donato Galo
 * Date: 19/01/2011 
 */
@SuppressWarnings("serial")
public class SpinButton extends Column {

	private Row row = new Row();
	private Column col = new Column();;
	private Button btnUp;
	private Button btnDown;
	private TextField box = new TextField();
	private int boxData = 0;

	public SpinButton() {

		box.setText("0");
		box.setBackgroundImage(new FillImage(new ResourceImageReference(
					"com/valkirye/lanterncorpsacademy/components/images/spBox01.png")));
		box.setWidth(new Extent(36));
		box.setHeight(new Extent(18));
		box.setEditable(true);
		box.setAlignment(Alignment.ALIGN_CENTER);
		box.setBorder(new Border(0, Color.WHITE, Border.STYLE_INSET));
		box.setFont(new Font(Font.VERDANA, Font.PLAIN, new Extent(12)));

		col.add(box);
		row.add(col);
		col = new Column();

		btnUp = new Button(new ResourceImageReference(
					"com/valkirye/lanterncorpsacademy/components/images/spBtnUp01.png",
					new Extent(13), new Extent(10)));
		btnUp.setWidth(new Extent(13));
		btnUp.setHeight(new Extent(10));
		btnUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnUpClicked();
			}
		});
		col.add(btnUp);

		btnDown = new Button(new ResourceImageReference(
					"com/valkirye/lanterncorpsacademy/components/images/spBtnDown01.png",
					new Extent(13), new Extent(10)));
		btnUp.setWidth(new Extent(13));
		btnUp.setHeight(new Extent(10));
		btnDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				btnDownClicked();
			}
		});
		col.add(btnDown);

		row.add(col);
		this.add(row);
	}

	private void btnUpClicked() {
		boxData++;
		box.setText(Integer.toString(boxData));
	}

	private void btnDownClicked() {
		if (boxData == 0) {
			return;
		} else {
			boxData--;
			box.setText(Integer.toString(boxData));
		}
	}

	public String getBoxData() {
		return box.getText();
	}

	public int getBoxDataInt() {
		return Integer.parseInt(box.getText());
	}

}
