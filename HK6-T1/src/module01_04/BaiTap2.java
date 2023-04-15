package module01_04;

import javax.swing.JDialog;
public class BaiTap2 extends JDialog{
public BaiTap2() {
	setTitle("Demo JDialog"); //Tiêu đề của hộp thoại JDialog
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); //Đóng hộp thoại
	setSize(300, 200);
	setResizable(false);
	//Các thuộc tính khác
	}
	public static void main(String[] args) {
		new BaiTap2().setVisible(true);
	}
}
