package com.valkirye.lanterncorpsacademy.extras;

import java.util.ArrayList;
import java.util.List;

import nextapp.echo.app.Row;
import nextapp.echo.app.event.EventListenerList;

@SuppressWarnings("serial")
public class ObjectSelect extends Row{

	private ActionListenerProxy actionListenerProxy = new ActionListenerProxy(
			new EventListenerList());

	private List<itemPrb> selected = new ArrayList<itemPrb>();
	private List<itemPrb> objects = new ArrayList<itemPrb>();
	
	public ObjectSelect(List<itemPrb> list) {

		for (int i = 0; i < list.size(); i++) {
			add(list.get(i));
		}

	}

	public ActionListenerProxy getActionListenerProxy() {
		return actionListenerProxy;
	}

	public void addObject(itemPrb item) {
		objects.add(item);
	}

}
