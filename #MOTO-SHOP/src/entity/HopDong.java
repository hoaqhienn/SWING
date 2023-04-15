package entity;

import java.util.Date;
import java.util.Objects;

public class HopDong {
	private String maHopDong;
	private Date ngayMua;
	private KhachHang maKhachHang;
	private NhanVien maNhanVien;
	private double tongThanhToan;
	
	public HopDong() {
		super();
	}

	public HopDong(String maHopDong) {
		super();
		this.maHopDong = maHopDong;
	}

	public HopDong(String maHopDong, Date ngayMua, KhachHang maKhachHang, NhanVien maNhanVien, double tongThanhToan) {
		super();
		this.maHopDong = maHopDong;
		this.ngayMua = ngayMua;
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
		this.tongThanhToan = tongThanhToan;
	}

	public String getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(String maHopDong) {
		this.maHopDong = maHopDong;
	}

	public Date getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}

	public KhachHang getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(KhachHang maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public NhanVien getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(NhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public double getTongThanhToan() {
		return tongThanhToan;
	}

	public void setTongThanhToan(double tongThanhToan) {
		this.tongThanhToan = tongThanhToan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maHopDong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HopDong other = (HopDong) obj;
		return Objects.equals(maHopDong, other.maHopDong);
	}

	@Override
	public String toString() {
		return "HopDong [maHopDong=" + maHopDong + ", ngayMua=" + ngayMua + ", maKhachHang=" + maKhachHang
				+ ", maNhanVien=" + maNhanVien + ", tongThanhToan=" + tongThanhToan + "]";
	}
	
	
	
	
}
