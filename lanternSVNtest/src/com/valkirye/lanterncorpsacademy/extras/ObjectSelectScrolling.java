package com.valkirye.lanterncorpsacademy.extras;

import nextapp.echo.app.Button;
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
public class ObjectSelectScrolling extends Row{

	LanternCorpsAcademyApp app = (LanternCorpsAcademyApp) LanternCorpsAcademyApp
		.getActive();

	protected PageableModel pageableModel;
	protected ObjectSelect obSelect;

	protected Button btnLeft;
	protected Button btnRight;

	public ObjectSelectScrolling(ObjectSelect objectSelect) {

		obSelect = objectSelect;
		this.pageableModel = obSelect.getObjectSelectModel();

		pageableModel.getPageableModelEvtProxy().addPageableModelListener( //
				new PageableModelListener() {
					public void pageChanged(PageableModelEvent evt) {
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
		btnLeft.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnLeftClicked();
			}
		});

		btnRight = new Button(">");
		btnRight.setWidth(new Extent(20));
		btnRight.setHeight(new Extent(40));
		btnRight.setStyle(Estilo.getDefaultStyleColor(app.getAtributos()));
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnRightClicked();
			}
		});

		add(btnLeft);
		add(obSelect);
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
