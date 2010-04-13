package dao.api;

import dao.connection.ConnectionBean;


public class FactoryDAO {

	private FactoryDAO() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	public static InterfaceDAO getDAO( //
			Class<? extends InterfaceDAO> clazz, ConnectionBean connectionBean) //
			throws ClassNotFoundException, Exception {

		InterfaceDAO ret = (InterfaceDAO) clazz.newInstance();
		ret.init(connectionBean);

		return ret;
	}
}
