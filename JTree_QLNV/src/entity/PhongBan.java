package entity;

import java.util.ArrayList;

public class PhongBan {
	private String maPhong, tenPhong;
	
	private ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();;

	public PhongBan(String maPhong, String tenPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.dsnv = dsnv;
	}
	
	public void themMoiNhanVien(String empCode, String lName, String fName, boolean gender, int age, long salary) {
		NhanVien nv = new NhanVien(empCode, fName, lName, gender, age, salary, this);
		dsnv.add(nv);
	}
	
	public ArrayList<NhanVien> getDsnv(){
		return dsnv;
	}

	@Override
	public String toString() {
		return tenPhong;
	}
	

}
