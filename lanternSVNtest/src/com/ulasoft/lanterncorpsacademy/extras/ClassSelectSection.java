package com.ulasoft.lanterncorpsacademy.extras;

import nextapp.echo.app.Border;
import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Insets;
import nextapp.echo.app.RadioButton;
import nextapp.echo.app.Style;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.app.event.EventListenerList;

@SuppressWarnings("serial")
public class ClassSelectSection extends Grid {

	private ActionListenerProxy actionListenerProxy = new ActionListenerProxy(
			new EventListenerList());

	public RadioButton radioButton;
	private Column colRight;

	public ClassSelectSection(RadioButton radioBtn, Component comp) {

		this.setInsets(new Insets(5, 5, 5, 5));
		this.setColumnWidth(1, new Extent(500));
		this.setWidth(new Extent(750));
		this.setBackground(new Color(255, 255, 255));

		radioButton = radioBtn;
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				radioButtonClicked();
			}
		});
		this.add(radioButton);

		colRight = new Column();
		colRight.setBorder(new Border(1, new Color(0, 0, 0), Border.STYLE_SOLID));
		colRight.setVisible(false);
		colRight.add(comp);
		this.add(colRight);

	}

	private void radioButtonClicked() {
		actionListenerProxy.fireActionEvent(new ActionEvent(this, null));
	}

	public ActionListenerProxy getActionListenerProxy() {
		return actionListenerProxy;
	}

	public boolean isActive() {
		return colRight.isVisible();
	}

	public void show(){
		colRight.setVisible(true);
	}

	public void hide(){
		colRight.setVisible(false);
	}

	public void setStyleClassSelect(Style style) {
		radioButton.setStyle(style);
		colRight.setStyle(style);
	}

}