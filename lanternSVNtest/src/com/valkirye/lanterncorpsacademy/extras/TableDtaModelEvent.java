/*
 * Created on 22/09/2008
 */
package com.valkirye.lanterncorpsacademy.extras;

import java.util.EventObject;

/**
 * @author Demián Gutierrez
 */
@SuppressWarnings("serial")
public class TableDtaModelEvent extends EventObject {

  public TableDtaModelEvent(ObjectSelectModel source) {
    super(source);
  }
}
