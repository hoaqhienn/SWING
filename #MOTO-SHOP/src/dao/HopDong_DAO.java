package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.HopDong;
import entity.KhachHang;
import entity.NhanVien;

public class HopDong_DAO {
	public HopDong_DAO() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<HopDong> getAll(){
		ArrayList<HopDong> list = new ArrayList<HopDong>();

		try {
			Connection con = ConnectDB.getInstance().getConnection();
			
			String sql = "SELECT * FROM HopDong";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maHopDong = rs.getString(1);
				Date ngayMua = rs.getDate(2);
				KhachHang maKhachHang = new KhachHang(rs.getString(3));
				NhanVien maNhanVien = new NhanVien(rs.getString(4));
				Double tongHoaDon = rs.getDouble(5);
			
				HopDong hopDong = new HopDong(maHopDong, ngayMua, maKhachHang, maNhanVien, tongHoaDon);
				list.add(hopDong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
