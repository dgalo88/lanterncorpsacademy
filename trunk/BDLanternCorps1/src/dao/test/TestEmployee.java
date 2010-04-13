package dao.test;

import java.util.List;

import junit.framework.TestCase;
import dao.api.DataObject;
import dao.api.FactoryDAO;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.example.EmployeeDAO;
import dao.example.EmployeeDO;

/**
 * @author Demián Gutierrez
 */
public class TestEmployee extends TestCase {

	private boolean compareDO(EmployeeDO employeeDO1, EmployeeDO employeeDO2) {
		boolean ret = true;

		ret = ret && employeeDO1.getId() == employeeDO2.getId();
		ret = ret
				&& employeeDO1.getFrstName().equals(employeeDO2.getFrstName());
		ret = ret
				&& employeeDO1.getLastName().equals(employeeDO2.getLastName());

		return ret;
	}

	// --------------------------------------------------------------------------------

	public void testInsertLoad() throws Exception {
		ConnectionBean connectionBean;
		EmployeeDAO employeeDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);
		employeeDAO.createTable();

		EmployeeDO employeeDO1 = new EmployeeDO();
		employeeDO1.setFrstName("FooFrstName111");
		employeeDO1.setLastName("FooLastName111");
		employeeDAO.insert(employeeDO1);
		assertEquals(employeeDO1.getId(), 1);

		EmployeeDO employeeDO2 = new EmployeeDO();
		employeeDO2.setFrstName("FooFrstName222");
		employeeDO2.setLastName("FooLastName222");
		employeeDAO.insert(employeeDO2);
		assertEquals(employeeDO2.getId(), 2);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);

		EmployeeDO employeeDOX = (EmployeeDO) employeeDAO.loadById(1);
		assertTrue(compareDO(employeeDO1, employeeDOX));
		assertNotSame(employeeDO1, employeeDOX);

		EmployeeDO employeeDOY = (EmployeeDO) employeeDAO.loadById(2);
		assertTrue(compareDO(employeeDO2, employeeDOY));
		assertNotSame(employeeDO2, employeeDOY);

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testUpdateLoad() throws Exception {
		ConnectionBean connectionBean;
		EmployeeDAO employeeDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);
		employeeDAO.createTable();

		EmployeeDO employeeDO1 = new EmployeeDO();
		employeeDO1.setFrstName("FooFrstName111");
		employeeDO1.setLastName("FooLastName111");
		employeeDAO.insert(employeeDO1);
		assertEquals(employeeDO1.getId(), 1);

		EmployeeDO employeeDO2 = new EmployeeDO();
		employeeDO2.setFrstName("FooFrstName222");
		employeeDO2.setLastName("FooLastName222");
		employeeDAO.insert(employeeDO2);
		assertEquals(employeeDO2.getId(), 2);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD / UPDATE
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);

		EmployeeDO employeeDOX = (EmployeeDO) employeeDAO.loadById(1);
		employeeDOX.setFrstName("FooFrstNameXXX");
		employeeDOX.setLastName("FooLastNameXXX");
		employeeDAO.update(employeeDOX); // Changes the 111

		EmployeeDO employeeDOY = (EmployeeDO) employeeDAO.loadById(2);
		employeeDOY.setFrstName("FooFrstNameYYY");
		employeeDOY.setLastName("FooLastNameYYY");
		employeeDAO.update(employeeDOY); // Changes the 222

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);

		EmployeeDO employeeDOA = (EmployeeDO) employeeDAO.loadById(1);
		assertTrue(compareDO(employeeDOX, employeeDOA));
		assertNotSame(employeeDOX, employeeDOA);

		EmployeeDO employeeDOB = (EmployeeDO) employeeDAO.loadById(2);
		assertTrue(compareDO(employeeDOY, employeeDOB));
		assertNotSame(employeeDOY, employeeDOB);

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testDeleteLoad() throws Exception {
		ConnectionBean connectionBean;
		EmployeeDAO employeeDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);
		employeeDAO.createTable();

		EmployeeDO employeeDO1 = new EmployeeDO();
		employeeDO1.setFrstName("FooFrstName111");
		employeeDO1.setLastName("FooLastName111");
		employeeDAO.insert(employeeDO1);
		assertEquals(employeeDO1.getId(), 1);

		EmployeeDO employeeDO2 = new EmployeeDO();
		employeeDO2.setFrstName("FooFrstName222");
		employeeDO2.setLastName("FooLastName222");
		employeeDAO.insert(employeeDO2);
		assertEquals(employeeDO2.getId(), 2);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD / DELETE
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);

		EmployeeDO employeeDOX = (EmployeeDO) employeeDAO.loadById(1);
		employeeDAO.delete(employeeDOX);

		EmployeeDO employeeDOY = (EmployeeDO) employeeDAO.loadById(2);
		employeeDAO.delete(employeeDOY);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);

		EmployeeDO employeeDOA = (EmployeeDO) employeeDAO.loadById(1);
		assertNull(employeeDOA);

		EmployeeDO employeeDOB = (EmployeeDO) employeeDAO.loadById(2);
		assertNull(employeeDOB);

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testCacheLoad() throws Exception {
		ConnectionBean connectionBean;
		EmployeeDAO employeeDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);
		employeeDAO.createTable();

		EmployeeDO employeeDO1 = new EmployeeDO();
		employeeDO1.setFrstName("FooFrstName111");
		employeeDO1.setLastName("FooLastName111");
		employeeDAO.insert(employeeDO1);
		assertEquals(employeeDO1.getId(), 1);

		EmployeeDO employeeDO2 = new EmployeeDO();
		employeeDO2.setFrstName("FooFrstName222");
		employeeDO2.setLastName("FooLastName222");
		employeeDAO.insert(employeeDO2);
		assertEquals(employeeDO2.getId(), 2);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD / RE-LOAD
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);

		EmployeeDO employeeDOX = (EmployeeDO) employeeDAO.loadById(1);
		EmployeeDO employeeDOA = (EmployeeDO) employeeDAO.loadById(1);
		assertTrue(compareDO(employeeDOX, employeeDOA));
		assertSame(employeeDOX, employeeDOA);

		EmployeeDO employeeDOY = (EmployeeDO) employeeDAO.loadById(2);
		EmployeeDO employeeDOB = (EmployeeDO) employeeDAO.loadById(2);
		assertTrue(compareDO(employeeDOY, employeeDOB));
		assertSame(employeeDOY, employeeDOB);

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testDeleteReInsert() throws Exception {
		ConnectionBean connectionBean;
		EmployeeDAO employeeDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);
		employeeDAO.createTable();

		EmployeeDO employeeDO1 = new EmployeeDO();
		employeeDO1.setFrstName("FooFrstName");
		employeeDO1.setLastName("FooLastName");
		employeeDAO.insert(employeeDO1);
		assertEquals(employeeDO1.getId(), 1);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD / DELETE / RE-INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);

		EmployeeDO employeeDOX = (EmployeeDO) employeeDAO.loadById(1);
		employeeDAO.delete(employeeDOX);

		try {
			employeeDAO.insert(employeeDOX);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
		}

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testDeleteReUpdate() throws Exception {
		ConnectionBean connectionBean;
		EmployeeDAO employeeDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);
		employeeDAO.createTable();

		EmployeeDO employeeDO1 = new EmployeeDO();
		employeeDO1.setFrstName("FooFrstName");
		employeeDO1.setLastName("FooLastName");
		employeeDAO.insert(employeeDO1);
		assertEquals(employeeDO1.getId(), 1);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD / DELETE / RE-INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);

		EmployeeDO employeeDOX = (EmployeeDO) employeeDAO.loadById(1);
		employeeDAO.delete(employeeDOX);

		try {
			employeeDAO.update(employeeDOX);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
		}

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testDeleteReDelete() throws Exception {
		ConnectionBean connectionBean;
		EmployeeDAO employeeDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);
		employeeDAO.createTable();

		EmployeeDO employeeDO1 = new EmployeeDO();
		employeeDO1.setFrstName("FooFrstName");
		employeeDO1.setLastName("FooLastName");
		employeeDAO.insert(employeeDO1);
		assertEquals(employeeDO1.getId(), 1);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD / DELETE / RE-DELETE
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);

		EmployeeDO employeeDOX = (EmployeeDO) employeeDAO.loadById(1);
		employeeDAO.delete(employeeDOX);

		try {
			employeeDAO.delete(employeeDOX);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
		}

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testCacheCrash() throws Exception {
		ConnectionBean connectionBean;
		EmployeeDAO employeeDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);
		employeeDAO.createTable();

		EmployeeDO employeeDO1 = new EmployeeDO();
		employeeDO1.setFrstName("FooFrstName111");
		employeeDO1.setLastName("FooLastName111");

		EmployeeDO employeeDO2 = new EmployeeDO();
		employeeDO2.setFrstName("FooFrstName222");
		employeeDO2.setLastName("FooLastName222");

		// ----------------------------------------
		// UPDATE NON INSERTED
		// ----------------------------------------

		try {
			employeeDAO.update(employeeDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
		}

		// ----------------------------------------
		// DELETE NON INSERTED
		// ----------------------------------------

		try {
			employeeDAO.delete(employeeDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
		}

		// ----------------------------------------
		// INSERT TAMPERED
		// ----------------------------------------

		try {
			employeeDO1.setId(1); // TAMPERED ID
			employeeDAO.insert(employeeDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
			employeeDO1.setId(0); // UNTAMPER ID
		}

		// ----------------------------------------
		// UPDATE TAMPERED
		// ----------------------------------------

		try {
			employeeDO1.setId(1); // TAMPERED ID
			employeeDAO.update(employeeDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
			employeeDO1.setId(0); // UNTAMPER ID
		}

		// ----------------------------------------
		// DELETE TAMPERED
		// ----------------------------------------

		try {
			employeeDO1.setId(1); // TAMPERED ID
			employeeDAO.delete(employeeDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
			employeeDO1.setId(0); // UNTAMPER ID
		}

		// ----------------------------------------
		// DO INSERT
		// ----------------------------------------

		employeeDAO.insert(employeeDO1); // WORKS
		employeeDAO.insert(employeeDO2); // WORKS

		// ----------------------------------------
		// RE-INSERT TAMPERED
		// ----------------------------------------

		try {
			employeeDO1.setId(0); // TAMPERED ID
			employeeDAO.insert(employeeDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
			employeeDO1.setId(1); // UNTAMPER ID
		}

		// ----------------------------------------
		// RE-UPDATE TAMPERED
		// ----------------------------------------

		try {
			employeeDO1.setId(2); // TAMPERED ID
			employeeDAO.update(employeeDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
			employeeDO1.setId(1); // UNTAMPER ID
		}

		// ----------------------------------------
		// RE-DELETE TAMPERED
		// ----------------------------------------

		try {
			employeeDO1.setId(2); // TAMPERED ID
			employeeDAO.delete(employeeDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
			employeeDO1.setId(1); // UNTAMPER ID
		}

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testCount() throws Exception {
		ConnectionBean connectionBean;
		EmployeeDAO employeeDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);
		employeeDAO.createTable();

		EmployeeDO employeeDO1 = new EmployeeDO();
		employeeDO1.setFrstName("FooFrstName111");
		employeeDO1.setLastName("FooLastName111");
		employeeDAO.insert(employeeDO1);

		EmployeeDO employeeDO2 = new EmployeeDO();
		employeeDO2.setFrstName("FooFrstName222");
		employeeDO2.setLastName("FooLastName222");
		employeeDAO.insert(employeeDO2);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// COUNT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);

		assertEquals(2, employeeDAO.countAll());

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testListAll() throws Exception {
		ConnectionBean connectionBean;
		EmployeeDAO employeeDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);
		employeeDAO.createTable();

		EmployeeDO employeeDO1 = new EmployeeDO();
		employeeDO1.setFrstName("FooFrstName111");
		employeeDO1.setLastName("FooLastName111");
		employeeDAO.insert(employeeDO1);

		EmployeeDO employeeDO2 = new EmployeeDO();
		employeeDO2.setFrstName("FooFrstName222");
		employeeDO2.setLastName("FooLastName222");
		employeeDAO.insert(employeeDO2);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// COUNT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);

		List<DataObject> employeeList = employeeDAO.listAll();
		assertTrue(compareDO(employeeDO1, (EmployeeDO) employeeList.get(0)));
		assertTrue(compareDO(employeeDO2, (EmployeeDO) employeeList.get(1)));

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testListAllLimOff() throws Exception {
		ConnectionBean connectionBean;
		EmployeeDAO employeeDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);
		employeeDAO.createTable();

		EmployeeDO employeeDO1 = new EmployeeDO();
		employeeDO1.setFrstName("FooFrstName111");
		employeeDO1.setLastName("FooLastName111");
		employeeDAO.insert(employeeDO1);

		EmployeeDO employeeDO2 = new EmployeeDO();
		employeeDO2.setFrstName("FooFrstName222");
		employeeDO2.setLastName("FooLastName222");
		employeeDAO.insert(employeeDO2);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// COUNT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		employeeDAO = (EmployeeDAO) FactoryDAO.getDAO( //
				EmployeeDAO.class, connectionBean);

		List<DataObject> employeeList;

		employeeList = employeeDAO.listAll(1, 0);
		assertEquals(1, employeeList.size());
		assertTrue(compareDO(employeeDO1, (EmployeeDO) employeeList.get(0)));

		employeeList = employeeDAO.listAll(1, 1);
		assertEquals(1, employeeList.size());
		assertTrue(compareDO(employeeDO2, (EmployeeDO) employeeList.get(0)));

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}
}
