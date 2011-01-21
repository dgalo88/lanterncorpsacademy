package com.valkirye.lanterncorpsacademy.extras;

import java.util.ArrayList;
import java.util.List;

import nextapp.echo.app.Color;
import nextapp.echo.app.Column;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Grid;
import nextapp.echo.app.button.ButtonGroup;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

@SuppressWarnings("serial")
public class ClassSelect extends Grid {

	private Column col = new Column();
	private ClassSelectSection selected;
	private List<ClassSelectSection> sections = new ArrayList<ClassSelectSection>();
	private ButtonGroup btnGroupClases = new ButtonGroup();

	public ClassSelect() {

		setColumnWidth(1, new Extent(500));
		setWidth(new Extent(750));
		setBackground(new Color(255, 255, 255));

	}

	public void addSection(ClassSelectSection acSection){

		if(sections.isEmpty()){
			selected = acSection;
		}	

		sections.add(acSection);
		acSection.radioButton.setGroup(btnGroupClases);

		acSection.getActionListenerProxy().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent evt) {
				sectionClicked(evt);
			}
		});

		col.add(acSection.getColLeft());
		add(col);

	}

	private void sectionClicked(ActionEvent evt) {

		ClassSelectSection acSection = (ClassSelectSection) evt.getSource();

		if (acSection == selected) {
			selected.show();
			add(selected.getTextArea());
		} else {
			if (selected.isActive()){
				selected.hide();
				remove(selected.getTextArea());
			}
			selected = acSection;
			selected.show();
			add(selected.getTextArea());
		}

	}

}