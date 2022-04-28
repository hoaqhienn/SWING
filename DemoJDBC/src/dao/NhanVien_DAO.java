package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.PhongBan;

public class NhanVien_DAO {
	public NhanVien_DAO() {
		
	}
	public ArrayList<NhanVien> gettalltbNhanVien() {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance()	;
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select * from nhanvien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String maNV = rs.getString(1);
				String hoNV = rs.getString(2);
				String tenNV = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				PhongBan pBan = new PhongBan(rs.getString(6));
				Float luong = rs.getFloat(7);
				
				NhanVien nv = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, luong, pBan);
				dsnv.add(nv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	public ArrayList<NhanVien> getNhanVienTheoMaNV(int id) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from nhanvien where manv = ?";
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String maNV = rs.getString(1);
				String hoNV = rs.getString(2);
				String tenNV = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				float luong = rs.getFloat(6);
				PhongBan pBan = new PhongBan(rs.getString(7));
				NhanVien nv = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, luong, pBan);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsnv;
		
	}
	public ArrayList<NhanVien> getNhanVienTheoPhongBan(int idpb) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from nhanvien where maPhong = ?";
			statement.setInt(1, idpb);
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String maNV = rs.getString(1);
				String hoNV = rs.getString(2);
				String tenNV = rs.getString(3);
				int tuoi = rs.getInt(4);
				boolean phai = rs.getBoolean(5);
				float luong = rs.getFloat(6);
				PhongBan pBan = new PhongBan(rs.getString(7));
				NhanVien nv = new NhanVien(maNV, hoNV, tenNV, tuoi, phai, luong, pBan);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsnv;
	}
	public boolean create(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + "NhanVien value(?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getHoNV());
			stmt.setString(3, nv.getTenNV());
			stmt.setInt(4, nv.getTuoi());
			stmt.setBoolean(5, nv.isPhai());
			stmt.setString(6, nv.getPhong().getMaPhongBan());
			stmt.setFloat(7, (float) nv.getLuong());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	public boolean update(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhanVien set hoNV=?, tenNV=?" + "tuoiNV=?, phai=?, luong=?, phongban=?" + "where maNV=?");
//			stmt.setInt(1, nv.getMaNV());
			stmt.setString(1, nv.getHoNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setInt(3, nv.getTuoi());
			stmt.setBoolean(4, nv.isPhai());
			stmt.setDouble(5, nv.getLuong());
			stmt.setString(6, nv.getPhong().getMaPhongBan());
			
			stmt.setString(7, nv.getMaNV());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}

}
