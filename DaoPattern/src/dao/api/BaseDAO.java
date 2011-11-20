package dao.api;

import java.sql.Connection;

import dao.connection.ConnectionBean;
import dao.connection.DtaSession;

/**
 * @author Demián Gutierrez
 */
public abstract class BaseDAO implements InterfaceDAO {

  protected static final int CHECK_INSERT = 0;
  protected static final int CHECK_UPDATE = 1;
  protected static final int CHECK_DELETE = 2;
  protected static final int CHECK_IGNORE = 3;

  // --------------------------------------------------------------------------------

  protected ConnectionBean connectionBean;

  protected DtaSession dtaSession;
  protected Connection connection;

  // --------------------------------------------------------------------------------

  public BaseDAO() {
    // Empty
  }

  // --------------------------------------------------------------------------------

  @Override
  final public void init(ConnectionBean connectionBean) {
    if (this.connectionBean != null) {
      throw new IllegalStateException("this.connectionBean != null");
    }

    this.connectionBean = connectionBean;

    dtaSession = connectionBean.getDtaSession();
    connection = connectionBean.getConnection();
  }

  // --------------------------------------------------------------------------------

  @Override
  public String getTableName() {
    return getClass().getSimpleName();
  }

  // --------------------------------------------------------------------------------

  protected String singleQuotes(String str) {
    return "'" + str + "'";
  }

  // --------------------------------------------------------------------------------

  protected void checkClass( //
      DataObject dataObject, Class<? extends DataObject> dataObjectClass, int reqIdVal) {

    if (dataObject == null || dataObjectClass == null) {
      throw new IllegalArgumentException( //
          "dataObject == null || dataObjectClass == null");
    }

    if (dataObject.getClass() != dataObjectClass) {
      throw new IllegalArgumentException( //
          "dataObject.getClass() != dataObjectClass");
    }

    if (reqIdVal == CHECK_IGNORE) {
      return;
    }

    if (reqIdVal == CHECK_INSERT //
        && dataObject.getId() != 0) {
      throw new IllegalArgumentException( //
          "reqIdVal == CHECK_INSERT && dataObject.getId() != 0");
    }

    if ((reqIdVal == CHECK_UPDATE || reqIdVal == CHECK_DELETE) //
        && dataObject.getId() <= 0) {
      throw new IllegalArgumentException( //
          "(reqIdVal == CHECK_UPDATE || reqIdVal == CHECK_DELETE)" + //
              " && dataObject.getId() <= 0");
    }
  }

  // --------------------------------------------------------------------------------

  protected void checkCache(DataObject dataObject, int mode) {
    switch (mode) {
      case CHECK_INSERT :
        // In cache (deleted)
        if (dtaSession.getDelByKey(dataObject) != null) {
          throw new IllegalArgumentException( //
              "CHECK_INSERT: " + //
                  "dtaSession.getDelByKey(dataObject) != null : " + //
                  dtaSession.createKey(dataObject));
        }
        // In cache (by key)
        if (dtaSession.getDtaByKey(dataObject) != null) {
          throw new IllegalArgumentException( //
              "CHECK_INSERT: " + //
                  "dtaSession.getDtaByKey(dataObject) != null : " + //
                  dtaSession.createKey(dataObject));
        }
        // In cache (by val / tampered id)
        if (dtaSession.getDtaByVal(dataObject) != null) {
          throw new IllegalArgumentException( //
              "CHECK_INSERT: " + //
                  "dtaSession.getDtaByVal(dataObject) != null : " + //
                  dtaSession.createKey(dataObject));
        }
        break;
      case CHECK_UPDATE :
      case CHECK_DELETE :
        // In cache (deleted)
        if (dtaSession.getDelByKey(dataObject) != null) {
          throw new IllegalArgumentException( //
              "CHECK_INSERT: " + //
                  "dtaSession.getDelByKey(dataObject) != null : " + //
                  dtaSession.createKey(dataObject));
        }
        // Not in cache (by key)
        if (dtaSession.getDtaByKey(dataObject) == null) {
          throw new IllegalArgumentException( //
              "CHECK_UPDATE / CHECK_DELETE: " + //
                  "dtaSession.getByKey(dataObject) == null : " + //
                  dtaSession.createKey(dataObject));
        }
        break;
      default :
        throw new IllegalArgumentException("mode: " + mode);
    }
  }
}
