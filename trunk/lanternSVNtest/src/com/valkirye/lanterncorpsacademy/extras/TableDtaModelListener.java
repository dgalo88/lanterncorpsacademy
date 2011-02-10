/*
 * Created on 22/09/2008
 */
package com.valkirye.lanterncorpsacademy.extras;

import java.util.EventListener;

/**
 * @author Demián Gutierrez
 */
public interface TableDtaModelListener extends EventListener {

  public void tableDtaChanged(TableDtaModelEvent evt);
}
