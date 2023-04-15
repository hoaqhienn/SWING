import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachSach implements Serializable{
	private ArrayList<Sach> list;
	
	public DanhSachSach() {
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
	
	public Sach timKiem(String maSach) {
		Sach sach = new Sach(maSach);
		if(list.contains(sach))
			return list.get(list.indexOf(sach));
		return null;
	}
	
	public Sach getSach(int i) {
		if(i >= 0 && i < list.size())
			return list.get(i);
		return null;
	}
	
	public boolean suaSach(String maOld, Sach sachNew) {
		Sach sachOld = new Sach(maOld);
		
		if(list.contains(sachOld)) {
			System.out.print("a");
			sachOld = list.get(list.indexOf(sachOld));
			sachOld.setTuaSach(sachNew.getTuaSach());
			sachOld.setTacGia(sachNew.getTacGia());
			sachOld.setNamXB(sachNew.getNamXB());
			sachOld.setNhaXB(sachNew.getNhaXB());
			sachOld.setSoTrang(sachNew.getSoTrang());
			sachOld.setDonGia(sachNew.getDonGia());
			sachOld.setISBN(sachNew.getISBN());
			
			return true;
		}
		return false;
	}
	
	public ArrayList<Sach> getList(){
		return list;
	}
	
	public int tong() {
		return list.size();
	}
}
