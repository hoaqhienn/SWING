package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;

public class Khachhang_DAO {
	public Khachhang_DAO() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<KhachHang> getAll(){
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();

		try {
			Connection con = ConnectDB.getInstance().getConnection();
			
			String sql = "SELECT * FROM KhachHang";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maKhachHang = rs.getString(1);
				String tenKhachHang = rs.getString(2);
				int soCMT = rs.getInt(3);
				String diaChi = rs.getString(4);
				String soDienThoai = rs.getString(5);
				String email = rs.getString(6);
			
				KhachHang khach = new KhachHang(maKhachHang, tenKhachHang, soCMT, diaChi, soDienThoai, email);
				list.add(khach);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
