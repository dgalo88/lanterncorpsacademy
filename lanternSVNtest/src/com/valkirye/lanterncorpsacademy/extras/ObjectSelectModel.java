package com.valkirye.lanterncorpsacademy.extras;

import java.util.ArrayList;
import java.util.List;

import nextapp.echo.app.event.EventListenerList;

import com.minotauro.echo.table.base.PageableModel;
import com.minotauro.echo.table.event.PageableModelEvent;
import com.minotauro.echo.table.event.PageableModelEvtProxy;

public class ObjectSelectModel implements PageableModel {

	protected PageableModelEvtProxy pageableModelEvtProxy = //
		new PageableModelEvtProxy(new EventListenerList());
	protected TableDtaModelEvtProxy tableDtaModelEvtProxy = //
		new TableDtaModelEvtProxy(new EventListenerList());

	protected int pageSize = 3;
	protected int currPage = 0;

	private List<ObjectLca> selected = new ArrayList<ObjectLca>();
	private List<ObjectLca> objectList;

	public ObjectSelectModel(List<ObjectLca> list) {
		objectList = list;
	}

	// --------------------------------------------------------------------------------

	public List<ObjectLca> getSelected() {
		return selected;
	}

	public void setSelected() {
		for (int i = 0; i < objectList.size(); i++) {
			if (objectList.get(i).isSelected()) {
				selected.add(objectList.get(i));
			}
		}
	}

	// --------------------------------------------------------------------------------

	public PageableModelEvtProxy getPageableModelEvtProxy() {
		return pageableModelEvtProxy;
	}

	public void currPageChanged() {
		tableDtaModelEvtProxy.fireActionEvent( //
				new TableDtaModelEvent(this));
		pageableModelEvtProxy.fireActionEvent( //
				new PageableModelEvent(this));
	}

	// --------------------------------------------------------------------------------

	public int getObjectsCount() {
		return Math.min(objectList.size() - getRealFromPagedRow(0), pageSize);
	}

	public Object getElementAt(int pos) {
		pos = getRealFromPagedRow(pos);
		return objectList.get(pos);
	}

	public int getCurrPage() {
		return currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	// --------------------------------------------------------------------------------

	public int getPagedFromRealRow(int row) {
		throw new UnsupportedOperationException();
	}

	public int getRealFromPagedRow(int row) {
		return getCurrPage() * getPageSize() + row;
	}

	// --------------------------------------------------------------------------------

	public int getTotalPages() {

		if (getTotalObjects() == 0) {
			return 1;
		}
		return (int) Math.ceil( //
				((double) getTotalObjects() / getPageSize()));
	}

	public int getTotalObjects() {
		return objectList.size();
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
