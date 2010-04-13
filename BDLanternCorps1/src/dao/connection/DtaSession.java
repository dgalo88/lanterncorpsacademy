package dao.connection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import dao.api.DataObject;

public class DtaSession {

	private Map<String, DataObject> dtaObjectByKey = //
	new HashMap<String, DataObject>();

	private Set<DataObject> delObject = //
	new HashSet<DataObject>();

	// --------------------------------------------------------------------------------

	public DtaSession() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	public DataObject add(DataObject addDO) {
		if (addDO == null) {
			return null;
		}

		DataObject curDO = getDtaByKey(addDO);

		if (curDO == null) {
			dtaObjectByKey.put(createKey(addDO), addDO);
			curDO = addDO;
		}

		return curDO;
	}

	// --------------------------------------------------------------------------------

	public DataObject getDtaByKey(DataObject getDO) {
		if (getDO == null) {
			return null;
		}

		DataObject curDO = dtaObjectByKey.get(createKey(getDO));

		if (curDO != null && curDO != getDO) {
			throw new IllegalArgumentException( //
					"curDO != null && curDO != getDO : " + //
							createKey(getDO));
		}

		return curDO;
	}

	// --------------------------------------------------------------------------------

	public DataObject getDtaByVal(DataObject getDO) {
		if (dtaObjectByKey.values().contains(getDO)) {
			return getDO;
		}

		return null;
	}

	// --------------------------------------------------------------------------------

	public DataObject getDtaByKey(Class<? extends DataObject> clazz, int id) {
		if (clazz == null || id < 1) {
			throw new IllegalArgumentException("clazz == null || id < 1");
		}

		return dtaObjectByKey.get(clazz + "#" + id);
	}

	// --------------------------------------------------------------------------------

	public DataObject del(DataObject delDO) {
		if (delDO == null) {
			return null;
		}

		dtaObjectByKey.remove(delDO);

		delObject.add(delDO);

		return delDO;
	}

	// --------------------------------------------------------------------------------

	public DataObject getDelByKey(DataObject getDO) {
		if (delObject.contains(getDO)) {
			return getDO;
		}

		return null;
	}

	// --------------------------------------------------------------------------------

	public String createKey(DataObject dataObject) {
		return dataObject.getClass() + "#" + dataObject.getId();
	}
}
