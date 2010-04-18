package dao.api;

import java.sql.SQLException;
import java.util.List;

import dao.connection.ConnectionBean;

public interface InterfaceDAO {

	public void init(ConnectionBean connectionBean);

	// --------------------------------------------------------------------------------

	public void createTable() throws SQLException;

	// --------------------------------------------------------------------------------

	public void insert(DataObject bean) throws SQLException;

	public void update(DataObject bean) throws SQLException;

	public void delete(DataObject bean) throws SQLException;

	// --------------------------------------------------------------------------------

	public DataObject loadById(int id) throws SQLException;

	// --------------------------------------------------------------------------------

	public List<DataObject> listAll(int lim, int off) throws SQLException;

	public List<DataObject> listAll() throws SQLException;

	public int countAll() throws SQLException;

	// --------------------------------------------------------------------------------

	public String getTableName();
}
