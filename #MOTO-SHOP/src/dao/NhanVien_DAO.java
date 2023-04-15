package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.*;

public class NhanVien_DAO {
	public NhanVien_DAO() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<NhanVien> getAll() {
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			
			String sql = "SELECT * FROM NhanVien";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maNhanVien = rs.getString(1);
				String tenNhanVien = rs.getString(2);
				String diaChi = rs.getString(3);
				String soDienThoai = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				Boolean gioiTinh = rs.getBoolean(6);
				String chucVu = rs.getString(7);
				String trinhDo = rs.getString(8);
				Double luong = rs.getDouble(9);
				Date ngayVaoLam = rs.getDate(10);
				
				
				NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, diaChi, soDienThoai, ngaySinh, gioiTinh, chucVu, trinhDo, luong, ngayVaoLam);
				list.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public NhanVien getNhanVienTheoMa(String maNV) {
		NhanVien nhanVien = null;
		ArrayList<NhanVien> list = new ArrayList<NhanVien>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			
			String sql = "SELECT * FROM NhanVien WHERE maNhanVien = ?";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maNhanVien = rs.getString(1);
				String tenNhanVien = rs.getString(2);
				String diaChi = rs.getString(3);
				String soDienThoai = rs.getString(4);
				Date ngaySinh = rs.getDate(5);
				Boolean gioiTinh = rs.getBoolean(6);
				String chucVu = rs.getString(7);
				String trinhDo = rs.getString(8);
				Double luong = rs.getDouble(9);
				Date ngayVaoLam = rs.getDate(10);
				
				
				NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, diaChi, soDienThoai, ngaySinh, gioiTinh, chucVu, trinhDo, luong, ngayVaoLam);
				list.add(nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (list.isEmpty())
			return null;
		return list.get(0);
	}
	
	
	public void themNhanVien(NhanVien nhanVien) throws Exception {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement statement = null;
		
		try {
			String sql = "INSERT INTO NhanVien VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, nhanVien.getMaNhanVien());
			statement.setString(2, nhanVien.getTenNhanVien());
			statement.setString(3, nhanVien.getDiaChi());
			statement.setString(4, nhanVien.getSoDienThoai());
			statement.setDate(5, (java.sql.Date) nhanVien.getNgaySinh());
			statement.setBoolean(6, nhanVien.isGioiTinh());
			statement.setString(7, nhanVien.getChucVu());
			statement.setString(8, nhanVien.getTrinhDo());
			statement.setDouble(9, nhanVien.getLuong());
			statement.setDate(5, (java.sql.Date) nhanVien.getNgayVaoLam());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			statement.close();
		}
	}
}
