package source_codes;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable {
	private String maNv, ho, ten, gioiTinh;
	private int tuoi;
	private double luong;

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String maNv, String ho, String ten, String gioiTinh, int tuoi, double luong) {
		super();
		this.maNv = maNv;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		this.tuoi = tuoi;
		this.luong = luong;
	}

	public String getMaNv() {
		return maNv;
	}

	public void setMaNv(String maNv) {
		this.maNv = maNv;
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

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNv, other.maNv);
	}

	@Override
	public String toString() {
		return "NhanVien [maNv=" + maNv + ", ho=" + ho + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", tuoi=" + tuoi
				+ ", luong=" + luong + "]";
	}

}
