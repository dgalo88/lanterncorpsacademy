package dao.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	public static final String DEFAULT_CONFIG_FILE = "connection.properties";

	// --------------------------------------------------------------------------------

	private ConnectionFactory() {
		// Empty
	}

	// --------------------------------------------------------------------------------

	public static ConnectionBean getConnectionBean() //
			throws SQLException, ClassNotFoundException, IOException {

		return getConnectionBean(DEFAULT_CONFIG_FILE);
	}

	// --------------------------------------------------------------------------------

	public static ConnectionBean getConnectionBean(String configFile) //
			throws SQLException, ClassNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(ClassLoader.getSystemResourceAsStream(configFile));

		Class.forName(properties.getProperty("driver"));

		Connection connection = DriverManager.getConnection( //
				properties.getProperty("url"), //
				properties.getProperty("user"), //
				properties.getProperty("pass"));

		// ---------------------------------------------------------------------
		// En JDBC se hace un 'BEGIN' automático cuando se establece la conexión
		// Auto-Commit = FALSE
		// ---------------------------------------------------------------------

		// if (connection.getAutoCommit()) {
		// connection.setAutoCommit(false);
		// }

		return new ConnectionBean(new DtaSession(), connection);
	}

	// --------------------------------------------------------------------------------

	public static void closeConnection(Connection connection)
			throws SQLException {
		connection.close();
	}
}
