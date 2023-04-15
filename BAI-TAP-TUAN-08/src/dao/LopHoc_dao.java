package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.*;

public class LopHoc_dao {
	
	public LopHoc_dao() {
		
	}
	public ArrayList<LopHoc> getAllLopHoc() {
		ArrayList<LopHoc> dslh = new ArrayList<LopHoc>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select * from LopHoc";
			Statement statenent = con.createStatement();
			ResultSet rs = statenent.executeQuery(sql);
			
			while (rs.next()) {
				String maLop = rs.getString(1);
				String tenLop = rs.getString(2);
				String gvcn = rs.getString(3);
				LopHoc lop = new LopHoc(maLop, tenLop, gvcn);
				dslh.add(lop);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dslh;
	}
	
	public boolean create(LopHoc a) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into LopHoc values(?, ?, ?)");
			stmt.setString(1, a.getMaLop());
			stmt.setString(2, a.getTenLop());
			stmt.setString(3, a.getgVCN());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
}
