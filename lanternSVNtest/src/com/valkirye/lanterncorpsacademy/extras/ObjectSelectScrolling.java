package com.valkirye.lanterncorpsacademy.extras;

import java.util.ArrayList;
import java.util.List;

import nextapp.echo.app.Button;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.Label;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

@SuppressWarnings("serial")
public class ObjectSelectScrolling extends Column{

	private Button btnLeft;
	private Button btnRight;
	private Column col = new Column();
	private Grid [] grid = new Grid[3];

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

		Row row = new Row();
		for (int i = 0; i < grid.length; i++) {
			grid[i] = new Grid();
			
		}

		grid[0].add(btnLeft);
		grid[1].add(new Label("Lista Vacía"));
		grid[2].add(btnRight);

		for (int i = 0; i < grid.length; i++) {
			row.add(grid[i]);
		}
		col.add(row);
		add(col);

	}

	public void addSection(ObjectSelect object){

		if(objects.isEmpty()){
			selected = object;
		}	

		objects.add(object);

		object.getActionListenerProxy().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent evt) {
				sectionClicked(evt);
			}
		});

		grid[1].removeAll();
		grid[1].add(object);

	}

	private void sectionClicked(ActionEvent evt) {

		ObjectSelect objectSelect = (ObjectSelect) evt.getSource();

		selected = objectSelect;
		
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

//	private void putObjects(ObjectSelect object){
//
//		grid[1].removeAll();
//		grid[1].add(object);
//
//	}

}
