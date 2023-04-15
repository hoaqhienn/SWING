package entity;

import java.util.Objects;

public class XeMay {
	private String maXeMay, brand, model, mausac, soKhung, soSuon, note;
	private int capacity, namSX; 
	private Double giaNhap, giaBan;
	private boolean trangThai;
	
	public XeMay() {
		super();
	}

	public XeMay(String maXeMay) {
		super();
		this.maXeMay = maXeMay;
	}

	public XeMay(String maXeMay, String brand, String model, int capacity, int namSX, String mausac, String soKhung, String soSuon, Double giaNhap, Double giaBan, boolean trangThai) {
		super();
		this.maXeMay = maXeMay;
		this.brand = brand;
		this.model = model;
		this.mausac = mausac;
		this.soKhung = soKhung;
		this.soSuon = soSuon;
		this.capacity = capacity;
		this.namSX = namSX;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.trangThai = trangThai;
	}

	public String getMaXeMay() {
		return maXeMay;
	}

	public void setMaXeMay(String maXeMay) {
		this.maXeMay = maXeMay;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMausac() {
		return mausac;
	}

	public void setMausac(String mausac) {
		this.mausac = mausac;
	}

	public String getSoKhung() {
		return soKhung;
	}

	public void setSoKhung(String soKhung) {
		this.soKhung = soKhung;
	}

	public String getSoSuon() {
		return soSuon;
	}

	public void setSoSuon(String soSuon) {
		this.soSuon = soSuon;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNamSX() {
		return namSX;
	}

	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}

	public Double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(Double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public Double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(Double giaBan) {
		this.giaBan = giaBan;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, capacity, giaBan, giaNhap, maXeMay, mausac, model, namSX, note, soKhung, soSuon,
				trangThai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XeMay other = (XeMay) obj;
		return Objects.equals(brand, other.brand) && capacity == other.capacity && Objects.equals(giaBan, other.giaBan)
				&& Objects.equals(giaNhap, other.giaNhap) && Objects.equals(maXeMay, other.maXeMay)
				&& Objects.equals(mausac, other.mausac) && Objects.equals(model, other.model) && namSX == other.namSX
				&& Objects.equals(note, other.note) && Objects.equals(soKhung, other.soKhung)
				&& Objects.equals(soSuon, other.soSuon) && trangThai == other.trangThai;
	}

	@Override
	public String toString() {
		return "XeMay [maXeMay=" + maXeMay + ", brand=" + brand + ", model=" + model + ", mausac=" + mausac
				+ ", soKhung=" + soKhung + ", soSuon=" + soSuon + ", note=" + note + ", capacity=" + capacity
				+ ", namSX=" + namSX + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", trangThai=" + trangThai + "]";
	}
	
	
}
