package com.ulasoft.lanterncorpsacademy.extras;

import java.util.ArrayList;
import java.util.List;

import nextapp.echo.app.Column;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

@SuppressWarnings("serial")
public class Accordion extends Column {

	private AccordionSection selected;

	private List<AccordionSection> sections = new ArrayList<AccordionSection>();

	public Accordion() {
		/* Empty */
	}

	public void addSection(AccordionSection acSection){

		if(sections.isEmpty()){
			selected = acSection;
		}	

		sections.add(acSection);

		acSection.getActionListenerProxy().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent evt) {
				sectionClicked(evt);
			}

		});
		this.add(acSection);

	}

	private void sectionClicked(ActionEvent evt) {

		AccordionSection acSection = (AccordionSection) evt.getSource();

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