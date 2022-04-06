package OnTapGiuaKy;

import java.io.Serializable;
import java.util.ArrayList;

public class QuanLyNhanVien implements Serializable {
	private ArrayList<NhanVien> danhSachNhanVien;

	public QuanLyNhanVien() {
		super();
		danhSachNhanVien = new ArrayList<>();
	}
	public boolean themNV(NhanVien nhanVien) {
		if (danhSachNhanVien.contains(nhanVien))
			return false;
		danhSachNhanVien.add(nhanVien);
		return true;
	}
	public boolean xoaNV(String maNV) {
		for (NhanVien nhanVien : danhSachNhanVien) {
			if (nhanVien.getMaNV().equalsIgnoreCase(maNV)) {
				danhSachNhanVien.remove(nhanVien);
				return true;
			}
		}
		return false;
	}
	public ArrayList<NhanVien> getDanhSachNhanVien() {
		return danhSachNhanVien;
	}
	public void setDanhSachNhanVien(ArrayList<NhanVien> danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
	}
}
