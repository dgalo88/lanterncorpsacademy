package dao.test;

import java.util.List;

import junit.framework.TestCase;
import dao.api.DataObject;
import dao.api.FactoryDAO;
import dao.connection.ConnectionBean;
import dao.connection.ConnectionFactory;
import dao.lantern.DepartmentDAO;
import dao.lantern.DepartmentDO;

/**
 * @author Demián Gutierrez
 */
public class TestDepartment extends TestCase {

	private boolean compareDO(DepartmentDO departmentDO1,
			DepartmentDO departmentDO2) {
		boolean ret = true;

		ret = ret && departmentDO1.getId() == departmentDO2.getId();
		ret = ret && departmentDO1.getName().equals(departmentDO2.getName());
		ret = ret
				&& departmentDO1.getDescription().equals(
						departmentDO2.getDescription());

		return ret;
	}

	// --------------------------------------------------------------------------------

	public void testInsertLoad() throws Exception {
		ConnectionBean connectionBean;
		DepartmentDAO departmentDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);
		departmentDAO.createTable();

		DepartmentDO departmentDO1 = new DepartmentDO();
		departmentDO1.setName("FooName111");
		departmentDO1.setDescription("FooDescription111");
		departmentDAO.insert(departmentDO1);
		assertEquals(departmentDO1.getId(), 1);

		DepartmentDO departmentDO2 = new DepartmentDO();
		departmentDO2.setName("FooName222");
		departmentDO2.setDescription("FooDescription222");
		departmentDAO.insert(departmentDO2);
		assertEquals(departmentDO2.getId(), 2);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);

		DepartmentDO departmentDOX = (DepartmentDO) departmentDAO.loadById(1);
		assertTrue(compareDO(departmentDO1, departmentDOX));
		assertNotSame(departmentDO1, departmentDOX);

		DepartmentDO departmentDOY = (DepartmentDO) departmentDAO.loadById(2);
		assertTrue(compareDO(departmentDO2, departmentDOY));
		assertNotSame(departmentDO2, departmentDOY);

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testUpdateLoad() throws Exception {
		ConnectionBean connectionBean;
		DepartmentDAO departmentDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);
		departmentDAO.createTable();

		DepartmentDO departmentDO1 = new DepartmentDO();
		departmentDO1.setName("FooName111");
		departmentDO1.setDescription("FooDescription111");
		departmentDAO.insert(departmentDO1);
		assertEquals(departmentDO1.getId(), 1);

		DepartmentDO departmentDO2 = new DepartmentDO();
		departmentDO2.setName("FooName222");
		departmentDO2.setDescription("FooDescription222");
		departmentDAO.insert(departmentDO2);
		assertEquals(departmentDO2.getId(), 2);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD / UPDATE
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);

		DepartmentDO departmentDOX = (DepartmentDO) departmentDAO.loadById(1);
		departmentDOX.setName("FooNameXXX");
		departmentDOX.setDescription("FooDescriptionXXX");
		departmentDAO.update(departmentDOX); // Changes the 111

		DepartmentDO departmentDOY = (DepartmentDO) departmentDAO.loadById(2);
		departmentDOY.setName("FooNameYYY");
		departmentDOY.setDescription("FooDescriptionYYY");
		departmentDAO.update(departmentDOY); // Changes the 222

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);

		DepartmentDO departmentDOA = (DepartmentDO) departmentDAO.loadById(1);
		assertTrue(compareDO(departmentDOX, departmentDOA));
		assertNotSame(departmentDOX, departmentDOA);

		DepartmentDO departmentDOB = (DepartmentDO) departmentDAO.loadById(2);
		assertTrue(compareDO(departmentDOY, departmentDOB));
		assertNotSame(departmentDOY, departmentDOB);

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testDeleteLoad() throws Exception {
		ConnectionBean connectionBean;
		DepartmentDAO departmentDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);
		departmentDAO.createTable();

		DepartmentDO departmentDO1 = new DepartmentDO();
		departmentDO1.setName("FooName111");
		departmentDO1.setDescription("FooDescription111");
		departmentDAO.insert(departmentDO1);
		assertEquals(departmentDO1.getId(), 1);

		DepartmentDO departmentDO2 = new DepartmentDO();
		departmentDO2.setName("FooName222");
		departmentDO2.setDescription("FooDescription222");
		departmentDAO.insert(departmentDO2);
		assertEquals(departmentDO2.getId(), 2);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD / DELETE
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);

		DepartmentDO departmentDOX = (DepartmentDO) departmentDAO.loadById(1);
		departmentDAO.delete(departmentDOX);

		DepartmentDO departmentDOY = (DepartmentDO) departmentDAO.loadById(2);
		departmentDAO.delete(departmentDOY);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);

		DepartmentDO departmentDOA = (DepartmentDO) departmentDAO.loadById(1);
		assertNull(departmentDOA);

		DepartmentDO departmentDOB = (DepartmentDO) departmentDAO.loadById(2);
		assertNull(departmentDOB);

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testCacheLoad() throws Exception {
		ConnectionBean connectionBean;
		DepartmentDAO departmentDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);
		departmentDAO.createTable();

		DepartmentDO departmentDO1 = new DepartmentDO();
		departmentDO1.setName("FooName111");
		departmentDO1.setDescription("FooDescription111");
		departmentDAO.insert(departmentDO1);
		assertEquals(departmentDO1.getId(), 1);

		DepartmentDO departmentDO2 = new DepartmentDO();
		departmentDO2.setName("FooName222");
		departmentDO2.setDescription("FooDescription222");
		departmentDAO.insert(departmentDO2);
		assertEquals(departmentDO2.getId(), 2);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD / RE-LOAD
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);

		DepartmentDO departmentDOX = (DepartmentDO) departmentDAO.loadById(1);
		DepartmentDO departmentDOA = (DepartmentDO) departmentDAO.loadById(1);
		assertTrue(compareDO(departmentDOX, departmentDOA));
		assertSame(departmentDOX, departmentDOA);

		DepartmentDO departmentDOY = (DepartmentDO) departmentDAO.loadById(2);
		DepartmentDO departmentDOB = (DepartmentDO) departmentDAO.loadById(2);
		assertTrue(compareDO(departmentDOY, departmentDOB));
		assertSame(departmentDOY, departmentDOB);

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testDeleteReInsert() throws Exception {
		ConnectionBean connectionBean;
		DepartmentDAO departmentDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);
		departmentDAO.createTable();

		DepartmentDO departmentDO1 = new DepartmentDO();
		departmentDO1.setName("FooName");
		departmentDO1.setDescription("FooDescription");
		departmentDAO.insert(departmentDO1);
		assertEquals(departmentDO1.getId(), 1);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD / DELETE / RE-INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);

		DepartmentDO departmentDOX = (DepartmentDO) departmentDAO.loadById(1);
		departmentDAO.delete(departmentDOX);

		try {
			departmentDAO.insert(departmentDOX);
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
		DepartmentDAO departmentDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);
		departmentDAO.createTable();

		DepartmentDO departmentDO1 = new DepartmentDO();
		departmentDO1.setName("FooName");
		departmentDO1.setDescription("FooDescription");
		departmentDAO.insert(departmentDO1);
		assertEquals(departmentDO1.getId(), 1);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD / DELETE / RE-INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);

		DepartmentDO departmentDOX = (DepartmentDO) departmentDAO.loadById(1);
		departmentDAO.delete(departmentDOX);

		try {
			departmentDAO.update(departmentDOX);
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
		DepartmentDAO departmentDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);
		departmentDAO.createTable();

		DepartmentDO departmentDO1 = new DepartmentDO();
		departmentDO1.setName("FooName");
		departmentDO1.setDescription("FooDescription");
		departmentDAO.insert(departmentDO1);
		assertEquals(departmentDO1.getId(), 1);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// LOAD / DELETE / RE-DELETE
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);

		DepartmentDO departmentDOX = (DepartmentDO) departmentDAO.loadById(1);
		departmentDAO.delete(departmentDOX);

		try {
			departmentDAO.delete(departmentDOX);
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
		DepartmentDAO departmentDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);
		departmentDAO.createTable();

		DepartmentDO departmentDO1 = new DepartmentDO();
		departmentDO1.setName("FooName111");
		departmentDO1.setDescription("FooDescription111");

		DepartmentDO departmentDO2 = new DepartmentDO();
		departmentDO2.setName("FooName222");
		departmentDO2.setDescription("FooDescription222");

		// ----------------------------------------
		// UPDATE NON INSERTED
		// ----------------------------------------

		try {
			departmentDAO.update(departmentDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
		}

		// ----------------------------------------
		// DELETE NON INSERTED
		// ----------------------------------------

		try {
			departmentDAO.delete(departmentDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
		}

		// ----------------------------------------
		// INSERT TAMPERED
		// ----------------------------------------

		try {
			departmentDO1.setId(1); // TAMPERED ID
			departmentDAO.insert(departmentDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
			departmentDO1.setId(0); // UNTAMPER ID
		}

		// ----------------------------------------
		// UPDATE TAMPERED
		// ----------------------------------------

		try {
			departmentDO1.setId(1); // TAMPERED ID
			departmentDAO.update(departmentDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
			departmentDO1.setId(0); // UNTAMPER ID
		}

		// ----------------------------------------
		// DELETE TAMPERED
		// ----------------------------------------

		try {
			departmentDO1.setId(1); // TAMPERED ID
			departmentDAO.delete(departmentDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
			departmentDO1.setId(0); // UNTAMPER ID
		}

		// ----------------------------------------
		// DO INSERT
		// ----------------------------------------

		departmentDAO.insert(departmentDO1); // WORKS
		departmentDAO.insert(departmentDO2); // WORKS

		// ----------------------------------------
		// RE-INSERT TAMPERED
		// ----------------------------------------

		try {
			departmentDO1.setId(0); // TAMPERED ID
			departmentDAO.insert(departmentDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
			departmentDO1.setId(1); // UNTAMPER ID
		}

		// ----------------------------------------
		// RE-UPDATE TAMPERED
		// ----------------------------------------

		try {
			departmentDO1.setId(2); // TAMPERED ID
			departmentDAO.update(departmentDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
			departmentDO1.setId(1); // UNTAMPER ID
		}

		// ----------------------------------------
		// RE-DELETE TAMPERED
		// ----------------------------------------

		try {
			departmentDO1.setId(2); // TAMPERED ID
			departmentDAO.delete(departmentDO1);
			fail("Should raise an IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			// Exception (test OK)
			System.err.println(e.getClass() + " : " + e.getMessage());
			departmentDO1.setId(1); // UNTAMPER ID
		}

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testCount() throws Exception {
		ConnectionBean connectionBean;
		DepartmentDAO departmentDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);
		departmentDAO.createTable();

		DepartmentDO departmentDO1 = new DepartmentDO();
		departmentDO1.setName("FooName111");
		departmentDO1.setDescription("FooDescription111");
		departmentDAO.insert(departmentDO1);

		DepartmentDO departmentDO2 = new DepartmentDO();
		departmentDO2.setName("FooName222");
		departmentDO2.setDescription("FooDescription222");
		departmentDAO.insert(departmentDO2);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// COUNT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);

		assertEquals(2, departmentDAO.countAll());

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testListAll() throws Exception {
		ConnectionBean connectionBean;
		DepartmentDAO departmentDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);
		departmentDAO.createTable();

		DepartmentDO departmentDO1 = new DepartmentDO();
		departmentDO1.setName("FooName111");
		departmentDO1.setDescription("FooDescription111");
		departmentDAO.insert(departmentDO1);

		DepartmentDO departmentDO2 = new DepartmentDO();
		departmentDO2.setName("FooName111");
		departmentDO2.setDescription("FooDescription111");
		departmentDAO.insert(departmentDO2);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// COUNT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);

		List<DataObject> departmentList = departmentDAO.listAll();
		assertTrue(compareDO(departmentDO1, (DepartmentDO) departmentList
				.get(0)));
		assertTrue(compareDO(departmentDO2, (DepartmentDO) departmentList
				.get(1)));

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}

	// --------------------------------------------------------------------------------

	public void testListAllLimOff() throws Exception {
		ConnectionBean connectionBean;
		DepartmentDAO departmentDAO;

		// ----------------------------------------
		// INSERT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);
		departmentDAO.createTable();

		DepartmentDO departmentDO1 = new DepartmentDO();
		departmentDO1.setName("FooName111");
		departmentDO1.setDescription("FooDescription111");
		departmentDAO.insert(departmentDO1);

		DepartmentDO departmentDO2 = new DepartmentDO();
		departmentDO2.setName("FooName111");
		departmentDO2.setDescription("FooDescription111");
		departmentDAO.insert(departmentDO2);

		ConnectionFactory.closeConnection(connectionBean.getConnection());

		// ----------------------------------------
		// COUNT
		// ----------------------------------------

		connectionBean = ConnectionFactory.getConnectionBean();

		departmentDAO = (DepartmentDAO) FactoryDAO.getDAO( //
				DepartmentDAO.class, connectionBean);

		List<DataObject> departmentList;

		departmentList = departmentDAO.listAll(1, 0);
		assertEquals(1, departmentList.size());
		assertTrue(compareDO(departmentDO1, (DepartmentDO) departmentList
				.get(0)));

		departmentList = departmentDAO.listAll(1, 1);
		assertEquals(1, departmentList.size());
		assertTrue(compareDO(departmentDO2, (DepartmentDO) departmentList
				.get(0)));

		ConnectionFactory.closeConnection(connectionBean.getConnection());
	}
}
