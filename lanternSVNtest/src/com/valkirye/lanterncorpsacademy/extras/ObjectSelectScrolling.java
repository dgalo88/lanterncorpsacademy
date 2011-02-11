package com.valkirye.lanterncorpsacademy.extras;

import nextapp.echo.app.Alignment;
import nextapp.echo.app.Button;
import nextapp.echo.app.Color;
import nextapp.echo.app.Extent;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.ActionEvent;
import nextapp.echo.app.event.ActionListener;

import com.minotauro.echo.table.base.PageableModel;
import com.minotauro.echo.table.event.PageableModelEvent;
import com.minotauro.echo.table.event.PageableModelListener;
import com.ulasoft.lanterncorpsacademy.LanternCorpsAcademyApp;
import com.ulasoft.lanterncorpsacademy.logic.Estilo;

@SuppressWarnings("serial")
public class ObjectSelectScrolling extends Row {

	private LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) //
			LanternCorpsAcademyApp.getActive();

	protected PageableModel pageableModel;
	protected ObjectSelect objectSelect;

	protected Button btnLeft;
	protected Button btnRight;

	public ObjectSelectScrolling(ObjectSelectModel objectSelectModel, //
			CellRenderer cellRenderer) {

		this.pageableModel = objectSelectModel;
		this.objectSelect = new ObjectSelect(objectSelectModel, cellRenderer);

		pageableModel.getPageableModelEvtProxy().addPageableModelListener( //
				new PageableModelListener() {
					public void pageChanged(PageableModelEvent evt) {
						objectSelect.initElements();
						updateState();
					}
				});

		initGUI();
		updateState();
	}

	protected void initGUI() {

		setCellSpacing(new Extent(5));

		btnLeft = new Button("<");

		btnLeft.setWidth(new Extent(20));
		btnLeft.setHeight(new Extent(40));
		btnLeft.setAlignment(Alignment.ALIGN_CENTER);
		btnLeft.setTextAlignment(Alignment.ALIGN_CENTER);
		btnLeft.setBackground(Estilo.getColor(app.getAtributos()));
		btnLeft.setDisabledBackground(Color.LIGHTGRAY);
		btnLeft.setDisabledForeground(Color.DARKGRAY);

		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnLeftClicked();
			}
		});

		btnRight = new Button(">");

		btnRight.setWidth(new Extent(20));
		btnRight.setHeight(new Extent(40));
		btnRight.setAlignment(Alignment.ALIGN_CENTER);
		btnRight.setTextAlignment(Alignment.ALIGN_CENTER);
		btnRight.setBackground(Estilo.getColor(app.getAtributos()));
		btnRight.setDisabledBackground(Color.LIGHTGRAY);
		btnRight.setDisabledForeground(Color.DARKGRAY);

		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnRightClicked();
			}
		});

		add(btnLeft);
		add(objectSelect);
		add(btnRight);
	}

	protected void btnLeftClicked() {

		pageableModel.setCurrPage(pageableModel.getCurrPage() - 1);
		pageableModel.currPageChanged();
		updateState();

	}

	protected void btnRightClicked() {

		pageableModel.setCurrPage(pageableModel.getCurrPage() + 1);
		pageableModel.currPageChanged();
		updateState();

	}

	protected void updateState() {

		int page = pageableModel.getCurrPage() + 1;

		boolean beg = page == 1;
		boolean end = page == pageableModel.getTotalPages();

		btnLeft.setEnabled(!beg);
		btnRight.setEnabled(!end);
	}

}
