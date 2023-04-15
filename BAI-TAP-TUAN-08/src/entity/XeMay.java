package entity;

import java.util.Objects;

public class XeMay {
	private int id, year, slTon, engCap;
	private String brand, model, type, color;
	private double giaNhap, giaBan;
	
	public XeMay() {
		super();
	}

	public XeMay(int id) {
		super();
		this.id = id;
	}

	public XeMay(int id, String brand, String model, String type, int engCap, String color, int year, 
			double giaNhap, double giaBan, int slTon) {
		super();
		this.id = id;
		this.year = year;
		this.slTon = slTon;
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.engCap = engCap;
		this.color = color;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSlTon() {
		return slTon;
	}

	public void setSlTon(int slTon) {
		this.slTon = slTon;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getEngCap() {
		return engCap;
	}

	public void setEngCap(int engCap) {
		this.engCap = engCap;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, color, engCap, giaBan, giaNhap, id, model, slTon, type, year);
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
		return Objects.equals(brand, other.brand) && Objects.equals(color, other.color)
				&& Objects.equals(engCap, other.engCap)
				&& Double.doubleToLongBits(giaBan) == Double.doubleToLongBits(other.giaBan)
				&& Double.doubleToLongBits(giaNhap) == Double.doubleToLongBits(other.giaNhap) && id == other.id
				&& Objects.equals(model, other.model) && slTon == other.slTon && Objects.equals(type, other.type)
				&& year == other.year;
	}

	@Override
	public String toString() {
		return "XeMay [id=" + id + ", year=" + year + ", slTon=" + slTon + ", brand=" + brand + ", model=" + model
				+ ", type=" + type + ", engCap=" + engCap + ", color=" + color + ", giaNhap=" + giaNhap + ", giaBan="
				+ giaBan + "]";
	}
	
	
	
	
}
