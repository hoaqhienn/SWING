package OnTapGiuaKy;

import java.io.Serializable;

public class NhanVien implements Serializable {
	private String maNV, hoNv, tenNV, phongBan;
	private double luong;
	public NhanVien() {
		super();
	}
	public NhanVien(String maNV, String hoNv, String tenNV, String phongBan, double luong) {
		super();
		this.maNV = maNV;
		this.hoNv = hoNv;
		this.tenNV = tenNV;
		this.phongBan = phongBan;
		this.luong = luong;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoNv() {
		return hoNv;
	}
	public void setHoNv(String hoNv) {
		this.hoNv = hoNv;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	@Override
	public boolean equals(Object obj) {
		NhanVien nhanVien = (NhanVien)obj;
		return this.getMaNV().equalsIgnoreCase(nhanVien.getMaNV());
	}
}
