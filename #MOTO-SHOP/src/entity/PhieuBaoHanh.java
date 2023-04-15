package entity;

import java.util.Date;
import java.util.Objects;

public class PhieuBaoHanh {
	private String maphieu;
	private Date ngayLap;
	private KhachHang maKhachHang;
	private NhanVien maNhanVien;
	private String tenLinhKien;
	private String lyDoBaoHanh;
	private double giaTien;
	public PhieuBaoHanh() {
		super();
	}
	public PhieuBaoHanh(String maphieu) {
		super();
		this.maphieu = maphieu;
	}
	public PhieuBaoHanh(String maphieu, Date ngayLap, KhachHang maKhachHang, NhanVien maNhanVien, String tenLinhKien,
			String lyDoBaoHanh, double giaTien) {
		super();
		this.maphieu = maphieu;
		this.ngayLap = ngayLap;
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
		this.tenLinhKien = tenLinhKien;
		this.lyDoBaoHanh = lyDoBaoHanh;
		this.giaTien = giaTien;
	}
	public String getMaphieu() {
		return maphieu;
	}
	public void setMaphieu(String maphieu) {
		this.maphieu = maphieu;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
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
	public String getTenLinhKien() {
		return tenLinhKien;
	}
	public void setTenLinhKien(String tenLinhKien) {
		this.tenLinhKien = tenLinhKien;
	}
	public String getLyDoBaoHanh() {
		return lyDoBaoHanh;
	}
	public void setLyDoBaoHanh(String lyDoBaoHanh) {
		this.lyDoBaoHanh = lyDoBaoHanh;
	}
	public double getGiaTien() {
		return giaTien;
	}
	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maphieu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuBaoHanh other = (PhieuBaoHanh) obj;
		return Objects.equals(maphieu, other.maphieu);
	}
	@Override
	public String toString() {
		return "PhieuBaoHanh [maphieu=" + maphieu + ", ngayLap=" + ngayLap + ", maKhachHang=" + maKhachHang
				+ ", maNhanVien=" + maNhanVien + ", tenLinhKien=" + tenLinhKien + ", lyDoBaoHanh=" + lyDoBaoHanh
				+ ", giaTien=" + giaTien + "]";
	}
	
	
}
