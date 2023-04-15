package tuan2.bai13;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable {
	private int maNV, tuoi;
	private String ho, ten, phong;
	private boolean phai;
	String getPhong() {
		return phong;
	}
	public void setPhong(String phong) {
		this.phong = phong;
	}
	private double tien;
	public NhanVien(int maNV, String ho, String ten, boolean phai, int tuoi, String phong, double tien) {
		super();
		this.maNV = maNV;
		this.tuoi = tuoi;
		this.ho = ho;
		this.ten = ten;
		this.phong = phong;
		this.phai = phai;
		this.tien = tien;
	}
	public NhanVien(int maNV) {
		this(maNV,"","",true,0,"",0.0);
	}
	public NhanVien() {
		super();
	}
	public int getMaNV() {
		return maNV;
	}
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
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
	public boolean isPhai() {
		return phai;
	}
	public void setPhai(boolean phai) {
		this.phai = phai;
	}
	public double getTien() {
		return tien;
	}
	public void setTien(double tien) {
		this.tien = tien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ho, maNV, phai, phong, ten, tien, tuoi);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(ho, other.ho) && maNV == other.maNV && phai == other.phai
				&& Objects.equals(phong, other.phong) && Objects.equals(ten, other.ten)
				&& Double.doubleToLongBits(tien) == Double.doubleToLongBits(other.tien) && tuoi == other.tuoi;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tuoi=" + tuoi + ", ho=" + ho + ", ten=" + ten + ", phong=" + phong
				+ ", phai=" + phai + ", tien=" + tien + "]";
	}
	
}
