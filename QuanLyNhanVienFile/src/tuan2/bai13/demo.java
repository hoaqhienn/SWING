package tuan2.bai13;

public class demo {
	public static void main(String[] args) throws Exception {
		DanhSachNhanVien dao = new DanhSachNhanVien();
		new frmNhanVien(dao).setVisible(true);
	}
}
