package connectDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectDB {
	public static Connection con = null;
	private static ConnectDB instance = new ConnectDB();	
	public static ConnectDB getInstance() {
		return instance;
	}
	public void connect() throws SQLException {				
		/*
		 * String url = "jdbc:sqlserver://localhost:1433;databasename=cuahangxemay";
		 * String user = "sa"; String password = "11111111"; con =
		 * DriverManager.getConnection(url, user, password);
		 */
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=cuahangxemay", "sa", "11111111");
			System.out.println("Kết nối database thành công!");
	}	
	public void disconnect() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
}
