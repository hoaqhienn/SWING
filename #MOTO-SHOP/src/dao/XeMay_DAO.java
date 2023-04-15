package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.XeMay;

public class XeMay_DAO {
	public XeMay_DAO() {
	}
	public ArrayList<XeMay> getAll() {
		ArrayList<XeMay> list = new ArrayList<XeMay>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			
			String sql = "SELECT * FROM XeMay";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maXeMay = rs.getString(1);
				String brand = rs.getString(2);
				String model = rs.getString(3);
				int capacity = rs.getInt(4);
				int namSX = rs.getInt(5);
				String mauSac = rs.getString(6);
				String soKhung = rs.getString(7);
				String soSuon = rs.getString(8);
				Double giaNhap = rs.getDouble(9);
				Double giaBan = rs.getDouble(10);
				boolean trangThai = rs.getBoolean(11);
				
				XeMay xe = new XeMay(maXeMay, brand, model, capacity, namSX, mauSac, soKhung, soSuon, giaNhap, giaBan, trangThai);
				list.add(xe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
