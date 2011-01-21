package com.valkirye.lanterncorpsacademy.extras;


import com.valkirye.lanterncorpsacademy.components.ActionListenerProxy;

import nextapp.echo.app.Border;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Font;
import nextapp.echo.app.Insets;
import nextapp.echo.app.RadioButton;
import nextapp.echo.app.Style;
import nextapp.echo.app.TextArea;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.app.event.EventListenerList;

@SuppressWarnings("serial")
public class ClassSelectSection extends Column {

	private ActionListenerProxy actionListenerProxy = new ActionListenerProxy(
			new EventListenerList());

	private Column colLeft = new Column();
	private TextArea textArea = new TextArea();
	public RadioButton radioButton;

	public ClassSelectSection(RadioButton radioBtn, String string) {

		colLeft.setInsets(new Insets(5, 5, 5, 5));

		radioButton = radioBtn;
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				radioButtonClicked();
			}
		});
		colLeft.add(radioButton);

		textArea.setText(string);
		textArea.setBorder(new Border(1, new Color(0, 0, 0), Border.STYLE_SOLID));
		textArea.setVisible(false);
		textArea.setHeight(new Extent(180));
		textArea.setWidth(new Extent(450));
		textArea.setEditable(false);
		textArea.setFont(new Font(Font.VERDANA, Font.ITALIC, new Extent(13)));

	}

	private void radioButtonClicked() {
		actionListenerProxy.fireActionEvent(new ActionEvent(this, null));
	}

	public ActionListenerProxy getActionListenerProxy() {
		return actionListenerProxy;
	}

	public boolean isActive() {
		return textArea.isVisible();
	}

	public void show(){
		textArea.setVisible(true);
	}

	public void hide(){
		textArea.setVisible(false);
	}

	public Column getColLeft() {
		return colLeft;
	}

	public TextArea getTextArea() {
		return textArea;
	}

	public void setStyleClassSelect(Style style) {
		radioButton.setStyle(style);
		textArea.setStyle(style);
	}

	public void setBackgroundTextArea(Color color){
		textArea.setBackground(color);
	}

	public void setForegroundTextArea(Color color){
		textArea.setForeground(color);
	}

}