package com.ulasoft.lanterncorpsacademy.extras;

import java.util.ArrayList;
import java.util.List;

import nextapp.echo.app.Column;
import nextapp.echo.app.button.ButtonGroup;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

@SuppressWarnings("serial")
public class ClassSelect extends Column {

	private ClassSelectSection selected;

	private List<ClassSelectSection> sections = new ArrayList<ClassSelectSection>();
	private ButtonGroup btnGroupClases = new ButtonGroup();

	public ClassSelect() {
		/* Empty */
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
		this.add(acSection);

	}

	private void sectionClicked(ActionEvent evt) {

		ClassSelectSection acSection = (ClassSelectSection) evt.getSource();

		if (acSection == selected) {
			if (selected.isActive()){
				selected.hide();
			} else {
				selected.show();
			}
		} else {
			if (selected.isActive()){
				selected.hide();
			}
			selected = acSection;
			selected.show();
		}

	}

}