import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	public static Connection con = null;
	private static Database instance = new Database();
	public static Database getInstance() {
		return instance;
	}
	
	public void connect() {
		String url = "jdbc:sqlserver://localhost:1433;databasename=qlsv";
						
		String user = "sa";
		String pwd = "11111111";
		try {
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
}
