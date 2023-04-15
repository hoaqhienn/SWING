package entity;

import java.util.Objects;

public class ChiTietHopDong {
	private String id;
	private HopDong maHopDong;
	private XeMay maXeMay;
	private int soLuong;
	private double giamGia;
	private String hinhThucThanhToan;
	
	public ChiTietHopDong() {
		super();
	}

	public ChiTietHopDong(String id) {
		super();
		this.id = id;
	}

	public ChiTietHopDong(String id, HopDong maHopDong, XeMay maXeMay, int soLuong, double giamGia,
			String hinhThucThanhToan) {
		super();
		this.id = id;
		this.maHopDong = maHopDong;
		this.maXeMay = maXeMay;
		this.soLuong = soLuong;
		this.giamGia = giamGia;
		this.hinhThucThanhToan = hinhThucThanhToan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HopDong getMaHopDong() {
		return maHopDong;
	}

	public void setMaHopDong(HopDong maHopDong) {
		this.maHopDong = maHopDong;
	}

	public XeMay getMaXeMay() {
		return maXeMay;
	}

	public void setMaXeMay(XeMay maXeMay) {
		this.maXeMay = maXeMay;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}

	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHopDong other = (ChiTietHopDong) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ChiTietHopDong [id=" + id + ", maHopDong=" + maHopDong + ", maXeMay=" + maXeMay + ", soLuong=" + soLuong
				+ ", giamGia=" + giamGia + ", hinhThucThanhToan=" + hinhThucThanhToan + "]";
	}
	
	
}
