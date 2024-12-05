package commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {

	public static Connection getConnection() {
		try {
			final String url = "jdbc:mysql://localhost:3306/Bens";
			final String user = "marcosschlick";
			final String password = "0005";
			return DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}