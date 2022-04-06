import java.awt.BorderLayout;

import javax.swing.*;

public class GUI extends JFrame {
	GUI(){
		setTitle("Quản lý sách");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		createGUI();
//		danhSachNhanVien = new QuanLyNhanVien();
//		database = new Database();
//		try {
//			loadData();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}
	public void createGUI() {
		JPanel pN;
		add(pN = new JPanel(), BorderLayout.NORTH);
		
		Box box = Box.createVerticalBox();
	}
	
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.setVisible(true);
	}
}
