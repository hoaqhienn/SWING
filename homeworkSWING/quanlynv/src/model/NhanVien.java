package model;

import java.io.Serializable;

public class NhanVien implements Serializable {
	private String maNhanVien, ho, ten;
	private int tuoi;
	private double luong;
	private boolean gioiTinh;

	public NhanVien() {
		
	}

	public NhanVien(String maNhanVien, String ho, String ten, int tuoi, double luong, boolean gioiTinh) {
		super();
		this.maNhanVien = maNhanVien;
		this.ho = ho;
		this.ten = ten;
		this.tuoi = tuoi;
		this.luong = luong;
		this.gioiTinh = gioiTinh;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", ho=" + ho + ", ten=" + ten + ", tuoi=" + tuoi + ", luong="
				+ luong + ", gioiTinh=" + gioiTinh + "]";
	}
	
	
}
