package com.valkirye.lanterncorpsacademy.components;

import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Component;
import nextapp.echo.app.Style;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;
import nextapp.echo.app.event.EventListenerList;

@SuppressWarnings("serial")
public class AccordionSection extends Column {

	private ActionListenerProxy actionListenerProxy = //
		new ActionListenerProxy(new EventListenerList());

	private Button button;
	private Column col;

	public AccordionSection(String sectionName) {

		button = new Button(sectionName);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonClicked();
			}
		});
		add(button);

		col = new Column();
		col.setVisible(false);
		add(col);

	}

	public AccordionSection(Button btn) {

		button = btn;
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				buttonClicked();
			}
		});
		add(button);

		col = new Column();
		add(col);

	}

	private void buttonClicked() {
		actionListenerProxy.fireActionEvent(new ActionEvent(this, null));
	}

	public ActionListenerProxy getActionListenerProxy() {
		return actionListenerProxy;
	}

	public boolean isActive() {
		return col.isVisible();
	}

	public void show(){
		col.setVisible(true);
	}

	public void hide(){
		col.setVisible(false);
	}

	public void addItem(Component component){
		col.add(component);
	}

	public void setStyleButton(Style style) {
		button.setStyle(style);
	}

}