package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.XeMay;

public class Xe_DAO {

	public Xe_DAO() {
	}
	
	public ArrayList<XeMay> getAll(){
		ArrayList<XeMay> list = new ArrayList<XeMay>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String sql = "SELECT * FROM xe";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String brand = rs.getString(2);
				String model = rs.getString(3);
				String type = rs.getString(4);
				int engCap = rs.getInt(5);
				String color = rs.getString(6);
				int year = rs.getInt(7);
				double giaNhap = rs.getDouble(8);
				double giaBan = rs.getDouble(9);
				int tonKho = rs.getInt(10);
				
				XeMay xe = new XeMay(id, brand, model, type, engCap, color, year, giaNhap, giaBan, tonKho );
				list.add(xe);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} return list;
	}
	
}
