public class Demo {
	public static void main(String[] args) throws Exception {
		DanhSachSach dao = new DanhSachSach();
		new GUI(dao).setVisible(true);
	}
}