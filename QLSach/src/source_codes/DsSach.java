package source_codes;

import java.util.ArrayList;

public class DsSach {
	private ArrayList<Sach> listSach;

	public DsSach() {
		super();
		listSach = new ArrayList<Sach>();
	}

	public boolean addBook(Sach o) {
		if (listSach.contains(o)) {
			return false;
		}
		listSach.add(o);
		return true;
	}

	public ArrayList<Sach> getLs() {
		return listSach;
	}

	public int soSach() {
		return listSach.size();
	}

	public boolean delIndex(int index) {
		if (index >= 0 && index <= listSach.size() - 1) {
			listSach.remove(index);
			return true;
		}
		return false;
	}
	
	public boolean update(String ma, String ten, String TacGia, int namXb, String nhaXB, int soTrang, double gia, String isbn) {
		Sach o = new Sach(ma, ten, TacGia, namXb, nhaXB, soTrang, gia, isbn);
		if(listSach.contains(o)) {
			o.setMaSach(ma);
			o.setTenSach(ten);
			o.setTacGia(TacGia);
			o.setiSBN(isbn);
			o.setNamXb(namXb);
			o.setNhaXb(nhaXB);
			o.setSoTrang(soTrang);
			o.setGia(gia);
			return true;
		}
		return false;
	}
	
	public boolean searchBook(String ma) {
		Sach o = new Sach(ma);
		if(listSach.contains(o)) {
			return true;
		}
		return false;
	}
}
