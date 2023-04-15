package resource;

import java.io.Serializable;
import java.util.ArrayList;

public class ListSach implements Serializable{
	private ArrayList<Sach> list;

	public ListSach() {
		list = new ArrayList<Sach>();
	}
	
	public boolean themSach(Sach sach) {
		if(list.contains(sach))
			return false;
		list.add(sach);
		return true;
	}
	
	public boolean xoaSach(String maSach) {
		Sach sach = new Sach(maSach);
		if(list.contains(sach)) {
			list.remove(sach);
			return true;
		}
		return false;
	}
	
	public Sach getSach(int i) {
		if (i>0 && i<list.size())
			return list.get(i);
		return null;
	}
	
	public ArrayList<Sach> getList() {
		return list;
	}
	
	public int tong() {
		return list.size();
	}
	
}
