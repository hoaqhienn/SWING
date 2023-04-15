package entity;

import java.util.Date;
import java.util.Objects;

public class PhieuTraGop {
	private String maPhieu;
	private HopDong maHopDong;
	private Date ngayLap;
	private Date hanThanhToan;
	private KhachHang maKhachHang;
	private NhanVien maNhanVien;
	private double giaTien;
	
	public PhieuTraGop() {
		super();
	}

	public PhieuTraGop(String maPhieu) {
		super();
		this.maPhieu = maPhieu;
	}

	public PhieuTraGop(String maPhieu, HopDong maHopDong, Date ngayLap, Date hanThanhToan, KhachHang maKhachHang,
			NhanVien maNhanVien, double giaTien) {
		super();
		this.maPhieu = maPhieu;
		this.maHopDong = maHopDong;
		this.ngayLap = ngayLap;
		this.hanThanhToan = hanThanhToan;
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
		this.giaTien = giaTien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhieu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuTraGop other = (PhieuTraGop) obj;
		return Objects.equals(maPhieu, other.maPhieu);
	}

	@Override
	public String toString() {
		return "PhieuTraGop [maPhieu=" + maPhieu + ", maHopDong=" + maHopDong + ", ngayLap=" + ngayLap
				+ ", hanThanhToan=" + hanThanhToan + ", maKhachHang=" + maKhachHang + ", maNhanVien=" + maNhanVien
				+ ", giaTien=" + giaTien + "]";
	}
	
	
}
