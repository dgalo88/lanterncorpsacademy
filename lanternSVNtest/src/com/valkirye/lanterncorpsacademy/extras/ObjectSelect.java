package com.valkirye.lanterncorpsacademy.extras;

import nextapp.echo.app.Component;
import nextapp.echo.app.Row;
import nextapp.echo.app.event.EventListenerList;

import com.minotauro.echo.table.event.PageableModelEvtProxy;

@SuppressWarnings("serial")
public class ObjectSelect extends Row {

  protected PageableModelEvtProxy pageableModelEvtProxy = //
  new PageableModelEvtProxy(new EventListenerList());
  protected int pageSize = 3;
  protected int currPage = 0;

  //	private List<itemPrb> selected = new ArrayList<itemPrb>();
  private final ObjectSelectModel objectSelectModel;

  public ObjectSelect(ObjectSelectModel objectSelectModel, CellRenderer cellRenderer) {
    this.objectSelectModel = objectSelectModel;

    for (int i = 0; i < objectSelectModel.getRowCount(); i++) {
      Component component = cellRenderer.getCellRenderer(this, objectSelectModel.getElementAt(i), i);
      
      //component.setLayoutData(cellRenderer.getGridLayoutData());

      add(component);
    }
  }

  //	public List<itemPrb> getSelected() {
  //		return selected;
  //	}
  //
  //	public void setSelected() {
  //		for (int i = 0; i < objectList.size(); i++) {
  //			if (objectList.get(i).isSelected()) {
  //				selected.add(objectList.get(i));
  //			}
  //		}
  //	}

  //	public int getSize() {
  //		return objectList.size();
  //	}

  //	public void currPageChanged() {
  //
  //		if (getCurrPage() + 1 >= getTotalPages()) {
  //			setCurrPage(getTotalPages() - 1);
  //		}
  //		setCurrPage( //
  //		getCurrPage() >= 0 ? getCurrPage() : 0);
  //
  //	}
  //
  //	public int getCurrPage() {
  //		return currPage;
  //	}
  //
  //	public int getPageSize() {
  //		return pageSize;
  //	}
  //
  //	public PageableModelEvtProxy getPageableModelEvtProxy() {
  //		return pageableModelEvtProxy;
  //	}
  //
  //	public int getPagedFromRealRow(int arg0) {
  //		return getCurrPage() * getPageSize() + arg0;
  //	}

  //	public int getRealFromPagedRow(int arg0) {
  //		throw new UnsupportedOperationException();
  //	}

  //	public int getTotalPages() {
  //
  //		if (getTotalObjects() == 0) {
  //			return 1;
  //		}
  //
  //		return (int) Math.ceil( //
  //				((double) getTotalObjects() / getPageSize()));
  //
  //	}

  //	public int getTotalObjects() {
  //		return objectList.size();
  //	}

  //	public void setCurrPage(int currPage) {
  //		this.currPage = currPage;
  //	}
  //
  //	public void setPageSize(int pageSize) {
  //		this.pageSize = pageSize;
  //	}

}
