package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.ChiTietHopDong;
import entity.HopDong;
import entity.XeMay;

public class ChiTietHopDong_DAO {
	public ChiTietHopDong_DAO() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<ChiTietHopDong> getAll(){
		ArrayList<ChiTietHopDong> list = new ArrayList<ChiTietHopDong>();

		try {
			Connection con = ConnectDB.getInstance().getConnection();
			
			String sql = "SELECT * FROM ChiTietHopDong";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String id = rs.getString(1);
				HopDong maHopDong = new HopDong(rs.getString(2));
				XeMay maXeMay = new XeMay(rs.getString(3));
				int soLuong = rs.getInt(4);
				Double giamGia = rs.getDouble(5);
				String hinhThucThanhToan = rs.getString(6);
			
				ChiTietHopDong cthp = new ChiTietHopDong(id, maHopDong, maXeMay, soLuong, soLuong, hinhThucThanhToan);
				list.add(cthp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
