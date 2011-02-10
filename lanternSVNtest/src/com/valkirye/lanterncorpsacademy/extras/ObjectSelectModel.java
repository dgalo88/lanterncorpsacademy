package com.valkirye.lanterncorpsacademy.extras;

import java.util.ArrayList;
import java.util.List;

import nextapp.echo.app.event.EventListenerList;

import com.minotauro.echo.table.base.PageableModel;
import com.minotauro.echo.table.event.PageableModelEvent;
import com.minotauro.echo.table.event.PageableModelEvtProxy;

public class ObjectSelectModel implements PageableModel{

	protected PageableModelEvtProxy pageableModelEvtProxy = //
		new PageableModelEvtProxy(new EventListenerList());
	protected TableDtaModelEvtProxy tableDtaModelEvtProxy = //
		new TableDtaModelEvtProxy(new EventListenerList());

	protected int pageSize = 3;
	protected int currPage = 0;

	private List<ItemPrb> selected = new ArrayList<ItemPrb>();
	private List<ItemPrb> objectList;

	public ObjectSelectModel(List<ItemPrb> list) {
		objectList = list;
	}

	public List<ItemPrb> getSelected() {
		return selected;
	}

//	public void setSelected() {
//		for (int i = 0; i < objectList.size(); i++) {
//			if (objectList.get(i).isSelected()) {
//				selected.add(objectList.get(i));
//			}
//		}
//	}

	public int getObjectsCount() {
		return Math.min(objectList.size() - getRealFromPagedRow(0), pageSize);
	}

	public Object getElementAt(int pos) {
		pos = getRealFromPagedRow(pos);
		return objectList.get(pos);
	}

//	public void currPageChanged() {
//
//		if (getCurrPage() + 1 >= getTotalPages()) {
//			setCurrPage(getTotalPages() - 1);
//		}
//		setCurrPage( //
//		getCurrPage() >= 0 ? getCurrPage() : 0);
//
//	}

	public void currPageChanged() {
		//updateCurrPage();
		tableDtaModelEvtProxy.fireActionEvent( //
				new TableDtaModelEvent(this));
		pageableModelEvtProxy.fireActionEvent( //
				new PageableModelEvent(this));
	}

	public int getCurrPage() {
		return currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public PageableModelEvtProxy getPageableModelEvtProxy() {
		return pageableModelEvtProxy;
	}

	public int getPagedFromRealRow(int row) {
		return getCurrPage() * getPageSize() + row;
	}

	public int getRealFromPagedRow(int row) {
		throw new UnsupportedOperationException();
	}

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
