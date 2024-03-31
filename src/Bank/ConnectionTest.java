package Bank;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
	public Connection getCon() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();

		}
		return con;
	}

}
