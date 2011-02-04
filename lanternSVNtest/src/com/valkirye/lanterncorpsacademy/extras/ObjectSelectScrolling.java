package com.valkirye.lanterncorpsacademy.extras;
import java.util.ArrayList;
import java.util.List;

import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

@SuppressWarnings("serial")
public class ObjectSelectScrolling extends Column{

	private Row row = new Row();
	private Button btnLeft;
	private Button btnRight;

	private ObjectSelect selected;
	private List<ObjectSelect> objects = new ArrayList<ObjectSelect>();

	public ObjectSelectScrolling() {

		btnLeft = new Button("<");
		btnLeft.setWidth(new Extent(20));
//		btnLeft.setStyle(ButtonStyle.MENU_STYLE);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnLeftClicked();
			}
		});

		btnRight = new Button(">");
		btnRight.setWidth(new Extent(20));
//		btnRight.setStyle(ButtonStyle.MENU_STYLE);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnRightClicked();
			}
		});

		row.add(btnLeft);
		row.add(btnRight);

		add(row);

	}

	public void addSection(ObjectSelect object){

		row.remove(btnRight);

		if(objects.isEmpty()){
			selected = object;
		}
		objects.add(object);

//		object.getActionListenerProxy().addActionListener(new ActionListener() {	
//			@Override
//			public void actionPerformed(ActionEvent evt) {
//				sectionClicked(evt);
//			}
//		});

		row.add(object);
		row.add(btnRight);

	}

	private void sectionClicked(ActionEvent evt) {

		ObjectSelect objectSelected = (ObjectSelect) evt.getSource();
		selected = objectSelected;
		
	}

	public ObjectSelect getObjectSelect() {
		return selected;
	}

	private void btnLeftClicked() {
//		selected = objects.get(getComponentCount()-1);
	}

	private void btnRightClicked() {
//		selected = objects.get(getComponentCount()+1);
	}

}
