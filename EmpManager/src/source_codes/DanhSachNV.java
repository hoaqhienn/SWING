package source_codes;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;

public class DanhSachNV implements Serializable {
	private ArrayList<NhanVien> list;

	public DanhSachNV() {
		super();
		list = new ArrayList<NhanVien>();
	}

	public boolean addNV(NhanVien nv) {
		if (list.contains(nv))
			return false;
		list.add(nv);
		return true;
	}

	public ArrayList<NhanVien> getLs() {
		return list;
	}

	public int soNV() {
		return list.size();
	}

	public boolean deleteVT(int index) {
		if (index >= 0 && index <= list.size() - 1) {
			list.remove(index);
			return true;
		}
		return false;
	}

	public boolean update(String maNV, String ho, String ten, String gioiTinh, int tuoi, double luong) {
		NhanVien nv = new NhanVien(maNV, ho, ten, gioiTinh, tuoi, luong);
		if (list.contains(nv)) {
			nv.setMaNv(maNV);
			nv.setHo(ho);
			nv.setTen(ten);
			nv.setGioiTinh(gioiTinh);
			nv.setTuoi(tuoi);
			nv.setLuong(luong);
			return true;
		}
		return false;
	}

	public boolean timKiem(String maNV) {
		for (NhanVien nv : list) {
			if (nv.getMaNv().compareTo(maNV) == 0)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "DanhSachNV [list=" + list + "]";
	}

}
