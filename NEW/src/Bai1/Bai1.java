package Bai1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class Bai1 extends JFrame {
	
	public Bai1() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void Bai1(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		
		JLabel jLabel_1 = new JLabel("Số 1: ");		
		JLabel jLabel_2 = new JLabel("Số 2: ");
		JLabel jLabel_answer = new JLabel("Kết quả: ");
		
		JTextField jTF1 = new JTextField(50);
		JTextField jTF2 = new JTextField(50);
		JTextField jTF3 = new JTextField(50);
		jTF3.setEditable(false);
		
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(3, 2, 10, 10));
		jp.add(jLabel_1);
		jp.add(jTF1);
		jp.add(jLabel_2);
		jp.add(jTF2);
		jp.add(jLabel_answer);
		jp.add(jTF3);
		
		JButton jb_plus = new JButton("+");
		JButton jb_minus = new JButton("-");
		JButton jb_exit = new JButton("Thoat");
		JPanel jPB = new JPanel();
		jPB.setLayout(new GridLayout(1, 3));
		jPB.add(jb_plus);
		jPB.add(jb_minus);
		jPB.add(jb_exit);

		
		this.setLayout(new BorderLayout(10, 10));
		this.add(jp, BorderLayout.CENTER);
		this.add(jPB, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Bai1 a = new Bai1();
		a.Bai1("Bai1", 600, 400);
	}
}
