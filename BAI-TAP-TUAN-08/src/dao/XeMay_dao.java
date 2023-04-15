package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.*;

public class XeMay_dao {
	
	public XeMay_dao() {
		
	}
	public ArrayList<XeMay> getAllLopHoc() {
		ArrayList<XeMay> ds = new ArrayList<XeMay>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select * from xe";
			Statement statenent = con.createStatement();
			ResultSet rs = statenent.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String brand = rs.getString(2);
				String model = rs.getString(3);
				String type = rs.getString(4);
				int ec = rs.getInt(5);
				String color = rs.getString(6);
				int year = rs.getInt(7);
				Double giaNhap = rs.getDouble(8);
				Double giaBan = rs.getDouble(9);
				int tonKho = rs.getInt(10);
				
				XeMay xe = new XeMay(id, brand, model, type, ec, color, year, giaNhap, giaBan, tonKho);
				ds.add(xe);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public boolean create(XeMay a) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into xe values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, a.getId());
			stmt.setString(2, a.getBrand());
			stmt.setString(3, a.getModel());
			stmt.setString(4, a.getType());
			stmt.setInt(5, a.getEngCap());
			stmt.setString(6, a.getColor());
			stmt.setInt(7, a.getYear());
			stmt.setDouble(8, a.getGiaNhap());
			stmt.setDouble(9, a.getGiaBan());
			stmt.setInt(10, a.getSlTon());
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
