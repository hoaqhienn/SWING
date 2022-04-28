package dao;
import java.sql.*;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhongBan;

public class PhongBan_DAO {
	public ArrayList<PhongBan> gettalltbPhongBan() {
		ArrayList<PhongBan> dsphongban = new ArrayList<PhongBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select * from PhongBan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String maPB = rs.getString(1);
				String tenPB = rs.getString(2);
				PhongBan p = new PhongBan(maPB, tenPB);
				dsphongban.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsphongban;
	}
}
