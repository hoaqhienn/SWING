package tuan2.bai13;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachNhanVien implements Serializable{
	private ArrayList<NhanVien> list;
	
	public DanhSachNhanVien() {
		list = new ArrayList<NhanVien>();
	}
	public boolean themNhanVien(NhanVien nv) {
		if(list.contains(nv))
			return false;
		list.add(nv);
		return true;
	}
	
	public boolean xoaNhanVien(int maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(list.contains(nv)) {
			list.remove(nv);
			return true;
		}
		return false;
	}
	
	public NhanVien getNhanVien(int i) {
		if (i>=0 && i<list.size())
			return list.get(i);
		return null;
	}
	public ArrayList<NhanVien> getList(){
		return list;
	}
	public int tong() {
		return list.size();
	}
}
