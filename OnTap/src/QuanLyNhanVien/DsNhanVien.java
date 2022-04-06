package QuanLyNhanVien;

import java.io.Serializable;
import java.util.ArrayList;

public class DsNhanVien implements Serializable{
	private ArrayList<NhanVien> lnv;
	
	public DsNhanVien() {
		lnv = new ArrayList<>();
	}
	//add
	public boolean addNV(NhanVien nv) {
		for(int i=0;i<lnv.size();i++)
			if(lnv.get(i).getMaNV().equalsIgnoreCase(nv.getMaNV())) {
				return false;
			}
		lnv.add(nv);
		return true;
	}
	
	
	public boolean removeNV(int index) {
		if(index >= 0 && index <= lnv.size()-1) {
			lnv.remove(index);
			return true;
		}
		
		else {
			return false;
		}
	}
	public NhanVien timKiem(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(lnv.contains(nv))
			return lnv.get(lnv.indexOf(nv));
		return null;
	}
	public ArrayList<NhanVien> getls() {
		return lnv;
	}
}
